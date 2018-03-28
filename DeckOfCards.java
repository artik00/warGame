package com.art.openu.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class DeckOfCards {
    List<Card> deck = Collections.emptyList();

    public DeckOfCards() {
        this.deck = new ArrayList<>();
        for(int i = 2; i< RANK.values().length+2; i++) {
            for(int j = 1; j < SUIT.values().length+1; j++) {
                Card newCard = new Card(SUIT.returnSuitFromInt(j), RANK.getRankFromInt(i));
                deck.add(newCard);
            }
        }
        shuffleDeck();
    }

    public void shuffleDeck() {
        Collections.shuffle(deck);
    }

    public void splitDeck(List<Card> listA, List<Card> listB) {
        if (listA == null || listB == null) {
            return;
        }
        int i=0;
        for (Card card: deck) {
            if (i % 2 ==0) {
                listA.add(card);
            } else {
                listB.add(card);
            }
            i++;
        }
    }
}
