package hr.dominikricko.rma_lv2.observable

abstract class Observable<returnDataType> {

    private val observers = mutableListOf<Observer<returnDataType>>()

    fun addObserver(observer: Observer<returnDataType>) = observers.add(observer)
    fun removeObserver(observer: Observer<returnDataType>) = observers.remove(observer)
    fun notifyObservers(data : returnDataType) = observers.forEach { it.notify(data) }

}