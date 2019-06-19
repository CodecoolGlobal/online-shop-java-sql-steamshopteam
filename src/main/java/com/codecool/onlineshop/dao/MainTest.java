package com.codecool.onlineshop.dao;

import com.codecool.onlineshop.controller.RootController;

public class MainTest {

    //private static final UiController ui = new UiController();

    public static void main(String[] args)
    {
        RootController rootController = new RootController();

        rootController.run();
        //start(false);
    }

//    public static void start(boolean isLogged)
//    {
//        ui.start(isLogged);
//    }
}