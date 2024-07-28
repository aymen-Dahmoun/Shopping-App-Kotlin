package com.example.shi

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.dataAdapter
import com.example.myapplication.myAdapter
import com.example.myapplication.myAdapter2


class otherViewMode : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var products: ArrayList<dataAdapter>
    lateinit var images: Array<Int>
    lateinit var titles: Array<String>
    lateinit var descriptions: Array<String>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_other_view_mode, container, false)
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


        recyclerView = view.findViewById(R.id.rvProductsSecondView)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.setHasFixedSize(true)

        products = ArrayList()  // Initialize the products list

        // Log the initialization


        getData()






    }

    private fun getData() {
        for (i in images.indices) {
            val product = dataAdapter(images[i], titles[i], descriptions[i])
            products.add(product)
        }
        val adapter = myAdapter2(products)
        recyclerView.adapter = adapter
        adapter.setOnItemClickListner(object : myAdapter2.onItemClickListner{
            override fun onItemClicked(position: Int) {
                Toast.makeText(context,"Item ${position+1} was clicked",Toast.LENGTH_SHORT).show()
            }

        })

        // Log data loading

    }

}