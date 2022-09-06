Vor Start des Programms muss eine Datenbank angelegt werden.
Die Datenbank sollte pizzame heißen.
Die Tabellen werden über eine fill.sql -Datei gefüllt, die den Programm beiliegt.
Folgende Tabellen müssen angelegt werden:

CREATE TABLE Pizza(
	id BIGINT,
	description VARCHAR(255),
	ImageUrl VARCHAR(255),
	name VARCHAR(255),
	prize INTEGER,
	PRIMARY KEY(id)
);

CREATE TABLE Postcode(
	id BIGINT,
	name VARCHAR(255),
	zipcode VARCHAR(255),
	PRIMARY KEY(id)
);

CREATE TABLE Sequence(
	Seq_Name VARCHAR(255),
	Seq_Count DECIMAL,
	PRIMARY KEY(Seq_Name)
);
