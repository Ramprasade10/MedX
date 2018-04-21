package com.example.ramprasad.medx;
        import android.database.sqlite.SQLiteDatabase;
        import android.database.sqlite.SQLiteOpenHelper;
        import android.content.Context;
        import android.database.Cursor;
        import android.util.Log;

public class DB extends SQLiteOpenHelper {
    static String dbname="Register",table="patientdetails";
    public DB(Context context){
        super(context, dbname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String qry="CREATE TABLE IF NOT EXISTS "+table+" (uname VARCHAR(15),pillname VARCHAR(25),doct VARCHAR(20),time VARCHAR(25))";

        db.execSQL(qry);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String qry="DROP TABLE IF EXISTS "+table;
        db.execSQL(qry);
        onCreate(db);

    }
    public void create(){
        SQLiteDatabase db=this.getWritableDatabase();
        String qry1="CREATE TABLE IF NOT EXISTS "+table+" (name VARCHAR(20),description VARCHAR(250),day VARCHAR(2),month VARCHAR(5),year VARCHAR(4))";


        db.execSQL(qry1);

    }


    public Cursor search111(String pname,String day,String month,String year){

        SQLiteDatabase db=this.getReadableDatabase();

        Cursor chk=db.rawQuery("SELECT * FROM " + table + " WHERE name like '%" + pname + "%' AND day = '" + day + "' AND month ='" + month + "'  AND year ='" + year + "'", null);

        if(chk.getCount() != 0){
            Log.e("Db yes","db yes");}
        if(chk.getCount() == 0){
            Log.e("db no","db no");}
        return chk;
    }


    public boolean insert(String name,String pill,String doct,String time){try{
        SQLiteDatabase db=this.getWritableDatabase();
        String sql="INSERT INTO "+table+" VALUES('"+name+"','"+pill+"','"+doct+"','"+time+"')";
        db.execSQL(sql);

    }
    catch(Exception e)
    {
        Log.e("eror", "err", e);
    }

        return true;
    }

}

