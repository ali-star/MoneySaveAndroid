package ir.siriusapps.moneysave.customView

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import ir.siriusapps.moneysave.R

class Circle : View {

    private var strokeColor: Int = Color.BLACK
    private var radius: Int = 0
    private var strokeWidth: Int = 0
    private var paint = Paint()

    constructor(context: Context) : super(context)
    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet) {
        initAttr(attributeSet)
    }

    constructor(context: Context, attributeSet: AttributeSet, defStyle: Int) : super(
        context,
        attributeSet,
        defStyle
    ) {
        initAttr(attributeSet)
    }

    private fun initAttr(attributeSet: AttributeSet) {
        val arrayType = context.obtainStyledAttributes(attributeSet, R.styleable.Circle)
        try {
            strokeWidth = arrayType.getDimensionPixelSize(R.styleable.Circle_cr_storkWidth, 1)
            strokeColor = arrayType.getColor(R.styleable.Circle_cr_storkColor, Color.BLACK)
        } finally {
            arrayType.recycle()
        }

    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        radius = (width / 2) - strokeWidth
    }

    override fun draw(canvas: Canvas?) {
        super.draw(canvas)
        paint = Paint()
        paint.color = strokeColor
        paint.strokeWidth = strokeWidth.toFloat()
        paint.style = Paint.Style.STROKE
        paint.isAntiAlias=true
        canvas!!.drawCircle(
            width / 2.toFloat(),
            height / 2.toFloat(), radius.toFloat(), paint
        )
    }
}