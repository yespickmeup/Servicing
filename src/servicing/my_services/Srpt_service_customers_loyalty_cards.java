/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicing.my_services;

import java.util.List;

/**
 *
 * @author Guinness
 */
public class Srpt_service_customers_loyalty_cards {

    public static List<field> fields;
    
    public static class field {

        String customer_name;
        String customer_id;

        public field() {
        }

        public field(String customer_name, String customer_id) {
            this.customer_name = customer_name;
            this.customer_id = customer_id;
        }

        public String getCustomer_name() {
            return customer_name;
        }

        public void setCustomer_name(String customer_name) {
            this.customer_name = customer_name;
        }

        public String getCustomer_id() {
            return customer_id;
        }

        public void setCustomer_id(String customer_id) {
            this.customer_id = customer_id;
        }
    }
    
}
