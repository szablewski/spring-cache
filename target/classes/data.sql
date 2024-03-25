drop TABLE if exists articles;
drop TABLE if exists users;

CREATE TABLE IF NOT EXISTS users
(
    user_id    serial    NOT NULL primary key,
    email      varchar(180),
    first_name varchar(180),
    last_name  varchar(180),
    created    timestamp NOT NULL,
    updated    timestamp default null
);

CREATE TABLE IF NOT EXISTS articles
(
    article_id serial    NOT NULL primary key,
    title      varchar(255),
    content    varchar(255),
    user_id    bigint,
    created    timestamp NOT NULL,
    updated    timestamp default null,
    CONSTRAINT fk_user_Id
        FOREIGN KEY (user_id)
            REFERENCES users (user_id)
);

INSERT INTO users (user_id, email, first_name, last_name, created)
VALUES (1, 'j.kowtest@mail.com', 'Jan', 'Kowalski', now()),
       (2, 'f.zaorski123@mail.com', 'Filip', 'Zaorski', now()),
       (3, 'zlwska123@mail.com', 'Zosia', 'Lewandowska', now());

INSERT INTO articles (article_id, title, content, user_id, created)
VALUES (1, 'Test title', 'Test content first', 1, now()),
       (52, 'Test title 2', 'Test content 2', 1, now()),
       (103, 'Test title 3', 'Test content 4', 1, now()),
       (154, 'Test title 4', 'Test content 5', 1, now()),
       (205, 'Test title 5', 'Test content 6', 1, now()),
       (256, 'Test title 6', 'Test content 7', 1, now()),
       (307, 'Test title 7', 'Test content 8', 1, now()),
       (358, 'Test title 8', 'Test content 9', 1, now()),
       (409, 'Test title 9', 'Test content 10', 3, now()),
       (460, 'Test title 10', 'Test content first', 2, now()),
       (511, 'Test title 11', 'Test content first', 2, now()),
       (562, 'Test title 12', 'Test content first', 2, now()),
       (613, 'Test title 13', 'Test content first', 2, now()),
       (664, 'Test title 14', 'Test content first', 2, now());