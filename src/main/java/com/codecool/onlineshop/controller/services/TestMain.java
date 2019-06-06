package com.codecool.onlineshop.controller.services;

public class TestMain {
    public static void main (String[] args){

        CategoryService categoryService = new CategoryService();
        OrderService orderService = new OrderService();

        System.out.println(categoryService.readAllCategory());

        categoryService.update(16,"testUpdate");
        System.out.println(categoryService.readAllCategory());

       /* orderService.create("12.12.2018","null",1,1,1);
        orderService.create("13.12.2018","null",1,1,1);
        orderService.create("14.12.2018","null",1,1,1);
        orderService.create("15.12.2018","null",2,1,1);
        orderService.create("16.12.2018","null",2,1,1);
        orderService.create("17.12.2018","null",3,1,1);
        orderService.create("18.12.2018","null",3,1,1);*/
        System.out.println(orderService.readAllByUser(1));


    }
}
