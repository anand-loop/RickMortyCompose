package com.anandj.rickmorty.view

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class NavigationItem(
    @StringRes val title: Int,
    @DrawableRes val icon: Int,
    val route: String
)
