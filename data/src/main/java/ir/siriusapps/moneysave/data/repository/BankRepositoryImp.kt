package ir.siriusapps.moneysave.data.repository

import ir.siriusapps.moneysave.data.repository.source.local.MoneySaveDao
import ir.siriusapps.moneysave.domain.datasource.BankRepository
import ir.siriusapps.moneysave.domain.entity.Bank
import ir.siriusapps.moneysave.domain.entity.BankEntity
import ir.siriusapps.moneysave.domain.entity.BankEntityMapper
import ir.siriusapps.moneysave.domain.scope.ApplicationScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

@ApplicationScope
class BankRepositoryImp @Inject constructor(
    private val moneySaveDao: MoneySaveDao,
    private val bankEntityMapper: BankEntityMapper
) : BankRepository {

    private val ioDispatcher = Dispatchers.IO

    override suspend fun add(bank: Bank) = withContext(ioDispatcher) {
        moneySaveDao.insertBank(bankEntityMapper.mapToData(bank))
    }

    override suspend fun add(banks: List<Bank>) = withContext(ioDispatcher) {
        val bankEntities = banks.map {
            bankEntityMapper.mapToData(it)
        }
        moneySaveDao.insertBanks(bankEntities)
    }

    override suspend fun remove(bank: Bank) = withContext(ioDispatcher) {
        moneySaveDao.deleteBank(bankEntityMapper.mapToData(bank))
    }

    override suspend fun remove(banks: List<Bank>) = withContext(ioDispatcher) {
        val bankEntities = banks.map {
            bankEntityMapper.mapToData(it)
        }
        moneySaveDao.deleteBanks(bankEntities)
    }

    override suspend fun read(): List<Bank> = withContext(ioDispatcher) {
        return@withContext moneySaveDao.getBanks().map {
            bankEntityMapper.mapToDomain(it)
        }
    }
}