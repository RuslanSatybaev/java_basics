package com.satybaev.homework.task3.model;

import java.util.ArrayList;
import java.util.List;

public class GamePlay {
    List<Player> playerList = new ArrayList<>();
    List<Game> gameList = new ArrayList<>();

    public List<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }

    public List<Game> getGameList() {
        return gameList;
    }

    public void setGameList(List<Game> gameList) {
        this.gameList = gameList;
    }

    @Override
    public String toString() {
        return "GamePlay{" +
                "playerList=" + playerList +
                ", gameList=" + gameList +
                '}';
    }
}
