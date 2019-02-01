package site.thatman.newspe.bussiness.mvp.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.zhangchao.newspe.R
import eu.davidea.flexibleadapter.FlexibleAdapter
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy
import kotlinx.android.synthetic.main.activity_scmain.*
import site.thatman.newspe.bussiness.bean.remoteBean.JuheNewsWrapper
import site.thatman.newspe.bussiness.data.RemoteData
import site.thatman.newspe.bussiness.items.JuheNewsItem
import site.thatman.newspe.common.extension.ioToMain

class SCMainActivity : AppCompatActivity() {

    private var mDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scmain)
        fetchData()
    }

    private fun fetchData(){
        mDisposable.add(RemoteData.getJuheNews()
                .ioToMain()
                .subscribeBy (
                        onNext = {
                            fetchSucc(it)
                        },
                        onError = {
                            fetchFail()
                        }
                ))
    }

    private fun fetchSucc(newsWrapper: JuheNewsWrapper) {
        if (newsWrapper.data == null || newsWrapper.data.isEmpty()){
            fetchFail()
            return
        }
        val items = mutableListOf<JuheNewsItem>()
        newsWrapper.data.forEach {
            val item = JuheNewsItem(it)
            items.add(item)
        }
        val adapter = FlexibleAdapter(items)
        rv_activity_main.layoutManager = LinearLayoutManager(this)
        rv_activity_main.adapter = adapter
    }

    private fun fetchFail() {

    }

    override fun onDestroy() {
        super.onDestroy()
        mDisposable.dispose()
    }
}
