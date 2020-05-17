insert into tuzilac(tip) values ('OSNOVNI_JAVNI_TUZILAC');
insert into tuzilac(tip) values ('VISI_JAVNI_TUZILAC');

insert into obelezje(izvrsilac, vreme, mesto, radnja, posledica, subjektivan_odnos) values ('svako', 'svako', 'svako', 'podobna da prouzrokuje smrt', 'smrt, odmah ili kasije', 'umisljaj');
insert into obelezje(zrtva) values ('Vise od 18');

insert into delo(naziv, min_kazna, max_kazna, clan, stav, tacka, opste_obelezje_id, posebno_obelezje_id) values ('Ubistvo', 5, 15, 113, 0, 0, 1, 2);

insert into obelezje(izvrsilac, vreme, mesto, radnja, posledica, subjektivan_odnos) values ('svako', 'svako', 'svako', 'podobna da prouzrokuje smrt', 'srmt, odmah ili kasnije', 'umisljaj');
insert into obelezje(zrtva, radnja) values ('Vise od 18', 'Razbojnistvo&Kradja');

insert into delo(naziv, min_kazna, max_kazna, clan, stav, tacka, opste_obelezje_id, posebno_obelezje_id) values ('Tesko ubistvo', 10, 100, 114, 1, 4, 3, 4);


insert into obelezje(izvrsilac, vreme, mesto, radnja, posledica, subjektivan_odnos) values ('svako', 'svako', 'svako', 'podobna da prouzrokuje smrt', 'smrt, odmah ili kasnije', 'umisljaj');
insert into obelezje(zrtva) values ('Izmedju 18 i 14&Manje od 14&Bremenita zena');

insert into delo(naziv, min_kazna, max_kazna, clan, stav, tacka, opste_obelezje_id, posebno_obelezje_id) values ('Tesko ubistvo', 10, 100, 114, 1, 9, 5, 6);

insert into obelezje(izvrsilac, vreme, mesto, radnja, posledica, subjektivan_odnos) values ('svako', 'svako', 'svako', 'podobna da prouzrokuje smrt', 'smrt, odmah ili kasnije', 'umisljaj');
insert into obelezje(zrtva) values ('sve zrtve&>Vise od 18');

insert into delo(naziv, min_kazna, max_kazna, clan, stav, tacka, opste_obelezje_id, posebno_obelezje_id) values ('Tesko ubistvo', 10, 100, 114, 1, 11, 7, 8);

insert into obelezje(izvrsilac, vreme, mesto, radnja, posledica) values ('svako', 'svako', 'svako', 'podobna da prouzrokuje smrt', 'smrt, odmah ili kasnije');
insert into obelezje(subjektivan_odnos, zrtva) values ('Nehat', 'svako');

insert into delo(naziv, min_kazna, max_kazna, clan, stav, tacka, opste_obelezje_id, posebno_obelezje_id) values ('Nehatno lisenje zivota', 0.5, 5, 118, 0, 0, 9, 10);

insert into dokaz(clan, stav, tacka, opis) values (0, 0, 0, 'Spoljasnji pregled tela izvrsioca krivicnog dela i uzimanje krvi, urina, podnokatnog sadrzaja, bukalnog brisa, kao i tragova krivicnog dela.');
insert into dokaz(clan, stav, tacka, opis) values (0, 0, 0, 'Uzimanje obuce i odece od ucinioca krivicnog dela i zrtve.');
insert into dokaz(clan, stav, tacka, opis) values (0, 0, 0, 'Uzimanje uredjaja za video nadzor sa lica mesta.');
insert into dokaz(clan, stav, tacka, opis) values (0, 0, 0, 'Vestacenja eksperata.');
insert into dokaz(clan, stav, tacka, opis) values (114, 1, 9, 'Treba pribaviti dokaz o tome da je zrtva dete u vidu izvoda iz maticne knjige rodjenih, odnosno da je zrtva bremenita zena u vidu sudskomedicinskog vestacenja sa posebnim akcentom na tu okolnost.');
insert into dokaz(clan, stav, tacka, opis) values (115, 0, 0, 'Treba privaviti sudskopsihijatrisko i psiholosko vestacenje radi utvrdjivanja da li je ucinilac u vremeizvrsenja krivicnog dela bio u stanju jake razdrazenosti izazvane postupkom zrtve.');