-- emp ���̺� ����
drop table emp;

-- emp ���̺� ����
create table emp(
num number(5) primary key,
name varchar2(16) not null,
dept varchar2(16),
score number(7,2));

-- emp_seq ������ ����
create sequence emp_seq increment by 1 start with 1 nocache nocycle;

-- emp_seq ������ ����
drop sequence emp_seq; 

insert into emp(num,name,dept,score) values(emp_seq.nextval,'���Ѹ�','������',75.3);
insert into emp(num,name,dept,score) values(emp_seq.nextval,'���ġ','������',90.3);
insert into emp(num,name,dept,score) values(emp_seq.nextval,'�����','���ߺ�',100.0);
insert into emp(num,name,dept,score) values(emp_seq.nextval,'�ֵ�ũ','���ߺ�',75.3);

select * from emp;
delete from emp;