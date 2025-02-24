package com.example.big_practice.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes val stringResourceId: Int,
    val numberOfWatchong: Int,
    @DrawableRes val imageResourceId: Int
)