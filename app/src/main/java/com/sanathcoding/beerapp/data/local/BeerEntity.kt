package com.sanathcoding.beerapp.data.local

import androidx.room.Entity

@Entity
data class BeerEntity(
    val id: Int,
    val name: String,
    val tagline: String,
    val firstBrewed: String,
    val description: String,
    val imageUrl: String?
)
