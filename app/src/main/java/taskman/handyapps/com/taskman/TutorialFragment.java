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
public class TutorialFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View taskView = inflater.inflate(R.layout.taskview_fragment, container, false);
        TextView tv = (TextView) taskView.findViewById(R.id.textView);
        tv.setText("TEST MESSAGE Tutorial");
        tv.setBackgroundColor(Color.DKGRAY);
        return taskView;
    }
}
