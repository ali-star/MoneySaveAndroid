package ir.siriusapps.moneysave.reciver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.provider.Telephony
import android.widget.Toast
import java.lang.StringBuilder

class SmsListenerBroadcast:BroadcastReceiver() {
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