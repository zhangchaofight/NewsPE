package site.thatman.newspe.common.crash

/**
 * 需要自定义实现crash的手机策略
 *
 * 拦截崩溃 ： https://github.com/android-notes/Cockroach
 */
object SCCrashCollector {

    fun log(priority: Int, tag: String, message: String) {
        // TODO add log entry to circular buffer.
    }

    fun logWarning(t: Throwable) {
        // TODO report non-fatal warning.
    }

    fun logError(t: Throwable) {
        // TODO report non-fatal error.
    }

//    private SCCrashCollector()
//    {
//        throw new AssertionError ("No instances.");
//    }
}