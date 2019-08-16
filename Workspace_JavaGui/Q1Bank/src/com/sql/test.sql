DROP SEQUENCE ACCOUNTSEQ;
DROP TABLE BANK;
DROP TABLE TRADE_LIST;

CREATE SEQUENCE ACCOUNTSEQ;
CREATE SEQUENCE ACC;

CREATE TABLE BANK(
   ACCOUNT VARCHAR2(300) PRIMARY KEY,
   NAME VARCHAR2(100) NOT NULL,
   PASSWORD VARCHAR2(300) NOT NULL,
   T_BALANCE NUMBER NOT NULL,
   REG_DATE DATE
);


CREATE TABLE TRADE_LIST(
   ACCOUNT VARCHAR2(300) ,
   TRADE_DATE DATE NOT NULL,
   SENDER VARCHAR2(100) NOT NULL,
   MESSAGE VARCHAR2(600),
   INPUT NUMBER,
   OUTPUT NUMBER,
   BALANCE NUMBER NOT NULL
);

ALTER TABLE TRADE_LIST ADD CONSTRAINT ACC_FK FOREIGN KEY (ACCOUNT)
REFERENCES BANK(ACCOUNT);
INSERT INTO BANK VALUES('01011111111','최준연','0000',100000,SYSDATE);
INSERT INTO BANK VALUES('01000000000','huisoo','0000',100000,SYSDATE);
INSERT INTO TRADE_LIST values('01000000000',SYSDATE,'�۱���','����',NULL,NULL,10000);

UPDATE BANK SET T_BALANCE=20000 WHERE ACCOUNT='01000000000';
SELECT * FROM TRADE_LIST ORDER BY TRADE_DATE;
SELECT * FROM BANK ORDER BY ACCOUNT;


SELECT ACCOUNT FROM BANK WHERE ACCOUNT=? AND PASSWORD=?;

insert into bank values('01011111111','문희수','1111',420000,'20180505');

insert into trade_list values('01011111111','181112','교통대금 출금',null,0,56800,363200);
insert into trade_list values('01011111111','181112','ATM입금',null,20000,0,383200);
INSERT INTO TRADE_LIST VALUES('01011111111','181210','sk텔레콤',null,0,38400,344800);
INSERT INTO TRADE_LIST VALUES('01011111111','181210','파리바게트(역삼)',null,25000,0,319800);
insert into trade_list values('01011111111','190103','문영수','1월용돈이다',200000,0,519800);
insert into trade_list values('01011111111','190114','교통대금 출금',null,0,56800,463000);
insert into trade_list values('01011111111','190120','훈련장려금', null, 116000, 0,579000);
insert into trade_list values('01011111111','190129','반디앤루니스', null, 0,33000,546000);
insert into trade_list values('01011111111','190208','캐시백', null, 2100, 0,546021 );
insert into trade_list values('01011111111','190215','교통대금 출금', null, 0, 90500,455521);
insert into trade_list values('01011111111','190208','카카오머니',null,0,20000,435521);
insert into trade_list values('01011111111','190208','우리ATM출금',null,0,100000,335521);
insert into trade_list values('01011111111','190215','교통대금 출금', null, 0, 90500,245021);
insert into trade_list values('01011111111','190224','훈련장려금', null, 102000,0,347021);
insert into trade_list values('01011111111','190227','뚜레쥬르',null,0,1500,345521);
insert into trade_list values('01011111111','190301','(주)바이더웨이',null,0,4500,341021);
INSERT INTO TRADE_LIST VALUES('01011111111','190302','문영수','아껴써라', 200000, 0,541021);
insert into trade_list values('01011111111','190315','교통대금 출금', null, 0, 77800, 463221);
insert into trade_list values('01011111111','190320','맥도날드(대치점)', null, 0, 11300,451921);
insert into trade_list values('01011111111','190327','훈련장려금', null, 102000, 0,553921);
insert into trade_list values('01011111111','190403','롯데쇼핑(잠실점)',null,0,8800,545121);
INSERT INTO TRADE_LIST VALUES('01011111111','190410','교통대금 출금', null, 0, 38400,506721);
insert into trade_list values('01011111111','190425','훈련장려금', null, 116000, 0,622721);
insert into trade_list values('01011111111','190428','입출금통장이자',null,360,0,623081);
insert into trade_list values('01011111111','190503','sk텔레콤',null, 0, 50000,573081);
insert into trade_list values('01011111111','190503','신한ATM입금',null,50000,0, 623081);
insert into trade_list values('01011111111','190504','한지수','모임회비',30000,0,653081);
insert into trade_list values('01011111111','190504','정서희','모임회비',30000,0,683081);
insert into trade_list values('01011111111','190505','코스트코(양재)', null,0,173000,510081);