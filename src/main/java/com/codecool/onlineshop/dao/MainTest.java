package com.codecool.onlineshop.dao;

import com.codecool.onlineshop.view.UI;

public class MainTest {

    public static void main(String[] args)
    {
        start(false);
    }

    public static void start(boolean isLogged)
    {
        UI ui = new UI();
        ui.start(isLogged);
    }
}
