package com.art.openu.model;

public enum RANK {
    Two(2),
    Three(3),
    Four(4),
    Five(5),
    Six(6),
    Seven(7),
    Eight(8),
    Nine(9),
    Ten(10),
    Jack(11),
    Queen(12),
    King(13),
    Ace(14);

    private final int value;
    RANK (int value) {
        this.value = value;
    }

    public Integer getNumericValue() {
        return value;
    }

    public static RANK getRankFromInt(int number) {
        switch(number) {

            case 2:
                return RANK.Two;
            case 3:
                return RANK.Three;
            case 4:
                return RANK.Four;
            case 5:
                return RANK.Five;
            case 6:
                return RANK.Six;
            case 7:
                return RANK.Seven;
            case 8:
                return RANK.Eight;
            case 9:
                return RANK.Nine;
            case 10:
                return RANK.Ten;
            case 11:
                return RANK.Jack;
            case 12:
                return RANK.Queen;
            case 13:
                return RANK.King;
            case 14:
                return RANK.Ace;
                default:
                    return null;
        }
    }

    @Override
    public String toString() {
        switch (value) {
            case 2:
                return "Two";
            case 3:
                return "Three";
            case 4:
                return "Four";
            case 5:
                return "Five";
            case 6:
                return "Six";
            case 7:
                return "Seven";
            case 8:
                return "Eight";
            case 9:
                return "Nine";
            case 10:
                return "Ten";
            case 11:
                return "Jack";
            case 12:
                return "Queen";
            case 13:
                return "King";
            case 14:
                return "Ace";
            default:
                return "";
        }
    }
}
