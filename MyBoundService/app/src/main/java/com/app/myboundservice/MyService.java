package com.app.myboundservice;

import android.app.Service;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;

public class MyService extends Service {

    MyBinder myBinder = new MyBinder();
    public MyService() {

    }

    @Override
    public IBinder onBind(Intent intent) {
        return myBinder;
    }

    @Override
    public void onRebind(Intent intent) {
        super.onRebind(intent);
    }

    @Override
    public void unbindService(ServiceConnection conn) {
        super.unbindService(conn);
    }

    public String getSum(int x, int y){
        return (x+y) + "";
    }



    class MyBinder extends Binder{
        MyService getService(){
            return MyService.this;
        }
    }
}
