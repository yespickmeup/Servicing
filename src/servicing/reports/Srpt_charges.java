/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicing.reports;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import mijzcx.synapse.desk.utils.Application;
import mijzcx.synapse.desk.utils.JasperUtil;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.swing.JRViewer;
import servicing.utils.DateType;
import servicing.utils.MyConnection;

/**
 *
 * @author Ronescape
 */
public class Srpt_charges {

    public final String business_name;
    public final String address;
    public final String contact_no;
    public final String date;
    public final String department;
    public final String service_by;
    public final String trans_type;
    public final List<field> fields;

    public Srpt_charges(String business_name, String address, String contact_no, String date, String department, String service_by,String trans_type) {
        this.business_name = business_name;
        this.address = address;
        this.contact_no = contact_no;
        this.date = date;
        this.department = department;
        this.service_by = service_by;
        this.fields = new ArrayList();
        this.trans_type=trans_type;
    }

    public static class field {

        String transaction_no;
        String slip_no;
        String service_by_id;
        String service_by;
        String department;
        String date_received;
        String date_assigned;
        String date_released;
        String remarks;
        String service_type;
        String added_by;
        String status;
        String customer_id;
        String customer_name;
        String date_added;
        String problem;
        double amount;
        String branch;
        String branch_id;
        String location;
        String location_id;
        double replacements;
        double others;
        public field() {
        }

        public field(String transaction_no, String slip_no, String service_by_id, String service_by, String department, String date_received, String date_assigned, String date_released, String remarks, String service_type, String added_by, String status, String customer_id, String customer_name, String date_added, String problem, double amount, String branch, String branch_id, String location, String location_id,double replacements,double others) {
            this.transaction_no = transaction_no;
            this.slip_no = slip_no;
            this.service_by_id = service_by_id;
            this.service_by = service_by;
            this.department = department;
            this.date_received = date_received;
            this.date_assigned = date_assigned;
            this.date_released = date_released;
            this.remarks = remarks;
            this.service_type = service_type;
            this.added_by = added_by;
            this.status = status;
            this.customer_id = customer_id;
            this.customer_name = customer_name;
            this.date_added = date_added;
            this.problem = problem;
            this.amount = amount;
            this.branch = branch;
            this.branch_id = branch_id;
            this.location = location;
            this.location_id = location_id;
            this.replacements=replacements;
            this.others=others;
        }

        public double getReplacements() {
            return replacements;
        }

        public void setReplacements(double replacements) {
            this.replacements = replacements;
        }

        public double getOthers() {
            return others;
        }

        public void setOthers(double others) {
            this.others = others;
        }

        public String getTransaction_no() {
            return transaction_no;
        }

        public void setTransaction_no(String transaction_no) {
            this.transaction_no = transaction_no;
        }

        public String getSlip_no() {
            return slip_no;
        }

        public void setSlip_no(String slip_no) {
            this.slip_no = slip_no;
        }

        public String getService_by_id() {
            return service_by_id;
        }

        public void setService_by_id(String service_by_id) {
            this.service_by_id = service_by_id;
        }

        public String getService_by() {
            return service_by;
        }

        public void setService_by(String service_by) {
            this.service_by = service_by;
        }

        public String getDepartment() {
            return department;
        }

        public void setDepartment(String department) {
            this.department = department;
        }

        public String getDate_received() {
            return date_received;
        }

        public void setDate_received(String date_received) {
            this.date_received = date_received;
        }

        public String getDate_assigned() {
            return date_assigned;
        }

        public void setDate_assigned(String date_assigned) {
            this.date_assigned = date_assigned;
        }

        public String getDate_released() {
            return date_released;
        }

        public void setDate_released(String date_released) {
            this.date_released = date_released;
        }

        public String getRemarks() {
            return remarks;
        }

        public void setRemarks(String remarks) {
            this.remarks = remarks;
        }

        public String getService_type() {
            return service_type;
        }

        public void setService_type(String service_type) {
            this.service_type = service_type;
        }

        public String getAdded_by() {
            return added_by;
        }

        public void setAdded_by(String added_by) {
            this.added_by = added_by;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getCustomer_id() {
            return customer_id;
        }

        public void setCustomer_id(String customer_id) {
            this.customer_id = customer_id;
        }

        public String getCustomer_name() {
            return customer_name;
        }

        public void setCustomer_name(String customer_name) {
            this.customer_name = customer_name;
        }

        public String getDate_added() {
            return date_added;
        }

        public void setDate_added(String date_added) {
            this.date_added = date_added;
        }

        public String getProblem() {
            return problem;
        }

        public void setProblem(String problem) {
            this.problem = problem;
        }

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }

        public String getBranch() {
            return branch;
        }

        public void setBranch(String branch) {
            this.branch = branch;
        }

        public String getBranch_id() {
            return branch_id;
        }

        public void setBranch_id(String branch_id) {
            this.branch_id = branch_id;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public String getLocation_id() {
            return location_id;
        }

        public void setLocation_id(String location_id) {
            this.location_id = location_id;
        }

    }

    public static void main(String[] args) {

        System.setProperty("pool_db", "db_algorithm");
        String where = " order by id desc limit 30";
        List<field> datas = Srpt_charges.ret_data(where);
        String business_name = System.getProperty("business_name", "Algorithm Computer Services");
        String address = System.getProperty("address", "Daro, Dumaguete City");
        String contact_no = System.getProperty("contact_no", "00000-000000");
        String date = "September 8, 2019";
        String department = "All";
        String service_by = "all";
        String trans_type="All";
        Srpt_charges rpt = new Srpt_charges(business_name, address, contact_no, date, department, service_by,trans_type);
        rpt.fields.addAll(datas);
        String jrxml = "rpt_charges.jrxml";
        JRViewer viewer = get_viewer(rpt, jrxml);
        JFrame f = Application.launchMainFrame3(viewer, "Sample", true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static JasperReport compileJasper(String jrxml) {
        try {

            InputStream is = Srpt_charges.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);

            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer(Srpt_charges to, String jrxml) {

        return JasperUtil.getJasperViewer(
                compileJasper(jrxml),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));
    }

    public static List<field> ret_data(String where) {
        List<field> datas = new ArrayList();
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + " mc.id"
                    + ",mc.problem"
                    + ",mc.transaction_no"
                    + ",mc.date_received"
                    + ",mc.amount"
                    + ",mc.service_slip_no"
                    + ",mc.serviced_by"
                    + ",mc.service_by_id"
                    + ",mc.department_manager"
                    + ",mc.department_manager_id"
                    + ",mc.department"
                    + ",mc.department_id"
                    + ",mc.customer_name"
                    + ",mc.date_received"
                    + ",mc.date_assigned"
                    + ",mc.date_released"
                    + ",mc.added_by"
                    + ",mc.remarks"
                    + ",mc.status"
                    + ",mc.service_type"
                    + ",mc.service_type_id"
                    + ",mc.branch"
                    + ",mc.branch_id"
                    + ",mc.location"
                    + ",mc.location_id"
                    + " from my_services mc  "
                    //                    + " join my_services mc "
                    //                    + " on  mspc.transaction_no= mc.transaction_no "
                    + " " + where + " ";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String transaction_no = rs.getString(3);
                String problem = rs.getString(2);
                String date_added = rs.getString(4);
                double amount = rs.getDouble(5);
                String service_slip_no = rs.getString(6);
                String service_by = rs.getString(7);
                String service_by_id = rs.getString(8);
                String department_manager = rs.getString(9);
                String department_manager_id = rs.getString(10);
                String department = rs.getString(11);
                String department_id = rs.getString(12);
                String customer_name = rs.getString(13);
                String date_received = rs.getString(14);
                String date_assigned = rs.getString(15);
                String date_released = rs.getString(16);
                String added_by = rs.getString(17);
                String remarks = rs.getString(18);
                String status = rs.getString(19);
                String service_type = rs.getString(20);
                String service_type_id = rs.getString(21);
                String branch = rs.getString(22);
                String branch_id = rs.getString(23);
                String location = rs.getString(24);
                String location_id = rs.getString(25);

                String slip_no = service_slip_no;
                String customer_id = customer_name;

                date_received = DateType.convert_slash_datetime2(date_received);
                date_assigned = DateType.convert_slash_datetime2(date_assigned);
                date_released = DateType.convert_slash_datetime2(date_released);
                double replacements=0;
                double others=0;
                if (status.equals("0")) {
                    status = "On Going";
                }
                if (status.equals("1")) {
                    status = "Finished";
                }
                if (status.equals("2")) {
                    status = "Released";
                }
                if (status.equals("3")) {
                    status = "On Hold";
                }

                String s2 = "select "
                        + " amount"
                        + ",problem"
                        + " from my_services_problems_customers  "
                        + " where transaction_no='" + transaction_no + "' ";
                Statement stmt2 = conn.createStatement();
                ResultSet rs2 = stmt2.executeQuery(s2);
                while (rs2.next()) {
                    amount += rs2.getDouble(1);
                    problem = problem + " " + rs2.getString(2);
                }

                String s3 = "select "
                        + " qty"
                        + ",selling_price"
                        + " from my_services_item_replacements_customers  "
                        + " where transaction_no='" + transaction_no + "' ";
                Statement stmt3 = conn.createStatement();
                ResultSet rs3 = stmt3.executeQuery(s3);
                while (rs3.next()) {
                    double qty = rs3.getDouble(1);
                    double price = rs3.getDouble(2);
                    replacements += (qty * price);
                }

                String s4 = "select "
                        + " amount"
                        + " from my_services_others_customers  "
                        + " where transaction_no='" + transaction_no + "' ";
                Statement stmt4 = conn.createStatement();
                ResultSet rs4 = stmt4.executeQuery(s4);
                while (rs4.next()) {
                    others += rs4.getDouble(1);
                }

                field f = new field(transaction_no, slip_no, service_by_id, service_by, department, date_received, date_assigned, date_released, remarks, service_type, added_by, status, customer_id, customer_name, date_added, problem, amount, branch, branch_id, location, location_id,replacements,others);
                datas.add(f);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

}
