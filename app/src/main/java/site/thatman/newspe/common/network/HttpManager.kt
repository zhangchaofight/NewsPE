package site.thatman.newspe.common.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Suppress("SpellCheckingInspection")
object HttpManager {

    private const val JUHE_NEWS_URL = "http://v.juhe.cn/toutiao/"

    private lateinit var juheRetrofit: Retrofit

    init {
        initRetrofit()
    }

    private fun getOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
                //这个拦截所有的网络请求并展现
//                .addInterceptor(ChuckInterceptor(CoreApp.getInstance()))
                //对url params做处理，添加或者删除字段
//                .addInterceptor(HttpUrlParamsInterceptor(mCommonParams))
                //保存cookie
//                .addInterceptor(HttpSaveReceivedCookiesInterceptor(COOKIE_KEY))
                //发送保存的cookie
//                .addInterceptor(HttpSendSavedCookiesInterceptor(COOKIE_KEY))
                .build()
    }

    private fun initRetrofit() {
        juheRetrofit = Retrofit.Builder()
                .baseUrl(JUHE_NEWS_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                //下面一句可以传入gson对象，用来自定义gson转换规则
                //gson.registerTypeAdapter(class, adapter)
                .addConverterFactory(GsonConverterFactory.create())
                .client(getOkHttpClient())
                .build()
    }

    fun getJuheRetrofit() = juheRetrofit
}