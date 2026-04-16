package com.example.wishlist.repository;

import com.example.wishlist.model.Wish;
import com.example.wishlist.model.Wishlist;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class WishlistRepository {

    private final JdbcTemplate jdbcTemplate;

    public WishlistRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Wishlist> findByUserId(int userId) {
        String sql = "SELECT * FROM wishlists WHERE user_id = ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Wishlist.class), userId);
    }

    public Wishlist findById(int id) {
        String sql = "SELECT * FROM wishlists WHERE wishlist_id = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Wishlist.class), id);
    }

    public void save(Wishlist wishlist) {
        String sql = "INSERT INTO wishlists (user_id, title, description) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, wishlist.getUserId(), wishlist.getTitle(), wishlist.getDescription());
    }

    public List<Wish> findWishesByWishlistId(int wishlistId) {
        String sql = "SELECT * FROM wishes WHERE wishlist_id = ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Wish.class), wishlistId);
    }

    public void addWish(Wish wish) {
        String sql = "INSERT INTO wishes (wishlist_id, title, price, url, is_reserved) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, wish.getWishlistId(), wish.getTitle(), wish.getPrice(), wish.getUrl(), false);
    }

    public void deleteWish(int id) {
        String sql = "DELETE FROM wishes WHERE wish_id = ?";
        jdbcTemplate.update(sql, id);
    }
}