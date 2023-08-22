-- CREATE TABLE 소유계정(SCHEMA이름) 테이블 이름(열N 이름 + 열N 자료형(최대자릿수))

CREATE TABLE EMP_DDL(
EMPNO NUMBER(4),
--CHAR(길이고정,크기고정), VARCHAR2(최대 길이,크기 유동적), VARCHAR (X), VARCHAR2를 사용하면된다.
ENAME VARCHAR2(10),
JOB VARCHAR2(9),
MGR NUMBER(4),
HIREDATE DATE,
--(7,2) ->(전체자리수, 소수점자리수) -> XXXXX.XX 라는 뜻
SAL NUMBER(7,2),
COMM NUMBER(7,2),
DEPTNO NUMBER(2)
 );

 SELECT * FROM EMP_DDL;

-- 다른 테이블의 일부를 복사하여 테이블 생성하기

SELECT * FROM EMP_DDL_30;
 
CREATE TABLE EMP_DDL_30 AS SELECT * FROM EMP WHERE DEPTNO = 30;

--다른 스키마의 테이블 보기 XX.XXX
SELECT * FROM HR.EMPLOYEES;
-- 테이블 명 MEMBER (userid, password, email)
-- HR.EMPLOYEES EMAIL -> USERID
-- PASSWORD -> USERID와 동일한 값
-- EMAIL -> 기존 EMAIL에 소문자로 변경 후 @galapagos.org 추가
-- 문자열 결합 : || 
CREATE TABLE MEMBER AS
(SELECT E.EMAIL USERID, E.EMAIL PASSWORD, LOWER(EMAIL)||'@galapagos.org' EMAIL FROM HR.EMPLOYEES E );

SELECT * FROM MEMBER;

-- UPDATE문을 사용하여 USERID와 PASSWORD를 소문자로 변경
UPDATE MEMBER SET PASSWORD = LOWER(PASSWORD), USERID = LOWER(USERID);

CREATE TABLE EMP_ALTER AS SELECT * FROM EMP;
SELECT * FROM EMP_ALTER;
--ALTER 명령어로 HP 열 추가하기 (ALTER + TABLE + TABLE명 + ADD + 컬럼명 + 컬럼타입)
ALTER TABLE EMP_ALTER ADD HP VARCHAR2(20);
-- 컬럼명 바꾸기(RENAME COLUMN)
ALTER TABLE EMP_ALTER RENAME COLUMN HP TO TEL;
-- 열의 자료형을 변경하기 MODIFY (EMPNO의 길이를 5로 늘리기)
-- 1. 기존 컬럼에 데이터가 없는 경우 -> 항상 OK, 
-- 2.기존 컬럼에 데이터가 있는 경우 -> 타입이 같아야하고 길이는 늘어나는 것만 허용! (정보 손실 X)
ALTER TABLE EMP_ALTER MODIFY EMPNO NUMBER(5);
-- 특정 열을 삭제할 때 사용하는 DROP
ALTER TABLE EMP_ALTER DROP COLUMN TEL;
-- 테이블 이름 변경하기
RENAME EMP_ALTER TO EMP_RENAME;
SELECT * FROM EMP_RENAME;
-- 테이블의 데이터를 삭제하는 TRUNCATE DELETE FROM -> DML, TRUNCATE,DROP ->DDL(바로 커밋,롤백불가)
TRUNCATE TABLE EMP_RENAME;
DROP TABLE EMP_RENAME;

SELECT  ROWID, E.* FROM EMP E;
