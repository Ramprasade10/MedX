package com.example.ramprasad.medx;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

/**
 * Created by Ramprasad on 24-01-2017.
 */

public class Diagnostics extends AppCompatActivity {


    TextView tv;
    CheckBox common_cold,cough,chest,weakness,nausea,bodymuscle,red_eyes,throat,headache;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diagnostics);
        tv=(TextView)findViewById(R.id.result);
common_cold=(CheckBox)findViewById(R.id.commonc);
        cough=(CheckBox)findViewById(R.id.cough);
        headache=(CheckBox)findViewById(R.id.headache);
        chest=(CheckBox)findViewById(R.id.chestpain);
        weakness=(CheckBox)findViewById(R.id.weakness);
        nausea=(CheckBox)findViewById(R.id.nnv);
        bodymuscle=(CheckBox)findViewById(R.id.Bodymuscle);
        red_eyes=(CheckBox)findViewById(R.id.redeyes);
        throat=(CheckBox)findViewById(R.id.throatpain);
        // Spinner click listener


}
public void diag(View v){
    if(common_cold.isChecked()==true && headache.isChecked()==true && cough.isChecked()==true) {
        tv.setText("You've been diagnoised with Mild Fever");
    }

    else if(weakness.isChecked()==true && red_eyes.isChecked()==true &&headache.isChecked()==true){
        tv.setText("You've been diagnoised with High Fever");
    }
    else if(nausea.isChecked()==true&&red_eyes.isChecked()==true){
        tv.setText("Youve been diagnoised with Food poisioning");
    }

    else if(throat.isChecked()==true &&headache.isChecked()==true&&red_eyes.isChecked()==true){
        tv.setText("You've been dignoised with viral fever");
    }
    else if ( headache.isChecked()==true &&chest.isChecked() ==true){
        tv.setText("You've been diagonised with Pneumonia");
    }

    else if (  throat.isChecked()==true && common_cold.isChecked()==true ){
        tv.setText("You've been diagonised with Pneumonia");
    }
    else{
        tv.setText("You've been diagonised with Bronchitis");
    }
}
}
