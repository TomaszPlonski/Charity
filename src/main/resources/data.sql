insert ignore into categories(id, name) VALUES (1, 'pluszaki');
insert ignore into categories(id, name) VALUES (2, 'odzież');
insert ignore into categories(id, name) VALUES (3, 'zabawki');
insert ignore into categories(id, name) VALUES (4, 'pościel');

insert ignore into institutions(id, description, name) VALUES (1,'wsparcie osób starszych','fundacja Reinera Knizi');
insert ignore into institutions(id, description, name) VALUES (2,'wsparcie sierot','CMON organization');
insert ignore into institutions(id, description, name) VALUES (3,'wsparcie niepełnosprawnych','Nasza Fundacja');

insert ignore into donations(id, city, pick_up_comment, pick_up_date, pick_up_time, quantity, street, zip_code, institution_id)
VALUES (1,'Warszawa','Proszę dzwonić domofonem', DATE_ADD(CURRENT_DATE(),INTERVAL -2 DAY),CURRENT_TIME,5,'Marszałkowska 7','01-222',1);
insert ignore into donations_categories(donation_id, category_id) VALUES (1,1);
insert ignore into donations_categories(donation_id, category_id) VALUES (1,3);
insert ignore into donations_categories(donation_id, category_id) VALUES (1,4);

insert ignore into donations(id, city, pick_up_comment, pick_up_date, pick_up_time, quantity, street, zip_code, institution_id)
VALUES (2,'Kraków', null , DATE_ADD(CURRENT_DATE(),INTERVAL 4 DAY),'8:00:00',3,'Lazurowa 17','25-004',1);
insert ignore into donations_categories(donation_id, category_id) VALUES (2,2);
insert ignore into donations_categories(donation_id, category_id) VALUES (2,4);

insert ignore into donations(id, city, pick_up_comment, pick_up_date, pick_up_time, quantity, street, zip_code, institution_id)
VALUES (3,'Wrocław', 'pierwsze piętro' , DATE_ADD(CURRENT_DATE(),INTERVAL 10 DAY),'17:30:00',10,'Słomkowa 1','13-334',2);
insert ignore into donations_categories(donation_id, category_id) VALUES (3,3);

insert ignore into donations(id, city, pick_up_comment, pick_up_date, pick_up_time, quantity, street, zip_code, institution_id)
VALUES (4,'Poznań', '...' , DATE_ADD(CURRENT_DATE(),INTERVAL -1 DAY),'22:10:00',1,'Jajeczna 20','44-400',1);
insert ignore into donations_categories(donation_id, category_id) VALUES (4,1);
insert ignore into donations_categories(donation_id, category_id) VALUES (4,2);

