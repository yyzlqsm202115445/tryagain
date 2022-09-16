CREATE DATABASE IF NOT EXISTS stocktrade;
use stocktrade;
create table stock (
    id int primary key auto_increment,
    stockTicker varchar (50),
    price double,
    volume int,
    buyOrSell varchar (10),
    statusCode int);

insert into stock values(9,'Is This It','The Strokes',11,13.99);

INSERT INTO stock (stockTicker,price,volume,buyOrSell, statusCode)
                       VALUES
                       ('APPLE',140.1,100,'buy',0);
INSERT INTO stock (stockTicker,price,volume,buyOrSell, statusCode)
                       VALUES
                       ('QQ',180.32,300,'sell',0);
INSERT INTO stock (stockTicker,price,volume,buyOrSell, statusCode)
                       VALUES
                       ('AWS',150.4,100,'buy',0);