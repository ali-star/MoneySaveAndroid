package ir.siriusapps.moneysave.internal.di.module

import android.content.Context
import androidx.room.Room

import dagger.Module
import dagger.Provides
import ir.siriusapps.moneysave.domain.scope.ApplicationScope
import ir.siriusapps.moneysave.data.repository.source.local.AppDatabase
import ir.siriusapps.moneysave.data.repository.source.local.MoneySaveDao

@Module
class AppDataBaseModule {

    @Provides
    @ApplicationScope
    fun provideAppDatabase(context: Context): MoneySaveDao {
        val database = Room.databaseBuilder(context, AppDatabase::class.java, "money_save.db")
            .fallbackToDestructiveMigration()
            .build()
        return database.moneySaveDao()
    }

}