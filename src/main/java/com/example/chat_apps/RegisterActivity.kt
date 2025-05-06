package com.example.chat_apps

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {
    private var etUsername: EditText? = null
    private var etPassword: EditText? = null
    private var etPhone: EditText? = null
    private var etCountry: EditText? = null
    private var btnSubmit: Button? = null
    private var dbHelper: DatabaseHelper? = null // deklarasi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        // Inisialisasi DatabaseHelper
        dbHelper = DatabaseHelper(this)

        // Inisialisasi view
        etUsername = findViewById(R.id.etUsername)
        etPassword = findViewById(R.id.etPassword)
        etPhone = findViewById(R.id.etPhoneNumber)
        etCountry = findViewById(R.id.etCountry)
        btnSubmit = findViewById(R.id.btnRegister)

        btnSubmit?.setOnClickListener {
            val username = etUsername?.text.toString().trim()
            val password = etPassword?.text.toString().trim()
            val phone = etPhone?.text.toString().trim()
            val country = etCountry?.text.toString().trim()

            // Validasi: jika ada field yang kosong
            if (username.isEmpty() || password.isEmpty() || phone.isEmpty() || country.isEmpty()) {
                Toast.makeText(this, "Semua field harus diisi", Toast.LENGTH_SHORT).show()
                return@setOnClickListener  // Jangan lanjut ke insertUser
            }

            val inserted = dbHelper?.insertUser(username, password, phone, country) ?: false
            if (inserted) {
                Toast.makeText(this, "Registrasi berhasil", Toast.LENGTH_SHORT).show()
                finish() // kembali ke LoginActivity
            } else {
                Toast.makeText(this, "Registrasi gagal", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
