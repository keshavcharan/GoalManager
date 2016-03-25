package taskman.handyapps.com.taskman;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.Date;
import java.util.List;

import taskman.handyapps.com.model.Goal;
import taskman.handyapps.com.model.NotificationType;

/**
 * Created by Kesh on 3/21/2016.
 */
public class NotificationsAdapter extends BaseAdapter {

    private List<NotificationType> notificationList;
    private static LayoutInflater inflater = null;
    private TextView notificationTV;

    public NotificationsAdapter(List<NotificationType> notificationList, Activity activity){
        this.notificationList = notificationList;
        inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return notificationList.size();
    }

    @Override
    public Object getItem(int position) {
        return notificationList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if(convertView == null){
            v = inflater.inflate(R.layout.taskdetails_layout, null);
            notificationTV = (TextView) v.findViewById(R.id.notification_row);
            v.setTag(notificationTV);
        }

        NotificationType notification = notificationList.get(position);
        if(notification != null)
            notificationTV.setText(notification.getMessage());

        return v;
    }
}
