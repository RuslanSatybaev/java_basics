package com.satybaev.homework.task3.additonal_task3;

import com.satybaev.homework.task3.model.Player;
import com.satybaev.homework.task3.model.Step;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.List;

import static com.satybaev.homework.task3.print.InitPrintCheckTable.*;
import static com.satybaev.homework.task3.additonal_task3.GetGame.*;

public class TicTACxmlWriter {

    private static final String NUM = "1";
    private static final String PLAYER_ID = "1";


    private static final List<Step> stepList = game.getListStep();

    private static final Player winPlayer = gameResult.getWinPlayer();
    private static final int WIN_ID = winPlayer.getId();
    private static final String WIN_NAME = winPlayer.getName();
    private static final String WIN_SYMBOL = winPlayer.getSymbol();

    private static final List<Player> playerList = gamePlay.getPlayerList();
    public static Element gamer;

    public static void xmlWrite() {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try {
            builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();

            Element rootElement = doc.createElement("Gameplay");
            doc.appendChild(rootElement);

            for (Player player1 : playerList) {
                // добавляем первый дочерний элемент к корневому
                rootElement.appendChild(getPlayer(doc, player1.getId(), player1.getName(), player1.getSymbol()));
            }
            gamer = doc.createElement("Game");

            for (Step step1 : stepList) {
                rootElement.appendChild(getGameStep(doc,
                        String.valueOf(step1.getNum()),
                        String.valueOf(step1.getPlayerId()),
                        String.valueOf(step1.getValue())));
            }

            rootElement.appendChild(getGameResult(doc, WIN_ID, WIN_NAME, WIN_SYMBOL));

            //создаем объект TransformerFactory для печати в консоль 
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            // для красивого вывода в консоль
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);

            //печатаем в консоль или файл
            StreamResult console = new StreamResult(System.out);
            StreamResult file = new StreamResult(new File("src/com/satybaev/documents/gameplay3.xml"));

            //записываем данные
            transformer.transform(source, console);
            transformer.transform(source, file);
            System.out.println("Создание XML файла закончено");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}