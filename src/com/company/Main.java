package com.company;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;
import java.util.Scanner;

public class Main {

    static ArrayList<Record> records = new ArrayList<>();
    static ArrayList<RecordDate> dates = new ArrayList<>();
    static TypeOfRecord typeOfRecord1 = new TypeOfRecord(1,"confirmed");
    static TypeOfRecord typeOfRecord2 = new TypeOfRecord(2,"recovered");
    static TypeOfRecord typeOfRecord3 = new TypeOfRecord(3,"deaths");

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new File("confirmed.csv"));) {
            //обработка 1 строки
            parseFirstLine(scanner.nextLine());
            //
            while (scanner.hasNextLine()) {
                parceLine(scanner.nextLine(),1);
            }
        } catch (FileNotFoundException | ParseException e) {
            e.printStackTrace();
        }

        try (Scanner scanner = new Scanner(new File("recovered.csv"));) {
            //обработка 1 строки
            scanner.nextLine();
//            parseFirstLine(scanner.nextLine());
            //
            while (scanner.hasNextLine()) {
                parceLine(scanner.nextLine(),2);
            }
        } catch (FileNotFoundException  e) {
            e.printStackTrace();
        }

        try (Scanner scanner = new Scanner(new File("deaths.csv"));) {
            //обработка 1 строки
            scanner.nextLine();
//            parseFirstLine(scanner.nextLine());
            //
            while (scanner.hasNextLine()) {
                parceLine(scanner.nextLine(),3);
            }
        } catch (FileNotFoundException  e) {
            e.printStackTrace();
        }

        writeType();
        writeDate();
        writeRecord();

    }

    static void parseFirstLine(String line) throws ParseException {
        String[] split = line.split(",");
        for (int i =4;i<split.length;i++) {
            System.out.println(split[i]);
            Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(split[i]);
            RecordDate recordDate= new RecordDate(date1);
            dates.add(recordDate);
        }
    }

    static void parceLine(String line,int type){
        String[] split = line.split(",");
        for (int i=4;i<split.length;i++){
            if(!split[i].equals("")&&i<dates.size()){
            Record record= new Record(Integer.parseInt(split[i]),type,dates.get(i-4).getId(),split[1],split[4]);
            records.add(record);
            }
        }
    }

    static void writeRecord(){
        try (PrintWriter writer = new PrintWriter(new File("record.csv"))) {

            StringBuilder sb = new StringBuilder();
            for (Record record : records) {
                sb.append(record.id+","+record.dateId+","+record.qantity+","+record.recordType+","+record.country+","+record.region);
                sb.append("\n");
                writer.append(sb);
            }
            writer.flush();
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    static void writeDate(){
        try (PrintWriter writer = new PrintWriter(new File("date.csv"))) {

            StringBuilder sb = new StringBuilder();
            for (RecordDate dat : dates) {
                sb.append(dat.id+","+dat.date);
                sb.append("\n");
                writer.append(sb);
            }
            writer.flush();
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    static void writeType(){
        try (PrintWriter writer = new PrintWriter(new File("type.csv"))) {

            StringBuilder sb = new StringBuilder();

            ArrayList<TypeOfRecord> types = new ArrayList<>();
            types.add(typeOfRecord1);
            types.add(typeOfRecord2);
            types.add(typeOfRecord3);

            for (TypeOfRecord type : types) {
                sb.append(type.id+","+type.name);
                sb.append("\n");
                writer.append(sb);
            }
            writer.flush();
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
