package com.ivan.section6.controller

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ivan.section6.R
import com.ivan.section6.adapters.CategoryRecyclerAdapter
import com.ivan.section6.services.DataService
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: CategoryRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = CategoryRecyclerAdapter(
            this,
            DataService.categories)
        lv_categories.adapter = adapter
    }
}