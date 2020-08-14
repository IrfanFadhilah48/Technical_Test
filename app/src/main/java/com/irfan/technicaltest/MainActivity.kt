package com.irfan.technicaltest

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.show_image_dialog.*

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: ImageAdapter
    private var dataImage = arrayListOf<ImageModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        setRecyclerView()
        setData()
    }

    private fun setRecyclerView() {
        adapter = ImageAdapter(this, dataImage)
        adapter.setOnItemClickListener(object : ImageAdapter.OnItemClickListener{
            override fun onItemClicked(data: ImageModel) {
                showImage(data)
            }
        })
        val layoutManager = LinearLayoutManager(this)
        rv_main.layoutManager = layoutManager
        rv_main.adapter = adapter
    }

    private fun setData() {
        dataImage.addAll(DataSet.groupData)
        adapter.notifyDataSetChanged()
    }

    private fun showImage(data: ImageModel){
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.show_image_dialog)
        val window = dialog.window
        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        window?.setGravity(Gravity.CENTER)
        dialog.setCancelable(true)
        dialog.setCanceledOnTouchOutside(true)
        val imageView = dialog.iv_dialog
        data.image?.let { imageView.setImageResource(it) }
        dialog.show()
    }
}