package com.codecool.onlineshop.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadInput {

    public static String UserStringInput() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String readLine = "-1";
        try {
            readLine = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return readLine;
    }

    public static int UserIntInput() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String readLine = "-1";
        try {
            readLine = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Integer.parseInt(readLine);
    }

    public static float UserFloatInput() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String readLine = "-1";
        try {
            readLine = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Float.parseFloat(readLine);
    }
}

