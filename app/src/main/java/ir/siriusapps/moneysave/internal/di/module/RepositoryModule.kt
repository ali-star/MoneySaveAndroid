package ir.siriusapps.moneysave.internal.di.module

import dagger.Module
import dagger.Provides
import ir.siriusapps.domain.datasource.BankAccountDataSource
import ir.siriusapps.domain.datasource.TransactionDataSource
import ir.siriusapps.domain.entity.BankAccount
import ir.siriusapps.moneysave.data.repository.BankAccountRepository
import ir.siriusapps.moneysave.data.repository.TransactionRepository
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideTransactionsRepository(transactionRepository: TransactionRepository): TransactionDataSource = transactionRepository

    @Provides
    @Singleton
    fun provideBankAccountRepository(bankAccountRepository: BankAccountRepository): BankAccountDataSource = bankAccountRepository

}