insert into tuzilac(tip) values ('OSNOVNI_JAVNI_TUZILAC');
insert into tuzilac(tip) values ('VISI_JAVNI_TUZILAC');

insert into obelezje(izvrsilac, vreme, mesto, radnja, posledica, subjektivan_odnos) values ('svako', 'svako', 'svako', 'podobna da prouzrokuje smrt', 'smrt, odmah ili kasije', 'umisljaj');
insert into obelezje(zrtva) values ('>18');

insert into delo(naziv, max_kazna, min_kazna, clan, stav, tacka, opste_obelezje_id, posebno_obelezje_id) values ('Ubistvo', 5, 15, 113, 0, 0, 1, 2);

insert into obelezje(izvrsilac, vreme, mesto, radnja, posledica, subjektivan_odnos) values ('svako', 'svako', 'svako', 'podobna da prouzrokuje smrt', 'srmt, odmah ili kasnije', 'umisljaj');
insert into obelezje(zrtva, radnja) values ('>18', 'tokom razbojnistva ili razbojnicke kradje');

insert into delo(naziv, max_kazna, min_kazna, clan, stav, tacka, opste_obelezje_id, posebno_obelezje_id) values ('Tesko ubistvo', 10, 100, 114, 1, 4, 3, 4);


insert into obelezje(izvrsilac, vreme, mesto, radnja, posledica, subjektivan_odnos) values ('svako', 'svako', 'svako', 'podobna da prouzrokuje smrt', 'smrt, odmah ili kasnije', 'umisljaj');
insert into obelezje(zrtva) values ('<18 ili bremenita zena');

insert into delo(naziv, max_kazna, min_kazna, clan, stav, tacka, opste_obelezje_id, posebno_obelezje_id) values ('Tesko ubistvo', 10, 100, 114, 1, 9, 5, 6);

insert into obelezje(izvrsilac, vreme, mesto, radnja, posledica, subjektivan_odnos) values ('svako', 'svako', 'svako', 'podobna da prouzrokuje smrt', 'smrt, odmah ili kasnije', 'umisljaj');
insert into obelezje(zrtva) values ('sve zrtve&>18');

insert into delo(naziv, max_kazna, min_kazna, clan, stav, tacka, opste_obelezje_id, posebno_obelezje_id) values ('Tesko ubistvo', 10, 100, 114, 1, 11, 7, 8);

insert into obelezje(izvrsilac, vreme, mesto, radnja, posledica) values ('svako', 'svako', 'svako', 'podobna da prouzrokuje smrt', 'smrt, odmah ili kasnije');
insert into obelezje(subjektivan_odnos, zrtva) values ('nehat', 'svako');

insert into delo(naziv, max_kazna, min_kazna, clan, stav, tacka, opste_obelezje_id, posebno_obelezje_id) values ('Nehatno lisenje zivota', 0.5, 5, 118, 0, 0, 9, 10);