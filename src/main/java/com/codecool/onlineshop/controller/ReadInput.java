package com.codecool.onlineshop.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadInput {

    private static String readInput() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String readLine = "-1";
        try {
            readLine = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return readLine;
    }

    public static String UserStringInput() {
        return readInput();
    }

    public static int UserIntInput() {
        return Integer.parseInt(readInput());
    }

    public static float UserFloatInput() {
        return Float.parseFloat(readInput());
    }
}

