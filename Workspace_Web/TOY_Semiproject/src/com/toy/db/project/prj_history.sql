DROP TABLE
	PRJ_HISTORY;

CREATE TABLE
	PRJ_HISTORY( PRJ_NUM NUMBER REFERENCES PRJ_INFO(PRJ_NUM) ON DELETE CASCADE,
	HISTORY_RECORD VARCHAR2(4000) NOT NULL,
	HISTORY_CREATE DATE NOT NULL);

SELECT
	*
FROM
	PRJ_HISTORY;