/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicing.sales;

/**
 *
 * @author Maytopacka
 */
public class S1_multi_pricing {

    public static class to_multi_pricing {

        public final int id;
        public final double qty;
        public final String unit;
        public final double price;
        public  double invoice_qty;
        public final double conversion;

        public to_multi_pricing(int id, double qty, String unit, double price, double invoice_qty,double conversion) {
            this.id = id;
            this.qty = qty;
            this.unit = unit;
            this.price = price;
            this.invoice_qty = invoice_qty;
            this.conversion=conversion;
        }

        public double getInvoice_qty() {
            return invoice_qty;
        }

        public void setInvoice_qty(double invoice_qty) {
            this.invoice_qty = invoice_qty;
        }
        
    }
}
