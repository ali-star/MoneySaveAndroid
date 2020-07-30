package ir.siriusapps.moneysave.internal.di.module

import dagger.Module
import dagger.Provides
import ir.siriusapps.moneysave.domain.repository.BankAccountRepository
import ir.siriusapps.moneysave.domain.repository.TransactionRepository
import ir.siriusapps.moneysave.domain.scope.ApplicationScope
import ir.siriusapps.moneysave.data.repository.BankAccountRepositoryImp
import ir.siriusapps.moneysave.data.repository.BankRepositoryImp
import ir.siriusapps.moneysave.data.repository.TransactionRepositoryImp
import ir.siriusapps.moneysave.domain.repository.BankRepository

@Module
class RepositoryModule {

    @Provides
    @ApplicationScope
    fun provideTransactionsRepository(transactionRepositoryImp: TransactionRepositoryImp): TransactionRepository =
        transactionRepositoryImp

    @Provides
    @ApplicationScope
    fun provideBankAccountRepository(bankAccountRepositoryImp: BankAccountRepositoryImp): BankAccountRepository =
        bankAccountRepositoryImp

    @Provides
    @ApplicationScope
    fun provideBankRepository(bankRepositoryImp: BankRepositoryImp): BankRepository =
        bankRepositoryImp

}