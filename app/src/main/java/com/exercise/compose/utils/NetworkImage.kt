package com.exercise.compose.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import coil.compose.AsyncImage
import coil.request.CachePolicy
import coil.request.ImageRequest
import com.exercise.compose.R


@Composable
fun NetworkImage(
    modifier: Modifier = Modifier,
    imgUrl: String? = "",
    placeHolder: Int = R.drawable.ic_launcher_background,
    contentScale: ContentScale = ContentScale.Crop
) {

    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(imgUrl)
            .memoryCachePolicy(CachePolicy.ENABLED)
            .diskCachePolicy(CachePolicy.ENABLED)
            .crossfade(true)
            .build(),

        contentDescription = null,
        placeholder = painterResource(id = placeHolder),
        error = painterResource(id = placeHolder),
        contentScale = contentScale,
        modifier = modifier,
    )

}