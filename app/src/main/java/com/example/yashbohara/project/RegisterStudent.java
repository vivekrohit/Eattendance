package com.example.yashbohara.project;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import static com.example.yashbohara.project.M1.dbhandler;

public class RegisterStudent extends AppCompatActivity {
public static ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_student);
    }
public void RegisterClicked(View view)
{
    final EditText e62=(EditText) findViewById(R.id.e62);
    Spinner s51=(Spinner) findViewById(R.id.s51);
    Spinner s52=(Spinner) findViewById(R.id.s52);
    Spinner s53=(Spinner) findViewById(R.id.s53);
   String b=s52.getSelectedItem().toString()+s53.getSelectedItem().toString()+s51.getSelectedItem().toString();
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("Student"+b);
    progressDialog=new ProgressDialog(this);
    progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
    progressDialog.setMessage("Loading Please Wait....");
    progressDialog.setCanceledOnTouchOutside(false);
    progressDialog.show();
    myRef.addListenerForSingleValueEvent(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            if (dataSnapshot.child("Id").hasChild(e62.getText().toString()))
            {
                aj();
                progressDialog.dismiss();
            }
            else
            {
                ak();
            }
        }

        @Override
        public void onCancelled(DatabaseError databaseError) {

        }
    });


//    dbhandler.AddProduct(s52.getSelectedIte().toString(),s53.getSelectedItem().toString(),s51.getSelectedItem().toString(),e61.getText().toString(),e62.getText().toString());
}
    public void aj()
    {
        Toast.makeText(this,"Already exist",Toast.LENGTH_LONG).show();
    }
    public void ak()
    {
        progressDialog=new ProgressDialog(this);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setMessage("Loading Please Wait....");
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();
        EditText e61=(EditText) findViewById(R.id.e61);
        EditText e63=(EditText) findViewById(R.id.editText2);
        final EditText e62=(EditText) findViewById(R.id.e62);
        Spinner s51=(Spinner) findViewById(R.id.s51);
        Spinner s52=(Spinner) findViewById(R.id.s52);
        Spinner s53=(Spinner) findViewById(R.id.s53);
        TextView t61=(TextView) findViewById(R.id.t61);
        TextView t62=(TextView) findViewById(R.id.t62);
        TextView t65=(TextView) findViewById(R.id.textView19);
        TextView t63=(TextView) findViewById(R.id.t63);
        TextView t64=(TextView) findViewById(R.id.t64);
        // TextView t65=(TextView) findViewById(R.id.t65);
        String b=s52.getSelectedItem().toString()+s53.getSelectedItem().toString()+s51.getSelectedItem().toString();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Student"+b);
        DatabaseReference childref11=myRef.child(s52.getSelectedItem().toString()+s51.getSelectedItem().toString()+"01").child(t61.getText().toString());
        DatabaseReference childref=myRef.child(e62.getText().toString()).child(t61.getText().toString());
        DatabaseReference childref18=myRef.child(e62.getText().toString()).child("Password");
        DatabaseReference childref12=myRef.child(s52.getSelectedItem().toString()+s51.getSelectedItem().toString()+"01");
        DatabaseReference childref13=myRef.child(s52.getSelectedItem().toString()+s51.getSelectedItem().toString()+"02");
        DatabaseReference childref14=myRef.child(s52.getSelectedItem().toString()+s51.getSelectedItem().toString()+"03");
        DatabaseReference childref15=myRef.child(s52.getSelectedItem().toString()+s51.getSelectedItem().toString()+"04");
        DatabaseReference childref16=myRef.child(s52.getSelectedItem().toString()+s51.getSelectedItem().toString()+"05");
        DatabaseReference childref2=myRef.child(e62.getText().toString()).child(t62.getText().toString());
        DatabaseReference childref3=myRef.child(e62.getText().toString()).child(t63.getText().toString());
        DatabaseReference childref4=myRef.child(e62.getText().toString()).child(t64.getText().toString());
        DatabaseReference childref10=myRef.child("Id").child(e62.getText().toString());
        DatabaseReference childref5=myRef.child(e62.getText().toString()).child(s52.getSelectedItem().toString()+s51.getSelectedItem().toString()+"01");
        DatabaseReference childref6=myRef.child(e62.getText().toString()).child(s52.getSelectedItem().toString()+s51.getSelectedItem().toString()+"02");
        DatabaseReference childref7=myRef.child(e62.getText().toString()).child(s52.getSelectedItem().toString()+s51.getSelectedItem().toString()+"03");
        DatabaseReference childref8=myRef.child(e62.getText().toString()).child(s52.getSelectedItem().toString()+s51.getSelectedItem().toString()+"04");
        DatabaseReference childref9=myRef.child(e62.getText().toString()).child(s52.getSelectedItem().toString()+s51.getSelectedItem().toString()+"05");
        childref10.setValue(e62.getText().toString());
        childref18.setValue(e63.getText().toString());
        childref.setValue(e61.getText().toString());
        childref2.setValue(s51.getSelectedItem().toString());
        childref3.setValue(s52.getSelectedItem().toString());
        childref4.setValue(s53.getSelectedItem().toString());
        childref10.setValue(e62.getText().toString());
        childref5.setValue(0);
        childref6.setValue(0);
        childref7.setValue(0);
        childref8.setValue(0);
        childref9.setValue(0);
        progressDialog.dismiss();
        //childref5.setValue(e62.getText().toString());
        Intent intent=new Intent(this,M1.class);
        startActivity(intent);
    }
}
