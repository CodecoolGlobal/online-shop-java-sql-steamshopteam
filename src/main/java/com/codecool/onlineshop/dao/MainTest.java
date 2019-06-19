package com.codecool.onlineshop.dao;

import com.codecool.onlineshop.controller.RootController;
import com.codecool.onlineshop.view.Ui;

public class MainTest {

    //private static final Ui ui = new Ui();

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