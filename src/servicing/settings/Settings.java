/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicing.settings;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mijzcx.synapse.desk.utils.Lg;
import mijzcx.synapse.desk.utils.SqlStringUtil;
import servicing.utils.MyConnection;

/**
 *
 * @author Guinness
 */
public class Settings {

    public static class to_settings {

        public final int id;
        public final String company_name;
        public final String company_address;
        public final String company_operated_by;
        public final String company_slogan;
        public final String company_contact_no;
        public final String company_fax_no;
        public final String company_email_address;
        public final String bir_serial_no;
        public final String bir_permit_no;
        public final String bir_accreditation_no;
        public final String bir_tin;
        public final String bir_machine_no;
        public final String bir_min_no;
        public final String bir_business_type;
        public final String bir_vat_percent;
        public final String bir_receipt_footer;
        public final String bir_invoice_footer;
        public final int receipt_printing_enabled;
        public final int receipt_printer_show_dialog;
        public final int kitchen_printing_enable;
        public final int allow_negative_inventory;
        public final int is_server;
        public final String location;
        public final int receipt_printing_enabled2;
        public final String drawer;
        public final String developer;
        public final String developer_address;
        public final String developer_tin_no;
        public final String developer_accreditation_no;
        public final String developer_accreditation_date;
        public final String developer_contact_no;
        public final String module_software_type;
        public final int module_accounts_payable;
        public final int module_accounts_receivable;
        public final int module_services;
        public final int module_prepayments;
        public final int module_requisition_slip;
        public final int module_charge_in_advance;

        public to_settings(int id, String company_name, String company_address, String company_operated_by, String company_slogan, String company_contact_no, String company_fax_no, String company_email_address, String bir_serial_no, String bir_permit_no, String bir_accreditation_no, String bir_tin, String bir_machine_no, String bir_min_no, String bir_business_type, String bir_vat_percent, String bir_receipt_footer, String bir_invoice_footer, int receipt_printing_enabled, int receipt_printer_show_dialog, int kitchen_printing_enable, int allow_negative_inventory, int is_server, String location, int receipt_printing_enabled2, String drawer, String developer, String developer_address, String developer_tin_no, String developer_accreditation_no, String developer_accreditation_date, String developer_contact_no, String module_software_type, int module_accounts_payable, int module_accounts_receivable, int module_services, int module_prepayments, int module_requisition_slip, int module_charge_in_advance) {
            this.id = id;
            this.company_name = company_name;
            this.company_address = company_address;
            this.company_operated_by = company_operated_by;
            this.company_slogan = company_slogan;
            this.company_contact_no = company_contact_no;
            this.company_fax_no = company_fax_no;
            this.company_email_address = company_email_address;
            this.bir_serial_no = bir_serial_no;
            this.bir_permit_no = bir_permit_no;
            this.bir_accreditation_no = bir_accreditation_no;
            this.bir_tin = bir_tin;
            this.bir_machine_no = bir_machine_no;
            this.bir_min_no = bir_min_no;
            this.bir_business_type = bir_business_type;
            this.bir_vat_percent = bir_vat_percent;
            this.bir_receipt_footer = bir_receipt_footer;
            this.bir_invoice_footer = bir_invoice_footer;
            this.receipt_printing_enabled = receipt_printing_enabled;
            this.receipt_printer_show_dialog = receipt_printer_show_dialog;
            this.kitchen_printing_enable = kitchen_printing_enable;
            this.allow_negative_inventory = allow_negative_inventory;
            this.is_server = is_server;
            this.location = location;
            this.receipt_printing_enabled2 = receipt_printing_enabled2;
            this.drawer = drawer;
            this.developer = developer;
            this.developer_address = developer_address;
            this.developer_tin_no = developer_tin_no;
            this.developer_accreditation_no = developer_accreditation_no;
            this.developer_accreditation_date = developer_accreditation_date;
            this.developer_contact_no = developer_contact_no;
            this.module_software_type = module_software_type;
            this.module_accounts_payable = module_accounts_payable;
            this.module_accounts_receivable = module_accounts_receivable;
            this.module_services = module_services;
            this.module_prepayments = module_prepayments;
            this.module_requisition_slip = module_requisition_slip;
            this.module_charge_in_advance = module_charge_in_advance;
        }
    }

    public static void add_data(to_settings to_settings) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into settings("
                    + "company_name"
                    + ",company_address"
                    + ",company_operated_by"
                    + ",company_slogan"
                    + ",company_contact_no"
                    + ",company_fax_no"
                    + ",company_email_address"
                    + ",bir_serial_no"
                    + ",bir_permit_no"
                    + ",bir_accreditation_no"
                    + ",bir_tin"
                    + ",bir_machine_no"
                    + ",bir_min_no"
                    + ",bir_business_type"
                    + ",bir_vat_percent"
                    + ",bir_receipt_footer"
                    + ",bir_invoice_footer"
                    + ",receipt_printing_enabled"
                    + ",receipt_printer_show_dialog"
                    + ",kitchen_printing_enable"
                    + ",allow_negative_inventory"
                    + ",is_server"
                    + ",location"
                    + ",receipt_printing_enabled2"
                    + ",drawer"
                    + ",developer"
                    + ",developer_address"
                    + ",developer_tin_no"
                    + ",developer_accreditation_no"
                    + ",developer_accreditation_date"
                    + ",developer_contact_no"
                    + ")values("
                    + ":company_name"
                    + ",:company_address"
                    + ",:company_operated_by"
                    + ",:company_slogan"
                    + ",:company_contact_no"
                    + ",:company_fax_no"
                    + ",:company_email_address"
                    + ",:bir_serial_no"
                    + ",:bir_permit_no"
                    + ",:bir_accreditation_no"
                    + ",:bir_tin"
                    + ",:bir_machine_no"
                    + ",:bir_min_no"
                    + ",:bir_business_type"
                    + ",:bir_vat_percent"
                    + ",:bir_receipt_footer"
                    + ",:bir_invoice_footer"
                    + ",:receipt_printing_enabled"
                    + ",:receipt_printer_show_dialog"
                    + ",:kitchen_printing_enable"
                    + ",:allow_negative_inventory"
                    + ",:is_server"
                    + ",:location"
                    + ",:receipt_printing_enabled2"
                    + ",:drawer"
                    + ",:developer"
                    + ",:developer_address"
                    + ",:developer_tin_no"
                    + ",:developer_accreditation_no"
                    + ",:developer_accreditation_date"
                    + ",:developer_contact_no"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("company_name", to_settings.company_name)
                    .setString("company_address", to_settings.company_address)
                    .setString("company_operated_by", to_settings.company_operated_by)
                    .setString("company_slogan", to_settings.company_slogan)
                    .setString("company_contact_no", to_settings.company_contact_no)
                    .setString("company_fax_no", to_settings.company_fax_no)
                    .setString("company_email_address", to_settings.company_email_address)
                    .setString("bir_serial_no", to_settings.bir_serial_no)
                    .setString("bir_permit_no", to_settings.bir_permit_no)
                    .setString("bir_accreditation_no", to_settings.bir_accreditation_no)
                    .setString("bir_tin", to_settings.bir_tin)
                    .setString("bir_machine_no", to_settings.bir_machine_no)
                    .setString("bir_min_no", to_settings.bir_min_no)
                    .setString("bir_business_type", to_settings.bir_business_type)
                    .setString("bir_vat_percent", to_settings.bir_vat_percent)
                    .setString("bir_receipt_footer", to_settings.bir_receipt_footer)
                    .setString("bir_invoice_footer", to_settings.bir_invoice_footer)
                    .setNumber("receipt_printing_enabled", to_settings.receipt_printing_enabled)
                    .setNumber("receipt_printer_show_dialog", to_settings.receipt_printer_show_dialog)
                    .setNumber("kitchen_printing_enable", to_settings.kitchen_printing_enable)
                    .setNumber("allow_negative_inventory", to_settings.allow_negative_inventory)
                    .setNumber("is_server", to_settings.is_server)
                    .setString("location", to_settings.location)
                    .setNumber("receipt_printing_enabled2", to_settings.receipt_printing_enabled2)
                    .setString("drawer", to_settings.drawer)
                    .setString("developer", to_settings.developer)
                    .setString("developer_address", to_settings.developer_address)
                    .setString("developer_tin_no", to_settings.developer_tin_no)
                    .setString("developer_accreditation_no", to_settings.developer_accreditation_no)
                    .setString("developer_accreditation_date", to_settings.developer_accreditation_date)
                    .setString("developer_contact_no", to_settings.developer_contact_no)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Settings.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void update_data(to_settings to_settings) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update settings set "
                    + "company_name= :company_name "
                    + ",company_address= :company_address "
                    + ",company_operated_by= :company_operated_by "
                    + ",company_slogan= :company_slogan "
                    + ",company_contact_no= :company_contact_no "
                    + ",company_fax_no= :company_fax_no "
                    + ",company_email_address= :company_email_address "
                    + ",bir_serial_no= :bir_serial_no "
                    + ",bir_permit_no= :bir_permit_no "
                    + ",bir_accreditation_no= :bir_accreditation_no "
                    + ",bir_tin= :bir_tin "
                    + ",bir_machine_no= :bir_machine_no "
                    + ",bir_min_no= :bir_min_no "
                    + ",bir_business_type= :bir_business_type "
                    + ",bir_vat_percent= :bir_vat_percent "
                    + ",bir_receipt_footer= :bir_receipt_footer "
                    + ",bir_invoice_footer= :bir_invoice_footer "
                    + ",receipt_printing_enabled= :receipt_printing_enabled "
                    + ",receipt_printer_show_dialog= :receipt_printer_show_dialog "
                    + ",kitchen_printing_enable= :kitchen_printing_enable "
                    + ",allow_negative_inventory= :allow_negative_inventory "
                    + ",is_server= :is_server "
                    + ",location= :location "
                    + ",receipt_printing_enabled2= :receipt_printing_enabled2 "
                    + ",drawer= :drawer "
                    + ",developer= :developer "
                    + ",developer_address= :developer_address "
                    + ",developer_tin_no= :developer_tin_no "
                    + ",developer_accreditation_no= :developer_accreditation_no "
                    + ",developer_accreditation_date= :developer_accreditation_date "
                    + ",developer_contact_no= :developer_contact_no"
                    + " where id='" + to_settings.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("company_name", to_settings.company_name)
                    .setString("company_address", to_settings.company_address)
                    .setString("company_operated_by", to_settings.company_operated_by)
                    .setString("company_slogan", to_settings.company_slogan)
                    .setString("company_contact_no", to_settings.company_contact_no)
                    .setString("company_fax_no", to_settings.company_fax_no)
                    .setString("company_email_address", to_settings.company_email_address)
                    .setString("bir_serial_no", to_settings.bir_serial_no)
                    .setString("bir_permit_no", to_settings.bir_permit_no)
                    .setString("bir_accreditation_no", to_settings.bir_accreditation_no)
                    .setString("bir_tin", to_settings.bir_tin)
                    .setString("bir_machine_no", to_settings.bir_machine_no)
                    .setString("bir_min_no", to_settings.bir_min_no)
                    .setString("bir_business_type", to_settings.bir_business_type)
                    .setString("bir_vat_percent", to_settings.bir_vat_percent)
                    .setString("bir_receipt_footer", to_settings.bir_receipt_footer)
                    .setString("bir_invoice_footer", to_settings.bir_invoice_footer)
                    .setNumber("receipt_printing_enabled", to_settings.receipt_printing_enabled)
                    .setNumber("receipt_printer_show_dialog", to_settings.receipt_printer_show_dialog)
                    .setNumber("kitchen_printing_enable", to_settings.kitchen_printing_enable)
                    .setNumber("allow_negative_inventory", to_settings.allow_negative_inventory)
                    .setNumber("is_server", to_settings.is_server)
                    .setString("location", to_settings.location)
                    .setNumber("receipt_printing_enabled2", to_settings.receipt_printing_enabled2)
                    .setString("drawer", to_settings.drawer)
                    .setString("developer", to_settings.developer)
                    .setString("developer_address", to_settings.developer_address)
                    .setString("developer_tin_no", to_settings.developer_tin_no)
                    .setString("developer_accreditation_no", to_settings.developer_accreditation_no)
                    .setString("developer_accreditation_date", to_settings.developer_accreditation_date)
                    .setString("developer_contact_no", to_settings.developer_contact_no)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Settings.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void update_data_modules(int id, String module_software_type, int module_accounts_payable, int module_accounts_receivable, int module_services, int module_prepayments, int module_requisition_slip, int module_charge_in_advance) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update settings set "
                    + " module_software_type= :module_software_type "
                    + ",module_accounts_payable= :module_accounts_payable "
                    + ",module_accounts_receivable= :module_accounts_receivable "
                    + ",module_services= :module_services "
                    + ",module_prepayments= :module_prepayments "
                    + ",module_requisition_slip= :module_requisition_slip "
                    + ",module_charge_in_advance= :module_charge_in_advance "
                    + " where id='" + id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("module_software_type", module_software_type)
                    .setNumber("module_accounts_payable", module_accounts_payable)
                    .setNumber("module_accounts_receivable", module_accounts_receivable)
                    .setNumber("module_services", module_services)
                    .setNumber("module_prepayments", module_prepayments)
                    .setNumber("module_requisition_slip", module_requisition_slip)
                    .setNumber("module_charge_in_advance", module_charge_in_advance)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Settings.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_data(to_settings to_settings) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from settings  "
                    + " where id='" + to_settings.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg
                    .s(Settings.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_settings> ret_data(String where) {
        List<to_settings> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",company_name"
                    + ",company_address"
                    + ",company_operated_by"
                    + ",company_slogan"
                    + ",company_contact_no"
                    + ",company_fax_no"
                    + ",company_email_address"
                    + ",bir_serial_no"
                    + ",bir_permit_no"
                    + ",bir_accreditation_no"
                    + ",bir_tin"
                    + ",bir_machine_no"
                    + ",bir_min_no"
                    + ",bir_business_type"
                    + ",bir_vat_percent"
                    + ",bir_receipt_footer"
                    + ",bir_invoice_footer"
                    + ",receipt_printing_enabled"
                    + ",receipt_printer_show_dialog"
                    + ",kitchen_printing_enable"
                    + ",allow_negative_inventory"
                    + ",is_server"
                    + ",location"
                    + ",receipt_printing_enabled2"
                    + ",drawer"
                    + ",developer"
                    + ",developer_address"
                    + ",developer_tin_no"
                    + ",developer_accreditation_no"
                    + ",developer_accreditation_date"
                    + ",developer_contact_no"
                    + ",module_software_type"
                    + ",module_accounts_payable"
                    + ",module_accounts_receivable"
                    + ",module_services"
                    + ",module_prepayments"
                    + ",module_requisition_slip"
                    + ",module_charge_in_advance"
                    + " from settings"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String company_name = rs.getString(2);
                String company_address = rs.getString(3);
                String company_operated_by = rs.getString(4);
                String company_slogan = rs.getString(5);
                String company_contact_no = rs.getString(6);
                String company_fax_no = rs.getString(7);
                String company_email_address = rs.getString(8);
                String bir_serial_no = rs.getString(9);
                String bir_permit_no = rs.getString(10);
                String bir_accreditation_no = rs.getString(11);
                String bir_tin = rs.getString(12);
                String bir_machine_no = rs.getString(13);
                String bir_min_no = rs.getString(14);
                String bir_business_type = rs.getString(15);
                String bir_vat_percent = rs.getString(16);
                String bir_receipt_footer = rs.getString(17);
                String bir_invoice_footer = rs.getString(18);
                int receipt_printing_enabled = rs.getInt(19);
                int receipt_printer_show_dialog = rs.getInt(20);
                int kitchen_printing_enable = rs.getInt(21);
                int allow_negative_inventory = rs.getInt(22);
                int is_server = rs.getInt(23);
                String location = rs.getString(24);
                int receipt_printing_enabled2 = rs.getInt(25);
                String drawer = rs.getString(26);
                String developer = rs.getString(27);
                String developer_address = rs.getString(28);
                String developer_tin_no = rs.getString(29);
                String developer_accreditation_no = rs.getString(30);
                String developer_accreditation_date = rs.getString(31);
                String developer_contact_no = rs.getString(32);
                String module_software_type = rs.getString(33);
                int module_accounts_payable = rs.getInt(34);
                int module_accounts_receivable = rs.getInt(35);
                int module_services = rs.getInt(36);
                int module_prepayments = rs.getInt(37);
                int module_requisition_slip = rs.getInt(38);
                int module_charge_in_advance = rs.getInt(39);

                to_settings to = new to_settings(id, company_name, company_address, company_operated_by, company_slogan, company_contact_no, company_fax_no, company_email_address, bir_serial_no, bir_permit_no, bir_accreditation_no, bir_tin, bir_machine_no, bir_min_no, bir_business_type, bir_vat_percent, bir_receipt_footer, bir_invoice_footer, receipt_printing_enabled, receipt_printer_show_dialog, kitchen_printing_enable, allow_negative_inventory, is_server, location, receipt_printing_enabled2, drawer, developer, developer_address, developer_tin_no, developer_accreditation_no, developer_accreditation_date, developer_contact_no, module_software_type, module_accounts_payable, module_accounts_receivable, module_services, module_prepayments, module_requisition_slip, module_charge_in_advance);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

}
