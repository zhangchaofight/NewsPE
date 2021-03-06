package site.thatman.newspe.common.util

import android.content.Context
import com.tencent.mmkv.MMKV
import site.thatman.newspe.bussiness.bean.localBean.Version
import site.thatman.newspe.common.key.LocalKeys
import timber.log.Timber

object VersionUtil {

    fun onAppRun(context: Context) {
        val mmkv = MMKV.defaultMMKV()
        val cVersionCode = PackageUtils.getVersionCode(context).toString()
        //上次运行的版本
        val cVersionJson = mmkv.decodeString(LocalKeys.VERSION.CURRENT_VERSION)
        //如果之前的版本为空
        if (cVersionJson == null) {
            val current = Version(cVersionCode, 1,
                    System.currentTimeMillis())
            mmkv.encode(LocalKeys.VERSION.CURRENT_VERSION, GsonUtil.toJson(current))
            Timber.d("VersionUtil record: currentVersionCode = $cVersionCode ~~~ completely New run")
        } else {
            val cVersion = GsonUtil.fromJson(cVersionJson, Version::class.java)
            if (cVersionCode == cVersion.version) {
                cVersion.lunchTimes = cVersion.lunchTimes + 1
                mmkv.encode(LocalKeys.VERSION.CURRENT_VERSION, GsonUtil.toJson(cVersion))
                Timber.d("VersionUtil record: currentVersionCode = $cVersionCode ~~~${cVersion.lunchTimes} lunch")
            } else {
                mmkv.encode(LocalKeys.VERSION.LAST_VERSION, GsonUtil.toJson(cVersion))
                val current = Version(cVersionCode, 1,
                        System.currentTimeMillis())
                mmkv.encode(LocalKeys.VERSION.CURRENT_VERSION, GsonUtil.toJson(current))
                Timber.d("VersionUtil record: currentVersionCode = $cVersionCode ~~~ update from ${cVersion.version}")
            }
        }
    }
}