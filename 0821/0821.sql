--테이블 생성하기
CREATE TABLE DEPT_TEMP AS SELECT * FROM DEPT;
SELECT * FROM DEPT_TEMP ;
-- 테이블 삭제 DROP TABLE 테이블이름

-- INSERT INTO 테이블 이름 (열1, 열2, 열3) VALUES (들어갈 내용1, 들어갈내용2, 들어갈내용3)
INSERT INTO DEPT_TEMP (DEPTNO, DNAME, LOC) VALUES (50, 'DATABASE', 'SEOUL')
-- 테이블 만들 때 설정한 열 순서대로 , 열지정없이 데이터 추가 가능(비권장)
INSERT INTO DEPT_TEMP VALUES(60, 'NETWORK', 'BUSAN');
-- NULL추가하기
INSERT INTO DEPT_TEMP(DEPTNO,DNAME,LOC) VALUES (70, 'WEB','NULL');
INSERT INTO DEPT_TEMP(DEPTNO,DNAME,LOC) VALUES (70, 'WEB',' ');
-- 열 데이터를 넣지 않으면 해당 데이터 NULL
INSERT INTO DEPT_TEMP(DEPTNO,LOC) VALUES (90,'INCHEON');

-- 테이블의 골격만 만들기 WHERE의 값을 FALSE로 만들기 1,1이 같지않다 X
CREATE TABLE EMP_TEMP AS SELECT * FROM EMP WHERE 1<>1;
SELECT * FROM EMP_TEMP;
-- 날짜데이터 입력 'XXXX/XX/XX' OR 'XXXX-XX-XX'
INSERT INTO EMP_TEMP(EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO) VALUES (9999, '홍길동', 'PRESIDENT', NULL, '2023/01/01', 5000, 1000, 10);
INSERT INTO EMP_TEMP(EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO) VALUES (9999, '고길동', 'MANAGER', 9999, '2023-02-01', 4000, NULL, 20);
--날짜 다른 순서로 입력 TO DATE 함수 사용
INSERT INTO EMP_TEMP(EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO) VALUES (2111, '이순신', 'GENERAL', 9999, TO_DATE('07/01/2023','DD/MM/YYYY'), 3000, NULL, 25);
-- SYSDATE를 사용하여 날짜 입력(현재 시간)
INSERT INTO EMP_TEMP(EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO) VALUES (3111,'심청이', 'MANAGER', 9999, SYSDATE, 4000, NULL, 33);

-- 서브쿼리를 사용하여 여러 데이터 추가하기, 
INSERT INTO EMP_TEMP(EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO) 
SELECT E.EMPNO, E.ENAME, E.JOB, E.MGR, E.HIREDATE, E.SAL, E.COMM, E.DEPTNO FROM EMP E, SALGRADE S WHERE E.SAL BETWEEN S.LOSAL AND S.HISAL AND S.GRADE=1;

-- 지역에 맞는 데이터 표기방식 확인 ↓
SELECT * FROM NLS_SESSION_PARAMETERS;

-- UPDATE 테이블명  SET - WHERE(TRUE 행만 변경)
CREATE  TABLE DEPT_TEMP2 AS SELECT * FROM DEPT;
SELECT * FROM DEPT_TEMP2 ;
UPDATE  DEPT_TEMP2 SET DNAME ='DATABASE', LOC='SEOUL' WHERE DEPTNO = 40;
-- 서브쿼리를 사용하여 UPDATE 하기
UPDATE DEPT_TEMP2 SET(DNAME, LOC) = (SELECT DNAME, LOC FROM DEPT WHERE DEPTNO=40) WHERE DEPTNO =40;
UPDATE  DEPT_TEMP2 SET LOC = 'SEOUL' WHERE DEPTNO = (SELECT DEPTNO FROM DEPT_TEMP2 WHERE DNAME ='OPERATIONS');

CREATE TABLE EMP_TEMP2 AS SELECT * FROM EMP;
SELECT * FROM EMP_TEMP2;

-- DELETE [FROM] 테이블이름 WHERE [삭제할 대상 행을 선별하기 위한 조건식];
DELETE FROM EMP_TEMP2 WHERE JOB='MANAGER';
-- 서브쿼리를 사용하여 데이터를 삭제하기
DELETE FROM EMP_TEMP2 WHERE EMPNO IN(SELECT E.EMPNO FROM EMP_TEMP2 E, SALGRADE S WHERE E.SAL BETWEEN S.LOSAL AND S.HISAL AND S.GRADE=3 AND DEPTNO=30);

SELECT E.EMPNO FROM EMP_TEMP2 E, SALGRADE S WHERE E.SAL BETWEEN S.LOSAL AND S.HISAL AND S.GRADE=3 AND DEPTNO=30);
SELECT E.EMPNO FROM EMP_TEMP2 E JOIN SALGRADE S ON(E.SAL BETWEEN S.LOSAL AND S.HISAL) WHERE S.GRADE 3 AND DEPTNO =30;

-- 테이블 전체 데이터 삭제하기
DELETE FROM EMP_TEMP2 ;
SELECT * FROM EMP_TEMP2 ;

--ROWID, ROWNUM --> 의사(PESUDO) 컬럼
SELECT ROWID, ROWNUM, E.*FROM EMP E;
ORDER BY E.HIREDATE;
  