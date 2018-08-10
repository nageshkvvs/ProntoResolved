package com.prontoresolved.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.github.jjobes.slidedatetimepicker.SlideDateTimeListener;
import com.github.jjobes.slidedatetimepicker.SlideDateTimePicker;
import com.prontoresolved.validations.ProntoValidations;
import com.testdemo.com.prontoresolved.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by venkatarao.g on 2/28/2018.
 */

public class RequestActivtiy extends BaseActivity {
    Spinner restaurants;
    boolean restaurantFlag;
    EditText requestService;
    TextView selectDate;
    TextView tv;
    EditText numberOfPersons;
    @Override
    public void _onCreateOfActivity(Bundle savedInstanceState) {
    //    super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        restaurants=(Spinner)findViewById(R.id.request_hotel_spinner) ;
        List<String> list = new ArrayList<String>();
        list.add("Select");
        list.add("Paradise");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        restaurants.setAdapter(dataAdapter);
        restaurants.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {

                if (position > 0) {
                    restaurantFlag = true;
                    Object item = adapterView.getItemAtPosition(position);
                } else {
                    restaurantFlag = false;
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
    public void showDatePicker(View view){
      /* final LinearLayout guestInfo=(LinearLayout)findViewById(R.id.ll_datepicker);*/
        //
        tv = (TextView)view;
        Animation showAnim = AnimationUtils.loadAnimation(this, R.anim.slide_in_top);
        boolean isDateSet = false;

        new SlideDateTimePicker.Builder(getSupportFragmentManager())
                .setListener(listener)
                .setMinDate(new Date())
                .setInitialDate(new Date())
                .build()
                .show();

    }
    private SlideDateTimeListener listener = new SlideDateTimeListener() {

        @Override
        public void onDateTimeSet(Date date)
        {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy, HH:mm a");
            dateFormat.format(date);
            tv.setText(dateFormat.format(date).toString());
            // tv.setText(date.toString());
        }

        @Override
        public void onDateTimeCancel()
        {
          //  tv.setText("");
            // Overriding onDateTimeCancel() is optional.
        }
    };

    public  void  request(View view){
        //Intent intent=new Intent(HomeActivity.this,RequestActivtiy.class);
       // startActivity(intent);
       // overridePendingTransition(R.anim.anim_out,R.anim.anim_in);
    }
    public  void  report(View view){
        Intent intent=new Intent(RequestActivtiy.this,ReportActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.anim_out,R.anim.anim_in);
    }
    public void home(View view){
        Intent intent=new Intent(RequestActivtiy.this,HomeActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.anim_out,R.anim.anim_in);

    }
    public void underConstruction(View v){
        showImageErrorMessage(R.string.label_underConstruction, R.string.label_underConstruction_MessageBlank, R.drawable.underconstruction);
    }

   /* public void showImageErrorMessage(int title, int errorMessage, int imageID) {

        final Dialog dialog = new Dialog(this);
        dialog.getWindow();
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.error_message);
        dialog.getWindow().setBackgroundDrawableResource(R.drawable.curve_shap );
        dialog.setCanceledOnTouchOutside(false);
        ImageView errorMessageImage = (ImageView) dialog.findViewById(R.id.errorImage);
        errorMessageImage.setImageResource(imageID);

        Button okBtn=(Button)dialog.findViewById(R.id.btn_ok);
        okBtn.setText("Ok");

        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });

        dialog.show();


    }*/

   /* protected void showValidations(String msg,String title,String btnName) {
        // Point size = getWindowSize();
        // int width = size.x - (int) getResources().getDimension(R.dimen.dialog_addshelf_width_margin);

        final Dialog dialog = new Dialog(this);
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x - (int) getResources().getDimension(R.dimen.validation_dialog_width_width_margin);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.ok_prompt_popup);
        dialog.getWindow().setLayout(width, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawableResource(R.drawable.my_account_popup_rounded_corner);
        dialog.setCanceledOnTouchOutside(true);
        TextView content = (TextView) dialog.findViewById(R.id.ok_prompt_content);
       *//* frameLayout.setVisibility(View.GONE);*//*
        content.setText(title);
        TextView tvTitle = (TextView) dialog.findViewById(R.id.ok_prompt_title);
        tvTitle.setText(msg);
        Button okBtn = (Button) dialog.findViewById(R.id.ok_prompt_btn_ok);
        okBtn.setText(btnName);
        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();

    }*/

    public void requestForm(View view){

         requestService=(EditText)findViewById(R.id.request_service_req_et);
       // request_select_date
         selectDate=(TextView)findViewById(R.id.request_select_date);
        //request_numOfPersons
         numberOfPersons=(EditText)findViewById(R.id.request_numOfPersons);
        if(ProntoValidations.isEmptyOrNull(requestService.getText().toString())){
            showValidations("Please enter all fields to proceed ","Alert","Ok");

        }else if (!restaurantFlag){
            showValidations("Please enter all fields to proceed ","Alert","Ok");
        }
        else if(ProntoValidations.isEmptyOrNull(selectDate.getText().toString())){
            showValidations("Please enter all fields to proceed ","Alert","Ok");

        }else if(ProntoValidations.isEmptyOrNull(numberOfPersons.getText().toString())){

            showValidations("Please enter all fields to proceed ","Alert","Ok");
        }

        else{
           // Toast.makeText(getApplicationContext(),"Request form details submitted successfully.",Toast.LENGTH_LONG).show();
            showSuccess("Request data submitted successfully");
            resetRequestFields();
        }
    }

    public void resetRequestFields(){

        requestService.setText("");
        selectDate.setText("");
        numberOfPersons.setText("");
        //restaurants=(Spinner)findViewById(R.id.request_hotel_spinner) ;
        restaurants.setSelection(0);


    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(RequestActivtiy.this, HomeActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.anim_in, R.anim.anim_out);
    }

    protected void showSuccess(String str) {
        // Point size = getWindowSize();
        // int width = size.x - (int) getResources().getDimension(R.dimen.dialog_addshelf_width_margin);
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.ok_prompt_popup);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawableResource(R.drawable.my_account_popup_rounded_corner);
        dialog.setCanceledOnTouchOutside(true);
        TextView tvTitle = (TextView) dialog.findViewById(R.id.ok_prompt_title);
       /* FrameLayout frameLayout = (FrameLayout) dialog.findViewById(R.id.image_frame_layout);*/
        TextView content = (TextView) dialog.findViewById(R.id.ok_prompt_content);
       /* frameLayout.setVisibility(View.GONE);*/
        content.setText("Success");//label_Success
        tvTitle.setText(str);
        Button okBtn = (Button) dialog.findViewById(R.id.ok_prompt_btn_ok);
        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
                Intent intent = new Intent(RequestActivtiy.this, HomeActivity.class);
                startActivity(intent);
            }
        });
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();

    }
}
