package com.example.marsphotos

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ServeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_serve)

    }

    fun startMusicService(view: View) {
        var msIntent = Intent(this,MusicService::class.java)
        msIntent.putExtra("url","https://download.com/abc")
        startService(msIntent)
    }
    fun stopMusicService(view: View) {
        var msIntent = Intent(this,MusicService::class.java)
        stopService(msIntent)
    }
}