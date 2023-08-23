CREATE TABLE DEPT_TCL AS SELECT * FROM DEPT;
-- SELECT TRANSACTION에 영향 X, 
--데이터의 수정에 해당하는 INSERT,UPDATE,DELETE -> TRANSACTION에 영향
SELECT * FROM DEPT_TCL; 

INSERT INTO DEPT_TCL VALUES(50, 'DATABASE','SEOUL');
UPDATE DEPT_TCL SET LOC ='BUSAN' WHERE DEPTNO = 40;
DELETE FROM DEPT_TCL WHERE DNAME ='RESEARCH';
ROLLBACK;
--커밋하면 롤백해도 돌아가지 않음
COMMIT;
DELETE FROM DEPT_TCL;
-- 가장 최근에 한 커밋의 모양으로 돌아감

ROLLBACK;
-- CREAT DROP ALTER 자동으로 커밋
DROP TABLE DEPT_TCL;