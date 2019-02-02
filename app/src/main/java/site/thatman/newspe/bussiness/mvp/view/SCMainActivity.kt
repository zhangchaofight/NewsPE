package site.thatman.newspe.bussiness.mvp.view

import android.os.Bundle
import android.widget.LinearLayout.VERTICAL
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.zhangchao.newspe.R
import eu.davidea.flexibleadapter.FlexibleAdapter
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy
import kotlinx.android.synthetic.main.activity_scmain.*
import org.jetbrains.anko.toast
import site.thatman.newspe.bussiness.bean.remoteBean.JuheNewsBean
import site.thatman.newspe.bussiness.data.DBData
import site.thatman.newspe.bussiness.items.JuheNewsItem
import site.thatman.newspe.common.util.ResUtils

class SCMainActivity : AppCompatActivity() {

    private var mDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scmain)
        fetchData()
    }

    private fun fetchData() {
        mDisposable.add(DBData.getJuheData()
                .subscribeBy(
                        onNext = {
                            fetchSucc(it)
                        },
                        onError = {
                            fetchFail()
                        }
                ))
    }

    private fun fetchSucc(juheNewsList: List<JuheNewsBean>) {
        if (juheNewsList.isEmpty()) {
            fetchFail()
            return
        }
        val items = mutableListOf<JuheNewsItem>()
        juheNewsList.forEach {
            val item = JuheNewsItem(it)
            items.add(item)
        }
        val adapter = FlexibleAdapter(items)
        rv_activity_main.layoutManager = LinearLayoutManager(this)
        val decoration = DividerItemDecoration(this@SCMainActivity, VERTICAL)
        decoration.setDrawable(ResUtils.getDrawable(R.drawable.decoration_juhe_news))
        rv_activity_main.addItemDecoration(decoration)
        rv_activity_main.adapter = adapter
    }

    private fun fetchFail() {
        toast("取数据库错误")
    }

    override fun onDestroy() {
        super.onDestroy()
        mDisposable.dispose()
    }
}
