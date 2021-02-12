package ir.siriusapps.moneysave.view

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import ir.siriusapps.moneysave.R
import ir.siriusapps.moneysave.presenter.dpToPx
import kotlin.properties.Delegates


class TransferLoading:View {

    private lateinit var paint: Paint
    private lateinit var leftBottomRoundRectShape: RectF
    private lateinit var leftTopRoundRectShape: RectF
    private lateinit var rightBottomRoundRectShape: RectF
    private lateinit var rightTopRoundRectShape: RectF
    private lateinit var path: Path
    private lateinit var valueAnimator: ValueAnimator

    private var mBackgroundColor: Int = Color.BLACK
    private var borderColor: Int = Color.BLACK

    private var startXLeftBottom :Float? =null
    private var endXLeftBottom :Float? =null
    private var startYLeftBottom :Float? =null
    private var endYLeftBottom :Float? =null

    private var startXLeftTop  :Float? =null
    private var endXLeftTop  :Float? =null
    private var startYLeftTop  :Float? =null
    private var endYLeftTop  :Float? =null

    private var startXRightBottom  :Float? =null
    private var endXRightButton  :Float? =null
    private var startYRightButton  :Float? =null
    private var endYRightButton  :Float? =null

    private var startXRightTop  :Float? =null
    private var endXRightTop  :Float? =null
    private var startYRightTop  :Float? =null
    private var endYRightTop  :Float? =null

    private var negativeValue: Float = 0F
    private var positiveValue: Float = 0F

    constructor(context: Context):super(context){
        init()
    }
    constructor(context: Context, attributeSet: AttributeSet): super(context, attributeSet){
        init()
        initAttr(attributeSet)
    }
    constructor(context: Context, attributeSet: AttributeSet, defStyleAttr: Int): super(
        context,
        attributeSet,
        defStyleAttr
    ){
        init()
        initAttr(attributeSet)
    }

    private fun initAttr(attributeSet: AttributeSet){
        val typeArray = context.obtainStyledAttributes(attributeSet, R.styleable.TransferLoading)
        try {
            mBackgroundColor = typeArray.getInt(R.styleable.TransferLoading_tl_BackgroundColor, Color.BLACK)
            borderColor = typeArray.getInt(R.styleable.TransferLoading_tl_BorderColor, Color.BLACK)
        } finally {
            typeArray.recycle()
        }
    }

    private fun init(){
        paint = Paint()
        paint.style = Paint.Style.FILL
        paint.color = mBackgroundColor

        path = Path()

        leftBottomRoundRectShape = RectF()
        rightBottomRoundRectShape = RectF()
        leftTopRoundRectShape = RectF()
        rightTopRoundRectShape = RectF()

        valueAnimator =  ValueAnimator.ofFloat(0F, 100F)
        valueAnimator.repeatCount = ValueAnimator.INFINITE
        valueAnimator.interpolator = AccelerateDecelerateInterpolator()
        valueAnimator.duration = 1000

        valueAnimator.addUpdateListener { valueAnimator ->
            if (startYLeftBottom?.isNaN() == false && startYLeftBottom!! < height/3.toFloat())
                     valueAnimator.cancel()
                negativeValue -= dpToPx(2)
                positiveValue += dpToPx(0)
                invalidate()
        }

        valueAnimator.start()

    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        path.reset()

        startXLeftBottom = 0F + dpToPx(2)
        endXLeftBottom = width.toFloat()/2 - dpToPx(2)
        startYLeftBottom = height.toFloat()/2 + dpToPx(4) +negativeValue
        endYLeftBottom = height.toFloat() - dpToPx(2)

        leftBottomRoundRectShape.set(
            startXLeftBottom!!,
            startYLeftBottom!!,
            endXLeftBottom!!,
            endYLeftBottom!!,
        )

        startXRightBottom = width.toFloat()/2 +dpToPx(2)
        endXRightButton = width.toFloat() - dpToPx(2)
        startYRightButton= height.toFloat()/2 + dpToPx(2)
        endYRightButton = height.toFloat() - dpToPx(2)

        rightBottomRoundRectShape.set(
            startXRightBottom!!,
            startYRightButton!!,
            endXRightButton!!,
            endYRightButton!!,
        )
        startXLeftTop = 0F + dpToPx(2)
        endXLeftTop = width.toFloat()/2 - dpToPx(2)
        startYLeftTop = 0F + dpToPx(2)
        endYLeftTop = height.toFloat()/2 -dpToPx(2)  + negativeValue

        leftTopRoundRectShape.set(
            startXLeftTop!!,
            startYLeftTop!!,
            endXLeftTop!!,
            endYLeftTop!!
        )

        startXRightTop = width.toFloat()/2 + dpToPx(2)
        startYRightTop = 0F + dpToPx(2)
        endXRightTop = width.toFloat() - dpToPx(2)
        endYRightTop = height.toFloat()/2 - dpToPx(2)

        rightTopRoundRectShape.set(
            startXRightTop!!,
            startYRightTop!!,
            endXRightTop!!,
            endYRightTop!!
        )


        path.addRoundRect(
            leftBottomRoundRectShape,
            dpToPx(10),
            dpToPx(10),
            Path.Direction.CW
        )

        path.addRoundRect(
            rightBottomRoundRectShape,
            dpToPx(10),
            dpToPx(10),
            Path.Direction.CW
        )

        path.addRoundRect(leftTopRoundRectShape, dpToPx(10), dpToPx(10), Path.Direction.CW)
        path.addRoundRect(rightTopRoundRectShape, dpToPx(10), dpToPx(10), Path.Direction.CW)

        canvas?.drawPath(path, paint)
    }
}