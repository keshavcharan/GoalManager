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
public class GoalManagerFragment extends Fragment {
    TasksPagerAdapter tasksPagerAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View goals = inflater.inflate(R.layout.top_goals_viewpager, container, false);
        System.out.println("yyyyyyyyyyyyyyyyyyyy");
        ViewPager viewPager = (ViewPager) goals.findViewById(R.id.tabspager);
        tasksPagerAdapter = new TasksPagerAdapter(getChildFragmentManager());
        viewPager.setAdapter(tasksPagerAdapter);

        return goals;
    }

}
