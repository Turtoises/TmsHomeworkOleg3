CREATE database if not exists lesson33;

USE lesson33;

CREATE table if not exists cities
(
    id   int primary key auto_increment,
    city varchar(20) not null
);

CREATE table if not exists students
(
    id      int primary key auto_increment,
    name    varchar(20) not null,
    surname varchar(20) not null,
    city_id int,
    foreign key (city_id) references cities (id)
);

insert into cities(city)
values
    ('Minsk'),
    ('Vitebsk'),
    ('Grodno');

insert into students(name,surname,city_id)
values
    ('Ivan','Ivanov',1),
    ('Fedr','Petrov',2),
    ('Nocolai','Volohov',3);

SELECT name,surname,city
FROM students
JOIN cities on students.city_id = cities.id;