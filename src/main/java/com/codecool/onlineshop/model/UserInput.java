package com.codecool.onlineshop.model;

import java.util.Scanner;

public class UserInput {
    public String input()
    {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
