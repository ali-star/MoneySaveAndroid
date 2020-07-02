package ir.siriusapps.moneysave.data.repository

import ir.siriusapps.domain.datasource.BankAccountDataSource
import ir.siriusapps.domain.entity.BankAccount
import ir.siriusapps.moneysave.data.repository.source.local.MoneySaveDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BankAccountRepository @Inject constructor(
    private val moneySaveDao: MoneySaveDao
) : BankAccountDataSource {

    override suspend fun add(bankAccount: BankAccount) = withContext(Dispatchers.IO) {
        moneySaveDao.insertBankAccount(bankAccount)
    }

    override suspend fun add(bankAccounts: List<BankAccount>) = withContext(Dispatchers.IO) {
        moneySaveDao.insertBankAccounts(bankAccounts)
    }

    override suspend fun remove(bankAccount: BankAccount) = withContext((Dispatchers.IO)) {
        moneySaveDao.deleteBankAccount(bankAccount)
    }

    override suspend fun remove(bankAccounts: List<BankAccount>) = withContext((Dispatchers.IO)) {
        moneySaveDao.deleteBankAccounts(bankAccounts)
    }

    override suspend fun read(): List<BankAccount> = withContext(Dispatchers.IO) {
        moneySaveDao.getBankAccounts()
    }

    override suspend fun searchByAccountNumber(accountNumber: String) = withContext((Dispatchers.IO)){
        return@withContext moneySaveDao.searchByAccountNumber(accountNumber)
    }


}