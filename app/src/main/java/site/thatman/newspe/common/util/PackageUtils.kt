package site.thatman.newspe.common.util

import android.content.Context
import android.content.pm.PackageManager

object PackageUtils {

    //获取当前app的版本号
    fun getVersionCode(context: Context): Long {
        val manager = context.packageManager
        return try {
            val info = manager.getPackageInfo(context.packageName, 0)
            info.longVersionCode
        } catch (e: PackageManager.NameNotFoundException) {
            // never run.
            e.printStackTrace()
            0L
        }
    }
}