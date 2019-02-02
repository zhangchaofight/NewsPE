package site.thatman.newspe.bussiness.data

import io.reactivex.Flowable
import site.thatman.newspe.bussiness.app.SCApp
import site.thatman.newspe.bussiness.bean.remoteBean.JuheNewsBean
import site.thatman.newspe.common.extension.ioToMain

object DBData {

    fun getJuheData(): Flowable<List<JuheNewsBean>> {
        return SCApp.scDatabase.getJuheNewsDao().getJuheNews().ioToMain()
    }
}