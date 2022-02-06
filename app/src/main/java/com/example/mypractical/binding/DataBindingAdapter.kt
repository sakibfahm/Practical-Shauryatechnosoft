package com.example.mypractical.binding

import android.view.View
import androidx.databinding.BindingAdapter
import androidx.paging.PagingData
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.example.mypractical.R
import com.example.mypractical.data.model.ImageListModel
import com.example.mypractical.data.model.UserListModel
import com.example.mypractical.ui.main.MainActivity
import com.example.mypractical.ui.main.adapter.DairyProductAdapter
import com.example.mypractical.ui.main.adapter.ImageViewPagerAdapter
import com.example.mypractical.utils.LogM


@BindingAdapter("bindUserList", "bindMainListner")
fun bindUserList(view: RecyclerView, list: PagingData<UserListModel.Data1>, mainactivity: MainActivity?) {
    if(list != null) {
        var adapter = view.adapter
        adapter = DairyProductAdapter(mainactivity!!)
        view.adapter = adapter
        adapter.submitData(mainactivity.lifecycle,list)
    }
}

@BindingAdapter("setViewPagerImages","currentPoisition", requireAll = false)
fun setViewPagerImages(view: ViewPager, list: List<ImageListModel.Data1>?, currentPoisition: Int = 0) {
    if(list != null) {
        val mViewPagerAdapter =
            ImageViewPagerAdapter(view.context, list)
        view.setAdapter(mViewPagerAdapter)

        view.currentItem = currentPoisition
    }
}

@BindingAdapter("setEndColor")
fun setEndColor(view: View, position: Int) {
    when {
        position % 3 == 0 -> view.setBackgroundColor(view.context.getColor(R.color.colorRed))
        position % 3 == 1 -> view.setBackgroundColor(view.context.getColor(R.color.colorGreen))
        position % 3 == 2 -> view.setBackgroundColor(view.context.getColor(R.color.colorSaveButton))
    }
}
