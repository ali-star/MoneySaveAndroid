package ir.siriusapps.moneysave.reciver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import android.provider.Telephony
import android.widget.Toast
import androidx.annotation.RequiresApi
import java.lang.StringBuilder

class SmsListenerBroadcast : BroadcastReceiver() {

    val phoneNumberBanks = arrayListOf("9107324708", "9907473597")

    @RequiresApi(Build.VERSION_CODES.KITKAT)
    override fun onReceive(context: Context?, intent: Intent?) {

        if (Telephony.Sms.Intents.SMS_RECEIVED_ACTION == intent?.action) {
            val bundle = intent.extras
            if (bundle != null) {
                try {
                    val smsMessages = Telephony.Sms.Intents.getMessagesFromIntent(intent)
                    val messageBody = StringBuilder()
                    var senderNumber: String? = smsMessages[0].originatingAddress
                    for (i in 0..phoneNumberBanks.size)
                        if (senderNumber!!.contains(phoneNumberBanks[i])) {
                            for (message in smsMessages)
                                messageBody.append(message.messageBody)
                            Toast.makeText(
                                context,
                                senderNumber + "\n" + messageBody.toString(),
                                Toast.LENGTH_LONG
                            )
                                .show()
                            break
                        }
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
    }
}