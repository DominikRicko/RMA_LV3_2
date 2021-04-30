package hr.dominikricko.rma_lv2.data

import androidx.room.Database
import androidx.room.RoomDatabase
import hr.dominikricko.rma_lv2.model.InspiringPerson
import hr.dominikricko.rma_lv2.model.Quote

@Database(version = 1, entities = [InspiringPerson::class, Quote::class])
abstract class PeopleDatabase : RoomDatabase(){

    abstract fun peopleDao() : PeopleDao

    companion object{
        const val NAME = "peopleDb"
    }

}

