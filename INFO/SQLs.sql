-- Створюємо БД
CREATE DATABASE demo_db;

-- Створюємо таблицю
CREATE TABLE IF NOT EXISTS products
( id INTEGER NOT NULL AUTO_INCREMENT,
  name VARCHAR(128) NOT NULL,
  quota INTEGER NOT NULL,
  price DOUBLE NOT NULL,
  PRIMARY KEY (id)
);

-- Створення нового продукту
INSERT INTO products (name, quota, price) VALUES (?, ?, ?)

-- Читання всіх продуктів
SELECT * FROM products

-- Читання продукта за id
SELECT * FROM products WHERE id = ?

-- Оновлення продукта за id
UPDATE products SET name = ?, quota = ?, price = ? WHERE id = ?

-- Видалення продукту за id
DELETE FROM products WHERE id = ?