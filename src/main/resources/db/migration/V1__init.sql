DROP TABLE IF EXISTS users;

CREATE TABLE users
(
    id         BIGINT AUTO_INCREMENT PRIMARY KEY,
    username   VARCHAR(50)  NOT NULL UNIQUE,
    email      VARCHAR(100) NOT NULL UNIQUE,
    password   VARCHAR(255) NOT NULL,
    created_at TIMESTAMP    NOT NULL,
    updated_at TIMESTAMP    NOT NULL,
    role       VARCHAR(20)  NOT NULL
);

INSERT INTO users (username, email, password, created_at, updated_at, role)
VALUES ('admin', 'admin@example.com',
        '$2a$10$K2Xe21mP9lw78zUUryIRH.jHlNG.p2uGHswkM6ycQq4jquncbyIVG',
        CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'ROLE_ADMIN'),

       ('moderator', 'moderator@example.com',
        '$2a$10$K2Xe21mP9lw78zUUryIRH.jHlNG.p2uGHswkM6ycQq4jquncbyIVG',
        CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'ROLE_MODERATOR'),

       ('user1', 'user1@example.com',
        '$2a$10$K2Xe21mP9lw78zUUryIRH.jHlNG.p2uGHswkM6ycQq4jquncbyIVG',
        CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'ROLE_USER'),

       ('user2', 'user2@example.com',
        '$2a$10$K2Xe21mP9lw78zUUryIRH.jHlNG.p2uGHswkM6ycQq4jquncbyIVG',
        CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'ROLE_USER');