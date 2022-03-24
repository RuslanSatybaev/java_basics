package com.satybaev.homework.task3.model;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Step> listStep = new ArrayList<>();

    public List<Step> getListStep() {
        return listStep;
    }

    public void setListStep(List<Step> listStep) {
        this.listStep = listStep;
    }
}
