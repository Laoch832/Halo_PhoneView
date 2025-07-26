package com.halo.blog.utils

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableFloatStateOf

// 字体大小管理器
object FontSizeManager {
    private var _fontSize = mutableFloatStateOf(35f)
    val fontSize: State<Float> = _fontSize
    
    fun updateFontSize(size: Float) {
        _fontSize.floatValue = size
    }
    
    fun getFontSize(context: android.content.Context): Float {
        val sharedPrefs = context.getSharedPreferences("font_settings", android.content.Context.MODE_PRIVATE)
        return sharedPrefs.getFloat("font_size", 35f)
    }
}