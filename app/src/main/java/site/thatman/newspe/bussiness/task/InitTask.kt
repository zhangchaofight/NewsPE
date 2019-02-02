package site.thatman.newspe.bussiness.task

import io.reactivex.rxkotlin.subscribeBy
import site.thatman.newspe.bussiness.app.SCApp
import site.thatman.newspe.bussiness.data.RemoteData
import site.thatman.newspe.common.extension.io

object InitTask{

    fun fetchJuheData() {
        SCApp.mAppDisposable.add(RemoteData.getJuheNews()
                .io()
                .subscribeBy (
                        onNext = {
                            if (it.data?.isNotEmpty() == true) {
                                SCApp.scDatabase.getJuheNewsDao().addJuheNewsList(it.data)
                            }
                        },
                        onError = {

                        }
                ))
    }
}