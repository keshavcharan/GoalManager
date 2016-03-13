package taskman.handyapps.com.taskman;

import android.app.ActionBar;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.support.design.widget.TabLayout;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TableLayout;

public class TaskManagerActivity extends AppCompatActivity
{
    TasksPagerAdapter tasksPagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_task_manager);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        tabLayout.addTab(tabLayout.newTab().setText("Tab 1"));
        tabLayout.addTab(tabLayout.newTab().setText("Tab 2"));
        tabLayout.addTab(tabLayout.newTab().setText("Tab 3"));
        ViewPager viewPager = (ViewPager) findViewById(R.id.tabspager);
        tasksPagerAdapter = new TasksPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(tasksPagerAdapter);

    }
}
