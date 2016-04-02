package taskman.handyapps.com.taskman;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import java.util.Calendar;

/**
 * Created by Kesh on 3/13/2016.
 */
public class CreateGoalFragmentPage1 extends DialogFragment {

    public CreateGoalFragmentPage1() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        final Bundle bundle = getArguments();
        if(bundle == null)
            getDialog().dismiss();

        getDialog().setCanceledOnTouchOutside(false);
        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);

        if(bundle.getInt("AddFragmentPageNumber") == 0 || bundle.getInt("AddFragmentPageNumber") == 1) {
            View taskView = inflater.inflate(R.layout.create_goal_page1, container, false);
            getDialog().setCanceledOnTouchOutside(false);
            getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);

            final Button cancel_button = (Button) taskView.findViewById(R.id.cancelbutton);
            cancel_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getDialog().dismiss();
                    FragmentManager fm = getFragmentManager();
                    BottomTabsViewPager vp=(BottomTabsViewPager) getActivity().findViewById(R.id.bottom_tabs_pager);
                    vp.setCurrentItem(0);
                }
            });

            final Button next_button = (Button) taskView.findViewById(R.id.nextbutton);
            final EditText titleET = (EditText) taskView.findViewById(R.id.titletext);
            final EditText descriptionET = (EditText) taskView.findViewById(R.id.notestext);


            next_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    bundle.putString("title", titleET.getText().toString());
                    bundle.putString("description", descriptionET.getText().toString());
                    bundle.putInt("AddFragmentPageNumber", 2);
                    CreateGoalFragmentPage1 createGoalFragmentPage1 = new CreateGoalFragmentPage1();
                    createGoalFragmentPage1.setArguments(bundle);
                    FragmentTransaction ft = getChildFragmentManager().beginTransaction();
                    createGoalFragmentPage1.show(getFragmentManager(),"addFragmentDialogPage2");
                }
            });

            return taskView;
        } else if(bundle.getInt("AddFragmentPageNumber") == 2) {
            final View taskView = inflater.inflate(R.layout.create_goal_page2, container, false);
            final View oldView = inflater.inflate((R.layout.create_goal_page1), container, false);
            oldView.post(new Runnable() {
                @Override
                public void run() {
                    FragmentManager fm = getFragmentManager();
                    FragmentTransaction ft = fm.beginTransaction();
                    CreateGoalFragmentPage1 cgFragment = (CreateGoalFragmentPage1) fm.findFragmentByTag("addFragmentDialogPage1");
                    if(cgFragment != null)
                        cgFragment.dismiss();
                }
            });

            String[] years = new String[]{"Y", "2010", "2011"};
            final Spinner yearDD = (Spinner) taskView.findViewById(R.id.yeardd);
            ArrayAdapter<String> yrAdapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_dropdown_item, years);
            yearDD.setAdapter(yrAdapter);

            String[] months = MonthEnum.initializeDropDownArray();
            final Spinner monthDD = (Spinner) taskView.findViewById(R.id.monthdd);
            ArrayAdapter<String> mnAdapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_dropdown_item, months);
            monthDD.setAdapter(mnAdapter);

            String[] dates = new String[]{"D","1","2","3"};
            final Spinner dateDD = (Spinner) taskView.findViewById(R.id.datedd);
            ArrayAdapter<String> dateAdapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_dropdown_item, dates);
            dateDD.setAdapter(dateAdapter);

            final RadioGroup priority = (RadioGroup) taskView.findViewById(R.id.radioPriority);
            final Button page2nextbutton = (Button) taskView.findViewById(R.id.pagetwonext);
            page2nextbutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getDialog().dismiss();
                    bundle.putInt("AddFragmentPageNumber", 3);

                    long deadlinetimestamp = setCalendarTimestamp(yearDD.getSelectedItem().toString(), monthDD.getSelectedItem().toString(), dateDD.getSelectedItem().toString());
                    bundle.putLong("timestamp",deadlinetimestamp);
                    ((RadioButton)taskView.findViewById(priority.getCheckedRadioButtonId())).getText();

                    CreateGoalFragmentPage1 createGoalFragmentPage1 = new CreateGoalFragmentPage1();
                    createGoalFragmentPage1.setArguments(bundle);
                    FragmentTransaction ft = getChildFragmentManager().beginTransaction();
                    createGoalFragmentPage1.show(getFragmentManager(), "addFragmentDialogPage3");
                }
            });

            final Button pagetwocancelbutton = (Button) taskView.findViewById(R.id.pagetwocancelbutton);
            pagetwocancelbutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getDialog().dismiss();

                    FragmentManager fm = getFragmentManager();
                    BottomTabsViewPager vp=(BottomTabsViewPager) getActivity().findViewById(R.id.bottom_tabs_pager);
                    vp.setCurrentItem(0);
                }
            });

            return taskView;
        } else {
            View taskView = inflater.inflate(R.layout.create_goal_page3, container, false);
            LinearLayout subTaskLayout = (LinearLayout) taskView.findViewById(R.id.subtasklist);

            final View oldView = inflater.inflate((R.layout.create_goal_page2), container, false);
            oldView.post(new Runnable() {
                @Override
                public void run() {
                    FragmentManager fm = getFragmentManager();
                    FragmentTransaction ft = fm.beginTransaction();
                    CreateGoalFragmentPage1 cgFragment = (CreateGoalFragmentPage1) fm.findFragmentByTag("addFragmentDialogPage2");
                    if(cgFragment != null)
                        cgFragment.dismiss();
                }
            });

            final Button pagethreecancelbutton = (Button) taskView.findViewById(R.id.cancel_all);
            pagethreecancelbutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getDialog().dismiss();
                    FragmentManager fm = getFragmentManager();
                    BottomTabsViewPager vp = (BottomTabsViewPager) getActivity().findViewById(R.id.bottom_tabs_pager);
                    vp.setCurrentItem(0);
                }
            });

            //LinearLayout addLayout = addSubTask();

            return taskView;
        }
    }

    private long setCalendarTimestamp(String y, String m, String d){
        if(y == null || m == null || d == null)
            return 0;

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, Integer.parseInt(y));
        calendar.set(Calendar.MONTH, MonthEnum.valueOf(m).getMonthNumber());
        calendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(d));
        return calendar.getTimeInMillis()/1000;

    }
    /*public LinearLayout addSubTask(){
    }
*/
    public void onResume()
    {
        super.onResume();
        if(getDialog() != null) {
            Window window = getDialog().getWindow();
            window.setLayout(getResources().getDimensionPixelSize(R.dimen.add_popup_width), getResources().getDimensionPixelSize(R.dimen.add_popup_height));
            window.setGravity(Gravity.CENTER);
        }
    }
}
