package ir.siriusapps.moneysave.view

import android.animation.Animator
import android.animation.ValueAnimator
import android.content.Context
import android.graphics.*
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.animation.AccelerateDecelerateInterpolator
import androidx.appcompat.widget.AppCompatButton
import ir.siriusapps.moneysave.R
import ir.siriusapps.moneysave.utils.Utils

class GradientButton : AppCompatButton {

    private val paint = Paint()
    private var mWidth = 0f
    private var mHeight = 0f
    private lateinit var backgroundRect: RectF
    private val path = Path()
    private var startColor: Int = 0
    private var endColor: Int = 0
    private var angel: Int = 0
    private val mMatrix = Matrix()
    private var radius: Float = 0F
    private var color: Int = 0
    private var defaultBackground: Drawable? = null

    private var colorRipple: Int = 0
    private var radiusRipple: Float = 50F
    private var onTouch: Boolean = false
    private var isRipple: Boolean = false
    private var paintRipple: Paint = Paint()
    private var pathRipple: Path = Path()
    private var touchEventX: Float = 0F
    private var touchEventY: Float = 0F
    private var animator: ValueAnimator = ValueAnimator()

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
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.GradientButton)
        try {
            startColor = typedArray.getColor(R.styleable.GradientButton_gb_startColor, 0)
            endColor = typedArray.getColor(R.styleable.GradientButton_gb_endColor, 0)
            angel = typedArray.getColor(R.styleable.GradientButton_gb_angle, 45)
            radius = typedArray.getDimensionPixelSize(
                R.styleable.GradientButton_gb_radius,
                Utils.dipToPix(16)
            ).toFloat()
            color = typedArray.getColor(R.styleable.GradientButton_gb_Color, 0)

            colorRipple =
                typedArray.getColor(
                    R.styleable.GradientButton_gb_color_ripple,
                    Color.rgb(255, 255, 255)
                )
            isRipple = typedArray.getBoolean(R.styleable.GradientButton_gb_is_ripple, false)

        } finally {
            typedArray.recycle()
        }
    }

    private fun initView() {
        setLayerType(LAYER_TYPE_SOFTWARE, null)
        defaultBackground = background
        background = null
        mMatrix.reset()
        mMatrix.setRotate(angel.toFloat())
        backgroundRect = RectF()

    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        val result = super.onTouchEvent(event)

        if(animator.isRunning){
            invalidate()
            return result
        }

        if (isEnabled && isRipple && event!!.actionMasked == MotionEvent.ACTION_DOWN) {

            onTouch = true

            touchEventX = event.x
            touchEventY = event.y

            animator = ValueAnimator.ofFloat(0F, width.toFloat())
            animator.duration = 500
            animator.interpolator = AccelerateDecelerateInterpolator()

            animator.addUpdateListener { animation ->
                radiusRipple = animation.animatedValue as Float
                invalidate()
            }

            animator.addListener(object : Animator.AnimatorListener {
                override fun onAnimationRepeat(animation: Animator?) {}

                override fun onAnimationEnd(animation: Animator?) {
                    radiusRipple = 0F
                    invalidate()
                }

                override fun onAnimationCancel(animation: Animator?) {}

                override fun onAnimationStart(animation: Animator?) {}

            })
            animator.start()
        }
        return result
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        mWidth = w.toFloat()
        mHeight = h.toFloat()
        checkColor(startColor, endColor, color)
        paint.flags = Paint.ANTI_ALIAS_FLAG
    }

    private fun checkColor(startColor: Int, endColor: Int, color: Int) {
        if (startColor == 0 && endColor == 0 && color == 0) {
            background = defaultBackground
            return
        } else if (startColor != 0 && endColor != 0) {
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
            return
        } else {
            paint.color = color
            return
        }
    }


    override fun onDraw(canvas: Canvas?) {
        path.reset()
        paintRipple.color = colorRipple
        paintRipple.alpha = 20

        backgroundRect.set(0F, 0F, mWidth, mHeight)
        path.addRoundRect(
            backgroundRect,
            if (radius < 0) mHeight / 2 else radius,
            if (radius < 0) mHeight / 2 else radius,
            Path.Direction.CW
        )
        canvas!!.drawPath(path, paint)


        if (onTouch) {
            pathRipple.reset()
            pathRipple.addCircle(touchEventX, touchEventY, radiusRipple, Path.Direction.CW)
            canvas.drawPath(pathRipple, paintRipple)
        }


        super.onDraw(canvas)
    }

}