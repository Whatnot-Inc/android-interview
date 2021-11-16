package com.whatnot.productcatalog

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.whatnot.productcatalog.ProductsAdapter.ViewHolder
import com.whatnot.productcatalog.databinding.ProductItemBinding

class ProductsAdapter(private val items: List<Product>) : RecyclerView.Adapter<ViewHolder>() {
  data class Product(
    val isStarred: Boolean,
    val text: CharSequence
  )

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    val itemView = LayoutInflater.from(parent.context)
      .inflate(R.layout.product_item, parent, false)
    return ViewHolder(itemView)
  }

  override fun onBindViewHolder(holder: ViewHolder, position: Int) = with(holder.binding) {
    val product = items[position]
    productText.text = product.text
    productSwitch.isChecked = product.isStarred
  }

  override fun getItemCount(): Int = items.size

  data class ViewHolder(val itemView: View) : RecyclerView.ViewHolder(itemView) {
    val binding: ProductItemBinding = ProductItemBinding.bind(itemView)
  }
}
