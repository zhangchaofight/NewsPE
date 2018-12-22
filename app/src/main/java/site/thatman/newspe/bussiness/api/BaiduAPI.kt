package site.thatman.newspe.bussiness.api

import io.reactivex.Observable
import okhttp3.ResponseBody
import retrofit2.http.GET

interface BaiduAPI {

    @GET("/")
    fun baidu():Observable<ResponseBody>
}