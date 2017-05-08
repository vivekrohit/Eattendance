package com.example.yashbohara.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import static com.example.yashbohara.project.M1.dbhandler;

public class RegisterFaculty extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_faculty);

    }
    public void Register_Clicked(View view) {
        EditText e71 = (EditText) findViewById(R.id.e71);
        EditText e1 = (EditText) findViewById(R.id.editText);
        EditText e72 = (EditText) findViewById(R.id.e72);
        Spinner s71 = (Spinner) findViewById(R.id.s71);
        Intent intent = new Intent(this, Faculty_Login.class);
        TextView t71=(TextView) findViewById(R.id.t71);
        TextView t73=(TextView) findViewById(R.id.t73);
        String a=e72.getText().toString();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Faculty");
        DatabaseReference childref=myRef.child(a).child(t71.getText().toString());
        DatabaseReference childref2=myRef.child(a).child(t73.getText().toString());
        childref.setValue(e71.getText().toString());
        childref2.setValue(s71.getSelectedItem().toString());
        dbhandler.AddFaculty(e71.getText().toString(), e72.getText().toString(), s71.getSelectedItem().toString());
        if (e1.getText().toString().equals("register")) {
            Toast.makeText(this, "SuccessfullyAdded", Toast.LENGTH_LONG).show();
            startActivity(intent);
        }
    }
}
