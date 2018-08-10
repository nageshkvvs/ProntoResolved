package com.prontoresolved.components;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.testdemo.com.prontoresolved.R;

import java.util.List;

/**
 * Created by nageshk on 3/9/2018.
 */
public class NotificationBaseAdapter extends BaseAdapter{
    Context ctx;
    LayoutInflater lInflater;
    List<Notification> data;

    public NotificationBaseAdapter(Context context, List<Notification> data) {
        ctx = context;
        this.data = data;
        lInflater = (LayoutInflater) ctx
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        Notification notification = (Notification)getItem(position);
        if (view == null) {
            view = lInflater.inflate(R.layout.activity_notification, parent, false);
        }

//        if (position % 2 == 0) {
//            view.setBackgroundResource(R.drawable.artists_list_backgroundcolor);
//        } else {
//            view.setBackgroundResource(R.drawable.artists_list_background_alternate);
//        }

        //((TextView) view.findViewById(R.id.heading)).setText(data.get(position));
        TextView title = (TextView) view.findViewById(R.id.notification_title);
        TextView message = (TextView) view.findViewById(R.id.notification_msg);
        TextView status_type = (TextView) view.findViewById(R.id.status_type);
        //status_type
        // Populate the data into the template view using the data object
        title.setText(notification.getTitle());
        message.setText(notification.getMessage());
        status_type.setText(notification.getStatusType());
        // Return the completed view to render on screen
        //convertView.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.textbox, null));
        //view.setBackgroundResource(R.drawable.notification_textbox);


        return view;
    }
}
