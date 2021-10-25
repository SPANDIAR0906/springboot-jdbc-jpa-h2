create table author (
id integer,
name varchar2(100 byte),
dob date,
gender varchar2(1 byte),
created_dt date,
modified_dt date,
PRIMARY KEY(ID)
);

insert into author (id, name, dob, gender, created_dt, modified_dt) values (10000, 'Jeffrey Archer', to_date('01-01-1955','mm-dd-yyyy'), 'M', SYSDATE(), SYSDATE());
insert into author (id, name, dob, gender, created_dt, modified_dt) values (10001, 'Sydney Shelton', to_date('04-12-1948','mm-dd-yyyy'), 'M', SYSDATE(), SYSDATE());
insert into author (id, name, dob, gender, created_dt, modified_dt) values (10002, 'Dan Brown', to_date('05-15-1965','mm-dd-yyyy'), 'M', SYSDATE(), SYSDATE());