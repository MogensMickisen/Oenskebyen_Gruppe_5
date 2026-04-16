package com.example.wishlist.model;

public class Wish {
    private int wishId;
    private int wishlistId;
    private String title;
    private String description;
    private String url;
    private double price;
    private boolean isReserved;

    public Wish() {}

    // Getters og Setters
    public int getWishId() { return wishId; }
    public void setWishId(int wishId) { this.wishId = wishId; }
    public int getWishlistId() { return wishlistId; }
    public void setWishlistId(int wishlistId) { this.wishlistId = wishlistId; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public boolean isReserved() { return isReserved; }
    public void setReserved(boolean reserved) { isReserved = reserved; }
}