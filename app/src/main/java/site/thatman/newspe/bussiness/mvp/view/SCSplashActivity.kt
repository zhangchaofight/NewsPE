package site.thatman.newspe.bussiness.mvp.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.zhangchao.newspe.R
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy
import org.jetbrains.anko.startActivity
import site.thatman.newspe.common.extension.ioToMain
import java.util.concurrent.TimeUnit

class SCSplashActivity : AppCompatActivity() {

    private var mDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scsplash)
        mDisposable.add(Observable.interval(2, 0L, TimeUnit.SECONDS)
                .take(1)
                .ioToMain()
                .subscribeBy {
                    startActivity<SCMainActivity>()
                    finish()
                })
    }

    override fun onDestroy() {
        super.onDestroy()
        mDisposable.dispose()
    }
}
