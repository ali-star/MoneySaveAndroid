package ir.siriusapps.moneysave.domain.useCase.bankaccount

import ir.siriusapps.moneysave.domain.repository.BankAccountRepository
import ir.siriusapps.moneysave.domain.entity.BankAccount
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ReadBankAccount @Inject constructor(private val bankAccountRepository: BankAccountRepository) {

    suspend fun readBankAccount():List<BankAccount> = withContext(Dispatchers.IO) {
        return@withContext bankAccountRepository.read()
    }
}