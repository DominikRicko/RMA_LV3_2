package hr.dominikricko.rma_lv2.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "quotes",
    foreignKeys = [ForeignKey(
        entity = InspiringPerson::class,
        parentColumns = ["id"],
        childColumns = ["referenceId"]
    )]
)
class Quote(
    @PrimaryKey(autoGenerate = true) val id: Long,
    @ColumnInfo val referenceId: Long,
    @ColumnInfo var quote: String
){
    companion object{
        operator fun invoke(person: InspiringPerson, quote: String) : Quote{
            return Quote(0, person.id, quote)
        }
    }
}