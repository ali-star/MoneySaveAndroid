package ir.siriusapps.moneysave.service

import android.R
import android.app.*
import android.content.Intent
import android.os.Build
import android.os.IBinder
import android.util.Log
import androidx.core.app.NotificationCompat


class AppService : Service() {

    val CHANNEL_ID = "ForegroundServiceChannel"
    private var manager: NotificationManager? = null

    override fun onBind(intent: Intent?): IBinder? {
        TODO("Not yet implemented")
    }

    override fun onCreate() {

        super.onCreate()
        createNotificationChannel()
        val notification: Notification = NotificationCompat.Builder(this, CHANNEL_ID)
            .setContentTitle("Foreground Service")
            .setContentText("MoneySave app is running")
            .setSmallIcon(R.drawable.alert_light_frame)
            .build()
        Log.i("TAG", "start")
        startForeground(1, notification)

    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        return super.onStartCommand(intent, flags, startId)
    }

    private fun createNotificationChannel() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val notificatoinChannel = NotificationChannel(
                CHANNEL_ID,
                "App Notification",
                NotificationManager.IMPORTANCE_LOW
            )
            manager = getSystemService(NotificationManager::class.java)
            manager?.createNotificationChannel(notificatoinChannel)
        }
    }

}
