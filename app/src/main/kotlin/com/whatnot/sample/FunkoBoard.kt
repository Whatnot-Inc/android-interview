package com.whatnot.sample

interface FunkoBoard {
  /**
   * Shuffle Funkos in random order.
   */
  fun shuffle()

  /**
   * Hide all the Funkos by displaying Whatnot logo instead.
   */
  fun hideAll()

  /**
   * Show all the Funkos.
   */
  fun showAll()

  /**
   * Turn specified Funko and recalculate scoring.
   */
  fun turn(id: Int)
}
