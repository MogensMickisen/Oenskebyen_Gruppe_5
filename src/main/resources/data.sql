USE wishlist_db;

-- Indsæt testbruger (Forudfyldt login: testuser / password123)
INSERT INTO users (username, password, email) VALUES 
('testuser', 'password123', 'test@test.dk'),
('guestuser', 'guest123', 'guest@test.dk');

-- Indsæt test ønskesedler
INSERT INTO wishlists (user_id, title, description) VALUES 
(1, 'Fødselsdag 2026', 'Mine ønsker til min 25-års fødselsdag'),
(1, 'Julen 2026', 'Juleønsker');

-- Indsæt test ønsker
INSERT INTO wishes (wishlist_id, title, description, url, price, is_reserved) VALUES 
(1, 'PlayStation 5', 'Disk version', 'https://example.com/ps5', 4000.00, FALSE),
(1, 'Sokker', 'Sorte uldsokker', NULL, 150.00, TRUE),
(2, 'Kaffemaskine', 'Moccamaster', 'https://example.com/kaffe', 1200.00, FALSE);