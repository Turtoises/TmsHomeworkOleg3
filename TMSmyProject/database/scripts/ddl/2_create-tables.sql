USE my_project;


CREATE table if not exists users
(
    id BIGINT primary key auto_increment,
    login varchar(20) not null unique,
    password varchar(10) not null,
    role varchar(10) not null default 'USER',
    email varchar(20),
    name varchar(20),
    surname varchar(20)
);