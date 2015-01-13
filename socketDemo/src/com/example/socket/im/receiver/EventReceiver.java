/*   
 * Copyright (c) 2012-2013 Qeemo Ltd. All Rights Reserved.      
 */
package com.example.socket.im.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.example.socket.service.IMService;

/**
 * @author Kurten
 * @date 2014/9/10
 * @time 12:22
 * @vsersion 1.0
 */
public class EventReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        IMService.actionStart(context, null);
    }
}
