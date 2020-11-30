package com.company;


public class Coutry {
    static int sequence =1;

    int id;

    String name;

    Coutry(String name){
        id = sequence;
        sequence++;
        this.name = name;
    }

}
