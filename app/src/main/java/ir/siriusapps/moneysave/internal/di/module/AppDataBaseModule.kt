package ir.siriusapps.moneysave.internal.di.module

import android.content.Context
import androidx.room.Room

import dagger.Module
import dagger.Provides
import ir.irsiusapps.data.repository.source.local.*
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
    fun provideBankDatabase(appDatabase: AppDatabase): MoneySaveDao = appDatabase.moneySaveDao()

}