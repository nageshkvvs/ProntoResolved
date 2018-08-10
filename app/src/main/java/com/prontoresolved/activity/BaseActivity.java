package com.prontoresolved.activity;

import android.Manifest;
import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.prontoresolved.exceptions.ProntoResolvedAppNetworkFailureException;
import com.testdemo.com.prontoresolved.R;

import org.json.JSONException;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.UUID;

/**
 * Created by nageshk on 11/9/2017.
 */
public abstract class BaseActivity extends AppCompatActivity {

    protected String uniqueDeviceID = "";
    private String prontoUUIDStorageKey = "prontoUUID";
    protected Context context;
    public static  String firstName;
    public static String lastName;
    public abstract void _onCreateOfActivity(Bundle savedInstanceState) throws JSONException, ProntoResolvedAppNetworkFailureException;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        context = getApplicationContext();

        if (uniqueDeviceID.length() == 0) {
            if (loadUUID().length() == 0) {
                createUUID();
                uniqueDeviceID = loadUUID();
            } else {
                uniqueDeviceID = loadUUID();
            }
        }
        ;

//        SayUtil.overrideFont(getApplicationContext(), "SERIF", "fonts/calibri.otf");
//        setApplicationLanguage();
        // context management
        super.onCreate(savedInstanceState);
        // Animation functionality
        //overridePendingTransition(R.anim.anim_out, R.anim.anim_in);

      //  setUPActionBar();


        // execute sub class actions
        try {
            //getServiceToken();

            _onCreateOfActivity(savedInstanceState);
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ProntoResolvedAppNetworkFailureException e) {
            showNetworkError();
        }


    }

    public void showNetworkError() {
        Toast.makeText(this,
                "Network error : ",
                Toast.LENGTH_SHORT).show();
    }

    public String loadUUID() {

        String uuID = "";
        try {
            FileInputStream fin = openFileInput(prontoUUIDStorageKey);
            int c;
            while ((c = fin.read()) != -1) {
                uuID = uuID + Character.toString((char) c);
            }
        } catch (Exception e) {
        }
        return uuID;
    }

    public void createUUID() {
        UUID uuid = UUID.randomUUID();
        String data = uuid.toString().trim();
        try {
            FileOutputStream fOut = openFileOutput(prontoUUIDStorageKey, MODE_WORLD_READABLE);
            fOut.write(data.getBytes());
            fOut.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getLastName() {
        return lastName;
    }

    public static String getFirstName() {
        return firstName;
    }

    public static void setLastName(String lastName) {
        BaseActivity.lastName = lastName;
    }

    public static void setFirstName(String firstName) {
        BaseActivity.firstName = firstName;
    }
    /* public void setUPActionBar() {

        ActionBar actionBar = getActionBar();

        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);
    }*/
    public void showImageErrorMessage(int title, int errorMessage, int imageID) {

        final Dialog dialog = new Dialog(this);
        dialog.getWindow();
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.error_message);
        dialog.getWindow().setBackgroundDrawableResource(R.drawable.curve_shap);
        dialog.setCanceledOnTouchOutside(false);
        ImageView errorMessageImage = (ImageView) dialog.findViewById(R.id.errorImage);
        errorMessageImage.setImageResource(imageID);

        Button okBtn = (Button) dialog.findViewById(R.id.btn_ok);
        okBtn.setText("Ok");

        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });

        dialog.show();


    }
    protected void showValidations(String msg,String title,String btnName) {
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
       /* frameLayout.setVisibility(View.GONE);*/
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

    }

    public void contact(){
        LayoutInflater li = LayoutInflater.from(context);
        View promptsView = li.inflate(R.layout.prompt, null);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                this);
        //alertDialogBuilder.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT)
        //alertDialogBuilder.get
        // set prompts.xml to alertdialog builder
        alertDialogBuilder.setView(promptsView);
        //alertDialogBuilder.


        // set dialog message
        alertDialogBuilder
                .setCancelable(false)
                .setPositiveButton("Call",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                // get user input and set it to result
                                // edit text
                                //result.setText(userInput.getText());
                                Intent phoneIntent = new Intent(Intent.ACTION_CALL);
                                phoneIntent.setData(Uri.parse("tel:91-000-000-0000"));
                                if (ActivityCompat.checkSelfPermission(context,
                                        Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                                    return;
                                }
                                startActivity(phoneIntent);
                            }
                        })
                .setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                dialog.cancel();
                            }
                        });

        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.getWindow().setBackgroundDrawableResource(R.drawable.my_account_popup_rounded_corner);
        // show it
        alertDialog.show();
    }

//    public void showLogoutPrompt() {
//        Display display = getWindowManager().getDefaultDisplay();
//        Point size = new Point();
//        display.getSize(size);
//        //int width = size.x - (int) getResources().getDimension(R.dimen.dialog_addshelf_width_margin);
//        final Dialog dialog = new Dialog(this);
//        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//        dialog.setContentView(R.layout.prompt);
//        //dialog.getWindow().setLayout(width, ViewGroup.LayoutParams.WRAP_CONTENT);
//        dialog.getWindow().setBackgroundDrawableResource(R.drawable.my_account_popup_rounded_corner);
//        dialog.setCanceledOnTouchOutside(false);
//        dialog.setCancelable(false);
//
////        TextView tvTitle = (TextView) dialog.findViewById(R.id.confirm_prompt_title);
////        tvTitle.setText(context.getString(R.string.label_logout_logout));
////
////        TextView tvDesc = (TextView) dialog.findViewById(R.id.confirm_prompt_content);
////        tvDesc.setText(context.getString(R.string.label_areyousuretologout));
////
////        ImageView ivAction = (ImageView) dialog.findViewById(R.id.iv_confirm_prompt_action);
////        ivAction.setVisibility(View.GONE);
//
//        Button saveBtn = (Button) dialog.findViewById(R.id.confirm_prompt_btn_yes);
//        saveBtn.setText(context.getString(R.string.label_Yes));
//
//        Button discardBtn = (Button) dialog.findViewById(R.id.confirm_prompt_btn_no);
//        discardBtn.setText(context.getString(R.string.label_No));
//
//        discardBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                setDialogShown(false);
//                dialog.cancel();
//                return;
//            }
//        });
//
//        saveBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                try {
//
//                    setDialogShown(false);
//                    dialog.cancel();
//                    if (!SayInternetManager.haveNetworkConnection(getApplicationContext())) {
//                        showValidationFailureForInternet(context.getString(R.string.label_no_connection), context.getString(R.string.label_communication_problem));
//                    } else {
//                        logout();
//                    }
//
//
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//        setDialogShown(true);
//        dialog.show();
//
//    }
}
