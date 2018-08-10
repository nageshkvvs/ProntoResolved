package com.prontoresolved.components;

import android.content.Context;
import android.support.v4.content.res.ResourcesCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.testdemo.com.prontoresolved.R;

import java.util.ArrayList;

/**
 * Created by venkatarao.g on 3/8/2018.
 */

public class NotificationAdapter extends ArrayAdapter<Notification> {
    public NotificationAdapter(Context context, ArrayList<Notification> users) {
        super(context, 0, users);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Notification notification = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_notification, parent, false);
        }
        // Lookup view for data population
        TextView title = (TextView) convertView.findViewById(R.id.notification_title);
        TextView message = (TextView) convertView.findViewById(R.id.notification_msg);
        TextView status_type = (TextView) convertView.findViewById(R.id.status_type);
        //status_type
        // Populate the data into the template view using the data object
        title.setText(notification.getTitle());
        message.setText(notification.getMessage());
        status_type.setText(notification.getStatusType());
        // Return the completed view to render on screen
        //convertView.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.textbox, null));
      //  convertView.setBackgroundResource(R.drawable.textbox);
        return convertView;
    }
}
