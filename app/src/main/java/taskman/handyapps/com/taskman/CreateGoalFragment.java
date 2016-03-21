package taskman.handyapps.com.taskman;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.text.InputFilter;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Kesh on 3/13/2016.
 */
public class CreateGoalFragment extends DialogFragment {

    public CreateGoalFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        final Bundle bundle = getArguments();
        if(bundle == null)
            getDialog().dismiss();

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
                    BottomViewPager vp=(BottomViewPager) getActivity().findViewById(R.id.bottom_tabs_pager);
                    vp.setCurrentItem(0);
                }
            });

            final Button next_button = (Button) taskView.findViewById(R.id.nextbutton);

            next_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Bundle bundle = new Bundle();
                    bundle.putInt("AddFragmentPageNumber", 2);
                    CreateGoalFragment createGoalFragment = new CreateGoalFragment();
                    createGoalFragment.setArguments(bundle);
                    FragmentTransaction ft = getChildFragmentManager().beginTransaction();
                    createGoalFragment.show(getFragmentManager(),"addFragmentDialogPage2");
                }
            });

            return taskView;
        } else {
            View taskView = inflater.inflate(R.layout.create_goal_page2, container, false);
            getDialog().setCanceledOnTouchOutside(false);
            getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);

            final View oldView = inflater.inflate((R.layout.create_goal_page1), container, false);
            oldView.post(new Runnable() {
                @Override
                public void run() {
                    FragmentManager fm = getFragmentManager();
                    FragmentTransaction ft = fm.beginTransaction();
                    CreateGoalFragment cgFragment = (CreateGoalFragment) fm.findFragmentByTag("addFragmentDialogPage1");
                    if(cgFragment != null)
                        cgFragment.dismiss();
                }
            });

            final Button pagetwocancelbutton = (Button) taskView.findViewById(R.id.pagetwocancelbutton);
            pagetwocancelbutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getDialog().dismiss();

                    FragmentManager fm = getFragmentManager();
                    BottomViewPager vp=(BottomViewPager) getActivity().findViewById(R.id.bottom_tabs_pager);
                    vp.setCurrentItem(0);
                }
            });

            return taskView;
        }
    }

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
