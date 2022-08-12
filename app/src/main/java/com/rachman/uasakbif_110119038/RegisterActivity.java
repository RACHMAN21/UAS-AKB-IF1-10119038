package com.rachman.uasakbif_110119038;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/**
 * Identitas Diri
 * NIM  : 10119038
 * Kelas: IF-1
 * Nama : Rachman Aldiansyah
 */
public class RegisterActivity extends AppCompatActivity {

    private EditText editEmail, editPassword;
    private Button btnLogin, btnRegister;
    private FirebaseAuth mAuth;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        editEmail = findViewById(R.id.txt_email);
        editPassword = findViewById(R.id.txt_password);

        btnRegister = findViewById(R.id.btn_signUp);
        btnLogin = findViewById(R.id.btn_signIn);

        mAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(RegisterActivity.this);
        progressDialog.setTitle("Loading");
        progressDialog.setMessage("Silahkan tunggu");
        progressDialog.setCancelable(false);

        btnLogin.setOnClickListener(v -> {
            finish();
        });

        btnRegister.setOnClickListener(v -> {
            if (editEmail.getText().length()>0 && editPassword.getText().length()>0) {
                register(editEmail.getText().toString(), editPassword.getText().toString());
            } else {
                Toast.makeText(getApplicationContext(), "Silahkan daftarkan email & password Anda.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void register(String email, String password) {
        progressDialog.show();
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(RegisterActivity.this, "Akun berhasil dibuat!", Toast.LENGTH_SHORT).show();
                            editEmail.getText().clear();
                            editPassword.getText().clear();
                        } else {
                            Toast.makeText(getApplicationContext(), task.getException().getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    private void reload() {
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
    }

    @Override
    public void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null) {
            reload();
        }
    }
}