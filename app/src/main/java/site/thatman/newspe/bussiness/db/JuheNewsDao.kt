package site.thatman.newspe.bussiness.db

import androidx.room.*
import io.reactivex.Flowable
import site.thatman.newspe.bussiness.bean.remoteBean.JuheNewsBean

@Dao
interface JuheNewsDao {

    @Query("select * from juhe_news")
    fun getJuheNews():Flowable<List<JuheNewsBean>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addJuheNews(juheNewsBean: JuheNewsBean)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addJuheNewsList(juheNewsBeans: List<JuheNewsBean>)

    @Update
    fun update(juheNewsBean: JuheNewsBean): Int

    @Delete
    fun deleteJuheNews(juheNewsBean: JuheNewsBean): Int
}