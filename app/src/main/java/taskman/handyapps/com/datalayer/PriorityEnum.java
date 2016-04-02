package taskman.handyapps.com.datalayer;

import android.util.SparseArray;
import android.util.SparseIntArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Kesh on 4/2/2016.
 */
public enum PriorityEnum {

    LOW(0, "LOW"),
    NOR(1, "NORMAL"),
    HIGH(2, "HIGH"),
    TOP(3, "PIN TO TOP");

    private int level;
    private String name;

    private static final SparseArray<String> eMap = initializeMap();
    private PriorityEnum(int level, String name) {
        this.level = level;
        this.name = name;
    }

    public String getName() { return name; }
    public int getLevel() { return level; }

    private static SparseArray<String> initializeMap() {
        SparseArray<String> enumMap = new SparseArray<>();
        List<PriorityEnum> enumList = Arrays.asList(PriorityEnum.values());
        for(PriorityEnum enumval : enumList){
            enumMap.put(enumval.getLevel(), enumval.getName());
        }
        return enumMap;
    }

    public static int getLevelByName(String name){
        if(name == null)
            return -1;

        for(int i = 0; i < eMap.size(); i++)
        {
            if(name.equals(eMap.get(i)))
            {
                return eMap.keyAt(i);
            }
        }
        return -1;
    }

}
