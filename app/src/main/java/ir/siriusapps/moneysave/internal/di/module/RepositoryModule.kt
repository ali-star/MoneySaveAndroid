package ir.siriusapps.moneysave.internal.di.module

import dagger.Module
import dagger.Provides
import ir.siriusapps.moneysave.domain.datasource.BankAccountRepository
import ir.siriusapps.moneysave.domain.datasource.TransactionRepository
import ir.siriusapps.moneysave.domain.scope.ApplicationScope
import ir.siriusapps.moneysave.data.repository.BankAccountRepositoryImp
import ir.siriusapps.moneysave.data.repository.TransactionRepositoryImp

@Module
class RepositoryModule {

    @Provides
    @ApplicationScope
    fun provideTransactionsRepository(transactionRepositoryImp: TransactionRepositoryImp): TransactionRepository = transactionRepositoryImp

    @Provides
    @ApplicationScope
    fun provideBankAccountRepository(bankAccountRepositoryImp: BankAccountRepositoryImp): BankAccountRepository = bankAccountRepositoryImp

}