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