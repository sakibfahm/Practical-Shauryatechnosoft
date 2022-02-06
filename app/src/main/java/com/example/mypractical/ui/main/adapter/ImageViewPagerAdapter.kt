package com.example.mypractical.ui.main.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide
import com.example.mypractical.R
import com.example.mypractical.data.model.ImageListModel
import java.util.*

class ImageViewPagerAdapter (
    private val context: Context,
    private val dataList: List<ImageListModel.Data1>?,
) : PagerAdapter() {

    var mLayoutInflater: LayoutInflater

    init {
        mLayoutInflater =
            context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }

    override fun getCount(): Int {
        return dataList?.size!!
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object` as LinearLayout
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val itemView: View = mLayoutInflater.inflate(R.layout.adapter_viewpager, container, false)
        val ivImage = itemView.findViewById<View>(R.id.ivImage) as ImageView

        Glide.with(ivImage.context)
            .load(dataList?.get(position)?.imagepath)
            .into(ivImage)

        Objects.requireNonNull(container).addView(itemView)

        return itemView
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as LinearLayout)
    }
}