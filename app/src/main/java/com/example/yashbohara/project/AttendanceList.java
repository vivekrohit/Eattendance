package com.example.yashbohara.project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import static com.example.yashbohara.project.M1.dbhandler;

public class AttendanceList extends AppCompatActivity {
ListView l1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance_list);
        Bundle bundle=getIntent().getExtras();
        String b1=bundle.getString("s1");
        String b2=bundle.getString("s2");
        String b3=bundle.getString("s3");
        String b4=bundle.getString("s4");
        ArrayList<String> list=dbhandler.databaseToString(b1,b2,b3);
        ListAdapter listAdapter=new CustomAdapter(this,list);
        l1=(ListView) findViewById(R.id.l1);
        l1.setAdapter(listAdapter);
    }
    public void On_Clicked(View view)
    {
        //dbhandler.
    }
}
