package site.thatman.newspe.common.widget

import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.zhangchao.newspe.R

/**
 * https://juejin.im/post/59b76ac05188257e93494a88
 */
class SimpleFragment : DialogFragment() {

    override fun onStart() {
        super.onStart()
        Thread {
            Thread.sleep(1500)
            if (!this.isDetached) {
                this.dismiss()
            }
        }.start()
    }

    override fun onCancel(dialog: DialogInterface?) {
        super.onCancel(dialog)
        Toast.makeText(activity, "cancel", Toast.LENGTH_SHORT).show()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.dialog_progress_bar, container)
    }
}