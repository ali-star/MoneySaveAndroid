package ir.siriusapps.moneysave.reciver

import android.content.Context
import android.content.Intent
import androidx.core.content.ContextCompat
import dagger.android.DaggerBroadcastReceiver
import ir.siriusapps.moneysave.service.AppService

class BoatReceiver : DaggerBroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        super.onReceive(context, intent)
        ContextCompat.startForegroundService(context!!, Intent(context, AppService::class.java))
    }
}