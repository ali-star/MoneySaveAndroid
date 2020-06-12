package ir.irsiusapps.domain.iteractors

import com.example.core.data.repository.CardRepo
import com.example.core.domain.entity.Card
import javax.smartcardio.Card

class ReadCard(private val cardRepo: CardRepo) {

    suspend fun readCard():List<Card> = cardRepo.readCard()

}