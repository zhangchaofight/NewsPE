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
    private const val SC_SERVER_URL = "204.44.94.85"

    private lateinit var juheRetrofit: Retrofit
    private lateinit var baiduRetrofit: Retrofit
    private lateinit var scRetrofit: Retrofit

    init {
        initRetrofit()
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
                .client(HttpClient.defaultClient)
                .build()

        baiduRetrofit = Retrofit.Builder()
                .baseUrl(BAIDU_NEWS_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                //下面一句可以传入gson对象，用来自定义gson转换规则
                //gson.registerTypeAdapter(class, adapter)
//                .addConverterFactory(GsonConverterFactory.create())
                .client(getBaiduClient())
                .build()

        scRetrofit = Retrofit.Builder()
                .baseUrl(SC_SERVER_URL)
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