/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  User
 * Created: 08 11, 21
 */

alter table my_services add sales_id int;
alter table my_services add sales_no varchar(255);


alter table my_services_item_replacements_customers add sales_id int;
alter table my_services_item_replacements_customers add sales_no varchar(255);

insert into  user_default_previleges (account,name)values('Maintenance','Service Departments');
insert into  user_default_previleges (account,name)values('Maintenance','Service Department Members');
insert into  user_default_previleges (account,name)values('Maintenance','Service Transaction Type');


insert into  user_default_previleges (account,name)values('Transactions','Services-Transaction');


alter table sale_slip_nos add department varchar(255);
alter table sale_slip_nos add department_id int default 0;

alter table my_services add release_date datetime;
alter table my_services add released_by_id int;
alter table my_services add released_by_screen_name varchar(255);

alter table my_services_item_replacements_customers add release_date datetime;
alter table my_services_item_replacements_customers add released_by_id int;
alter table my_services_item_replacements_customers add released_by_screen_name varchar(255);






