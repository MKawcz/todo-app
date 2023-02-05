drop table if exists projects;
create table projects(
    id bigint primary key auto_increment,
    description varchar(100) not null
);
drop table if exists projects_steps;
create table project_steps(
    id bigint primary key auto_increment,
    description varchar(100) not null,
    days_to_deadline int not null,
    project_id bigint not null,
    foreign key (project_id) references projects(id)
);
alter table task_groups add column project_id bigint null;
alter table task_groups add foreign key (project_id) references projects (id);