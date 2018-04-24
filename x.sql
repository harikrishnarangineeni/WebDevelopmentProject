drop table Users 
create sequence pp
start with 1
increment by 1
delete from SETUP where type='Standard'
select * from SETUP
update SETUP set type = 'Standard' where type ='Standard';
select * from inventory
update  USERS s set  s.U_TYPE = 'Admin' 
select * from INVENTORY;
insert into INVENTORY values (44,'HD',1017,10009,31,21,'assignedtoretailer',17);
insert into INVENTORY values (45,'HD+',1018,10010,32,22,'assignedtoretailer',18);
insert into INVENTORY values (46,'Standard',1011,10003,25,15,'assignedtoretailer',17);
insert into INVENTORY values (47,'IPTV',1012,10004,26,16,'assignedtoretailer',18);
insert into INVENTORY values (48,'HD+',1013,10005,27,17,'assignedtoretailer',17);
insert into INVENTORY values (49,'IPTV',1014,10006,28,18,'assignedtoretailer',18);
insert into INVENTORY values (50,'HD',1015,10007,29,19,'assignedtoretailer',17);
insert into INVENTORY values (51,'HD',1016,10008,30,20,'assignedtoretailer',18);
delete from INVENTORY where retailerid = 3;
delete from SETUP where SETUPID > 8
update INVENTORY set status='assignedtoretailer'
select * from retailer;
select * from users;
update users s set s.password='excellence' where s.U_ID = 29
insert into users values(41,'Customer','manoj143');
insert into users values(42,'Customer','tcs123');
insert into users values(44,'Customer','raji12')
insert into users values(43,'Customer','hari123')
insert into users values(45,'Customer','lokesh123')
insert into users values(46,'Customer','nitish123')

select * from bil;
delete from CUSTOMER c where c.CustId=3;
delete from RETAILER where retailerId = 3;
drop table  customer;
drop table price2
drop table price;
drop table setup ;
drop table retailer;
drop table inventory;
drop table Customer_Package_P
select * from bil
drop TABLE bil
drop table datepre;
select * from pre

drop table packlist
select * from Package_Gpacklist
select * from PACKAGE_G;
select * from CHANNEL_G;
 select * from package_channel_G
insert into table CHANNEL_E values(1,'maatv')
insert into table Package_F values(100,'Telugu1');
create table STBPACKAGE_G (serialNo number(10),packageName varchar2(10),Type number(10),packageId number(10))
insert into  STBPACKAGE_G values(1,'Y',1,100);
insert into  STBPACKAGE_G values(33,'Y',1,103);
insert into  STBPACKAGE_G values(2,'N',1,101);
insert into  STBPACKAGE_G values(17,'N',1,1000);

insert into  STBPACKAGE_G values(3,'Y',2,100);
insert into  STBPACKAGE_G values(4,'N',2,101);
insert into  STBPACKAGE_G values(18,'N',2,1000);
insert into  STBPACKAGE_G values(34,'Y',2,103);

insert into  STBPACKAGE_G values(5,'Y',3,100);
insert into  STBPACKAGE_G values(6,'N',3,101);
insert into  STBPACKAGE_G values(19,'N',3,1000);
insert into  STBPACKAGE_G values(35,'Y',3,103);

insert into  STBPACKAGE_G values(7,'Y',4,100);
insert into  STBPACKAGE_G values(8,'N',4,101);
insert into  STBPACKAGE_G values(20,'N',4,1000);
insert into  STBPACKAGE_G values(36,'Y',4,103);


insert into  STBPACKAGE_G values(9,'Y',5,100);
insert into  STBPACKAGE_G values(10,'N',5,101);
insert into  STBPACKAGE_G values(21,'N',5,1000);
insert into  STBPACKAGE_G values(37,'Y',5,103);

insert into  STBPACKAGE_G values(11,'Y',6,100);
insert into  STBPACKAGE_G values(12,'N',6,101);
insert into  STBPACKAGE_G values(22,'N',6,1000);
insert into  STBPACKAGE_G values(38,'Y',6,103);





insert into  STBPACKAGE_G values(13,'Y',7,100);
insert into  STBPACKAGE_G values(14,'N',7,101);
insert into  STBPACKAGE_G values(23,'N',7,1000);
insert into  STBPACKAGE_G values(39,'Y',7,103);

insert into  STBPACKAGE_G values(15,'Y',8,100);
insert into  STBPACKAGE_G values(16,'N',8,101);
insert into  STBPACKAGE_G values(24,'N',8,1000);
insert into  STBPACKAGE_G values(40,'Y',8,103);
select * from customer ;
select * from Bil
select * from Bil_datecol
select * from packlist1
SELECT * FROM pres
drop table Bil_datecol
drop table packlist1