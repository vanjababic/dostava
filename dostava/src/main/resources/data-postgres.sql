
insert into "users" (rolee, id, email, password, firstName, lastName, address, phone, city, country, enabled) values ('kupac', nextval('seq_user'), 'fff', '$2y$10$1p9FJ4b6sWPs97ACLIeG8.5VRhK4.4roqBGVI6PQjmnOyKM2jCwou', 'Pera', 'Peric', 'Dunavska', '060111111', 'Novi Sad', 'Srbija', true);
insert into "users" (rolee, id, email, password, firstName, lastName, address, phone, city, country, enabled) values ('kuvar', nextval('seq_user'), 'sss', '$2y$10$1p9FJ4b6sWPs97ACLIeG8.5VRhK4.4roqBGVI6PQjmnOyKM2jCwou', 'Dejan', 'Deki', 'Dunavska', '060111111', 'Novi Sad', 'Srbija', true);
insert into "users" (rolee, id, email, password, firstName, lastName, address, phone, city, country, enabled) values ('dostavljac', nextval('seq_user'), 'qqq', '$2y$10$1p9FJ4b6sWPs97ACLIeG8.5VRhK4.4roqBGVI6PQjmnOyKM2jCwou', 'Mika', 'Mikic', 'Dunavska', '060111112', 'Novi Sad', 'Srbija', true);


INSERT INTO AUTHORITY (name) VALUES ('ROLE_KUPAC');
INSERT INTO AUTHORITY (name) VALUES ('ROLE_KUVAR');
INSERT INTO AUTHORITY (name) VALUES ('ROLE_DOSTAVLJAC');

INSERT INTO USER_AUTHORITY (user_id, authority_id) VALUES (1, 1);
INSERT INTO USER_AUTHORITY (user_id, authority_id) VALUES (2, 2);
INSERT INTO USER_AUTHORITY (user_id, authority_id) VALUES (3, 3);