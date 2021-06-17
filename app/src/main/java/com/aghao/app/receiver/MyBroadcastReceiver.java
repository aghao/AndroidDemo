package com.aghao.app.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MyBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        switch(intent.getAction()) {
            case "AGHAO" :
                Log.i("justyin", "打开SecondActivity广播会调用此方法");
                break;
            case Intent.ACTION_NEW_OUTGOING_CALL :
                Log.i("justyin", "接收拨出电话广播会调用此方法");
                String number = getResultData();
                setResultData("1" + number);
                break;
            default:
                break;
        }
        throw new UnsupportedOperationException("Not yet implemented");
    }
}