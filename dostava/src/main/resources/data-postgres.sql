
insert into "objekat" (id, naziv, adresa) values (nextval('seq_objekat'), 'Loft', 'Mihajla Pupina 4');
insert into "objekat" (id, naziv, adresa) values (nextval('seq_objekat'), 'Barrique', 'Njegoseva 3');
insert into "objekat" (id, naziv, adresa) values (nextval('seq_objekat'), 'Masa', 'Obradoviceva 14');

insert into "users" (rolee, id, email, password, firstName, lastName, address, phone, city, country, enabled, adresa) values ('kupac', nextval('seq_user'), 'kor', '$2y$10$1p9FJ4b6sWPs97ACLIeG8.5VRhK4.4roqBGVI6PQjmnOyKM2jCwou', 'Pera', 'Peric', 'Dunavska', '060111111', 'Novi Sad', 'Srbija', true, 'Maksima Gorkog 4');
insert into "users" (rolee, id, email, password, firstName, lastName, address, phone, city, country, enabled, objekat_id) values ('kuvar', nextval('seq_user'), 'kuv', '$2y$10$1p9FJ4b6sWPs97ACLIeG8.5VRhK4.4roqBGVI6PQjmnOyKM2jCwou', 'Dejan', 'Deki', 'Dunavska', '060111111', 'Novi Sad', 'Srbija', true, 1);
insert into "users" (rolee, id, email, password, firstName, lastName, address, phone, city, country, enabled) values ('dostavljac', nextval('seq_user'), 'dos1', '$2y$10$1p9FJ4b6sWPs97ACLIeG8.5VRhK4.4roqBGVI6PQjmnOyKM2jCwou', 'Mika', 'Mikic', 'Dunavska', '060111112', 'Novi Sad', 'Srbija', true);
insert into "users" (rolee, id, email, password, firstName, lastName, address, phone, city, country, enabled) values ('dostavljac', nextval('seq_user'), 'dos2', '$2y$10$1p9FJ4b6sWPs97ACLIeG8.5VRhK4.4roqBGVI6PQjmnOyKM2jCwou', 'Zika', 'Zikic', 'Dunavska', '060111112', 'Novi Sad', 'Srbija', true);

insert into "statusnarudzbine" (id, odbijena, prihvatioKuvar, dodeljenDostavljac, preuzetaIzRestorana, vremePreuzimanjaIzRestorana, dostavljenaKorisniku, vremeDostavljanja) values (nextval('seq_statusNarudzbine'), false, false, false, false, null, false, null);
insert into "statusnarudzbine" (id, odbijena, prihvatioKuvar, dodeljenDostavljac, preuzetaIzRestorana, vremePreuzimanjaIzRestorana, dostavljenaKorisniku, vremeDostavljanja) values (nextval('seq_statusNarudzbine'), false, false, false, false, null, false, null);

insert into "proizvod" (id, naziv, cena) values (nextval('seq_proizvod'), 'Pizza', 500);
insert into "proizvod" (id, naziv, cena) values (nextval('seq_proizvod'), 'Burger', 450);
insert into "proizvod" (id, naziv, cena) values (nextval('seq_proizvod'), 'Pasta', 740);
insert into "proizvod" (id, naziv, cena) values (nextval('seq_proizvod'), 'Krempita', 320);

insert into "narudzbina" (id, ukupnacena, datum, objekat_id, kupac_id, statusNarudzbine_id,narucena) values (nextval('seq_narudzbina'), 2140,'2021-07-06', null,  1, 1, false);
insert into "narudzbina" (id, ukupnacena, datum, objekat_id, kupac_id, statusNarudzbine_id, narucena) values (nextval('seq_narudzbina'), 3140,'2021-07-06', null,  1, 2, false);


insert into "narudzbinaproizvodi" (id, kolicina, narudzbina_id, proizvod_id) values (nextval('seq_narudzbinaProizvodi'), 1, 1, 1);
insert into "narudzbinaproizvodi" (id, kolicina, narudzbina_id, proizvod_id) values (nextval('seq_narudzbinaProizvodi'), 1, 1, 2);
insert into "narudzbinaproizvodi" (id, kolicina, narudzbina_id, proizvod_id) values (nextval('seq_narudzbinaProizvodi'), 1, 1, 3);

insert into "narudzbinaproizvodi" (id, kolicina, narudzbina_id, proizvod_id) values (nextval('seq_narudzbinaProizvodi'), 2, 2, 1);
insert into "narudzbinaproizvodi" (id, kolicina, narudzbina_id, proizvod_id) values (nextval('seq_narudzbinaProizvodi'), 2, 2, 2);
insert into "narudzbinaproizvodi" (id, kolicina, narudzbina_id, proizvod_id) values (nextval('seq_narudzbinaProizvodi'), 2, 2, 3);



INSERT INTO AUTHORITY (name) VALUES ('ROLE_KUPAC');
INSERT INTO AUTHORITY (name) VALUES ('ROLE_KUVAR');
INSERT INTO AUTHORITY (name) VALUES ('ROLE_DOSTAVLJAC');

INSERT INTO USER_AUTHORITY (user_id, authority_id) VALUES (1, 1);
INSERT INTO USER_AUTHORITY (user_id, authority_id) VALUES (2, 2);
INSERT INTO USER_AUTHORITY (user_id, authority_id) VALUES (3, 3);
INSERT INTO USER_AUTHORITY (user_id, authority_id) VALUES (4, 3);