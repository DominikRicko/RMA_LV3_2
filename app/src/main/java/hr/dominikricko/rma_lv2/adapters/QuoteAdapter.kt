package hr.dominikricko.rma_lv2.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import hr.dominikricko.rma_lv2.R
import hr.dominikricko.rma_lv2.listeners.OnQuoteViewClickListener

class QuoteAdapter : RecyclerView.Adapter<QuoteViewHolder>(), OnQuoteViewClickListener {

    val quotes : MutableList<String> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuoteViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_quote,parent, false)

        return QuoteViewHolder(view)
    }

    override fun onBindViewHolder(holder: QuoteViewHolder, position: Int) {
        holder.bind(this,quotes[position])
    }

    override fun getItemCount(): Int {
        return quotes.size
    }

    override fun onQuoteClick(quote: String) {
        quotes.remove(quote)
    }
}