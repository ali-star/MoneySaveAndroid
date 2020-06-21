package ir.siriusapps.moneysave

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class BroadcastReceiverTest {

    private lateinit var mReceiver: MReceiver
    private lateinit var mContext: Context

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        mReceiver = MReceiver()
        mContext = InstrumentationRegistry.getInstrumentation().context
    }

    @Test
    fun test1() {
        val intent = Intent()
        mReceiver.onReceive(mContext, intent)
    }

}

class MReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {

    }
}