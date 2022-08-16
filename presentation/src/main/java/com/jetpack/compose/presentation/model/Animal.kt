package com.jetpack.compose.presentation.model

import android.os.Parcelable
import com.jetpack.compose.presentation.utils.default
import com.jetpack.compose.presentation.utils.empty
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Animal(
    val breeds: String = String.empty(),
    val description: String = String.empty(),
    val id: Int = Int.default(),
    val image: String = String.empty(),
    val name: String = String.empty()
) : Parcelable