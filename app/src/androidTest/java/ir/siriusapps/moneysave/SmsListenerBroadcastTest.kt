package ir.siriusapps.moneysave

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.provider.Telephony
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.platform.app.InstrumentationRegistry
import com.google.gson.Gson
import ir.siriusapps.moneysave.reciver.SmsListenerBroadcast
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import java.lang.StringBuilder

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

    }

}