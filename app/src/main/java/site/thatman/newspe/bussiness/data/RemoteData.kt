package site.thatman.newspe.bussiness.data

import io.reactivex.Observable
import okhttp3.ResponseBody
import site.thatman.newspe.bussiness.api.BaiduAPI
import site.thatman.newspe.bussiness.api.JuheNewsAPI
import site.thatman.newspe.bussiness.bean.remoteBean.JuheNewsWrapper
import site.thatman.newspe.common.key.DataEnum
import site.thatman.newspe.common.network.HttpManager
import site.thatman.newspe.common.network.callJuheAPI

@Suppress("SpellCheckingInspection")
object RemoteData {

    private val juheNewsAPI by lazy { HttpManager.getJuheRetrofit().create(JuheNewsAPI::class.java) }
    private val baiduAPI by lazy { HttpManager.getBaiduRetrofit().create(BaiduAPI::class.java) }

    fun getJuheNews(index: String = DataEnum.JuheNewsIndex.TOP.index): Observable<JuheNewsWrapper> = juheNewsAPI.getNews(index, DataEnum.JuheKeys.JUHE_NEWS_KEY).callJuheAPI()

    fun getBaidu(): Observable<ResponseBody> = baiduAPI.baidu()
}