package ir.siriusapps.moneysave.customView

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatButton
import ir.siriusapps.moneysave.R
import ir.siriusapps.moneysave.utils.Utils


class GradientButton : AppCompatButton {

    private val paint = Paint()
    private var mWidth = 0f
    private var mHeight = 0f
    private lateinit var backgroundRect: RectF
    private lateinit var backgroundRectBlur: RectF
    private val path = Path()
    private var startColor: Int = 0
    private var endColor: Int = 0
    private var angel: Int = 0
    private val mMatrix = Matrix()
    private val paintBlur = Paint()
    private var radius: Float = 0F

    constructor(context: Context) : super(context) {
        initView()
    }

    constructor(context: Context, attrs: AttributeSet? = null) : super(context, attrs) {
        initAttrs(attrs)
        initView()
    }

    constructor(context: Context, attrs: AttributeSet?, defStyle: Int) : super(
        context,
        attrs,
        defStyle
    ) {
        initAttrs(attrs)
        initView()
    }

    private fun initAttrs(attrs: AttributeSet?) {
        context.obtainStyledAttributes(attrs, R.styleable.GradientButton).apply {
            try {
                startColor = getColor(R.styleable.GradientButton_gb_startColor, Color.BLACK)
                endColor = getColor(R.styleable.GradientButton_gb_endColor, Color.WHITE)
                angel = getColor(R.styleable.GradientButton_gb_angle, 45)
                radius = getDimensionPixelSize(
                    R.styleable.GradientButton_gb_radius,
                    Utils.dipToPix(16)
                ).toFloat()
            } finally {
                recycle()
            }
        }
    }

    private fun initView() {
        setLayerType(LAYER_TYPE_SOFTWARE, null)
        mMatrix.reset()
        mMatrix.setRotate(angel.toFloat())
        backgroundRect = RectF()
        backgroundRectBlur = RectF()
    }


    override fun onDraw(canvas: Canvas?) {
        path.reset()
        path.addRoundRect(
            backgroundRect,
            Utils.dipToPix(radius),
            Utils.dipToPix(radius),
            Path.Direction.CW
        )
        canvas!!.drawPath(path, paint)
        super.onDraw(canvas)
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        mWidth = w.toFloat()
        mHeight = h.toFloat()

        backgroundRect.set(0F, 0F, mWidth, mHeight)
        paint.setShader(
            LinearGradient(
                0F,
                0F,
                mWidth,
                mHeight,
                startColor,
                endColor,
                Shader.TileMode.CLAMP
            )
        ).setLocalMatrix(mMatrix)
    }

}