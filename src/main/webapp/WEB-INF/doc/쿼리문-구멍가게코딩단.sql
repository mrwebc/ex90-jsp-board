drop database if exists jspboard;
CREATE DATABASE IF NOT EXISTS jspboard DEFAULT CHARACTER SET utf8;

USE jspboard;

drop table if exists tbl_board;
create table tbl_board (
    bno int primary key auto_increment,
    title varchar(200) not null,
    content text,
    writer varchar(50) not null,
    regdate datetime not null default now(),
    viewcnt int default 0   
) default character set utf8;




select * from tbl_board order by bno desc;
select * from tbl_board limit 0,10;
select count(*) from tbl_board;

delete from tbl_board where title="";

insert into tbl_board (title, content, writer) values ("아기공룡둘리","둘리는 내친구~!", 'duly'); 
insert into tbl_board (title, content, writer) (select title, content, writer from tbl_board);


show tables;

drop table if exists tbl_member;
create table tbl_member(
    userid varchar(50) primary key,
    userpw varchar(50) not null,
    username varchar(50) not null,
    email varchar(100),
    regdate datetime default now(),
    updatedate datetime default now()
) default character set utf8;


desc tbl_member;

select * from tbl_member;
delete from tbl_member ;

select now(), sysdate(), current_timestamp() ;


CREATE TABLE tbl_reply(
    rseq int PRIMARY KEY auto_increment,
    seq int NOT NULL DEFAULT 0,
    replyText varchar(1000) NOT NULL,
    replyer varchar(50) NOT NULL,
    regdate timestamp NOT NULL DEFAULT now(),
    updatedate timestamp NOT NULL DEFAULT now(),
    foreign key (seq) references tbl_board (seq)
) DEFAULT CHARACTER SET utf8;













