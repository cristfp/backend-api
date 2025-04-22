create table products(

    id bigint not null auto_increment,
    name varchar(100) not null,
    description varchar(100) not null unique,
    price varchar(6) not null unique,
    categoryPath varchar(100) not null,
    categories varchar(100) not null,
    available varchar(100) not null,
    obs varchar(9) not null,


    primary key(id)

);