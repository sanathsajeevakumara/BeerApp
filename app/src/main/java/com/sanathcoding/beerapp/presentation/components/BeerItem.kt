package com.sanathcoding.beerapp.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.sanathcoding.beerapp.domain.Beer
import com.sanathcoding.beerapp.ui.theme.BeerAppTheme

@Composable
fun BeerItem(
    beer: Beer,
    modifier: Modifier = Modifier
) {

    Card(
        modifier = modifier,
        elevation = 4.dp
    ) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .height(IntrinsicSize.Max)
        ) {
            AsyncImage(
                model = beer.imageUrl,
                contentDescription = beer.name,
                modifier = Modifier
                    .weight(1f)
                    .height(150.dp),
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column(
                modifier = Modifier
                .weight(3f)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = beer.name,
                    style = MaterialTheme.typography.h6,
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = beer.tagline,
                    fontStyle = FontStyle.Italic,
                    color = Color.LightGray,
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = beer.description,
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "First brewed in ${beer.firstBrewed}",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.End,
                    fontSize = 8.sp
                )
            }
        }
    }
}

@Preview
@Composable
fun BeerItemPreview() {
    BeerAppTheme {
        BeerItem(
            beer = Beer(
                id = 1,
                name = "Beer",
                tagline = "This is a cool beer",
                firstBrewed = "07/2022",
                description = "This is the description for the beer. \n And this is good!",
                imageUrl = null
            ),
            modifier = Modifier.fillMaxWidth()
        )
    }
}