package site.thatman.newspe.bussiness.bean.remoteBean

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "juhe_news")
data class JuheNewsBean(
        @ColumnInfo(name = "author_name") @SerializedName("author_name") val authorName: String,
        @ColumnInfo(name = "category") @SerializedName("category") val category: String,
        @ColumnInfo(name = "date") @SerializedName("date") val date: String,
        @ColumnInfo(name = "thumbnail_pic_s") @SerializedName("thumbnail_pic_s") val thumbnailPic0: String? = "",
        @ColumnInfo(name = "thumbnail_pic_s02") @SerializedName("thumbnail_pic_s02") val thumbnailPic1: String? = "",
        @ColumnInfo(name = "thumbnail_pic_s03") @SerializedName("thumbnail_pic_s03") val thumbnailPic2: String? = "",
        @ColumnInfo(name = "title") @SerializedName("title") val title: String,
        @ColumnInfo(name = "uniquekey") @PrimaryKey(autoGenerate = false) @SerializedName("uniquekey") val uniqueKey: String,
        @ColumnInfo(name = "url") @SerializedName("url") val url: String,
        @ColumnInfo(name = "isRead") var isRead: Boolean = false
) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as JuheNewsBean
        return uniqueKey == other.uniqueKey
    }

    override fun hashCode(): Int {
        return uniqueKey.hashCode()
    }
}