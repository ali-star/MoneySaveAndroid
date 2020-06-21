package ir.siriusapps.moneysave.presenter.ui

import android.os.Bundle
import dagger.android.support.DaggerAppCompatActivity
import ir.siriusapps.moneysave.R

class MainActivity : DaggerAppCompatActivity() {

    companion object {
        private const val RECEIVE_SMS_PERMISSION_REQUEST_CODE = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        requestPermissionForSms()
    }

    private fun requestPermissionForSms() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(
                    this,
                    Manifest.permission.RECEIVE_SMS)
            ) {
                if (ActivityCompat.checkSelfPermission(
                        this,
                        Manifest.permission.RECEIVE_SMS
                    ) != PackageManager.PERMISSION_GRANTED
                ) {
                    AlertDialog.Builder(this)
                        .setTitle(R.string.requestPermission)
                        .setMessage(R.string.messagePermission)
                        .setPositiveButton(
                            R.string.acceptRequest
                        ) { dialog, _ -> dialog!!.dismiss(); }
                        .setNegativeButton(
                            R.string.ignoreRequest
                        ) { dialog, _ -> dialog!!.dismiss(); }
                        .create()
                        .show()
                }
            } else {
                requestPermission()
            }
        }
    }

    private fun requestPermission() {
        ActivityCompat.requestPermissions(
            this,
            arrayOf(Manifest.permission.RECEIVE_SMS), RECEIVE_SMS_PERMISSION_REQUEST_CODE
        )
    }

}












