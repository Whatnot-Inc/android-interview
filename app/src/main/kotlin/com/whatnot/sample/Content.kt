package com.whatnot.sample

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.whatnot.sample.R.string

@Composable
fun Content(viewModel: FunkoViewModel = viewModel()) {
  val state by viewModel.state.collectAsState()

  Column(
    modifier = Modifier.fillMaxHeight()
  ) {
    LazyVerticalGrid(
      columns = GridCells.Fixed(count = 4),
      contentPadding = PaddingValues(
        horizontal = 16.dp,
        vertical = 16.dp
      ),
      verticalArrangement = Arrangement.spacedBy(8.dp),
      horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
      items(state.funkoList) { funko ->
        Image(
          painter = painterResource(id = funko.imageRes),
          contentDescription = funko.name,
        )
      }
    }

    Text(
      text = stringResource(string.score, state.score),
      modifier = Modifier.align(alignment = Alignment.CenterHorizontally),
      fontSize = 16.sp
    )
  }
}
