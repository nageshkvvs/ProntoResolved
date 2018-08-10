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
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.github.jjobes.slidedatetimepicker.SlideDateTimeListener;
import com.github.jjobes.slidedatetimepicker.SlideDateTimePicker;
import com.prontoresolved.validations.ProntoValidations;
import com.testdemo.com.prontoresolved.R;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by venkatarao.g on 3/6/2018.
 */

public class ReportActivity extends BaseActivity {
    TextView tv;
    TextView selectDate;
    EditText  reportDetails;
    @Override
    public void _onCreateOfActivity(Bundle savedInstanceState) {
   //     super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        tv=(TextView)findViewById(R.id.report_select_date) ;
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy, HH:mm a");
        dateFormat.format(date);
        tv.setText(dateFormat.format(date).toString());
    }

    /*public void showDatePicker(View view){
      *//* final LinearLayout guestInfo=(LinearLayout)findViewById(R.id.ll_datepicker);*//*
        //
        tv = (TextView)view;
        Animation showAnim = AnimationUtils.loadAnimation(this, R.anim.slide_in_top);
        boolean isDateSet = false;

        new SlideDateTimePicker.Builder(getSupportFragmentManager())
                .setListener(listener)
                .setInitialDate(new Date())
                .build()
                .show();

    }
    private SlideDateTimeListener listener = new SlideDateTimeListener() {

        @Override
        public void onDateTimeSet(Date date)
        {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            dateFormat.format(date);
            tv.setText(dateFormat.format(date).toString());
            // tv.setText(date.toString());
        }

        @Override
        public void onDateTimeCancel()
        {
            // Overriding onDateTimeCancel() is optional.
        }
    };*/
    public  void  request(View view){
        Intent intent=new Intent(ReportActivity.this,RequestActivtiy.class);
         startActivity(intent);
         overridePendingTransition(R.anim.anim_out,R.anim.anim_in);
    }
    public  void  report(View view){
        //Intent intent=new Intent(HomeActivity.this,RequestActivtiy.class);
        // startActivity(intent);
        // overridePendingTransition(R.anim.anim_out,R.anim.anim_in);
    }
    public void home(View view){
        Intent intent=new Intent(ReportActivity.this,HomeActivity.class);
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
public void reportForm(View view){
    //report_select_date
     selectDate=(TextView)findViewById(R.id.report_select_date);
    //report_service_req_et
      reportDetails=(EditText)findViewById(R.id.report_service_req_et);
    if(ProntoValidations.isEmptyOrNull(selectDate.getText().toString())){
        showValidations("Please enter all fields to proceed ","Alert","Ok");

    }else if(ProntoValidations.isEmptyOrNull(reportDetails.getText().toString())){
        showValidations("Please enter all fields to proceed ","Alert","Ok");
    }else{
        //Toast.makeText(getApplicationContext(),"Report data  submitted successfully.",Toast.LENGTH_LONG).show();

        showSuccess("Report data  submitted successfully");
        resetReportFields();
    }

}

    public void resetReportFields(){
        selectDate.setText("");
        reportDetails.setText("");
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
                Intent intent = new Intent(ReportActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();

    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(ReportActivity.this, HomeActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.anim_in, R.anim.anim_out);
    }
}
