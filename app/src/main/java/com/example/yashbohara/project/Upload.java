package com.example.yashbohara.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Upload extends AppCompatActivity {
    EditText e;
    static long a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload);


    }
    public void Upload_Clicked(View view)
    {
        e=(EditText) findViewById(R.id.e);
        ae();}
    public void ai(long l)
    {
        FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
        DatabaseReference databaseReference=firebaseDatabase.getReference("Notice");
        DatabaseReference databaseReference1=databaseReference.child(""+l);
        databaseReference1.setValue(e.getText().toString());
        Intent intent=new Intent(this,Admin_Functions.class);
        this.finish();
        startActivity(intent);
    }
    public void ae()
    {
        FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
        DatabaseReference databaseReference=firebaseDatabase.getReference("Notice");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                a=dataSnapshot.getChildrenCount();
                a++;
                ai(a);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
