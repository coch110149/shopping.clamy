package com.clamy.shopping
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val data = ArrayList<ItemsViewModel>()

        val addFab: View = findViewById<RecyclerView>(R.id.add_button)
        val message = "This will eventually be an action for "
        addFab.setOnClickListener{ view ->
            Snackbar.make(view,"$message addFab" , Snackbar.LENGTH_LONG)
                .setAction("Action", null)
                .show()
        }

        for(i in 1..20){
            data.add(ItemsViewModel(R.drawable.ic_launcher_background, "Item+i"))
        }
        val adapter = CustomAdapter(data)
        recyclerView.adapter = adapter
    }
}