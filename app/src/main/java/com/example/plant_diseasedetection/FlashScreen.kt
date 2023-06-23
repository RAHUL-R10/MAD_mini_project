package com.example.plant_diseasedetection

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity

class FlashScreen : AppCompatActivity() {

    private lateinit var video:VideoView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_flashscreen)
        video = findViewById(R.id.video)
        val uri = Uri.parse("android.resource://" + packageName + "/" + R.raw.video_bg)
        video.setVideoURI(uri)
        video.start()
        video.setOnPreparedListener { mp -> mp.isLooping = true }
        video.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun onPostResume() {
        video.resume()
        super.onPostResume()
    }

    override fun onRestart() {
        video.start()
        super.onRestart()
    }

    override fun onPause() {
        video.suspend()
        super.onPause()
    }

    override fun onDestroy() {
        video.stopPlayback()
        super.onDestroy()
    }
}