USE todo;
DROP TABLE IF EXISTS board;
DROP TABLE IF EXISTS category;
DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS activity;
DROP TABLE IF EXISTS task;

CREATE TABLE board (
    id int primary key auto_increment,
    name varchar(64)
);

CREATE TABLE category (
    id int primary key auto_increment,
    name varchar(64),
    is_deleted boolean DEFAULT FALSE,
    created_date_time datetime DEFAULT current_timestamp,
    board int references board(id),
    board_key int
);

CREATE TABLE user (
    id int primary_key auto_increment,
    name varchar(64),
    password varchar(64)
);

CREATE TABLE task (
    id int auto_increment primary key,
    title varchar(500),
    content varchar(500),
    is_deleted boolean DEFAULT FALSE,
    category_from int DEFAULT 0,
    category_to int DEFAULT 0,
    category int references category(id) ON UPDATE CASCADE,
    category_key int,
    user int,
    author varchar(30),
    priority int
)

CREATE TABLE activity (
	id int auto_increment primary key,
    created_date datetime NOT NULL DEFAULT current_timestamp,
    action varchar(45),
    category_from int,
    category_to int,
    board int references board(id),
    board_key int,
    user int,
    author varchar(45),
    task varchar(500)
);