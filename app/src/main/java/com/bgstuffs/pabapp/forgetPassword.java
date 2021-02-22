package com.bgstuffs.pabapp;

import android.content.Intent;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class forgetPassword extends AppCompatActivity {

    // declaration of views
    private EditText forget;
    private Button sendEmail;

    // fireBase initialization
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);

        forget = findViewById(R.id.et_forgotPassword);
        sendEmail = findViewById(R.id.bt_sendEmail);

        // for calling the instance of the Fire base auth
        firebaseAuth = FirebaseAuth.getInstance();

        // when send button is clicked
        sendEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = forget.getText().toString().trim();

                if (TextUtils.isEmpty(email)){
                    forget.setError("Entrez votre mdp svp");
                }

                else {
                    firebaseAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()){
                                Toast.makeText(forgetPassword.this,"Un email vous a été envoyé!",Toast.LENGTH_LONG).show();

                                startActivity(new Intent(forgetPassword.this,MainActivity.class));
                            }
                            else {
                                Toast.makeText(forgetPassword.this,"Email inexistant!",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }


            }
        });
    }
}
