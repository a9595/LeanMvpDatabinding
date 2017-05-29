package com.infullmobile.neuca.presentation.common.extensions

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.support.v4.content.LocalBroadcastManager

/**
 * Created by gabrieljanucik on 15.03.2017.
 */
class LocalBroadcastManagerExtension

fun LocalBroadcastManager.registerCallback(action: String, callback: (Intent) -> Unit): BroadcastReceiver {
    val receiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            callback(intent)
        }
    }
    registerReceiver(receiver, IntentFilter(action))
    return receiver
}