package cohen.dafna.day7.blackjack

class Deck {
    var cards: MutableList<Card> = addCardsToDeck()

    private fun addCardsToDeck(): MutableList<Card> {
        if (cards.isNullOrEmpty()) {
            cards = mutableListOf()
            for (suit in Suit.values()) {
                for (rank in Rank.values()) {
                    cards.add(Card(rank, suit))
                }
            }
        }
        return cards
    }

    fun shuffle() {
        cards.shuffle()
    }

    fun dealCard(): Card {
        val card = cards.removeAt(0)
        cards.remove(card)
        return card
    }
}
