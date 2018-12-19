package site.thatman.newspe.common.widget

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.zhangchao.newspe.R

/**
 * 这是用来展示进度条的dialog
 */
class ProgressBarDialog: DialogFragment() {

    //是否可以自动消失
    private var autoDismiss = false
    private var delayMilliseconds = 0L

    init {
        isCancelable = false
    }

    //对话框设置为可以由用户触外界取消
    fun setCancelable(): ProgressBarDialog {
        isCancelable = true
        return this
    }

    //对话框设置为自动消失及消失时间
    fun setAutoDismiss(delayMilliseconds: Long = 1500): ProgressBarDialog {
        if (delayMilliseconds > 0L) {
            this.delayMilliseconds = delayMilliseconds
        }
        autoDismiss = true
        return this
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.dialog_progress_bar, container)
    }

    override fun onStart() {
        super.onStart()
        if (autoDismiss) {
            Thread{
                Thread.sleep(delayMilliseconds)
                @Suppress("UNNECESSARY_SAFE_CALL")
                //有可能已经被回收了所以需要安全判断
                if (!this@ProgressBarDialog?.isDetached) {
                    this@ProgressBarDialog.dismiss()
                    Log.d("ProgressBarDialog", "self dismiss")
                } else {
                    Log.d("ProgressBarDialog", "object has be recycled")
                }
            }.start()
        }
    }
}