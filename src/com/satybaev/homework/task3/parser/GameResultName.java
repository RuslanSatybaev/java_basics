package com.satybaev.homework.task3.parser;

import com.satybaev.homework.task3.model.Player;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

import static com.satybaev.homework.task3.parser.BuildDocument.buildDocument;

public class GameResultName {

    static Player player = new Player();
    static List<Player> playerList = new ArrayList<>();

    public Player returnPlayer() {
        playerWin();
        return player;
    }


    public static void playerWin() {
        Document document;
        try {
            document = buildDocument();
        } catch (Exception e) {
            System.out.println("Open parsing error ");
            return;
        }

        NodeList playerNodeList = document.getElementsByTagName("GameResult");
        for (int i = 0; i < playerNodeList.getLength(); i++) {
            if (playerNodeList.item(i).getNodeType() == Node.ELEMENT_NODE) {
                Element playerElement = (Element) playerNodeList.item(i);

                NodeList childNodes = playerElement.getChildNodes();
                for (int j = 0; j < childNodes.getLength(); j++) {
                    if (childNodes.item(j).getNodeType() == Node.ELEMENT_NODE) {
                        Element childNodeElement = (Element) childNodes.item(j);

                        player.setId(Integer.parseInt(childNodeElement.getAttribute("id")));
                        player.setName(childNodeElement.getAttribute("name"));
                        player.setSymbol(childNodeElement.getAttribute("symbol"));
                    }
                }
                playerList.add(player);
            }
        }
    }
}


