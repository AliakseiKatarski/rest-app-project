create table User(
                     id bigint primary key auto_increment,
                     first_name varchar(20) not null,
                     last_name varchar(40) not null,
                     surname varchar(40) not null,
                     email varchar(50) not null unique
);

create table User_Role(
                          user_id bigint not null,
                          role_name varchar(45) not null,
                          FOREIGN KEY (user_id) REFERENCES User(id),
                          PRIMARY KEY (user_id,role_name)
)