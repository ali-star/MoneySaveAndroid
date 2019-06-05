package ir.siriusapps.moneysave.di.component

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import ir.siriusapps.moneysave.di.module.GsonModule
import ir.siriusapps.moneysave.di.scope.ApplicationScope
import ir.siriusapps.moneysave.App
import ir.siriusapps.moneysave.di.module.ActivityBindingModule

@ApplicationScope
@Component(modules = [AndroidInjectionModule::class, GsonModule::class, ActivityBindingModule::class])
interface AppComponent: AndroidInjector<App> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(app: App): Builder
        fun build(): AppComponent
    }

}