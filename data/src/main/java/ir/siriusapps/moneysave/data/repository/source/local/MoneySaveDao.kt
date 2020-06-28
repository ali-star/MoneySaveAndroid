package ir.siriusapps.moneysave.data.repository.source.local

import androidx.room.Dao

@Dao
interface MoneySaveDao : RoomBankDao,
    RoomBankAccountDao,
    RoomCardDao,
    TransactionRoomDao