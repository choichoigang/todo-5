DROP TABLE IF EXISTS CATEGORY;
DROP TABLE IF EXISTS USER;
DROP TABLE IF EXISTS TASK;
DROP TABLE IF EXISTS ACTIVITY;

CREATE TABLE CATEGORY (
	id int auto_increment primary key NOT NULL,
    name varchar(10) NOT NULL
);

CREATE TABLE USER (
	id int auto_increment primary key NOT NULL,
    name varchar(16) NOT NULL,
    password varchar(15) NOT NULL
);

CREATE TABLE TASK (
	id int auto_increment primary key NOT NULL,
    description varchar(500) NOT NULL,
    is_deleted tinyint(2) NOT NULL DEFAULT FALSE,
    category int references category(id) NOT NULL,
    category_key int NOT NULL,
    user int references user(id) NOT NULL,
    user_key int NOT NULL
);

CREATE TABLE ACTIVITY (
	id int auto_increment primary key NOT NULL,
    created_date_time datetime NOT NULL,
    action_item varchar(45) NOT NULL,
    task int references task(id) NOT NULL,
    task_key int NOT NULL
);