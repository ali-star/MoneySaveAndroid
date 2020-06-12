package ir.irsiusapps.domain.iteractors

import com.example.core.data.repository.BankAccountRepo
import com.example.core.domain.entity.BankAccount
import ir.irsiusapps.domain.entity.BankAccount

class RemoveBankAccount(private val bankAccountRpo: BankAccountRepo) {

    suspend fun removeBankAccount(bankAccount: BankAccount) =
        bankAccountRpo.removeBankAccount(bankAccount)

    suspend fun removeBankAccount(bankAccounts: List<BankAccount>) =
        bankAccountRpo.removeBankAccount(bankAccounts)
}