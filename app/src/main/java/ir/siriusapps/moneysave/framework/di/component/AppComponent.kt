package ir.siriusapps.moneysave.framework.di.component

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.android.AndroidInjection
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import ir.siriusapps.moneysave.App
import ir.siriusapps.moneysave.framework.db.mainDb.roomDao.RoomDaoBank
import ir.siriusapps.moneysave.framework.di.module.AppDataBaseModule
import ir.siriusapps.moneysave.framework.di.module.ApplicationModule
import ir.siriusapps.moneysave.framework.di.module.BindingModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidInjectionModule::class, ApplicationModule::class,
    AppDataBaseModule::class, BindingModule::class
])
interface AppComponent :AndroidInjector<App>{

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance app: App): AppComponent
    }
}