use glory_db;

use world;

select * from city order by name limit 0,10; -- 1번째 페이지 목록얻기
select * from city order by name limit 10,10; -- 2번째 페이지 목록얻기
select count(*) from city;

select now(); -- from 절 없이 실행시키면 한 행만 실행
select now(), sysdate(); 

use glory_db;
select * from travel order by region,title;

-- 페이지네이션
select * from travel order by region, title limit 30,10; -- 0번째부터 10개까지