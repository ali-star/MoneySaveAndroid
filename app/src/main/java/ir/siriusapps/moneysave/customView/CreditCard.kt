package ir.siriusapps.moneysave.customView

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.graphics.drawable.Drawable
import android.os.Build
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import ir.siriusapps.moneysave.R



class CreditCardView : FrameLayout {

    private var mWith: Float = 0F
    private var mHeight: Float = 0F
    private lateinit var paint: Paint
    private lateinit var path: Path
    private lateinit var iconImageView: ImageView
    private lateinit var backgroundImageView: ImageView
    private lateinit var balanceTitleTextVew: TextView
    private lateinit var cardNumberTextView: TextView
    private lateinit var balanceTextView: TextView
    private var cardView: CardView? = null
    var cardColor: Int? = null
        set(value) {
            field = value
            value?.let { cardView?.setBackgroundColor(it) }
        }
    var backgroundImage: Drawable? = null
        set(value) {
            field = value
            value?.let { backgroundImageView.setImageDrawable(it) }
        }
    var iconImage: Drawable? = null
        set(value) {
            field = value
            value?.let { iconImageView.setImageDrawable(it) }
        }
    var cardNumber: String? = null
        set(value) {
            field = value
            value?.let { cardNumberTextView.setText(it) }
        }
     var balanceTitle: String? = null
        set(value) {
            field = value
            value?.let { balanceTitleTextVew.setText(it) }
        }
     var balance: String? = null
        set(value) {
            field = value
            value?.let { balanceTextView.setText(it) }
        }

    constructor(context: Context) : super(context) {
        initView()
    }

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet) {
        initView()
        initAttribute(attributeSet)
    }

    constructor(context: Context, attributeSet: AttributeSet, defStyle: Int) : super(
        context,
        attributeSet,
        defStyle
    ) {
        initView()
        initAttribute(attributeSet)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
    }

    fun initView() {
        if (Build.VERSION.SDK_INT < 29)
            setLayerType(View.LAYER_TYPE_SOFTWARE, null)
        inflate(context, R.layout.cerdit_card_view, this)
        /////////////////////////////////////
        iconImageView = findViewById(R.id.iconImageView)
        backgroundImageView = findViewById(R.id.backgroundImageView)
        balanceTitleTextVew = findViewById(R.id.balanceTitleTextView)
        balanceTextView = findViewById(R.id.balanceTextView)
        cardNumberTextView = findViewById(R.id.cardNumberTextView)
        cardView = findViewById(R.id.cerditCardView)
        //////////////////////////////////
        iconImage?.let {
            iconImageView.setImageDrawable(iconImage!!)
        }
        backgroundImage?.let {
            backgroundImageView.setImageDrawable(iconImage!!)
        }
        balanceTitle?.let {
            balanceTitleTextVew.setText(it)
        }
        balance?.let {
            balanceTextView.setText(it)
        }
        cardNumber?.let {
            cardNumberTextView.setText(it)
        }
    }

    fun initAttribute(attributeSet: AttributeSet) {

    }
}