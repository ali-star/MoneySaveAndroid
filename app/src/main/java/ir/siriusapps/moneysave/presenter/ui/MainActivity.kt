package ir.siriusapps.moneysave.presenter.ui

import android.os.Bundle
import dagger.android.support.DaggerAppCompatActivity
import ir.siriusapps.moneysave.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            button.text = "work"
        }
    }
}
