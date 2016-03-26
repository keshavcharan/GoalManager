package taskman.handyapps.com.taskman;

import android.content.Context;
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

    GoalTabsViewPager goalTabsViewPager;
    TutorialFragment tutorialFragment;

    public BottomTabsPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
        this.numberOfTabs = 2;

        goalTabsViewPager = new GoalTabsViewPager();
        tutorialFragment = new TutorialFragment();
    }

    @Override
    public Fragment getItem(int position) {
        switch(position)
        {
            case 0:
                return goalTabsViewPager;
            case 1:
                return tutorialFragment;
            default:
                return new GoalTabsViewPager();
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
            default:
                title = "";
                break;

        }
        return title;
    }
}
