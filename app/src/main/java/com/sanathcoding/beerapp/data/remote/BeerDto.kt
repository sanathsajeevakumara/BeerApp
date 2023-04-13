package com.sanathcoding.beerapp.data.remote

data class BeerDto(
    val id: Int,
    val name: String,
    val tagline: String,
    val first_brewed: String,
    val description: String,
    val image_url: String?
)
