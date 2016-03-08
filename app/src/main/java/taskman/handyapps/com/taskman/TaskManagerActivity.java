package taskman.handyapps.com.taskman;

import android.app.ActionBar;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.widget.TableLayout;

public class TaskManagerActivity extends FragmentActivity
{
    TasksPagerAdapter tasksPagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);



        setContentView(R.layout.activity_task_manager);
        ViewPager viewPager = (ViewPager) findViewById(R.id.tabspager);
        tasksPagerAdapter = new TasksPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(tasksPagerAdapter);
    }
}
