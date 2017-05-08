package com.example.yashbohara.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.security.Key;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static com.example.yashbohara.project.M1.dbhandler;

public class AttendanceList extends AppCompatActivity {
ListView l1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance_list);
        Bundle bundle=getIntent().getExtras();
        final String b1=bundle.getString("s1");
        final String b2=bundle.getString("s2");
       final String b3=bundle.getString("s3");
        //String b4=bundle.getString("s4");
        FirebaseDatabase database=FirebaseDatabase.getInstance();
        final DatabaseReference mref=database.getReference("Student"+b1+b2+b3);
        l1=(ListView) findViewById(R.id.l1);

        /*mref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                String value=dataSnapshot.getValue(String.class);
                item.add(value);
                //listAdapter.notify();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });*/
        //final HashMap<String,String> map=new HashMap<>();
       // Collection<String> values=map.values();
        final ArrayList<String> item=new ArrayList<String>();
        mref.child("Id").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
               // Log.e("helllo world",item.get(1));
                Log.e("hello",""+dataSnapshot.getValue());
                String a=dataSnapshot.getValue().toString();
                item.add(a);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
                //HashMap map=(HashMap)dataSnapshot.child("Name").getValue();
                //String Name=map.get();
                //map.containsValue(dataSnapshot.child("Student"+b1+b2+b3).getValue());
                //Log.e("hello2",Name);
                //item.add(dataSnapshot.child("117").child("Name").getValue().toString());
                //item.add(dataSnapshot.child("Student"+b1+b2+b3).getValue(String.class));
                //listAdapter.notify();
           // for(DataSnapshot snap=dataSnapshot.child().getValue())




        final ListAdapter listAdapter=new CustomAdapter(this,item);
        l1.setAdapter(listAdapter);
        // ArrayList<String> list=dbhandler.databaseToString(b1,b2,b3);
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
