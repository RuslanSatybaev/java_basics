package com.satybaev.homework.task3.parser;

import com.satybaev.homework.task3.model.GamePlay;
import com.satybaev.homework.task3.model.Player;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import static com.satybaev.homework.task3.parser.BuildDocument.buildDocument;

public class PlayerName {
    private static final Player player = new Player();

    public static void playerInit() {
        GamePlay root = new GamePlay();
        Document document;
        try {
            document = buildDocument();
        } catch (Exception e) {
            System.out.println("Open parsing error " + root.toString());
            return;
        }

        NodeList playerNodeList = document.getElementsByTagName("Player");
        for (int i = 0; i < playerNodeList.getLength() - 1; i++) {
            if (playerNodeList.item(i).getNodeType() == Node.ELEMENT_NODE) {
                Element playerElement = (Element) playerNodeList.item(i);
                player.setId(Integer.parseInt(playerElement.getAttribute("id")));
                player.setName(playerElement.getAttribute("name"));
                player.setSymbol(playerElement.getAttribute("symbol"));
            }
        }
    }
}
