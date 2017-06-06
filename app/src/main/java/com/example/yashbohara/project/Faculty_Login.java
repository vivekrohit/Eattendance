package com.example.yashbohara.project;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

import static com.example.yashbohara.project.M1.dbhandler;

public class Faculty_Login extends AppCompatActivity {
    static String a;
    static int c=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty__login);
    }
    public void Login_Clicked(View view)
    {EditText e31=(EditText) findViewById(R.id.e31);
        EditText e32=(EditText) findViewById(R.id.e32);
        final ProgressDialog progressDialog=new ProgressDialog(this);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setMessage("Loading Please Wait....");
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();
        FirebaseDatabase database=FirebaseDatabase.getInstance();
        final DatabaseReference mref=database.getReference("Faculty");
        mref.child(e31.getText().toString()).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                try {

                a=dataSnapshot.child("Password").getValue().toString();
                c=1;
                    progressDialog.dismiss();
                    ab(a);
                }
                catch (NullPointerException e)
                {
                    progressDialog.dismiss();
                    //Toast.makeText(this,e).show();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
       // progressDialog.setProgress(8);
        //progressDialog.dismiss();
       /* if(e32.getText().toString().equals(dbhandler.RetrieveFaculty(e31.getText().toString())))
        {
            Intent intent = new Intent(this, Faculty_Functions.class);
            Toast.makeText(this,"Successfully Logged In",Toast.LENGTH_LONG).show();
            startActivity(intent);
        }
        else
        {
        Toast.makeText(this,"Unsuccessfull",Toast.LENGTH_LONG).show();
    }
*/
    }
    public void ab(String b)
    {
        EditText e32=(EditText) findViewById(R.id.e32);
        if(e32.getText().toString().equals(b))
        {
            Intent intent = new Intent(this, Faculty_Functions.class);
            Toast.makeText(this,"Successfully Logged In",Toast.LENGTH_LONG).show();
            this.finish();
            startActivity(intent);
        }
        else
        {
            Toast.makeText(this,"Unsuccessfull",Toast.LENGTH_LONG).show();
        }
    }
    public void RegisterFaculty_Clicked(View view)
    {
//        Intent intent=new Intent(this,RegisterFaculty.class);
        Intent intent=new Intent(this,RegisterFaculty.class);
        startActivity(intent);
    }

    }
