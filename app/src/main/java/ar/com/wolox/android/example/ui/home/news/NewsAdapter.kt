package ar.com.wolox.android.example.ui.home.news

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ar.com.wolox.android.R
import ar.com.wolox.android.example.model.News
import kotlinx.android.synthetic.main.item_news.view.*

class NewsAdapter(private val vNewsListItems: List<News>) : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val vItemImage: ImageView = itemView.vItemNewImage
        val vTitleView: TextView = itemView.vItemNewTitle
        val vTextInformation: TextView = itemView.vItemNewTextInformation
        val vTextTime: TextView = itemView.vItemNewTime
        val vEmotionImage: ImageView = itemView.vItemNewEmotionImage
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
        return NewsViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val currentItem = vNewsListItems[position]

        // holder.vItemImage.setImageResource(currentItem.picture)
        holder.vTitleView.text = currentItem.title
        holder.vTextInformation.text = currentItem.text
        holder.vTextTime.text = currentItem.cratedAt
        // holder.vEmotionImage.setImageResource(currentItem.getEmotionImage())
    }

    override fun getItemCount(): Int {
        return vNewsListItems.size
    }
}
