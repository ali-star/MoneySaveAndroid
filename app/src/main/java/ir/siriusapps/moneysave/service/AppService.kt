package ir.siriusapps.moneysave.service

import android.app.*
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Build
import android.os.IBinder
import android.provider.Settings
import android.widget.Toast
import androidx.core.app.NotificationCompat
import ir.siriusapps.moneysave.presenter.ui.MainActivity
import ir.siriusapps.moneysave.reciver.SmsListenerBroadcast


class AppService : Service() {

    private var manager: NotificationManager? = null
    private lateinit var smsListenerBroadcast: BroadcastReceiver

    companion object {
        private const val channelId = "AppServiceChannel"
    }

    override fun onBind(intent: Intent?): IBinder? {
        TODO("Not yet implemented")
    }

    override fun onCreate() {
        super.onCreate()
        manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        createNotificationChannel()
        val intent = if (Build.VERSION.SDK_INT > Build.VERSION_CODES.O) {
            Intent(Settings.ACTION_CHANNEL_NOTIFICATION_SETTINGS)
                .putExtra(Settings.EXTRA_APP_PACKAGE, packageName)
                .putExtra(Settings.EXTRA_CHANNEL_ID, channelId)
        } else {
            Intent(applicationContext, MainActivity::class.java)
        }
        val pendingIntent = PendingIntent.getActivity(
            applicationContext,
            2,
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT
        )
        val notification: Notification = NotificationCompat.Builder(this, channelId)
            .setContentTitle("Foreground Service")
            .setContentText("MoneySave app is running")
            .setSmallIcon(android.R.drawable.alert_light_frame)
            .setContentIntent(pendingIntent)
            .build()
        startForeground(1, notification)
        val smsListenerIntentFilter = IntentFilter()
        smsListenerIntentFilter.addAction("android.provider.Telephony.SMS_RECEIVED")
        smsListenerBroadcast = SmsListenerBroadcast()
        registerReceiver(smsListenerBroadcast, smsListenerIntentFilter)

        Toast.makeText(applicationContext, "Service Started", Toast.LENGTH_LONG).show()
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val notificationChannel = NotificationChannel(
                channelId,
                "App Notification",
                NotificationManager.IMPORTANCE_MIN
            )
            manager?.createNotificationChannel(notificationChannel)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        try {
            unregisterReceiver(smsListenerBroadcast)
        } catch (ignored: Exception) {
        }
        stopForeground(true)
    }

}
