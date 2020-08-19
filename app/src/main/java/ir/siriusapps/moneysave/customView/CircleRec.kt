package ir.siriusapps.moneysave.customView

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import ir.siriusapps.moneysave.R
import java.util.jar.Attributes

class CircleRec : View {

    private var strokeColor: Int = Color.BLACK
    private var strokeWidth: Int = 0
    private var startAngel: Float = 0F
    private var endAngel: Float = 0F
    private var paint = Paint()
    private var rect = RectF()
    private var path = Path()

    constructor(context: Context) : super(context)
    constructor(context: Context, attributes: AttributeSet) : super(context, attributes) {
        initAttributes(attributes)
    }

    constructor(context: Context, attributes: AttributeSet, defStyle: Int) : super(
        context,
        attributes,
        defStyle
    ) {
        initAttributes(attributes)
    }

    private fun initAttributes(attributes: AttributeSet) {
        val typedArray = context.obtainStyledAttributes(attributes, R.styleable.CircleRec)
        try {
            strokeColor = typedArray.getColor(R.styleable.CircleRec_rcr_strokColor, Color.BLACK)
            strokeWidth = typedArray.getDimensionPixelSize(R.styleable.CircleRec_rcr_strokWidth, 1)
            startAngel = typedArray.getFloat(R.styleable.CircleRec_rcr_StartAngel, 0F)
            endAngel = typedArray.getFloat(R.styleable.CircleRec_rcr_endAngel, 90F)
        } finally {
            typedArray.recycle()
        }

    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        rect.set(0F+strokeWidth, 0F+strokeWidth, width.toFloat()-strokeWidth, height.toFloat()-strokeWidth)
    }

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        paint.color = strokeColor;
        paint.strokeWidth = strokeWidth.toFloat()
        paint.style = Paint.Style.STROKE
        canvas!!.drawArc(rect, startAngel, endAngel, false, paint)
    }

    public fun reDraw(increaseDegree: Int) {
        endAngel += increaseDegree
        if (endAngel == 360F)
            endAngel = 10F
        invalidate()
    }

}