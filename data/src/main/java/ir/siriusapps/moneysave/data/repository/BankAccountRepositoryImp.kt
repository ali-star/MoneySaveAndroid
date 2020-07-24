package ir.siriusapps.moneysave.data.repository

import ir.siriusapps.moneysave.domain.datasource.BankAccountRepository
import ir.siriusapps.moneysave.domain.scope.ApplicationScope
import ir.siriusapps.moneysave.data.repository.source.local.MoneySaveDao
import ir.siriusapps.moneysave.domain.entity.BankAccount
import ir.siriusapps.moneysave.domain.entity.BankAccountEntityMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

@ApplicationScope
class BankAccountRepositoryImp @Inject constructor(
    private val moneySaveDao: MoneySaveDao,
    private val bankAccountEntityMapper: BankAccountEntityMapper
) : BankAccountRepository {

    private val ioDispatcher = Dispatchers.IO

    override suspend fun add(bankAccount: BankAccount) = withContext(ioDispatcher) {
        moneySaveDao.insertBankAccount(bankAccountEntityMapper.mapToData(bankAccount))
    }

    override suspend fun add(bankAccounts: List<BankAccount>) = withContext(ioDispatcher) {
        val bankEntityAccounts = bankAccounts.map {
            bankAccountEntityMapper.mapToData(it)
        }
        moneySaveDao.insertBankAccounts(bankEntityAccounts)
    }

    override suspend fun remove(bankAccount: BankAccount) = withContext(ioDispatcher) {
        moneySaveDao.deleteBankAccount(bankAccountEntityMapper.mapToData(bankAccount))
    }

    override suspend fun remove(bankAccounts: List<BankAccount>) = withContext(ioDispatcher) {
        val bankAccountEntity = bankAccounts.map {
            bankAccountEntityMapper.mapToData(it)
        }
        moneySaveDao.insertBankAccounts(bankAccountEntity)
    }

    override suspend fun read(): List<BankAccount> = withContext(ioDispatcher) {
        return@withContext moneySaveDao.getBankAccounts().map {
            bankAccountEntityMapper.mapToDomain(it)
        }
    }

    override suspend fun searchByAccountNumber(accountNumber: String): BankAccount? = withContext(ioDispatcher) {
       return@withContext moneySaveDao.searchByAccountNumber(accountNumber)?.let {
            bankAccountEntityMapper.mapToDomain(it)
        }
    }

}