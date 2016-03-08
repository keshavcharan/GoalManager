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
        this.numberOfTabs = 2;
    }

    @Override
    public Fragment getItem(int position) {
        switch(position)
        {
            case 0:
                TaskViewFragment taskViewFragment = new TaskViewFragment();
                return taskViewFragment;
            case 1:
                GoalDetailsFragment goalDetailsFragment = new GoalDetailsFragment();
                return goalDetailsFragment;
            default:
                return null;
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch(position)
        {
            case 0:
                return "Goals";
            case 1:
                return "Task Calendar";
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numberOfTabs;
    }
}
