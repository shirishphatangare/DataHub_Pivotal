DROP TABLE IF EXISTS Employee;
create table Employee (id integer primary key,
 firstname varchar(155),
 lastname varchar(155),
 role varchar(155),
 manager integer,
 phone varchar(50),
 email varchar(100),
 address1 varchar(100),
 address2 varchar(100),
 city varchar(100),
 state varchar(100),
 zip varchar(100),
 country varchar(100)
);