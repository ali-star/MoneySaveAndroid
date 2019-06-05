package ir.siriusapps.moneysave.di.module

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import ir.siriusapps.moneysave.data.database.AppDatabase

@Module class AppDatabaseModule {
    @Provides fun database(context: Context) =
        Room.databaseBuilder(context, AppDatabase::class.java, "AppDatabase")
            .fallbackToDestructiveMigration()
            .build()
}