package hr.dominikricko.rma_lv2.listeners

import android.widget.Toast
import hr.dominikricko.rma_lv2.context.ApplicationContext
import hr.dominikricko.rma_lv2.model.InspiringPerson

object ShowRandomQuoteOnClick : OnPersonViewClickListener {
    override fun onPersonClick(person: InspiringPerson) {
        Toast.makeText(
            ApplicationContext.context,
            person.quotes.elementAt((person.quotes.indices).random()), Toast.LENGTH_SHORT
        )
            .show()
    }
}