package hr.dominikricko.rma_lv2.data

import hr.dominikricko.rma_lv2.model.InspiringPerson
import hr.dominikricko.rma_lv2.observable.Observable

object PeopleRepository : Observable<Int>() {
    private val editablePeople: MutableList<InspiringPerson> = mutableListOf()

    val people : List<InspiringPerson>
    get() = editablePeople

    fun addNewPerson(person: InspiringPerson) {
        editablePeople.add(person)
    }

    fun editPerson(newPerson: InspiringPerson, oldPerson: InspiringPerson){
        removePerson(oldPerson)
        addNewPerson(newPerson)
    }

    fun removePerson(person: InspiringPerson) {
        val index = editablePeople.indexOf(person)

        editablePeople.removeAt(index)
        notifyObservers(index);
    }
}