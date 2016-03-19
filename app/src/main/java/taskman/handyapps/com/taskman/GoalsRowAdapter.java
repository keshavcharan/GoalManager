package taskman.handyapps.com.taskman;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import taskman.handyapps.com.model.Goal;

/**
 * Created by Kesh on 2/28/2016.
 */
public class GoalsRowAdapter extends BaseAdapter implements View.OnClickListener
{

    private static LayoutInflater inflater = null;
    private List<Goal> goals;
    private Activity activity;
    private Resources res;
    private Goal goal;

    public static class FileViewHolder {
        public TextView taskStatus;
        public TextView taskTitle;
        public TextView taskDate;
    }

    public GoalsRowAdapter(List<Goal> goals, Activity activity, Resources res)
    {
        if(goals == null)
            this.goals = new ArrayList<Goal>();
        else
            this.goals = goals;

        this.activity = activity;
        this.res = res;
        inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return goals.size();
    }

    @Override
    public Object getItem(int position) {
        return goals.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        FileViewHolder holder ;
        if(convertView == null){
            v = inflater.inflate(R.layout.taskdetails_layout, null);
            holder = new FileViewHolder();
            holder.taskStatus = (TextView)v.findViewById(R.id.task_stat);
            holder.taskTitle = (TextView)v.findViewById(R.id.task_header);
            holder.taskDate = (TextView) v.findViewById(R.id.task_date);
            v.setTag(holder);
        }else{
            holder = (FileViewHolder) v.getTag();
        }

            goal = (Goal) goals.get(position);

            holder.taskStatus.setText("false");
            holder.taskTitle.setText(goal.getAbout());
            holder.taskDate.setText(new Date(goal.getEndDate()).toString());

            //v.setOnClickListener(new OnItemClickListener(position));

/*			holder.reminderImage.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					 open reminder popup
				}
			});
*/
			/* set data */
/*            holder.copySelect.setOnCheckedChangeListener(new OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

					*//* copy text/file *//*
                }
            });*/

        return v;
    }

    public Goal getGoal() {
        return goal;
    }

    public void setGoal(Goal goal) {
        this.goal = goal;
    }

    @Override
    public void onClick(View v) {

    }
}
