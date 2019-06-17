# ER 모델링 규칙

## 엔티티

- 단수형 고유 엔티티 이름
- 엔티티 이름은 대문자
- 모서리가 둥근 상자

## 속성

- 소문자의 단수형 이름
- UID(고유 식별자) - #태그
- 필수 속성은 - * 태그
- 선택적 속성에는 - o 태그

## 관계

기호 - 설명

점선 : maybe를 나타내는 선택적 요소

실선 : must be를 나타내는 필수적 요소

까치발 : one or more을 나타내는 정도 요소

일방선 : one and only one을 나타내는 정도 요소



## 연관짓기

Primary Key : 테이블의 각 행을 고유하게 식별 (Unique + Not null)

Foreign Key : 여러 테이블을 논리적으로 연관시키는 역할



## SQL 문

### DML - 데이터 조작어

> SELECT
>
> INSERT
>
> UPDATE
>
> DELETE
>
> MERGE

### DDL - 데이터 정의어

> CREATE
>
> ALTER
>
> DROP
>
> RENAME
>
> TRUNCATE
>
> COMENT

### DCL - 데이터 제어어

> GRANT
>
> REVOKE

### 트랜잭션 제어

> COMMIT
>
> ROLLBACK
>
> SAVEPOINT



### 개발 도구

1. SQL Developer(GUI)
2. SQL *Plus(CLI)



### 1대 다 관계

![1560734840942](C:\Users\student\AppData\Roaming\Typora\typora-user-images\1560734840942.png)

EX) employee_id < manager_id

한 명의 사원이 여러명을 관리할 수 있다.



### ER 모델링

- 

<https://victorydntmd.tistory.com/126>

- ER 모델을 관계 모델로 변환

<https://victorydntmd.tistory.com/127?category=687930>

**3. ER 모델을 관계 모델로 변환**

**1) 일반적인 변환**



![img](https://t1.daumcdn.net/cfile/tistory/99EB8A3E5A7D137929)

Takes : 바뀔 가능성이 크다.(유동적)

Entity : 바뀔 가능성이 적다.(대게 수동적)