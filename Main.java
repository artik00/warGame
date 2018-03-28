package com.art.openu;

import com.art.openu.logic.Game;
import com.art.openu.logic.GameRunner;
import com.art.openu.model.Card;
import com.art.openu.model.DeckOfCards;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        GameRunner gameRunner = new GameRunner();
        gameRunner.start();
    }
}
