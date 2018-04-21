package com.example.ramprasad.medx;

import android.database.sqlite.SQLiteDatabase;
        import android.database.sqlite.SQLiteOpenHelper;
        import android.content.Context;
        import android.database.Cursor;
public class DB1 extends SQLiteOpenHelper {
    static String dbname="Register",table="userdetails";
    public DB1(Context context){
        super(context,dbname,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String qry="CREATE TABLE IF NOT EXISTS "+table+" (name VARCHAR(20), username VARCHAR(15), password VARCHAR(20),phno NUMBER(10))";
        db.execSQL(qry);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String qry="DROP TABLE IF EXISTS "+table;
        db.execSQL(qry);
        onCreate(db);
        db.close();
    }
    public Cursor login(String uname){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor csr=db.rawQuery("SELECT * FROM "+table+" WHERE username = '"+uname+"' ",null);


        return csr;
    }
    public Cursor checkun(String a){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor chk=db.rawQuery("SELECT * FROM "+table+" WHERE username = '"+a+"' ",null);
        return chk;
    }
    public void insert(String name,String uname,String pwd,String ph){
        SQLiteDatabase db=this.getWritableDatabase();
        String sql="INSERT INTO "+table+" VALUES('"+name+"', '"+uname+"', '"+pwd+"', '"+ph+"')";
        db.execSQL(sql);
        db.close();

    }

}
