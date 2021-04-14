package hr.dominikricko.rma_lv2.context

import android.app.Application

class ApplicationContext: Application() {

    companion object{
        private val instance = ApplicationContext()

        fun invoke() : ApplicationContext{
            return instance
        }

        fun getContext() = instance.applicationContext
    }

}