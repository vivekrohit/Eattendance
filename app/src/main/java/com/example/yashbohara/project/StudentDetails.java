package com.example.yashbohara.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import static com.example.yashbohara.project.M1.dbhandler;

public class StudentDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_details);
        Bundle bundle=getIntent().getExtras();
        String Name=bundle.getString("i1");
        String Semester=bundle.getString("i2");
        String Branch=bundle.getString("i4");
        String Section=bundle.getString("i5");
        String RollNo=bundle.getString("i3");
        TextView t121=(TextView) findViewById(R.id.t121);
        TextView t1=(TextView) findViewById(R.id.t1);
        TextView t2=(TextView) findViewById(R.id.t2);
        TextView t3=(TextView) findViewById(R.id.t3);
        TextView t4=(TextView) findViewById(R.id.t4);
        TextView t5=(TextView) findViewById(R.id.t5);
        TextView t6=(TextView) findViewById(R.id.t6);
        TextView t7=(TextView) findViewById(R.id.t7);
        TextView t8=(TextView) findViewById(R.id.t8);
        TextView t9=(TextView) findViewById(R.id.t9);
        TextView t10=(TextView) findViewById(R.id.t10);
        t121.setText(Name);
        t1.setText(Branch+Semester+"01");
        t3.setText(Branch+Semester+"02");
        t5.setText(Branch+Semester+"03");
        t7.setText(Branch+Semester+"04");
        t9.setText(Branch+Semester+"05");
        t2.setText(dbhandler.Extract(Branch,Section,Semester,RollNo,Branch+Semester+"01").toString());
        t4.setText(dbhandler.Extract(Branch,Section,Semester,RollNo,Branch+Semester+"02").toString());
        t6.setText(dbhandler.Extract(Branch,Section,Semester,RollNo,Branch+Semester+"03").toString());
        t8.setText(dbhandler.Extract(Branch,Section,Semester,RollNo,Branch+Semester+"04").toString());
        t10.setText(dbhandler.Extract(Branch,Section,Semester,RollNo,Branch+Semester+"05").toString());

    }

    @Override
    public void onBackPressed() {
        Intent intent=new Intent(this,M1.class);
        startActivity(intent);
        this.finish();
    }
}
