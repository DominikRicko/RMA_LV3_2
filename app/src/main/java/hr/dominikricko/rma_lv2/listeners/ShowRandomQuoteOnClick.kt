package hr.dominikricko.rma_lv2.listeners

import android.widget.Toast
import hr.dominikricko.rma_lv2.context.ApplicationContext
import hr.dominikricko.rma_lv2.model.InspiringPerson

object ShowRandomQuoteOnClick : OnPersonViewClickListener {
    override fun onPersonClick(person: InspiringPerson) {

        val quotes = person.getQuotes()


        Toast.makeText(
            ApplicationContext.context,
            quotes.elementAt((quotes.indices).random()), Toast.LENGTH_SHORT
        )
            .show()
    }
}