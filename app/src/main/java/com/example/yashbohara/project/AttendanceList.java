package com.example.yashbohara.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import static com.example.yashbohara.project.M1.dbhandler;

public class AttendanceList extends AppCompatActivity {
ListView l1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance_list);
        Bundle bundle=getIntent().getExtras();
        String b1=bundle.getString("s1");
        String b2=bundle.getString("s2");
        String b3=bundle.getString("s3");
        //String b4=bundle.getString("s4");
        ArrayList<String> list=dbhandler.databaseToString(b1,b2,b3);
        ListAdapter listAdapter=new CustomAdapter(this,list);
        l1=(ListView) findViewById(R.id.l1);
        l1.setAdapter(listAdapter);
    }
    public void On_Clicked(View view)
    {
        CheckBox c1=(CheckBox) view.findViewById(R.id.c1);
        Bundle bundle=getIntent().getExtras();
        String b1=bundle.getString("s1");
        String b2=bundle.getString("s2");
        String b3=bundle.getString("s3");
        String b4=bundle.getString("s4");
if(c1.isChecked()) {
    dbhandler.Update(b1, b2, b3, b4, c1.getText().toString());
    Toast.makeText(this, "Saved", Toast.LENGTH_LONG).show();
}
    else {
    dbhandler.Update2(b1, b2, b3, b4, c1.getText().toString());

}
    }
    public void Save_Clicked(View view)
    {
        Toast.makeText(this,"Successfully Updated",Toast.LENGTH_LONG).show();
        Intent intent=new Intent(this,Faculty_Functions.class);
        startActivity(intent);
    }
}
