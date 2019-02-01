package site.thatman.newspe.bussiness.mvp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.zhangchao.newspe.R
import kotlinx.android.synthetic.main.activity_scdetail.*
import site.thatman.newspe.common.widget.SCToast

class SCDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scdetail)
    }

    override fun onResume() {
        super.onResume()
        val url = intent?.getStringExtra("juheNewsUrl")
        if (url != null) {
            wv_activity_detail.loadUrl(url)
        } else {
            SCToast.show("网页地址错误")
        }
    }
}
