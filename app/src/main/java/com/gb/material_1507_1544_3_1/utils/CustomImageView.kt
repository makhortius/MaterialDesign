package com.gb.material_1507_1544_3_1.utils

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView

class CustomImageView @JvmOverloads constructor(context:Context, attrs: AttributeSet? = null, style: Int=0):
    AppCompatImageView(context,attrs,style) {

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec)
    }
}