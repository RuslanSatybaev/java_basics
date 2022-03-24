package com.satybaev.homework.task3.parser;

import com.satybaev.homework.task3.model.Player;
import com.satybaev.homework.task3.model.Step;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import static com.satybaev.homework.task3.parser.BuildDocument.buildDocument;

public class StepName {
    static Player player = new GameResultName().returnPlayer();
    static String[][] array;
    static String SIGN_X = player.getSymbol();
    static String SIGN_0 = "0";

    static Step step = new Step();

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

    private static void initArray() {
        array = new String[][]{{"1", "2", "3"}, {"4", "5", "6"}, {"7", "8", "9"}};
    }

    private static void printArray() {
        for (int row = 0; row < 3; row++) {
            char separator = '|';
            for (int col = 0; col < 3; col++) {
                if (step.getPlayerId() == 1 && array[row][col].equals(String.valueOf(step.getValue()))) {
                    array[row][col] = SIGN_X;
                } else if (step.getPlayerId() == 2 && array[row][col].equals(String.valueOf(step.getValue()))) {
                    array[row][col] = SIGN_0;
                }
                System.out.print(separator + "" + array[row][col]);
            }
            System.out.print(separator);
            System.out.println();
        }
    }

    private static boolean checkWin(String dot) {
        for (int i = 0; i < 3; i++)
            if ((array[i][0].equals(dot) && array[i][1].equals(dot) &&
                    array[i][2].equals(dot)) ||
                    (array[0][i].equals(dot) && array[1][i].equals(dot) &&
                            array[2][i].equals(dot)))
                return true;
        return (array[0][0].equals(dot) && array[1][1].equals(dot) &&
                array[2][2].equals(dot)) ||
                (array[2][0].equals(dot) && array[1][1].equals(dot) &&
                        array[0][2].equals(dot));
    }
}
