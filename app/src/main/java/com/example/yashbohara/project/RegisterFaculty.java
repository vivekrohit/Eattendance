package com.example.yashbohara.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import static com.example.yashbohara.project.M1.dbhandler;

public class RegisterFaculty extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_faculty);
    }
    public void Register_Clicked(View view)
    {
        EditText e71=(EditText) findViewById(R.id.e71);
        EditText e72=(EditText) findViewById(R.id.e72);
        Spinner s71=(Spinner) findViewById(R.id.s71);
        Intent intent=new Intent(this,Admin_Functions.class);
        dbhandler.AddFaculty(e71.getText().toString(),e72.getText().toString(),s71.getSelectedItem().toString());
        Toast.makeText(this,"SuccessfullyAdded",Toast.LENGTH_LONG).show();
        startActivity(intent);
    }
}
