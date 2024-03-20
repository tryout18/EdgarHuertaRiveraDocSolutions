package com.edgarhrdevs.edgarhuertariveradocsolutions.ui.userslist

import android.view.View
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.edgarhrdevs.edgarhuertariveradocsolutions.domain.UserResponseBody

@BindingAdapter("setText")
fun TextView.setText(data: String?){
    text = data ?: "N/A"

}

@BindingAdapter("userItems")
fun RecyclerView.setItems(data: List<UserResponseBody>?){
    if(data != null){
        (adapter as? UserListAdapter)?.submitList(data)
    }
}