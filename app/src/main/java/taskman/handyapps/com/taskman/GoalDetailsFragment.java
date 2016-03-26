package taskman.handyapps.com.taskman;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.j256.ormlite.dao.Dao;

import java.util.ArrayList;
import java.util.List;

import taskman.handyapps.com.datalayer.DatabaseHelper;
import taskman.handyapps.com.datalayer.DatabaseManager;
import taskman.handyapps.com.model.Goal;

/**
 * Created by Kesh on 3/6/2016.
 */
public class GoalDetailsFragment extends Fragment {
    DatabaseHelper dbHelper;
    ListView fileList;
    Dao<Goal, Integer> goalDao;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        dbHelper = DatabaseManager.getDatabaseHelper(getActivity());
        goalDao = (Dao<Goal,Integer>)dbHelper.getDaoClass(Goal.class);
        View taskDetails = inflater.inflate(R.layout.goal_details_page, container, false);
        fileList = (ListView) taskDetails.findViewById(R.id.textDetailsListView);
        List<Goal> detailsList = new ArrayList<Goal>();
        Goal goal = new Goal();
        goal.setAbout("Example Goal");
        goal.setEndDate((int)System.currentTimeMillis());
        detailsList.add(goal);
//        setListData();
        GoalsRowAdapter rowAdapter = new GoalsRowAdapter(detailsList, this.getActivity(), getResources());
/*        TextView tv = (TextView) taskDetails.findViewById(R.id.textDetailsView);
        tv.setText("TEST MESSAGE 2");*/
        fileList.setAdapter(rowAdapter);
        return taskDetails;
    }

}
