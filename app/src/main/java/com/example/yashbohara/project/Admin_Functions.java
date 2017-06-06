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


    public void ViewClassReport_Clicked(View view)
    {
        Intent intent=new Intent(this,FilterClass.class);
        this.finish();
        startActivity(intent);
    }
    public void UploadNotice_Clicked(View view)
    {
        Intent intent=new Intent(this,Upload.class);
        this.finish();
        startActivity(intent);
    }

        @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent=new Intent(this,M1.class);
        startActivity(intent);
        this.finish();
    }
}