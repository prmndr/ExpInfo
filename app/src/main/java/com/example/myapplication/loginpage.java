package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class loginpage extends AppCompatActivity {

    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://expinfo-29d94-default-rtdb.firebaseio.com/");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpage);

        final EditText username = findViewById(R.id.editTextTextPersonName);
        final EditText password = findViewById(R.id.editTextTextPassword);
        final Button button = findViewById(R.id.button);
        final TextView registerNowBtn = findViewById(R.id.registerNowBtn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String usernameTxt = username.getText().toString();
                final String passwordTxt = password.getText().toString();

                if(usernameTxt.isEmpty() || passwordTxt.isEmpty()){
                    Toast.makeText(loginpage.this, "Please enter your Username", Toast.LENGTH_SHORT).show();
                }
                else{
                        databaseReference.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                if(snapshot.hasChild(usernameTxt)){

                                    final String getPassword = snapshot.child(usernameTxt).child("password").getValue(String.class);

                                    assert getPassword != null;
                                    if(getPassword.equals(passwordTxt)){

                                        Toast.makeText(loginpage.this, "Successfully logged In", Toast.LENGTH_SHORT).show();

                                        startActivity(new Intent(loginpage.this, Activity2.class));
                                        finish();
                                    }
                                    else{
                                        Toast.makeText(loginpage.this, "Wrong Password", Toast.LENGTH_SHORT).show();
                                    }
                                }
                                else{
                                    Toast.makeText(loginpage.this, "Wrong Password", Toast.LENGTH_SHORT).show();
                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {

                            }
                        });
                }
            }
        });

        registerNowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(loginpage.this, MainActivity.class ));
            }
        });
    }
}