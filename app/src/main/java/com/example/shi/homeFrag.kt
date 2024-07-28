package com.example.shi

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.view.SupportActionModeWrapper
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration
import com.example.myapplication.dataAdapter
import com.example.myapplication.myAdapter

class homeFrag : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var gridLayoutManager: GridLayoutManager
    private lateinit var products: ArrayList<dataAdapter>
    lateinit var images: Array<Int>
    lateinit var titles: Array<String>
    lateinit var descriptions: Array<String>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home2, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        images = arrayOf(
            R.drawable.arab, R.drawable.china1,
            R.drawable.lv, R.drawable.nike_1,
            R.drawable.kabile_1, R.drawable.hindi_1 ,
            R.drawable.china2, R.drawable.hindi_2,
            R.drawable.lv_1, R.drawable.nike_2,
            R.drawable.kabile_2,

        )
        titles = arrayOf(
            "Traditional Arabic Clothing",
            "Traditional Chinese Clothing",
            "Louis Viton",
            "Nike",
            "Traditional Kabyle Clothing",
            "Traditional Hindi Clothing",
            "Traditional Chinese Clothing",
            "Traditional Hindi Clothing",
            "Louis Viton","Nike","Traditional Kabyle Clothing"

        )
        descriptions = arrayOf(
            "description", "description",
            "description", "description"
            , "description", "description",
            "description", "description",
            "description", "description"
            , "description"
        )

        recyclerView = view.findViewById(R.id.rvProducts)
        gridLayoutManager = GridLayoutManager(context,2)
        recyclerView.layoutManager = gridLayoutManager
        recyclerView.setHasFixedSize(true)

        products = ArrayList()  // Initialize the products list

        // Log the initialization

        val verticalSpacing = resources.getDimensionPixelSize(R.dimen.dimen)
        val a : verticalSpacingItemDEcoration = verticalSpacingItemDEcoration(verticalSpacing)
        recyclerView.addItemDecoration(a)
        getData()

    }

    private fun getData() {
        for (i in images.indices) {
            val product = dataAdapter(images[i], titles[i], descriptions[i])
            products.add(product)
        }
        val adapter = myAdapter(products)
        recyclerView.adapter = adapter
        adapter.setOnItemClickListner(object : myAdapter.onItemClickListner{
            override fun onItemClicked(position: Int) {
                Toast.makeText(context,"Item ${position+1} was clicked",Toast.LENGTH_SHORT).show()
            }

        })

        // Log data loading

    }



}