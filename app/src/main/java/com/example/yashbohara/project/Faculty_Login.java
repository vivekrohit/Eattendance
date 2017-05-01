package com.example.yashbohara.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import static com.example.yashbohara.project.M1.dbhandler;

public class Faculty_Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty__login);
    }
    public void Login_Clicked(View view)
    {
        EditText e31=(EditText) findViewById(R.id.e31);
        EditText e32=(EditText) findViewById(R.id.e32);
        if(e32.getText().toString().equals(dbhandler.RetrieveFaculty(e31.getText().toString())))
        {
            Intent intent = new Intent(this, Faculty_Functions.class);
            Toast.makeText(this,"Successfully Logged In",Toast.LENGTH_LONG).show();
            startActivity(intent);
        }
        else
        {
        Toast.makeText(this,"Unsuccessfull",Toast.LENGTH_LONG).show();
    }

    }
    public void RegisterFaculty_Clicked(View view)
    {
        Intent intent=new Intent(this,RegisterFaculty.class);
        startActivity(intent);
    }
}
