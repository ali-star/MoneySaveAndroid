package ir.siriusapps.moneysave.internal.di.module

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import ir.siriusapps.moneysave.domain.scope.ApplicationScope
import ir.siriusapps.moneysave.data.repository.source.local.Dao
import ir.siriusapps.moneysave.data.repository.source.local.db.AppDatabase
import javax.inject.Singleton

@Module
class AppDataBaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(context: Context): Dao {
        val database = Room.databaseBuilder(context, AppDatabase::class.java, "money_save.db")
            .fallbackToDestructiveMigration()
            .build()
        return database.moneySaveDao()
    }

}