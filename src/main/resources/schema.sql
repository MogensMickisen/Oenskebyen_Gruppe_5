CREATE DATABASE IF NOT EXISTS wishlist_db;
USE wishlist_db;

DROP TABLE IF EXISTS wishes;
DROP TABLE IF EXISTS wishlists;
DROP TABLE IF EXISTS users;

CREATE TABLE users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE wishlists (
    wishlist_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    title VARCHAR(100) NOT NULL,
    description VARCHAR(255),
    FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE
);

CREATE TABLE wishes (
    wish_id INT AUTO_INCREMENT PRIMARY KEY,
    wishlist_id INT NOT NULL,
    title VARCHAR(100) NOT NULL,
    description VARCHAR(255),
    url VARCHAR(255),
    price DECIMAL(10, 2),
    is_reserved BOOLEAN DEFAULT FALSE,
    FOREIGN KEY (wishlist_id) REFERENCES wishlists(wishlist_id) ON DELETE CASCADE
);