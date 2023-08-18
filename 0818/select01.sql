SELECT  * FROM EMP;

-- 주석 달기 컨트롤 슬래시 ctrl + /

-- SELECT + 호출 하고 싶은 부분 열 이름(projection) + FROM + 속한 테이블 명
SELECT  EMPNO, ENAME, DEPTNO
FROM emp;

-- 같은 번호 = 같은 부서라는 뜻
SELECT DEPTNO FROM EMP;

-- 중복 없이 출력 
SELECT  DISTINCT  DEPTNO FROM EMP;

-- 두 프로젝션의 조합이 유일한 것들 배열
SELECT  DISTINCT  JOB, DEPTNO FROM emp;

--SAL*12+COMM 실제로는 없지만 즉석으로 보기위해 생성(연봉 데이터), 
--null(알수 없는 값)에 대한 사칙연산 -> null로 처리됨(알 수 없음)
--NULL에 대한 모든 산술 연산 결과는 NULL
SELECT  ENAME, SAL, SAL*12+COMM, COMM FROM EMP;

--SAL*12+COMM 을 별칭(ANNSAL)으로 지정
SELECT  ENAME, SAL, SAL*12+COMM AS ANNSAL, COMM FROM EMP;

--ORDER BY 정렬기능, 디폴트는 오름 차순(ASC), 내림차순(DESC)
SELECT  * FROM EMP ORDER BY SAL;
SELECT  * FROM EMP ORDER BY SAL DESC;

--1순위 정렬에서 동률인 경우 2순위 정렬에서 다른 정렬방식 지정 (1순위 DEPTNO 오름차순, 2순위 SAL 내림차순)
SELECT * FROM EMP ORDER BY DEPTNO ASC, SAL DESC;
SELECT HIREDATE  FROM EMP ORDER BY HIREDATE DESC;

--필요한 데이터만 출력하는 WHERE 절 ,부서번호가 30인 것만 출력
SELECT * FROM EMP WHERE DEPTNO =30;
SELECT * FROM DEPT WHERE DEPTNO=30;

--여러개의 조건을 만족하는 데이터를 출력 (AND,OR 연산자), (큰따옴표 X), 데이터는 대소문자를 구분 한다.
SELECT * FROM EMP WHERE DEPTNO =30 AND JOB = 'SALESMAN';
SELECT * FROM EMP WHERE DEPTNO =30 OR JOB = 'CLERK' ORDER BY DEPTNO, ENAME ;

--WHERE 에 산술 연산자도 활용 가능
SELECT * FROM EMP WHERE SAL*12 =36000;
SELECT * FROM EMP WHERE SAL > 2000 ORDER BY ENAME;
SELECT * FROM EMP WHERE ENAME >= 'F';

--등가 비교 연산자 (!=, <>, ^=) 모두 다르다는 뜻
SELECT * FROM EMP WHERE ENAME != 'SMITH';
SELECT * FROM EMP WHERE NOT SAL = 3000;

-- IN 연산자, IN()안에 있는 것 들중 하나이면 출력, <-> NOT IN
SELECT * FROM EMP WHERE JOB ='MANAGER' OR JOB = 'SALESMAN' OR JOB = 'CLERK';
SELECT * FROM EMP WHERE JOB IN('MANAGER', 'SALESMAN', 'CLERK');

SELECT * FROM EMP WHERE JOB != 'MANAGER' AND JOB <> 'SALESMAN' AND JOB ^='CLERK';
SELECT * FROM EMP WHERE JON NOT IN ('MANAGER', 'SALESMAN', 'CLERK');

-- 범위 검색(2000이상 3000이하),BETWEEN A AND B(A이상 B이하), 이 범위 밖에 있는 내용 출력 NOT BETWEEN A AND B
SELECT * FROM EMP WHERE SAL >= 2000 AND SAL <= 3000;
SELECT * FROM EMP WHERE SAL BETWEEN 2000 AND 3000;

-- 일부 문자열이 포함된 데이터 조회 LIKE + 패턴(_,%) _-> 글자 한개, % -> 0개이상,( %키워드% )
SELECT * FROM EMP WHERE ENAME LIKE '_L%'; 
SELECT * FROM EMP WHERE ENAME LIKE '%L%'; 
SELECT * FROM EMP WHERE ENAME NOT LIKE '%L%';

--IS NULL 연산자, NULL인 것 찾기 / NULL이 아닌 것 찾기
SELECT * FROM EMP WHERE COMM IS NULL;
SELECT * FROM EMP WHERE COMM IS NOT NULL;


 
