package site.thatman.newspe.common.network

import okhttp3.ConnectionPool
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

object HttpClient {

    //普通的client（全局变量，初始化后一直存在）
    val defaultClient = OkHttpClient.Builder()
            .connectionPool(ConnectionPool(MAX_IDLE_CONNECTIONS, KEEP_ALIVE_DURATION, TimeUnit.MINUTES))
            .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS) //上传视频超时时间设置长一些，避免因为超时而导致的错误
            .retryOnConnectionFailure(true)
            .addInterceptor(HttpUrlParamsInterceptor())
            .build()
}