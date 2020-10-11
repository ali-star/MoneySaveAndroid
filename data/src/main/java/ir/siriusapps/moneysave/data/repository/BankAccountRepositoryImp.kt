package ir.siriusapps.moneysave.data.repository

import ir.siriusapps.moneysave.data.repository.source.local.Dao
import ir.siriusapps.moneysave.domain.repository.BankAccountRepository
import ir.siriusapps.moneysave.domain.scope.ApplicationScope
import ir.siriusapps.moneysave.domain.entity.BankAccount
import ir.siriusapps.moneysave.data.entity.BankAccountEntityMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

@ApplicationScope
class BankAccountRepositoryImp @Inject constructor(
    private val dao: Dao,
    private val bankAccountEntityMapper: BankAccountEntityMapper
) : BankAccountRepository {

    private val ioDispatcher = Dispatchers.IO

    override suspend fun add(bankAccount: BankAccount) :Long= withContext(ioDispatcher) {
      return@withContext  dao.insertBankAccount(bankAccountEntityMapper.mapToData(bankAccount))
    }

    override suspend fun add(bankAccounts: List<BankAccount>) = withContext(ioDispatcher) {
        val bankEntityAccounts = bankAccounts.map {
            bankAccountEntityMapper.mapToData(it)
        }
        dao.insertBankAccounts(bankEntityAccounts)
    }

    override suspend fun remove(bankAccount: BankAccount) = withContext(ioDispatcher) {
        dao.deleteBankAccount(bankAccountEntityMapper.mapToData(bankAccount))
    }

    override suspend fun remove(bankAccounts: List<BankAccount>) = withContext(ioDispatcher) {
        val bankAccountEntity = bankAccounts.map {
            bankAccountEntityMapper.mapToData(it)
        }
        dao.insertBankAccounts(bankAccountEntity)
    }

    override suspend fun read(): List<BankAccount> = withContext(ioDispatcher) {
        return@withContext dao.getBankAccounts().map {
            bankAccountEntityMapper.mapToDomain(it)
        }
    }

    override suspend fun searchByAccountNumber(accountNumber: String): BankAccount? =
        withContext(ioDispatcher) {
            return@withContext dao.searchByAccountNumber(accountNumber)?.let {
                bankAccountEntityMapper.mapToDomain(it)
            }
        }

}