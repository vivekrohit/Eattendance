package com.example.yashbohara.project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import static com.example.yashbohara.project.M1.dbhandler;

public class ViewClassReport extends AppCompatActivity {
ListView l2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_class_report);
        TextView t8=(TextView) findViewById(R.id.textView8);
        TextView t9=(TextView) findViewById(R.id.textView9);
        TextView t10=(TextView) findViewById(R.id.textView10);
        TextView t11=(TextView) findViewById(R.id.textView11);
        TextView t12=(TextView) findViewById(R.id.textView12);
        Bundle bundle=getIntent().getExtras();
        String a=bundle.getString("s1");
        String b=bundle.getString("s2");
        String c=bundle.getString("s3");
        t8.setText(b+a+"02");
        t9.setText(b+a+"03");
        t10.setText(b+a+"04");
        t11.setText(b+a+"05");
        t12.setText(b+a+"01");
        ArrayList<String> list2=dbhandler.databaseToString(b,c,a);
        ListAdapter listAdapter2=new CustomAdapter2(this,list2);
        l2=(ListView) findViewById(R.id.l2);
        l2.setAdapter(listAdapter2);
//       obj1=new ViewClassReport();

    }

}
