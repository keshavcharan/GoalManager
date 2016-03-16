package taskman.handyapps.com.taskman;

import android.app.ActionBar;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.support.design.widget.TabLayout;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TableLayout;

public class TaskManagerActivity extends FragmentActivity
{
    BottomTabsPagerAdapter bottomTabsPagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_task_manager);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);

        BottomViewPager bottomViewPager = (BottomViewPager) findViewById(R.id.bottom_tabs_pager);
        bottomTabsPagerAdapter = new BottomTabsPagerAdapter(getSupportFragmentManager(), getApplicationContext());
        bottomViewPager.setAdapter(bottomTabsPagerAdapter);

        tabLayout.setupWithViewPager(bottomViewPager);

    }

}
