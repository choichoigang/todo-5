DROP TABLE IF EXISTS category;
DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS task;
DROP TABLE IF EXISTS activity;

CREATE TABLE category (
	id int auto_increment primary key NOT NULL,
    name varchar(45) NOT NULL,
    is_deleted boolean NOT NULL DEFAULT FALSE,
    created_date_time datetime NOT NULL DEFAULT current_timestamp
);

CREATE TABLE user (
	id int auto_increment primary key NOT NULL,
    name varchar(16) NOT NULL,
    password varchar(15) NOT NULL
);

CREATE TABLE task (
	id int auto_increment primary key NOT NULL,
    title varchar(500) NOT NULL,
    content varchar(500) NOT NULL,
    is_deleted boolean NOT NULL DEFAULT FALSE,
    priority int NOT NULL,
    category_to int DEFAULT 0,
    category int references category(id) ON UPDATE CASCADE,
    category_key int,
    user int references user(id) ON UPDATE CASCADE,
    user_key int,
    author varchar(30) NOT NULL
);

CREATE TABLE activity (
	id int auto_increment primary key NOT NULL,
    created_date varchar(45),
    action varchar(45),
    target varchar(45),
    user_name varchar(45),
    category_from int,
    category_to int,
    target_title varchar(45),
    user int NOT NULL references user(id) ON UPDATE CASCADE,
    user_key int
);