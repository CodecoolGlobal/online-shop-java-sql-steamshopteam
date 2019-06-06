package com.codecool.onlineshop.view;

import java.util.ArrayList;
import java.util.List;

public class Viewer {

    public void displayTable(List<List<String>> table){
        List<String> headers = new ArrayList<>();
        headers.add("ID");
        headers.add("NAME");
        headers.add("PRICE");
        headers.add("AMOUNT");
        headers.add("isAVAILABLE");
        headers.add("CATEGORY");
        PrintTable newTable = new PrintTable(headers,  table , false);
        String tableToPrint = newTable.printTable();
        display(tableToPrint);
    }

    public void display(String content){
        System.out.println(content);
    }

}
