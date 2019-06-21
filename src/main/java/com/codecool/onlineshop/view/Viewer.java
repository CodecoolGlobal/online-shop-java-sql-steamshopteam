package com.codecool.onlineshop.view;

import java.util.List;

public class Viewer {

    /*
    displayTable merges headers with content and display it in console
     */

    public void displayTable(List<List<String>> table, List<String> headers){

        PrintTable newTable = new PrintTable(headers, table,false);
        String tableToPrint = newTable.printTable();
        display(tableToPrint);
    }

    private void display(String content){
        System.out.println(content);
    }

    /*
    productsToString will read List of products
    and put it to list of lists (each product as a row)
     */
    /*

    public List<List<String>> productsToString(List<Product> products){
        List<List<String>> list = new ArrayList<>();
        for (Product product : products) {
            List<String> temp = new ArrayList<>();
            temp.add(product.getId().toString());
            temp.add(product.getName());
            temp.add(product.getPrice().toString());
            temp.add(product.getAmount().toString());
            temp.add(product.getAvailable().toString());
            temp.add(product.getCategory().getName());

            list.add(temp);
        }
        return list;
    }*/


}
