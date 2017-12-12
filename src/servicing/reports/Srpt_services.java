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
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import mijzcx.synapse.desk.utils.Application;
import mijzcx.synapse.desk.utils.FitIn;
import mijzcx.synapse.desk.utils.JasperUtil;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.swing.JRViewer;
import servicing.my_services.My_services_description_customers;
import servicing.my_services.My_services_item_replacements_customers;
import servicing.my_services.My_services_others_customers;
import servicing.my_services.My_services_problems_customers;
import servicing.my_services.S1_my_services_description;
import servicing.my_services.S1_my_services_others;
import servicing.utils.DateType;
import servicing.utils.DateUtils1;
import servicing.utils.MyConnection;

/**
 *
 * @author Ronald
 */
public class Srpt_services {

    public final List<Srpt_services.field> fields;
    public final String business_name;
    public final String date;
    public final String printed_by;
    public final String statuses;

    public Srpt_services(String business_name, String date, String printed_by, String statuses) {
        this.fields = new ArrayList();
        this.business_name = business_name;
        this.date = date;
        this.printed_by = printed_by;
        this.statuses = statuses;
    }

    public static class field {

        String transaction;
        String service_slip_no;
        String date;
        String days;
        String customer_name;
        String serviced_by;
        String description;
        String problem;
        double amount;
        String others;
        String remarks;
        public field() {
        }

        public field(String transaction, String service_slip_no, String date, String days, String customer_name, String serviced_by, String description, String problem, double amount, String others,String remarks) {
            this.transaction = transaction;
            this.service_slip_no = service_slip_no;
            this.date = date;
            this.days = days;
            this.customer_name = customer_name;
            this.serviced_by = serviced_by;
            this.description = description;
            this.problem = problem;
            this.amount = amount;
            this.others = others;
            this.remarks=remarks;
        }

        public String getRemarks() {
            return remarks;
        }

        public void setRemarks(String remarks) {
            this.remarks = remarks;
        }
        
        public String getOthers() {
            return others;
        }

        public void setOthers(String others) {
            this.others = others;
        }

        public String getTransaction() {
            return transaction;
        }

        public void setTransaction(String transaction) {
            this.transaction = transaction;
        }

        public String getService_slip_no() {
            return service_slip_no;
        }

        public void setService_slip_no(String service_slip_no) {
            this.service_slip_no = service_slip_no;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getDays() {
            return days;
        }

        public void setDays(String days) {
            this.days = days;
        }

        public String getCustomer_name() {
            return customer_name;
        }

        public void setCustomer_name(String customer_name) {
            this.customer_name = customer_name;
        }

        public String getServiced_by() {
            return serviced_by;
        }

        public void setServiced_by(String serviced_by) {
            this.serviced_by = serviced_by;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
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

    }

    public static void main(String[] args) {

        List<Srpt_services.field> datas = Srpt_services.ret_data("", 0);
        String business_name = System.getProperty("business_name", "Algorithm Computer Services");
        String date = DateType.month_date.format(new Date());
        String printed_by = "Administrator";
        Srpt_services rpt = new Srpt_services(business_name, date, printed_by, "");
        rpt.fields.addAll(datas);
        String jrxml = "rpt_services.jrxml";
        JRViewer viewer = get_viewer(rpt, jrxml);
        JFrame f = Application.launchMainFrame3(viewer, "Sample", true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static JasperReport compileJasper(String jrxml) {
        try {

            InputStream is = Srpt_services.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);

            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer(Srpt_services to, String jrxml) {

        return JasperUtil.getJasperViewer(
                compileJasper(jrxml),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));
    }

    public static List<Srpt_services.field> ret_data(String where, int statuses) {
        List<Srpt_services.field> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",transaction_no"
                    + ",service_slip_no"
                    + ",serviced_by"
                    + ",service_by_id"
                    + ",department_manager"
                    + ",department_manager_id"
                    + ",department"
                    + ",department_id"
                    + ",customer_name"
                    + ",customer_id"
                    + ",qty"
                    + ",unit"
                    + ",description"
                    + ",problem"
                    + ",date_received"
                    + ",date_assigned"
                    + ",date_released"
                    + ",added_by"
                    + ",remarks"
                    + ",status"
                    + ",service_type"
                    + ",service_type_id"
                    + ",amount"
                    + ",cashier"
                    + ",cashier_id"
                    + " from my_services  "
                    + " " + where;
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String transaction_no = rs.getString(2);
                String service_slip_no = rs.getString(3);
                String serviced_by = rs.getString(4);
                String service_by_id = rs.getString(5);
                String department_manager = rs.getString(6);
                String department_manager_id = rs.getString(7);
                String department = rs.getString(8);
                String department_id = rs.getString(9);
                String customer_name = rs.getString(10);
                String customer_id = rs.getString(11);
                double qty = rs.getDouble(12);
                String unit = rs.getString(13);
                String description = rs.getString(14);
                String problem = rs.getString(15);
                String date_received = rs.getString(16);
                String date_assigned = rs.getString(17);
                String date_released = rs.getString(18);
                String added_by = rs.getString(19);
                String remarks = rs.getString(20);
                int status = rs.getInt(21);
                String service_type = rs.getString(22);
                String service_type_id = rs.getString(23);
                double amount = 0;//rs.getDouble(24);
                String cashier = rs.getString(25);
                String cashier_id = rs.getString(26);
                String others = "";
                Date d;
                int days = 0;
                try {
                    d = DateType.sf.parse(date_assigned);
                    days = DateUtils1.count_days(d, new Date());

                } catch (ParseException ex) {
                    Logger.getLogger(Srpt_services.class.getName()).log(Level.SEVERE, null, ex);
                }
                String where2 = "where transaction_no='" + transaction_no + "' order by description asc";
                List<S1_my_services_description.to_my_services_description> desc_list = My_services_description_customers.ret_data(where2);

                for (S1_my_services_description.to_my_services_description desc : desc_list) {
                    description = description + FitIn.fmt_woc(desc.amount) + " - " + desc.description + " ,";
                }

                String where3 = " where transaction_no='" + transaction_no + "' order by problem asc";
                List<My_services_problems_customers.to_my_services_problems_customers> prob_list = My_services_problems_customers.ret_data(where3);
                for (My_services_problems_customers.to_my_services_problems_customers prob : prob_list) {
                    problem = problem + " " + prob.problem + " @ " + FitIn.fmt_wc_0(prob.amount) + " ,";
                    amount += prob.amount;
                }
                
                String where4 = " where transaction_no='" + transaction_no + "' order by description asc";
                List<My_services_item_replacements_customers.to_my_services_item_replacements_customers> replacement_list = My_services_item_replacements_customers.ret_data(where4);
                for (My_services_item_replacements_customers.to_my_services_item_replacements_customers rep : replacement_list) {
                    others = others + " " + rep.description + " " + FitIn.fmt_wc_0(rep.qty * rep.selling_price) + " ,";
                    amount += rep.qty * rep.selling_price;
                }
                
                String where5 = " where transaction_no='" + transaction_no + "' ";
                List<S1_my_services_others.to_my_services_others> others_list = My_services_others_customers.ret_data(where5);
                for (S1_my_services_others.to_my_services_others other : others_list) {
                    others = others + " " + other.name + " " + FitIn.fmt_wc_0(other.qty * other.amount) + " ,";
                    amount += other.qty * other.amount;
                }

                String my_day = "";
                String my_date = DateType.convert_slash_datetime2(date_released);
                if (statuses == 1) {
                    my_day = "" + days;
                    my_date = DateType.convert_slash_datetime2(date_released);
                }
                if (statuses == 2) {
                    my_date = DateType.convert_slash_datetime2(date_released);
                }
                if (statuses == 3) {
                    my_date = DateType.convert_slash_datetime2(date_released);
                }
                if (statuses == 4) {
                    my_date = DateType.convert_slash_datetime2(date_released);
                }
                
                Srpt_services.field to = new field(transaction_no, service_slip_no, my_date, my_day, customer_name
                        , serviced_by, description, problem, amount, others,remarks);
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
