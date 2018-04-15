package com.feliperoriz.itemdecorationexample

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import kotlinx.android.synthetic.main.listitem.view.*

class ListAdapter(private val items: MutableList<ListItem> = mutableListOf(),
                  private val inflator: LayoutInflater): RecyclerView.Adapter<ListAdapter.ListItemViewHolder>() {

    override fun getItemCount() = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListItemViewHolder {
        val view = inflator.inflate(R.layout.listitem, parent, false)
        return ListItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListItemViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    inner class ListItemViewHolder(val view: View): RecyclerView.ViewHolder(view) {
        fun bind(item: ListItem) {
            view.content_text.text = item.content
        }
    }
}