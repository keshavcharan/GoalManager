package taskman.handyapps.com.taskman;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.LayoutInflater;

/**
 * Created by Kesh on 3/13/2016.
 */
public class BottomTabsPagerAdapter extends FragmentStatePagerAdapter{

    LayoutInflater inflater;
    int numberOfTabs;
    Context context;

    public BottomTabsPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
        this.numberOfTabs = 3;
    }

    @Override
    public Fragment getItem(int position) {
        switch(position)
        {
            case 0:
                return new GoalManagerFragment();
            case 1:
                return new TutorialFragment();
            case 2:
                return new CreateGoalFragment();
            default:
                return new GoalManagerFragment();
        }
    }

    @Override
    public int getCount() {
        return numberOfTabs;
    }

    @Override
    public CharSequence getPageTitle(int position){
        CharSequence title;
        switch (position)
        {
            case 0:
                title = "HOME";
                break;
            case 1:
                title = "i";
                break;
            case 2:
                title = "+";
                break;
            default:
                title = "";
                break;

        }
        return title;
    }



}
