package hr.dominikricko.rma_lv2.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import hr.dominikricko.rma_lv2.data.PeopleDatabaseBuilder
import java.io.Serializable

@Entity(tableName = "people")
data class InspiringPerson(
    @PrimaryKey(autoGenerate = true) val id: Long,
    @ColumnInfo var name: String,
    @ColumnInfo var imageUrl: String?,
    @ColumnInfo var dateOfBirth: String,
    @ColumnInfo var dateOfDeath: String?,
    @ColumnInfo var description: String
) : Serializable {

    companion object{
        operator fun invoke(name: String,
                            imageUrl: String?,
                            dateOfBirth: String,
                            dateOfDeath: String?,
                            description: String) : InspiringPerson{
            return InspiringPerson(0,name,imageUrl,dateOfBirth,dateOfDeath,description)
        }
    }


    fun addQuote(quote: String) {

        val newQuote = Quote(this, quote)
        val quoteDao = PeopleDatabaseBuilder.getInstance().quoteDao()

        quoteDao.insert(newQuote)
    }

    fun getQuotes() : List<String>{
        return PeopleDatabaseBuilder.getInstance().quoteDao().getQuotes(this.id).map { it.quote }
    }

}
