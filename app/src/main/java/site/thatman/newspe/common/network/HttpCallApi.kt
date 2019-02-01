package site.thatman.newspe.common.network

import io.reactivex.Observable
import io.reactivex.functions.Function

//封装异常处理
fun <T> Observable<JuheResponse<T>>.callJuheAPI(): Observable<T> {
    return this.map(HandleJuheFunc())
            .onErrorResumeNext(HttpErrorResp<T>())
}

//判断数据是否合法
class HandleJuheFunc<T> : Function<JuheResponse<T>, T> {
    override fun apply(t: JuheResponse<T>): T {
        if (t.code == 200 && t.data != null) {
            t.data?.let {
                return it
            }
            throw ApiException(t.msg, t.code)
        } else {
            throw ApiException(t.msg, t.code)
        }
    }
}

//封装rx的异常
class HttpErrorResp<T> : Function<Throwable, Observable<T>> {
    override fun apply(t: Throwable): Observable<T> {
        return Observable.error(ApiException.handleException(t))
    }
}