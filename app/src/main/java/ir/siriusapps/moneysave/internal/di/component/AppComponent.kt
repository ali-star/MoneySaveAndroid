package ir.siriusapps.moneysave.internal.di.component

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import ir.siriusapps.moneysave.App
import ir.siriusapps.moneysave.internal.di.module.AppDataBaseModule
import ir.siriusapps.moneysave.internal.di.module.ApplicationModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidInjectionModule::class, ApplicationModule::class,
    AppDataBaseModule::class
])
interface AppComponent :AndroidInjector<App>{

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance app: App): AppComponent
    }
}