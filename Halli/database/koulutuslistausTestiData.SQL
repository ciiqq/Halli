INSERT INTO koulutustilaisuus (koulutus_id, aihe, kuvaus, lahtotaso, nakyvyys, arvioiva_ope)
VALUES (2, "jQuery", "jQuery luento on aika kiva", "semi", 0, 1);

INSERT INTO koulutustilaisuus (koulutus_id, aihe, kuvaus, lahtotaso, nakyvyys, arvioiva_ope)
VALUES (3, "JavaScript", "JavaScript luento on aika kiva", "semi-pro", 1, 1);

INSERT INTO koulutustilaisuus ( aihe, kuvaus, lahtotaso, nakyvyys)
VALUES ("Java srvletit", "Java_beanit on melko hauskoja", "semi-pro-pro", 1);

INSERT INTO koulutustilaisuus ( aihe, kuvaus, lahtotaso, nakyvyys)
VALUES ("Java Sprin frameee", "Java_beanit on melko hauskoja", "semi-pro-pro", 0);

INSERT INTO koulutustilaisuus ( aihe, kuvaus, lahtotaso, nakyvyys)
VALUES ("jQueryUI", "Java_beanit on melko hauskoja", "semi-pro-pro", 0);

INSERT INTO koulutustilaisuus ( aihe, kuvaus, lahtotaso, nakyvyys)
VALUES ("AngularJS", "Java_beanit on melko hauskoja", "semi-pro-pro", 1);


INSERT INTO opettaja (opettaja_id, etunimi, sukunimi, salasana, suola)
VALUES (2, "Naskali", "Nakke", "derpadurpa", "222222");

INSERT INTO aikatauluslotti (aika_id, pvm, alkukello, loppukello, koulutustila, koulutus_id)
VALUES (2, "2014-04-03", "12:00", "14:00", "5007", 2);

INSERT INTO aikatauluslotti (aika_id, pvm, alkukello, loppukello, koulutustila, koulutus_id)
VALUES (3, "2014-04-04", "12:00", "14:00", "5007", 3);

INSERT INTO aikatauluslotti (aika_id, pvm, alkukello, loppukello, koulutustila, koulutus_id)
VALUES (4, "2014-04-05", "12:00", "14:00", "5007", 4);

INSERT INTO aikatauluslotti ( pvm, alkukello, loppukello, koulutustila, koulutus_id)
VALUES ( "2015-04-05", "12:00", "14:00", "5007", 5);

INSERT INTO aikatauluslotti ( pvm, alkukello, loppukello, koulutustila, koulutus_id)
VALUES ( "2016-04-05", "12:00", "14:00", "5007", 6);

INSERT INTO aikatauluslotti ( pvm, alkukello, loppukello, koulutustila, koulutus_id)
VALUES ( "2017-04-05", "12:00", "14:00", "5007", 7);

INSERT INTO aikatauluslotti ( pvm, alkukello, loppukello, koulutustila, koulutus_id)
VALUES ( "2018-04-05", "12:00", "14:00", "5007", 8);

INSERT INTO aikatauluslotti ( pvm, alkukello, loppukello, koulutustila, koulutus_id)
VALUES ( "2018-12-05", "12:00", "14:00", "5007", 9);

INSERT INTO aikatauluslotti ( pvm, alkukello, loppukello, koulutustila, koulutus_id)
VALUES ( "2015-07-15", "12:00", "14:00", "5007", 10);


INSERT INTO avainsana (avainsana_id, avainsana)
VALUES (1, "jQuery");

INSERT INTO avainsana (avainsana_id, avainsana)
VALUES (2, "JavaScript");

INSERT INTO avainsana (avainsana_id, avainsana)
VALUES (3, "Java");

INSERT INTO avainsana (avainsana_id, avainsana)
VALUES (4, "Beans");

INSERT INTO avainsana (avainsana_id, avainsana)
VALUES (5, "Koodaus");

INSERT INTO koulutuksen (avainsana_id, avainsana)
VALUES (5, "Koodaus");

INSERT INTO koulutuksenAvainsana (koulutuksenavainsana_id, avainsana_id, koulutus_id)
VALUES (1, 1, 2);

INSERT INTO koulutuksenAvainsana (koulutuksenavainsana_id, avainsana_id, koulutus_id)
VALUES (2, 2, 3);

INSERT INTO koulutuksenAvainsana (koulutuksenavainsana_id, avainsana_id, koulutus_id)
VALUES (3, 3, 4);

INSERT INTO koulutuksenAvainsana (koulutuksenavainsana_id, avainsana_id, koulutus_id)
VALUES (4, 4, 4);

INSERT INTO koulutuksenAvainsana (koulutuksenavainsana_id, avainsana_id, koulutus_id)
VALUES (5, 5, 2);

INSERT INTO kouluttaja (opiskelijanro, etunimi, sukunimi, salasana, suola)
VALUES (1200001, "Oppi", "opiskelija", "salasana", "suola123");

INSERT INTO henkilo (henkilotunnus, etunimi, sukunimi, salasana, suola, rooli)
VALUES ("1200001", "Oppi", "opiskelija", "salasana", "suola123", "kouluttaja");

INSERT INTO henkilo (henkilotunnus, etunimi, sukunimi, salasana, suola, rooli)
VALUES ("1200002", "Oppi", "opiskelija", "salasana", "suola123", "kouluttaja");

INSERT INTO henkilo (henkilotunnus, etunimi, sukunimi, salasana, suola, rooli)
VALUES ("1200003", "Oppi", "opiskelija", "salasana", "suola123", "opettaja");

INSERT INTO henkilo (henkilotunnus, etunimi, sukunimi, salasana, suola, rooli)
VALUES ("1200004", "Oppi", "opiskelija", "salasana", "suola123", "opettaja");

INSERT INTO kouluttaja (opiskelijanro, etunimi, sukunimi, salasana, suola)
VALUES (1200002, "Matti", "Mallikas", "salasana", "suola123");

INSERT INTO kouluttaja (opiskelijanro, etunimi, sukunimi, salasana, suola)
VALUES (1200003, "Melko", "Meikäläinen", "salasana", "suola123");

INSERT INTO kouluttaja (opiskelijanro, etunimi, sukunimi, salasana, suola)
VALUES (1200004, "Make", "Makkara", "salasana", "suola123");

INSERT INTO koulutuksenKouluttaja (koulutus_id, opiskelijanro)
VALUES (2, 1200001);

INSERT INTO henkilo (henkilotunnus, etunimi, sukunimi, salasana, suola, rooli)
VALUES ("1234567", "KALLE", "KANAALI", "salasana", "suola123", "kouluttaja");

INSERT INTO henkilo (henkilotunnus, etunimi, sukunimi, salasana, suola, rooli)
VALUES ("1234568", "Oppi", "opiskelija", "salasana", "suola123", "kouluttaja");

INSERT INTO henkilo (henkilotunnus, etunimi, sukunimi, salasana, suola, rooli)
VALUES ("1234569", "Manne", "Mankeli", "salasana", "suola123", "kouluttaja");

INSERT INTO henkilo (henkilotunnus, etunimi, sukunimi, salasana, suola, rooli)
VALUES ("ope1235", "Ope", "Rankaisija", "salasana", "suola123", "opettaja");

INSERT INTO henkilo (henkilotunnus, etunimi, sukunimi, salasana, suola, rooli)
VALUES ("ope1234", "Matti", "Matikka", "salasana", "suola123", "opettaja");