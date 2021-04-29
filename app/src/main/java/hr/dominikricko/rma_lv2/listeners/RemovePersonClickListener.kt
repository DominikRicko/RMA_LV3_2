package hr.dominikricko.rma_lv2.listeners

import hr.dominikricko.rma_lv2.data.PeopleRepository
import hr.dominikricko.rma_lv2.model.InspiringPerson

object RemovePersonClickListener : OnPersonRemoveClickListener {
    override fun removePerson(person: InspiringPerson) {
        PeopleRepository.removePerson(person);
    }
}