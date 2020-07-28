package ir.siriusapps.moneysave.domain.useCase.bankaccount

import ir.siriusapps.moneysave.domain.repository.BankAccountRepository
import ir.siriusapps.moneysave.domain.entity.BankAccount
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AddBankAccount @Inject constructor(private val accountRepository: BankAccountRepository) {

    suspend fun execute(bankAccount: BankAccount) = withContext(Dispatchers.IO) {
        return@withContext accountRepository.add(bankAccount)
    }

    suspend fun execute(bankAccounts: List<BankAccount>) = withContext(Dispatchers.IO) {
        return@withContext accountRepository.add(bankAccounts)
    }

    suspend fun execute(accountName: String, accountNumber: String, cardNumber: String)= withContext(Dispatchers.IO){
        return@withContext accountRepository.add(accountName,accountNumber,cardNumber)
    }
}