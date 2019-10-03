create table board(
	num number(5) primary key,
	title varchar(50),
	writer varchar(20),
	content varchar(100),
	writeDate date default sysdate,
	hits number(5) default 0,
	recommand number(5) default 0
);

create sequence board_seq with 1 increment by 1;

insert into board(num, title, writer, content, writeDate, hits, recommand) values(board_seq, 'admin', 'admin', 'admin');
select * from board;