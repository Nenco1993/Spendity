package com.example.spendity.spending

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.example.spendity.R
import com.example.spendity.data.Spending
import kotlinx.android.synthetic.main.list_item_spending.view.*
import org.jetbrains.anko.layoutInflater
import timber.log.Timber

class SpendingListAdapter() : RecyclerView.Adapter<SpendingListAdapter.SpendingListViewHolder>() {

    var listSpendingData = listOf<Spending>()

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): SpendingListViewHolder {
        val view = parent.context.layoutInflater.inflate(R.layout.list_item_spending, parent, false)
        return SpendingListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listSpendingData.size
    }

    override fun onBindViewHolder(holder: SpendingListViewHolder, position: Int) {
        val spendingItem = listSpendingData[position]
        holder.bindItems(spendingItem)
    }

    inner class SpendingListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItems(spendingItem: Spending) {
            val name = spendingItem.attributes?.name ?: "NoName"
            itemView.spending_name.text = name
            itemView.spending_price.text = spendingItem.attributes?.amount
            itemView.spending_category.text = spendingItem.attributes?.categoryName
            itemView.spending_desc.text = "just a description"
            itemView.spending_date.text = spendingItem.attributes?.date
            itemView.setOnClickListener {
                spendingItem.isExpanded = !spendingItem.isExpanded
                notifyItemChanged(layoutPosition)
            }
            if (spendingItem.isExpanded) {
                itemView.view.visibility = View.VISIBLE
                itemView.spending_category.visibility = View.VISIBLE
                itemView.spending_desc.visibility = View.VISIBLE
                itemView.spending_date.visibility = View.VISIBLE
            } else {
                itemView.view.visibility = View.GONE
                itemView.spending_category.visibility = View.GONE
                itemView.spending_desc.visibility = View.GONE
                itemView.spending_date.visibility = View.GONE
            }
        }
    }
}