package ir.siriusapps.moneysave.internal.di.module

import dagger.Module
import dagger.Provides
import ir.siriusapps.moneysave.domain.datasource.BankAccountDataSource
import ir.siriusapps.moneysave.domain.datasource.TransactionDataSource
import ir.siriusapps.moneysave.domain.entity.BankAccount
import ir.siriusapps.moneysave.domain.scope.ApplicationScope
import ir.siriusapps.moneysave.data.repository.BankAccountRepository
import ir.siriusapps.moneysave.data.repository.TransactionRepository
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @ApplicationScope
    fun provideTransactionsRepository(transactionRepository: TransactionRepository): TransactionDataSource = transactionRepository

    @Provides
    @ApplicationScope
    fun provideBankAccountRepository(bankAccountRepository: BankAccountRepository): BankAccountDataSource = bankAccountRepository

}