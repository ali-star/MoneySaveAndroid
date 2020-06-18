package ir.siriusapps.moneysave.service

import android.app.*
import android.content.Intent
import android.os.Build
import android.os.IBinder
import android.widget.Toast
import androidx.core.app.NotificationCompat


class AppService : Service() {
    private var manager: NotificationManager? = null

    companion object {
        private const val chanelId = "ForegroundServiceChannel"
    }

    override fun onBind(intent: Intent?): IBinder? {
        TODO("Not yet implemented")
    }

    override fun onCreate() {
        super.onCreate()
        createNotificationChannel()
        val notification: Notification = NotificationCompat.Builder(this, chanelId)
            .setContentTitle("Foreground Service")
            .setContentText("MoneySave app is running")
            .build()
        startForeground(1, notification)
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Toast.makeText(this, "start service", Toast.LENGTH_LONG).show()
        return super.onStartCommand(intent, flags, startId)
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val notificationChannel = NotificationChannel(
                chanelId,
                "App Notification",
                NotificationManager.IMPORTANCE_HIGH
            )
            manager = getSystemService(NotificationManager::class.java)
            manager?.createNotificationChannel(notificationChannel)
        }
    }
}
