/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Ronescape
 * Created: Sep 13, 2019
 */



select serviced_by,service_by_id from my_services group by serviced_by,service_by_id  order by  service_by_id asc ;

insert into user_default_previlege_others(account,account_name,name)values('Reports','Services','Services Performance Report');


update my_services set service_by_id='17' where service_by_id='19' and serviced_by like 'Oscar Dipad';

update my_services set service_by_id='27' where service_by_id='19' and serviced_by like 'Eric Viliran';

update my_services set service_by_id='26' where service_by_id='19' and serviced_by like 'RENATO MIER';

update my_services set service_by_id='26' where service_by_id='' and serviced_by like 'Renato Mier';

update my_services set serviced_by='Paul  Crodua' where service_by_id='66' and serviced_by like 'Jesley  Cal';
update my_services set service_by_id='66' where service_by_id='21' and serviced_by like 'Paul  Crodua';

update my_services set serviced_by='Jetvic  Libo-on' where service_by_id='25' and serviced_by like 'Jetvic  Libu-on';
update my_services set serviced_by='Arvin  Vergara - TSG1' where service_by_id='32' and serviced_by like 'Arvin  Vergara';
update my_services set serviced_by='Jesley&Victor' where service_by_id='34' and serviced_by like 'Jesley & Victor';

update my_services set serviced_by='Jesley  Cal' where service_by_id='21' ;

update my_services set service_by_id='66' where service_by_id='60' ;

