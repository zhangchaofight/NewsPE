package site.thatman.newspe.common.util

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.Drawable
import site.thatman.newspe.bussiness.app.SCApp

/**
 * 资源获取工具
 */
object ResUtils {

    fun getString(resId: Int): String {
        return SCApp.context.getString(resId)
    }

    fun getString(resId: Int, vararg args: Any): String {
        return SCApp.context.getString(resId, *args)
    }

    fun getStringArray(resId: Int): Array<out String> {
        return SCApp.context.resources.getStringArray(resId)
    }

    fun getBoolean(id: Int): Boolean {
        return SCApp.context.resources.getBoolean(id)
    }

    @Suppress("DEPRECATION")
    fun getColor(color: Int): Int {
        return SCApp.context.resources.getColor(color)
    }

    fun getInteger(id: Int): Int {
        return SCApp.context.resources.getInteger(id)
    }

    fun getDimension(id: Int): Float {
        return SCApp.context.resources.getDimension(id)
    }

    fun getBitmap(id: Int): Bitmap {
        return BitmapFactory.decodeResource(SCApp.context.resources, id)
    }

    @Suppress("DEPRECATION")
    fun getDrawable(id: Int): Drawable {
        return SCApp.context.resources.getDrawable(id)
    }

    @Suppress("DEPRECATION")
    fun getCompoundDrawable(id: Int): Drawable? {
        val drawable = SCApp.context.resources.getDrawable(id) ?: return null
        drawable.setBounds(0, 0, drawable.intrinsicWidth, drawable.intrinsicHeight)
        return drawable
    }

}