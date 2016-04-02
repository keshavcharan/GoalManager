package taskman.handyapps.com.taskman;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;

/**
 * Created by Kesh on 3/30/2016.
 */
public class CreateGoalFragmentPage3 extends DialogFragment {


    public CreateGoalFragmentPage3() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final Bundle bundle = getArguments();
        if(bundle == null)
            getDialog().dismiss();

        getDialog().setCanceledOnTouchOutside(false);
        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);

        View taskView = inflater.inflate(R.layout.create_goal_page3, container, false);
        LinearLayout subTaskLayout = (LinearLayout) taskView.findViewById(R.id.subtasklist);

        final View oldView = inflater.inflate((R.layout.create_goal_page2), container, false);
        oldView.post(new Runnable() {
            @Override
            public void run() {
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                CreateGoalFragmentPage2 cgFragment = (CreateGoalFragmentPage2) fm.findFragmentByTag("addFragmentDialogPage2");
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
