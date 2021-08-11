/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicing.unit_of_measure;

/**
 *
 * @author Guinness
 */
public class S1_unit_of_measure {

    public static class to_uom {
        
        public String unit;
        public double price;
        public double conversion;
        public int is_default;

        public to_uom(String unit, double price, double conversion, int is_default) {
            this.unit = unit;
            this.price = price;
            this.conversion = conversion;
            this.is_default = is_default;
        }

        public String getUnit() {
            return unit;
        }

        public void setUnit(String unit) {
            this.unit = unit;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public double getConversion() {
            return conversion;
        }

        public void setConversion(double conversion) {
            this.conversion = conversion;
        }

        public int getIs_default() {
            return is_default;
        }

        public void setIs_default(int is_default) {
            this.is_default = is_default;
        }

    }

    public static void main(String[] args) {

    }
}
