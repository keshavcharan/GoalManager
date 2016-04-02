package taskman.handyapps.com.taskman;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by Kesh on 3/30/2016.
 */
public class CalenderUtil {

    private static String[] years;

    public CalenderUtil(){

    }

    public static String[] getYears(){
        if(years != null){
            return years;
        }
        int year = Calendar.getInstance().get(Calendar.YEAR);
        years = new String[]{"Y", Integer.toString(year), Integer.toString(year+1), Integer.toString(year+2), Integer.toString(year+4), Integer.toString(year+5),
                Integer.toString(year + 6), Integer.toString(year+7), Integer.toString(year+8), Integer.toString(year+9)};
        return years;
    }

    public static String[] getDatesFromMonth(int month, int year){
        int days = new GregorianCalendar(year, month, 1).getActualMaximum(Calendar.DAY_OF_MONTH);
        String[] dates = new String[days];
        for(int i = 0; i < days; i++){
            dates[i] = Integer.toString(i+1);
        }
        return dates;
    }
}
