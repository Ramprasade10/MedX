package com.example.ramprasad.medx;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ramprasad on 25-01-2017.
 */

public class Doctor extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
Spinner s1,s2,s3;
    @Override

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.doctor);

        Spinner spinner1 = (Spinner) findViewById(R.id.spinner1);
        Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);
        Spinner spinner3 = (Spinner) findViewById(R.id.spinner3);
        // Spinner click listener


        // Spinner Drop down elements
        List<String> categories1 = new ArrayList<String>();
        categories1.add("Apollo White Dental : Dr. Ravi  Shanthraj");//9am
        categories1.add("Mysore Dental Clinic : Dr. Pradeep Subbaiah");//2:30
        categories1.add("entral Dental Clinic : Dr. Sanath Hegde");//9:30



        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories1);

        // Drop down layout style - list view with radio button
        dataAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner1.setAdapter(dataAdapter1);

        // Spinner Drop down elements
        List<String> categories2 = new ArrayList<String>();

        categories2.add("Vikram Perfect : Dr. Jayadev B");//9am
        categories2.add("Apollo Clinic : Dr. Praveen ");//2:30
        categories2.add("Columbia Asia : Dr. Devraja R");//9:30


        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories2);

        // Drop down layout style - list view with radio button
        dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(dataAdapter2);

        // Spinner Drop down elements
        List<String> categories3 = new ArrayList<String>();
        categories3.add("Cauvery Hospital : Dr. Nagraja Desai");//9am
        categories3.add("Simha Heart Foundation : >Dr. C B Keshavamurthy");//2:30
        categories3.add("JSS Hospital : Dr. S. Parameshwarappa");//9:30



        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories3);

        // Drop down layout style - list view with radio button
        dataAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner3.setAdapter(dataAdapter3);


    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {



    }
    public void check(View v){
        Uri gmmIntentUri = Uri.parse("geo:0,0?q=hospitals");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);
    }
    public void checkup(View v){
        Toast.makeText(getApplicationContext(),"Your Check Up has been Confirmed !! You will be contacted soon! ",Toast.LENGTH_LONG).show();
    }

    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }

}