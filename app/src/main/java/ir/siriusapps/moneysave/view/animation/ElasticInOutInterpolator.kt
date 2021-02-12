package ir.siriusapps.moneysave.view.animation

import android.view.animation.Interpolator
import kotlin.math.*

class ElasticInOutInterpolator : Interpolator {
    override fun getInterpolation(t: Float): Float {
        val pi2 = Math.PI * 2
        val s = .45 / pi2 * asin(1.0)
        var o = t * 2f
        return if (o < 1) {
            o -= 1f
            (-0.5f * (2.0.pow((10 * o).toDouble()) * sin((o - s) * pi2 / .45))).toFloat()
        } else {
            o -= 1f
            (2.0.pow((-10 * o).toDouble()) * sin((o - s) * pi2 / .45) * 0.5 + 1).toFloat()
        }
    }
}