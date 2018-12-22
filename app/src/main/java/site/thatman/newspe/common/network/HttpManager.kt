package site.thatman.newspe.common.network

import okhttp3.Cookie
import okhttp3.CookieJar
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Suppress("SpellCheckingInspection")
object HttpManager {

    private const val JUHE_NEWS_URL = "http://v.juhe.cn/toutiao/"
    private const val BAIDU_NEWS_URL = "https://www.baidu.com/"

    private lateinit var juheRetrofit: Retrofit
    private lateinit var baiduRetrofit: Retrofit

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

    private fun getBaiduClient(): OkHttpClient {
        return OkHttpClient.Builder()
                .cookieJar(object: CookieJar {
                    val cookieStore = HashMap<HttpUrl, List<Cookie>>()

                    override fun saveFromResponse(url: HttpUrl, cookies: List<Cookie>) {
                        cookieStore[url] = cookies
                        val c = HttpUrl.parse("https://www.baidu.com/")
                        if (c!= null) {
                            cookieStore[c] = cookies
                        }
                    }

                    override fun loadForRequest(url: HttpUrl): List<Cookie> {
                        val cookies = cookieStore[HttpUrl.parse("https://www.baidu.com/")]
                        return cookies ?: arrayListOf()
                    }
                })
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

        baiduRetrofit = Retrofit.Builder()
                .baseUrl(BAIDU_NEWS_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                //下面一句可以传入gson对象，用来自定义gson转换规则
                //gson.registerTypeAdapter(class, adapter)
//                .addConverterFactory(GsonConverterFactory.create())
                .client(getBaiduClient())
                .build()
    }

    fun getJuheRetrofit() = juheRetrofit
    fun getBaiduRetrofit() = baiduRetrofit
}