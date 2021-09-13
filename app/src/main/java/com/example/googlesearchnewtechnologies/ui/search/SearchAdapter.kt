package com.example.googlesearchnewtechnologies.ui.search

import android.graphics.Color
import android.text.TextUtils
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.googlesearchnewtechnologies.network.services.search.ItemDto

class SearchAdapter(private val onItemClick: (ItemDto) -> Unit) :
    RecyclerView.Adapter<SearchAdapter.ViewHolder>() {

    var items: List<ItemDto>? = null
        set(value) {
            field = value
            notifyItemChanged(0, value?.size)
        }

    companion object {
        const val titleId = 1001
        const val descriptionId = 1002
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LinearLayout(parent.context).apply {
            orientation = LinearLayout.VERTICAL
            addView(TextView(context).apply { id = titleId })
            addView(TextView(context).apply {
                id = descriptionId; ellipsize = TextUtils.TruncateAt.END; maxLines = 3
            })
            addView(View(context).apply {
                setBackgroundColor(Color.GRAY); layoutParams =
                ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 30)
            })
        })
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items?.get(position))
    }

    override fun getItemCount(): Int = items?.size ?: 0


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private var titleTextView: TextView? = null
        private var descriptionTextView: TextView? = null

        init {
            titleTextView = itemView.findViewById(titleId)
            descriptionTextView = itemView.findViewById(descriptionId)
        }

        fun bind(item: ItemDto?) = item.run {
            titleTextView?.text = item?.title
            descriptionTextView?.text = item?.snippet
            itemView.setOnClickListener { item?.let { it1 -> onItemClick.invoke(it1) } }
        }
    }
}