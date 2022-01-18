package com.clamy.shopping
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val data = ArrayList<ItemsViewModel>()

        for(i in 1..20){
            data.add(ItemsViewModel(R.drawable.ic_launcher_background, "Item+i"))
        }
        val adapter = CustomAdapter(data)
        recyclerView.adapter = adapter
    }
}