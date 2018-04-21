package com.example.ramprasad.medx;

/**
 * Created by Ramprasad on 24-01-2017.
 */

import android.app.Activity;
import android.app.NotificationManager;
import android.content.Intent;


import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class Reminder extends Activity implements AdapterView.OnItemSelectedListener {
    private DB db; Button remind ;EditText pill,doc;String itm="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db=new DB(this);
        setContentView(R.layout.reminder);
       remind=(Button)findViewById(R.id.remind);
         pill=(EditText)findViewById(R.id.pill);
         doc=(EditText)findViewById(R.id.doc);
        // Spinner element
        Spinner spinner = (Spinner) findViewById(R.id.spinner);

        // Spinner click listener
        spinner.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();

        categories.add("Morning");//9am
        categories.add("Afternoon");//2:30
        categories.add("Night");//9:30


        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();
itm=item;
        // Showing selected spinner item




Login a=new Login();
        //db.insert(a.un,pill.toString(),doc.toString(),time);
        Intent i=new Intent(this,MainInter.class);

                // Set PendingIntent into Notification

                // Set RemoteViews into Notification



        // Create Notification Manager





    }
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }
    public void remind(View v){
        String time="";
        if(itm=="Morning"){
            time="9 am";
        }
        if(itm=="Afternoon"){
            time="2:30 pm";
        }
        if(itm=="Night"){
            time="10 pm";
        }
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this).setContentText("Please Take Your Pill "+pill.getText().toString()+" as prescribed by "+doc.getText().toString()+" at "+time)

                .setSmallIcon(R.drawable.icon)

                .setAutoCancel(true);
        NotificationManager notificationmanager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        // Build Notification with Notification Manager
        notificationmanager.notify(0, builder.build());
    }
    }
