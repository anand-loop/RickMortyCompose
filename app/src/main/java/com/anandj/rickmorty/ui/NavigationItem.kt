package com.anandj.rickmorty.ui

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class NavigationItem(
    @StringRes val title: Int,
    @DrawableRes val icon: Int,
    val route: String
)
