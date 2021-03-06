package ir.siriusapps.moneysave.presenter.ui

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentFactory
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import ir.siriusapps.moneysave.R

import ir.siriusapps.moneysave.service.AppService
import javax.inject.Inject

class MainActivity : AppCompatActivity(), HasAndroidInjector {

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    @Inject
    lateinit var fragmentFactory: FragmentFactory

    override fun androidInjector(): AndroidInjector<Any> = androidInjector

    companion object {
        private const val RECEIVE_SMS_PERMISSION_REQUEST_CODE = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        supportFragmentManager.fragmentFactory = fragmentFactory

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        requestPermissionForSms()
    }

    fun changeStatusBarColor(color: Int) {

    }

    private fun requestPermissionForSms() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(
                    this,
                    Manifest.permission.RECEIVE_SMS
                )
            ) {
                if (ActivityCompat.checkSelfPermission(
                        this,
                        Manifest.permission.RECEIVE_SMS
                    ) != PackageManager.PERMISSION_GRANTED
                ) {
                    askForGrantPermission()
                }
            } else {
                requestPermission()
            }
        } else {
            ContextCompat.startForegroundService(
                applicationContext,
                Intent(applicationContext, AppService::class.java)
            )
        }
    }

    private fun askForGrantPermission() {
        AlertDialog.Builder(this)
            .setTitle(R.string.requestPermission)
            .setMessage(R.string.messagePermission)
            .setPositiveButton(
                R.string.acceptRequest
            ) { _, _ -> requestPermission(); }
            .setNegativeButton(
                R.string.ignoreRequest
            ) { dialog, _ ->
                dialog!!.dismiss()
                finish()
            }
            .create()
            .show()
    }

    private fun requestPermission() {
        ActivityCompat.requestPermissions(
            this,
            arrayOf(Manifest.permission.RECEIVE_SMS), RECEIVE_SMS_PERMISSION_REQUEST_CODE
        )
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == RECEIVE_SMS_PERMISSION_REQUEST_CODE
            && permissions[0] == Manifest.permission.RECEIVE_SMS
            && grantResults[0] == PackageManager.PERMISSION_GRANTED
        ) {
            ContextCompat.startForegroundService(
                applicationContext,
                Intent(applicationContext, AppService::class.java)
            )
        } else {
            stopService(Intent(this, AppService::class.java))
            finish()
        }
    }

}
