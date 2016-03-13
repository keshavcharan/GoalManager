package taskman.handyapps.com.datalayer;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;
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

    SQLiteDatabase db;
    private static Dao<Goal, Integer> goalDAO;
    private static Dao<NotificationType, Integer> notificationTypeDAO;
    private static Dao<SeverityLevel, Integer> severityLevelDao;
    private static Dao<SubDetail, Integer> subDetailDao;

    public DatabaseHelper(Context context)
    {
        super(context, DB_NAME, null, VERSION);
        db=super.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, Goal.class);
            TableUtils.createTable(connectionSource, NotificationType.class);
            TableUtils.createTable(connectionSource, SeverityLevel.class);
            TableUtils.createTable(connectionSource, SubDetail.class);

            SeverityLevel severityLevel;
            for (SeverityLevelsEnum severityLevelsEnum : SeverityLevelsEnum.values()) {
                    severityLevel = new SeverityLevel(severityLevelsEnum.toString());
                    ((Dao<SeverityLevel, Integer>) getDaoClass(SeverityLevel.class)).create(severityLevel);
            }

            NotificationType notificationType;
            for(NotificationTypesEnum notificationTypesEnum : NotificationTypesEnum.values()) {
                QueryBuilder<SeverityLevel, Integer> severityQueryBuilder = severityLevelDao.queryBuilder();
                switch (notificationTypesEnum){
                    case REMINDER:
                        severityLevel = severityQueryBuilder.where().eq("type", SeverityLevelsEnum.YELLOW.toString()).queryForFirst();
                        notificationType = new NotificationType(severityLevel, notificationTypesEnum.getMessage());
                        break;
                    case DEADLINE_AHEAD:
                        severityLevel = severityQueryBuilder.where().eq("type", SeverityLevelsEnum.ORANGE.toString()).queryForFirst();
                        notificationType = new NotificationType(severityLevel, notificationTypesEnum.getMessage());
                        break;
                    case DEADLINE_MISSED:
                        severityLevel = severityQueryBuilder.where().eq("type", SeverityLevelsEnum.LIGHT_RED.toString()).queryForFirst();
                        notificationType = new NotificationType(severityLevel, notificationTypesEnum.getMessage());
                        break;
                    case DEADLINES_MISSED:
                        severityLevel = severityQueryBuilder.where().eq("type", SeverityLevelsEnum.DARK_RED.toString()).queryForFirst();
                        notificationType = new NotificationType(severityLevel, notificationTypesEnum.getMessage());
                        break;
                    default:
                        severityLevel = severityQueryBuilder.where().eq("type", SeverityLevelsEnum.ORANGE.toString()).queryForFirst();
                        notificationType = new NotificationType(severityLevel, notificationTypesEnum.getMessage());
                        break;
                }

                ((Dao<NotificationType, Integer>) getDaoClass(NotificationType.class)).create(notificationType);
            }
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
