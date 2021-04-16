package hr.dominikricko.rma_lv2.data

import hr.dominikricko.rma_lv2.model.InspiringPerson

object PeopleRepository {
    private val editablePeople: MutableList<InspiringPerson> = mutableListOf()

    val people : List<InspiringPerson>
    get() = editablePeople

    fun addNewPerson(person: InspiringPerson) {
        editablePeople.add(person)
    }

    fun removePerson(person: InspiringPerson) {
        editablePeople.remove(person)
    }
}