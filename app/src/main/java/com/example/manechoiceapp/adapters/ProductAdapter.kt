package com.example.manechoiceapp.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.manechoiceapp.R
import com.example.manechoiceapp.interfaces.IController
import kotlinx.android.synthetic.main.productview_item.view.*

class ProductAdapter(val controller: IController): RecyclerView.Adapter<ProductViewHolder>() {
    override fun getItemCount(): Int {
        return controller.product.size
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = controller.product.get(position)
        holder.itemView.productIdTv.text = product.id
        holder.itemView.productNameTv.text = product.productName
        holder.itemView.productBrandTv.text = product.brand
        holder.itemView.productPriceTv.text = product.price

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.productview_item, parent, false)

        return ProductViewHolder(view)
    }

}
class ProductViewHolder(view: View): RecyclerView.ViewHolder(view)