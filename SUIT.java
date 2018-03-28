package com.art.openu.model;

public enum SUIT {
    Spades(1),
    Hearts(2),
    Diamonds(3),
    Clubs(4);

    private final int value;

    SUIT (int value) {
        this.value = value;
    }

    public int getNumericValue() {
        return value;
    }

    public static SUIT returnSuitFromInt(int number) {
        switch(number) {
            case 1:
                return SUIT.Spades;

            case 2:
                return SUIT.Hearts;

            case 3:
                return SUIT.Diamonds;

            case 4:
                return SUIT.Clubs;
                default:
                    return null;

        }
    }

    @Override
    public String toString() {
        switch (value) {
            case 1:
                return "Spades";

            case 2:
                return "Hearts";

            case 3:
                return "Diamonds";

            case 4:
                return "Clubs";
            default:
                return null;


        }
    }
}
