package site.thatman.newspe.bussiness.data

import io.reactivex.Observable
import site.thatman.newspe.bussiness.api.JuheNewsAPI
import site.thatman.newspe.common.key.DataEnum
import site.thatman.newspe.common.network.HttpManager

@Suppress("SpellCheckingInspection")
object RemoteData {

    private val juheNewsAPI by lazy { HttpManager.getJuheRetrofit().create(JuheNewsAPI::class.java) }

    fun getJuheNews(index: String = DataEnum.JuheNewsIndex.TOP.index):Observable<Any>
            = juheNewsAPI.getNews(index, DataEnum.JuheKeys.JUHE_NEWS_KEY)
}