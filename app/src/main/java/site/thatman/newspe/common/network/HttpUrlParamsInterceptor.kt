package site.thatman.newspe.common.network

import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.Response

class HttpUrlParamsInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        var url = original.url()
        val urlParamsMap = HttpParamsManager.getParams()
        url = url.newBuilder()
                .addQueryParameters(urlParamsMap)
                .build()
        return chain.proceed(original.newBuilder().url(url).build())
    }

}

fun HttpUrl.Builder.addQueryParameters(parameters: Map<String, String>): HttpUrl.Builder {
    for (entry in parameters.entries) {
        this.addQueryParameter(entry.key, entry.value)
    }
    return this
}