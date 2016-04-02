package taskman.handyapps.com.taskman;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;

import taskman.handyapps.com.datalayer.DatabaseHelper;
import taskman.handyapps.com.datalayer.DatabaseManager;
import taskman.handyapps.com.datalayer.PriorityEnum;
import taskman.handyapps.com.model.Goal;

/**
 * Created by Kesh on 3/30/2016.
 */
public class CreateGoalFragmentPage2 extends DialogFragment {

    DatabaseHelper dbHelper;
    Dao<Goal, Integer> goalDao;

    public CreateGoalFragmentPage2() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        dbHelper = DatabaseManager.getDatabaseHelper(getActivity());
        goalDao = (Dao<Goal,Integer>)dbHelper.getDaoClass(Goal.class);

        final Bundle bundle = getArguments();
        if(bundle == null)
            getDialog().dismiss();

        getDialog().setCanceledOnTouchOutside(false);
        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);

        final View taskView = inflater.inflate(R.layout.create_goal_page2, container, false);
        final View oldView = inflater.inflate((R.layout.create_goal_page1), container, false);
        oldView.post(new Runnable() {
            @Override
            public void run() {
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                CreateGoalFragmentPage1 cgFragment = (CreateGoalFragmentPage1) fm.findFragmentByTag("addFragmentDialogPage1");
                if (cgFragment != null)
                    cgFragment.dismiss();
            }
        });

        final Spinner dateDD = (Spinner) taskView.findViewById(R.id.datedd);
        final Spinner monthDD = (Spinner) taskView.findViewById(R.id.monthdd);
        final Spinner yearDD = (Spinner) taskView.findViewById(R.id.yeardd);
        ArrayAdapter<String> yrAdapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_spinner_dropdown_item, CalenderUtil.getYears());
        yearDD.setAdapter(yrAdapter);
        yearDD.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position != 1) {
                    String[] months = MonthEnum.initializeDropDownArray();
                    ArrayAdapter<String> mnAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_dropdown_item, months);
                    monthDD.setAdapter(mnAdapter);
                    monthDD.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View mview, int mposition, long mid) {
                            if(mposition != 0) {
                                int month = MonthEnum.valueOf(monthDD.getSelectedItem().toString()).getMonthNumber();
                                int year = Integer.parseInt(yearDD.getSelectedItem().toString());
                                ArrayAdapter<String> dateAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_dropdown_item, CalenderUtil.getDatesFromMonth(month, year));
                                dateDD.setAdapter(dateAdapter);
                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {
                        }
                    });
                } else {
                    ArrayAdapter<String> mnAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_dropdown_item, new String[]{"M"});
                    monthDD.setAdapter(mnAdapter);

                    ArrayAdapter<String> dateAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_dropdown_item, new String[]{"D"});
                    dateDD.setAdapter(dateAdapter);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        final RadioGroup priority = (RadioGroup) taskView.findViewById(R.id.radioPriority);
        final Button nextbutton = (Button) taskView.findViewById(R.id.pagetwonext);
        nextbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDialog().dismiss();

                int deadlinetimestamp = setCalendarTimestamp(yearDD.getSelectedItem().toString(), monthDD.getSelectedItem().toString(), dateDD.getSelectedItem().toString());
/*
                bundle.putLong("timestamp",deadlinetimestamp);
                bundle.putString("priority",((RadioButton)taskView.findViewById(priority.getCheckedRadioButtonId())).getText().toString());
*/
                String title = (String)bundle.get("title");
                String description = (String)bundle.get("description");
                String selectedPriority = ((RadioButton)taskView.findViewById(priority.getCheckedRadioButtonId())).getText().toString();
                try {
                    Goal goal = new Goal();
                    goal.setAbout(title == null ? "NULL" : title);
                    goal.setDescription(description == null ? "NULL" : description);
                    goal.setEndDate(deadlinetimestamp);
                    goal.setPriority(PriorityEnum.getLevelByName(selectedPriority));
                    goalDao.create(goal);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                CreateGoalFragmentPage3 createGoalFragmentPage3 = new CreateGoalFragmentPage3();
                createGoalFragmentPage3.setArguments(bundle);
                FragmentTransaction ft = getChildFragmentManager().beginTransaction();
                createGoalFragmentPage3.show(getFragmentManager(), "addFragmentDialogPage3");
            }
        });

        final Button cancelbutton = (Button) taskView.findViewById(R.id.pagetwocancelbutton);
        cancelbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDialog().dismiss();

                FragmentManager fm = getFragmentManager();
                BottomTabsViewPager vp=(BottomTabsViewPager) getActivity().findViewById(R.id.bottom_tabs_pager);
                vp.setCurrentItem(0);
            }
        });

        return taskView;

    }



    private int setCalendarTimestamp(String y, String m, String d){
        if(y == null || m == null || d == null)
            return 0;

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, Integer.parseInt(y));
        calendar.set(Calendar.MONTH, MonthEnum.valueOf(m).getMonthNumber());
        calendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(d));
        long out = calendar.getTimeInMillis()/1000;
        return (int)out;

    }

}
