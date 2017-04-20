package com.example.yashbohara.project;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.health.PackageHealthStats;
import android.util.Log;

import java.util.ArrayList;

public class Dbhandler extends SQLiteOpenHelper {
    public static final String Name="Name";
    public static final String ContactNumber="ContactNumber";
    public static final String EnrollmentNumber="EnrollmentNumber";
    public static String branch;
    public static final String DatabaseName="dddddd.db";
    public static final int DatabaseVersion =1;
    public Dbhandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DatabaseName, factory, DatabaseVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        for (int j = 0; j < 6; j++) {
            if (j == 0) {
                branch = "CS";
            }
            if (j == 1) {
                branch = "IT";
            }
            if (j == 2) {
                branch = "EX";
            }
            if (j == 3) {
                branch = "ME";
            }
            if (j == 4) {
                branch = "AU";
            }
            if (j == 5) {
                branch = "Ci";
            }
            for (int i = 1; i <= 8; i++) {
                String query1 = "CREATE TABLE " + branch + "A" + i + "(" + Name + " TEXT  , " + ContactNumber + " INTEGER ," + EnrollmentNumber + " TEXT PRIMARY KEY ," + branch + i + "01" + " INTEGER, " + branch+i+"02" + " INTEGER ," + branch+i+"03" + " INTEGER ," + branch+i+"04" + " INTEGER ," + branch+i+"05" + " INTEGER " + ");";
                db.execSQL(query1);
            }
            for (int i = 1; i <= 8; i++) {
                String query2 = "CREATE TABLE " + branch + "B" + i + "(" + Name + " TEXT  , " + ContactNumber + " INTEGER ," + EnrollmentNumber + " TEXT PRIMARY KEY ," + branch + i + "01" + " INTEGER, " + branch+i+"02" + " INTEGER ," + branch+i+"03" + " INTEGER ," + branch+i+"04" + " INTEGER ," + branch+i+"05" + " INTEGER " + ");";
                db.execSQL(query2);
            }

            for (int i = 1; i <= 8; i++) {
                String query3 = "CREATE TABLE " + branch + "C" + i + "(" + Name + " TEXT  , " + ContactNumber + " INTEGER ," + EnrollmentNumber + " TEXT PRIMARY KEY ," + branch + i + "01" + " INTEGER, " + branch+i+"02" + " INTEGER ," + branch+i+"03" + " INTEGER ," + branch+i+"04" + " INTEGER ," + branch+i+"05" + " INTEGER " + ");";
                db.execSQL(query3);
            }


            for (int i = 1; i <= 8; i++) {
                String query4 = "CREATE TABLE " + branch + "D" + i + "(" + Name + " TEXT  , " + ContactNumber + " INTEGER ," + EnrollmentNumber + " TEXT PRIMARY KEY ," + branch + i + "01" + " INTEGER, " + branch+i+"02" + " INTEGER ," + branch+i+"03" + " INTEGER ," + branch+i+"04" + " INTEGER ," + branch+i+"05" + " INTEGER " + ");";
                db.execSQL(query4);
            }

            for (int i = 1; i <= 8; i++) {
                String query5 = "CREATE TABLE " + branch + "E" + i + "(" + Name + " TEXT  , " + ContactNumber + " INTEGER ," + EnrollmentNumber + " TEXT PRIMARY KEY ," + branch + i + "01" + " INTEGER, " + branch+i+"02" + " INTEGER ," + branch+i+"03" + " INTEGER ," + branch+i+"04" + " INTEGER ," + branch+i+"05" + " INTEGER " + ");";
                db.execSQL(query5);
            }
        }
        String q="CREATE TABLE TEACHERS(Name TEXT, Id TEXT PRIMARY KEY, Branch TEXT);";
        db.execSQL(q);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        for (int j = 0; j < 6; j++) {
            if (j == 0) {
                branch = "CS";
            }
            if (j == 1) {
                branch = "IT";
            }
            if (j == 2) {
                branch = "EX";
            }
            if (j == 3) {
                branch = "ME";
            }
            if (j == 4) {
                branch = "AU";
            }
            if (j == 5) {
                branch = "Ci";
            }
            for (int i = 0; i < 8; i++) {
                db.execSQL("DROP TABLE IF EXISTS " + branch + "A" + i);
                db.execSQL("DROP TABLE IF EXISTS " + branch + "B" + i);
                db.execSQL("DROP TABLE IF EXISTS " + branch + "C" + i);
                db.execSQL("DROP TABLE IF EXISTS " + branch + "D" + i);
                db.execSQL("DROP TABLE IF EXISTS " + branch + "E" + i);
            }
            onCreate(db);
        }
    }


    public void AddProduct(String  branch ,String section ,String semester ,String Name ,String EnrollmentNumber)
    {
        SQLiteDatabase db=getWritableDatabase();

        ContentValues values=new ContentValues();
        values.put("Name",Name);
        values.put("ContactNumber",11);
        values.put("EnrollmentNumber",EnrollmentNumber);
        values.put(branch+semester+"01",0);
        values.put(branch+semester+"02",0);
        values.put(branch+semester+"03",0);
        values.put(branch+semester+"04",0);
        values.put(branch+semester+"05",0);
        //String q1="INSERT INTO "+branch+section+semester+" WHERE VALUES ("+Name +" , " + " 0, "+EnrollmentNumber + ", 0 " + " ,0 " + " ,0 " + " ,0 " + " ,0 "+" );";
db.insert(branch+section+semester,null,values);
        db.close();
        //db.execSQL(q1);

    }
    public void AddFaculty(String Name,String Id,String Branch)
    {
        SQLiteDatabase db=getWritableDatabase();

        ContentValues value=new ContentValues();
        value.put("Name",Name);
        value.put("Id",Id);
        value.put("Branch",Branch);

        db.insert("TEACHERS",null,value);
        db.close();
    }

public String RetrieveFaculty(String id)
{
    SQLiteDatabase db=getWritableDatabase();

    String q1="SELECT Name FROM TEACHERS WHERE Id='"+id+"';";
    String op="";
    Cursor cursor=db.rawQuery(q1,null);
    cursor.moveToFirst();
    while (!cursor.isAfterLast())
    {
        if (cursor.getString(cursor.getColumnIndex(Name))!=null)
        {
            op=cursor.getString(cursor.getColumnIndex(Name));
        }
        cursor.moveToNext();
    }
    db.close();
    return op;

}
public String Extract(String  branch ,String section ,String semester , String EnrollmentNumber,String SubjectCode)
{
    String Result="0";
    SQLiteDatabase db=getWritableDatabase();
    String q3="SELECT "+ SubjectCode+" FROM "+ branch+section+semester+" WHERE EnrollmentNumber ='"+EnrollmentNumber+"';";
    Cursor cursor=db.rawQuery(q3,null);
    cursor.moveToFirst();
    while (!cursor.isAfterLast())
    {
        if (cursor.getString(cursor.getColumnIndex(SubjectCode))!=null)
        {
            Result=cursor.getString(cursor.getColumnIndex(SubjectCode));
        }
        cursor.moveToNext();
    }
    Log.e("hello",Result);
    db.close();
    return Result;
}

public ArrayList<String> databaseToString(String Branch,String Section,String Semester)
{
    ArrayList<String> dbString=new ArrayList<String>();
    SQLiteDatabase db=getWritableDatabase();
    String query="SELECT * FROM " + Branch+Section+Semester + ";";
    Cursor c=db.rawQuery(query,null);
    c.moveToFirst();

    while (!c.isAfterLast())
    {
        if (c.getString(c.getColumnIndex("EnrollmentNumber"))!=null)
        {
            dbString.add(c.getString(c.getColumnIndex("EnrollmentNumber")));
        }
        c.moveToNext();
    }
    db.close();
    return dbString;
}
    public int Retrieve(String Branch, String Section, String Semester, String Code, String checkbox) {
        int result=0;
        SQLiteDatabase db = getWritableDatabase();
        String q = "SELECT " + Branch+Semester+Code + " FROM " + Branch + Section + Semester + " WHERE EnrollmentNumber='" + checkbox + "'";
        Cursor cursor = db.rawQuery(q, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            if (cursor.getString(cursor.getColumnIndex(Branch+Semester+Code)) != null) {
                result = cursor.getInt(cursor.getColumnIndex(Branch+Semester+Code));
            }
            cursor.moveToNext();
        }
        Log.e("result", String.valueOf(result));
        return result;
    }
    public void Update(String Branch, String Section, String Semester, String Code, String checkbox) {
        int a;
        a=Retrieve(Branch,Section,Semester,Code,checkbox);
        a++;
        Log.e("a", String.valueOf(a));
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("UPDATE " + Branch+Section+Semester + " SET "+Branch+Semester+Code+" ='"+a+"' WHERE EnrollmentNumber='"+checkbox+"';");

    }
    public void Update2(String Branch, String Section, String Semester, String Code, String checkbox) {
        int a;
        a=Retrieve(Branch,Section,Semester,Code,checkbox);
        a--;
        Log.e("a", String.valueOf(a));
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("UPDATE " + Branch+Section+Semester + " SET "+Branch+Semester+Code+" ='"+a+"' WHERE EnrollmentNumber='"+checkbox+"';");

    }
    public String RetrieveStudent(String Semester,String Branch,String Section,String RollNo)
    {
        String ba="";
        SQLiteDatabase db = getWritableDatabase();
        String q2="SELECT * FROM "+Branch+Section+Semester+" WHERE EnrollmentNumber='"+RollNo+"';";
        Cursor cursor=db.rawQuery(q2,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast())
        {
            if(cursor.getString(cursor.getColumnIndex("EnrollmentNumber"))!=null)
            {
                ba=cursor.getString(cursor.getColumnIndex("Name"));
            }
            cursor.moveToNext();
        }
    return ba;
    }
}