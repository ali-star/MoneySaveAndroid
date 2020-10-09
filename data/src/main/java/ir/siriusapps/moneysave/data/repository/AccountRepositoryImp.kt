package ir.siriusapps.moneysave.data.repository

import ir.siriusapps.moneysave.data.entity.AccountEntityMapper
import ir.siriusapps.moneysave.data.repository.source.romote.NetworkService
import ir.siriusapps.moneysave.domain.model.Account
import ir.siriusapps.moneysave.domain.repository.AccountRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AccountRepositoryImp @Inject constructor(
    private val networkService: NetworkService,
    private val mapper: AccountEntityMapper
):AccountRepository {
    override suspend fun login(userName: String, password: String): Account =
       mapper.mapToDomain(networkService.getService().getAccount(userName,password))
}