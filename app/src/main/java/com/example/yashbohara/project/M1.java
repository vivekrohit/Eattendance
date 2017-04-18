package com.example.yashbohara.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class M1 extends AppCompatActivity {
    public static Dbhandler dbhandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m1);
    dbhandler=new Dbhandler(this,null,null,1);
    }
    public void Admin_Clicked(View view)
    {
        Intent intent1=new Intent(this,Admin_Login.class);
        startActivity(intent1);
    }
    public void Faculty_Clicked(View view)
    {
        Intent intent2=new Intent(this,Faculty_Login.class);
        startActivity(intent2);
    }
    public void Student_Clicked(View view)
    {
        Intent intent3=new Intent(this,Student_Login.class);
        startActivity(intent3);
    }
}
