package taskman.handyapps.com.datalayer;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

import taskman.handyapps.com.model.Goal;
import taskman.handyapps.com.model.NotificationType;
import taskman.handyapps.com.model.SeverityLevel;
import taskman.handyapps.com.model.SubDetail;

/**
 * Created by Kesh on 3/6/2016.
 */
public enum DbClassNameEnum {

    GOAL(Goal.class),
    NOTIFICATION_TYPE(NotificationType.class),
    SEVERITY_LEVEL(SeverityLevel.class),
    SUB_DETAIL(SubDetail.class);

    private static final Map<DbClassNameEnum, Class<?>> eMap = Collections.unmodifiableMap(initializeMap());
    private final Class<?> classType;

    private DbClassNameEnum(Class<?> classType)
    {
        this.classType = classType;
    }

    private static Map<DbClassNameEnum, Class<?>> initializeMap()
    {
        Map<DbClassNameEnum, Class<?>> emap = new EnumMap<DbClassNameEnum, Class<?>>(DbClassNameEnum.class);
        for(DbClassNameEnum enumval : DbClassNameEnum.values())
        {
            emap.put(enumval, enumval.classType);
        }
        return emap;
    }

    public static DbClassNameEnum getEnumByClassType(Class<?> classType)
    {
        for(Map.Entry<DbClassNameEnum, Class<?>> searchEnum : eMap.entrySet())
        {
            if(classType == searchEnum.getValue())
            {
                return searchEnum.getKey();
            }
        }
        return null;
    }

    public Class<?> getClassType()
    {
        return classType;
    }

}
