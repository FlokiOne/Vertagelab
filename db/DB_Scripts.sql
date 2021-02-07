drop table userss;
drop table books;
drop SEQUENCE user_seq;
drop SEQUENCE book_seq;
drop TRIGGER user_bir;
drop TRIGGER book_bir;

----------------------------------- User TABLE ------------------------------

CREATE TABLE users (
                        user_id    NUMBER(10)    NOT NULL,
                        first_name VARCHAR2(100) NOT NULL,
                        last_name  VARCHAR2(100) NOT NULL
);


ALTER TABLE users ADD (CONSTRAINT users_pk PRIMARY KEY (user_id));
/

CREATE SEQUENCE user_seq START WITH 1;
/

CREATE OR REPLACE TRIGGER user_bir
BEFORE INSERT ON users
FOR EACH ROW

BEGIN
SELECT user_seq.NEXTVAL
INTO   :new.user_id
FROM   dual;
END;
/


----------------------------------- BOOKS TABLE ------------------------------


CREATE TABLE books (
                       book_id NUMBER(10)    NOT NULL,
                       user_id NUMBER(10)    NOT NULL,
                       title   VARCHAR2(100) NOT NULL,
                       status  VARCHAR2(100) NOT NULL
);


ALTER TABLE books ADD (
    CONSTRAINT books_pk PRIMARY KEY (book_id),
    CONSTRAINT user_fk
    FOREIGN KEY (user_id)
    REFERENCES users(user_id));
/

CREATE SEQUENCE book_seq START WITH 1;
/

CREATE OR REPLACE TRIGGER book_bir
BEFORE INSERT ON books
FOR EACH ROW

BEGIN
SELECT book_seq.NEXTVAL
INTO   :new.book_id
FROM   dual;
END;
/