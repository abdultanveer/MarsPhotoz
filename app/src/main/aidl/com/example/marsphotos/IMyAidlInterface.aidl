// IMyAidlInterface.aidl
package com.example.marsphotos;


interface IMyAidlInterface {//aidl-2

           int add(int fno, int sno);
}

//1. enable aidl  in app gradle
//2. right click on package- select new-aidl-aidl file
//3. in aidl file add  a method add(a,b)
//4. in the music service create a aidl binder and returnn it
//5 in manifest -add an intent filter