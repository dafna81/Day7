package cohen.dafna.day7.blackjack

class Game {
    private lateinit var deck: Deck
    private lateinit var playerHand: Hand
    private lateinit var dealerHand: Hand
    private var isGameInProgress: Boolean = false
    private var isBlackJack: Boolean = false
    private lateinit var winnerHand: String

    init {
        newGame()
    }

    private fun newGame() {
        deck = Deck()
        deck.shuffle()
        dealInitialCards()
        if (playerHand.checkBlackJack()) {
            endGameBlackJack()
        } else if (dealerHand.checkBlackJack()) {
            endGameBlackJack()
        }
        while (playerHand.getValue() < 17) {
            hit(playerHand)
        }
        stand()
        println(getWinner(checkWinner(Pair(playerHand, dealerHand))))
    }

    private fun endGameBlackJack() {
        println("Game over. $winnerHand.")
        isBlackJack = true
        isGameInProgress = false
    }

    private fun dealInitialCards() {
        isGameInProgress = true
        playerHand = Hand(mutableListOf(deck.dealCard(), deck.dealCard()))
        println("Player Cards: ${playerHand.getCards()}, Value: ${playerHand.getValue()}")
        dealerHand = Hand(mutableListOf(deck.dealCard(), deck.dealCard()))
        println("Dealer Cards: ${dealerHand.getCards()}, Value: ${dealerHand.getValue()}")
    }

    private fun hit(hand: Hand) {
        hand.addCard(deck)
        val who: String = if (hand == playerHand) "Player" else "Dealer"
        println("New value for $who: ${hand.getValue()}")
    }

    private fun stand() {
        if (isGameInProgress) {
            while (dealerHand.getValue() < 17) {
                hit(dealerHand)
            }
        }
    }

    private fun checkWinner(pair: Pair<Hand, Hand> = Pair(playerHand, dealerHand)): Int {
        if (!(pair.first.checkIfBusted()) && (pair.second.checkIfBusted()
                    || (pair.second.getValue() < pair.first.getValue())
                    || pair.first.checkBlackJack())
        ) {
            isGameInProgress = false
            return 0
        } else if (!(pair.second.checkIfBusted()) && (pair.first.checkIfBusted()
                    || (pair.second.getValue() > pair.first.getValue())
                    || pair.second.checkBlackJack())
        ) {
            isGameInProgress = false
            return 1
        } else if ((pair.second.checkIfBusted() && pair.first.checkIfBusted())
            || pair.second.getValue() == pair.first.getValue()
        ) {
            isGameInProgress = false
            return 2
        } else {
            isGameInProgress = true
            return 3
        }
    }

    private fun getWinner(winner: Int): String {
        return when (winner) {
            0 -> "Player won"
            1 -> "Dealer won"
            2 -> "Tie"
            else -> {
                "Not determined yet"
            }
        }
    }
}