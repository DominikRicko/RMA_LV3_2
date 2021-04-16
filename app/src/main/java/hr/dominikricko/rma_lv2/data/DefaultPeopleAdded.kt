package hr.dominikricko.rma_lv2.data

import hr.dominikricko.rma_lv2.R
import hr.dominikricko.rma_lv2.context.ApplicationContext
import hr.dominikricko.rma_lv2.model.InspiringPerson

object DefaultPeopleAdded {
    fun init() {
        val person = InspiringPerson(
                "Grace Murray Hopper",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/a/ad/Commodore_Grace_M._Hopper%2C_USN_%28covered%29.jpg/800px-Commodore_Grace_M._Hopper%2C_USN_%28covered%29.jpg",
                "1962/12/09",
                "1992/01/01",
                ApplicationContext.context.getString(R.string.grace_hopper_description)
        )
        PeopleRepository.addNewPerson(person)

        PeopleRepository.addNewPerson(InspiringPerson(
                "André-Marie Ampère",
                "https://upload.wikimedia.org/wikipedia/commons/c/c0/Ampere_Andre_1825.jpg",
                "1775/01/20",
                "1836/06/10",
                ApplicationContext.context.getString(R.string.andre_ampere_description)
        ))

        PeopleRepository.addNewPerson(InspiringPerson(
                "Pythagoras of Samos",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/e/e0/Pythagoras_in_the_Roman_Forum%2C_Colosseum.jpg/621px-Pythagoras_in_the_Roman_Forum%2C_Colosseum.jpg",
                "570 BC",
                "495 BC",
                ApplicationContext.context.getString(R.string.pythagoras_description)
        ))
    }
}