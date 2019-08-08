package net.iqbalfauzan.uikit.utils

import androidx.annotation.StringRes
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.databinding.BindingAdapter

/**
 * Created by Iqbalmf on 2019-07-21
 */
@BindingAdapter("app:srcCompat")
fun setImageViewResource(imageView: AppCompatImageView, resource: Int) {
    imageView.setImageResource(resource)
}

@BindingAdapter("app:text")
fun setText(textView: AppCompatTextView, @StringRes resource: Int) {
    textView.setText(resource)
}