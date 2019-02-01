package site.thatman.newspe.bussiness.items

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.zhangchao.newspe.R
import eu.davidea.flexibleadapter.FlexibleAdapter
import eu.davidea.viewholders.FlexibleViewHolder
import eu.davidea.flexibleadapter.items.IFlexible
import eu.davidea.flexibleadapter.items.AbstractFlexibleItem
import org.jetbrains.anko.startActivity
import site.thatman.newspe.bussiness.bean.remoteBean.JuheNewsBean
import site.thatman.newspe.bussiness.mvp.view.SCDetailActivity

/**
 * Where AbstractFlexibleItem implements IFlexible!
 */
class JuheNewsItem(private val juheNewsBean: JuheNewsBean)
    : AbstractFlexibleItem<JuheNewsItem.JuheTopViewHolder>() {

    /**
     * When an item is equals to another?
     * Write your own concept of equals, mandatory to implement or use
     * default java implementation (return this == o;) if you don't have unique IDs!
     * This will be explained in the "Item interfaces" Wiki page.
     */
    override fun equals(other: Any?): Boolean {
        if (other is JuheNewsItem) {
            val inItem = other as JuheNewsItem?
            return this.juheNewsBean.uniqueKey == inItem!!.juheNewsBean.uniqueKey
        }
        return false
    }

    /**
     * You should implement also this method if equals() is implemented.
     * This method, if implemented, has several implications that Adapter handles better:
     * - The Hash, increases performance in big list during Update & Filter operations.
     * - You might want to activate stable ids via Constructor for RV, if your id
     * is unique (read more in the wiki page: "Setting Up Advanced") you will benefit
     * of the animations also if notifyDataSetChanged() is invoked.
     */
    override fun hashCode(): Int {
        return juheNewsBean.hashCode()
    }

    /**
     * For the item type we need an int value: the layoutResID is sufficient.
     */
    override fun getLayoutRes(): Int {
        return R.layout.item_juhe_top_news
    }

    /**
     * Delegates the creation of the ViewHolder to the user (AutoMap).
     * The inflated view is already provided as well as the Adapter.
     */
    override fun createViewHolder(view: View, adapter: FlexibleAdapter<IFlexible<*>>): JuheTopViewHolder {
        return JuheTopViewHolder(view, adapter)
    }

    /**
     * The Adapter and the Payload are provided to perform and get more specific
     * information.
     */
    override fun bindViewHolder(adapter: FlexibleAdapter<IFlexible<*>>, holder: JuheTopViewHolder,
                                position: Int,
                                payloads: List<Any>) {
        holder.mTitle.text = juheNewsBean.title
        holder.mSource.text = juheNewsBean.authorName
        Glide.with(holder.mImg).load(juheNewsBean.thumbnailPic0).into(holder.mImg)
        holder.root.isEnabled = true

        holder.root.setOnClickListener {
            it.context.startActivity<SCDetailActivity>("juheNewsUrl" to juheNewsBean.url)
        }
    }

    /**
     * The ViewHolder used by this item.
     * Extending from FlexibleViewHolder is recommended especially when you will use
     * more advanced features.
     */
    inner class JuheTopViewHolder(view: View, adapter: FlexibleAdapter<*>) : FlexibleViewHolder(view, adapter) {

        var root = view
        var mImg: ImageView = view.findViewById(R.id.item_juhe_top_img)
        var mTitle: TextView = view.findViewById(R.id.item_juhe_top_title)
        var mSource: TextView = view.findViewById(R.id.item_juhe_top_source)
    }
}