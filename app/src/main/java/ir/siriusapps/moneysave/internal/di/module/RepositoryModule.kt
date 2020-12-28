package ir.siriusapps.moneysave.internal.di.module

import dagger.Module
import dagger.Provides
import ir.siriusapps.moneysave.data.repository.*
import ir.siriusapps.moneysave.domain.repository.*
import ir.siriusapps.moneysave.domain.scope.ApplicationScope
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideTransactionsRepository(transactionRepositoryImp: TransactionRepositoryImp): TransactionRepository = transactionRepositoryImp

    @Provides
    @Singleton
    fun provideBankAccountRepository(bankAccountRepositoryImp: BankAccountRepositoryImp): BankAccountRepository = bankAccountRepositoryImp

    @Provides
    @Singleton
    fun provideBankRepository(bankRepositoryImp: BankRepositoryImp): BankRepository = bankRepositoryImp

    @Provides
    @Singleton
    fun provideCardRepository(cardRepositoryImp: CardRepositoryImp): CardRepository = cardRepositoryImp

    @Provides
    @Singleton
    fun provideUserRepository(userRepositoryImp: UserRepositoryImp): UserRepository = userRepositoryImp

    @Provides
    @Singleton
    fun provideInternalRepository(internalRepositoryImp: InternalRepositoryImp): InternalRepository = internalRepositoryImp

}