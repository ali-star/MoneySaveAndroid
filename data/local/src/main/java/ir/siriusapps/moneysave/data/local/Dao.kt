package ir.siriusapps.moneysave.data.local

import androidx.room.Dao
import ir.siriusapps.moneysave.data.local.db.*

@Dao
interface Dao :
    UserDao,
    RoomBankDao,
    RoomBankAccountDao,
    RoomCardDao,
    RoomTransactionDao