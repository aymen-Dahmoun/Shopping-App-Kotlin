package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.shi.R
import com.google.android.material.imageview.ShapeableImageView

class myAdapter2(private val products: ArrayList<dataAdapter>): RecyclerView.Adapter<myAdapter2.myViewHolder>() {


    lateinit var myListner : onItemClickListner

    interface onItemClickListner {
        fun onItemClicked (position : Int)
    }


    fun setOnItemClickListner (listner: onItemClickListner){
        myListner = listner
    }

    class myViewHolder (itemView: View, listner: onItemClickListner) : RecyclerView.ViewHolder(itemView) {
        val productImage: ShapeableImageView = itemView.findViewById(R.id.productImage)
        val productTitle: TextView = itemView.findViewById(R.id.tvproducttitle)
        val productDescription: TextView = itemView.findViewById(R.id.tvproductdescription)

        init {
            itemView.setOnClickListener {
                listner.onItemClicked(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.second_item, parent, false)
        return myViewHolder(itemView,myListner)

    }

    override fun getItemCount(): Int {
        return products.size
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        val currentItem = products[position]
        holder.productImage.setImageResource(currentItem.image)
        holder.productTitle.text = currentItem.title
        holder.productDescription.text = currentItem.description
    }
}