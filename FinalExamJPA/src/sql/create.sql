 
DROP TABLE IF EXISTS EMPLOYEE;

create table EMPLOYEE( ID int primary key AUTO_INCREMENT NOT NULL, 
						FIRST_NAME varchar(25),
						LAST_NAME varchar(25),
						AGE BIGINT,
						EMPLOYEENUMBER BIGINT,
						TITLE varchar(25)
					);