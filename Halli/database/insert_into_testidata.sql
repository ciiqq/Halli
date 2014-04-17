INSERT INTO kouluttaja (opiskelijanro, etunimi, sukunimi, salasana, suola)
VALUES (1101234, 'Maija', 'Matilainen', 'hyvingeneroitupassu', 'suolatius'), (1201234, 'Ossi', 'Osaava', 'testipassu_hyvin_generoitu', 'suolakin'), (1202341, 'Samu', 'Sammakko', 'kosiomatkallaa_uah_uah', 'sakusuola'), (1202342, 'Harri', 'H�m�l�inen', 'tarpeellinentesti', 'testisuola'), (1204321, 'Tiina', 'Taitava', 'salasanageneraattori', 'suolatettu'), (1234567, 'Matti', 'Meikalainen', 'abc123', '123abc');

INSERT INTO opettaja (etunimi, sukunimi, salasana, suola)
VALUES ('Jukka', 'Testi', 'Jukka123', '123Jukka'), ('Aila', 'Avulias', 'salasanajeejee', 'suola'), ('Pekka', 'Kuusisto', 'geneerinensalasana', 'suola'), ('Simo', 'Silmu', 'generoitupassu', 'suola'), ('Saija', 'Sulava', 'passupassupassu', 'suola');

INSERT INTO osallistuja (osallistujan_opiskelijanro, etunimi, sukunimi);
VALUES (1234568, 'Osallistuja', 'Testi'), (1101234, 'Vanha', 'Osallistuja'), (1104321, 'Hanna', 'Hanakka'), (1103214, 'Saila', 'Simonen'), (1302341, 'Teuvo', 'Maantie');

INSERT INTO koulutustilaisuus (aihe, kuvaus, lahtotaso, nakyvyys, arvioiva_ope)
VALUES ('SQL', 'Tahan tulee kuvaus', 'alkeet', 1, 1), ('jQuery', 'jQueryn perusteet', 'alkeet', 0, 2), ('GIT', 'versionhallinta gitillä', 'alkeet', 0, 3), ('Spring framework', 'Spring frameworkin käyttö projektissa', 'keskitaso', 1, 2), ('Photoshop', 'Photoshopin käyttö verkkosovelluksiin', 'kehittynyt', 0, 1);

INSERT INTO aikatauluslotti (pvm, alkukello, loppukello, koulutustila, koulutus_id)
VALUES ('2014-03-12', '14:00', '16:00', '4003', 1), ('2014-04-03', '10:00:00', '12:00:00', '5006', 2), ('2014-4-20', '09:00', '11:00', '5006', 3), ('2014-4-21', '12:00', '14:00', '5007', 4), ('2014-05-1', '08:00', '12:00', '5006', 5);

INSERT INTO avainsana (avainsana)
VALUES ('SQL'), ('jQuery'), ('Photoshop'), ('Spring'), ('GIT');

INSERT INTO palaute (arvosana, palauteteksti)
VALUES (5, 'Oikein hienoa'), (5, 'Hyvä koulutus'), (4, 'Hyvin vedetty, mutta vähän olisin kaivannut syvempää koulutusta'), (5, 'Hyvä jee jee'), (5, 'Hyvin meni');

INSERT INTO ilmoittautuminen (osallistuja_id, koulutus_id, palaute_id)
VALUES (1, 1, 1), (2, 2, 2), (3, 3, 3), (4, 4, 4), (5, 1, 5);

INSERT INTO koulutuksenAvainsana (avainsana_id, koulutus_id)
VALUES (1,1), (2,2), (3,3), (4,4), (5,5);

INSERT INTO koulutuksenKouluttaja (opiskelijanro, koulutus_id)
VALUES (1201234,1), (1204321,2), (1202341,3), (1234567,4), (1202342,5);