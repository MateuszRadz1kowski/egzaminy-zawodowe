package com.example.mobilna

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val zatwierdzButton = findViewById<Button>(R.id.zatwierdz)
        val emailInput = findViewById<TextView>(R.id.email)
        val passwordInput = findViewById<TextView>(R.id.passInput)
        val retypePasswordInput = findViewById<TextView>(R.id.retypePassInput)
        val communicate = findViewById<TextView>(R.id.communicate)

        zatwierdzButton.setOnClickListener {
            if (emailInput.text.contains("@") && passwordInput.text.toString() == retypePasswordInput.text.toString()){
                communicate.text = "Witaj ${emailInput.text}"
            }
            else if(!emailInput.text.contains("@") && passwordInput.text.toString() == retypePasswordInput.text.toString()){
                communicate.text = "Nieprawidlowy adres email"
            }
            else if(emailInput.text.contains("@") && passwordInput.text.toString() != retypePasswordInput.text.toString()){
                communicate.text = "Hasla sie roznia"
            }
            else {
                communicate.text = "Nieprawidlowy adres email i hasla sie roznia"
            }
        }
    }
}