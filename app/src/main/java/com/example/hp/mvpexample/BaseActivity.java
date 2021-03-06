package com.example.hp.mvpexample;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public abstract class BaseActivity extends AppCompatActivity {

    private ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    protected void showToast(String msg, int duration){
        Toast.makeText(this, msg, duration).show();
    }

    
    protected void showAlertMessage(String title, String message,
                                    DialogInterface.OnClickListener okClick,
                                    DialogInterface.OnClickListener cancelClick){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButton("OK", okClick);
        builder.setNegativeButton("Cancel", cancelClick);
        builder.create();
        builder.show();
    }

    protected void showProgress(String title, String message){
        dialog = new ProgressDialog(this);
        dialog.setTitle(title);
        dialog.setMessage(message);
        dialog.show();
    }

    protected void hideProgress(){
        if (dialog!=null){
            dialog.dismiss();
        }
    }
}
