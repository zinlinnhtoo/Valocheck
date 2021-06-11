package com.kz.valocheck.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.kz.valocheck.domain.AgentsDomain

@BindingAdapter("setImage")
fun ImageView.setImageResource(res: Int?) {
    res?.let {
        setImageResource(it)
    }
}