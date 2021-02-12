package ir.siriusapps.moneysave.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View
import ir.siriusapps.moneysave.R
import ir.siriusapps.moneysave.utils.Utils

class CircleProgress : View {

    private var progressStrokeColor: Int = Color.BLACK
    private var progressStrokeWidth: Int = 0
    private var strokeColor: Int = Color.BLACK
    private var strokeWidth: Int = 0
    private var backgroundStrokePaint = Paint()
    private var progressPaint = Paint()
    private var rect = RectF()

    var progress = 0
        set(value) {
            field = value
            invalidate()
        }

    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet) {
        initAttr(attributeSet)
        init()
    }

    constructor(context: Context, attributeSet: AttributeSet, defStyle: Int) : super(
        context,
        attributeSet,
        defStyle
    ) {
        initAttr(attributeSet)
        init()
    }

    private fun init() {
        setLayerType(LAYER_TYPE_SOFTWARE, null)

        backgroundStrokePaint.color = strokeColor
        backgroundStrokePaint.strokeWidth = strokeWidth.toFloat()
        backgroundStrokePaint.style = Paint.Style.STROKE
        backgroundStrokePaint.isAntiAlias = true

        progressPaint.isAntiAlias = true
        progressPaint.color = progressStrokeColor;
        progressPaint.strokeWidth = progressStrokeWidth.toFloat()
        progressPaint.style = Paint.Style.STROKE
    }

    private fun initAttr(attributeSet: AttributeSet) {
        val arrayType = context.obtainStyledAttributes(attributeSet, R.styleable.CircleProgress)
        try {
            strokeWidth =
                arrayType.getDimensionPixelSize(R.styleable.CircleProgress_cr_storkWidth, Utils.dipToPix(4))
            strokeColor = arrayType.getColor(R.styleable.CircleProgress_cr_storkColor, Color.BLACK)
            progressStrokeColor =
                arrayType.getColor(R.styleable.CircleProgress_cr_progressStrokeColor, Color.WHITE)
            progressStrokeWidth = arrayType.getDimensionPixelSize(
                R.styleable.CircleProgress_cr_progressStrokeWidth,
                Utils.dipToPix(4)
            )
            progress = arrayType.getInt(R.styleable.CircleProgress_cr_progress, 0)
        } finally {
            arrayType.recycle()
        }

    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        rect.set(
            progressStrokeWidth.toFloat(),
            progressStrokeWidth.toFloat(),
            w.toFloat() - progressStrokeWidth,
            h.toFloat() - progressStrokeWidth
        )

    }

    override fun draw(canvas: Canvas?) {
        super.draw(canvas)
        canvas!!.drawOval(rect, backgroundStrokePaint)
        
        val angle = 360f * progress.toFloat() / 100f
        canvas.drawArc(rect, -90f, angle, false, progressPaint)
    }
}