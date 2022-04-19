create table product (
pno bigint(20) not null auto_increment,
title varchar(200) not null,
writer varchar(100) not null,
content text,
reg_at datetime not null default current_timestamp(),
mod_at datetime not null default current_timestamp(),
readcount bigint(20) default 0,
primary key (pno)
);