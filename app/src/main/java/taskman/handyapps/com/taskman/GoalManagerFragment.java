package taskman.handyapps.com.taskman;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Kesh on 3/14/2016.
 */
public class GoalManagerFragment extends Fragment {
    TasksPagerAdapter tasksPagerAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        Bundle bundle = this.getArguments();

        boolean addPopup = false;
        if(bundle != null) {
            addPopup = bundle.getBoolean("addPopup");
        }

        if(addPopup) {
            CreateGoalFragment createGoal = new CreateGoalFragment();
            createGoal.show(getFragmentManager(), "fragmentDialog");
        }

            View goals = inflater.inflate(R.layout.top_goals_viewpager, container, false);
            ViewPager viewPager = (ViewPager) goals.findViewById(R.id.tabspager);
            tasksPagerAdapter = new TasksPagerAdapter(getChildFragmentManager());
            viewPager.setAdapter(tasksPagerAdapter);
            viewPager.setCurrentItem(1);
            return goals;

    }

}
