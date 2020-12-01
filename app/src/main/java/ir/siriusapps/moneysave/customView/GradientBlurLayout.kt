package ir.siriusapps.moneysave.customView

import android.content.Context
import android.graphics.*
import android.graphics.drawable.Drawable
import android.os.Build
import android.util.AttributeSet
import android.view.View
import ir.siriusapps.moneysave.R
import ir.siriusapps.moneysave.utils.Utils

class GradientBlurLayout : View {
    private val paint = Paint()
    private var mWidth = 0f
    private var mHeight = 0f
    private lateinit var backgroundRectBlur: RectF
    private val path = Path()
    private var startColor: Int = 0
    private var endColor: Int = 0
    private var color: Int = 0
    private var angel: Int = 0
    private var blurRadius: Float = 0F
    private val mMatrix = Matrix()
    private var radius: Float = 0F
    private var defaultBackground: Drawable? = null

    constructor(context: Context) : super(context) {
        initView()
    }

    constructor(context: Context, attributeSet: AttributeSet? = null) : super(
        context,
        attributeSet
    ) {
        initAttr(attributeSet)
        initView()
    }

    constructor(context: Context, attributeSet: AttributeSet?, defStyle: Int) : super(
        context,
        attributeSet,
        defStyle
    ) {
        initAttr(attributeSet)
        initView()
    }

    private fun initAttr(attributeSet: AttributeSet?) {
        val typedArray =
            context.obtainStyledAttributes(attributeSet, R.styleable.GradientBlurLayout)
        try {
            startColor =
                typedArray.getColor(R.styleable.GradientBlurLayout_gbl_startColor, 0)
            endColor = typedArray.getColor(R.styleable.GradientBlurLayout_gbl_endColor, 0)
            angel = typedArray.getInt(R.styleable.GradientBlurLayout_gbl_angle, 45)
            blurRadius = typedArray.getDimensionPixelSize(
                R.styleable.GradientBlurLayout_gbl_blurRadius,
                Utils.dipToPix(8)
            ).toFloat()
            radius = typedArray.getDimensionPixelSize(
                R.styleable.GradientBlurLayout_gbl_radius,
                Utils.dipToPix(16)
            ).toFloat()
            color = typedArray.getColor(R.styleable.GradientBlurLayout_gbl_color, 0)
        } finally {
            typedArray.recycle()
        }
    }

    private fun initView() {
        if (Build.VERSION.SDK_INT < 29)
            setLayerType(LAYER_TYPE_SOFTWARE, null)
        defaultBackground = background
        background = null
        mMatrix.setRotate(angel.toFloat())
        backgroundRectBlur = RectF()
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        mWidth = w.toFloat()
        mHeight = h.toFloat()
        backgroundRectBlur.set(blurRadius, blurRadius, mWidth - blurRadius, mHeight - blurRadius)
        checkColor(startColor, endColor, color)
        paint.maskFilter = BlurMaskFilter(blurRadius - (blurRadius / 3), BlurMaskFilter.Blur.NORMAL)
        paint.flags = Paint.ANTI_ALIAS_FLAG
    }

    private fun checkColor(startColor: Int, endColor: Int, color: Int) {
        if (startColor == 0 && endColor == 0 && color == 0) {
            background = defaultBackground
            return
        } else if (startColor != 0 && endColor != 0) {
            paint.setShader(
                LinearGradient(
                    blurRadius, blurRadius, mWidth - blurRadius, mHeight - blurRadius,
                    startColor,
                    endColor,
                    Shader.TileMode.CLAMP
                )
            ).setLocalMatrix(mMatrix)
            return
        } else {
            paint.color = color
            return
        }
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        path.reset()
        path.addRoundRect(
            backgroundRectBlur,
            if (radius < 0) mHeight / 2 else radius,
            if (radius < 0) mHeight / 2 else radius,
            Path.Direction.CW
        )
        canvas!!.drawPath(path, paint)

    }
}