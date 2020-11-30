package com.company;

public class Region {
    static int sequence =1;

    int id;

    String name;

    int countryId;

    public static int getSequence() {
        return sequence;
    }

    public static void setSequence(int sequence) {
        Region.sequence = sequence;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    Region(String name, int countryId){
        id = sequence;
        sequence++;
        this.name = name;
        this.countryId = countryId;
    }

}
