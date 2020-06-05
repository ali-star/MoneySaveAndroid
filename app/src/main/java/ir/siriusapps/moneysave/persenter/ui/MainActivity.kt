package ir.siriusapps.moneysave.persenter.ui

import android.app.Activity
import android.os.Bundle
import dagger.android.support.DaggerAppCompatActivity
import ir.siriusapps.moneysave.R
import ir.siriusapps.moneysave.framework.db.mainDb.AppDatabase
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
