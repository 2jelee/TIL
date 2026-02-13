select * from dept2;

drop table guestBook;

create table guestBook (
	num number,
	name varchar2(50) not null,
	email varchar2(50),
	home varchar2(50),
	contents varchar2(2000) not null
) SEGMENT creation IMMEDIATE;  

select * from guestBook;

drop sequence book_num;
create sequence book_num; 

insert into guestBook(num, name, email, home, contents)
     values(book_num.nextval, 'dd', 'aa@kosta.or.kr', 'homeaa', 'hello');
    
commit;
--------------------------------------------------
 select name, email, home, contents from GUESTBOOK 
 				where num > 6 and num <= 23 
 				order by num desc;

SELECT COUNT(*) FROM GUESTBOOK
 select count(num) from GUESTBOOK;

 DELETE FROM GUESTBOOK WHERE NUM = 12
-----------------------------------------------

update guestBook set email='ii@i.kr', home='http://', contents='hi' where num = 1;

update guestBook set email= ? , home= ? , contents= ? where num = ?;


