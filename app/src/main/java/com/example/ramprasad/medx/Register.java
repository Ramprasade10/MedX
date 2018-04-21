package com.example.ramprasad.medx;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Ramprasad on 3/15/2015.
 */
public class Register extends Activity{
    Button create,back;
    EditText pname,username,pwd1,pwd2,phno;int max = 100000;
    /*  50: 22 */   int min = 10000;
    private DB1 db;String notuser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        create=(Button)findViewById(R.id.create);
        back=(Button)findViewById(R.id.back);
        pname=(EditText)findViewById(R.id.name);
        username=(EditText)findViewById(R.id.username);
        pwd1=(EditText)findViewById(R.id.pwd1);
        pwd2=(EditText)findViewById(R.id.pwd2);
        phno=(EditText)findViewById(R.id.phno);
        db=new DB1(this);

        username.addTextChangedListener(new TextWatcher(){

            public void afterTextChanged(Editable s) {
                String un=s.toString();
                Cursor chk=db.checkun(un);
                if(chk!=null && chk.getCount()>0){
                    Toast.makeText(getApplicationContext(),"The Username is already taken!!",Toast.LENGTH_SHORT).show();

                }
            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after){}
            public void onTextChanged(CharSequence s, int start, int before, int count){}
        });

    }
    public void create(View v)
    {
        String pw1=pwd1.getText().toString();
        String pw2=pwd2.getText().toString();
        String uname=username.getText().toString();
        String ph=phno.getText().toString();
        String name=pname.getText().toString();





/* 241:216 */   String un=uname.toString();

        Cursor chk=db.checkun(un);
        if (name.length()==0) {
/* 249:225 */         Toast.makeText(this,"Please Enter Your Name",Toast.LENGTH_SHORT).show();
/* 250:    */       }
/* 248:224 */       else if (uname.length()==0) {
/* 249:225 */         Toast.makeText(this,"Please Enter a UserName",Toast.LENGTH_SHORT).show();
/* 250:    */       }
        else if(chk!=null && chk.getCount()>0){
            Toast.makeText(getApplicationContext(),"The Username is already taken!!",Toast.LENGTH_SHORT).show();
        }
        else if (pw1.length()==0) {
/* 249:225 */          Toast.makeText(this, "Please Enter Password", Toast.LENGTH_SHORT).show();
/* 250:    */       }
        else if (pw2.length()==0) {
/* 249:225 */          Toast.makeText(this, "Please Confirm your password", Toast.LENGTH_SHORT).show();
/* 250:    */       }
/* 251:228 */       else if (!pw1.equals(pw2)) {
/* 252:230 */         Toast.makeText(this, "Passwords did not match", Toast.LENGTH_SHORT).show();

/* 253:    */       }
/* 254:232 */
/* 257:236 */
/* 260:241 */
        else if(ph.length()<10){
            Toast.makeText(this, "Enter a correct phone number", Toast.LENGTH_SHORT).show();
        }

/* 264:    */       else
/* 265:    */       {
/* 266:246 */
/* 268:248 */
/* 269:    */         try
/* 270:    */         {

                db.insert(name,uname,pw1,ph);
                db.close();
                Toast.makeText(this,"Registration Successful!!",Toast.LENGTH_LONG).show();
            }
            catch(Exception e){
                Log.e("Exception","Exception",e);
                Toast.makeText(this,"Registration Un-Successful,Try Again",Toast.LENGTH_SHORT);
            }
        }}
    public void back(View v){
        Intent back=new Intent(this,Login.class);
        startActivity(back);
    }
}
