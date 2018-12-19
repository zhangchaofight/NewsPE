package site.thatman.newspe.bussiness.mvp.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.zhangchao.newspe.R
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy
import kotlinx.android.synthetic.main.activity_scsplash.*
import site.thatman.newspe.common.extension.ioToMain
import site.thatman.newspe.common.extension.obOnNewThread
import site.thatman.newspe.common.widget.SCToast
import java.util.concurrent.TimeUnit

class SCSplashActivity : AppCompatActivity() {

    private var mDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scsplash)

        mDisposable.add(Observable.interval(0, 1, TimeUnit.SECONDS)
                .take(10)
                .ioToMain()
                .subscribeBy(
                        onNext = {
                            count_down.text = it.toString()
                        },
                        onComplete = {
                            Toast.makeText(this@SCSplashActivity, "dispose", Toast.LENGTH_SHORT).show()
                            mDisposable.dispose()
                        }
                ))

        mDisposable.add(Observable.interval(0, 1, TimeUnit.SECONDS)
                .take(9)
                .obOnNewThread()
                .subscribeBy(
                        onNext = {
                            SCToast.show(it.toString())
                        }
                ))
    }

    override fun onDestroy() {
        super.onDestroy()
        mDisposable.dispose()
    }
}
