create table ong(
	id varbinary(16) primary key not null,
	name varchar(200) not null,
	email varchar(150) not null,
	whatsapp varchar(11) not null,
	city varchar(255) not null,
	uf varchar(2) not null
);