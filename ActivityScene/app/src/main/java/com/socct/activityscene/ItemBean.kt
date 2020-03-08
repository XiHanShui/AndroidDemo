package com.socct.activityscene

import android.os.Parcelable
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.parcel.Parcelize


data class ItemBean(
    val drawableRes: Int,
    val txt: String,
    val closure: (ItemBean, ImageView, TextView) -> Unit
)