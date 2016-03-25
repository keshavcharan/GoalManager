package taskman.handyapps.com.taskman;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.List;

/**
 * Created by Kesh on 3/21/2016.
 */
public class NotificationFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.notification_page, container, false);
        ListView lv = (ListView) view.findViewById(R.id.notificationsListView);
        return view;
    }
}
