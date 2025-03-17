package com.example.marsphotos

import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ServeActivity : AppCompatActivity() {

    lateinit  var mService:MusicService  //im not going to instantiate it

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_serve)

    }

    //starting service -- setting up catering service--rent,hire,buy
    //binding service -- only interested in getting served, not instantiating it
    fun startMusicService(view: View) {
        var msIntent = Intent(this,MusicService::class.java)
        msIntent.putExtra("url","https://download.com/abc")
        //startService(msIntent)
        Log.i(TAG,"about to bind to the service")
        bindService(msIntent, sconnection, BIND_AUTO_CREATE)//1
    }
    fun stopMusicService(view: View) {
        var msIntent = Intent(this,MusicService::class.java)
        unbindService(sconnection)
        //stopService(msIntent)
    }

    //IBinder -- pipe b/w 2 apps, IPC
    // as keyword is used  for typecasting

    val sconnection = object : ServiceConnection {

        override fun onServiceConnected(p0: ComponentName?, binderpipe: IBinder?) {//3
           Log.i(TAG,"onServiceConnected")
            val binder = binderpipe as MusicService.LocalBinder  //4
            mService = binder.getService()  //i didn't instantiate mservice, im pulling it thro binder
            var result = mService.add(10,20)

            Log.i(TAG,"result is $result")
        }

        override fun onServiceDisconnected(p0: ComponentName?) {
            Log.i(TAG,"onServiceDisconnected")

        }

    }

    companion object{
        var  TAG = ServeActivity::class.java.simpleName
    }
    
}