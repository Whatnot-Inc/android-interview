package com.whatnot.productcatalog

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.whatnot.productcatalog.ProductsAdapter.Product

class MainActivity : AppCompatActivity() {

  private val productsAdapter = ProductsAdapter(
    Array(3) { Product(false, "Product ${it + 1}") }.toList()
  )

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.main_activity)
    findViewById<RecyclerView>(R.id.recyclerView).adapter = productsAdapter
  }
}
