package com.exercise.compose.ui.productDetails

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.exercise.compose.R
import com.exercise.compose.domain.uimodel.ProductDetails
import com.exercise.compose.ui.theme.Black
import com.exercise.compose.ui.theme.Grey
import com.exercise.compose.utils.ComposeText
import com.exercise.compose.utils.NetworkImage

@Composable
fun ProductDetailsScreen(
    modifier: Modifier = Modifier,
    productDetails: ProductDetails?,
    onBackClick: () -> Unit
) {

    Box(modifier = Modifier) {
        Image(
            painter = painterResource(R.drawable.ic_back),
            contentDescription = "back_icon",
            modifier = Modifier
                .padding(top = 16.dp, start = 16.dp)
                .clip(CircleShape)
                .clickable {
                    onBackClick.invoke()
                })
        Column(
            modifier,
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {

            NetworkImage(
                imgUrl = productDetails?.image,
                modifier = Modifier
                    .height(500.dp)
                    .fillMaxWidth()
            )

            ComposeText(
                modifier = Modifier.padding(top = 24.dp, start = 16.dp, end = 16.dp),
                text = productDetails?.title ?: "",
                color = Black,
                style = MaterialTheme.typography.h5.copy(fontWeight = FontWeight.Bold),
                textAlign = TextAlign.Left,
                overflow = TextOverflow.Ellipsis,
                maxLines = 2
            )


            ComposeText(
                modifier = Modifier.padding(top = 24.dp, start = 16.dp, end = 16.dp),
                text = productDetails?.description ?: "",
                color = Grey,
                style = MaterialTheme.typography.subtitle1.copy(fontWeight = FontWeight.SemiBold),
                textAlign = TextAlign.Left
            )

        }
    }

}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showSystemUi = true, showBackground = true)
@Composable
fun ProductDetailsPreview() {
    MaterialTheme {
        ProductDetailsScreen(
            productDetails = ProductDetails(
                1,
                "Essence Mascara Lash Princess",
                "The Essence Mascara Lash Princess is a popular mascara known for its volumizing and lengthening effects. Achieve dramatic lashes with this long-lasting and cruelty-free formula.",
                "https://cdn.dummyjson.com/products/images/beauty/Essence%20Mascara%20Lash%20Princess/1.png"
            ), onBackClick = {

            }
        )
    }
}