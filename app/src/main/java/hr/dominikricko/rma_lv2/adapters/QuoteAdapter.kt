package hr.dominikricko.rma_lv2.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import hr.dominikricko.rma_lv2.R
import hr.dominikricko.rma_lv2.data.TemporaryQuoteRepository
import hr.dominikricko.rma_lv2.observable.Observable
import hr.dominikricko.rma_lv2.observable.Observer

class QuoteAdapter : RecyclerView.Adapter<QuoteViewHolder>(), Observer<Int> {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuoteViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_quote, parent, false)

        return QuoteViewHolder(view)
    }

    override fun onBindViewHolder(holder: QuoteViewHolder, position: Int) {
        holder.bind(TemporaryQuoteRepository.quotes[position])
    }

    override fun getItemCount(): Int {
        return TemporaryQuoteRepository.quotes.size
    }

    override fun notify(data: Int) {
        notifyItemRemoved(data)
    }

}