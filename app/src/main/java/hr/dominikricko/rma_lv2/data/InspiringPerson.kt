package hr.dominikricko.rma_lv2.data

import android.graphics.Bitmap
import java.util.*
import kotlin.collections.ArrayList

data class InspiringPerson(var name : String,
                           var image : Bitmap,
                           var dateOfBirth : Date,
                           var dateOfDeath : Date?,
                           var description : String){

    private val _quotes = ArrayList<String>()

    val quotes: Collection<String>
        get() = _quotes

    fun addQuote(quote : String){
        _quotes.add(quote)
    }

    fun removeQuote(quote : String){
        _quotes.remove(quote)
    }

}
