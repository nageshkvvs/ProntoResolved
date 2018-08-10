package com.prontoresolved.activity;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;


import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import android.support.v4.app.FragmentManager;
import com.github.jjobes.slidedatetimepicker.SlideDateTimeListener;
import com.github.jjobes.slidedatetimepicker.SlideDateTimePicker;
import com.prontoresolved.validations.ProntoValidations;
import com.testdemo.com.prontoresolved.R;

import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/**
 * Created by venkatarao.g on 2/20/2018.
 */

public class MainActivity extends BaseActivity {
    Handler handler;
    DatePickerDialog datePickerDialog;
    TextView tv;
    @Override
    public void _onCreateOfActivity(Bundle savedInstanceState) {
       // super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //ActionBar actionBar = getActionBar();

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        Random randomGenerator = new Random();
        int counter = randomGenerator.nextInt(7);
        final RelativeLayout imageView = (RelativeLayout) findViewById(R.id.rl_backgd_image);
       /* RadioButton button1=(RadioButton)findViewById(R.id.radioButton1);
        RadioButton button2=(RadioButton)findViewById(R.id.radioButton2);*/
        LinearLayout linearLayout=(LinearLayout)findViewById(R.id.ll_hotel);

        if (counter == 0) {
            imageView.setBackgroundResource(R.drawable.h1);
        }
        if (counter == 1) {
            imageView.setBackgroundResource(R.drawable.h2);
        }
        if (counter == 2) {
            imageView.setBackgroundResource(R.drawable.h3);
        }
        if (counter == 3) {
            imageView.setBackgroundResource(R.drawable.h4);
        }
        if (counter == 4) {
            imageView.setBackgroundResource(R.drawable.h5);
        }
        if (counter == 5) {
            imageView.setBackgroundResource(R.drawable.h6);

        }
        if (counter == 6) {
            imageView.setBackgroundResource(R.drawable.h7);

        }
//        if (counter == 7) {
//            imageView.setBackgroundResource(R.drawable.h8);
//
//        }
//        if (counter == 8) {
//            imageView.setBackgroundResource(R.drawable.h9);
//
//        }
//        if (counter == 9) {
//            imageView.setBackgroundResource(R.drawable.h10);
//
//        }
//        if (counter == 10) {
//            imageView.setBackgroundResource(R.drawable.h11);
//
//        }
        /*if (counter == 11) {
            imageView.setBackgroundResource(R.drawable.h12);

        }
        if (counter == 12) {
            imageView.setBackgroundResource(R.drawable.h13);

        }
        if (counter == 13) {
            imageView.setBackgroundResource(R.drawable.h14);

        }
        if (counter == 14) {
            imageView.setBackgroundResource(R.drawable.h15);

        }
        if (counter == 15) {
            imageView.setBackgroundResource(R.drawable.h16);

        }
        if (counter == 16) {
            imageView.setBackgroundResource(R.drawable.h17);

        }
        if (counter == 17) {
            imageView.setBackgroundResource(R.drawable.h18);

        }if (counter == 18) {
            imageView.setBackgroundResource(R.drawable.h19);

        }
        if (counter == 19) {
            imageView.setBackgroundResource(R.drawable.h20);

        }
        if (counter == 20) {
            imageView.setBackgroundResource(R.drawable.h21);

        }*/


        /*Animation hyperspaceJumpAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_in);
        button1.startAnimation(hyperspaceJumpAnimation);

        Animation hyperspaceJumpAnimation1 = AnimationUtils.loadAnimation(this, R.anim.anim_out);
        button2.startAnimation(hyperspaceJumpAnimation1);*/

        Animation hyperspaceJumpAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_in_top);
        linearLayout.startAnimation(hyperspaceJumpAnimation);

    }



    public void guestInfo(View view){
        //Toast.makeText(getApplicationContext(),"ttttt",Toast.LENGTH_LONG).show();
        LinearLayout linearLayout=(LinearLayout)findViewById(R.id.ll_hotel);
        Animation hyperspaceJumpAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_out_top);
        linearLayout.startAnimation(hyperspaceJumpAnimation);


        LinearLayout guestInfo=(LinearLayout)findViewById(R.id.ll_guestinfo);
        //
        Animation showAnim = AnimationUtils.loadAnimation(this, R.anim.slide_in_top);

        guestInfo.startAnimation(showAnim);
        guestInfo.setVisibility(View.VISIBLE);
    }

   public void showDatePicker(View view){
      /* final LinearLayout guestInfo=(LinearLayout)findViewById(R.id.ll_datepicker);*/
       //
        tv = (TextView)view;
       Animation showAnim = AnimationUtils.loadAnimation(this, R.anim.slide_in_top);
       boolean isDateSet = false;
      /* guestInfo.startAnimation(showAnim);
       guestInfo.setVisibility(View.VISIBLE);
*/
      // final DatePicker datePicker = (DatePicker)findViewById(R.id.simpleDatePicker);

              // guestInfo.setVisibility(View.GONE);
//               final Calendar c = Calendar.getInstance();
//               int mYear = c.get(Calendar.YEAR); // current year
//               int mMonth = c.get(Calendar.MONTH); // current month
//               int mDay = c.get(Calendar.DAY_OF_MONTH); // current day
//               // date picker dialog
//               datePickerDialog = new DatePickerDialog(MainActivity.this,
//                       new DatePickerDialog.OnDateSetListener() {
//
//                           @Override
//                           public void onDateSet(DatePicker view, int year,
//                                                 int monthOfYear, int dayOfMonth) {
//                               // set day of month , month and year value in the edit text
//                               tv.setText(dayOfMonth + "/"
//                                       + (monthOfYear + 1) + "/" + year);
//
//                           }
//                       }, mYear, mMonth, mDay);
//       //datePickerDialog.start
//       datePickerDialog.getWindow().getAttributes().windowAnimations = R.style.dialog_animation;
//       datePickerDialog.show();
      // FragmentActivity activity = (FragmentActivity) this;
      // FragmentManager manager = activity.getSupportFragmentManager();
       new SlideDateTimePicker.Builder(getSupportFragmentManager())
               .setListener(listener)
               .setMinDate(new Date())
               .setInitialDate(new Date())
               .build()
               .show();

   }
    public void hideDatePicker(View view){
        LinearLayout ll = (LinearLayout)view;
        Animation hyperspaceJumpAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_out_top);
        ll.startAnimation(hyperspaceJumpAnimation);
        //ll.setVisibility(View.GONE);
    }

    private SlideDateTimeListener listener = new SlideDateTimeListener() {

        @Override
        public void onDateTimeSet(Date date)
        {
            // Do something with the date. This Date object contains
            // the date and time that the user has selected.
         //   Toast.makeText(getApplicationContext(),date.toString(),Toast.LENGTH_LONG).show();
           // TextView tv1= (TextView) getActivity().findViewById(R.id.textview1);
     //   tv.setText("Year: "+view.getYear()+" Month: "+view.getMonth()+" Day: "+view.getDayOfMonth());
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm a");
            dateFormat.format(date);
            tv.setText(dateFormat.format(date).toString());
           // tv.setText(date.toString());
        }

        @Override
        public void onDateTimeCancel()
        {
            // tv.setText("");
            // Overriding onDateTimeCancel() is optional.
        }

    };

    public void _formSubmit(View view) throws  ParseException{
        EditText firstName=(EditText)findViewById(R.id.guestname_et);
        //hotel_name_et
        EditText lastName=(EditText)findViewById(R.id.hotel_name_et);
        //check_in_tv
        TextView checkIn=(TextView)findViewById(R.id.check_in_tv);
        TextView checkOut=(TextView)findViewById(R.id.check_out_tv);
        //room_number_et
        EditText roomNumber=(EditText)findViewById(R.id.room_number_et);

      /* if (!ProntoValidations.isEmptyOrNull(guestName.getText().toString()) && !ProntoValidations.isEmptyOrNull(hotelName.getText().toString())
               && !ProntoValidations.isEmptyOrNull(checkIn.getText().toString()) && !ProntoValidations.isEmptyOrNull(checkOut.getText().toString())) {
           Intent intent = new Intent(MainActivity.this, HomeActivity.class);
           startActivity(intent);
           overridePendingTransition(R.anim.anim_out, R.anim.anim_in);
       }else{
           Toast.makeText(getApplicationContext(),"please fill the fields",Toast.LENGTH_LONG).show();
       }*/

        Log.d("Check in date ::",checkIn.getText().toString());
        Log.d("Check out date ::",checkOut.getText().toString());
        if(ProntoValidations.isEmptyOrNull(firstName.getText().toString())){
//Please enter room number
          //  Toast.makeText(getApplicationContext()," Please enter guest name ",Toast.LENGTH_LONG).show();
            showValidations("Please enter all fields to proceed ","Alert","Ok");
        }else if(ProntoValidations.isEmptyOrNull(lastName.getText().toString())){
           // Toast.makeText(getApplicationContext()," Please enter hotel name ",Toast.LENGTH_LONG).show();
            showValidations("Please enter all fields to proceed","Alert","Ok");
        }
        else if(ProntoValidations.isEmptyOrNull(checkIn.getText().toString())){
           // Toast.makeText(getApplicationContext()," Please select checkin date ",Toast.LENGTH_LONG).show();
            showValidations("Please enter all fields to proceed","Alert","Ok");
        }else if(ProntoValidations.isEmptyOrNull(checkOut.getText().toString())){
           // Toast.makeText(getApplicationContext()," Please select checkout date ",Toast.LENGTH_LONG).show();
            showValidations("Please enter all fields to proceed ","Alert","Ok");
        }else if(ProntoValidations.isEmptyOrNull(roomNumber.getText().toString())){
            // Toast.makeText(getApplicationContext()," Please select checkout date ",Toast.LENGTH_LONG).show();
            showValidations("Please enter all fields to proceed ","Alert","Ok");
        }else if(!datesValidations()){
            // Toast.makeText(getApplicationContext()," Please select checkout date ",Toast.LENGTH_LONG).show();
            showValidations("Check out date should be greater than check in date","Alert","Ok");
        }

        else{
            Intent intent = new Intent(MainActivity.this, HomeActivity.class);
            setFirstName(firstName.getText().toString());
            setLastName(lastName.getText().toString());
           /* Bundle b =new Bundle();
            b.putString("FirstName",firstName.getText().toString());
            b.putString("LastName",lastName.getText().toString());
            intent.putExtras(b);*/
            startActivity(intent);
            overridePendingTransition(R.anim.anim_out, R.anim.anim_in);
        }

    }
    public void _closeGuestLayout(View view){
        //Toast.makeText(getApplicationContext(),"ttttt",Toast.LENGTH_LONG).show();
        LinearLayout linearLayout=(LinearLayout)findViewById(R.id.ll_hotel);
        Animation showAnim = AnimationUtils.loadAnimation(this, R.anim.slide_in_top);

        linearLayout.startAnimation(showAnim);


        LinearLayout guestInfo=(LinearLayout)findViewById(R.id.ll_guestinfo);

        Animation hyperspaceJumpAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_out_top);

        guestInfo.startAnimation(hyperspaceJumpAnimation);
        guestInfo.setVisibility(View.VISIBLE);
        EditText firstName=(EditText)findViewById(R.id.guestname_et);
        //hotel_name_et
        EditText lastName=(EditText)findViewById(R.id.hotel_name_et);
        //check_in_tv
        TextView checkIn=(TextView)findViewById(R.id.check_in_tv);
        TextView checkOut=(TextView)findViewById(R.id.check_out_tv);
        //room_number_et
        EditText roomNumber=(EditText)findViewById(R.id.room_number_et);
        firstName.setText("");
        lastName.setText("");
        checkIn.setText("");
        checkOut.setText("");
        roomNumber.setText("");
    }

    @Override
    public void onBackPressed() {
//        Intent intent = new Intent(RequestActivtiy.this, HomeActivity.class);
//        startActivity(intent);
//        overridePendingTransition(R.anim.anim_in, R.anim.anim_out);
        moveTaskToBack(true);
    }



    public boolean datesValidations() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm a");
        TextView checkInDate = (TextView) findViewById(R.id.check_in_tv);
        TextView checkOutDate = (TextView) findViewById(R.id.check_out_tv);
        Log.d("Check in date ::", checkInDate.getText().toString());
        Log.d("Check out date ::",checkOutDate.getText().toString());
        Date checkIn = sdf.parse(checkInDate.getText().toString());
        Date checkOut = sdf.parse(checkOutDate.getText().toString());
        if (checkIn.compareTo(checkOut) < 0) {
            return true;
        } else {
            return false;
        }


    }


    }





