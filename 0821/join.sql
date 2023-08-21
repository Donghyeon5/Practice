-- FROM절에 여러 테이블 선언하기
--EMP(12개) DEPT(4개), 총 48개 조합 할 수 있는 모든 경우의 수 나옴
SELECT * FROM EMP,DEPT ORDER BY EMPNO ;

--열 이름을 비교하는 조건식으로 조인하기 (DEPTNO가 같은 것만 출력)
-- 등가 조인 EQUI JOIN 공통 컬럼을 선정하여 출력
SELECT * FROM EMP,DEPT WHERE EMP.DEPTNO = DEPT.DEPTNO ORDER BY EMPNO;
-- AMBIGUOUSLY, DEPTNO가 어디 소속의 DEPTNO를 말하는 건지 모호하다
SELECT EMPNO, ENAME, DEPTNO, DNAME, LOC FROM EMP E, DEPT D WHERE E.DEPTNO = D.DEPTNO ;
--DEPTNO가 어디 소속인지 밝혀 주기
SELECT EMPNO, ENAME, D.DEPTNO, DNAME, LOC FROM EMP E, DEPT D WHERE E.DEPTNO = D.DEPTNO ORDER BY D.DEPTNO ,E.EMPNO ;
-- 테이블의 별칭 설정
SELECT  * FROM EMP E, DEPT D WHERE E.DEPTNO = D.DEPTNO ORDER BY EMPNO ;
-- WHERE절에 추가로 조건식 넣어 출력하기
SELECT E.EMPNO, E.ENAME, E.SAL,D.DEPTNO,D.DNAME,D.LOC FROM EMP E, DEPT D WHERE  E.DEPTNO=D.DEPTNO  AND SAL >= 3000;

--비등가 조인
-- 급여 범위를 지정하는 조건식으로 조인하기
SELECT * FROM EMP E, SALGRADE S WHERE E.SAL BETWEEN S.LOSAL  AND S.HISAL ;
-- 급여 등급이 2등급인 조건식
SELECT * FROM EMP E, SALGRADE S WHERE (E.SAL BETWEEN S.LOSAL  AND S.HISAL) AND S.GRADE =2 ;
-- 같은 테이블을 두 번 사용하여 자체 조인하기 (별칭을 각각 다르게 배정하여 다른 테이블인 것 처럼 운용)
-- 각 사원의 상사명의 이름을 알고싶을때, MGR 과 EMPNO가 같은 번호일때만 출력, 같은 테이블을 별칭을 각각 다르게 운용
SELECT E1.EMPNO,E1.ENAME,E1.MGR,E2.EMPNO AS MGR_EMPNO, E2.ENAME AS MGR_ENAME FROM EMP E1, EMP E2 WHERE E1.MGR=E2.EMPNO;
-- KING의 정보가 있는 E1 을 기준으로 , KING의 상사가 없더라도 NULL로 표현 해주길 바랄때 E2에 +를 해준다는 느낌
SELECT E1.EMPNO,E1.ENAME,E1.MGR,E2.EMPNO AS MGR_EMPNO, E2.ENAME AS MGR_ENAME FROM EMP E1, EMP E2 WHERE E1.MGR=E2.EMPNO(+);
-- 부하직원이 없는 사원들 찾을 때 
SELECT E1.EMPNO,E1.ENAME,E1.MGR,E2.EMPNO AS MGR_EMPNO, E2.ENAME AS MGR_ENAME FROM EMP E1, EMP E2 WHERE E1.MGR(+)=E2.EMPNO ORDER BY E1.EMPNO ;
-- NATURAL JOIN 자동으로 공통열을 사용
SELECT E.EMPNO, E.ENAME, E.JOB, E.MGR, E.HIREDATE, E.SAL, E.COMM,DEPTNO, D.DNAME, D.LOC FROM EMP E NATURAL JOIN DEPT D ORDER BY DEPTNO, EMPNO;

SELECT E.EMPNO, E.ENAME, E.JOB, E.MGR, E.HIREDATE, E.SAL, E.COMM, DEPTNO, D.DNAME, D.LOC FROM EMP E JOIN DEPT D USING(DEPTNO) WHERE SAL >= 3000 ORDER BY DEPTNO, EMPNO;
-- JOIN ON 양식
SELECT E.EMPNO, E.ENAME, E.JOB, E.MGR, E.HIREDATE, E.SAL, E.COMM,E.DEPTNO, D.DNAME, D.LOC FROM EMP E JOIN DEPT D ON(E.DEPTNO = D.DEPTNO) WHERE SAL >= 3000 ORDER BY E.DEPTNO, EMPNO;
-- 왼쪽 외부조인을 (+)를 사용하지 않고 쓰기 SELECT E1.EMPNO,E1.ENAME,E1.MGR,E2.EMPNO AS MGR_EMPNO, E2.ENAME AS MGR_ENAME FROM EMP E1, EMP E2 WHERE E1.MGR=E2.EMPNO(+);
SELECT E1.EMPNO, E1.ENAME, E1.MGR,E2.EMPNO AS MGR_EMPNO,E2.ENAME AS MGR_ENAMEFROM FROM EMP E1 LEFT OUTER JOIN EMP E2 ON(E1.MGR = E2.EMPNO)ORDER BY E1.EMPNO;
-- 오른쪽 외부조인을 (+)를 사용하지 않고 쓰기 SELECT E1.EMPNO,E1.ENAME,E1.MGR,E2.EMPNO AS MGR_EMPNO, E2.ENAME AS MGR_ENAME FROM EMP E1, EMP E2 WHERE E1.MGR(+)=E2.EMPNO 
SELECT E1.EMPNO, E1.ENAME, E1.MGR,E2.EMPNO AS MGR_EMPNO,E2.ENAME AS MGR_ENAMEFROM FROM EMP E1 RIGHT OUTER JOIN EMP E2 ON(E1.MGR = E2.EMPNO)ORDER BY E1.EMPNO;
