package com.example.yashbohara.project;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
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
    long i;
    long j;
    static int counter=0;
    static ArrayList<String> item;
    ListView l1;
   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance_list);
        Bundle bundle=getIntent().getExtras();
        final String b1=bundle.getString("s1");
        final String b2=bundle.getString("s2");
       final String b3=bundle.getString("s3");
       final ProgressDialog progressDialog=new ProgressDialog(this);
       progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
       progressDialog.setMessage("Loading Please Wait....");
       progressDialog.setCanceledOnTouchOutside(false);
       progressDialog.show();
       //String b4=bundle.getString("s4");
        FirebaseDatabase database=FirebaseDatabase.getInstance();
        final DatabaseReference mref=database.getReference("Student"+b1+b2+b3);
        l1=(ListView) findViewById(R.id.l1);

         item=new ArrayList<>();
        mref.child("Id").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                String a=dataSnapshot.getValue().toString();
                item.add(a);
                counter++;
                if(counter>dataSnapshot.getChildrenCount())
                {
                    Log.e("Hello Counter",""+counter);
                    progressDialog.dismiss();
                    ac();
                }
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
        // ArrayList<String> list=dbhandler.databaseToString(b1,b2,b3);
         }
    public void ac()
    {
        final ListAdapter listAdapter=new CustomAdapter(this,item);
        l1.setAdapter(listAdapter);
    }
    public void On_Clicked(View view)
    {
        Bundle bundle=getIntent().getExtras();
        final String a1=bundle.getString("s1");
        final String a2=bundle.getString("s2");
        final String a3=bundle.getString("s3");
        FirebaseDatabase database=FirebaseDatabase.getInstance();
        final DatabaseReference databaseReference=database.getReference("Student"+a1+a2+a3);

        final CheckBox c1=(CheckBox) view.findViewById(R.id.c1);
        final String b1=bundle.getString("s1");
        String b2=bundle.getString("s2");
        final String b3=bundle.getString("s3");
        final String b4=bundle.getString("s4");
if(c1.isChecked()) {

    databaseReference.child(c1.getText().toString()).child(b1+b3+b4).addListenerForSingleValueEvent(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            i= (long) dataSnapshot.getValue();
            i=i+1;
            Bundle bundle=getIntent().getExtras();
            String b1=bundle.getString("s1");
            String b3=bundle.getString("s3");
            String b4=bundle.getString("s4");
            DatabaseReference d=databaseReference.child(c1.getText().toString()).child(b1+b3+b4);
            d.setValue(i);
            Log.e("Updated",""+i);

        }

        @Override
        public void onCancelled(DatabaseError databaseError) {

        }
    });
    //dbhandler.Update(b1, b2, b3, b4, c1.getText().toString());
    Toast.makeText(this, "Saved", Toast.LENGTH_LONG).show();
}
    else {

    databaseReference.child(c1.getText().toString()).child(b1+b3+b4).addListenerForSingleValueEvent(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            j= (long) dataSnapshot.getValue();
            j=j-1;
            Bundle bundle=getIntent().getExtras();
            String b1=bundle.getString("s1");
            String b3=bundle.getString("s3");
            String b4=bundle.getString("s4");
            DatabaseReference d=databaseReference.child(c1.getText().toString()).child(b1+b3+b4);
            d.setValue(j);
            Log.e("UnChecked",""+j);

        }

        @Override
        public void onCancelled(DatabaseError databaseError) {

        }
    });
    //dbhandler.Update2(b1, b2, b3, b4, c1.getText().toString());

}
    }
    public void Save_Clicked(View view)
    {
        Toast.makeText(this,"Successfully Updated",Toast.LENGTH_LONG).show();
        Intent intent=new Intent(this,Faculty_Functions.class);
        startActivity(intent);
    }
}
