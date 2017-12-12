/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Guinness
 * Created: Jun 4, 2016
 */

drop table if exists my_services_barcodes_customers;
create table my_services_barcodes_customers(
id int auto_increment primary key
,customer_id varchar(255)
,customer_name varchar(255)
,transaction_no varchar(255)
,date_added datetime
,barcode varchar(255)
,branch varchar(255)
,branch_id varchar(255)
,location varchar(255)
,location_id varchar(255)
);
 