package com.satybaev.homework.task3.model;

public class Step {
    private int num;
    private int playerId;
    private int value;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Step{" +
                "num=" + num +
                ", playerId=" + playerId +
                ", value=" + value +
                '}';
    }
}
