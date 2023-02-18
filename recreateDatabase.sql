CREATE TABLE authorities (
	id integer not null AUTO_INCREMENT,
    codename varchar(30) COLLATE utf8mb4_general_ci,
    name varchar(30) COLLATE utf8mb4_general_ci,
    PRIMARY KEY (id)
);

CREATE TABLE users (
	id integer NOT null AUTO_INCREMENT,
    nickname varchar(30) COLLATE utf8mb4_general_ci,
    password varchar(200) COLLATE utf8mb4_general_ci,
    authority_id integer not null,
    PRIMARY KEY (id),
    FOREIGN KEY (authority_id) REFERENCES authorities(id)
);

CREATE TABLE messages (
	id integer not null AUTO_INCREMENT,
    room_id integer,
    nickname_id integer not null,
    timestamp datetime,
    message text COLLATE utf8mb4_general_ci,
    PRIMARY KEY (id),
    FOREIGN KEY (nickname_id) REFERENCES users(id)
);

INSERT INTO authorities VALUES 
(1, 'REGULAR', 'User'),
(2, 'ADMIN', 'Administrator');

INSERT INTO users VALUES
(1, 'admin', '123123', 2),
(2, 'System', '111111', 2),
(3, 'Java Developer', '123123', 1),
(4, 'Sam', '123123', 1),
(5, 'Hollywood Undead', '123123', 1);