-- emp 테이블 삭제
drop table emp;

-- emp 테이블 생성
create table emp(
num number(5) primary key,
name varchar2(16) not null,
dept varchar2(16),
score number(7,2));

-- emp_seq 시퀀스 생성
create sequence emp_seq increment by 1 start with 1 nocache nocycle;

-- emp_seq 시퀀스 삭제
drop sequence emp_seq; 

insert into emp(num,name,dept,score) values(emp_seq.nextval,'강둘리','관리부',75.3);
insert into emp(num,name,dept,score) values(emp_seq.nextval,'김또치','영업부',90.3);
insert into emp(num,name,dept,score) values(emp_seq.nextval,'도우너','개발부',100.0);
insert into emp(num,name,dept,score) values(emp_seq.nextval,'최듀크','개발부',75.3);

select * from emp;
delete from emp;