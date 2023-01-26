package com.example.eatingrecord.data.model

data class ProfileInfo(
    val id: String,
    val name: String,
    val image: String?,
    val email: String,
    val height: Double,
    val weight: Double,
    val sex: Int,
    val mealCount: Int
)
