package ir.siriusapps.moneysave.persenter.ui

import android.os.Bundle
import dagger.android.support.DaggerAppCompatActivity
import ir.siriusapps.moneysave.R

class MainActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
