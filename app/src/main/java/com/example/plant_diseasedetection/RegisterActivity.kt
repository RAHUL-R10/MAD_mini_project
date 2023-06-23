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
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase


class RegisterActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var db: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        auth = Firebase.auth
        db = FirebaseFirestore.getInstance()
        val loginText : TextView = findViewById(R.id.textView_login_now)

        loginText.setOnClickListener{
            val intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

        val registerBtn : Button = findViewById(R.id.register_button)

        registerBtn.setOnClickListener {
            performSignUp()
        }

    }

    private fun performSignUp() {
        val email = findViewById<EditText>(R.id.email_edittext_register)
        val password = findViewById<EditText>(R.id.password_edittext_register)
        val name = findViewById<EditText>(R.id.name_edittext_register)

        if(email.text.isEmpty() || password.text.isEmpty() || name.text.isEmpty()){
            Toast.makeText(this,"Please fill all the fields",Toast.LENGTH_SHORT).show()
            return
        }

        val inputEmail = email.text.toString()
        val inputPassword = password.text.toString()
        val inputName = name.text.toString()
        val user = hashMapOf(
            "Name" to inputName,
            "Email" to inputEmail
        )
        val users=db.collection("USERS")


        auth.createUserWithEmailAndPassword(inputEmail,inputPassword)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    users.document(inputEmail).set(user)
                    Toast.makeText(baseContext,"Registration Successful. Please Login", Toast.LENGTH_SHORT,).show()
                    val intent =Intent(this,LoginActivity::class.java)
                    startActivity(intent)
                    finish()

                } else {
                    // If sign in fails, display a message to the user.

                    Toast.makeText(baseContext,"Authentication failed.", Toast.LENGTH_SHORT,).show()

                }
            }

            .addOnFailureListener {
                Toast.makeText(this,"error occurred ${it.localizedMessage}",Toast.LENGTH_SHORT).show()
            }
    }
}