package taskman.handyapps.com.taskman;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Keshav on 12/12/2015.
 */
public class GoalCalendarFragment extends Fragment
{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View taskView = inflater.inflate(R.layout.taskview_fragment, container, false);
        TextView tv = (TextView) taskView.findViewById(R.id.textView);
        tv.setText("TEST MESSAGE 1");

        return taskView;
    }

}