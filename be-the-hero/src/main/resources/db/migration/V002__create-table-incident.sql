create table incident(
	id varbinary(16) primary key not null,
	title varchar(255) not null,
	description varchar(255) not null,
	value decimal(10,2) not null,
	ong_id varbinary(16) not null
);

alter table incident add constraint fk_incident_ong
foreign key (ong_id) references ong (id);