package hr.dominikricko.rma_lv2.observable

interface Observer<returnDataType> {

    fun notify(data : returnDataType)

}