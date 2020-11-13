package ir.siriusapps.moneysave.domain.useCase

import javax.inject.Singleton

@Singleton
class OnUserUnauthorizedListener {

    private val listeners = mutableListOf<(() -> Unit)>()

    fun register(listener: () -> Unit) {
        if (listener !in listeners)
            listeners.add(listener)
    }

    fun unregister(listener: () -> Unit) {
        if (listener !in listeners)
            listeners.remove(listener)
    }

    fun emmit() {
        listeners.forEach { it.invoke() }
    }

}