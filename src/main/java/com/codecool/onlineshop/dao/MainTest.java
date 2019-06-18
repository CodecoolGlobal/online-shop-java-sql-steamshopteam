package com.codecool.onlineshop.dao;

import com.codecool.onlineshop.view.UI;

public class MainTest {

    private static final UI ui = new UI();

    public static void main(String[] args)
    {
        start(false);
    }

    public static void start(boolean isLogged)
    {
        ui.start(isLogged);
    }
}
