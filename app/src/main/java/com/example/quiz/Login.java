package com.example.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.quiz.databinding.ActivityLoginBinding;

public class Login extends AppCompatActivity {
    ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        if (SessionManager.is_login(Login.this)) {
            startActivity(new Intent(Login.this, MainActivity.class));
            finish();
            return;
        }

        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (binding.username.getText().toString().isEmpty()) {
                    binding.username.setError("Harap Masukkan Nama Anda");
                    return;
                }
                if (binding.umur.getText().toString().isEmpty()) {
                    binding.umur.setError("Harap Masukkan Umur Anda");
                    return;
                }
                Intent i = new Intent(Login.this, MainActivity.class);
                SessionManager.setLogin(Login.this, true);
                SessionManager.setKey_nama(Login.this, binding.username.getText().toString());
                SessionManager.setUmur_nya(Login.this, Integer.parseInt(binding.umur.getText().toString()));
                startActivity(i);
                finish();
            }
        });
    }
}