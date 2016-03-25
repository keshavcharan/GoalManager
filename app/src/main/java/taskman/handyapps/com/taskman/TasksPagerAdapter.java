package taskman.handyapps.com.taskman;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by Keshav on 12/12/2015.
 */
public class TasksPagerAdapter extends FragmentStatePagerAdapter
{
    int numberOfTabs;
    public TasksPagerAdapter(FragmentManager fm) {
        super(fm);
        this.numberOfTabs = 3;
    }

    @Override
    public Fragment getItem(int position) {
        switch(position)
        {
            case 0:
                return new GoalCalendarFragment();
            case 1:
                return new GoalDetailsFragment();
            case 2:
                return new NotificationFragment();
            default:
                return new GoalDetailsFragment();
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch(position)
        {
            case 0:
                return "Task Calendar";
            case 1:
                return "Goals";
            case 2:
                return "Notifications";
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numberOfTabs;
    }
}
