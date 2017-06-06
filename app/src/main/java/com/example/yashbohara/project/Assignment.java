package com.example.yashbohara.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Assignment extends AppCompatActivity {
    static long a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assignment);
    }
    public void Up_Clicked(View view)
    {
        ae();
    }

    public void al(long l)
    {
        EditText e4=(EditText) findViewById(R.id.editText4);
        FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
        DatabaseReference databaseReference=firebaseDatabase.getReference("Assignment");
        DatabaseReference databaseReference1=databaseReference.child(""+l);
        databaseReference1.setValue(e4.getText().toString());
        Toast.makeText(this,"Uploaded",Toast.LENGTH_LONG).show();
        Intent intent=new Intent(this,Faculty_Functions.class);
        this.finish();
        startActivity(intent);
    }
    public void ae() {
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference databaseReference = firebaseDatabase.getReference("Assignment");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                a=dataSnapshot.getChildrenCount();
                a++;
                al(a);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
