package site.thatman.newspe.bussiness.app

import android.app.Application
import com.tencent.mmkv.MMKV
import site.thatman.newspe.common.util.VersionUtil

class SCApp :Application() {

    override fun onCreate() {
        super.onCreate()
        init()
    }

    private fun init(){
        MMKV.initialize(this)
        VersionUtil.onAppRun(this)
    }
}