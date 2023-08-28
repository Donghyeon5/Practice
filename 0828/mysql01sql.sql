use mysql;
select  host,user from user;
create user 'glory'@'%' identified by '1234';
grant all privileges on world.* to 'glory'@'%';
commit;

-- glory_db 생성
create database glory_db;

-- glory 계정에게 glory_db 사용 권한 부여
grant all privileges on glory_db.* to 'glory'@'%';
commit;