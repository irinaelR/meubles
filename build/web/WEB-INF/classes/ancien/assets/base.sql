create database projetMeuble;
\c projetMeuble;
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