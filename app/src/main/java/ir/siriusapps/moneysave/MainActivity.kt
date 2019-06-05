package ir.siriusapps.moneysave

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.gson.Gson
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import ir.siriusapps.moneysave.model.SmsMessage
import javax.inject.Inject

class MainActivity : AppCompatActivity(), HasActivityInjector {

    @Inject lateinit var injector: DispatchingAndroidInjector<Activity>
    @Inject lateinit var gson: Gson

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i("test", gson.toString())
    }

    override fun activityInjector(): AndroidInjector<Activity> {
        return injector
    }
}
