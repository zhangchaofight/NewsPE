package site.thatman.newspe.common.widget

import android.os.Handler
import android.os.Looper
import android.widget.Toast
import site.thatman.newspe.bussiness.app.SCApp

/**
 * 任意线程，任意位置都可以调用的Toast
 * 整个项目都应该使用这个toast，保持风格统一
 */
// todo 考虑修改UI，添加其他功能
object SCToast {

    private var mToast:Toast? = null

    @Synchronized fun show(msg: String) {
        Handler(Looper.getMainLooper()).post{
            mToast?.cancel()
            mToast = Toast.makeText(SCApp.context, msg, Toast.LENGTH_LONG)
            mToast?.show()
        }
    }
}