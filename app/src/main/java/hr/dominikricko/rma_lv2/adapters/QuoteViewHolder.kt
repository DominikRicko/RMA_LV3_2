package hr.dominikricko.rma_lv2.adapters

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import hr.dominikricko.rma_lv2.databinding.ItemQuoteBinding

class QuoteViewHolder(private val quoteView : View) : RecyclerView.ViewHolder(quoteView){

    fun bind(quote : String){
        val binding = ItemQuoteBinding.bind(quoteView)

        binding.tvQuote.text = quote

    }
}