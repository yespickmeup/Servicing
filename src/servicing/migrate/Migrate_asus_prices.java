/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicing.migrate;

import servicing.inventory.Inventory_barcodes;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mijzcx.synapse.desk.utils.FitIn;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDataFormatter;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellReference;

/**
 *
 * @author User
 */
public class Migrate_asus_prices {

    public static class asus {

        public final String pn_rule;
        public final String product_type;
        public final String part_description;
        public final String spec;
        public final String currency;
        public final double cost;
        public final double price;
        public final double amount;

        public asus(String pn_rule, String product_type, String part_description, String spec, String currency, double cost, double price, double amount) {
            this.pn_rule = pn_rule;
            this.product_type = product_type;
            this.part_description = part_description;
            this.spec = spec;
            this.currency = currency;
            this.cost = cost;
            this.price = price;
            this.amount = amount;
        }

    }

    public static void update_asus() {
        
        String file = "C:\\Users\\Public\\asus2.xls";

        if (file == null || file.isEmpty()) {
            return;
        }
        FileInputStream fis = null;
        final List sheetData = new ArrayList();
        try {
            fis = new FileInputStream(file);
            HSSFWorkbook workbook = new HSSFWorkbook(fis);
            HSSFSheet sheet = workbook.getSheetAt(0);
            Iterator rows = sheet.rowIterator();
            while (rows.hasNext()) {
                HSSFRow row = (HSSFRow) rows.next();
                Iterator cells = row.cellIterator();

                List data = new ArrayList();
                while (cells.hasNext()) {
                    HSSFCell cell = (HSSFCell) cells.next();
                    data.add(cell);
                }
                sheetData.add(data);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {

            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException ex) {
//                    Logger.getLogger(Excel_to_db_inventory_items.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        List<Inventory_barcodes.to_inventory_barcodes> invs = Inventory_barcodes.ret_where(" where location_id=32 ");
        List<asus> datas = Migrate_asus_prices.showExcelData_asus(sheetData, file);
        List<asus> to_update = new ArrayList();
        for (asus asus : datas) {
            for (Inventory_barcodes.to_inventory_barcodes inv : invs) {
                if (inv.main_barcode.equalsIgnoreCase(asus.pn_rule)) {
                    to_update.add(asus);
                }
            }
//            System.out.println(asus.pn_rule);
        }
        Inventory_barcodes.edit_inventory_barcodes_price(to_update);
        System.out.println("size:" + datas.size());
        System.out.println("to_update:" + to_update.size());

    }

    public static void main(String[] args) {
        System.setProperty("pool_db", "db_algorithm");
        System.setProperty("pool_password", "password");

    }

    public static List<asus> showExcelData_asus(List sheetData, String path) {

        FileInputStream fis;
        List<asus> datas = new ArrayList();
        try {
            fis = new FileInputStream(path);
            int r = 0;
            int r_set = 1;
            int id = 0;
            for (int i = 0; i < sheetData.size(); i++) {
                List list = (List) sheetData.get(i);
                int size = list.size();
                String[] record = new String[8];
                int record_size = 0;
                for (int j = 0; j < list.size(); j++) {

                    CellReference cellReference = new CellReference("B3");
                    HSSFCell cell = (HSSFCell) list.get(j);
                    HSSFDataFormatter hdf = new HSSFDataFormatter();
                    String data = "";
                    if (j >= 8) {
                        break;
                    }
                    if (j == 5 || j == 6 || j == 7) {
                        try {
                            data = "" + cell.getNumericCellValue();
                        } catch (Exception e) {
                            data = "" + cell.getStringCellValue();
                        }
                    } else {

                        try {
                            data = "" + cell.getStringCellValue();
                        } catch (Exception e) {
                            data = "" + cell.getNumericCellValue();
                        }
                    }

                    record[record_size] = data;
                    record_size++;
                }

                String pn_rule = record[0];
                String product_type = record[1];
                String part_description = record[2];
                String spec = record[3];
                String currency = record[4];
                double cost = FitIn.toDouble(record[5]);
                double price = FitIn.toDouble(record[6]);
                double amount = FitIn.toDouble(record[7]);

                asus asus = new asus(pn_rule, product_type, part_description, spec, currency, cost, price, amount);
                if (record[0] != null) {
                    datas.add(asus);
                }

            }
        } catch (FileNotFoundException ex) {
//            Logger.getLogger(Excel_to_db_inventory_items.class.getName()).log(Level.SEVERE, null, ex);
        }

        return datas;
    }
}
