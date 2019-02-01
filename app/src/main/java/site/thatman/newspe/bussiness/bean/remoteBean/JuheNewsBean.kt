package site.thatman.newspe.bussiness.bean.remoteBean

import com.google.gson.annotations.SerializedName

data class JuheNewsBean(
        @SerializedName("author_name") val authorName: String,
        @SerializedName("category") val category: String,
        @SerializedName("date") val date: String,
        @SerializedName("thumbnail_pic_s") val thumbnailPic0: String? = "",
        @SerializedName("thumbnail_pic_s02") val thumbnailPic1: String? = "",
        @SerializedName("thumbnail_pic_s03") val thumbnailPic2: String? = "",
        @SerializedName("title") val title: String,
        @SerializedName("uniquekey") val uniqueKey: String,
        @SerializedName("url") val url: String
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as JuheNewsBean
        return uniqueKey == other.uniqueKey
    }
}