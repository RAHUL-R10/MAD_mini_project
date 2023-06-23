package com.example.plant_diseasedetection

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        auth = Firebase.auth


        val registerText : TextView = findViewById(R.id.textView_register_now)

        registerText.setOnClickListener{
            val intent = Intent(this,RegisterActivity::class.java)
            startActivity(intent)
            finish()
        }

        val loginBtn : Button = findViewById(R.id.login_button)

        loginBtn.setOnClickListener {
            performLogin()
        }
    }

    private fun performLogin() {
        val email = findViewById<EditText>(R.id.email_edittext_login)
        val password = findViewById<EditText>(R.id.password_edittext_login)

        if(email.text.isEmpty() || password.text.isEmpty()){
            Toast.makeText(this,"Please fill all the fields", Toast.LENGTH_SHORT).show()
            return
        }

        val inputEmail = email.text.toString()
        val inputPassword = password.text.toString()

        auth.signInWithEmailAndPassword(inputEmail, inputPassword)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Toast.makeText(baseContext,"Login Successful. Welcome!", Toast.LENGTH_SHORT,).show()
                    val intent =Intent(this,MainActivity::class.java)
                    intent.putExtra("Email",inputEmail)
                    startActivity(intent)
                    finish()

                } else {
                    // If sign in fails, display a message to the user.
                    Toast.makeText(baseContext,"Authentication failed.", Toast.LENGTH_SHORT,).show()
                }
            }

            .addOnFailureListener{
                Toast.makeText(this,"error occurred ${it.localizedMessage}",Toast.LENGTH_SHORT).show()
            }
    }


}