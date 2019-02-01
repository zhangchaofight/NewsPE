package site.thatman.newspe.common.network

import com.google.gson.annotations.SerializedName

data class JuheResponse<T> (@SerializedName("err_code") var code: Int = 200,
                        @SerializedName("reason") var msg: String = "success",
                        @SerializedName("result") var data: T? = null)