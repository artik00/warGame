package com.art.openu.logic;

import com.art.openu.model.Card;

import javax.swing.*;
import java.util.Collections;
import java.util.List;

public class Game {
    private List<Card> firstDeck = Collections.emptyList();
    private List<Card> secondDeck = Collections.emptyList();

    public Game(List<Card> firstPlayerDeck, List<Card> secondPlayerDeck) {
        this.firstDeck = firstPlayerDeck;
        this.secondDeck = secondPlayerDeck;
    }

    public Card getFirstPlayerUpperCard() {
        if(firstDeck.size() > 0) {
            return firstDeck.get(0);
        }
        return null;
    }

    public Card getSecondPlayerUpperCard() {
        if(secondDeck.size() > 0) {
            return secondDeck.get(0);
        }
        return null;
    }

    public List<Card> getFirstDeck() {
        return firstDeck;
    }

    public List<Card> getSecondDeck() {
        return secondDeck;
    }

    public boolean shouldContinue() {
        if (firstDeck.isEmpty() || secondDeck.isEmpty()) {
            return false;
        }
        return true;
    }

    public void firstPlayerWon() {
        firstDeck.add(firstDeck.size(), secondDeck.get(0));
        secondDeck.remove(0);
    }

    public void secondPlayerWon() {
        secondDeck.add(secondDeck.size(), firstDeck.get(0));
        firstDeck.remove(0);
    }

    public void moveCardsFromDeckOneToTwo(int numberOfCards) {
        while(numberOfCards > 0 && firstDeck.size() > 0) {
            secondDeck.add(secondDeck.size(), firstDeck.get(0));
            firstDeck.remove(0);
            numberOfCards--;
        }
        moveSecondPlayerUpperCardToTail();
    }

    private void moveFirstPlayerUpperCardToTail() {
        if (!firstDeck.isEmpty()) {
            Card card = firstDeck.remove(0);
            firstDeck.add(firstDeck.size(), card);
        }
    }

    private void moveSecondPlayerUpperCardToTail() {
        if (!secondDeck.isEmpty()) {
            Card card = secondDeck.remove(0);
            secondDeck.add(secondDeck.size(), card);
        }
    }

    public void moveCardsFromDeckTwoToOne(int numberOfCards) {
        while (numberOfCards > 0 && secondDeck.size() > 0) {
            firstDeck.add(firstDeck.size(), secondDeck.get(0));
            secondDeck.remove(0);
            numberOfCards--;
        }
        moveFirstPlayerUpperCardToTail();
    }

    public int manageWar(int lastCardIndex, boolean quiet) {
        if (firstDeck.size() <= lastCardIndex) {
            if (!quiet) {
                JOptionPane.showMessageDialog(null, "You ran out of cards, You lost!");
                System.out.println("You ran out of cards, You lost!");
            }
            return -1;
        } else if (secondDeck.size() <= lastCardIndex) {
            if (!quiet) {
                JOptionPane.showMessageDialog(null, "Computer ran out of cards, You won!");
                System.out.println("Computer ran out of cards, You won!");
            }
            return 1;
        }
        return firstDeck.get(lastCardIndex).getRank().getNumericValue().compareTo(secondDeck.get(lastCardIndex).getRank().getNumericValue());
    }
}
