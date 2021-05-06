package com.ivan.section6.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ivan.section6.R
import com.ivan.section6.model.Product
import kotlinx.android.synthetic.main.product_item.view.*

class ProductAdapter(val context: Context, val products: List<Product>) :
    RecyclerView.Adapter<ProductAdapter.ProductHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductHolder {
        return ProductHolder(LayoutInflater.from(context).inflate(R.layout.product_item, parent, false))
    }

    override fun onBindViewHolder(holder: ProductHolder, position: Int) {
        holder.onBind(products[position])
    }

    override fun getItemCount(): Int {
        return products.count()
    }

    inner class ProductHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val image: ImageView = itemView.iv_product
        private val name: TextView = itemView.tv_name
        private val price: TextView = itemView.tv_price

        fun onBind(product: Product){
            val imageId = context.resources.getIdentifier(product.image, "drawable", context.packageName)
            image.setImageResource(imageId)
            name.text = product.title
            price.text = "${product.price}"
        }
    }
}