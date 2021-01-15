create table aposta (
	aposta_id bigint not null auto_increment,
	pessoa_id bigint not null,
    primeiro_numero INTEGER not null,
    segundo_numero INTEGER not null,
    terceiro_numero INTEGER not null,
    quarto_numero INTEGER not null,
    quinto_numero INTEGER not null,
    sexto_numero INTEGER not null,
    data_criacao datetime(6) not null,
    primary key (aposta_id)
)engine=InnoDB default charset=utf8mb4;


alter table aposta add constraint fk_aposta_pessoa
foreign key (pessoa_id) references pessoa (pessoa_id);

