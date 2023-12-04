CREATE TABLE IF NOT EXISTS tasks
(
    id        BIGINT AUTO_INCREMENT PRIMARY KEY,
    title      VARCHAR(255) NOT NULL,
    content     VARCHAR(255),
    status    BOOLEAN   DEFAULT TRUE,
    createdAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updatedAt TIMESTAMP
);
insert into tasks(title, createdAt)
values ('hello', now());
insert into tasks(title)
values ('world');

select *
from tasks;