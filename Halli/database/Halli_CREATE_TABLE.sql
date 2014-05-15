CREATE TABLE henkilo (
    henkilotunnus CHAR(7) PRIMARY KEY NOT NULL,
    etunimi VARCHAR(30) NOT NULL,
    sukunimi VARCHAR(50) NOT NULL,
    salasana VARCHAR(255) NOT NULL,
    suola VARCHAR(255) NOT NULL,
    rooli ENUM('kouluttaja','opettaja') NOT NULL
) engine=innoDB default charset=utf8;

CREATE TABLE koulutustilaisuus (
    koulutus_id INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL,
    aihe VARCHAR(50) NOT NULL,
    kuvaus TEXT,
    lahtotaso VARCHAR(100),
    nakyvyys BOOLEAN,
    koulutusmenetelmat VARCHAR (255)
) engine=innoDB default charset=utf8;

CREATE TABLE aikatauluslotti (
    aika_id INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL,
    pvm DATE NOT NULL,
    alkukello TIME NOT NULL,
    loppukello TIME NOT NULL,
    koulutustila VARCHAR(10) NOT NULL,
    koulutus_id int,    
    FOREIGN KEY (koulutus_id) REFERENCES koulutustilaisuus(koulutus_id)
) engine=innoDB default charset=utf8;

CREATE TABLE avainsana(
    avainsana_id INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL,
    avainsana VARCHAR(30)
) engine=innoDB default charset=utf8;

CREATE TABLE koulutuksenavainsana(
    koulutuksenavainsana_id    INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL,
    avainsana_id int,
    koulutus_id int,
    FOREIGN KEY (koulutus_id) REFERENCES koulutustilaisuus(koulutus_id),
    FOREIGN KEY (avainsana_id) REFERENCES avainsana(avainsana_id)
) engine=innoDB default charset=utf8;

CREATE TABLE koulutuksentoimija(
    koulutuksentoimija_id INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL,    
    henkilotunnus CHAR(7),
    koulutus_id int,
    FOREIGN KEY (henkilotunnus) REFERENCES henkilo(henkilotunnus),
    FOREIGN KEY (koulutus_id) REFERENCES koulutustilaisuus(koulutus_id)
) engine=innoDB default charset=utf8;

CREATE TABLE palaute(
    palaute_id INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL,
    arvosana SMALLINT NOT NULL,
    palauteteksti TEXT NOT NULL,
    opiskelijanro CHAR(7) NOT NULL
) engine=innoDB default charset=utf8;

CREATE TABLE osallistuja(
   osallistujan_opiskelijanro CHAR(7) NOT NULL primary key,
    etunimi VARCHAR(30) NOT NULL,
    sukunimi VARCHAR(50) NOT NULL
) engine=innodb default charset=utf8;

CREATE TABLE ilmoittautuminen (
    osallistujan_opiskelijanro char(7) not null,
    koulutus_id int(11) not null,
    palaute_id int(11),
primary key (osallistujan_opiskelijanro, koulutus_id),
 FOREIGN KEY (osallistujan_opiskelijanro) REFERENCES osallistuja(osallistujan_opiskelijanro),
 FOREIGN KEY (koulutus_id) REFERENCES koulutustilaisuus(koulutus_id),
 FOREIGN KEY (palaute_id) REFERENCES palaute(palaute_id)
) engine=innoDB default charset=utf8;