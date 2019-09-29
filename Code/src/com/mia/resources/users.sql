create table users(
	num number(5) primary key,
	id varchar(20),
	password varchar(20)
	name varchar(20)
);

create sequence users_seq with 1 increment by 1;

insert into users(num, id, password, name) values(user_seq, 'admin', 'admin', 'admin');
select * from users;