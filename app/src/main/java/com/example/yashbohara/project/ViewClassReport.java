package com.example.yashbohara.project;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

import static com.example.yashbohara.project.M1.dbhandler;

public class ViewClassReport extends AppCompatActivity {
    ListView l2;
    static int counter2=1;
    static ArrayList<String> list2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_class_report);
        TextView t8=(TextView) findViewById(R.id.textView8);
        TextView t9=(TextView) findViewById(R.id.textView9);
        TextView t10=(TextView) findViewById(R.id.textView10);
        TextView t11=(TextView) findViewById(R.id.textView11);
        TextView t12=(TextView) findViewById(R.id.textView12);
        Bundle bundle=getIntent().getExtras();
        String a=bundle.getString("s1");
        String b=bundle.getString("s2");
        String c=bundle.getString("s3");
        t8.setText(b+a+"02");
        t9.setText(b+a+"03");
        t10.setText(b+a+"04");
        t11.setText(b+a+"05");
        t12.setText(b+a+"01");
        FirebaseDatabase database=FirebaseDatabase.getInstance();
        DatabaseReference mref=database.getReference("Student"+b+c+a);
        //final ArrayList<String> list2=dbhandler.databaseToString(b,c,a);
        //final ArrayList<String> item=new ArrayList<>();
        list2=new ArrayList<>();
        final ProgressDialog progressDialog=new ProgressDialog(this);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setMessage("Loading Please Wait....");
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();
        mref.child("Id").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                String d=dataSnapshot.getValue().toString();
                list2.add(d);
                counter2++;
                if(counter2>dataSnapshot.getChildrenCount())
                {
                    progressDialog.dismiss();
                    ad();
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
    }
    public void ad()
    {
        ListAdapter listAdapter2=new CustomAdapter2(this,list2);
        l2=(ListView) findViewById(R.id.l2);
        l2.setAdapter(listAdapter2);

    }

}
