
DROP TABLE CUSTOMER;

CREATE TABLE CUSTOMER(
	ID VARCHAR2(500) PRIMARY KEY,
	PASSWORD VARCHAR2(500) NOT NULL,
	NAME VARCHAR2(500) NOT NULL
);

INSERT INTO CUSTOMER VALUES('admin', 'admin1234', '문희수');

SELECT ID, PASSWORD, NAME FROM CUSTOMER;
