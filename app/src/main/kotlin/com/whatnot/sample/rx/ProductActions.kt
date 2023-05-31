package com.whatnot.sample.rx

import com.whatnot.sample.AuctionProduct
import com.whatnot.sample.util.runAuction
import kotlinx.coroutines.rx3.rxCompletable

class ProductActions(private val productEvents: ProductEvents) {
  suspend fun runAuction(
    product: AuctionProduct,
    durationSeconds: Int = 60,
  ) = rxCompletable {
    runAuction(
      product = product,
      durationSeconds = durationSeconds,
      onEvent = { event -> productEvents.notifyEvent(event) },
    )
  }
}
