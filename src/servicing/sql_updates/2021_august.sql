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

alter table my_services set 