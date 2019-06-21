package com.codecool.onlineshop.view;


import java.util.ArrayList;
import java.util.List;

class PrintTable {

    private List<String> headers;
    private List<List<String>> content;
    private boolean wantIndex;
    private Integer[] collumnsWidth;


    public PrintTable(List<String> headers, List<List<String>> content, boolean wantIndex) {
        this.headers = headers;
        this.content = content;
        this.wantIndex = wantIndex;
        getCollumnsWidth();
    }

    public String printTable() {
        checkIfNoProblems();
        List<String> table = new ArrayList<>();
        List<List<String>> input = processData();
        String fieldSeparator = "│";
        String rowSeparator = generateTopMiddleOrBottomLine("rowSeparator");

        table.add(generateTopMiddleOrBottomLine("top"));
        for (List<String> list : input) {
            table.add(fieldSeparator);
            for (int index = 0; index < list.size(); index ++) {
                table.add(centerField(list.get(index), collumnsWidth[index]));
                table.add(fieldSeparator);
            }
            table.add(rowSeparator);
        }
        table.set(table.size() - 1, generateTopMiddleOrBottomLine("bottom"));
        return String.join("", table);
    }

    private void getCollumnsWidth() {
        List<Integer> collumnsWidth = new ArrayList<>();
        this.collumnsWidth = new Integer[headers.size()];

        for (String string : headers) {
            collumnsWidth.add(string.length());
        }
        for (List<String> list : content) {
            for (int index = 0; index < list.size(); index ++) {
                if (collumnsWidth.get(index) < list.get(index).length()) {
                    collumnsWidth.set(index, list.get(index).length());
                }
            }
        }
        collumnsWidth.toArray(this.collumnsWidth);
    }

    private String generateTopMiddleOrBottomLine(String modifier) {
        List<String> output = new ArrayList<>();
        String start;
        String middle;
        String end;

        switch (modifier) {
            case "top": default:
                start = "\n╭";
                middle = "┬";
                end = "╮\n";
                break;
            case "rowSeparator":
                start = "\n├";
                middle = "┼";
                end = "┤\n";
                break;
            case "bottom":
                start = "\n╰";
                middle = "┴";
                end = "╯\n";
                break;
        }
        output.add(start);
        for (Integer number : collumnsWidth) {
            int repetitions = number;
            while (repetitions > 0) {
                output.add("─");
                repetitions --;
            }
            output.add(middle);
        }
        output.set(output.size() - 1, end);
        return String.join("", output);
    }

    private String centerField(String field, int collumnWidth) {
        List<String> centeredField = new ArrayList<>();
        boolean flip = true;
        int repetitions = collumnWidth - field.length();
        int shift = 1;

        centeredField.add(field);
        while (repetitions > 0) {
            if (flip == true) {
                centeredField.add(centeredField.size() - shift, " ");
            } else {
                centeredField.add(" ");
            }
            flip = !flip;
            shift ++;
            repetitions --;
        }
        return String.join("", centeredField);
    }

    private List<List<String>> injectIndex() {
        if (wantIndex) {
            List<List<String>> indexedContent = content;
            Integer index = 1;
            for (List<String> list : indexedContent) {
                list.add(0, index.toString());
                index ++;
            }
            return indexedContent;
        }
        return content;
    }

    private List<List<String>> processData() {
        List<List<String>> input = injectIndex();
        input.add(0, headers);
        return input;
    }

    private boolean areListsLengthsValid() {
        int listsLength = headers.size();

        if (wantIndex) {
            listsLength --;
        }
        for(List<String> list : content) {
            if (list.size() != listsLength) {
                return false;
            }
        }
        return true;
    }

    private boolean checkIfListsAreEmpty() {
        List<List<String>> headersAndContent = new ArrayList<>();

        headersAndContent.add(headers);
        for (List<String> list : content) {
            headersAndContent.add(list);
        }
        for (List<String> list : headersAndContent) {
            try {
                String string = list.get(0);
            } catch (IndexOutOfBoundsException e) {
                return true;
            }
        }
        return false;
    }

    private void checkIfNoProblems() {
        if (checkIfListsAreEmpty()) {
            System.out.println("Error, some of lists passed to printer are empty");
            System.exit(0);
        } else if (!areListsLengthsValid()) {
            System.out.println("Lists lengths are invalid. Amount of items in each sublist of content\nYou wish to print must be the same as amount of items in headers with\nthe exception of situation where you want program to add index. In this\ncase headers should contain 1 more item than each sublist of content to print");
            System.exit(0);
        }
    }
}