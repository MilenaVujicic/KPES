insert into tuzilac(tip) values ('OSNOVNI_JAVNI_TUZILAC');
insert into tuzilac(tip) values ('VISI_JAVNI_TUZILAC');
insert into tuzilac(tip) values ('TUZILAC_ZA_MALOLETNIKE');
insert into tuzilac(tip) values ('TUZILAC_ZA_ORGANIZOVANI_KRIMINAL');

/*
 * 113
 */
insert into obelezje(izvrsilac, vreme, mesto, radnja, posledica, subjektivan_odnos) values ('svako', 'svako', 'svako', 'podobna da prouzrokuje smrt', 'smrt, odmah ili kasije', 'umisljaj');
insert into obelezje(zrtva) values ('Vise od 18');

insert into delo(naziv, min_kazna, max_kazna, clan, stav, tacka, opste_obelezje_id, posebno_obelezje_id) values ('Ubistvo', 5, 15, 113, 0, 0, 1, 2);


/*
 * 114 1 4
 */

insert into obelezje(izvrsilac, vreme, mesto, radnja, posledica, subjektivan_odnos) values ('svako', 'svako', 'svako', 'podobna da prouzrokuje smrt', 'srmt, odmah ili kasnije', 'umisljaj');
insert into obelezje(zrtva, radnja) values ('Vise od 18', 'Razbojnistvo&Kradja');

insert into delo(naziv, min_kazna, max_kazna, clan, stav, tacka, opste_obelezje_id, posebno_obelezje_id) values ('Tesko ubistvo', 10, 100, 114, 1, 4, 3, 4);

/*
 * 114 1 9
 */

insert into obelezje(izvrsilac, vreme, mesto, radnja, posledica, subjektivan_odnos) values ('svako', 'svako', 'svako', 'podobna da prouzrokuje smrt', 'smrt, odmah ili kasnije', 'umisljaj');
insert into obelezje(zrtva) values ('Izmedju 18 i 14&Manje od 14&Bremenita zena');

insert into delo(naziv, min_kazna, max_kazna, clan, stav, tacka, opste_obelezje_id, posebno_obelezje_id) values ('Tesko ubistvo', 10, 100, 114, 1, 9, 5, 6);


/*
 * 114 1 11
 */

insert into obelezje(izvrsilac, vreme, mesto, radnja, posledica, subjektivan_odnos) values ('svako', 'svako', 'svako', 'podobna da prouzrokuje smrt', 'smrt, odmah ili kasnije', 'umisljaj');
insert into obelezje(zrtva) values ('sve zrtve&>Vise od 18');

insert into delo(naziv, min_kazna, max_kazna, clan, stav, tacka, opste_obelezje_id, posebno_obelezje_id) values ('Tesko ubistvo', 10, 100, 114, 1, 11, 7, 8);

/*
 * 118
 */

insert into obelezje(izvrsilac, vreme, mesto, radnja, posledica) values ('svako', 'svako', 'svako', 'podobna da prouzrokuje smrt', 'smrt, odmah ili kasnije');
insert into obelezje(subjektivan_odnos, zrtva) values ('Nehat', 'svako');

insert into delo(naziv, min_kazna, max_kazna, clan, stav, tacka, opste_obelezje_id, posebno_obelezje_id) values ('Nehatno lisenje zivota', 0.5, 5, 118, 0, 0, 9, 10);
/*
 * 310
 */
insert into obelezje(izvrsilac, vreme, mesto, radnja, posledica, zrtva, subjektivan_odnos) values ('svako', 'svako', 'svako','podobna da prouzrokuje smrt', 'smrt', 'Vise od 18', 'umisljaj');
insert into obelezje(zrtva, radnja) values ('poseban status', 'ugrozavanje ustavnog uredjenja');

insert into delo(naziv, min_kazna, max_kazna, clan, stav, tacka, opste_obelezje_id, posebno_obelezje_id) values ('Ubistvo predstavnika najvisih drzavnih organa', 10, 100, 310, 0, 0, 11, 12);

/*
 * 115
 */

insert into obelezje(izvrsilac, vreme, mesto, radnja, posledica, zrtva, subjektivan_odnos) values ('svako', 'svako', 'svako' ,'podobna da prouzrokuje smrt', 'smrt', 'Vise od 18', 'umisljaj');
insert into obelezje(radnja, zrtva, izvrsilac) values ('prethodio napad', 'jedan ili vise zlostavljaca', 'doveden u posebno psihicko stanje');

insert into delo(naziv, min_kazna, max_kazna, clan, stav, tacka, opste_obelezje_id, posebno_obelezje_id) values ('Ubistvo na mah', 1, 8, 115, 0, 0, 13, 14);

insert into dokaz(clan, stav, tacka, opis) values (0, 0, 0, 'Spoljasnji pregled tela izvrsioca krivicnog dela i uzimanje krvi, urina, podnokatnog sadrzaja, bukalnog brisa, kao i tragova krivicnog dela.');
insert into dokaz(clan, stav, tacka, opis) values (0, 0, 0, 'Uzimanje obuce i odece od ucinioca krivicnog dela i zrtve.');
insert into dokaz(clan, stav, tacka, opis) values (0, 0, 0, 'Uzimanje uredjaja za video nadzor sa lica mesta.');
insert into dokaz(clan, stav, tacka, opis) values (0, 0, 0, 'Vestacenja eksperata.');

insert into dokaz(clan, stav, tacka, opis) values (114, 1, 9, 'Treba pribaviti dokaz o tome da je zrtva dete u vidu izvoda iz maticne knjige rodjenih, odnosno da je zrtva bremenita zena u vidu sudskomedicinskog vestacenja sa posebnim akcentom na tu okolnost');
insert into dokaz(clan, stav, tacka, opis) values (115, 0, 0, 'Treba privaviti sudskopsihijatrisko i psiholosko vestacenje radi utvrdjivanja da li je ucinilac u vremeizvrsenja krivicnog dela bio u stanju jake razdrazenosti izazvane postupkom zrtve');
insert into dokaz(clan, stav, tacka, opis) values (310, 0, 0, 'Treba pribaviti dokaz o sluzbi ili funkciji koje obavljala zrtva krvicnog dela u vidu resenja o zasnivanju radnog odnosa ili odluke o izboru ili imenovanju kako bi se dokazalo da zrtva ima to posebno svojstvo.');

insert into linkt(tuzilac, clan, stav, tacka) values ('VISI_JAVNI_TUZILAC', 113, 0, 0);
insert into linkt(tuzilac, clan, stav, tacka) values ('VISI_JAVNI_TUZILAC', 114, 1, 4);
insert into linkt(tuzilac, clan, stav, tacka) values ('VISI_JAVNI_TUZILAC', 114, 1, 9);
insert into linkt(tuzilac, clan, stav, tacka) values ('VISI_JAVNI_TUZILAC', 114, 1, 11);
insert into linkt(tuzilac, clan, stav, tacka) values ('VISI_JAVNI_TUZILAC', 115, 0, 0);

insert into linkt(tuzilac, clan, stav, tacka) values ('OSNOVNI_JAVNI_TUZILAC', 118, 0, 0);

insert into linkt(tuzilac, clan, stav, tacka) values ('TUZILAC_ZA_ORGANIZOVANI_KRIMINAL', 310, 0, 0);

insert into linkt(tuzilac, clan, stav, tacka) values ('TUZILAC_ZA_MALOLETNIKE', 113, 0, 0);
insert into linkt(tuzilac, clan, stav, tacka) values ('TUZILAC_ZA_MALOLETNIKE', 114, 1, 4);
insert into linkt(tuzilac, clan, stav, tacka) values ('TUZILAC_ZA_MALOLETNIKE', 114, 1, 9);
insert into linkt(tuzilac, clan, stav, tacka) values ('TUZILAC_ZA_MALOLETNIKE', 114, 1, 11);
insert into linkt(tuzilac, clan, stav, tacka) values ('TUZILAC_ZA_MALOLETNIKE', 115, 0, 0);
insert into linkt(tuzilac, clan, stav, tacka) values ('TUZILAC_ZA_MALOLETNIKE', 118, 0, 0);
insert into linkt(tuzilac, clan, stav, tacka) values ('TUZILAC_ZA_MALOLETNIKE', 310, 0, 0);

insert into linkd(dokaz, clan, stav, tacka) values ('Spoljasnji pregled tela izvrsioca krivicnog dela i uzimanje krvi, urina, podnokatnog sadrzaja, bukalnog brisa, kao i tragova krivicnog dela.', 113, 0, 0);
insert into linkd(dokaz, clan, stav, tacka) values ('Spoljasnji pregled tela izvrsioca krivicnog dela i uzimanje krvi, urina, podnokatnog sadrzaja, bukalnog brisa, kao i tragova krivicnog dela.', 114, 1, 4);
insert into linkd(dokaz, clan, stav, tacka) values ('Spoljasnji pregled tela izvrsioca krivicnog dela i uzimanje krvi, urina, podnokatnog sadrzaja, bukalnog brisa, kao i tragova krivicnog dela.', 114, 1, 9);
insert into linkd(dokaz, clan, stav, tacka) values ('Spoljasnji pregled tela izvrsioca krivicnog dela i uzimanje krvi, urina, podnokatnog sadrzaja, bukalnog brisa, kao i tragova krivicnog dela.', 114, 1, 11);
insert into linkd(dokaz, clan, stav, tacka) values ('Spoljasnji pregled tela izvrsioca krivicnog dela i uzimanje krvi, urina, podnokatnog sadrzaja, bukalnog brisa, kao i tragova krivicnog dela.', 115, 0, 0);
insert into linkd(dokaz, clan, stav, tacka) values ('Spoljasnji pregled tela izvrsioca krivicnog dela i uzimanje krvi, urina, podnokatnog sadrzaja, bukalnog brisa, kao i tragova krivicnog dela.', 118, 0, 0);
insert into linkd(dokaz, clan, stav, tacka) values ('Spoljasnji pregled tela izvrsioca krivicnog dela i uzimanje krvi, urina, podnokatnog sadrzaja, bukalnog brisa, kao i tragova krivicnog dela.', 310, 0, 0);

insert into linkd(dokaz, clan, stav, tacka) values ('Uzimanje obuce i odece od ucinioca krivicnog dela i zrtve.', 113, 0, 0);
insert into linkd(dokaz, clan, stav, tacka) values ('Uzimanje obuce i odece od ucinioca krivicnog dela i zrtve.', 114, 1, 4);
insert into linkd(dokaz, clan, stav, tacka) values ('Uzimanje obuce i odece od ucinioca krivicnog dela i zrtve.', 114, 1, 9);
insert into linkd(dokaz, clan, stav, tacka) values ('Uzimanje obuce i odece od ucinioca krivicnog dela i zrtve.', 114, 1, 11);
insert into linkd(dokaz, clan, stav, tacka) values ('Uzimanje obuce i odece od ucinioca krivicnog dela i zrtve.', 115, 0, 0);
insert into linkd(dokaz, clan, stav, tacka) values ('Uzimanje obuce i odece od ucinioca krivicnog dela i zrtve.', 118, 0, 0);
insert into linkd(dokaz, clan, stav, tacka) values ('Uzimanje obuce i odece od ucinioca krivicnog dela i zrtve.', 310, 0, 0);


insert into linkd(dokaz, clan, stav, tacka) values ('Uzimanje uredjaja za video nadzor sa lica mesta.', 113, 0, 0);
insert into linkd(dokaz, clan, stav, tacka) values ('Uzimanje uredjaja za video nadzor sa lica mesta.', 114, 1, 4);
insert into linkd(dokaz, clan, stav, tacka) values ('Uzimanje uredjaja za video nadzor sa lica mesta.', 114, 1, 9);
insert into linkd(dokaz, clan, stav, tacka) values ('Uzimanje uredjaja za video nadzor sa lica mesta.', 114, 1, 11);
insert into linkd(dokaz, clan, stav, tacka) values ('Uzimanje uredjaja za video nadzor sa lica mesta.', 115, 0, 0);
insert into linkd(dokaz, clan, stav, tacka) values ('Uzimanje uredjaja za video nadzor sa lica mesta.', 118, 0, 0);
insert into linkd(dokaz, clan, stav, tacka) values ('Uzimanje uredjaja za video nadzor sa lica mesta.', 310, 0, 0);

insert into linkd(dokaz, clan, stav, tacka) values ('Vestacenja eksperata.', 113, 0, 0);
insert into linkd(dokaz, clan, stav, tacka) values ('Vestacenja eksperata.', 114, 1, 4);
insert into linkd(dokaz, clan, stav, tacka) values ('Vestacenja eksperata.', 114, 1, 9);
insert into linkd(dokaz, clan, stav, tacka) values ('Vestacenja eksperata.', 114, 1, 11);
insert into linkd(dokaz, clan, stav, tacka) values ('Vestacenja eksperata.', 115, 0, 0);
insert into linkd(dokaz, clan, stav, tacka) values ('Vestacenja eksperata.', 118, 0, 0);
insert into linkd(dokaz, clan, stav, tacka) values ('Vestacenja eksperata.', 310, 0, 0);

insert into linkd(dokaz, clan, stav, tacka) values ('Treba pribaviti dokaz o tome da je zrtva dete u vidu izvoda iz maticne knjige rodjenih, odnosno da je zrtva bremenita zena u vidu sudskomedicinskog vestacenja sa posebnim akcentom na tu okolnost', 114, 1, 9);

insert into linkd(dokaz, clan, stav, tacka) values ('Treba privaviti sudskopsihijatrisko i psiholosko vestacenje radi utvrdjivanja da li je ucinilac u vremeizvrsenja krivicnog dela bio u stanju jake razdrazenosti izazvane postupkom zrtve', 115, 0, 0);

insert into linkd(dokaz, clan, stav, tacka) values ('Treba pribaviti dokaz o sluzbi ili funkciji koje obavljala zrtva krvicnog dela u vidu resenja o zasnivanju radnog odnosa ili odluke o izboru ili imenovanju kako bi se dokazalo da zrtva ima to posebno svojstvo.', 310, 0, 0);



