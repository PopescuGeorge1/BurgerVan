package com.example.burgervan;

public class itemObj {
    private String name;
    private Double price;
    private String description;
    private Integer q;

    public itemObj(String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
        q=1;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public Integer getQ() {
        return q;
    }

    public void setQ(Integer q) {
        this.q = q;
    }
}
