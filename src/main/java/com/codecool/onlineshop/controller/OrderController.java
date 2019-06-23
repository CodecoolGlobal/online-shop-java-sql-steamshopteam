package com.codecool.onlineshop.controller;

import com.codecool.onlineshop.controller.services.BasketService;
import com.codecool.onlineshop.controller.services.OrderService;
import com.codecool.onlineshop.model.Basket;
import com.codecool.onlineshop.model.ConvertToArrays;
import com.codecool.onlineshop.model.Order;
import com.codecool.onlineshop.model.User;
import com.codecool.onlineshop.view.Print;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class OrderController {
    private BasketController basketController;
    private User user;
    private OrderService orderService;
    private DateTimeFormatter dateTimeFormatter;
    private LocalDate localDate;

    public OrderController(User user) {
        this.basketController = new BasketController(user);
        this.user = user;
        this.orderService = new OrderService();
        this.dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        this.localDate = LocalDate.now();
    }

    private void makeOrder() {
        List<Basket> basketList = new BasketService().getUserBasket(user);
        for (Basket basket : basketList) {
            Order order = new Order(user.getUserId(), dateTimeFormatter.format(localDate), "", user.getUserId(), 1,
                    basket.getProduct(), basket.getAmount());
            orderService.create(order);
            basketController.deleteProductsFromBasket(user);
        }


    }

    public void uiView() {
        List<Basket> basketList = new BasketService().getUserBasket(user);
        if (basketList.size() > 0) {
            Print.printText("Your basket");
            basketController.showUserBasket(user);
            Print.printText("Do you want place order ?(y/n): ");
            String userInput = ReadInput.UserStringInput();
            if (userInput.equals("y") || userInput.equals("Y")) {
                this.makeOrder();
                this.payForOrder();
            }
        } else {
            Print.printText("Your basket is empty!");
        }


    }

    private void payForOrder() {
        List<Order> orderList = orderService.readAllByUser(user.getUserId());
        for (Order order : orderList) {
            if (order.getId_owner() == user.getUserId()) {
                orderService.payForOrder(order, dateTimeFormatter.format(localDate));
            }

        }


    }

    public void showOrdersHistory() {
        List<Order> orderList = orderService.readAllByUser(user.getUserId());
        new ConvertToArrays().sendOrdersToTable(orderList);

    }

    public void showOrderList() {
        List<Order> orderList = orderService.readAll();
        new ConvertToArrays().sendOrdersToTable(orderList);
    }

}
