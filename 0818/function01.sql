-- 함수 연습

-- 대소문자를 바꿔주는 함수(UPPER,LOWER,INITCAP)
SELECT ENAME, UPPER(ENAME),LOWER(ENAME), INITCAP(ENAME) FROM EMP; 
SELECT * FROM EMP WHERE UPPER(ENAME) = UPPER('smith');
SELECT * FROM EMP WHERE UPPER(ENAME) LIKE UPPER('%smi%');

-- 두 문자열 데이터를 합치는 CONCAT 함수 (||)
SELECT CONCAT(EMPNO,ENAME),CONCAT(EMPNO,CONCAT(':', ENAME)) FROM EMP WHERE ENAME ='SMITH';
SELECT  EMPNO || ENAME, EMPNO|| ':' || ENAME FROM EMP WHERE ENAME ='SMITH';

-- 결과 테이블을 하나만 나오도록 할 때 DUAL
SELECT ROUND(1.234) FROM EMP;
SELECT ROUND(1.234) FROM DUAL;
SELECT * FROM DUAL;

-- 날짜,시간 데이터를 다룰때 SYSDATE
SELECT SYSDATE AS NOW, SYSDATE-1 AS YESTERDAY,SYSDATE+1 AS TOMORROW FROM DUAL;

--날짜,숫자데이터를 문자 데이터로변환, SYSDATE 날짜 형식 지정하여 출력
SELECT TO_CHAR(SYSDATE, 'YYYY/MM/DD HH24:MI:SS') AS 현재날짜시간 FROM DUAL;
-- 특정 날짜에 대한 문자열 표현으로 대체 가능
SELECT * FROM EMP WHERE HIREDATE = '1981-12-03';
-- 1981년 입사자들만 찾기
SELECT * FROM EMP WHERE HIREDATE BETWEEN '1981-01-01' AND '1981-12-31';

-- NVL(NULL VALUE) NULL을 어떻게 취급할 것인가? NVL(COMM,0)->COMM의 NULL을 0으로 계산
SELECT EMPNO,ENAME,SAL,COMM,SAL+COMM,NVL(COMM, 0),SAL+NVL(COMM, 0) FROM EMP;
-- 연봉 계산
SELECT SAL*12+NVL(COMM,0) FROM EMP;
-- 연봉 순으로 오름차순 + 연봉 별칭 주기 (별칭에 공백 줄 시에 ""필요)
SELECT EMPNO,ENAME,SAL,COMM,SAL*12+NVL(COMM,0) AS "ANN SAL" FROM EMP ORDER BY "ANN SAL";