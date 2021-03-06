DROP
	TABLE
		PAGEBOARD;

DROP
	SEQUENCE PAGESEQ;

CREATE
	SEQUENCE PAGESEQ;

CREATE
	TABLE
		PAGEBOARD(SEQ NUMBER PRIMARY KEY,
		TITLE VARCHAR2(100) NOT NULL,
		CONTENT VARCHAR2(4000) NOT NULL,
		CATEGORY VARCHAR2(50) NOT NULL);

SELECT
	*
FROM
	PAGEBOARD;

DELETE
FROM
	PAGEBOARD;

INSERT
	INTO
		PAGEBOARD
	VALUES(PAGESEQ.NEXTVAL,
	'TEST',
	'TESTCONTENT',
	'A');

INSERT
	INTO
		PAGEBOARD
	VALUES(PAGESEQ.NEXTVAL,
	'TEST',
	'TESTCONTENT',
	'B');

INSERT
	INTO
		PAGEBOARD
	VALUES(PAGESEQ.NEXTVAL,
	'TEST',
	'TESTCONTENT',
	'C');

SELECT
	ROWNUM AS RNUM,
	P.*
FROM
	PAGEBOARD P
WHERE
	CATEGORY = 'A';

DELETE
FROM
	PAGEBOARD
WHERE
	ROWNUM BETWEEN 1 AND 5;


SELECT
	P.*
FROM
	PAGEBOARD P
WHERE
	CATEGORY = 'B'
ORDER BY
	SEQ DESC;

SELECT * FROM
(SELECT ROWNUM AS RNUM, P.* FROM
		( SELECT *
		FROM PAGEBOARD
		WHERE CATEGORY = 'B'
		ORDER BY SEQ DESC
		) P )
		WHERE RNUM BETWEEN 5 AND 8;


SELECT *
		FROM PAGEBOARD
		WHERE CATEGORY = 'C' AND
			(
				(upper(CONTENT) like '%' || upper(47) || '%') or
				(upper(TITLE) like '%' || upper(47) || '%')
			)
