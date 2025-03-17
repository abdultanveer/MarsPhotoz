package com.example.marsphotos

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.util.Log
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
//offer this service to activities of other apps
class MusicService : Service() {

    private val binderpipe = LocalBinder()

    override fun onCreate() {
        super.onCreate()
        Log.i(TAG,"service created")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
         super.onStartCommand(intent, flags, startId)
        var dataReceived = intent?.getStringExtra("url")
        Log.i(TAG,"data received = $dataReceived")
//        GlobalScope.launch {
//
//        }
        // condition -- stopSelf()
        return START_STICKY
    }


    fun add(a:Int, b:Int):Int{
        return a+b
    }

    fun getServerJson():String{
        return "{somejson}"
    }


    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG,"service destroyed")
    }


    override fun onBind(intent: Intent): IBinder {
        Log.i(TAG,"im in onbind--returning binder")
        return aidlBinder//2 //aidl - 3
    }

    companion object{
        var TAG = MusicService::class.simpleName
    }

    private val  aidlBinder = object : IMyAidlInterface.Stub() {  //aidl-3
        override fun add(fno: Int, sno: Int): Int {
            return fno + sno
        }

    }


    inner class LocalBinder : Binder() {



        // Return this instance of LocalService so clients can call public methods.
        fun getService(): MusicService = this@MusicService
    }


}
