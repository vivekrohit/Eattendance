package com.example.yashbohara.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Faculty_Functions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty__functions);
    }
    public void TakeAttendance_Clicked(View view)
    {

        Intent i=new Intent(this,TakeAttendance.class);
        startActivity(i);
    }
    public void ViewStudentRecord_Clicked(View view)
    {
        Intent intent=new Intent(this,StudentRecord1.class);
        startActivity(intent);
    }
    public void UploadAssignment_Clicked(View view)
    {
        Intent intent=new Intent(this,Assignment.class);
        startActivity(intent);
    }
    public void ViewClassReport_Clicked(View view)
    {
        Intent intent=new Intent(this,FilterClass.class);
        startActivity(intent);
    }
    @Override
    public void onBackPressed() {
        Intent intent=new Intent(this,M1.class);
        startActivity(intent);

    }
}
