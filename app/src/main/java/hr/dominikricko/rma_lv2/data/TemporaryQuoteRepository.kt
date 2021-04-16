package hr.dominikricko.rma_lv2.data

object TemporaryQuoteRepository {

    private val editableQuotes : MutableList<String> = mutableListOf()

    val quotes : List<String>
    get() = editableQuotes

    fun addQuote(quote: String){
        editableQuotes.add(quote)
    }

    fun removeQuote(quote: String){
        editableQuotes.remove(quote)
    }

    fun clear(){
        editableQuotes.clear()
    }

}