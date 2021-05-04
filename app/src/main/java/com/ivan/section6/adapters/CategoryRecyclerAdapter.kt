package com.ivan.section6.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ivan.section6.R
import com.ivan.section6.model.Category
import kotlinx.android.synthetic.main.category_item.view.*

class CategoryRecyclerAdapter(val context: Context, val categories: List<Category>)
    : RecyclerView.Adapter<CategoryRecyclerAdapter.CategoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        return CategoryViewHolder(LayoutInflater.from(context).inflate(R.layout.category_item, parent, false))
    }

    override fun onBindViewHolder(holderCategory: CategoryViewHolder, position: Int) {
        holderCategory.onBind(categories[position])
    }

    override fun getItemCount(): Int {
        return categories.count()
    }

    inner class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val image: ImageView = itemView.iv_image
        private val name: TextView = itemView.tv_name

        fun onBind(category: Category) {
            val imageId = context.resources.getIdentifier(category.image, "drawable", context.packageName)
            image.setImageResource(imageId)
            name.text = category.title
        }
    }
}