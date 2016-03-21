package taskman.handyapps.com.taskman;

import android.app.ActionBar;
import android.app.Fragment;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.support.design.widget.TabLayout;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TabHost;
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

        final BottomViewPager bottomViewPager = (BottomViewPager) findViewById(R.id.bottom_tabs_pager);
        bottomTabsPagerAdapter = new BottomTabsPagerAdapter(getSupportFragmentManager(), getApplicationContext());
        bottomViewPager.setCurrentItem(0);
        bottomViewPager.setOffscreenPageLimit(2);
        bottomViewPager.setAdapter(bottomTabsPagerAdapter);

        tabLayout.setupWithViewPager(bottomViewPager);
        tabLayout.addTab(tabLayout.newTab().setText("+"));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if(tab.getPosition() == 2){
                    Bundle bundle = new Bundle();
                    bundle.putInt("AddFragmentPageNumber", 1);
                    CreateGoalFragment createGoal = new CreateGoalFragment();
                    createGoal.setShowsDialog(true);
                    createGoal.setArguments(bundle);
                    createGoal.setStyle(DialogFragment.STYLE_NORMAL, 0);
                    createGoal.show(getSupportFragmentManager(), "addFragmentDialogPage1");
                } else {
                    bottomViewPager.setCurrentItem(tab.getPosition());
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

}
