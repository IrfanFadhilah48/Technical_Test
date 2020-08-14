package com.irfan.technicaltest

import android.content.Context
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.list_image.view.*

class ImageAdapter (val context: Context, val imageData: ArrayList<ImageModel>): RecyclerView.Adapter<ImageAdapter.ViewHolder>(){

    private lateinit var onItemClickListener: OnItemClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_image, parent, false);
        return ViewHolder(view);
    }

    override fun getItemCount(): Int = imageData.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = imageData[position]

        holder.itemView.setOnClickListener {
            onItemClickListener.onItemClicked(data)
        }

        Glide.with(context)
            .load(data.image)
            .into(holder.imageView)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.iv_list
    }

    fun setOnItemClickListener(onItemClickListener: OnItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }

    interface OnItemClickListener{
        fun onItemClicked(data: ImageModel)
    }

}