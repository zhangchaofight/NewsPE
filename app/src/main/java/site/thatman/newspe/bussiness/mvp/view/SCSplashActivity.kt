package site.thatman.newspe.bussiness.mvp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.zhangchao.newspe.R
import io.reactivex.rxkotlin.subscribeBy
import site.thatman.newspe.bussiness.data.DataCenter
import site.thatman.newspe.common.extension.io

class SCSplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scsplash)

        DataCenter.remote.getJuheNews()
                .io()
                .subscribeBy (
                        onNext = {
                            val i = 0
                        },
                        onError = {
                            val i = 0
                        }

                )
    }
}
