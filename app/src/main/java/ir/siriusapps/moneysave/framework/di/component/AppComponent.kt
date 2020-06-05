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
import javax.inject.Singleton

@Component(modules = [ApplicationModule::class, AppDataBaseModule::class])
@Singleton
interface AppComponent :AndroidInjector<App>{

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance app: App): AppComponent
    }
}