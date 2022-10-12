package com.example.moviesapplication.movies_list.presentation.screen.component

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.moviesapplication.BuildConfig
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun MovieCard(
    title: String,
    releaseDate: String,
    imageUrl: String,
    modifier: Modifier
) {
    Row(
        modifier = modifier
            .height(160.dp)
            .fillMaxWidth()
            .padding(horizontal = 12.dp)
    ) {
        GlideImage(
            modifier = Modifier.width(108.dp),
            imageModel = BuildConfig.IMAGES_BASE_URL + imageUrl,
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.width(12.dp))

        Column() {

            Text(
                text = title,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = releaseDate.substringBefore('-')
            )
        }
    }
}