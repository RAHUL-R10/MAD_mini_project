package com.example.plant_diseasedetection

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.firebase.firestore.FirebaseFirestore

class Profile : AppCompatActivity() {

    private lateinit var db: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val sharedPref=getSharedPreferences("Email",Context.MODE_PRIVATE)?:return
        val email=sharedPref.getString("Email","1")

        val nameView = findViewById<TextView>(R.id.name_profile)
        val emailView = findViewById<TextView>(R.id.email_profile)
        val backBtn = findViewById<Button>(R.id.back_profile)
        val logoutBtn = findViewById<Button>(R.id.logout_profile)

        db= FirebaseFirestore.getInstance()
        if (email != null) {
            db.collection("USERS").document(email).get()
                .addOnSuccessListener {
                        tasks->
                    nameView.text="NAME: "+tasks.get("Name").toString()
                    emailView.text="EMAIL: "+tasks.get("Email").toString()

                }
        }

        backBtn.setOnClickListener {
            var intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        logoutBtn.setOnClickListener {
            sharedPref.edit().remove("Email").apply()
            var intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}