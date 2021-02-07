-------------------------------------------------Test data for User ---------------------------------------------

INSERT INTO users (user_id, first_name, last_name) VALUES(0, 'Library', 'Manager');

INSERT INTO users (user_id, first_name, last_name) VALUES(USER_SEQ.nextval, 'Zurab', 'Surmanidze');
INSERT INTO users (user_id, first_name, last_name) VALUES(USER_SEQ.nextval, 'Ivan', 'Kalyta');
INSERT INTO users (user_id, first_name, last_name) VALUES(USER_SEQ.nextval, 'Masha', 'Sulima');
INSERT INTO users (user_id, first_name, last_name) VALUES(USER_SEQ.nextval, 'Maksym', 'Mazurov');
INSERT INTO users (user_id, first_name, last_name) VALUES(USER_SEQ.nextval, 'Anton', 'Kiriya');
INSERT INTO users (user_id, first_name, last_name) VALUES(USER_SEQ.nextval, 'Anna', 'Diasamidze');


-------------------------------------------------Test data for Book ---------------------------------------------

INSERT INTO books (book_id, user_id, title, status) VALUES(BOOK_SEQ.nextval, 0, 'Number the Stars', 'Enabled');
INSERT INTO books (book_id, user_id, title, status) VALUES(BOOK_SEQ.nextval, 1, 'The Chronicles of Narnia', 'Disabled');
INSERT INTO books (book_id, user_id, title, status) VALUES(BOOK_SEQ.nextval, 4, 'Winnie-the-Pooh', 'Disabled');
INSERT INTO books (book_id, user_id, title, status) VALUES(BOOK_SEQ.nextval, 3, 'Bridge to Terabithia', 'Disabled');
INSERT INTO books (book_id, user_id, title, status) VALUES(BOOK_SEQ.nextval, 0, 'Mary Poppins', 'Enabled');
INSERT INTO books (book_id, user_id, title, status) VALUES(BOOK_SEQ.nextval, 3, 'Coraline', 'Disabled');
INSERT INTO books (book_id, user_id, title, status) VALUES(BOOK_SEQ.nextval, 0, 'Number ', 'Enabled');
INSERT INTO books (book_id, user_id, title, status) VALUES(BOOK_SEQ.nextval, 1, 'The Narnia', 'Disabled');
INSERT INTO books (book_id, user_id, title, status) VALUES(BOOK_SEQ.nextval, 4, 'Winnie', 'Disabled');
INSERT INTO books (book_id, user_id, title, status) VALUES(BOOK_SEQ.nextval, 3, 'Bridge', 'Disabled');
INSERT INTO books (book_id, user_id, title, status) VALUES(BOOK_SEQ.nextval, 0, 'Poppins', 'Enabled');
INSERT INTO books (book_id, user_id, title, status) VALUES(BOOK_SEQ.nextval, 3, 'Coraline 2', 'Disabled');