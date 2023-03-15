
/*
	테이블 설계 주의점
		1. 서로 다른 테이블 간의 중복필드 x
        2. 예외) 서로 다른 테이블간의 관계[연결 PK-FK] : 무결성 유지
			- 테이블당 PK 1개 이상 권장
*/



drop database if exists jspweb;
create database jspweb;
use jspweb; -- 없으면 새로 생성하기 
-- 회원테이블
drop table if exists member;
create table member(
	mno		int 		auto_increment primary key , -- 식별번호 
    mid		varchar(30) not null  unique, -- 회원 아이디 [ 공백불가 , 중복불가 ] 	
    mpwd	varchar(20) not null , -- 회원 비밀번호 [ 공백불가 ]
    mimg	longtext , -- 웹서버에 저장된 사진 경로  [ 공백가능 ]
	memail	varchar(100) -- 회원 이메일 [ 공백불가 , 중복불가 ] 
);
-- 친추 테이블 
drop table if exists friend;
create table friend(
	fno int 	auto_increment primary key , -- 식별번호 
    ffrom int  	,	-- 친구 신청한 회원 fk 
    fto int 	,	-- 친구 신청 받은 회원 fk 
    foreign key ( ffrom ) 	references member ( mno ) on delete set null,	
    foreign key ( fto ) 	references member( mno ) on delete set null -- 친구가 탈퇴하면 null 
);
-- 포인트 테이블 
drop table if exists mpoint;
create table mpoint(
	mpno		int 			auto_increment primary key ,	-- 포인트내역 식별번호 
    mpcomment	varchar(1000) not null , 	-- 포인트내역 내용 
    mpamount	int default 0,				-- 포인트 수량 
    mpdate		datetime default now() ,	-- 포인트 내역 날짜 
    mno			int ,						-- 포인트 변경된 회원번호 
    foreign key ( mno ) 	references member ( mno ) on delete set null  -- 탈퇴하면 포인트 null
);
insert into member(mid,mpwd,mimg,memail) values ('admin','admin1',null,'admin@admin.com');
insert into mpoint(mpcomment,mpamount,mno) values ('관리자',10000,1);
-- 아이디에 해당하는 회원정보[레코드] + 보유보인트 호출

/*
-- 1. 특정 회원 포인트 내역
select * from mpoint where mno=1;
-- * 모든 회원의 보유 포인트
select sum(mpamount) from mpoint;
-- 2. 특정 회원 보유 보인트
select sum(mpamount) from mpoint where mno= 1;
-- 3. 아이디에 해당하는 회원 보유 포인트 [ 조인--교집합 / PK - FK]
select * from member m, mpoint p where m.mno = p.mno; 	-- 다른 조건과 헷갈릴 수 있다.
select *from member m natural join mpoint;				-- 암묵적으로 PK와 FK를 찾아서 조인

-- 4. (회원별 보유포인트)조인 후 필요한 필드와 통계 [ 두개 이상 필드를 출력시 그룹 필수!!!! ]
select m.mno,m.mid,m.mimg,m.memail, sum( p.mpamount) as mpoint
from member m, mpoint p 
where m.mno = p.mno
group by mno;	-- 집계할 기준 [~~별]

-- 5. (특정1명 회원정보+보유포인트)
select m.mno,m.mid,m.mimg,m.memail, sum( p.mpamount) as mpoint
from member m, mpoint p 
where m.mno = p.mno and m.mid='admin';

-- 조인 없을 때
select * from member where mid = 'qwewqrqw';

select *from member;
select *from mpoint;
*/

-- 카테고리 테이블 [ 카테고리번호, 카테고리 이름 (공지사항, 커뮤니티, Q&A, 노하우 등등)]
drop table if exists category;
create table category(
	cno int auto_increment primary key,
    cname varchar(100)
);
-- 게시물 테이블 [ 번호, 제목, 내용, 첨부파일1개, 작성일, 조회수, 좋아요, 싫어요, 작성자, 카테고리번호 ]
create table board(
	bno int auto_increment primary key,
    btitle varchar(100) not null,
    bcontent longtext not null,
    bfile longtext,
    bdate datetime default now(),
    bview int default 0,
    bup int default 0,
    bdown int default 0,
    mno int,
    cno int,
    foreign key (mno) references member(mno) on delete set null,	-- pk[회원] 삭제되면 게시물은 유지
    foreign key (cno) references category(cno) on delete cascade	-- pk[카테고리] 삭제되면 게시물 같이 삭제
);

-- 카테고리 임시 생성
insert into category(cname) value ('노하우');
select *from category;



