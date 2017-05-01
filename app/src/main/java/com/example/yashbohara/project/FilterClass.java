package com.example.yashbohara.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;

public class FilterClass extends AppCompatActivity {
    public static FilterClass obj1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter_class);
        obj1=new FilterClass();
    }
    public void OnView_Clicked(View view)
    {
        Spinner s81=(Spinner) findViewById(R.id.j81);
        Spinner s82=(Spinner) findViewById(R.id.j82);
        Spinner s83=(Spinner) findViewById(R.id.j83);
        CustomAdapter2 obj=new CustomAdapter2(this,s81.getSelectedItem().toString(),s82.getSelectedItem().toString(),s83.getSelectedItem().toString());
        Intent intent=new Intent(this,ViewClassReport.class);
        intent.putExtra("s1",s81.getSelectedItem().toString());
        intent.putExtra("s2",s82.getSelectedItem().toString());
        intent.putExtra("s3",s83.getSelectedItem().toString());

        startActivity(intent);
    }
    public String a()
    {
        Spinner s81=(Spinner) findViewById(R.id.j81);
        return s81.getSelectedItem().toString();
    }
    public String b()
    {
        Spinner s82=(Spinner) findViewById(R.id.j81);
        return s82.getSelectedItem().toString();
    }
    public String c()
    { Spinner s83=(Spinner) findViewById(R.id.j81);
        return s83.getSelectedItem().toString();
    }
}
