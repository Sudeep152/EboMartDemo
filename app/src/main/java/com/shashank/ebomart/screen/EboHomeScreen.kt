package com.shashank.ebomart.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil3.compose.AsyncImage
import com.shashank.ebomart.remote.response.EboMartProductItem
import com.shashank.ebomart.viewmodel.EboMovieViewModel


@Composable
fun EboHomeScreen(modifier: Modifier = Modifier, navigate: (name: String) -> Unit) {
    val viewModel: EboMovieViewModel = hiltViewModel<EboMovieViewModel>()
    val movieList = viewModel.movieList.collectAsState()
    Column(modifier = modifier) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            items(movieList.value.size) { index ->
                ProductItemCard(data = movieList.value[index], onClick = { name ->
                    navigate(name)
                })
            }
        }
    }
}


@Composable
fun ProductItemCard(data: EboMartProductItem, onClick: (name: String) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = {
                onClick(data.title ?: "Unknown Product")
            })
            .padding(5.dp)
    ) {
        Column(modifier = Modifier.padding(5.dp)) {
            AsyncImage(
                model = data.imagePortrait ?: "",
                contentDescription = "",
                modifier = Modifier.fillMaxWidth()
            )
            Text(data.title ?: "Unknown Product")
            Text(data.imdb ?: "0.0")
            Text(data.director ?: "")
        }
    }
}