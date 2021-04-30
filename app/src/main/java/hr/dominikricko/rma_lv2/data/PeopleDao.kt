package hr.dominikricko.rma_lv2.data

import androidx.room.*
import hr.dominikricko.rma_lv2.model.InspiringPerson

@Dao
interface PeopleDao {

    @Query("SELECT * FROM people")
    fun getPeople() : List<InspiringPerson>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(person : InspiringPerson)

    @Delete
    fun delete(person: InspiringPerson)

    @Query("SELECT * FROM people WHERE id=:id")
    fun getPerson(id: Long): InspiringPerson
}