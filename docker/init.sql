CREATE SCHEMA IF not exists task_schema;

CREATE TABLE IF NOT EXISTS tasks_schema.task
(
    id  bigint primary key,
    title varchar(255) not null,
    description varchar(255) not null,
    priority INTEGER not null
)
