package com.example.chat_apps;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {
    EditText etUsername, etPassword, etPhone, etCountry;
    Button btnSubmit;
    DatabaseHelper dbHelper; // deklarasi

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Inisialisasi DatabaseHelper
        dbHelper = new DatabaseHelper(this);

        // Inisialisasi view
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        etPhone = findViewById(R.id.etPhoneNumber);
        etCountry = findViewById(R.id.etCountry);
        btnSubmit = findViewById(R.id.btnRegister);

        btnSubmit.setOnClickListener(v -> {
            String username = etUsername.getText().toString().trim();
            String password = etPassword.getText().toString().trim();
            String phone = etPhone.getText().toString().trim();
            String country = etCountry.getText().toString().trim();

            // Validasi: jika ada field yang kosong
            if (username.isEmpty() || password.isEmpty() || phone.isEmpty() || country.isEmpty()) {
                Toast.makeText(this, "Semua field harus diisi", Toast.LENGTH_SHORT).show();
                return; // Jangan lanjut ke insertUser
            }

            boolean inserted = dbHelper.insertUser(username, password, phone, country);
            if (inserted) {
                Toast.makeText(this, "Registrasi berhasil", Toast.LENGTH_SHORT).show();
                finish(); // kembali ke LoginActivity
            } else {
                Toast.makeText(this, "Registrasi gagal", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
