package hr.dominikricko.rma_lv2.listeners

import android.widget.Toast
import hr.dominikricko.rma_lv2.context.ApplicationContext
import hr.dominikricko.rma_lv2.data.InspiringPerson

object ShowRandomQuoteOnClick : OnPersonViewClickListener {
    override fun OnPersonClick(person: InspiringPerson) {
        Toast.makeText(
            ApplicationContext.GetContext(),
            person.quotes.elementAt((person.quotes.indices).random()), Toast.LENGTH_SHORT)
            .show()
    }
}