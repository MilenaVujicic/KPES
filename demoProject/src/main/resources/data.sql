/*
 *Tuzioci
 */

insert into tuzilac(tip) values('OSNOVNI_JAVNI_TUZILAC');
insert into tuzilac(tip) values('VISI_JAVNI_TUZILAC');
insert into tuzilac(tip) values('TUZILAC_ZA_MALOLETNIKE');
insert into tuzilac(tip) values('TUZILAC_ZA_ORGANIZOVANI_KRIMINAL');
insert into tuzilac(tip) values ('TUZILAC_ZA_RATNE_ZLOCINE');

/*
 * 113 
*/

insert into obelezje(izvrsilac, vreme, mesto, radnja, posledica, subjektivan_odnos) values ('svako', 'svako', 'svako', 'podobna da prouzrokuje smrt', 'smrt, odmah ili kasije', 'umisljaj');
insert into obelezje(zrtva) values ('Vise od 18');

insert into delo(naziv, min_kazna, max_kazna, clan, stav, tacka, opste_obelezje_id, posebno_obelezje_id) values ('Ubistvo', 5, 15, 113, 0, 0, 1, 2);

/*
* 114 1 1 
*/

insert into obelezje(izvrsilac, vreme, mesto, radnja, posledica, subjektivan_odnos) values('svako', 'svako', 'svako', 'podobna da prouzrokuje smrt', 'smrt, odmah ili kasije', 'umisljaj');
insert into obelezje(zrtva, nacin) values ('Vise od 18', 'Svirep ili podmukao');

insert into delo(naziv, min_kazna, max_kazna, clan, stav, tacka, opste_obelezje_id, posebno_obelezje_id) values ('Tesko ubistvo', 5, 100, 114, 1, 1, 3, 4);

/*
* 114 1 2
*/

insert into obelezje(izvrsilac, vreme, mesto, radnja, posledica, zrtva, subjektivan_odnos) values('svako', 'svako', 'svako', 'podobna da prouzrokuje smrt', 'smrt, odmah ili kasije', 'Vise od 18', 'umisljaj');
insert into obelezje(radnja) values('bezobzirno nasilnicko ponasanje');

insert into delo(naziv, min_kazna, max_kazna, clan, stav, tacka, opste_obelezje_id, posebno_obelezje_id) values ('Tesko ubistvo', 5, 100, 114, 1, 2, 5, 6);

/*
* 114 1 3
*/

insert into obelezje(izvrsilac, vreme, mesto, radnja, posledica, zrtva, subjektivan_odnos) values('svako', 'svako', 'svako', 'podobna da prouzrokuje smrt', 'smrt, odmah ili kasije', 'Vise od 18', 'umisljaj');
insert into obelezje(radnja) values('u opasnost doveden zivot jos nekog lica');

insert into delo(naziv, min_kazna, max_kazna, clan, stav, tacka, opste_obelezje_id, posebno_obelezje_id) values('Tesko ubistvo', 5, 100, 114, 1, 3, 7, 8);

/*
* 114 1 4
*/
insert into obelezje(izvrsilac, vreme, mesto, radnja, posledica, subjektivan_odnos, zrtva) values ('svako', 'svako', 'svako', 'podobna da prouzrokuje smrt', 'srmt, odmah ili kasnije', 'umisljaj','Vise od 18');
insert into obelezje(radnja) values ( 'Razbojnistvo&Kradja');

insert into delo(naziv, min_kazna, max_kazna, clan, stav, tacka, opste_obelezje_id, posebno_obelezje_id) values ('Tesko ubistvo', 10, 100, 114, 1, 4, 9, 10);

/*
* 114 1 5
*/

insert into obelezje(izvrsilac, vreme, mesto, radnja, posledica, subjektivan_odnos, zrtva) values ('svako', 'svako', 'svako', 'podobna da prouzrokuje smrt', 'srmt, odmah ili kasnije', 'umisljaj','Vise od 18');
insert into obelezje(radnja) values ('radnja izvrsenja je preduzeta iz niskih pobuda');

insert into delo(naziv, min_kazna, max_kazna, clan, stav, tacka, opste_obelezje_id, posebno_obelezje_id) values('Tesko ubistvo', 10, 100, 114, 1, 5, 11, 12);

/*
* 114 1 6
*/
insert into obelezje(izvrsilac, vreme, mesto, radnja, posledica, subjektivan_odnos, zrtva) values ('svako', 'svako', 'svako', 'podobna da prouzrokuje smrt', 'srmt, odmah ili kasnije', 'umisljaj','Vise od 18');
insert into obelezje(zrtva) values('status sluzbenog ili vojnog lica koje vrsi svoju duznost');

insert into delo(naziv, min_kazna, max_kazna, clan, stav, tacka, opste_obelezje_id, posebno_obelezje_id) values('Tesko ubistvo', 10, 100, 114, 1, 6, 13, 14);

/*
 * 114 1 7 
 */
insert into obelezje(izvrsilac, vreme, mesto, radnja, posledica, subjektivan_odnos, zrtva) values ('svako', 'svako', 'svako', 'podobna da prouzrokuje smrt', 'srmt, odmah ili kasnije', 'umisljaj','Vise od 18');
insert into obelezje(zrtva) values('status sudije, javnog tuzioca, zamenika javnog tuzioca ili policijskog sluzbenika koji vrsi svoju duznost');

insert into delo(naziv, min_kazna, max_kazna, clan, stav, tacka, opste_obelezje_id, posebno_obelezje_id) values('Tesko ubistvo', 10, 100, 114, 1, 7, 15, 16);

/*
 * 114 1 8 
 */

insert into obelezje(izvrsilac, vreme, mesto, radnja, posledica, subjektivan_odnos, zrtva) values ('svako', 'svako', 'svako', 'podobna da prouzrokuje smrt', 'srmt, odmah ili kasnije', 'umisljaj','Vise od 18');
insert into obelezje(zrtva) values('svojstvo lica koje obavlja poslove od javnog znacaja pri obavljanju tih poslova');

insert into delo(naziv, min_kazna, max_kazna, clan, stav, tacka, opste_obelezje_id, posebno_obelezje_id) values('Tesko ubistvo', 10, 100, 114, 1, 8, 17, 18);

/*
 * 114 1 9
 */
insert into obelezje(izvrsilac, vreme, mesto, radnja, posledica, subjektivan_odnos) values ('svako', 'svako', 'svako', 'podobna da prouzrokuje smrt', 'smrt, odmah ili kasnije', 'umisljaj');
insert into obelezje(zrtva) values ('Izmedju 18 i 14&Manje od 14&Bremenita zena');

insert into delo(naziv, min_kazna, max_kazna, clan, stav, tacka, opste_obelezje_id, posebno_obelezje_id) values ('Tesko ubistvo', 10, 100, 114, 1, 9, 19, 20);

/*
 * 114 1 10
 */
insert into obelezje(izvrsilac, vreme, mesto, radnja, posledica, subjektivan_odnos, zrtva) values ('svako', 'svako', 'svako', 'podobna da prouzrokuje smrt', 'srmt, odmah ili kasnije', 'umisljaj','Vise od 18');
insert into obelezje(zrtva) values('svojstvo zlostavljanog clana porodice izvrisoca');

insert into delo(naziv, min_kazna, max_kazna, clan, stav, tacka, opste_obelezje_id, posebno_obelezje_id) values('Tesko ubistvo', 10, 100, 114, 1, 10, 21, 22);

/*
* 114 1 11
*/

insert into obelezje(izvrsilac, vreme, mesto, radnja, posledica, subjektivan_odnos) values ('svako', 'svako', 'svako', 'podobna da prouzrokuje smrt', 'smrt, odmah ili kasnije', 'umisljaj');
insert into obelezje(zrtva) values ('sve zrtve&>Vise od 18');

insert into delo(naziv, min_kazna, max_kazna, clan, stav, tacka, opste_obelezje_id, posebno_obelezje_id) values ('Tesko ubistvo', 10, 100, 114, 1, 11, 23, 24);

/*
* 115
*/

insert into obelezje(izvrsilac, vreme, mesto, radnja, posledica, zrtva, subjektivan_odnos) values ('svako', 'svako', 'svako' ,'podobna da prouzrokuje smrt', 'smrt, odmah ili kasnije', 'Vise od 18', 'umisljaj');
insert into obelezje(radnja, zrtva, izvrsilac) values ('prethodio napad', 'jedan ili vise zlostavljaca', 'doveden u posebno psihicko stanje');

insert into delo(naziv, min_kazna, max_kazna, clan, stav, tacka, opste_obelezje_id, posebno_obelezje_id) values ('Ubistvo na mah', 1, 8, 115, 0, 0, 25, 26);

/*
* 118 
*/

insert into obelezje(izvrsilac, vreme, mesto, radnja, posledica) values ('svako', 'svako', 'svako', 'podobna da prouzrokuje smrt', 'smrt, odmah ili kasnije');
insert into obelezje(subjektivan_odnos, zrtva) values ('Nehat', 'svako');

insert into delo(naziv, min_kazna, max_kazna, clan, stav, tacka, opste_obelezje_id, posebno_obelezje_id) values ('Nehatno lisenje zivota', 0.5, 5, 118, 0, 0, 27, 28);

/*
* 310
*/


insert into obelezje(izvrsilac, vreme, mesto, radnja, posledica) values ('svako', 'svako', 'svako', 'podobna da prouzrokuje smrt', 'smrt, odmah ili kasnije');
insert into obelezje(subjektivan_odnos, zrtva) values ('Nehat', 'svako');

insert into delo(naziv, min_kazna, max_kazna, clan, stav, tacka, opste_obelezje_id, posebno_obelezje_id) values ('Nehatno lisenje zivota', 0.5, 5, 118, 0, 0, 29, 30);

/*
 * Dokazi
 */

/*
 * Opsti dokazi
 */

insert into dokaz_root(clan, stav, tacka, osnovni_opis) values (0, 0, 0, 'Uvidjaj na licu mesta');
insert into dokaz_leaf(dokaz_parent_id, opis) values (1, 'Pravljenje zapisnika');
insert into dokaz_leaf(opis, opis_parent_id) values('Pravljenje video snimka lica mesta', 1);
insert into dokaz_leaf(opis, opis_parent_id) values('Pravljenje fotografija lica mesta', 1);
insert into dokaz_leaf(opis, opis_parent_id) values('Pravljenje skice lica mesta', 1);

insert into dokaz_root(clan, stav, tacka, osnovni_opis) values (0, 0, 0, 'Uzimanje tragova sa lica mesta');
insert into dokaz_leaf(dokaz_parent_id, opis) values (2, 'Uzimanje bioloskih tragova');
insert into dokaz_leaf(opis, opis_parent_id) values('Uzimanje otisaka sa prstiju i dlanova', 5);
insert into dokaz_leaf(dokaz_parent_id, opis) values(2, 'Uzimanje krvi, dlake, pljuvacke');
insert into dokaz_leaf(dokaz_parent_id, opis) values(2, 'Uzimanje sredstava izvrsenja dela');
insert into dokaz_leaf(opis, opis_parent_id) values('Uzimanje oruzija', 8);
insert into dokaz_leaf(opis, opis_parent_id) values('Uzimanje hrane ili tecnosti kojim je neko otrovan', 8);
insert into dokaz_leaf(dokaz_parent_id, opis) values(2, 'Uzimanje otisaka obuce');
insert into dokaz_leaf(dokaz_parent_id, opis) values(2, 'Uzimanje otisaka pneumatika vozila');

insert into dokaz_root(clan, stav, tacka, osnovni_opis) values (0, 0, 0, 'Pregled izvrsioca krivicnog dela');
insert into dokaz_leaf(dokaz_parent_id, opis) values(3, 'Uzimanje krvi i urina');
insert into dokaz_leaf(dokaz_parent_id, opis) values(3, 'Uzimanje podnokatnog sadrzaja');
insert into dokaz_leaf(dokaz_parent_id, opis) values(3, 'Uzimanje bukalnog brisa');
insert into dokaz_leaf(dokaz_parent_id, opis) values(3, 'Uzimanje tragova krivicnog dela');
insert into dokaz_leaf(opis, opis_parent_id) values('Tragovi tudje krvi', 16);
insert into dokaz_leaf(opis, opis_parent_id) values('Tragovi barutnih cestica', 16);

insert into dokaz_root(clan, stav, tacka, osnovni_opis) values (0, 0, 0, 'Uzimanje odece i obuce ucinioca krivicnog dela');

insert into dokaz_root(clan, stav, tacka, osnovni_opis) values (0, 0, 0, 'Uzimanje uredjaja za nadzor sa lica mesta');

insert into dokaz_root(clan, stav, tacka, osnovni_opis) values (0, 0, 0, 'Uzimanja uredjaja za elektronsku obradu podataka sa lica mesta');

insert into dokaz_root(clan, stav, tacka, osnovni_opis) values (0, 0, 0, 'Potrebna vestacenja');


/*
* 114 1 1
*/
insert into dokaz_root(clan, stav, tacka, osnovni_opis) values (114, 1, 1, 'Sudsko medicinsko vestacnje');
insert into dokaz_leaf(dokaz_parent_id, opis) values(8, 'Vrsta povrede');
insert into dokaz_leaf(dokaz_parent_id, opis) values(8, 'Tezina povrede');
insert into dokaz_leaf(dokaz_parent_id, opis) values(8, 'mehanizam nanosenja povrede');

/*
* 114 1 5
*/
insert into dokaz_root(clan, stav, tacka, osnovni_opis) values (114, 1, 5, 'Pretresanje stana');
insert into dokaz_leaf(dokaz_parent_id, opis) values(9, 'Izvrsioca krivicnog dela');
insert into dokaz_leaf(dokaz_parent_id, opis) values(9, 'Bliskih srodinka izvrsioca krivicnog dela');
insert into dokaz_root(clan, stav, tacka, osnovni_opis) values (114, 1, 5, 'Provera finansija zrtve');

/*
* 114 1 6
*/
insert into dokaz_root(clan, stav, tacka, osnovni_opis) values (114, 1, 6, 'Dokaz o sluzbi ili funkciji koju je obavljala zrtva');

/*
* 114 1 7
*/
insert into dokaz_root(clan, stav, tacka, osnovni_opis) values (114, 1, 7, 'Dokaz o sluzbi ili funkciji koju je obavljala zrtva');

/*
* 114 1 8
*/
insert into dokaz_root(clan, stav, tacka, osnovni_opis) values (114, 1, 8, 'Dokaz o sluzbi ili funkciji koju je obavljala zrtva');

/*
 * 114 1 9
 */
insert into dokaz_root(clan, stav, tacka, osnovni_opis) values (114, 1, 9, 'Dokaz da je zrtva bila dete');
insert into dokaz_root(clan, stav, tacka, osnovni_opis) values (114, 1, 9, 'Dokaz da je zrtva bila bremenita zena');

/*
 * 114 1 10
 */
insert into dokaz_root(clan, stav, tacka, osnovni_opis) values (114, 1, 9, 'Dokaz da je pocinilac clan porodice');
insert into dokaz_leaf(dokaz_parent_id, opis) values(16, 'Izvod iz maticne knjige rodjenih');
insert into dokaz_leaf(dokaz_parent_id, opis) values(16, 'Izvod iz maticne knjige vencanih');
insert into dokaz_leaf(dokaz_parent_id, opis) values(16, 'Resenje o starateljstvu ili hraniteljskom odnosu');

/*
 * 115 
 */
insert into dokaz_root(clan, stav, tacka, osnovni_opis) values (114, 1, 9, 'Sudsko psiholosko vestacenje pocinioca');

/*
 * 310
 */

insert into dokaz_root(clan, stav, tacka, osnovni_opis) values (310, 0, 0, 'Dokaz o sluzbi ili funkciji koju je obavljala zrtva');