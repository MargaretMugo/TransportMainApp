package com.example.transportmainapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterUser extends AppCompatActivity implements View.OnClickListener{
    private TextView headingTitle,registerUser;
    private EditText editTextfullName,editTextage,editTextemail,editTextpassword;
    //private ProgressBar progressBar;
    private FirebaseAuth mAuth;

    public RegisterUser() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);
        mAuth = FirebaseAuth.getInstance();

        headingTitle = (TextView) findViewById(R.id.headingTitle);
        headingTitle.setOnClickListener(this);

        registerUser = (Button) findViewById(R.id.registerUser);
        registerUser.setOnClickListener(this);

        editTextfullName = (EditText) findViewById(R.id.fullName);
        editTextage = (EditText) findViewById(R.id.age);
        editTextemail = (EditText) findViewById(R.id.email);
        editTextpassword = (EditText) findViewById(R.id.password);

        //progressBar = (ProgressBar) findViewById(R.id.progressBar);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.headingTitle:
                startActivity(new Intent(this,MainActivity.class));
                break;
            case R.id.registerUser:
                registerUser();
                break;
        }

    }
    private void registerUser() {
        String fullName = editTextfullName.getText().toString().trim();
        String age = editTextage.getText().toString().trim();
        String email = editTextemail.getText().toString().trim();
        String password = editTextpassword.getText().toString().trim();

        if (fullName.isEmpty()){
            editTextfullName.setError("Full name is needed");
            editTextfullName.requestFocus();
            return;
        }
        if (age.isEmpty()){
            editTextage.setError("Age is needed");
            editTextage.requestFocus();
            return;
        }
        if (email.isEmpty()){
            editTextemail.setError("Email is needed");
            editTextemail.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            editTextemail.setError("Please provide a valid email address");
            editTextemail.requestFocus();
            return;
        }
        if (password.isEmpty()){
            editTextpassword.setError("Password is needed");
            editTextpassword.requestFocus();
            return;
        }
        if (password.length()<6){
            editTextpassword.setError("Minimum characters is 6!");
            editTextpassword.requestFocus();
            return;
        }

        mAuth.createUserWithEmailAndPassword(email,password)
                //checks if the user has been registered
        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    User user = new User(fullName,age,email);
                    FirebaseDatabase.getInstance().getReference("Users")
                            //corresponds the object to the registered users
                            .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                            .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull  Task<Void> task) {
                            if (task.isSuccessful()){
                                Toast.makeText(RegisterUser.this,"User is registered successfully",Toast.LENGTH_LONG).show();
                            }else {
                                Toast.makeText(RegisterUser.this,"User is unregistered",Toast.LENGTH_LONG).show();
                            }
                        }
                    });
                }else {
                    Toast.makeText(RegisterUser.this,"User is unregistered",Toast.LENGTH_LONG).show();
                    //progressBar.setVisibility(View.GONE);
                }
            }
        });
    }
}