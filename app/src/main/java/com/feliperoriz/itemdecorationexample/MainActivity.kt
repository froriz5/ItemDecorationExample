package com.feliperoriz.itemdecorationexample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val adapter: ListAdapter by lazy(LazyThreadSafetyMode.NONE) {
        ListAdapter(getDummyItems().toMutableList() ,LayoutInflater.from(this))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recycler_view.adapter = adapter
        recycler_view.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))
        val drawable = ContextCompat.getDrawable(this, R.drawable.dummy_image)
        recycler_view.addItemDecoration(ExampleDecoration(drawable!!, getDummyItems()))
    }

    private fun getDummyItems(): List<ListItem> {
        val dummyData = mutableListOf<ListItem>()
        for (num in 1..20) {
            dummyData.add(ListItem(timestamp = num.toLong(), showDisplayAvatar = num % 2 == 0))
        }
        return dummyData
    }
}
