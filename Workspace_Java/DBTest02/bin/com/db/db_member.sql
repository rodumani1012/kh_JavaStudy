
CREATE SEQUENCE MEMBERSQ; --INSERT 할때마다 M_NO를 1씩 증가시켜줌

CREATE TABLE TB_MEMBER(
	M_NO NUMBER PRIMARY KEY,
	M_NAME VARCHAR2(20) NOT NULL,
	M_AGE NUMBER NOT NULL,
	M_GENDER VARCHAR2(2)
		CHECK(M_GENDER IN('M', 'F')) NOT NULL,
	M_LOCATION VARCHAR2(100),
	M_JOB VARCHAR2(10),
	M_TEL VARCHAR2(20),
	M_EMAIL VARCHAR2(20)
);

INSERT INTO TB_MEMBER
VALUES(MEMBERSQ.NEXTVAL, '관리자', 100, 'M', '서울시 강남구', '관리자', '010-1234-5678', 'ADMIN@ADMIN.COM');

SELECT * FROM TB_MEMBER;
