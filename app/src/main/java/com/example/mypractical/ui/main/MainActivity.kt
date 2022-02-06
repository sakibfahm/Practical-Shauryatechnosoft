package com.example.mypractical.ui.main

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Window
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import com.example.mypractical.R
import com.example.mypractical.base.BaseBindingActivity
import com.example.mypractical.data.db.table.UserTable
import com.example.mypractical.data.model.UserListModel
import com.example.mypractical.databinding.ActivityMainBinding
import com.example.mypractical.listner.MainListner
import com.example.mypractical.utils.Coroutines
import com.example.mypractical.utils.LogM
import com.google.gson.Gson
import javax.inject.Inject

class MainActivity : BaseBindingActivity<ActivityMainBinding>(), MainListner {

    @Inject
    lateinit var viewModel: MainViewModel
    override fun layoutId() = R.layout.activity_main

    override fun initializeBinding(binding: ActivityMainBinding) {
        binding.viewmodel = viewModel
        binding.lifecycleOwner = this
        binding.listner = this
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun saveToDatabase(model: UserListModel.Data1) {
        val dialog = Dialog(this, R.style.Theme_Dialog)
        dialog.window?.requestFeature(Window.FEATURE_NO_TITLE)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.setCancelable(true)
        dialog.setContentView(R.layout.dialog_save_data)

        val ivClose = dialog.findViewById(R.id.ivClose) as AppCompatImageView
        val tvNo = dialog.findViewById(R.id.tvNo) as TextView
        val tvYes = dialog.findViewById(R.id.tvYes) as TextView

        tvNo.setOnClickListener {
            dialog.dismiss()
        }

        ivClose.setOnClickListener {
            dialog.dismiss()
        }

        tvYes.setOnClickListener {
            dialog.dismiss()
//            //Save to database.
            Coroutines.io {
                //Converting model class to string to save data into database.
                val gson = Gson()
                val json = gson.toJson(model)
                viewModel.insertTopic(UserTable(null, json.toString()))
            }

            Coroutines.io {
                LogM.e("=> database item checking ??? " + viewModel.getUsers().data)
            }
        }
        dialog.show()
    }

}