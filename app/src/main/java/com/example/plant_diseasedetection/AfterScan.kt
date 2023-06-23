package com.example.plant_diseasedetection

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class AfterScan : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_after_scan)

        var results=intent.getStringExtra("answer")
        val mImageView = findViewById<ImageView>(R.id.disease_imageView_afterscan)
        val bitmap = intent.getParcelableExtra("Image") as Bitmap?
        val mResult = findViewById<TextView>(R.id.result)

        mImageView.setImageBitmap(bitmap)
        mResult.text = results

        mResult.setOnClickListener {
            val intent = Intent(this,ResultInfo::class.java)
            intent.putExtra("info",results)
            startActivity(intent)
        }

        val sharedPref=getSharedPreferences("Email", Context.MODE_PRIVATE)?:return
        val isLogin=sharedPref.getString("Email","1")

    }
}