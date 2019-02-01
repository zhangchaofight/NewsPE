package site.thatman.newspe.bussiness.bean.remoteBean

import com.google.gson.annotations.SerializedName

data class JuheNewsWrapper(
        @SerializedName("stat") val stat: String? = null,
        @SerializedName("data") val data: List<JuheNewsBean>? = null
)