package com.codecool.onlineshop.view;

import java.util.List;

public class Viewer {

    /*
    displayTable merges headers with content and display it in console
     */

    public void displayTable(List<List<String>> table, List<String> headers) {

        PrintTable newTable = new PrintTable(headers, table, false);
        String tableToPrint = newTable.printTable();
        display(tableToPrint);
    }

    private void display(String content) {
        System.out.println(content);
    }


}
