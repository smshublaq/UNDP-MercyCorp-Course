package com.app.boundservices;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class MyService extends Service {
    MyBinder myBinder = new MyBinder();
    public MyService() {

    }



    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return myBinder;
    }

    class MyBinder extends Binder{
        public MyService getService(){
            return MyService.this;
        }
    }

    public String getSum(int x,int y){
        return (x+y) + "";
    }

    public String getCurrentTime(){
        return System.currentTimeMillis() + "";
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }
}
