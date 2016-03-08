package taskman.handyapps.com.datalayer;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

import taskman.handyapps.com.model.Goal;
import taskman.handyapps.com.model.NotificationType;
import taskman.handyapps.com.model.SeverityLevel;
import taskman.handyapps.com.model.SubDetail;

/**
 * Created by Kesh on 3/5/2016.
 */
public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

    private static final String DB_NAME = "goalman.db";
    private static final int VERSION = 3;

    private static Dao<Goal, Integer> goalDAO;
    private static Dao<NotificationType, Integer> notificationTypeDAO;
    private static Dao<SeverityLevel, Integer> severityLevelDao;
    private static Dao<SubDetail, Integer> subDetailDao;

    public DatabaseHelper(Context context)
    {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, Goal.class);
            TableUtils.createTable(connectionSource, NotificationType.class);
            TableUtils.createTable(connectionSource, SeverityLevel.class);
            TableUtils.createTable(connectionSource, SubDetail.class);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            TableUtils.dropTable(connectionSource, Goal.class, true);
            TableUtils.dropTable(connectionSource, NotificationType.class, true);
            TableUtils.dropTable(connectionSource, SeverityLevel.class, true);
            TableUtils.dropTable(connectionSource, SubDetail.class, true);
            onCreate(database);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public Dao<?, ?> getDaoClass(Class<?> className)
    {
        DbClassNameEnum dbClassNameEnum = DbClassNameEnum.getEnumByClassType(className);
        Dao<?, ?> retval = null;
        try
        {
            switch (dbClassNameEnum)
            {
                case NOTIFICATION_TYPE:
                    if(notificationTypeDAO == null) {
                        notificationTypeDAO = getDao(NotificationType.class);
                    }
                    retval = notificationTypeDAO;
                    break;
                case GOAL:
                    if(goalDAO == null){
                        goalDAO = getDao(Goal.class);
                    }
                    retval = goalDAO;
                    break;
                case SEVERITY_LEVEL:
                    if(severityLevelDao == null){
                        severityLevelDao = getDao(SeverityLevel.class);
                    }
                    retval = severityLevelDao;
                    break;
                case SUB_DETAIL:
                    if(subDetailDao == null) {
                        subDetailDao = getDao(SubDetail.class);
                    }
                    retval = subDetailDao;
                    break;
                default:
                    break;

            }
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        return retval;
    }
}
