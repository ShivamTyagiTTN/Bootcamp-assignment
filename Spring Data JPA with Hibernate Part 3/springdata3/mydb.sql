use mydb;

CREATE TABLE mydb.author (
id int PRIMARY KEY AUTO_INCREMENT NOT NULL,
name varchar(25),
street_number varchar(25),
location varchar(25),
State varchar(25)
);
SELECT * from author;

CREATE TABLE mydb.subject (
id int PRIMARY KEY AUTO_INCREMENT NOT NULL,
author_id int,
subject_name varchar(25),
FOREIGN KEY (author_id) References author(id));

SELECT * from subject;

create table mydb.book(
	id int PRIMARY KEY AUTO_INCREMENT NOT NULL,
    author_id int,
    book_name varchar(20),
	FOREIGN KEY (author_id) REFERENCES author(id)
);
select * from book;


create table mydb.book_many(
	id int primary key auto_increment,
    book_name varchar(20)
);
select * from book_many;

create table mydb.author_many(
	id int primary key auto_increment,
    author_name varchar(20)
);
select * from author_many;

create table mydb.authors_books(
author_id int,
book_id int,
FOREIGN KEY (author_id)
REFERENCES author_many(id),
FOREIGN KEY (book_id)
REFERENCES book_many(id)
);
select * from authors_books;
