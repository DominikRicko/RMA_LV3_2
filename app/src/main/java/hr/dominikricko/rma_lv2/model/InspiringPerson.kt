package hr.dominikricko.rma_lv2.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "people")
data class InspiringPerson(
    @PrimaryKey(autoGenerate = true) private val id: Long,
    @ColumnInfo var name: String,
    @ColumnInfo var imageUrl: String?,
    @ColumnInfo var dateOfBirth: String,
    @ColumnInfo var dateOfDeath: String?,
    @ColumnInfo var description: String
) : Serializable {

}
