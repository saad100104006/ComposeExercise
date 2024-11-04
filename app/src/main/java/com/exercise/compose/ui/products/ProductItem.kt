package com.exercise.compose.ui.products

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.exercise.compose.domain.uimodel.ProductUiModel
import com.exercise.compose.ui.theme.Black
import com.exercise.compose.ui.theme.Grey
import com.exercise.compose.ui.theme.White
import com.exercise.compose.utils.ComposeText
import com.exercise.compose.utils.NetworkImage
import com.exercise.compose.R


@Composable
fun ProductItem(productUiModel: ProductUiModel, onItemClick: (Int?) -> Unit) {
    Card(
        shape = RoundedCornerShape(12.dp),
        backgroundColor = White,
        elevation = 10.dp,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(top  = 4.dp, bottom = 4.dp)
            .clickable {
                onItemClick.invoke(productUiModel.id)
            }
    ) {
        Column {
            NetworkImage(
                imgUrl = productUiModel.thumbnail,
                modifier = Modifier
                    .height(200.dp)
                    .fillMaxWidth()
            )

            ComposeText(
                textAlign = TextAlign.Center,
                text = productUiModel.title ?: "",
                style = MaterialTheme.typography.h6.copy(fontWeight = FontWeight.Bold),
                modifier = Modifier
                    .padding(
                        start = 8.dp, top = 16.dp
                    ),
                color = Black,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            if(!productUiModel.brand .isNullOrEmpty()) {
                Row(modifier = Modifier.fillMaxWidth()) {

                    ComposeText(
                        text = stringResource(R.string.brand),
                        modifier = Modifier
                            .padding(
                                start = 8.dp, top = 4.dp
                            ),
                        style = MaterialTheme.typography.subtitle1.copy(fontWeight = FontWeight.SemiBold),
                        color = Black
                    )

                    ComposeText(
                        text = productUiModel.brand,
                        modifier = Modifier
                            .padding(
                                start = 2.dp, top = 4.dp
                            ),
                        style = MaterialTheme.typography.subtitle1.copy(fontWeight = FontWeight.Normal),
                        color = Grey
                    )
                }
            }

            Row(modifier = Modifier.fillMaxWidth()) {

                ComposeText(
                    text = stringResource(R.string.price),
                    modifier = Modifier
                        .padding(
                            start = 8.dp, top = 4.dp
                        ),
                    style = MaterialTheme.typography.subtitle1.copy(fontWeight = FontWeight.SemiBold),
                    color = Black
                )

                ComposeText(
                    text = productUiModel.price.toString() + " USD",
                    modifier = Modifier
                        .padding(top = 4.dp, bottom = 16.dp, start = 2.dp
                        ),
                    style = MaterialTheme.typography.subtitle1.copy(fontWeight = FontWeight.Normal),
                    color = Grey
                )
            }
        }
    }

}