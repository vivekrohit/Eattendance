package com.example.yashbohara.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Admin_Functions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin__functions);
    }
    public void RegisterStudent_Clicked(View view)
    {
        Intent intent=new Intent(this,RegisterStudent.class);
        startActivity(intent);
    }
    public void RegisterFaculty_Clicked(View view)
    {
        Intent intent=new Intent(this,RegisterFaculty.class);
        startActivity(intent);
    }
    public void ViewStudentRecord_Clicked(View view)
    {
        Intent intent=new Intent(this,StudentRecord.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        Intent intent=new Intent(this,M1.class);
        startActivity(intent);

    }
}
