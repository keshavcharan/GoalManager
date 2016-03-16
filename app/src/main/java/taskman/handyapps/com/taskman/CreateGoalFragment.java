package taskman.handyapps.com.taskman;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Kesh on 3/13/2016.
 */
public class CreateGoalFragment extends Fragment {

    private Bundle bundle;
    private boolean edit = false;
    public CreateGoalFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        Bundle bundle = this.getArguments();
        if(bundle != null)
            edit = bundle.getBoolean("editFragment");

        View taskView = inflater.inflate(R.layout.taskview_fragment, container, false);
        TextView tv = (TextView) taskView.findViewById(R.id.textView);
        if(edit) {
            tv.setText("TEST MESSAGE Edit");
            tv.setBackgroundColor(Color.DKGRAY);
        } else  {
            tv.setText("TEST MESSAGE Create");
            tv.setBackgroundColor(Color.YELLOW);
        }
        return taskView;
    }
}
