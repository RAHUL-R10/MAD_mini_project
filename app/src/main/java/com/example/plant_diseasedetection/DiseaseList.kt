package com.example.plant_diseasedetection

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

class DiseaseList : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_disease_list)
        val clubs= listOf("apple scab",
            "apple black rot",
            "apple cedar ","apple rust"
            ,"apple healthy"
            ,"blueberry healthy"
            ,"cherry including sour powdery mildew"
            ,"cherry including sour healthy"
            ,"corn maize cercospora leaf"
            ,"corn maize common rust"
            ,"corn maize northern leaf blight"
            ,"corn maize healthy"
            ,"grape black rot"
            ,"grape esca black measles"
            ,"grape leaf blight isariopsis leaf spot"
            ,"grape healthy"
            ,"orange haunglongbing citrus greening"
            ,"peach bacterial spot"
            ,"peach healthy"
            ,"pepper bell bacterial spot"
            ,"pepper bell healthy"
            ,"potato early blight"
            ,"potato late blight"
            ,"potato healthy"
            ,"raspberry healthy"
            ,"soybean healthy"
            ,"squash powdery mildew"
            ,"strawberry leaf scorch"
            ,"strawberry healthy"
            ,"tomato bacterial spot"
            ,"tomato early blight"
            ,"tomato late blight"
            ,"tomato leaf mold"
            ,"tomato septoria leaf spot"
            ,"tomato spider mites two spotted spider mite"
            ,"tomato target spot"
            ,"tomato yellow leaf curl virus"
            ,"tomato mosaic virus"
            ,"tomato healthy"
        )

        val view = findViewById<ListView>(R.id.disease_listView)
        view.adapter= ArrayAdapter(this,R.layout.list_items,R.id.text_view_list,clubs)
    }
}