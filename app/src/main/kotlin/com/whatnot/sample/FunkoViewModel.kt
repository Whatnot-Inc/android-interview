package com.whatnot.sample

import androidx.annotation.DrawableRes
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn

class FunkoViewModel : ViewModel(), FunkoBoard {

  private val _state = MutableStateFlow(FunkoState())
  val state: StateFlow<FunkoState> = _state
    .stateIn(
      viewModelScope,
      SharingStarted.WhileSubscribed(),
      FunkoState()
    )

  override fun shuffle() {
    TODO("To be implemented!")
  }

  override fun hideAll() {
    TODO("To be implemented!")
  }

  override fun showAll() {
    TODO("To be implemented!")
  }

  override fun turn(id: Int) {
    TODO("To be implemented!")
  }
}

data class FunkoState(
  val score: Int = 0,
  val funkoList: List<Funko> = buildList {
    addAll(Funko.values().toList())
    addAll(Funko.values().toList())
  }
)

enum class Funko(
  @DrawableRes val imageRes: Int,
  val id: Int = imageRes,
) {
  HOMER(imageRes = R.drawable.funko_homer),
  HARRY_POTTER(imageRes = R.drawable.funko_harry_potter),
  LEIA(imageRes = R.drawable.funko_leia),
  HARLEY(imageRes = R.drawable.funko_harley),
  MAGIC(imageRes = R.drawable.funko_magic),
  RICK(imageRes = R.drawable.funko_rick),
  WHITNEY(imageRes = R.drawable.funko_whitney),
  NASA(imageRes = R.drawable.funko_nasa),
}
