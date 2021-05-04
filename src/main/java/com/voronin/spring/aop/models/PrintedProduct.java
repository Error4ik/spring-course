package com.voronin.spring.aop.models;

public abstract class PrintedProduct {
    private String name;

    private String author;

    private int yearOfPublication;

    public PrintedProduct() {
    }

    public PrintedProduct(String name, String author, int yearOfPublication) {
        this.name = name;
        this.author = author;
        this.yearOfPublication = yearOfPublication;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getYearOfPublication() {
        return yearOfPublication;
    }
}
