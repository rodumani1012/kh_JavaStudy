
--Q1) 사원테이블에서 사원 이름과 월급을 구하되, 
--월급을 내림차순으로 출력하자.

SELECT ENAME, SAL
FROM EMP
ORDER BY SAL DESC;

--Q2) 사원테이블에서 직업별 평균 월급을 출력하되 
--컬럼 ALIAS를 '평균' 으로 하고
--평균 월급이 높은 순으로 정렬하자.

SELECT AVG(SAL) AS "평균"
FROM EMP
GROUP BY JOB
ORDER BY AVG(SAL) DESC;

--Q3) 사원테이블에서 직업별 총 월급을 구하고, 
--총 월급이 5000 이상인 것만 출력하자.

SELECT SUM(SAL)
FROM EMP
HAVING SUM(SAL) >= 5000
GROUP BY JOB
ORDER BY SUM(SAL) DESC;


--Q4) 사원테이블에서 부서별 월급의 합을 구하고, 
--그 총합이 1000 이상인 것만 출력하자.

SELECT SUM(SAL)
FROM EMP
GROUP BY DEPTNO
HAVING SUM(SAL) >= 1000
ORDER BY SUM(SAL);




--Q1) 사원테이블에서 평균 월급을 출력하자.

SELECT AVG(SAL)
FROM EMP;

--Q2) 사원테이블에서 부서번호가 10인 부서에 
--근무하고 있는 사원들의 부서번호와 
--평균 월급을 출력하자.

SELECT DEPTNO, AVG(SAL)
FROM EMP
WHERE DEPTNO = 10
GROUP BY DEPTNO;

--Q3) 사원테이블에서 직업이 'SALESMAN'인 사원들의 
--평균 월급을 출력하자.

SELECT AVG(SAL)
FROM EMP
WHERE JOB = 'SALESMAN';

--Q4) 사원테이블에서 부서별 평균 월급을 출력하자.

SELECT DEPTNO,AVG(SAL)
FROM EMP
GROUP BY DEPTNO;


--Q5) 사원테이블에서 직업별 평균 월급을 출력하자.

SELECT JOB, AVG(SAL)
FROM EMP
GROUP BY JOB
ORDER BY 1 DESC;

--Q6) 사원 테이블에서 평균 커미션(COMM)을 출력하자.

SELECT AVG(COMM), AVG(NVL(COMM,0))
FROM EMP;


--Q7) 사원테이블에서 10번 부서의 최대 월급을 출력하자.

SELECT MAX(SAL)
FROM EMP
WHERE DEPTNO = 10;

--Q8) 사원테이블에서 부서별 최대 월급을 출력하자.

SELECT DEPTNO,MAX(SAL)
FROM EMP
GROUP BY DEPTNO;

SELECT * FROM EMP;

--Q9) 사원테이블에서 직업별 최대 월급을 출력하자.

SELECT JOB, MAX(SAL)
FROM EMP
GROUP BY JOB;

--Q10) 사원테이블에서 직업이 'SALESMAN'인 사원들 중 
--최대월급을 출력하자.

SELECT JOB,MAX(SAL)
FROM EMP
WHERE JOB='SALESMAN'
GROUP BY JOB;





--Q1) 사원 테이블에서 부서별 최대 월급을 출력하자.

SELECT MAX(SAL), DEPTNO
FROM EMP
GROUP BY DEPTNO;

--Q2) 사원테이블에서 직업별 최소 월급을 구하되, 
--직업이 'CLERK' 인 것만 출력하자.

SELECT JOB, MIN(SAL)
FROM EMP
WHERE JOB = 'CLERK'
GROUP BY JOB;

--Q3) 사원테이블에서 
--커미션이 책정된 사원은 모두 몇 명인지 출력하자.

SELECT COUNT(COMM)
FROM EMP;

--Q4) 사원테이블에서 직업이 'SALESMAN'이고 
--월급이 1000 이상인 사원의 이름과 월급을 출력하자.

SELECT ENAME, SAL
FROM EMP
WHERE JOB='SALESMAN'
AND SAL >= 1000;

--Q5) 사원테이블에서 부서별 평균 월급을 출력하되, 
--평균 월급이 2000보다 큰 부서의 부서번호와 
--평균 월급을 출력하자.

SELECT DEPTNO, AVG(SAL)
FROM EMP
HAVING AVG(SAL) >= 2000
GROUP BY DEPTNO;

--Q6) 사원테이블에서 직업이 'MANAGER' 인 사원을 
--출력하되, 
--월급이 높은 순으로 
--이름, 직업, 월급을 출력하자.(내림차순)

SELECT ENAME, JOB, SAL
FROM EMP
WHERE JOB = 'MANAGER'
ORDER BY 3 DESC;


--Q7) 사원테이블에서 CUBE를 사용하여 
--각 직업별 총 월급을 출력하되 
--월급이 낮은 순으로 출력하자.(오름차순)

SELECT JOB, SUM(SAL)
FROM EMP
GROUP BY CUBE(JOB)
ORDER BY SUM(SAL);


--Q8) 사원테이블에서 직업별 총 월급을 출력하되, 
--직업이 'MANAGER'인 사원들은 제외하고, 
--총 월급이 5000보다 큰 직업만 출력하자.

SELECT SUM(SAL),JOB
FROM EMP
WHERE JOB <> 'MANAGER'
HAVING SUM(SAL) >= 5000
GROUP BY JOB;

--Q9) 사원테이블에서 직업별 최대 월급을 출력하되, 
--직업이 'CLERK' 인 사원들은 제외하고, 
--총 월급이 2000 이상인 직업과 
--최대월급을 오름차순으로 정렬하여 출력하자.

SELECT JOB, MAX(SAL)
FROM EMP
WHERE JOB != 'CLERK'
HAVING SUM(SAL) >= 2000
GROUP BY JOB
ORDER BY MAX(SAL);

--Q10) 사원테이블에서 부서별 총 월급을 출력하되, 
--30번 부서를 제외하고, 
--총 월급이 8000 이상인 부서를 
--총 월급이 높은 순으로 출력하자.(내림차순)

SELECT DEPTNO, SUM(SAL)
FROM EMP
WHERE DEPTNO <> 30
HAVING SUM(SAL) >= 8000
GROUP BY DEPTNO
ORDER BY SUM(SAL) DESC;

--Q11) 사원테이블에서 부서별 평균 월급을 출력하되
--커미션이 책정된 사원만 구하고
--평균 월급이 1000 달러 이상인 부서만 구하고
--평균 월급이 높은 순으로 출력하자.(내림차순)

SELECT DEPTNO, AVG(SAL)
FROM EMP
WHERE COMM IS NOT NULL
HAVING AVG(SAL) >= 1000
GROUP BY DEPTNO
ORDER BY AVG(SAL) DESC;








--Q1) 사원 테이블에서 사원이름을 첫글자는 대문자로, 
--나머지는 소문자로 출력하자.

SELECT UPPER(SUBSTR(ENAME,1,1))
||LOWER(SUBSTR(ENAME,2))
FROM EMP;

SELECT INITCAP(ENAME)
FROM EMP;

--Q2) 사원테이블에서 사원이름을 출력하고, 
--이름의 두번째 글자부터 네번째 글자도 출력하자.

SELECT ENAME, SUBSTR(ENAME,2,3)
FROM EMP;

--Q3) 사원테이블에서 각 사원 이름의 철자 개수를 출력하자.

SELECT ENAME, LENGTH(ENAME)
FROM EMP;

--Q4) 사원테이블에서 각 사원 이름의 앞 글자 하나와 
--마지막 글자 하나만 출력하되, 소문자로 출력하라.

SELECT ENAME, LOWER(SUBSTR(ENAME,1,1)),
LOWER(SUBSTR(ENAME,-1))
FROM EMP;

--Q5) 3456.78을 소수점 첫번째 자리에서 
--반올림해서 출력하자.

SELECT ROUND(3456.78,0)
FROM DUAL;

--Q6) 사원테이블에서 사원이름과 
--근무일수(고용일 ~ 현재 날짜)를 출력하자.
--(한달을 30일로 계산)

SELECT ENAME,
TRUNC(MONTHS_BETWEEN(SYSDATE,HIREDATE)*30)
FROM EMP;

--Q7) 위 문제에서 근무일수를 '00년 00개월 00일' 형식으로 출력하자.
--예)
--ENAME 근무일수
--KING  00년 00개월 00일

SELECT ENAME,HIREDATE,
FLOOR((SYSDATE-HIREDATE)/365)||'년'||
FLOOR(MOD((SYSDATE-HIREDATE),365)/30)||'월'||
FLOOR(MOD(MOD((SYSDATE-HIREDATE),365),30))||'일' 
AS "근무일수"
FROM EMP;











