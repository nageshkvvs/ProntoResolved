package com.prontoresolved.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.prontoresolved.components.Notification;
import com.prontoresolved.components.NotificationAdapter;
import com.prontoresolved.components.NotificationBaseAdapter;
import com.testdemo.com.prontoresolved.*;

import java.util.ArrayList;

/**
 * Created by venkatarao.g on 2/26/2018.
 */

public class HomeActivity extends BaseActivity {


    @Override
    public void _onCreateOfActivity(Bundle savedInstanceState) {
      //  super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        ListView simpleList = (ListView) findViewById(R.id.notification_listview);
        TextView firstNameTv=(TextView)findViewById(R.id.home_firstName);
        TextView lastNameTv=(TextView)findViewById(R.id.home_lastName);

        firstNameTv.setText(getFirstName());
        lastNameTv.setText(getLastName());
       /* Bundle b = getIntent().getExtras();
        String firstName= b.getString("FirstName");
        String lastName= b.getString("LastName");


        firstNameTv.setText(firstName);
        lastNameTv.setText(lastName);*/
        // Construct the data source
        ArrayList<Notification> arrayOfUsers = new ArrayList<Notification>();
        arrayOfUsers.add(new Notification("Update for you","You request for cab booking is successful for drive to New york","Closed"));
        arrayOfUsers.add(new Notification("Service update","Your request for cleaning service of room is going to be done at 10:45 AM.","Open"));
        arrayOfUsers.add(new Notification("Restaurant  update","Your breakfast is wating for you at dine 23. Please get delicious food on plate","Open"));
// Create the adapter to convert the array to views
        //NotificationAdapter adapter = new NotificationAdapter(this, arrayOfUsers);
        NotificationBaseAdapter adapter = new NotificationBaseAdapter(this,arrayOfUsers);
        simpleList.setAdapter(adapter);
    }

    public void request(View view) {
        Intent intent = new Intent(HomeActivity.this, RequestActivtiy.class);
        startActivity(intent);
        overridePendingTransition(R.anim.anim_out, R.anim.anim_in);
    }

    public void report(View view) {
        Intent intent = new Intent(HomeActivity.this, ReportActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.anim_out, R.anim.anim_in);
    }

    public void home(View view) {

    }


    public void underConstruction(View v) {
        showImageErrorMessage(R.string.label_underConstruction, R.string.label_underConstruction_MessageBlank, R.drawable.underconstruction);
    }
    public void contactPurpose(View v) {
        //showImageErrorMessage(R.string.label_underConstruction, R.string.label_underConstruction_MessageBlank, R.drawable.underconstruction);
        contact();
    }


    @Override
    public void onBackPressed() {
        Intent intent = new Intent(HomeActivity.this,MainActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.anim_in, R.anim.anim_out);
    }
}
