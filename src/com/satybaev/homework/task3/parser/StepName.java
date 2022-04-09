package com.satybaev.homework.task3.parser;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import static com.satybaev.homework.task3.parser.BuildDocument.buildDocument;
import static com.satybaev.homework.task3.print.InitPrintCheckTable.*;

public class StepName {

    public static void game() {
        PlayerName.playerInit();
        initArray();
        Document document;

        try {
            document = buildDocument();
        } catch (Exception e) {
            System.out.println("Open parsing error");
            return;
        }

        NodeList StepNodeList = document.getElementsByTagName("Step");
        for (int i = 0; i < StepNodeList.getLength(); i++) {
            if (StepNodeList.item(i).getNodeType() == Node.ELEMENT_NODE) {

                Element stepElement = (Element) StepNodeList.item(i);
                step.setNum(Integer.parseInt(stepElement.getAttribute("num")));
                step.setPlayerId(Integer.parseInt(stepElement.getAttribute("playerId")));
                step.setValue(Integer.parseInt(stepElement.getTextContent()));

                printArray();
            }
            System.out.println();
        }
        if (checkWin(SIGN_X)) {
            System.out.println("Player " +
                    player.getId() + " -> " +
                    player.getName() + " is winner as '" +
                    player.getSymbol() + "'!");
        }
        if (checkWin(SIGN_0)) {
            System.out.println(" Player 2 -> " + player.getName() + " is winner as '0'!");
        }
    }
}
