package com.example.yashbohara.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

import static com.example.yashbohara.project.M1.dbhandler;

public class TakeAttendance extends AppCompatActivity {
//ListView l1;
    //Button b1=(Button) findViewById(R.id.b1);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_attendance);
        }
public void TakeAttendance_Clicked(View view)
{
    Spinner s101=(Spinner) findViewById(R.id.s101);
    Spinner s102=(Spinner) findViewById(R.id.s102);
    Spinner s103=(Spinner) findViewById(R.id.s103);
    Spinner s104=(Spinner) findViewById(R.id.s104);
    Intent i=new Intent(this,AttendanceList.class);
    i.putExtra("s1",s101.getSelectedItem().toString());
    i.putExtra("s2",s102.getSelectedItem().toString());
    i.putExtra("s3",s103.getSelectedItem().toString());
    i.putExtra("s4",s104.getSelectedItem().toString());
    startActivity(i);

}

    @Override
    public void onBackPressed() {
        Intent intent=new Intent(this,Faculty_Functions.class);
        startActivity(intent);
        this.finish();
    }
}
