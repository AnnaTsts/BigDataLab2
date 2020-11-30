package com.company;


import java.util.Date;

public class RecordDate{
    static int sequence =1;

    int id;
    Date date;

    public static int getSequence() {
        return sequence;
    }

    public static void setSequence(int sequence) {
        RecordDate.sequence = sequence;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    RecordDate(Date date){
        id = sequence;
        sequence++;
        this.date = date;
    }
}
