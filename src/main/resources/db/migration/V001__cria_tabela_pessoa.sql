create table pessoa (
	pessoa_id bigint not null auto_increment,
    email varchar(100) not null,
    primary key (pessoa_id)
)engine=InnoDB default charset=utf8mb4;