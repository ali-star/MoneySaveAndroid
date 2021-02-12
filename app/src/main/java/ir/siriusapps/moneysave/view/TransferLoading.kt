package ir.siriusapps.moneysave.view

import android.animation.Animator
import android.animation.ValueAnimator
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import androidx.core.animation.addListener


import ir.siriusapps.moneysave.R
import ir.siriusapps.moneysave.presenter.dpToPx

class TransferLoading:View {

    private lateinit var paint: Paint
    private var leftBottomRoundRectShape: RectF? =  null
    private var leftTopRoundRectShape: RectF? =  null
    private var rightBottomRoundRectShape: RectF? =  null
    private var rightTopRoundRectShape: RectF? =  null
    private lateinit var path: Path
    private lateinit var valueAnimator: ValueAnimator

    private var mBackgroundColor: Int = Color.BLACK
    private var borderColor: Int = Color.BLACK


    constructor(context: Context):super(context){
        init()
    }
    constructor(context: Context, attributeSet: AttributeSet): super(context, attributeSet){
        init()
        initAttr(attributeSet)
    }
    constructor(context: Context, attributeSet: AttributeSet, defStyleAttr: Int): super(context, attributeSet, defStyleAttr){
        init()
        initAttr(attributeSet)
    }

    private fun initAttr(attributeSet: AttributeSet){
        val typeArray = context.obtainStyledAttributes(attributeSet, R.styleable.TransferLoading)
        try {
            mBackgroundColor = typeArray.getInt(R.styleable.TransferLoading_tl_BackgroundColor,Color.BLACK)
            borderColor = typeArray.getInt(R.styleable.TransferLoading_tl_BorderColor,Color.BLACK)
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

        valueAnimator = ValueAnimator()
        valueAnimator.repeatCount = ValueAnimator.INFINITE

        valueAnimator.addListener { object:Animator.AnimatorListener{
            override fun onAnimationStart(animation: Animator?) {
                TODO("Not yet implemented")
            }

            override fun onAnimationEnd(animation: Animator?) {
                TODO("Not yet implemented")
            }

            override fun onAnimationCancel(animation: Animator?) {
                TODO("Not yet implemented")
            }

            override fun onAnimationRepeat(animation: Animator?) {
                TODO("Not yet implemented")
            }

        }}
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        leftBottomRoundRectShape?.set(
            0F + dpToPx(12),
            height.toFloat()/2 + dpToPx(12),
            width.toFloat()/2 - dpToPx(12),
            height.toFloat() - dpToPx(12),
        )

        rightBottomRoundRectShape?.set(
            width.toFloat()/2 +dpToPx(12),
            height.toFloat()/2 + dpToPx(12),
            width.toFloat() - dpToPx(12),
            height.toFloat() - dpToPx(12),
        )

        leftTopRoundRectShape?.set(
            0F + dpToPx(12),
            0F + dpToPx(12),
            width.toFloat()/2 - dpToPx(12),
            height.toFloat()/2 -dpToPx(12)
        )

        rightTopRoundRectShape?.set(
            width.toFloat()/2 + dpToPx(12),
            0F + dpToPx(12),
            width.toFloat() - dpToPx(12),
            height.toFloat()/2 - dpToPx(12)
        )
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        path.reset()

        path.addRoundRect(
            leftBottomRoundRectShape!!,
            dpToPx(24),
            dpToPx(24),
            Path.Direction.CW)

        path.addRoundRect(
            rightBottomRoundRectShape!!,
            dpToPx(24),
            dpToPx(24),
            Path.Direction.CW)

        path.addRoundRect(leftTopRoundRectShape!!, dpToPx(24), dpToPx(24), Path.Direction.CW)
        path.addRoundRect(rightTopRoundRectShape!!, dpToPx(24), dpToPx(24), Path.Direction.CW)

        canvas?.drawPath(path, paint)
    }
}