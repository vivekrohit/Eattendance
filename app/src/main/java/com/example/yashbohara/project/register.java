package com.example.yashbohara.project;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

public class register extends AppCompatActivity {
private SignInButton signInButton;
    private static final int RC_SIGN_IN=1;
    private GoogleApiClient mGoogleApiClient;
    private  FirebaseAuth mAuth;
    static ProgressDialog progressDialog;

    private static final String TAG="Main Activity";
    private FirebaseAuth.AuthStateListener mAuthListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mAuthListener=new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if (firebaseAuth.getCurrentUser()!=null)
                {
                    firebaseAuth.getCurrentUser().sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful())
                            {
                                Log.e("Success","Yes");
                            }
                            else {
                                Log.e("Success","No");

                            }
                        }
                    });
                    //if (!task.isSuccessful())
                    {
//Toast.makeText(this,"",Toast.LENGTH_LONG).show();
                    }
                    //else
                    //
                    {
                        startActivity(new Intent(register.this,Student_Login.class));
                        finish();
                    }
                }
            }

                    //ae(firebaseAuth.getCurrentUser());
                    //progressDialog.dismiss();
                   // startActivity(new Intent(register.this,Student_Login.class));
        };
        mAuth=FirebaseAuth.getInstance();

        signInButton=(SignInButton) findViewById(R.id.googlebutton);
        // Configure Google Sign In
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
mGoogleApiClient=new GoogleApiClient.Builder(getApplicationContext())
        .enableAutoManage(this,new GoogleApiClient.OnConnectionFailedListener(){
            @Override
            public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

            }
        })
.addApi(Auth.GOOGLE_SIGN_IN_API,gso).build();
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                ag();
                /*final ProgressDialog progressDialog=new ProgressDialog();
                progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                progressDialog.setMessage("Loading Please Wait....");
                progressDialog.setCanceledOnTouchOutside(false);
                progressDialog.show();

                */        //mAuth=FirebaseAuth.getInstance();
                signIn();
                ah();
                //progressDialog.dismiss();
            }

        });
    }
   /* public void ae(final FirebaseUser user){

       Bundle bundle=getIntent().getExtras();
        String a=bundle.getString("a");
        String b=bundle.getString("b");
        mAuth.createUserWithEmailAndPassword(a,b).addOnCompleteListener(register.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                //  Toast.makeText(this,"create user with email id complete"+task.isSuccessful(),Toast.LENGTH_LONG).show();
                    user.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful())
                            {
                                Log.e("Success","Yes");
                            }
                            else {
                                Log.e("Success","No");

                            }
                        }
                    });
                if (!task.isSuccessful())
                {
//Toast.makeText(this,"",Toast.LENGTH_LONG).show();
                }
                else {
                    startActivity(new Intent(register.this,Student_Login.class));
                    finish();
                }
            }
        });
    }*/
    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    public void ag()
    {
                progressDialog=new ProgressDialog(this);
                progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                progressDialog.setMessage("Loading Please Wait....");
                progressDialog.setCanceledOnTouchOutside(false);
                progressDialog.show();
    }
    public void ah()
    {
        progressDialog.dismiss();
    }
    private void signIn() {
        Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }
    @Override
        public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            if (result.isSuccess()) {
                // Google Sign In was successful, authenticate with Firebase
                GoogleSignInAccount account = result.getSignInAccount();
                firebaseAuthWithGoogle(account);
            } else {
                // Google Sign In failed, update UI appropriately
                // ...
            }
        }
    }
    private void firebaseAuthWithGoogle(GoogleSignInAccount acct) {
        Log.d(TAG, "firebaseAuthWithGoogle:" + acct.getId());

        AuthCredential credential = GoogleAuthProvider.getCredential(acct.getIdToken(), null);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithCredential:success");
                            //FirebaseUser user = mAuth.getCurrentUser();
                            //updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithCredential:failure", task.getException());
                            Toast.makeText(register.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            //updateUI(null);
                        }

                        // ...
                    }
                });
    }
}