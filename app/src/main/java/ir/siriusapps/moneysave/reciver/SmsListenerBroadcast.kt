package ir.siriusapps.moneysave.reciver

import android.content.Context
import android.content.Intent
import android.os.Build
import android.provider.Telephony
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.google.code.regexp.Pattern
import dagger.android.DaggerBroadcastReceiver
import ir.siriusapps.moneysave.domain.entity.BankAccount
import ir.siriusapps.moneysave.domain.entity.Transaction
import ir.siriusapps.moneysave.domain.iteractors.bankaccount.SearchBankAccountByNumber
import kotlinx.coroutines.runBlocking
import saman.zamani.persiandate.PersianDate
import java.lang.StringBuilder
import java.util.*
import javax.inject.Inject

class SmsListenerBroadcast : DaggerBroadcastReceiver() {

    @Inject
    lateinit var searchBankAccountByNumber: SearchBankAccountByNumber

    val phoneNumberBanks = arrayListOf("9107324708", "9907473597")

    @RequiresApi(Build.VERSION_CODES.KITKAT)
    override fun onReceive(context: Context?, intent: Intent?) {
        super.onReceive(context, intent)

        if (Telephony.Sms.Intents.SMS_RECEIVED_ACTION == intent?.action) {
            val bundle = intent.extras
            if (bundle != null) {
                try {
                    val smsMessages = Telephony.Sms.Intents.getMessagesFromIntent(intent)
                    val messageBody = StringBuilder()
                    val senderNumber: String? = smsMessages[0].originatingAddress
                    for (i in 0..phoneNumberBanks.size)
                        if (senderNumber!!.contains(phoneNumberBanks[i])) {
                            for (message in smsMessages)
                                messageBody.append(message.messageBody)

                            val transaction = convertSmsMessageToTransaction(messageBody.toString())

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

    private fun convertSmsMessageToTransaction(messageBody: String): Transaction? {
        val pattern = Pattern.compile("\\*\\W+\\*\\n\\W+\\n\\W+(?<AccountNumber>\\d.+)\\n\\W+(?<Amount>\\d.+)\\s+\\W+\\n((?<Year>\\d{2})\\/(?<Month>\\d{2})\\/(?<Day>\\d{2}))\\w((?<Hour>\\d{2})\\W(?<Minute>\\d{2}))\\n\\W+(?<Inventory>\\d.+) \\W+")
        val matcher = pattern.matcher(messageBody)
        if (matcher.find()) {
            val persianDate = PersianDate()

            val accountNumber = matcher.group("AccountNumber")
            val amount = matcher.group("Amount").toDouble()
            val inventory = matcher.group("Inventory").toDouble()
            val year = matcher.group("Year")?.toInt() ?: persianDate.shYear
            val month = matcher.group("Month").toInt()
            val dayOfMonth = matcher.group("Day").toInt()
            val hour = matcher.group("Hour").toInt()
            val minute = matcher.group("Minute").toInt()

            val transactionType = if (messageBody.contains("برداشت") || amount < 0)
                Transaction.Type.WITHDRAWAL
            else
                Transaction.Type.DEPOSIT

            persianDate.shYear = year
            persianDate.shMonth = month
            persianDate.shDay = dayOfMonth
            persianDate.hour = hour
            persianDate.minute = minute

            val calendar = Calendar.getInstance()
            calendar.set(
                persianDate.grgYear,
                persianDate.grgMonth,
                persianDate.grgDay,
                persianDate.hour,
                persianDate.minute, 0
            )

            val bankAccount: BankAccount? = null
            runBlocking {
                searchBankAccountByNumber.execute(accountNumber)
            }

            return Transaction(
                null,
                null,
                Date(calendar.timeInMillis),
                transactionType,
                bankAccount?.localId ?: -1,
                amount,
                inventory
            )
        }
        return null
    }
}