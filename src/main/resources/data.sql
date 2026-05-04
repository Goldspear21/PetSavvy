DELETE FROM user WHERE userid = 1;
DELETE FROM user WHERE userid = 2;
DELETE FROM user WHERE userid = 3;
DELETE FROM user WHERE userid = 4;

delete from rescuedanimal where tagid=1;
delete from rescuedanimal where tagid=2;
delete from rescuedanimal where tagid=3;
delete from rescuedanimal where tagid=4;
delete from rescuedanimal where tagid=5;

delete from pet where petid=1;
delete from pet where petid=2;
delete from pet where petid=3;
delete from pet where petid=4;
delete from pet where petid=5;

delete from customer where cust_number=1;
delete from customer where cust_number=2;


insert into customer(cust_number,custemail,custfirstname,custlastname,custphone) values
(1,"ld6733@rit.edu","Loretta","naynay","09712345"),
(2,"anh3100@rit.edu", "Afnan", "Hassan", "09712345");

INSERT INTO user (userid, password, usermail, username) VALUES
(1, "jason", "jnv8919@rit.edu", "Jason"),
(2, "bhargav", "bs1310@rit.edu", "Bhargav"),
(3, "afnan", "anh3100@rit.edu", "Afnan"),
(4, "loretta", "ld6733@rit.edu", "Loretta");


INSERT INTO pet (petid, pet_birthdate, pet_name, pet_type, pet_price, pet_status, pet_vaccinated) VALUES
(1, '2020-01-01', 'Buddy', 'Dog',200,  'available', true),
(2, '2019-05-15', 'Mittens', 'Cat', 150, 'available', true),
(3, '2021-03-10', 'Charlie', 'Rabbit', 250, 'available', false),
(4, '2018-11-20', 'Luna', 'Bird', 180, 'available', true),
(5, '2020-07-25', 'Max', 'Hamster', 220, 'available', false);

INSERT INTO rescuedanimal (tagid,rescued_name,rescue_location,rescue_date,species, vaccination,cuteness) VALUES 
(1, 'Godrick', 'Stormveil Castle', '2021-03-10','Horse',  false, true),
(2, 'Godfrey', 'Leyndell', '2019-05-15', 'Cat', true, true),
(3, 'Margit', 'Northwest Limgrave', '2022-03-10', 'Dog', true, true),
(4, 'Radahn', 'Wailing Dunes', '2018-11-20', 'Bird', false, true),
(5, 'Malenia', 'Brace of the Haligtree', '2020-07-25', 'Rabbit', false, true);