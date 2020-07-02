package ir.siriusapps.moneysave.internal.di.module

import android.content.Context
import androidx.room.Room

import dagger.Module
import dagger.Provides
import ir.siriusapps.moneysave.data.repository.source.local.AppDatabase
import ir.siriusapps.moneysave.data.repository.source.local.MoneySaveDao
import javax.inject.Singleton

@Module
class AppDataBaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "money_save.db")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideMoneySaveDao(appDatabase: AppDatabase): MoneySaveDao = appDatabase.moneySaveDao()

}