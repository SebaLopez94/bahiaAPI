DROP TABLE IF EXISTS precio;
DROP TABLE IF EXISTS brand;

CREATE TABLE brand (
  id INT AUTO_INCREMENT  ,
  code VARCHAR(250) NOT NULL,
  name VARCHAR(250) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE precio (
  id INT AUTO_INCREMENT,
  brand INT NOT NULL,
  start_date TIMESTAMP  NOT NULL,
  end_date TIMESTAMP NOT NULL,
  price_list INT,
  product_id  INT,
  priority  INT,
  price FLOAT NOT NULL,
  curr VARCHAR(250) NOT NULL,
  created_at TIMESTAMP  NOT NULL,
  updated_at TIMESTAMP  NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (brand) REFERENCES brand(id)
);

INSERT INTO brand (id, code, name) VALUES
    (1, 'ZARA', 'ZARA');


INSERT INTO precio (brand, start_date,end_date,price_list,product_id,priority,price,curr,created_at,updated_at) VALUES
  (1, '2020-06-14 00.00.00', '2020-12-31 23.59.59', 1, 35455, 0, 35.50, 'EUR', CURRENT_TIMESTAMP(),CURRENT_TIMESTAMP()),
  (1, '2020-06-14 15.00.00', '2020-06-14 18.30.00', 2, 35455, 1, 25.45, 'EUR', CURRENT_TIMESTAMP(),CURRENT_TIMESTAMP()),
  (1, '2020-06-15 00.00.00', '2020-06-15 11.00.00', 3, 35455, 1, 30.50, 'EUR', CURRENT_TIMESTAMP(),CURRENT_TIMESTAMP()),
  (1, '2020-06-15 16.00.00', '2020-12-31 23.59.59', 4, 35455, 1, 38.95, 'EUR', CURRENT_TIMESTAMP(),CURRENT_TIMESTAMP());


