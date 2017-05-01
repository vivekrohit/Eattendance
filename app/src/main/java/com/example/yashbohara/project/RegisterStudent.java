package com.example.yashbohara.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import static com.example.yashbohara.project.M1.dbhandler;

public class RegisterStudent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_student);
    }
public void RegisterClicked(View view)
{
    EditText e61=(EditText) findViewById(R.id.e61);
    EditText e62=(EditText) findViewById(R.id.e62);
    Spinner s51=(Spinner) findViewById(R.id.s51);
    Spinner s52=(Spinner) findViewById(R.id.s52);
    Spinner s53=(Spinner) findViewById(R.id.s53);
    dbhandler.AddProduct(s52.getSelectedItem().toString(),s53.getSelectedItem().toString(),s51.getSelectedItem().toString(),e61.getText().toString(),e62.getText().toString());
    Toast.makeText(this,"Added Successfully",Toast.LENGTH_LONG).show();
    Intent intent=new Intent(this,M1.class);
    startActivity(intent);
}
}
