package com.example.manechoiceapp

import android.app.AlertDialog
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.manechoiceapp.interfaces.IController
import kotlinx.android.synthetic.main.activity_recycler.view.*
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
        holder.itemView.productInfoTv.text = product.productInfo

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.productview_item, parent, false)
        val builder = AlertDialog.Builder(parent.context)

        view.setOnClickListener {
            builder.setCancelable(true)
            builder.setTitle("Product Description")
            builder.setMessage("Name: ${view.productNameTv.text.toString()} \n" +
                    "Brand: ${view.productBrandTv.text.toString()} \n" +
                    "Price: ${view.productPriceTv.text.toString()} \n" +
                    "Description: ${view.productInfoTv.text.toString()} \n"
            )
            builder.setPositiveButton("Email"){dialog, which ->
                sendEmail(view, parent)
            }
            builder.show()

        }

        return ProductViewHolder(view)
    }
    fun sendEmail(view: View, parent: ViewGroup){
        var recipient = "your@gmail.com"

        var subject = "Mane Choice Hair Product "
        var message = ("Name: ${view.productNameTv.text.toString()} \n" +
                "Brand: ${view.productBrandTv.text.toString()} \n" +
                "Price: ${view.productPriceTv.text.toString()} \n" +
                "Description: ${view.productInfoTv.text.toString()} \n"
                )
        val mintent = Intent(Intent.ACTION_SEND)
        mintent.putExtra(Intent.EXTRA_EMAIL, recipient)
        mintent.putExtra(Intent.EXTRA_SUBJECT, subject)
        mintent.putExtra(Intent.EXTRA_TEXT, message)
        mintent.setType("text/plain")

        try{
            parent.context.startActivity(Intent.createChooser(mintent, "Send Email using:"))
        }        catch (e: Exception){
            Toast.makeText(parent.context, e.message, Toast.LENGTH_LONG).show()
        }

    }
}
class ProductViewHolder(view: View): RecyclerView.ViewHolder(view)