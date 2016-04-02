package taskman.handyapps.com.taskman;

import java.util.Calendar;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

import static java.util.Calendar.APRIL;
import static java.util.Calendar.AUGUST;
import static java.util.Calendar.DECEMBER;
import static java.util.Calendar.FEBRUARY;
import static java.util.Calendar.JANUARY;
import static java.util.Calendar.JULY;
import static java.util.Calendar.JUNE;
import static java.util.Calendar.MARCH;
import static java.util.Calendar.NOVEMBER;
import static java.util.Calendar.OCTOBER;
import static java.util.Calendar.SEPTEMBER;

/**
 * Created by Kesh on 3/27/2016.
 */
public enum MonthEnum {

    JAN(JANUARY),
    FEB(FEBRUARY),
    MAR(MARCH),
    APR(APRIL),
    JUN(JUNE),
    JUL(JULY),
    AUG(AUGUST),
    SEPT(SEPTEMBER),
    OCT(OCTOBER),
    NOV(NOVEMBER),
    DEC(DECEMBER);

    private static final Map<MonthEnum, Integer> eMap = Collections.unmodifiableMap(initializeMap());
    private int monthnumber;

    private MonthEnum(int month) {
        this.monthnumber = month;
    }

    private static Map<MonthEnum, Integer> initializeMap()
    {
        Map<MonthEnum, Integer> emap = new EnumMap<MonthEnum, Integer>(MonthEnum.class);
        for(MonthEnum enumv : MonthEnum.values())
        {
            emap.put(enumv, enumv.monthnumber);
        }
        return emap;
    }

    public static String[] initializeDropDownArray()
    {
        String[] months = new String[MonthEnum.values().length];
        int i = 0;
        for(MonthEnum enumv : MonthEnum.values())
        {
            months[i] = enumv.toString();
            i = i+1;
        }
        return months;
    }

    public int getMonthNumber(){
        return monthnumber;
    }


}
