create database projetMeuble;
\c projetmeuble;
create table categorie(
    idCategorie serial primary key , 
    nomCategorie varchar(50)
);
insert into categorie(nomCategorie) values('chaise');
insert into categorie(nomCategorie) values('table');

create table Matiere(
    idMatiere serial primary key , 
    nomMatiere varchar(50)
);
insert into matiere(nomMatiere) values('hazo');
insert into matiere(nomMatiere) values('lamba');

create table style(
    idStyle serial primary key , 
    nomStyle varchar(50)    
);
insert into style(nomStyle) values('Royale');
insert into style(nomStyle) values('Boeme');

create table matiereParStyle(
    idMatiereParStyle serial primary key , 
    idStyle int not null , 
    idMatiere int not null ,
    foreign key(idStyle) references style(idStyle),
    foreign key(idMatiere) references matiere(idMatiere)
);

INSERT INTO MATIEREPARSTYLE(IDSTYLE, IDMATIERE) VALUES (1, 1);
INSERT INTO MATIEREPARSTYLE(IDSTYLE, IDMATIERE) VALUES (1, 2);

CREATE OR REPLACE VIEW STYLEAVECMATIERE AS (
    SELECT STYLE.IDSTYLE AS IDSTYLE, MATIERE.IDMATIERE AS IDMATIERE,
    STYLE.NOMSTYLE AS NOMSTYLE, MATIERE.NOMMATIERE AS NOMMATIERE
    FROM MATIERE JOIN MATIEREPARSTYLE ON MATIERE.IDMATIERE=MATIEREPARSTYLE.IDMATIERE
                 JOIN STYLE ON MATIEREPARSTYLE.IDSTYLE=STYLE.IDSTYLE
);


CREATE TABLE VOLUME (
    IDVOLUME SERIAL PRIMARY KEY,
    NOMVOLUME VARCHAR(50)
);

CREATE TABLE TAILLEPARCATEGORIEPARSTYLE (
    IDTCS SERIAL PRIMARY KEY,
    IDCATEGORIE INT NOT NULL,
    IDSTYLE INT NOT NULL,
    IDVOLUME INT NOT NULL,
    FOREIGN KEY IDCATEGORIE REFERENCES CATEGORIE(IDCATEGORIE),
    FOREIGN KEY IDSTYLE REFERENCES STYLE(IDSTYLE),
    FOREIGN KEY IDVOLUME REFERENCES VOLUME(IDVOLUME) 
); 

CREATE TABLE FORMULEFABRICATION(
    IDTC INT NOT NULL,
    IDMATIERE INT NOT NULL,
    FOREIGN KEY IDTC REFERENCES TAILLEPARCATEGORIEPARSTYLE(IDTCS),
    FOREIGN KEY IDMATIERE REFERENCES MATIERE(IDMATIERE)
);