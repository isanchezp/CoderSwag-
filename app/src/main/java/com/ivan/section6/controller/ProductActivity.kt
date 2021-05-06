package com.ivan.section6.controller

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.ivan.section6.R
import com.ivan.section6.adapters.ProductAdapter
import com.ivan.section6.model.Product
import com.ivan.section6.services.DataService
import com.ivan.section6.utilities.EXTRA_CATEGORY
import kotlinx.android.synthetic.main.activity_product.*

class ProductActivity : AppCompatActivity() {

    private lateinit var adapter: ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)

        intent?.let {
            val category = intent.getStringExtra(EXTRA_CATEGORY) ?: ""
            tv_header.text = category

            var spanCount = 2
            val orientation = resources.configuration.orientation
            if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
                spanCount = 3
            }

            val manager = GridLayoutManager(this, spanCount)
            rv_products.layoutManager = manager

            adapter = ProductAdapter(
                this,
                DataService.getProducts(category))
            rv_products.adapter = adapter
        }
    }
}