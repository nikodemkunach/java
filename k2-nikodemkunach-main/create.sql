create table address (id integer not null, city varchar(255), postal_code varchar(255), street varchar(255), person_id integer, primary key (id));
create table person (id integer not null, first_name varchar(255), last_name varchar(255), primary key (id));
alter table address add constraint FK81ihijcn1kdfwffke0c0sjqeb foreign key (person_id) references person;
create table address (id integer not null, city varchar(255), postal_code varchar(255), street varchar(255), person_id integer, primary key (id));
create table person (id integer not null, first_name varchar(255), last_name varchar(255), primary key (id));
alter table address add constraint FK81ihijcn1kdfwffke0c0sjqeb foreign key (person_id) references person;
