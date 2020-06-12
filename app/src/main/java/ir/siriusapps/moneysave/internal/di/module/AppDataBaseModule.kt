package ir.siriusapps.moneysave.internal.di.module

import android.content.Context
import androidx.room.Room

import dagger.Module
import dagger.Provides
import ir.siriusapps.moneysave.internal.db.mainDb.AppDatabase
import ir.siriusapps.moneysave.internal.db.mainDb.roomDao.RoomDaoBank
import ir.siriusapps.moneysave.internal.db.mainDb.roomDao.RoomDaoBankAccount
import ir.siriusapps.moneysave.internal.db.mainDb.roomDao.RoomDaoCard
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
    fun provideBankDatabase(appDatabase: AppDatabase): RoomDaoBank = appDatabase.roomDaoBank()

    @Provides
    @Singleton
    fun provideBankAccountDatabase(appDatabase: AppDatabase): RoomDaoBankAccount =
        appDatabase.roomDaoBankAccount()

    @Provides
    @Singleton
    fun provideCardDataBase(appDatabase: AppDatabase): RoomDaoCard = appDatabase.roomDaoCard()

}