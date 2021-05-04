package com.ivan.section6.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.ivan.section6.R
import com.ivan.section6.model.Category
import kotlinx.android.synthetic.main.category_item.view.*

class CategoryAdapter(val context: Context, val categories: List<Category>) : BaseAdapter() {

    var x = 87

    override fun getCount(): Int {
        return categories.count()
    }

    override fun getItem(position: Int): Any {
        return categories[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View
        val viewHolder: ViewHolder

        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(R.layout.category_item, null)
            viewHolder = ViewHolder()
            viewHolder.image = view.iv_image
            viewHolder.name = view.tv_name
            view.tag = viewHolder
        } else {
            viewHolder = convertView.tag as ViewHolder
            view = convertView
        }

        viewHolder.name?.text = categories[position].title
        val imageId = context.resources.getIdentifier(categories[position].image, "drawable", context.packageName)
        viewHolder.image?.setImageResource(imageId)
        return view
    }

    inner class ViewHolder(){
        var image: ImageView? = null
        var name: TextView? = null
    }
}