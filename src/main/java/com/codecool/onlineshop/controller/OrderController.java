package com.codecool.onlineshop.controller;

import com.codecool.onlineshop.controller.services.BasketService;
import com.codecool.onlineshop.controller.services.OrderService;
import com.codecool.onlineshop.controller.services.ProductService;
import com.codecool.onlineshop.model.Basket;
import com.codecool.onlineshop.model.Order;
import com.codecool.onlineshop.model.User;
import com.codecool.onlineshop.view.Print;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

public class OrderController {
    private BasketController basketController;
    private User user;
    private ProductService productService;
    private OrderService orderService;
    private DateTimeFormatter dateTimeFormatter;
    private LocalDate localDate;

    public OrderController(User user) {
        this.basketController = new BasketController(user);
        this.user = user;
        this.productService = new ProductService();
        this.orderService = new OrderService();
        this.dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        this.localDate = LocalDate.now();
    }

    public void makeOrder(){
        List<Basket> basketList = new BasketService().getUserBasket(user);
        for (Basket basket : basketList){
            Order order = new Order(dateTimeFormatter.format(localDate), "", user.getUserId(), 1,
                    basket.getProduct());
            orderService.create(order.getOrderDate(), order.getPayDate(), order.getId_owner(), order.getId_status(),
                    order.getId_product());
        }


    }

    public void payForOrder(){
        List<Order> orderList = new OrderService().readAllByUser(user.getUserId());
        for (Order order : orderList){
            if(order.getId_owner() == user.getUserId()){
                orderService.payForOrder(order, dateTimeFormatter.format(localDate));
            }

        }


    }

}
