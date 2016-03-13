package taskman.handyapps.com.datalayer;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

/**
 * Created by Kesh on 3/12/2016.
 */
public enum NotificationTypesEnum {

    REMINDER("REMINDER: Next Task to be completed is  ? "),
    DEADLINE_AHEAD("DEADLINE AHEAD: Task ? needs to be taken care of in ? days"),
    DEADLINE_MISSED("An Interim Task ? has missed deadline ? days ago. Update calendar"),
    DEADLINES_MISSED("Interim Tasks ? have missed deadlines ? days ago. Update calendar");

    private static final Map<NotificationTypesEnum, String> eMap = Collections.unmodifiableMap(initializeMap());
    private String message;

    private NotificationTypesEnum(String notification) {
        this.message = notification;
    }

    private static Map<NotificationTypesEnum, String> initializeMap()
    {
        Map<NotificationTypesEnum, String> emap = new EnumMap<NotificationTypesEnum, String>(NotificationTypesEnum.class);
        for(NotificationTypesEnum enumv : NotificationTypesEnum.values())
        {
            emap.put(enumv, enumv.message);
        }
        return emap;
    }

    public String getMessage(){
        return message;
    }

}
