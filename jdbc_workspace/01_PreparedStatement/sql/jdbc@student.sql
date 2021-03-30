--==================================
--관리자 계정
--==================================
--student계정 생성 및 권한부여
create user student
identified by student  --비밀번호
default tablespace users;  --생성함

--권한부여
grant connect, resource to student;

--=======================
--student 계정
--======================
create table member(
    member_id varchar2(20),
    password varchar2(20) not null,
    member_name varchar2(100) not null,
    gender char(1),
    age number,
    email varchar2(200),
    phone char(11) not null,
    address varchar2(1000),
    hobboy varchar2(100),  --농구,음악감상,영화 (콤마를 구분자로)
    enroll_date date default sysdate,   --여기선 기본값이 sysdate 라는것.
    constraint pk_member_id primary key(member_id),
    constraint ck_member_gender check(gender in ('M', 'F'))
);
insert into member
values(
    'honggd', '1234', '홍길동', 'M', 33, 
    'honggd@naver.com', '01012341234',
    '서울 강남구 테헤란로', '등산,그림,요리', default
);
insert into member
values(
    'sinsa', '1234', '신사임당', 'F', 48, 
    'sinsa@naver.com', '01012344321',
    '서울 강동구 ', '음악감상', default
);
insert into member
values(
    'sejong', '1234', '세종', 'M', 76, 
    'sejong@naver.com', '01099998888',
    '서울 중구 ', '육식', default
);
insert into member
values(
    'leess', '1234', '이순신', 'M', 45, 
    'leess@naver.com', '01012121212',
    '전남 여수', '목공예', default
);
insert into member
values(
    'ygsgs', '1234', '유관순', 'F', null, 
    null, '01031313131',
    null, null, default
);

select * from member;
commit;

desc member;  --테이블 명세

alter table member
rename column hobboy to hobby;


-- 03 Properties_ExceptionHandling 실습문제
--삭제 트리거 생성
--resource 롤에 create trigger 권한이 있기 때문에 별도의 DCL없이 진행할수있음

create or replace trigger trig_delete_member
before delete on member
for each row
begin
    insert into member_del
        values(:old.member_id,:old.password,:old.member_name,:old.gender,:old.age,
        :old.email,:old.phone,:old.address,:old.hobby,:old.enroll_date,sysdate);
end;
/

--데이터 확인
select * from member_del;


--상품 테이블
create table product_stock(
product_id varchar2(30),
product_name varchar2(30) not null,
price number(10) not null,
description varchar2(50),
stock number default 0,
constraint pk_product_id primary key(product_id)
);

select * from product_stock;

--상품 입출고 테이블 
/*
create table product_io(
io_no number,
product_id varchar2(30),
iodate date default sysdate,
amount number,
status char(1),
constraint ck_product_io_status check(status in('I','O')),
constraint pk_io_no primary key(io_no),
constraint fk_product_io_product_id foreign key(product_id)
                                                references product_stock(product_id)

);
*/

--번호 부여 시퀀스 생성
create sequence seq_product_io
    start with 1
    increment by 1;

-- 트리거 생성
create or replace trigger tri_product
before
    update on product_io
    for each row
begin

    --입고
    if  :new.status = 'I' then
        update product_stock
        set stock = stock + :new.amount
        where product_id = :new.product_id;
     --출고   
    else 
        update product_stock
        set stock = stock - :new.amount
        where product_id = :new.product_id;
    end if;
end;
/
        
    








