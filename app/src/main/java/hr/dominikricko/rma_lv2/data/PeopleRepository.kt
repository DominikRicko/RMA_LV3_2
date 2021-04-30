package hr.dominikricko.rma_lv2.data

import hr.dominikricko.rma_lv2.model.InspiringPerson
import hr.dominikricko.rma_lv2.observable.Observable

object PeopleRepository : Observable<Int>() {

    private val peopleDao = PeopleDatabaseBuilder.getInstance().peopleDao()

    fun addNewPerson(person: InspiringPerson) {
        peopleDao.insert(person)
    }

    fun editPerson(newPerson: InspiringPerson, oldPerson: InspiringPerson){

        removePerson(oldPerson)
        addNewPerson(newPerson)
    }

    fun removePerson(person: InspiringPerson) {
        val index = peopleDao.getPeople().indexOf(person)

        peopleDao.delete(person)

        notifyObservers(index);
    }

    fun getPeople() : List<InspiringPerson>{
        return peopleDao.getPeople()
    }
}