package com.example.yashbohara.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Next extends AppCompatActivity {
    private EditText Email;
    private EditText Password;
    private Button button5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
        Email=(EditText) findViewById(R.id.Email);
        Password=(EditText) findViewById(R.id.Password);
        button5=(Button) findViewById(R.id.button5);

    }
    public void Next_Clicked(View view)
    {
        String a=Email.getText().toString();
        String b=Password.getText().toString();
        Intent intent=new Intent(this,register.class);
        intent.putExtra("a",a);
        intent.putExtra("b",b);
        startActivity(intent);
    }
}
