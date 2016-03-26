package taskman.handyapps.com.taskman;

import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.support.design.widget.TabLayout;
import android.os.Bundle;

public class MainGoalManActivity extends FragmentActivity
{
    BottomTabsPagerAdapter bottomTabsPagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main_goalman);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);

        final BottomTabsViewPager bottomTabsViewPager = (BottomTabsViewPager) findViewById(R.id.bottom_tabs_pager);
        bottomTabsPagerAdapter = new BottomTabsPagerAdapter(getSupportFragmentManager(), getApplicationContext());
        bottomTabsViewPager.setCurrentItem(0);
        bottomTabsViewPager.setOffscreenPageLimit(2);
        bottomTabsViewPager.setAdapter(bottomTabsPagerAdapter);

        tabLayout.setupWithViewPager(bottomTabsViewPager);
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
                    bottomTabsViewPager.setCurrentItem(tab.getPosition());
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
