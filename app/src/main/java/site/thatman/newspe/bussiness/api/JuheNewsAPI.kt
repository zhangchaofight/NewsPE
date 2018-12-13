package site.thatman.newspe.bussiness.api

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

@Suppress("SpellCheckingInspection")
interface JuheNewsAPI {

    //    http://v.juhe.cn/toutiao/index?type=top&key=APPKEY
    @GET("index?")
    fun getNews(@Query("type") type: String, @Query("key") key: String): Observable<Any>
}