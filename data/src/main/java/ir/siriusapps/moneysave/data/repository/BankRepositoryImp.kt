package ir.siriusapps.moneysave.data.repository

import ir.siriusapps.moneysave.data.repository.source.local.MoneySaveDao
import ir.siriusapps.moneysave.domain.datasource.BankRepository
import ir.siriusapps.moneysave.domain.entity.Bank
import ir.siriusapps.moneysave.domain.entity.BankEntity
import ir.siriusapps.moneysave.domain.entity.BankEntityMapper
import javax.inject.Inject

class BankRepositoryImp @Inject constructor(
    private val moneySaveDao: MoneySaveDao,
    private val bankEntityMapper: BankEntityMapper
) : BankRepository {

    override fun add(bank: Bank) {
        moneySaveDao.insertBank(bankEntityMapper.mapToData(bank))
    }

    override fun add(banks: List<Bank>) {
        val bankEntities = banks.map {
            bankEntityMapper.mapToData(it)
        }
        moneySaveDao.insertBanks(bankEntities)
    }

    override fun remove(bank: Bank) {
        moneySaveDao.deleteBank(bankEntityMapper.mapToData(bank))
    }

    override fun remove(banks: List<Bank>) {
        val bankEntities = banks.map {
            bankEntityMapper.mapToData(it)
        }
        moneySaveDao.deleteBanks(bankEntities)
    }

    override fun read(): List<Bank> {
        return moneySaveDao.getBanks().map {
            bankEntityMapper.mapToDomain(it)
        }
    }
}