package hr.dominikricko.rma_lv2.data

import androidx.room.*
import hr.dominikricko.rma_lv2.model.InspiringPerson
import hr.dominikricko.rma_lv2.model.Quote

@Dao
interface QuoteDao {
    @Query("SELECT * FROM quotes where referenceId = :personId")
    fun getQuotes(personId : Long) : List<Quote>

    @Delete
    fun delete(quote: Quote)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(quote: Quote)

    @Query("DELETE FROM quotes WHERE id = :quoteId")
    fun deleteWithId( quoteId: Long)

}