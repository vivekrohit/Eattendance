package com.example.yashbohara.project;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class StudentRecord1 extends AppCompatActivity {
     public static ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_record1);
    }
    public void View_Clicked(View view)
    {

        am();
                }
    public void am(){
        EditText e81=(EditText) findViewById(R.id.e81);
        final EditText e82=(EditText) findViewById(R.id.e83);
        Spinner s81=(Spinner) findViewById(R.id.j81);
        Spinner s82=(Spinner) findViewById(R.id.j82);
        Spinner s83=(Spinner) findViewById(R.id.j83);
        FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
        progressDialog=new ProgressDialog(this);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setMessage("Loading Please Wait....");
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();
    DatabaseReference databaseReference=firebaseDatabase.getReference("Student"+s82.getSelectedItem().toString()+s83.getSelectedItem().toString()+s81.getSelectedItem().toString());
    databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            if (e82.getText().toString().equals("")){
          progressDialog.dismiss();
           an();
        }
        else
            {
                if (!dataSnapshot.hasChild(e82.getText().toString())){
                    progressDialog.dismiss();
                    an();
                }
                else
                {
                    progressDialog.dismiss();
                    ao();
                }            }
        }

        @Override
        public void onCancelled(DatabaseError databaseError) {

        }
    });}
    public void ao()
    {
        EditText e81=(EditText) findViewById(R.id.e81);
        final EditText e82=(EditText) findViewById(R.id.e83);
        Spinner s81=(Spinner) findViewById(R.id.j81);
        Spinner s82=(Spinner) findViewById(R.id.j82);
        Spinner s83=(Spinner) findViewById(R.id.j83);
        Intent intent=new Intent(this,StudentDetails.class);
        intent.putExtra("i1",e81.getText().toString());
        intent.putExtra("i3",e82.getText().toString());
        intent.putExtra("i2",s81.getSelectedItem().toString());
        intent.putExtra("i4",s82.getSelectedItem().toString());
        intent.putExtra("i5",s83.getSelectedItem().toString());
        this.finish();
        startActivity(intent);
    }
    public void an()
    {
        Toast.makeText(this,"InValid Student",Toast.LENGTH_LONG).show();
    }
        @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }
}
