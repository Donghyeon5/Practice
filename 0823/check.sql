CREATE TABLE TABLE_CHECK(
	LOGIN_ID VARCHAR2(20) CONSTRAINT TBLCK_LGNID_PK PRIMARY KEY,
	LOGIN_PWD VARCHAR2(20) CONSTRAINT TBLCK_LGNPW_CK CHECK(LENGTH(LOGIN_PWD) > 3),
	TEL VARCHAR(20)
);

SELECT * FROM TABLE_CHECK;

INSERT INTO TABLE_CHECK VALUES('TEST_ID','123','010-1111-1111'); --오류 발생 PW 3보다 길어야함
INSERT INTO TABLE_CHECK VALUES('TEST_ID','1234','010-1111-1111');

SELECT OWNER, CONSTRAINT_NAME, CONSTRAINT_TYPE, TABLE_NAME FROM USER_CONSTRAINTS WHERE TABLE_NAME LIKE 'TABLE_CHECK';

--DEFAULT
CREATE TABLE TABLE_DEFAULT(
	LOGIN_ID VARCHAR2(20) CONSTRAINTS TBLDF_LGNID_PK PRIMARY KEY,
	LOGIN_PWD VARCHAR2(20) DEFAULT '1234',
	TEL VARCHAR2(20),
	REG_DATE DATE DEFAULT SYSDATE,
	UPDATE_DATE DATE DEFAULT SYSDATE
);
INSERT INTO TABLE_DEFAULT (LOGIN_ID, LOGIN_PWD, TEL)
VALUES('TEST_ID', NULL, '010-1111-1111');

INSERT INTO TABLE_DEFAULT (LOGIN_ID,TEL)
VALUES('TEST_ID2','010-1111-1112');

SELECT * FROM TABLE_DEFAULT;
DROP TABLE TABLE_DEFAULT;

SELECT * FROM DICTIONARY;
SELECT TABLE_NAME FROM USER_TABLES;  --계정이 가지고있는 객체 정보 살펴보기
SELECT OWNER, TABLE_NAME FROM ALL_TABLES; --SCOTT 계정이 사용할 수 있는 객체 정보 살펴보기

-- SCOTT 계정이 소유한 인덱스 정보 알아보기(SCOTT 계정일 때)
SELECT * FROM USER_INDEXES;
-- SCOTT 계정이 소유한 인덱스 컬럼 정보 알아보기
SELECT * FROM USER_IND_COLUMNS;

-- 인덱스 생성 CREATE INDEX 인덱스 이름 ON 테이블이름(열이름1, 열이름2,....)
-- 검색속도가 느려지면 해당 열에 INDEX를 두어 그 열만 따로 데이터 조회하기
CREATE INDEX IDX_EMP_SAL ON EMP(SAL);

SELECT * FROM USER_IND_COLUMNS;

DROP INDEX IDX_EMP_SAL;

-- VIEW
-- CREATE VIEW 뷰이름(열이름...) AS(SELECT 문) 

-- 부서번호가 20인 사원들의 정보가 담긴 뷰 생성
CREATE VIEW VM_EMP20 AS(SELECT EMPNO,ENAME,JOB,DEPTNO FROM EMP WHERE DEPTNO=20);

SELECT * FROM USER_VIEWS;

SELECT * FROM VM_EMP20;

-- 인라인뷰 TOP-N 문제 T0P N을 찾고 싶을때 < , <= 만 사용 가능
SELECT ROWNUM,E.* FROM EMP E ORDER BY SAL ASC; --SAL의 오름차순으로 ROWNUM이 순서대로 진행X
SELECT ROWNUM,E.* FROM (SELECT * FROM EMP E ORDER BY SAL DESC) E; --내림차순 후에 그 정보 순서대로 ROWNUM을 매기면 순위로 해석 가능
SELECT ROWNUM,E.* FROM (SELECT * FROM EMP E ORDER BY SAL DESC) E WHERE ROWNUM <= 3; --상위 3명

-- VIEW로 만들어준 후 모든 연산자 사용 가능, 중복 생성 오류를 막아주는 REPLACE
CREATE OR REPLACE VIEW EMP_SAL_RANK AS 
	SELECT  ROW_NUMBER() OVER(ORDER BY SAL DESC) SEQ, E.* 
		FROM EMP E; --SQL 제공함수로 연봉순 정렬
		
SELECT * FROM EMP_SAL_RANK WHERE SEQ BETWEEN 3 AND 5;
SELECT * FROM EMP_SAL_RANK WHERE SEQ > 5;

-- SAL로 내림차순 정렬
-- SEQ, EMPNO, EMPNAME,DEPTNO,DEPTNAME을 가지는 뷰 생성
CREATE OR REPLACE VIEW EMP_SAL_RANK_ETC AS
	SELECT 
	ROW_NUMBER() OVER(ORDER BY SAL DESC) SEQ, E.EMPNO, E.ENAME, D.DEPTNO, D.DNAME
	FROM  EMP E JOIN DEPT D ON(D.DEPTNO = E.DEPTNO);

-- VIEW의 이름만 알면 간단하게 데이터 로드 가능, ROWNUM의 컬럼화, 구간 검사 가능하도록
SELECT * FROM EMP_SAL_RANK_ETC;
SELECT * FROM EMP_SAL_RANK_ETC WHERE SEQ BETWEEN 5 AND 10;





























