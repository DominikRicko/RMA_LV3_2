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
    @PrimaryKey(autoGenerate = true) private val id: Long,
    @ColumnInfo private val referenceId: Long,
    @ColumnInfo var quote: String
)