package com.art.openu.model;

public class Card implements Comparable{
    private SUIT suit;
    private RANK rank;

    public Card(SUIT suit, RANK rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public SUIT getSuit() {
        return suit;
    }

    public RANK getRank() {
        return rank;
    }

    @Override
    public String toString() {
        return "Suit : " + suit + " Rank : "+ rank ;
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Card) {
            Card other = (Card) o;
            RANK otherRank = other.getRank();
             return rank.getNumericValue().compareTo(otherRank.getNumericValue());
        }
        return -1;
    }
}
