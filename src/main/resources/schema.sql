DROP TABLE  IF EXISTS CARD;
CREATE TABLE CARD (
     id   INTEGER      NOT NULL AUTO_INCREMENT,
     name VARCHAR(128) NOT NULL,
     number VARCHAR(19) NOT NULL,
     limitoncard INTEGER,
     balance INTEGER,
     PRIMARY KEY (id)
);