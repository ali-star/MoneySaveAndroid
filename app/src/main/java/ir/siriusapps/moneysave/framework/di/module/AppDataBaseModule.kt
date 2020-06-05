package ir.siriusapps.moneysave.framework.di.module

import android.accessibilityservice.GestureDescription
import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

import dagger.Module
import dagger.Provides
import ir.siriusapps.moneysave.framework.db.mainDb.AppDatabase
import ir.siriusapps.moneysave.framework.db.mainDb.roomDao.RoomDaoBank
import ir.siriusapps.moneysave.framework.db.mainDb.roomDao.RoomDaoBankAccount
import ir.siriusapps.moneysave.framework.db.mainDb.roomDao.RoomDaoCard
import ir.siriusapps.moneysave.framework.db.roomDataSource.RoomBank
import javax.inject.Singleton

@Module
class AppDataBaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(context: Context): AppDatabase {
        val database = Room.databaseBuilder(context, AppDatabase::class.java, "money_save.db")
            .fallbackToDestructiveMigration()
            .build()

        return database
    }

    @Provides
    @Singleton
    fun provideBankDatabase(appDatabase: AppDatabase): RoomDaoBank = appDatabase.roomDaoBank()

    @Provides
    @Singleton
    fun provideBankAccountDatabase(appDatabase: AppDatabase): RoomDaoBankAccount =
        appDatabase.roomDaoBankAccount()

    @Provides
    @Singleton
    fun provideCardDataBase(appDatabase: AppDatabase): RoomDaoCard = appDatabase.roomDaoCard()
}