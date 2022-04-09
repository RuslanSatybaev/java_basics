package com.satybaev.homework.task3.additonal_task3;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import static com.satybaev.homework.task3.additonal_task3.TicTACxmlWriter.gamer;

public class GetGame {

    public static Node getPlayer(Document doc, int id, String name, String symbol) {
        Element player = doc.createElement("Player");
        player.setAttribute("id", String.valueOf(id));
        player.setAttribute("name", name);
        player.setAttribute("symbol", symbol);
        return player;
    }

    public static Node getGameStep(Document doc,String num, String playerId, String value) {
        gamer.appendChild(getGameElements(doc, num, playerId, value));
        return gamer;
    }

    public static Node getGameResult(Document doc, int id, String name, String symbol) {
        Element game = doc.createElement("GameResult");
        game.appendChild(getPlayer(doc, id, name, symbol));
        return game;
    }

    private static Node getGameElements(Document doc, String num, String playerId, String value) {
        Element step = doc.createElement("Step");
        step.setAttribute("num", num);
        step.setAttribute("playerId", playerId);
        step.appendChild(doc.createTextNode(value));
        return step;
    }
}
