CREATE TABLE aikatauluslotti (
	id SMALLINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	aika_id smallint,
	pvm DATE,
	alkukello TIME,
	loppukello TIME,
	koulutustila  varchar(10),
	koulutus_id  SMALLINT,
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
