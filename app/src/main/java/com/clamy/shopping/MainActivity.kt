package com.clamy.shopping

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.SparseBooleanArray
import android.view.LayoutInflater
import android.widget.ArrayAdapter
import com.clamy.shopping.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // Initializing the array lists and the adapter
        var itemlist = arrayListOf<String>()
        var adapter =ArrayAdapter<String>(this,
            android.R.layout.simple_list_item_multiple_choice
            , itemlist)
        // Adding the items to the list when the add button is pressed
        binding.add.setOnClickListener {

            itemlist.add(binding.editText.text.toString())
            binding.listView.adapter =  adapter
            adapter.notifyDataSetChanged()
            // This is because every time when you add the item the input space or the eidt text space will be cleared
            binding.editText.text.clear()
        }
        // Clearing all the items in the list when the clear button is pressed
        binding.clear.setOnClickListener {

            itemlist.clear()
            adapter.notifyDataSetChanged()
        }
        // Adding the toast message to the list when an item on the list is pressed
        binding.listView.setOnItemClickListener { adapterView, view, i, l ->
            android.widget.Toast.makeText(this, "You Selected the item --> "+itemlist.get(i), android.widget.Toast.LENGTH_SHORT).show()
        }
        // Selecting and Deleting the items from the list when the delete button is pressed
        binding.delete.setOnClickListener {
            val position: SparseBooleanArray = binding.listView.checkedItemPositions
            val count = binding.listView.count
            var item = count - 1
            while (item >= 0) {
                if (position.get(item))
                {
                    adapter.remove(itemlist.get(item))
                }
                item--
            }
            position.clear()
            adapter.notifyDataSetChanged()
        }
    }
}