package hr.dominikricko.rma_lv2.data

import hr.dominikricko.rma_lv2.observable.Observable

object TemporaryQuoteRepository : Observable<Int>() {

    private val editableQuotes : MutableList<String> = mutableListOf()

    val quotes : List<String>
    get() = editableQuotes

    fun addQuote(quote: String){
        editableQuotes.add(quote)
    }

    fun removeQuote(quote: String){
        val index = editableQuotes.indexOf(quote)
        if(index == -1) return
        editableQuotes.remove(quote)
        notifyObservers(index)
    }

    fun clear(){
        editableQuotes.clear()
    }

}