package com.example.dbdemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class CDB extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_NAME="DMS";
    public CDB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase arg0) {
        arg0.execSQL("create table TbDept(dno integer primary key autoincrement,dname text,dloctext)");

    }
    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
        arg0.execSQL("DROP TABLE IF EXISTS TbDept");
        onCreate(arg0);
    }
    public void addDept(String dn,String d1)
    {
        try
        {
            SQLiteDatabase db=this.getWritableDatabase();
            ContentValues cv=new ContentValues();//key value pair
            cv.put("dname",dn);
            cv.put("dloc",d1);
            db.insert("TbDept",null,cv);
            db.close();
        }catch (Exception e)
        {
            System.out.println(e);
            Log.d("INSERT",e.toString());
        }
    }
    public String[] getOneDepartment(int dno)
    {
        String a[]=new String[2];
        try
        {
            SQLiteDatabase db=this.getReadableDatabase();

            Cursor cursor=db.query("TbDept",new String[]{"dno","dname","dloc"},"dno"+"=?",new
                    String[]{String.valueOf(dno) },null,null,null,null);
            if(cursor !=null && cursor.getCount() !=0)
            {
                cursor.moveToFirst();
                a[0]= cursor.getString(1);
                a[1]= cursor.getString(2);
            }
            else{
                a[0]= "";
                a[1]="";
            }
        }catch(Exception e)
        {
            System.out.println(e);
            Log.d("SELECT :",e.toString());
        }
        return a;
    }
    public int deleteDept(int dno)
    {
        SQLiteDatabase db= this.getWritableDatabase();
        return db.delete("TbDept","dno=?" , new String[] {String.valueOf(dno)});
    }
    public void update(int dno,String dn,String d1)
    {
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues values= new ContentValues();
        values.put("dname",dn);

        values.put("dloc",d1);
        db.update("TbDept",values,"dno=?",new String[]{String.valueOf(dno)});
        db.close();
    }
    public List<CDept> getAllvalues()
    {
        List<CDept> recList=new ArrayList<CDept>();
        String selectQuery ="select * from TbDept";
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery(selectQuery,null);
        if(cursor.moveToFirst()){
            do {
                CDept rec=new CDept();
                rec.id=Integer.parseInt(cursor.getString(0));
                rec.dname=cursor.getString(1);
                rec.dloc= cursor.getString(2);
                recList.add(rec);
            }while(cursor.moveToNext());
        }
        return recList;
    }
}
