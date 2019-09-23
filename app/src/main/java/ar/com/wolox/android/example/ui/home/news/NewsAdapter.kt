package ar.com.wolox.android.example.ui.home.news

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ar.com.wolox.android.R
import ar.com.wolox.android.example.model.News
import ar.com.wolox.android.example.utils.onClickListener
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_news.view.*

typealias OnNewsClickListener = (News) -> Unit

class NewsAdapter(private val vNewsListItems: List<News>, private val userId: Int, private val onNewsClickListener: OnNewsClickListener) : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
        return NewsViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val currentItem = vNewsListItems[position]

        holder.vTitleView.text = currentItem.title
        holder.vTextInformation.text = currentItem.text
        holder.vTextTime.text = currentItem.readableCreationTime
        holder.vEmotionImage.setImageResource(R.drawable.ic_like_selector)
        holder.vEmotionImage.isSelected = currentItem.likes.contains(userId)

        Glide.with(holder.itemView.context)
                .load(currentItem.formatPicture)
                .circleCrop()
                .into(holder.vItemImage)

        holder.onItemClicked(onNewsClickListener, currentItem)
    }

    override fun getItemCount(): Int {
        return vNewsListItems.size
    }

    class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val vItemImage: ImageView = itemView.vItemNewImage
        val vTitleView: TextView = itemView.vItemNewTitle
        val vTextInformation: TextView = itemView.vItemNewTextInformation
        val vTextTime: TextView = itemView.vItemNewTime
        val vEmotionImage: ImageView = itemView.vNewsDetailsEmotionImage
        fun onItemClicked(onNewsClickListener: OnNewsClickListener, currentItem: News) {
            itemView.onClickListener { onNewsClickListener.invoke(currentItem) }
        }
    }
}
