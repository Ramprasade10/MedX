package com.example.ramprasad.medx;

/**
 * Created by Ramprasad on 25-01-2017.
 */



        import android.app.Activity;
        import android.content.Intent;
        import android.database.Cursor;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.TextView;
        import android.widget.Toast;


public class Login extends Activity {
    EditText username,password;static String respwd;
    TextView tv_login;
    Button login,create_acc;
    String un="";
    private DB1 db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        username=(EditText)findViewById(R.id.username);
        password=(EditText)findViewById(R.id.password);
        tv_login=(TextView)findViewById(R.id.tv_login);
        login=(Button)findViewById(R.id.btn_login);
        create_acc=(Button)findViewById(R.id.btn_create_account);
        db=new DB1(this);
    }
    public void login(View v){
        String uname,pwd;
        uname=username.getText().toString();
        pwd=password.getText().toString();
        Cursor c=db.login(uname);

        while (c.moveToNext()) {

            String respwd1=c.getString(c.getColumnIndex("password"));
            this.respwd=respwd1;
        }
        if(uname.length()==0){
            Toast.makeText(this,"Please Enter Username",Toast.LENGTH_SHORT).show();
        }
        else if(pwd.length()==0){
            Toast.makeText(this,"Please Enter Password",Toast.LENGTH_SHORT).show();
        }

        else if( pwd.equals(respwd)){
            Toast.makeText(this,"Login Successful",Toast.LENGTH_LONG).show();
un=uname;
            Intent a =new Intent(this,MainInter.class);
            startActivity(a);
        }
        else{


            Toast.makeText(this,"Login Un-Successful,Please Check Username and Password",Toast.LENGTH_LONG).show();

        }
    }

    public void create_account(View v){
        Intent login=new Intent(this,Register.class);
        startActivity(login);

    }


}
