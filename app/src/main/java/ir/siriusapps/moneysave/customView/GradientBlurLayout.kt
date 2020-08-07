package ir.siriusapps.moneysave.customView

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import ir.siriusapps.moneysave.R
import ir.siriusapps.moneysave.utils.Utils
import okhttp3.internal.Util

class GradientBlurLayout : View {
    private val paint = Paint()
    private var mWidth = 0f
    private var mHeight = 0f
    private lateinit var backgroundRectBlur: RectF
    private val path = Path()
    private var startColor: Int = 0
    private var endColor: Int = 0
    private var angel: Int = 0
    private var blurRadius: Float = 0F
    private val mMatrix = Matrix()
    private var radius: Float = 0F

    constructor(context: Context) : super(context) {
        initView()
    }

    constructor(context: Context, attributeSet: AttributeSet? = null) : super(
        context,
        attributeSet
    ) {
        initView()
        initAttr(attributeSet)
    }

    constructor(context: Context, attributeSet: AttributeSet?, defStyle: Int) : super(
        context,
        attributeSet,
        defStyle
    ) {
        initAttr(attributeSet)
    }

    private fun initAttr(attributeSet: AttributeSet?) {
        context.obtainStyledAttributes(attributeSet, R.styleable.GradientBlurLayout).apply {
            startColor = getColor(R.styleable.GradientBlurLayout_gbl_startColor, Color.BLACK)
            endColor = getColor(R.styleable.GradientBlurLayout_gbl_endColor, Color.WHITE)
            angel = getInt(R.styleable.GradientBlurLayout_gbl_angle, 45)
            blurRadius = getFloat(R.styleable.GradientBlurLayout_gbl_blurRadius, Utils.dipToPix(8F))
            radius = getFloat(R.styleable.GradientBlurLayout_gbl_radius, Utils.dipToPix(16F))
        }
    }

    private fun initView() {
        mMatrix.setRotate(angel.toFloat())
        backgroundRectBlur = RectF()
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        mWidth = w.toFloat()
        mHeight = h.toFloat()
        backgroundRectBlur.set(0F, 0F, mWidth, mHeight)
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
        paint.maskFilter = BlurMaskFilter(Utils.dipToPix(blurRadius), BlurMaskFilter.Blur.NORMAL)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        path.reset()
        path.addRoundRect(
            backgroundRectBlur,
            Utils.dipToPix(radius),
            Utils.dipToPix(radius),
            Path.Direction.CW
        )
        canvas!!.drawPath(path, paint)

    }
}