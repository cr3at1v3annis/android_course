package com.example.unit_5_practice.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AmphibianPhoto(
    val name: String,
    val type: String,
    val description : String,
    @SerialName(value = "img_src") val imgSrc: String
)