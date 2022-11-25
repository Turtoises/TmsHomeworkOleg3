USE my_project;

CREATE table if not exists users
(
    id       BIGINT primary key auto_increment,
    login    varchar(20) not null unique,
    password varchar(50) not null,
    role     varchar(10) not null default 'USER',
    email    varchar(70),
    name     varchar(50),
    surname  varchar(50)
);

CREATE INDEX index_login
    ON users (login);