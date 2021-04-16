package hr.dominikricko.rma_lv2.adapters

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import hr.dominikricko.rma_lv2.databinding.ItemQuoteBinding
import hr.dominikricko.rma_lv2.listeners.OnQuoteViewClickListener

class QuoteViewHolder(private val quoteView: View) : RecyclerView.ViewHolder(quoteView) {

    fun bind(onClickListener: OnQuoteViewClickListener, quote: String) {
        val binding = ItemQuoteBinding.bind(quoteView)

        binding.btnRemove.setOnClickListener { onClickListener.onQuoteClick(quote) }
        binding.tvQuote.text = quote

    }
}