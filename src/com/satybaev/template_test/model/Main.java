package com.satybaev.template_test.model;

import com.satybaev.lecture.Building;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
//import com.satybaev.lecture.House;

public class Main {

    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        list.add("Ruslan");
        list.add("Zabida");
        list.add("Alfia");

        for (String s : list) {
            System.out.print(s);
        }
        System.out.println();
        list.forEach(System.out::print);

        System.out.println();

        list.stream().forEach(e->{
            System.out.println(e);
        });

//        new House();
        new Building();
    }
}
