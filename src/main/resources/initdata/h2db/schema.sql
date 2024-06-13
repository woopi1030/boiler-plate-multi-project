DROP TABLE tb_sample IF EXISTS;

CREATE TABLE tb_sample ( 
	id int not null AUTO_INCREMENT,
	name varchar(255) not null,
    status varchar(255) not null,
    created_at DATETIME(6) not null,
    created_by VARCHAR(255) not null,
    updated_at DATETIME(6) not null,
    updated_by VARCHAR(255) not null,
	primary key (id) 
);