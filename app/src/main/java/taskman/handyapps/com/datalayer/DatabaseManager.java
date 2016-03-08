package taskman.handyapps.com.datalayer;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import taskman.handyapps.com.model.Goal;
import taskman.handyapps.com.model.NotificationType;
import taskman.handyapps.com.model.SeverityLevel;
import taskman.handyapps.com.model.SubDetail;

/**
 * Created by Kesh on 3/6/2016.
 */
public class DatabaseManager {
    private static DatabaseHelper databaseHelper = null;

    public static DatabaseHelper getDatabaseHelper(Context context) {
        if (databaseHelper == null)
            databaseHelper = new DatabaseHelper(context);

        return databaseHelper;
    }

    public static void releaseHelper() {
        if(databaseHelper != null) {
            OpenHelperManager.releaseHelper();
            databaseHelper = null;
        }
    }
}
