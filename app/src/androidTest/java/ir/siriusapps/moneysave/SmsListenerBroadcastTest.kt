package ir.siriusapps.moneysave

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.platform.app.InstrumentationRegistry
import ir.siriusapps.moneysave.reciver.SmsListenerBroadcast
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class SmsListenerBroadcastTest {

    private lateinit var receiver: SmsListenerBroadcast
    private lateinit var context: Context

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        receiver = SmsListenerBroadcast()
        context = InstrumentationRegistry.getInstrumentation().context
    }

    @Test
    fun test1() {
        val intent = Intent()
        val bundle = Bundle()
        bundle.putByteArray("pdus", byteArrayOf(0, 32, 10,-127, 86, 80, 85, 33, 33, 0, 0, 2, 96, 18,
            50, 100, 81, 73, 10, -24, 116, 58, 13, 98, -105, -45, -20, 48))
        bundle.putString("format", "3gpp")
        bundle.putInt("android.telephony.extra.SUBSCRIPTION_INDEX", 1)
        receiver.onReceive(context, intent)
    }

}