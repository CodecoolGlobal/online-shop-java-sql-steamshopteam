package com.codecool.onlineshop.controller;

import com.codecool.onlineshop.controller.services.CategoryService;
import com.codecool.onlineshop.view.Print;

public class CategoryController {
    CategoryService categoryService;

    public CategoryController() {
        categoryService = new CategoryService();
    }

    public void createNewCategory(){
        Print.printText("Enter the category name");
        categoryService.create(ReadInput.UserStringInput());

    }

    public void editNameExistCategory(){
        System.out.println(categoryService.readAllCategory());
        Print.printText("Select id category to name edit");
        int id_category = ReadInput.UserIntInput();
        Print.printText("Enter new name category");
        categoryService.update(id_category,ReadInput.UserStringInput());
        System.out.println(categoryService.readAllCategory());

    }

}
