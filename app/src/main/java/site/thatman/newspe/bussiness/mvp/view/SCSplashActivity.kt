package site.thatman.newspe.bussiness.mvp.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.zhangchao.newspe.R
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy
import site.thatman.newspe.bussiness.data.RemoteData
import site.thatman.newspe.common.extension.ioToMain

class SCSplashActivity : AppCompatActivity() {

    private var mDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scsplash)
        mDisposable.add(RemoteData.getJuheNews()
                .ioToMain()
                .subscribeBy(
                        onNext = {
                            val i = 0
                        },
                        onError = {
                            val i = 0
                        }
                )
        )
    }

    override fun onDestroy() {
        super.onDestroy()
        mDisposable.dispose()
    }
}
