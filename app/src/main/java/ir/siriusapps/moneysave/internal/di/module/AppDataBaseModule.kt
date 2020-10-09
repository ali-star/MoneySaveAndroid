package ir.siriusapps.moneysave.internal.di.module

import android.content.Context
import androidx.room.Room

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import ir.siriusapps.moneysave.data.repository.source.local.AppDatabase
import ir.siriusapps.moneysave.data.repository.source.local.MoneySaveDao
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class AppDataBaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): MoneySaveDao {
        val database = Room.databaseBuilder(context, AppDatabase::class.java, "money_save.db")
            .fallbackToDestructiveMigration()
            .build()
        return database.moneySaveDao()
    }

}