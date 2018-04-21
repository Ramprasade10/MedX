package com.example.ramprasad.medx;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Ramprasad on 25-01-2017.
 */

public class MainInter extends AppCompatActivity {

   Button diag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_inter);


    }
    public void diag(View v){
        Intent a =new Intent(this,Diagnostics.class);
        startActivity(a);
    }
    public void reminder(View v){
        Intent a =new Intent(this,Reminder.class);
        startActivity(a);
    }
    public void doctor(View v){
        Intent a =new Intent(this,Doctor.class);
        startActivity(a);
    }
}
