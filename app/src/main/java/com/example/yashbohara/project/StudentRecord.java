package com.example.yashbohara.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import static com.example.yashbohara.project.M1.dbhandler;

public class StudentRecord extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_record);
    }
    public void View_Clicked(View view)
    {
        EditText e81=(EditText) findViewById(R.id.e81);
        EditText e82=(EditText) findViewById(R.id.e83);
        Spinner s81=(Spinner) findViewById(R.id.j81);
        Spinner s82=(Spinner) findViewById(R.id.j82);
        Spinner s83=(Spinner) findViewById(R.id.j83);
        Intent intent=new Intent(this,StudentDetails.class);
        intent.putExtra("i1",e81.getText().toString());
        intent.putExtra("i3",e82.getText().toString());
        intent.putExtra("i2",s81.getSelectedItem().toString());
        intent.putExtra("i4",s82.getSelectedItem().toString());
        intent.putExtra("i5",s83.getSelectedItem().toString());
        if(e81.getText().toString().equals(dbhandler.RetrieveStudent(s81.getSelectedItem().toString(), s82.getSelectedItem().toString(), s83.getSelectedItem().toString(), e82.getText().toString()))&&e81.getText().toString()!=null)
       {
           if(e81.getText().toString().equals(""))
           {
               Toast.makeText(this,"Invalid Name or Roll Number",Toast.LENGTH_LONG).show();
           }
           else {
           Toast.makeText(this, "Valid Roll Number", Toast.LENGTH_LONG).show();
        startActivity(intent);
    }
       }
        else {
          Toast.makeText(this, "Invalid Roll Number", Toast.LENGTH_LONG).show();
      }
    }
}
