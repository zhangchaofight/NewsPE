package site.thatman.newspe.common.network

class ApiException(val msg: String, val code: Int): RuntimeException() {

    companion object {
        fun handleException(throwable: Throwable): ApiException {
            return when (throwable) {
                is ApiException -> {
                    ApiException(throwable.msg, throwable.code)
                }
                else ->{
                    ApiException(throwable.message ?: "exception", 0)
                }
            }
        }
    }
}