package com.foodest.foodest.Classes;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private Double price;
    private String imgUrl;

    @ManyToOne
    @JoinColumn(name = "cartId")
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "restaurantId")
    private Restaurant restaurant;

    @ManyToOne
    @JoinColumn(name = "orderId")
    private Order order;
    public Product() {
    }

    public Product(String name, String desc, Double price, String imgUrl, Restaurant restaurant) {
        this.name = name;
        this.description = desc;
        this.price = price;
        this.imgUrl = imgUrl;
        this.restaurant = restaurant;
    }

    public Product(Long id, String name, String desc, Double price, String imgUrl, Cart cart, Restaurant restaurant, Order order) {
        this.id = id;
        this.name = name;
        this.description = desc;
        this.price = price;
        this.imgUrl = imgUrl;
        this.cart = cart;
        this.restaurant = restaurant;
        this.order = order;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return description;
    }

    public void setDesc(String desc) {
        this.description = desc;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
