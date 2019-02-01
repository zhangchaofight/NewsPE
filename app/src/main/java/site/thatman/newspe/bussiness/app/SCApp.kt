package site.thatman.newspe.bussiness.app

import android.app.Application
import com.example.zhangchao.newspe.BuildConfig
import com.tencent.mmkv.MMKV
import io.reactivex.disposables.CompositeDisposable
import site.thatman.newspe.common.crash.CrashReportingTree
import site.thatman.newspe.common.network.HttpManager
import site.thatman.newspe.common.util.VersionUtil
import timber.log.Timber

class SCApp : Application() {

    companion object {
        lateinit var context: Application
        val mAppDisposable = CompositeDisposable()
    }

    init {
        context = this
    }

    override fun onCreate() {
        super.onCreate()
        init()
    }

    private fun init() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        } else {
            Timber.plant(CrashReportingTree())

        }

        MMKV.initialize(this)
        VersionUtil.onAppRun(this)
        HttpManager.initRetrofit()
    }
}