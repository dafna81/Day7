package cohen.dafna.day7.blackjack

data class Card(val rank: Rank, val suit: Suit)

enum class Rank(val value: Int) {
    TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7),
    EIGHT(8), NINE(9), TEN(10), JACK(10), QUEEN(10), KING(10),
    ACE(11)
}

enum class Suit {
    SPADES, HEARTS, CLUBS, DIAMONDS
}
