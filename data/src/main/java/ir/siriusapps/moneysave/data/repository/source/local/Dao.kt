package ir.siriusapps.moneysave.data.repository.source.local

import androidx.room.Dao
import ir.siriusapps.moneysave.data.repository.source.local.db.*

@Dao
interface Dao :
    UserDao,
    RoomBankDao,
    RoomBankAccountDao,
    RoomCardDao,
    RoomTransactionDao