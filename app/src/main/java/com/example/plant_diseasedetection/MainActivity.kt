package com.example.plant_diseasedetection

import android.app.Activity
import android.content.Intent
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Matrix
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import java.io.IOException

class MainActivity : AppCompatActivity() {

    private lateinit var mClassifier: Classifier
    private lateinit var mBitmap: Bitmap

    private val mCameraRequestCode = 0
    private val mGalleryRequestCode = 2

    private val mInputSize = 224
    private val mModelPath = "plant_disease_model.tflite"
    private val mLabelPath = "plant_labels.txt"
    private val mSamplePath = "insect.png"

    private lateinit var drawerLayout: DrawerLayout
    lateinit var navView: NavigationView
    lateinit var actionBarDrawerToggle: ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPref=getSharedPreferences("Email",Context.MODE_PRIVATE)?:return
        val isLogin=sharedPref.getString("Email","1")


        if(isLogin=="1")
        {
            var email=intent.getStringExtra("Email")
            if(email!=null)
            {
                with(sharedPref.edit())
                {
                    putString("Email",email)
                    apply()
                }
            }
            else{
                var intent = Intent(this,LoginActivity::class.java)
                startActivity(intent)
                finish()
            }
        }

        mClassifier = Classifier(assets, mModelPath, mLabelPath, mInputSize)

        val diseaseImage = findViewById<ImageView>(R.id.disease_imageView)
        val mCameraBtn = findViewById<ImageButton>(R.id.camera_btn)
        val mGalleryBtn = findViewById<ImageButton>(R.id.gallery_btn)
        val mDetectBtn = findViewById<Button>(R.id.detect_btn)


        resources.assets.open(mSamplePath).use {
            mBitmap = BitmapFactory.decodeStream(it)
            mBitmap = Bitmap.createScaledBitmap(mBitmap, mInputSize, mInputSize, true)
            diseaseImage.setImageBitmap(mBitmap)
        }

        mCameraBtn.setOnClickListener {
            val callCameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(callCameraIntent, mCameraRequestCode)
        }

        mGalleryBtn.setOnClickListener {
            val callGalleryIntent = Intent(Intent.ACTION_PICK)
            callGalleryIntent.type = "image/*"
            startActivityForResult(callGalleryIntent, mGalleryRequestCode)
        }

        mDetectBtn.setOnClickListener {
            val results = mClassifier.recognizeImage(mBitmap).firstOrNull()

            val intent = Intent(this, AfterScan:: class.java)
            intent.putExtra("Image",mBitmap)
            intent.putExtra("answer",results?.title+ "\n confidence:"+results?.confidence)
            startActivity(intent)
        }

        var myToolbar : Toolbar? = findViewById<Toolbar>(R.id.my_toolbar)
        setSupportActionBar(myToolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        drawerLayout = findViewById(R.id.drawer_layout)
        actionBarDrawerToggle = ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close)
        drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()


        navView = findViewById(R.id.nav_view)

        navView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.home -> {
                    Toast.makeText(this@MainActivity, "Home Clicked", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this,MainActivity::class.java)
                    startActivity(intent)
                    finish()
                }
                R.id.diseases -> {
                    Toast.makeText(this@MainActivity, "Diseases Clicked", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this,DiseaseList::class.java)
                    startActivity(intent)
                }
                R.id.profile -> {
                    Toast.makeText(this@MainActivity, "Profile Clicked", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this,Profile::class.java)
                    startActivity(intent)
                }
                R.id.about -> {
                    Toast.makeText(this@MainActivity, "About Clicked", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this,AboutUs::class.java)
                    startActivity(intent)
                }
                R.id.logout -> {
                    Toast.makeText(this@MainActivity, "Logout Clicked", Toast.LENGTH_SHORT).show()
                    sharedPref.edit().remove("Email").apply()
                    var intent = Intent(this,MainActivity::class.java)
                    startActivity(intent)
                    finish()
                }
            }
            true
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val diseaseImage = findViewById<ImageView>(R.id.disease_imageView)

        if(requestCode == mCameraRequestCode){
            if(resultCode == Activity.RESULT_OK && data != null) {
                mBitmap = data.extras!!.get("data") as Bitmap
                mBitmap = scaleImage(mBitmap)

                diseaseImage.setImageBitmap(mBitmap)

            } else {
                Toast.makeText(this, "Camera cancel..", Toast.LENGTH_LONG).show()
            }
        } else if(requestCode == mGalleryRequestCode) {
            if (data != null) {
                val uri = data.data

                try {
                    mBitmap = MediaStore.Images.Media.getBitmap(this.contentResolver, uri)
                } catch (e: IOException) {
                    e.printStackTrace()
                }

                println("Success!!!")
                mBitmap = scaleImage(mBitmap)
                diseaseImage.setImageBitmap(mBitmap)

            }
        } else {
            Toast.makeText(this, "Unrecognized request code", Toast.LENGTH_LONG).show()

        }
    }


    private fun scaleImage(bitmap: Bitmap?): Bitmap {
        val orignalWidth = bitmap!!.width
        val originalHeight = bitmap.height
        val scaleWidth = mInputSize.toFloat() / orignalWidth
        val scaleHeight = mInputSize.toFloat() / originalHeight
        val matrix = Matrix()
        matrix.postScale(scaleWidth, scaleHeight)
        return Bitmap.createBitmap(bitmap, 0, 0, orignalWidth, originalHeight, matrix, true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            true
        } else super.onOptionsItemSelected(item)
    }
}