package com.art.openu.logic;

import com.art.openu.model.Card;
import com.art.openu.model.DeckOfCards;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class GameRunner {
    public static final String COMPUTER_WINS_THE_ROUND = "Computer wins the round!";
    public static final String YOU_WIN_THE_ROUND = "You win the round!";
    DeckOfCards deckOfCards;
    List<Card> firstPlayerCards;
    List<Card> secondPlayerCards;
    Game warGame;

    public GameRunner() {
        this.deckOfCards = new DeckOfCards();
        this.firstPlayerCards = new ArrayList<>();
        this.secondPlayerCards = new ArrayList<>();
        this.deckOfCards.splitDeck(firstPlayerCards, secondPlayerCards);
        this.warGame = new Game(firstPlayerCards, secondPlayerCards);
    }

    public void start() {
        while (warGame.shouldContinue()) {
            JOptionPane.showMessageDialog(null, "Your card is  " + warGame.getFirstPlayerUpperCard() +
                    "\n" + "Computer's card is " + warGame.getSecondPlayerUpperCard());
            Card firstPlayerCard = warGame.getFirstPlayerUpperCard();
            Card secondPlayerCard = warGame.getSecondPlayerUpperCard();
            if (firstPlayerCard != null && secondPlayerCard != null) {
                if (firstPlayerCard.compareTo(secondPlayerCard) == -1) {
                    JOptionPane.showMessageDialog(null, COMPUTER_WINS_THE_ROUND);
                    warGame.moveCardsFromDeckOneToTwo(1);
                } else if (firstPlayerCard.compareTo(secondPlayerCard) == 1) {
                    JOptionPane.showMessageDialog(null, YOU_WIN_THE_ROUND);
                    warGame.moveCardsFromDeckTwoToOne(1);
                } else {
                    JOptionPane.showMessageDialog(null, "Same ranks, starting a war!");
                    int index = 4;
                    while ( warGame.manageWar(index, true) == 0) {
                        index += 3;
                    }
                    int winner = warGame.manageWar(index, false);
                    manageWarResults(index, winner);
                }
            }
        }
    }

    private void manageWarResults(int index, int winner) {
        if (winner == 1) {
            if (secondPlayerCards.size() > index) {
                JOptionPane.showMessageDialog(null, "You won with " + firstPlayerCards.get(index) + ", computer card was : "
                        + secondPlayerCards.get(index) + ", you gained total of " + index + " cards.");
            }
            warGame.moveCardsFromDeckTwoToOne(index);
        } else if ( winner == -1) {
            if( firstPlayerCards.size() > index) {
                JOptionPane.showMessageDialog(null, "You lost with " + firstPlayerCards.get(index) + " computer card was : "
                        + secondPlayerCards.get(index) + " you lost total of " + index + " cards.");
            }
            warGame.moveCardsFromDeckOneToTwo(index);
        }
    }
}
