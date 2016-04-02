package taskman.handyapps.com.taskman;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Kesh on 3/14/2016.
 */
public class GoalTabsViewPager extends Fragment {
    GoalTabsPagerAdapter goalTabsPagerAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        Bundle bundle = this.getArguments();

        boolean addPopup = false;
        if(bundle != null) {
            addPopup = bundle.getBoolean("addPopup");
        }

        if(addPopup) {
            CreateGoalFragmentPage1 createGoal = new CreateGoalFragmentPage1();
            createGoal.show(getFragmentManager(), "fragmentDialog");
        }

            View goals = inflater.inflate(R.layout.goal_tabs_viewpager, container, false);
            ViewPager viewPager = (ViewPager) goals.findViewById(R.id.tabspager);
            goalTabsPagerAdapter = new GoalTabsPagerAdapter(getChildFragmentManager());
            viewPager.setAdapter(goalTabsPagerAdapter);
            viewPager.setCurrentItem(1);
            return goals;

    }

}
