package site.thatman.newspe.common.crash

import android.util.Log
import android.util.Log.INFO
import timber.log.Timber

/** A tree which logs important information for crash reporting.  */

class CrashReportingTree : Timber.Tree() {

    companion object {
        private const val DEFAULT_TAG = "site.thatman.newspe.common.crash"
    }

    override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
        if (priority == Log.VERBOSE || priority == Log.DEBUG) {
            return
        }

        SCCrashCollector.log(priority, tag ?: DEFAULT_TAG, message)

        if (t != null) {
            if (priority == Log.ERROR) {
                SCCrashCollector.logError(t)
            } else if (priority == Log.WARN) {
                SCCrashCollector.logWarning(t)
            }
        }
    }

    override fun isLoggable(tag: String?, priority: Int): Boolean {
        return priority >= INFO
    }
}