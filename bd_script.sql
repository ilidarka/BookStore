DROP DATABASE IF EXISTS BookStore;

CREATE DATABASE BookStore;
USE BookStore;

CREATE TABLE Books (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    bookName VARCHAR(255) NOT NULL,	
    author VARCHAR(255) NOT NULL,
    category VARCHAR(255) NOT NULL,
    genre VARCHAR(255) NOT NULL,
	price INT NOT NULL,
    amount INT NOT NULL,
    popularity INT NOT NULL,
    publisher VARCHAR(255) NOT NULL,
    graduate DATE NOT NULL,
    onStore INT NOT NULL,
    solded INT NOT NULL
);

CREATE TABLE Orders (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    orderNumber INT NOT NULL,
    bookToOrder VARCHAR(255) NOT NULL,
    customerName VARCHAR(255) NOT NULL,
    customerSurname VARCHAR(255) NOT NULL,
    customerAdres VARCHAR(255) NOT NULL,
    customerPhone VARCHAR(255) NOT NULL
);

INSERT INTO `Books` VALUES ('1',"1" , "book1", "science", "genre", '100', '300', '1', "publisher", '2008-10-23', '23', '30');
INSERT INTO `Books` VALUES ('2',"2" , "book2", "science", "genre", '100', '300', '2', "publisher", '2008-10-23', '23', '30');
INSERT INTO `Books` VALUES ('3',"3" , "book3", "science", "genre", '100', '300', '3', "publisher", '2008-10-23', '23', '30');
INSERT INTO `Books` VALUES ('4',"4" , "book4", "science", "genre", '100', '300', '4', "publisher", '2008-10-23', '23', '30');
INSERT INTO `Books` VALUES ('5',"5" , "book5", "science", "genre", '100', '300', '5', "publisher", '2008-10-23', '23', '30');
INSERT INTO `Books` VALUES ('6',"6" , "book6", "science", "genre", '100', '300', '6', "publisher", '2008-10-23', '23', '30');
INSERT INTO `Books` VALUES ('7',"7" , "book7", "science", "genre", '100', '300', '7', "publisher", '2008-10-23', '23', '30');
INSERT INTO `Books` VALUES ('8',"8" , "book8", "science", "genre", '100', '300', '8', "publisher", '2008-10-23', '23', '30');
INSERT INTO `Books` VALUES ('9',"9" , "book9", "science", "genre", '100', '300', '9', "publisher", '2008-10-23', '23', '30');
INSERT INTO `Books` VALUES ('10',"10" , "book10", "science", "genre", '100', '300', '10', "publisher", '2008-10-23', '23', '30');

INSERT INTO `Orders` VALUES ('1', '123', "orderedBook", "Anton", "Volosenko", "Pobeda Str. 23", "937-99-92");
INSERT INTO `Orders` VALUES ('2', '123', "orderedBook", "Anton", "Volosenko", "Pobeda Str. 23", "937-99-92");
INSERT INTO `Orders` VALUES ('3', '123', "orderedBook", "Anton", "Volosenko", "Pobeda Str. 23", "937-99-92");
INSERT INTO `Orders` VALUES ('4', '123', "orderedBook", "Anton", "Volosenko", "Pobeda Str. 23", "937-99-92");
INSERT INTO `Orders` VALUES ('5', '123', "orderedBook", "Anton", "Volosenko", "Pobeda Str. 23", "937-99-92");
INSERT INTO `Orders` VALUES ('6', '123', "orderedBook", "Anton", "Volosenko", "Pobeda Str. 23", "937-99-92");
INSERT INTO `Orders` VALUES ('7', '123', "orderedBook", "Anton", "Volosenko", "Pobeda Str. 23", "937-99-92");
INSERT INTO `Orders` VALUES ('8', '123', "orderedBook", "Anton", "Volosenko", "Pobeda Str. 23", "937-99-92");
INSERT INTO `Orders` VALUES ('9', '123', "orderedBook", "Anton", "Volosenko", "Pobeda Str. 23", "937-99-92");
INSERT INTO `Orders` VALUES ('10', '123', "orderedBook", "Anton", "Volosenko", "Pobeda Str. 23", "937-99-92");
