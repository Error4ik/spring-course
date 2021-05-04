package com.voronin.spring.aop;

import com.voronin.spring.aop.models.PrintedProduct;
import org.springframework.stereotype.Component;

@Component("libraryBean")
public class Library {

    public void getBook() {
        System.out.println("We get the book!");
    }

    public void returnBook() {
        System.out.println("We are returning the Book!");
    }

    public void addPrintedProduct(String personName, PrintedProduct printedProduct) {
        System.out.println(String.format("We are adding the %s!", printedProduct.getName()));
    }

    public void getMagazine() {
        System.out.println("We get the Magazine!");
    }

    public void returnMagazine() {
        System.out.println("We are returning the Magazine!");
    }
}
