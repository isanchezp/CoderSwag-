package com.ivan.section6.controller

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ivan.section6.R
import com.ivan.section6.adapters.CategoryRecyclerAdapter
import com.ivan.section6.services.DataService
import com.ivan.section6.utilities.EXTRA_CATEGORY
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: CategoryRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = CategoryRecyclerAdapter(
            this,
            DataService.categories){
            val intent = Intent(this, ProductActivity::class.java)
            intent.putExtra(EXTRA_CATEGORY, it.title)
            startActivity(intent)
        }
        lv_categories.adapter = adapter
    }
}