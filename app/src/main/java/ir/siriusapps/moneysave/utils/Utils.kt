package ir.siriusapps.moneysave.utils

import android.content.res.Resources

object Utils {
    fun dipToPix(dp: Float): Float {
        return dp * Resources.getSystem().getDisplayMetrics().density
    }

    fun dipToPix(dp: Int): Int {
        return (dp * Resources.getSystem().getDisplayMetrics().density) as Int
    }
}