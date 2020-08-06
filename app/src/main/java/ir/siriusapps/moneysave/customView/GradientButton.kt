package ir.siriusapps.moneysave.customView

import android.content.Context
import android.content.res.TypedArray
import android.graphics.*
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatButton
import ir.siriusapps.moneysave.R


class GradientButton : AppCompatButton {
    lateinit var paint: Paint

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet? = null) : super(context, attrs) {
        paint = Paint()
        val typedArray =
            context.obtainStyledAttributes(attrs,
                R.styleable.GradientButton)

        typedArray.recycle()
    }

    constructor(context: Context, attrs: AttributeSet?, defStyle: Int) : super(
        context,
        attrs,
        defStyle
    )


    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        /*  paint.shader = LinearGradient(
              0,
              0,
              0,
              height,
              ,
              0x070E30,
              Shader.TileMode.MIRROR
          )
          canvas!!.drawPath(arrowPath, paint)*/
    }

}