package ir.siriusapps.moneysave.internal.di.component

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import ir.siriusapps.moneysave.domain.scope.ApplicationScope
import ir.siriusapps.moneysave.App
import ir.siriusapps.moneysave.internal.di.module.*
import javax.inject.Singleton

@ApplicationScope
@Component(modules = [
    AndroidInjectionModule::class, ApplicationModule::class,
    AppDataBaseModule::class, BindingModule::class, ViewModelModule::class,
    RepositoryModule::class
])
interface AppComponent :AndroidInjector<App>{

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance app: App): AppComponent
    }

}