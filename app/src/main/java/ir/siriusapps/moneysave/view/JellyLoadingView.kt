package ir.siriusapps.moneysave.view

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.Log
import android.view.View
import ir.siriusapps.moneysave.view.animation.ElasticInOutInterpolator
import kotlin.math.max
import kotlin.math.min

class JellyLoadingView : View {

    private lateinit var paint: Paint
    private lateinit var path: Path

    private var cw: Int = 0
    private var ch: Int = 0
    private lateinit var itemRect: RectF

    private var itemWith: Float = 50f
    private var itemHeight: Float = 50f
    private var itemPadding: Float = 20f
    private var itemYOffset1: Float = 0f
    private var itemYOffset2: Float = 0f
    private var itemYOffset3: Float = 0f

    private var circleRadius1: Float = 0f
    private var circleRadius2: Float = 0f
    private var circleRadius3: Float = 0f

    private var fraction1: Float = 0f
    private var fraction2: Float = 0f
    private var fraction3: Float = 0f

    private var radius: Float = 0f

    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        init()
    }

    fun init() {
        paint = Paint(Paint.ANTI_ALIAS_FLAG)
        paint.color = Color.BLACK
        paint.style = Paint.Style.FILL

        path = Path()

        itemRect = RectF()

        val valueAnimator1 = ValueAnimator.ofFloat(0f, 25f, 0f)
        valueAnimator1.repeatCount = ValueAnimator.INFINITE
        valueAnimator1.duration = 3000
        valueAnimator1.interpolator = ElasticInOutInterpolator()
        valueAnimator1.addUpdateListener {
            itemYOffset1 = it.animatedValue as Float
            fraction1 = it.animatedFraction
            circleRadius1 = if (fraction1 > 0.3f) {
                val m = (((0.72f / 100) * max(0f, fraction1 - 0.28f)) * 100f) * 2
                min(itemWith / 2, (itemWith / 2f) - ((itemWith / 2f) / 100f) * (m * 100f))
            } else
                itemWith / 2
            invalidate()
        }
        valueAnimator1.start()

        val valueAnimator2 = ValueAnimator.ofFloat(0f, 25f, 0f)
        valueAnimator2.repeatCount = ValueAnimator.INFINITE
        valueAnimator2.duration = 3000
        valueAnimator2.interpolator = ElasticInOutInterpolator()
        valueAnimator2.startDelay = 250
        valueAnimator2.addUpdateListener {
            itemYOffset2 = it.animatedValue as Float
            fraction2 = it.animatedFraction
            circleRadius2 = if (fraction2 > 0.3f) {
                val m = (((0.72f / 100) * max(0f, fraction2 - 0.28f)) * 100f) * 2
                min(itemWith / 2, (itemWith / 2f) - ((itemWith / 2f) / 100f) * (m * 100f))
            } else
                itemWith / 2
            invalidate()
        }
        valueAnimator2.start()

        val valueAnimator3 = ValueAnimator.ofFloat(0f, 25f, 0f)
        valueAnimator3.repeatCount = ValueAnimator.INFINITE
        valueAnimator3.duration = 3000
        valueAnimator3.interpolator = ElasticInOutInterpolator()
        valueAnimator3.startDelay = 500
        valueAnimator3.addUpdateListener {
            itemYOffset3 = it.animatedValue as Float
            fraction3 = it.animatedFraction
            circleRadius3 = if (fraction3 > 0.3f) {
                val m = (((0.72f / 100) * max(0f, fraction3 - 0.28f)) * 100f) * 2
                min(itemWith / 2, (itemWith / 2f) - ((itemWith / 2f) / 100f) * (m * 100f))
            } else
                itemWith / 2
            invalidate()
        }
        valueAnimator3.start()
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        cw = width / 2
        ch = height / 2

        radius = itemWith / 2f
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        path.reset()

        itemRect.set(
            cw - (itemWith / 2f) - itemPadding - itemWith,
            ch - (itemHeight / 1.6f) + itemYOffset1,
            cw + (itemWith / 2f) - itemPadding - itemWith,
            ch + (itemHeight / 1.6f) + (itemYOffset1 / 2)
        )
        path.addRoundRect(itemRect, radius, radius, Path.Direction.CW)
        path.addCircle(
            cw - itemPadding - itemWith,
            ch - (((itemHeight) / 100f) * (fraction1 * 100)),
            circleRadius1,
            Path.Direction.CW
        )
        canvas.drawPath(path, paint)

        itemRect.set(
            cw - (itemWith / 2f),
            ch - (itemHeight / 1.6f) + itemYOffset2,
            cw + (itemWith / 2f),
            ch + (itemHeight / 1.6f) + (itemYOffset2 / 2)
        )
        path.addRoundRect(itemRect, radius, radius, Path.Direction.CW)
        path.addCircle(
            cw.toFloat(),
            ch - (((itemHeight) / 100f) * (fraction2 * 100)),
            circleRadius2,
            Path.Direction.CW
        )
        canvas.drawPath(path, paint)

        itemRect.set(
            cw - (itemWith / 2f) + itemPadding + itemWith,
            ch - (itemHeight / 1.6f) + itemYOffset3,
            cw + (itemWith / 2f) + itemPadding + itemWith,
            ch + (itemHeight / 1.6f) + (itemYOffset3 / 2)
        )
        path.addRoundRect(itemRect, radius, radius, Path.Direction.CW)
        path.addCircle(
            cw + itemPadding + itemWith,
            ch - (((itemHeight) / 100f) * (fraction3 * 100)),
            circleRadius3,
            Path.Direction.CW
        )
        canvas.drawPath(path, paint)
    }

}