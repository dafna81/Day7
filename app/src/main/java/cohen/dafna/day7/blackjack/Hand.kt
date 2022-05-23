package cohen.dafna.day7.blackjack

class Hand(private var cards: MutableList<Card>) {
    fun addCard(deck: Deck) {
        val card: Card = deck.dealCard()
        println("Added card: $card")
        cards.add(card)
    }

    fun getCards(): MutableList<Card> {
        return cards
    }

    fun getValue(): Int {
        var score = 0
        var aces = 0

        for (card in cards) {
            score += card.rank.value
            if (card.rank == Rank.ACE) {
                aces++
            }
            do {
                if (aces > 0 && score > 21) {
                    score -= 10
                    aces--
                }
            } while (aces > 0)

        }
        return score
    }

    fun checkIfBusted(): Boolean {
        if (getValue() > 21) {
            return true
        }
        return false
    }

    fun checkBlackJack(): Boolean {
        if (getCards().size == 2 && getValue() == 21) return true
        return false
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Hand

        if (cards != other.cards) return false

        return true
    }

    override fun hashCode(): Int {
        return cards.hashCode()
    }


}