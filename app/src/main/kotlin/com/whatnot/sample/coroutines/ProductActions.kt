package com.whatnot.sample.coroutines

import com.whatnot.sample.AuctionProduct
import com.whatnot.sample.util.runAuction

class ProductActions(private val productEvents: ProductEvents) {
  suspend fun runAuction(
    product: AuctionProduct,
    durationSeconds: Int = 60,
  ) = runAuction(
    product = product,
    durationSeconds = durationSeconds,
    onEvent = { event -> productEvents.notifyEvent(event) },
  )
}
