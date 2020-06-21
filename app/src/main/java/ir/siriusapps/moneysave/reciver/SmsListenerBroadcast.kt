package ir.siriusapps.moneysave.reciver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import android.provider.Telephony
import android.telephony.SmsMessage
import android.widget.Toast

class SmsListenerBroadcast:BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if (Telephony.Sms.Intents.SMS_RECEIVED_ACTION == intent?.action){
            val bundle = intent.extras
            if (bundle != null) {
                try {
                    val pdus = bundle["pdus"] as Array<*>?
                    val smsMessage = ArrayList<SmsMessage>(pdus!!.size)
                    val messageBody = StringBuilder()
                    for (i in 0 until smsMessage.size) {
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                            smsMessage[i] = SmsMessage.createFromPdu(
                                pdus[i] as ByteArray,
                                bundle.getString("format")
                            )
                        } else {
                            smsMessage[i] = SmsMessage.createFromPdu(pdus[i] as ByteArray)
                        }
                        messageBody.append(smsMessage[i].messageBody)
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
    }
}