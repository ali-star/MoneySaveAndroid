package ir.siriusapps.moneysave

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Build
import android.os.IBinder
import android.widget.Toast
import android.provider.Telephony.Sms.Intents.getMessagesFromIntent
import android.provider.Telephony.Sms.Intents.SMS_RECEIVED_ACTION
import android.util.Log
import com.google.gson.Gson
import dagger.android.AndroidInjection
import dagger.android.DaggerService
import javax.inject.Inject


class AppService: DaggerService() {

    /*
     * in some devices when onStartCommand method is empty, the service is not get started,
     * so we use this boolean to do our important work in onStartCommand when
     * first time service is created instead of using onCreated method.
     */
    private var firstCommand = true

    private val smsReceiverIntentFilter = IntentFilter()
    private lateinit var smsReceiver: BroadcastReceiver

    @Inject lateinit var gson: Gson

    override fun onBind(intent: Intent?): IBinder? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate() {
        AndroidInjection.inject(this)
        super.onCreate()
        Log.i("test", gson.toString())
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        if (firstCommand) {
            // register receiver
            smsReceiverIntentFilter.addAction(SMS_RECEIVED_ACTION)

            smsReceiver = object : BroadcastReceiver() {
                override fun onReceive(context: Context, intent: Intent) {
                    if (Build.VERSION.SDK_INT >= 19) {
                        for (smsMessage in getMessagesFromIntent(intent)) {
                            var messageData = gson.toJson(smsMessage)
                            Toast.makeText(applicationContext, gson.toJson(smsMessage), Toast.LENGTH_LONG).show()
                        }
                    }
                }
            }

            registerReceiver(smsReceiver, smsReceiverIntentFilter)

            firstCommand = false
        }
        return START_STICKY
    }

}