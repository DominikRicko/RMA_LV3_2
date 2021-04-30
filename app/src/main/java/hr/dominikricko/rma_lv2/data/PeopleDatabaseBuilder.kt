package hr.dominikricko.rma_lv2.data

import androidx.room.Room
import hr.dominikricko.rma_lv2.context.ApplicationContext

object PeopleDatabaseBuilder {

    private var instance: PeopleDatabase? = null

    fun getInstance(): PeopleDatabase {
        synchronized(PeopleDatabase::class) {
            if (instance == null) {
                instance = buildDatabase()
            }
        }
        return instance!!
    }

    private fun buildDatabase(): PeopleDatabase {
        return Room.databaseBuilder(
            ApplicationContext.context, PeopleDatabase::class.java, PeopleDatabase.NAME
        )
            .allowMainThreadQueries()
            .build()
    }
}