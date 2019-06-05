package ir.siriusapps.moneysave.di.component

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import ir.siriusapps.moneysave.di.scope.ApplicationScope
import ir.siriusapps.moneysave.App
import ir.siriusapps.moneysave.di.module.ActivityBindingModule
import ir.siriusapps.moneysave.di.module.AppDatabaseModule
import ir.siriusapps.moneysave.di.module.GsonModule

@ApplicationScope
@Component(modules = [
    AndroidInjectionModule::class, ActivityBindingModule::class,
    GsonModule::class, AppDatabaseModule::class
])
interface AppComponent: AndroidInjector<App> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(app: App): Builder
        fun build(): AppComponent
    }

}