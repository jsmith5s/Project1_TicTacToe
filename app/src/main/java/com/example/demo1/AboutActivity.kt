package com.example.demo1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        val image : ImageView = findViewById(R.id.imageView)
        val text : TextView = findViewById(R.id.textView2)
        val button : Button = findViewById(R.id.button4)
    }
}