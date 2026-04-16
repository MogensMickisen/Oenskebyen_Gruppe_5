package com.example.wishlist.model;

public class Wishlist {
    private int wishlistId;
    private int userId;
    private String title;
    private String description;

    public Wishlist() {}
    public Wishlist(int wishlistId, int userId, String title, String description) {
        this.wishlistId = wishlistId;
        this.userId = userId;
        this.title = title;
        this.description = description;
    }

    // Getters og Setters
    public int getWishlistId() { return wishlistId; }
    public void setWishlistId(int wishlistId) { this.wishlistId = wishlistId; }
    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}