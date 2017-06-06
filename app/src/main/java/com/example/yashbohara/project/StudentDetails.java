package com.example.yashbohara.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import static com.example.yashbohara.project.M1.dbhandler;

public class StudentDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_details);
        Bundle bundle=getIntent().getExtras();
        String Name=bundle.getString("i1");
        final String Semester=bundle.getString("i2");
        final String Branch=bundle.getString("i4");
        String Section=bundle.getString("i5");
        String RollNo=bundle.getString("i3");
        final TextView t121=(TextView) findViewById(R.id.t121);
        final TextView t1=(TextView) findViewById(R.id.t1);
        final TextView t2=(TextView) findViewById(R.id.t2);
        final TextView t3=(TextView) findViewById(R.id.t3);
        final TextView t4=(TextView) findViewById(R.id.t4);
        final TextView t5=(TextView) findViewById(R.id.t5);
        final TextView t6=(TextView) findViewById(R.id.t6);
        final TextView t7=(TextView) findViewById(R.id.t7);
        final TextView t8=(TextView) findViewById(R.id.t8);
        final TextView t9=(TextView) findViewById(R.id.t9);
        final TextView t10=(TextView) findViewById(R.id.t10);
        t121.setText(Name);
        t1.setText(Branch+Semester+"01");
        t3.setText(Branch+Semester+"02");
        t5.setText(Branch+Semester+"03");
        t7.setText(Branch+Semester+"04");
        t9.setText(Branch+Semester+"05");
        FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
        DatabaseReference databaseReference=firebaseDatabase.getReference("Student"+Branch+Section+Semester);
        databaseReference.child(RollNo).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String a=dataSnapshot.child(Branch+Semester+"01").getValue().toString();
                t2.setText(a);
                String b=dataSnapshot.child(Branch+Semester+"02").getValue().toString();
                t4.setText(b);
                String c=dataSnapshot.child(Branch+Semester+"03").getValue().toString();
                t6.setText(c);
                String d=dataSnapshot.child(Branch+Semester+"04").getValue().toString();
                t8.setText(d);
                String e=dataSnapshot.child(Branch+Semester+"05").getValue().toString();
                t10.setText(e);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        //t2.setText(dbhandler.Extract(Branch,Section,Semester,RollNo,Branch+Semester+"01").toString());
       // t4.setText(dbhandler.Extract(Branch,Section,Semester,RollNo,Branch+Semester+"02").toString());
       // t6.setText(dbhandler.Extract(Branch,Section,Semester,RollNo,Branch+Semester+"03").toString());
        //t8.setText(dbhandler.Extract(Branch,Section,Semester,RollNo,Branch+Semester+"04").toString());
        //t10.setText(dbhandler.Extract(Branch,Section,Semester,RollNo,Branch+Semester+"05").toString());

    }

    @Override
    public void onBackPressed() {
        Intent intent=new Intent(this,M1.class);
        startActivity(intent);
        this.finish();
    }
}
