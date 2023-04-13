package com.sanathcoding.beerapp.data.local

import com.sanathcoding.beerapp.data.remote.BeerDto
import com.sanathcoding.beerapp.domain.Beer

fun BeerDto.toBeerEntity(): BeerEntity {
    return BeerEntity(
        id =  id,
        name = name,
        tagline = tagline,
        firstBrewed = first_brewed,
        description = description,
        imageUrl =  image_url
    )
}

fun BeerEntity.toBeer(): Beer {
    return Beer(
        id =  id,
        name = name,
        tagline = tagline,
        firstBrewed = firstBrewed,
        description = description,
        imageUrl =  imageUrl
    )
}