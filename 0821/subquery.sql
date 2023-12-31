-- 서브쿼리 
-- 사원 이름이 jones인 사원의 급여
SELECT  SAL FROM EMP WHERE ENAME = 'JONES';
SELECT * FROM EMP WHERE SAL>2975;
-- 두 문장을 합치기 ,비교해야할 밸류값의 갯수가 같아야한다. 1개 -> 단일행 쿼리(결과가 1개의 행으로)
SELECT  * FROM EMP WHERE SAL > (SELECT SAL FROM EMP WHERE ENAME ='JONES');
-- JONES 보다 늦게 들어온 사람들 
SELECT * FROM EMP WHERE HIREDATE < (SELECT HIREDATE FROM EMP WHERE ENAME='JONES');
-- 평균 급여보다 많이 받는 사원 +20번 부서
SELECT * FROM EMP WHERE SAL>(SELECT AVG(SAL) FROM EMP) AND DEPTNO =20 ;

SELECT E.ENAME, D.DNAME, E.SAL FROM EMP E JOIN DEPT D ON (E.DEPTNO = D.DEPTNO) WHERE E.SAL>(SELECT AVG(SAL) FROM EMP) AND E.DEPTNO =20 ;

--IN 연산자 IN(이 중 하나라도 해당되는 정보)
SELECT * FROM EMP WHERE DEPTNO IN(20,30);
-- 각 부서별 최고급여와 동일한 급여를 받는 사원 정보 출력
SELECT * FROM EMP WHERE SAL IN (SELECT MAX(SAL) FROM EMP GROUP BY DEPTNO);

-- ANY,SOME 연산자 ()ㅎㅏ나라도 TRUE 가있으면 전체결과를 TRUE로 보겠다.
SELECT * FROM EMP WHERE SAL = ANY(SELECT MAX(SAL) FROM EMP GROUP BY DEPTNO );
SELECT * FROM EMP WHERE SAL = SOME(SELECT MAX(SAL) FROM EMP GROUP BY DEPTNO);

SELECT * FROM EMP WHERE SAL < ANY(SELECT SAL FROM EMP WHERE DEPTNO=30) ORDER BY SAL, EMPNO ;

-- ALL 모든 결과가 TRUE 여야 TRUE, 30번인 사원들의 최소급여보다 더 적은 급여를 받는 사원
SELECT * FROM EMP WHERE SAL < ALL (SELECT SAL FROM EMP WHERE DEPTNO =30);

-- EXIST 연산자 서브쿼리에 결과 값이 하나 이상 존재하면 TRUE, TRUE일 경우에만 메인 실행
SELECT * FROM EMP WHERE EXISTS(SELECT DNAME FROM DEPT WHERE DEPTNO =10);
SELECT * FROM EMP WHERE EXISTS(SELECT DNAME FROM DEPT WHERE DEPTNO =50);

SELECT * FROM EMP WHERE(DEPTNO, SAL) IN(SELECT DEPTNO,MAX(SAL) FROM EMP GROUP BY DEPTNO);

-- FROM 절에 사용하는 서브쿼리
SELECT E10.EMPNO, E10.ENAME, E10.DEPTNO, D.DNAME, D.LOC FROM (SELECT * FROM EMP WHERE DEPTNO=10) E10,(SELECT * FROM DEPT) D WHERE E10.DEPTNO=D.DEPTNO;
-- 가독성을 위해 WITH절 사용
WITH E10 AS (SELECT* FROM EMP WHERE DEPTNO=10), D AS(SELECT * FROM DEPT) SELECT E10.EMPNO, E10.ENAME, E10.DEPTNO, D.DNAME, D.LOC FROM E10, D WHERE E10.DEPTNO = D.DEPTNO;