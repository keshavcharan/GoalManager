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
        getDialog().setCanceledOnTouchOutside(false);
        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);

        View taskView = inflater.inflate(R.layout.create_goal_page1, container, false);
        getDialog().setCanceledOnTouchOutside(false);
        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);

        final Button cancel_button = (Button) taskView.findViewById(R.id.cancelbutton);
        cancel_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDialog().dismiss();
                FragmentManager fm = getFragmentManager();
                BottomTabsViewPager vp = (BottomTabsViewPager) getActivity().findViewById(R.id.bottom_tabs_pager);
                vp.setCurrentItem(0);
            }
        });

        final Button next_button = (Button) taskView.findViewById(R.id.nextbutton);
        final EditText titleET = (EditText) taskView.findViewById(R.id.titletext);
        final EditText descriptionET = (EditText) taskView.findViewById(R.id.notestext);

        next_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("title", titleET.getText().toString());
                bundle.putString("description", descriptionET.getText().toString());
                CreateGoalFragmentPage2 createGoalFragmentPage2 = new CreateGoalFragmentPage2();
                createGoalFragmentPage2.setArguments(bundle);
                FragmentTransaction ft = getChildFragmentManager().beginTransaction();
                createGoalFragmentPage2.show(getFragmentManager(), "addFragmentDialogPage2");
            }
        });

        return taskView;
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
