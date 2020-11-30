package com.company;

public class Record {
    static int sequence =1;
    int id;

    int qantity;

    String region;

    String country;

    int recordType;

    int dateId;

    public static int getSequence() {
        return sequence;
    }

    public static void setSequence(int sequence) {
        Record.sequence = sequence;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQantity() {
        return qantity;
    }

    public void setQantity(int qantity) {
        this.qantity = qantity;
    }


    public int getRecordType() {
        return recordType;
    }

    public void setRecordType(int recordType) {
        this.recordType = recordType;
    }

    public int getDateId() {
        return dateId;
    }

    public void setDateId(int dateId) {
        this.dateId = dateId;
    }

    public Record( int qantity,  int recordType, int dateId, String region, String country) {
        id = sequence;
        sequence++;
        this.qantity = qantity;
        this.recordType = recordType;
        this.dateId = dateId;
        this.region = region;
        this.country=country;
    }
}
