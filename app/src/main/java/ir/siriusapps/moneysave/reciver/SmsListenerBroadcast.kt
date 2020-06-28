package ir.siriusapps.moneysave.reciver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import android.provider.Telephony
import android.widget.Toast
import androidx.annotation.RequiresApi
import java.lang.StringBuilder

class SmsListenerBroadcast:BroadcastReceiver() {
    @RequiresApi(Build.VERSION_CODES.KITKAT)
    override fun onReceive(context: Context?, intent: Intent?) {
        if (Telephony.Sms.Intents.SMS_RECEIVED_ACTION == intent?.action){
            val bundle = intent.extras
            if (bundle != null) {
                try {
                    val smsMessages = Telephony.Sms.Intents.getMessagesFromIntent(intent)
                    val messageBody = StringBuilder()
                    for (message in smsMessages) {
                        messageBody.append(message.messageBody)
                    }
                    Toast.makeText(context, messageBody.toString(), Toast.LENGTH_LONG).show()
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
    }
}