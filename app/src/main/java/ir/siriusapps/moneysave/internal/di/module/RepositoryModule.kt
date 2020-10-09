package ir.siriusapps.moneysave.internal.di.module

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.components.ApplicationComponent
import ir.siriusapps.moneysave.domain.repository.BankAccountRepository
import ir.siriusapps.moneysave.domain.repository.TransactionRepository
import ir.siriusapps.moneysave.data.repository.BankAccountRepositoryImp
import ir.siriusapps.moneysave.data.repository.BankRepositoryImp
import ir.siriusapps.moneysave.data.repository.CardRepositoryImp
import ir.siriusapps.moneysave.data.repository.TransactionRepositoryImp
import ir.siriusapps.moneysave.domain.repository.BankRepository
import ir.siriusapps.moneysave.domain.repository.CardRepository
import javax.inject.Singleton


@InstallIn(ApplicationComponent::class)
@Module
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun provideTransactionsRepository(transactionRepositoryImp: TransactionRepositoryImp): TransactionRepository

    @Binds
    @Singleton
    abstract fun provideBankAccountRepository(bankAccountRepositoryImp: BankAccountRepositoryImp): BankAccountRepository

    @Binds
    @Singleton
    abstract fun provideBankRepository(bankRepositoryImp: BankRepositoryImp): BankRepository

    @Binds
    @Singleton
    abstract fun provideCardRepository(cardRepositoryImp: CardRepositoryImp): CardRepository

}