package taskman.handyapps.com.taskman;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

/**
 * Created by Keshav on 12/12/2015.
 */
public class GoalCalendarFragment extends Fragment
{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View taskView = inflater.inflate(R.layout.goal_calendar, container, false);

        String[] items = new String[]{"GOALS"};
        Spinner goalDD = (Spinner) taskView.findViewById(R.id.goaldd);
        ArrayAdapter<String> goalAdapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_dropdown_item, items);
        goalDD.setAdapter(goalAdapter);

        String[] subtasks = new String[]{"SUB TASKS", "ALL"};
        Spinner subtaskDD = (Spinner) taskView.findViewById(R.id.subtaskdd);
        ArrayAdapter<String> subtaskAdapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_dropdown_item,subtasks);
        subtaskDD.setAdapter(subtaskAdapter);


        String[] months = new String[]{"JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "SEPT", "OCT", "NOV", "DEC"};
        Spinner monthDD = (Spinner) taskView.findViewById(R.id.monthlistdd);
        ArrayAdapter<String> monthAdapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_dropdown_item,months);
        monthDD.setAdapter(monthAdapter);


        String[] yearDD = new String[]{"CURRENT YR"};
        Spinner yeartaskDD = (Spinner) taskView.findViewById(R.id.yearlistdd);
        ArrayAdapter<String> yearAdapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_dropdown_item, yearDD);
        yeartaskDD.setAdapter(yearAdapter);

        return taskView;

    }

}
