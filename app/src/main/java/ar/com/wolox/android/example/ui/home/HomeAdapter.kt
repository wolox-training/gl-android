package ar.com.wolox.android.example.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

import java.util.ArrayList

import ar.com.wolox.android.R
import kotlinx.android.synthetic.main.fragment_home_recycler_item.view.*

class HomeAdapter(private val vHomeListItems: ArrayList<HomeItem>, private var clickListener: ClickListener) : RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {

    class HomeViewHolder(itemView: View, listener: ClickListener) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        var vItemImage: ImageView? = null
        var vTitleView: TextView? = null
        var vTextInformation: TextView? = null
        var vTextTime: TextView? = null
        var vEmotionImage: ImageView? = null
        var view = itemView
        var listener: ClickListener? = null

        init {
            vItemImage = itemView.vItemImage
            vTitleView = itemView.vTitleView
            vTextInformation = itemView.vTextInformation
            vTextTime = itemView.vTextTime
            vEmotionImage = itemView.vEmotionImage

            this.listener = listener
            view.setOnClickListener(this)
        }

        override fun onClick(view: View?) {
            this.listener?.onClick(view!!, adapterPosition)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_home_recycler_item, parent, false)
        return HomeViewHolder(view, clickListener)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val currentItem = vHomeListItems[position]
        holder.vItemImage?.setImageResource(currentItem.getImageResource())
        holder.vTitleView?.text = currentItem.getTitleResource()
        holder.vTextInformation?.text = currentItem.getTextInformationResource()
        holder.vTextTime?.text = currentItem.getTimeResource()
        holder.vEmotionImage?.setImageResource(currentItem.getEmotionImage())
    }

    override fun getItemCount(): Int {
        return vHomeListItems.size
    }
}
