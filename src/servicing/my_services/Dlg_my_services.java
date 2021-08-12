/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicing.my_services;

import servicing.reports.Dlg_my_services_print_barcodes;
import servicing.my_services.My_services.to_my_services;
import servicing.my_services.S1_my_services_description.to_my_services_description;
import servicing.my_services.S1_my_services_item_replacements.to_my_services_item_replacements;
import servicing.my_services.S1_my_services_others.to_my_services_others;

import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.FitIn;
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;
import mijzcx.synapse.desk.utils.TableWidthUtilities;
import servicing.branch_locations.Branch_locations;
import servicing.inventory.Inventory;
import servicing.users.MyUser;
import servicing.users.Users;
import servicing.utils.Alert;
import servicing.utils.DateType;
import servicing.utils.DateUtils1;
import servicing.utils.TableRenderer;
import synsoftech.fields.Button;
import synsoftech.util.Focus_Fire;

/**
 *
 * @author Ronald
 */
public class Dlg_my_services extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_my_services
     */
    //<editor-fold defaultstate="collapsed" desc=" callback ">
    private Callback callback;

    public void setCallback(Callback callback) {
        this.callback = callback;

    }

    public static interface Callback {

        void ok(CloseDialog closeDialog, OutputData data);
    }

    public static class InputData {
    }

    public static class OutputData {
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Constructors ">
    private Dlg_my_services(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_my_services(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_my_services() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_my_services myRef;

    private void setThisRef(Dlg_my_services myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_my_services> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_my_services create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_my_services create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_my_services dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_my_services((java.awt.Frame) parent, false);
                dialog.setModalityType(modalType);
                dialogContainer.put(parent, dialog);
                java.util.logging.Logger.getAnonymousLogger().log(Level.INFO, "instances: {0}", dialogContainer.size());
                dialog.setThisRef(dialog);
                return dialog;
            } else {
                dialog.setModalityType(modalType);
                return dialog;
            }

        }

        if (parent instanceof java.awt.Dialog) {
            Dlg_my_services dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_my_services((java.awt.Dialog) parent, false);
                dialog.setModalityType(modalType);
                dialogContainer.put(parent, dialog);
                java.util.logging.Logger.getAnonymousLogger().log(Level.INFO, "instances: {0}", dialogContainer.size());
                dialog.setThisRef(dialog);
                return dialog;
            } else {
                dialog.setModalityType(modalType);
                return dialog;
            }

        }

        return null;

    }
    //</editor-fold>    

    //<editor-fold defaultstate="collapsed" desc=" main ">
    public static void main(String args[]) {

        try {
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        Dlg_my_services dialog = Dlg_my_services.create(new javax.swing.JFrame(), true);
        Toolkit tk = Toolkit.getDefaultToolkit();
        int xSize = ((int) tk.getScreenSize().
                getWidth());
        int ySize = ((int) tk.getScreenSize().
                getHeight());
        dialog.setSize(xSize, ySize);
        dialog.setVisible(true);

    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" added ">
    @Override
    public void setVisible(boolean visible) {
        super.setVisible(visible);
        if (visible == true) {
            getContentPane().removeAll();
            initComponents();
            myInit();
            repaint();
        }

    }

    public javax.swing.JPanel getSurface() {
        return (javax.swing.JPanel) getContentPane();
    }

    public void nullify() {
        myRef.setVisible(false);
        myRef = null;
    }
    //</editor-fold>

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        pp_barcode = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tf_transaction_no = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tf_service_slip_no = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tf_serviced_by = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tf_customer_name = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        tf_service_by_id = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tf_problem = new javax.swing.JTextArea();
        tf_service_type_id = new javax.swing.JTextField();
        tf_service_type = new javax.swing.JTextField();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel13 = new javax.swing.JLabel();
        dp_assigned = new com.toedter.calendar.JDateChooser();
        jCheckBox10 = new javax.swing.JCheckBox();
        jLabel12 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        dp_received = new com.toedter.calendar.JDateChooser();
        tf_qty = new javax.swing.JTextField();
        tf_unit = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tf_description = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        tf_amount = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tf_customer_id = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tf_remarks = new javax.swing.JTextArea();
        jCheckBox16 = new javax.swing.JCheckBox();
        jLabel42 = new javax.swing.JLabel();
        dp_released = new com.toedter.calendar.JDateChooser();
        jPanel8 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        jPanel9 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbl_my_services_description = new javax.swing.JTable();
        jLabel26 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        btn_edit1 = new Button.Info();
        jPanel5 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tbl_my_services_problems = new javax.swing.JTable();
        btn_edit2 = new Button.Info();
        jPanel6 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        tf_service_item_code = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        tf_service_description = new javax.swing.JTextField();
        jScrollPane7 = new javax.swing.JScrollPane();
        tbl_my_services_item_replacements = new javax.swing.JTable();
        tf_service_barcode = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        tf_service_price = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        tf_service_qty = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        tf_service_description1 = new javax.swing.JTextField();
        jScrollPane9 = new javax.swing.JScrollPane();
        tbl_my_services_others = new javax.swing.JTable();
        tf_service_price1 = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        tf_service_qty1 = new javax.swing.JTextField();
        btn_edit3 = new Button.Info();
        jTextField6 = new javax.swing.JTextField();
        jLabel47 = new javax.swing.JLabel();
        tf_contact_no = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbl_my_services = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jCheckBox5 = new javax.swing.JCheckBox();
        jCheckBox6 = new javax.swing.JCheckBox();
        jLabel16 = new javax.swing.JLabel();
        jCheckBox7 = new javax.swing.JCheckBox();
        jCheckBox8 = new javax.swing.JCheckBox();
        jLabel17 = new javax.swing.JLabel();
        jTextField12 = new javax.swing.JTextField();
        jCheckBox9 = new javax.swing.JCheckBox();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jCheckBox11 = new javax.swing.JCheckBox();
        tf_department1 = new javax.swing.JTextField();
        tf_department_id1 = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        tf_service_type1 = new javax.swing.JTextField();
        tf_service_type_id1 = new javax.swing.JTextField();
        jCheckBox12 = new javax.swing.JCheckBox();
        jCheckBox13 = new javax.swing.JCheckBox();
        jCheckBox14 = new javax.swing.JCheckBox();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jCheckBox15 = new javax.swing.JCheckBox();
        dp_from = new com.toedter.calendar.JDateChooser();
        dp_to = new com.toedter.calendar.JDateChooser();
        jCheckBox17 = new javax.swing.JCheckBox();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jButton9 = new Button.Default();
        jLabel44 = new javax.swing.JLabel();
        jCheckBox18 = new javax.swing.JCheckBox();
        tf_department2 = new javax.swing.JTextField();
        tf_department_id2 = new javax.swing.JTextField();
        jCheckBox19 = new javax.swing.JCheckBox();
        jLabel49 = new javax.swing.JLabel();
        tf_from_branch = new javax.swing.JTextField();
        tf_from_branch_id = new javax.swing.JTextField();
        tf_from_location_id = new javax.swing.JTextField();
        tf_from_location = new javax.swing.JTextField();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();

        jMenuItem1.setText("Transfer Job To");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);

        jMenuItem2.setText("Print Barcode");
        jMenuItem2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItem2MouseClicked(evt);
            }
        });
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem2);

        pp_barcode.setText("Print Barcode");
        pp_barcode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pp_barcodeActionPerformed(evt);
            }
        });
        jPopupMenu2.add(pp_barcode);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Transaction No:");

        tf_transaction_no.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_transaction_no.setFocusable(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Service Slip No:");

        tf_service_slip_no.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_service_slip_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_service_slip_noActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Service by:");

        tf_serviced_by.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_serviced_by.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_serviced_byActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Customer:");

        tf_customer_name.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_customer_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_customer_nameActionPerformed(evt);
            }
        });

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        tf_service_by_id.setFocusable(false);
        tf_service_by_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_service_by_idActionPerformed(evt);
            }
        });

        jScrollPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        tf_problem.setColumns(20);
        tf_problem.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        tf_problem.setRows(5);
        jScrollPane2.setViewportView(tf_problem);

        tf_service_type_id.setFocusable(false);

        tf_service_type.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_service_typeActionPerformed(evt);
            }
        });

        buttonGroup1.add(jCheckBox2);
        jCheckBox2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jCheckBox2.setText("Finished");
        jCheckBox2.setOpaque(false);

        buttonGroup1.add(jCheckBox1);
        jCheckBox1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jCheckBox1.setSelected(true);
        jCheckBox1.setText("On Going");
        jCheckBox1.setOpaque(false);

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel13.setText(" Trans Type:");

        dp_assigned.setDate(new Date());
        dp_assigned.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        buttonGroup1.add(jCheckBox10);
        jCheckBox10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jCheckBox10.setText("Released");
        jCheckBox10.setOpaque(false);

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel12.setText(" Status:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText(" Date Assigned:");

        dp_received.setDate(new Date());
        dp_received.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Unit:");

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Description:");

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        tf_description.setColumns(20);
        tf_description.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        tf_description.setRows(5);
        jScrollPane1.setViewportView(tf_description);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText(" Date Received:");

        tf_amount.setFocusable(false);

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel14.setText("Total Due:");

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Problem:");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Qty:");

        tf_customer_id.setFocusable(false);
        tf_customer_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_customer_idActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel11.setText(" Remarks:");

        jScrollPane3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        tf_remarks.setColumns(20);
        tf_remarks.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_remarks.setLineWrap(true);
        tf_remarks.setRows(5);
        jScrollPane3.setViewportView(tf_remarks);

        buttonGroup1.add(jCheckBox16);
        jCheckBox16.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jCheckBox16.setText("On Hold");
        jCheckBox16.setOpaque(false);

        jLabel42.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel42.setText("Released:");

        dp_released.setDate(new Date());
        dp_released.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addComponent(tf_service_by_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(tf_customer_id, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tf_service_type_id, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tf_unit, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tf_qty, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCheckBox1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox16))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jScrollPane3))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel10))
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(dp_received, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                                    .addComponent(dp_assigned, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tf_amount)
                                    .addComponent(dp_released, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(tf_service_type))))
                .addGap(1, 1, 1))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11)
                        .addComponent(tf_unit, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tf_qty, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tf_service_type_id, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tf_customer_id, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tf_service_by_id, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tf_amount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dp_released, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel7Layout.createSequentialGroup()
                            .addComponent(dp_received, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(1, 1, 1)
                            .addComponent(dp_assigned, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel7Layout.createSequentialGroup()
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(1, 1, 1)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(1, 1, 1)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_service_type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox1)
                    .addComponent(jCheckBox2)
                    .addComponent(jCheckBox10)
                    .addComponent(jCheckBox16)))
        );

        jButton1.setText("New");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Departments");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton6.setText("Members");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton5.setText("Add");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton4.setText("Update");
        jButton4.setEnabled(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton8.setText("Trans Type");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton7.setText("Customers");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton3.setText("Delete");
        jButton3.setEnabled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(1, 1, 1)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton6)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(1, 1, 1)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                        .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel8Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
        );

        jScrollPane8.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel27.setText("Qty:");

        jTextField3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel28.setText("Unit:");

        jScrollPane5.setBackground(new java.awt.Color(255, 255, 255));

        tbl_my_services_description.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_my_services_description.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_my_services_descriptionMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tbl_my_services_description);

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel26.setText("Description:");

        jLabel48.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel48.setText("Barcode:");

        jTextField7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });

        btn_edit1.setText("Edit");
        btn_edit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_edit1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel48, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel28)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField3)
                                .addGap(18, 18, 18)
                                .addComponent(btn_edit1))
                            .addComponent(jTextField7)
                            .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26))
                .addGap(1, 1, 1)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel48))
                .addGap(1, 1, 1)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_edit1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel29.setText("Problem:");

        jTextField4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        jTextField5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel30.setText("Amount:");

        jScrollPane6.setBackground(new java.awt.Color(255, 255, 255));

        tbl_my_services_problems.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_my_services_problems.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_my_services_problemsMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tbl_my_services_problems);

        btn_edit2.setText("Edit");
        btn_edit2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_edit2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jTextField5, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                                .addGap(134, 134, 134)
                                .addComponent(btn_edit2))
                            .addComponent(jTextField4)))
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_edit2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Replacements", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 14))); // NOI18N
        jPanel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel31.setText("Item Code:");

        tf_service_item_code.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_service_item_code.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_service_item_codeActionPerformed(evt);
            }
        });

        jLabel32.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel32.setText("Description:");

        tf_service_description.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_service_description.setFocusable(false);

        tbl_my_services_item_replacements.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_my_services_item_replacements.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_my_services_item_replacementsMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tbl_my_services_item_replacements);

        tf_service_barcode.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_service_barcode.setFocusable(false);

        jLabel33.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel33.setText("Barcode:");

        tf_service_price.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_service_price.setFocusable(false);

        jLabel34.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel34.setText("Price:");

        jLabel35.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel35.setText("Qty:");

        tf_service_qty.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_service_qty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_service_qtyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel31)
                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(tf_service_item_code, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel33))
                    .addComponent(tf_service_description))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(tf_service_barcode)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel35)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_service_qty))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel34)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_service_price)))
                .addGap(7, 7, 7))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(8, 8, 8))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_service_qty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel35, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel31)
                            .addComponent(tf_service_item_code, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_service_barcode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(tf_service_description, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel34)
                    .addComponent(tf_service_price, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE))
        );

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Others", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        jLabel43.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel43.setText("Description:");

        tf_service_description1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_service_description1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_service_description1ActionPerformed(evt);
            }
        });

        tbl_my_services_others.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_my_services_others.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_my_services_othersMouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(tbl_my_services_others);

        tf_service_price1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_service_price1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_service_price1ActionPerformed(evt);
            }
        });

        jLabel45.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel45.setText("Price:");

        jLabel46.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel46.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel46.setText("Qty:");

        tf_service_qty1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_service_qty1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_service_qty1ActionPerformed(evt);
            }
        });

        btn_edit3.setText("Edit");
        btn_edit3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_edit3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel46, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel43, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(tf_service_qty1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel45)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tf_service_price1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_edit3))
                            .addComponent(tf_service_description1)))
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(7, 7, 7))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel43)
                    .addComponent(tf_service_description1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_service_qty1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel45)
                    .addComponent(tf_service_price1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_edit3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jScrollPane8.setViewportView(jPanel9);

        jTextField6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField6.setText("+");
        jTextField6.setFocusable(false);
        jTextField6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField6MouseClicked(evt);
            }
        });

        jLabel47.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel47.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel47.setText("Contact No:");

        tf_contact_no.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_contact_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_contact_noActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(tf_service_slip_no)
                                    .addComponent(tf_transaction_no)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jScrollPane8, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(19, 19, 19)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(tf_customer_name)
                                        .addGap(1, 1, 1)
                                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(tf_serviced_by))))
                        .addGap(10, 10, 10))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addComponent(tf_contact_no)
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_transaction_no, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_service_slip_no))
                .addGap(1, 1, 1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_serviced_by, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_customer_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_contact_no, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        tbl_my_services.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_my_services.setGridColor(new java.awt.Color(255, 255, 255));
        tbl_my_services.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_my_servicesMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbl_my_servicesMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbl_my_servicesMouseReleased(evt);
            }
        });
        jScrollPane4.setViewportView(tbl_my_services);

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel15.setText("Search by:");

        buttonGroup2.add(jCheckBox3);
        jCheckBox3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox3.setText("Name");
        jCheckBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox3ActionPerformed(evt);
            }
        });

        buttonGroup2.add(jCheckBox4);
        jCheckBox4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox4.setText("Description");
        jCheckBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox4ActionPerformed(evt);
            }
        });

        buttonGroup2.add(jCheckBox5);
        jCheckBox5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox5.setText("Problem");
        jCheckBox5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox5ActionPerformed(evt);
            }
        });

        buttonGroup3.add(jCheckBox6);
        jCheckBox6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox6.setText("All");
        jCheckBox6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox6ActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel16.setText("Status:");

        buttonGroup3.add(jCheckBox7);
        jCheckBox7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox7.setSelected(true);
        jCheckBox7.setText("On Going");
        jCheckBox7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox7ActionPerformed(evt);
            }
        });

        buttonGroup3.add(jCheckBox8);
        jCheckBox8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox8.setText("Finished");
        jCheckBox8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox8ActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel17.setText("Search:");

        jTextField12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField12ActionPerformed(evt);
            }
        });

        buttonGroup3.add(jCheckBox9);
        jCheckBox9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox9.setText("Released");
        jCheckBox9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox9ActionPerformed(evt);
            }
        });

        jLabel18.setText("Total On-going:");

        jLabel19.setText("0");

        jLabel20.setText("0");

        jLabel21.setText("Finished:");

        jLabel22.setText("Released:");

        jLabel23.setText("0");

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel24.setText("Department:");

        jCheckBox11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox11.setSelected(true);
        jCheckBox11.setText("All");
        jCheckBox11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox11ActionPerformed(evt);
            }
        });

        tf_department1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_department1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_department1ActionPerformed(evt);
            }
        });

        tf_department_id1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_department_id1.setFocusable(false);

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel25.setText("Trans Type:");

        tf_service_type1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_service_type1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_service_type1ActionPerformed(evt);
            }
        });

        tf_service_type_id1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_service_type_id1.setFocusable(false);
        tf_service_type_id1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_service_type_id1ActionPerformed(evt);
            }
        });

        jCheckBox12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox12.setSelected(true);
        jCheckBox12.setText("All");
        jCheckBox12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox12ActionPerformed(evt);
            }
        });

        buttonGroup2.add(jCheckBox13);
        jCheckBox13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox13.setText("Transaction #");
        jCheckBox13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox13ActionPerformed(evt);
            }
        });

        buttonGroup2.add(jCheckBox14);
        jCheckBox14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox14.setText("Service Slip #");
        jCheckBox14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox14ActionPerformed(evt);
            }
        });

        jLabel36.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel36.setText("Date From:");

        jLabel37.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel37.setText("To:");

        buttonGroup3.add(jCheckBox15);
        jCheckBox15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox15.setText("On Hold");
        jCheckBox15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox15ActionPerformed(evt);
            }
        });

        dp_from.setDate(new Date());
        dp_from.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        dp_to.setDate(new Date());
        dp_to.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jCheckBox17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox17.setText("All");
        jCheckBox17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox17ActionPerformed(evt);
            }
        });

        jLabel38.setForeground(java.awt.Color.red);
        jLabel38.setText("On Hold:");

        jLabel39.setForeground(java.awt.Color.red);
        jLabel39.setText("0");

        jLabel40.setText("Total Transactions:");

        jLabel41.setText("0");

        jButton9.setText("Search");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jLabel44.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel44.setText("Serviced by:");

        jCheckBox18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox18.setSelected(true);
        jCheckBox18.setText("All");
        jCheckBox18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox18ActionPerformed(evt);
            }
        });

        tf_department2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_department2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_department2ActionPerformed(evt);
            }
        });

        tf_department_id2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_department_id2.setFocusable(false);

        buttonGroup2.add(jCheckBox19);
        jCheckBox19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox19.setSelected(true);
        jCheckBox19.setText("Barcode");
        jCheckBox19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox19ActionPerformed(evt);
            }
        });

        jLabel49.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel49.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel49.setText("Branch:");

        tf_from_branch.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_from_branch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_from_branchMouseClicked(evt);
            }
        });
        tf_from_branch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_from_branchActionPerformed(evt);
            }
        });

        tf_from_branch_id.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_from_branch_id.setFocusable(false);

        tf_from_location_id.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        tf_from_location.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_from_location.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_from_locationActionPerformed(evt);
            }
        });

        jLabel50.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel50.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel50.setText("Location:");

        jLabel51.setText("Status:");

        jProgressBar1.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        jProgressBar1.setString("");
        jProgressBar1.setStringPainted(true);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(4, 4, 4)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jCheckBox12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jCheckBox11, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(tf_department1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(tf_department_id1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(15, 15, 15)
                                        .addComponent(jLabel44)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jCheckBox18, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tf_department2))
                                    .addComponent(tf_service_type1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, 0)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tf_service_type_id1, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                                    .addComponent(tf_department_id2, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jTextField12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_from_location)
                            .addComponent(tf_from_branch))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_from_location_id, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_from_branch_id, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addComponent(jCheckBox6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCheckBox7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCheckBox8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCheckBox9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCheckBox15))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel40)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(52, 52, 52)
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel22)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel38)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addComponent(jCheckBox3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCheckBox4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCheckBox5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCheckBox13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCheckBox14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCheckBox19))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(83, 83, 83)
                                        .addComponent(jCheckBox17)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(dp_from, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel37)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dp_to, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 13, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel51)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(tf_from_branch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tf_from_branch_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel50, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_from_location, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(tf_from_location_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dp_to, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dp_from, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox17, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jCheckBox3)
                        .addComponent(jCheckBox4)
                        .addComponent(jCheckBox5)
                        .addComponent(jCheckBox13)
                        .addComponent(jCheckBox14)
                        .addComponent(jCheckBox19))
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCheckBox7)
                    .addComponent(jCheckBox8)
                    .addComponent(jCheckBox9)
                    .addComponent(jCheckBox15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tf_department1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jCheckBox11, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_department_id1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tf_department2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tf_department_id2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jCheckBox18, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_service_type1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox12)
                    .addComponent(tf_service_type_id1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19)
                    .addComponent(jLabel21)
                    .addComponent(jLabel20)
                    .addComponent(jLabel22)
                    .addComponent(jLabel23)
                    .addComponent(jLabel38)
                    .addComponent(jLabel39)
                    .addComponent(jLabel40)
                    .addComponent(jLabel41))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel51)
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(5, 5, 5))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(2, 2, 2))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCheckBox5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox5ActionPerformed
        data_cols();
    }//GEN-LAST:event_jCheckBox5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        clear_my_services();
        jButton5.setEnabled(true);
        jButton4.setEnabled(false);
        jButton3.setEnabled(false);
        tbl_my_services_description_ALM.clear();
        tbl_my_services_description_M.fireTableDataChanged();

        tbl_my_services_item_replacements_ALM.clear();
        tbl_my_services_item_replacements_M.fireTableDataChanged();

        tbl_my_services_problems_ALM.clear();
        tbl_my_services_problems_M.fireTableDataChanged();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        add_my_services();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        edit_my_services();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        delete_my_services();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void tbl_my_servicesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_my_servicesMouseClicked
        select_my_services();
    }//GEN-LAST:event_tbl_my_servicesMouseClicked

    private void tf_serviced_byActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_serviced_byActionPerformed
        init_manager();
    }//GEN-LAST:event_tf_serviced_byActionPerformed

    private void tf_customer_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_customer_nameActionPerformed
        init_customer();
    }//GEN-LAST:event_tf_customer_nameActionPerformed

    private void tf_service_slip_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_service_slip_noActionPerformed
        tf_serviced_by.grabFocus();
    }//GEN-LAST:event_tf_service_slip_noActionPerformed

    private void jTextField12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField12ActionPerformed
        data_cols();
    }//GEN-LAST:event_jTextField12ActionPerformed

    private void jCheckBox6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox6ActionPerformed
        data_cols();
    }//GEN-LAST:event_jCheckBox6ActionPerformed

    private void jCheckBox7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox7ActionPerformed
        data_cols();
    }//GEN-LAST:event_jCheckBox7ActionPerformed

    private void jCheckBox8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox8ActionPerformed
        data_cols();
    }//GEN-LAST:event_jCheckBox8ActionPerformed

    private void jCheckBox9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox9ActionPerformed
        data_cols();
    }//GEN-LAST:event_jCheckBox9ActionPerformed

    private void tf_department1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_department1ActionPerformed
        init_departments();
    }//GEN-LAST:event_tf_department1ActionPerformed

    private void jCheckBox11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox11ActionPerformed
        data_cols();
    }//GEN-LAST:event_jCheckBox11ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        departments();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        members();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:custome
        customers();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        type();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void tf_service_typeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_service_typeActionPerformed
        init_type();
    }//GEN-LAST:event_tf_service_typeActionPerformed

    private void tf_service_type1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_service_type1ActionPerformed
        init_type2();
    }//GEN-LAST:event_tf_service_type1ActionPerformed

    private void jCheckBox12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox12ActionPerformed
        data_cols();
    }//GEN-LAST:event_jCheckBox12ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        init_description();
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        jTextField3.grabFocus();
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void tbl_my_services_descriptionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_my_services_descriptionMouseClicked
        delete_description();
    }//GEN-LAST:event_tbl_my_services_descriptionMouseClicked

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed

        init_uom();
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void tf_customer_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_customer_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_customer_idActionPerformed

    private void tf_service_by_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_service_by_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_service_by_idActionPerformed

    private void tbl_my_services_problemsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_my_services_problemsMouseClicked
        delete_prob();
    }//GEN-LAST:event_tbl_my_services_problemsMouseClicked

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        init_prob();
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        add_prob();
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void tf_service_item_codeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_service_item_codeActionPerformed
        init_inventory();
    }//GEN-LAST:event_tf_service_item_codeActionPerformed

    private void tbl_my_services_item_replacementsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_my_services_item_replacementsMouseClicked
        delete_replacement();
    }//GEN-LAST:event_tbl_my_services_item_replacementsMouseClicked

    private void tf_service_qtyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_service_qtyActionPerformed
        add_replacement();
    }//GEN-LAST:event_tf_service_qtyActionPerformed

    private void tf_service_type_id1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_service_type_id1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_service_type_id1ActionPerformed

    private void jCheckBox15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox15ActionPerformed
        data_cols();
    }//GEN-LAST:event_jCheckBox15ActionPerformed

    private void jCheckBox17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox17ActionPerformed
        data_cols();
    }//GEN-LAST:event_jCheckBox17ActionPerformed

    private void jCheckBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox3ActionPerformed
        data_cols();
    }//GEN-LAST:event_jCheckBox3ActionPerformed

    private void jCheckBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox4ActionPerformed
        data_cols();
    }//GEN-LAST:event_jCheckBox4ActionPerformed

    private void jCheckBox13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox13ActionPerformed
        data_cols();
    }//GEN-LAST:event_jCheckBox13ActionPerformed

    private void jCheckBox14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox14ActionPerformed
        data_cols();
    }//GEN-LAST:event_jCheckBox14ActionPerformed

    private void tbl_my_services_othersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_my_services_othersMouseClicked
        // TODO add your handling code here:
        delete_others();
    }//GEN-LAST:event_tbl_my_services_othersMouseClicked

    private void tf_service_qty1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_service_qty1ActionPerformed
        // TODO add your handling code here:
        tf_service_price1.grabFocus();
    }//GEN-LAST:event_tf_service_qty1ActionPerformed

    private void tf_service_description1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_service_description1ActionPerformed
        init_others();
    }//GEN-LAST:event_tf_service_description1ActionPerformed

    private void tf_service_price1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_service_price1ActionPerformed
        // TODO add your handling code here:
        add_others();
    }//GEN-LAST:event_tf_service_price1ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        data_cols();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void tbl_my_servicesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_my_servicesMousePressed
        popup(evt);
    }//GEN-LAST:event_tbl_my_servicesMousePressed

    private void tbl_my_servicesMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_my_servicesMouseReleased
        popup(evt);
    }//GEN-LAST:event_tbl_my_servicesMouseReleased

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        transfer_job();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jCheckBox18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox18ActionPerformed
        data_cols();
    }//GEN-LAST:event_jCheckBox18ActionPerformed

    private void tf_department2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_department2ActionPerformed
        init_service_by();
    }//GEN-LAST:event_tf_department2ActionPerformed

    private void tf_contact_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_contact_noActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_contact_noActionPerformed

    private void jTextField6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField6MouseClicked
        customers();
    }//GEN-LAST:event_jTextField6MouseClicked

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
        jTextField2.grabFocus();
    }//GEN-LAST:event_jTextField7ActionPerformed

    private void jCheckBox19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox19ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox19ActionPerformed

    private void btn_edit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_edit1ActionPerformed
        edit_description();
    }//GEN-LAST:event_btn_edit1ActionPerformed

    private void btn_edit2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_edit2ActionPerformed
        edit_prob();
    }//GEN-LAST:event_btn_edit2ActionPerformed

    private void btn_edit3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_edit3ActionPerformed
        edit_others();
    }//GEN-LAST:event_btn_edit3ActionPerformed

    private void tf_from_branchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_from_branchMouseClicked
        init_branch_locations2();
    }//GEN-LAST:event_tf_from_branchMouseClicked

    private void tf_from_branchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_from_branchActionPerformed
        init_branch_locations2();
    }//GEN-LAST:event_tf_from_branchActionPerformed

    private void tf_from_locationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_from_locationActionPerformed

    }//GEN-LAST:event_tf_from_locationActionPerformed

    private void pp_barcodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pp_barcodeActionPerformed
        // TODO add your handling code here:z

    }//GEN-LAST:event_pp_barcodeActionPerformed

    private void jMenuItem2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem2MouseClicked
        print_barcode();
    }//GEN-LAST:event_jMenuItem2MouseClicked

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        print_barcode();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_edit1;
    private javax.swing.JButton btn_edit2;
    private javax.swing.JButton btn_edit3;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private com.toedter.calendar.JDateChooser dp_assigned;
    private com.toedter.calendar.JDateChooser dp_from;
    private com.toedter.calendar.JDateChooser dp_received;
    private com.toedter.calendar.JDateChooser dp_released;
    private com.toedter.calendar.JDateChooser dp_to;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox10;
    private javax.swing.JCheckBox jCheckBox11;
    private javax.swing.JCheckBox jCheckBox12;
    private javax.swing.JCheckBox jCheckBox13;
    private javax.swing.JCheckBox jCheckBox14;
    private javax.swing.JCheckBox jCheckBox15;
    private javax.swing.JCheckBox jCheckBox16;
    private javax.swing.JCheckBox jCheckBox17;
    private javax.swing.JCheckBox jCheckBox18;
    private javax.swing.JCheckBox jCheckBox19;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JCheckBox jCheckBox7;
    private javax.swing.JCheckBox jCheckBox8;
    private javax.swing.JCheckBox jCheckBox9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JMenuItem pp_barcode;
    private javax.swing.JTable tbl_my_services;
    private javax.swing.JTable tbl_my_services_description;
    private javax.swing.JTable tbl_my_services_item_replacements;
    private javax.swing.JTable tbl_my_services_others;
    private javax.swing.JTable tbl_my_services_problems;
    private javax.swing.JTextField tf_amount;
    private javax.swing.JTextField tf_contact_no;
    private javax.swing.JTextField tf_customer_id;
    private javax.swing.JTextField tf_customer_name;
    private javax.swing.JTextField tf_department1;
    private javax.swing.JTextField tf_department2;
    private javax.swing.JTextField tf_department_id1;
    private javax.swing.JTextField tf_department_id2;
    private javax.swing.JTextArea tf_description;
    private javax.swing.JTextField tf_from_branch;
    private javax.swing.JTextField tf_from_branch_id;
    private javax.swing.JTextField tf_from_location;
    private javax.swing.JTextField tf_from_location_id;
    private javax.swing.JTextArea tf_problem;
    private javax.swing.JTextField tf_qty;
    private javax.swing.JTextArea tf_remarks;
    private javax.swing.JTextField tf_service_barcode;
    private javax.swing.JTextField tf_service_by_id;
    private javax.swing.JTextField tf_service_description;
    private javax.swing.JTextField tf_service_description1;
    private javax.swing.JTextField tf_service_item_code;
    private javax.swing.JTextField tf_service_price;
    private javax.swing.JTextField tf_service_price1;
    private javax.swing.JTextField tf_service_qty;
    private javax.swing.JTextField tf_service_qty1;
    private javax.swing.JTextField tf_service_slip_no;
    private javax.swing.JTextField tf_service_type;
    private javax.swing.JTextField tf_service_type1;
    private javax.swing.JTextField tf_service_type_id;
    private javax.swing.JTextField tf_service_type_id1;
    private javax.swing.JTextField tf_serviced_by;
    private javax.swing.JTextField tf_transaction_no;
    private javax.swing.JTextField tf_unit;
    // End of variables declaration//GEN-END:variables

    private void myInit() {

//        System.setProperty("pool_host", "localhost");
//        System.setProperty("pool_db", "db_algorithm");
        init_key();
        init_tbl_my_services();
        focus();
        init_tr();
        set_default_branch();
        init_trans_type();
        init_dep();
        hiden();
        init_tbl_my_services_description();
        init_tbl_my_services_problems();
        init_tbl_my_services_item_replacements();
        init_tbl_my_services_others();
        tf_service_type_id1.setVisible(false);
        Date d = DateUtils1.add_day(new Date(), -30);
        dp_from.setDate(d);

        String where = " order by branch,location asc ";
        branch_location_list2 = S1_branch_locations.ret_location_where(where);

        jLabel49.setVisible(false);
        jLabel50.setVisible(false);
        tf_from_branch.setVisible(false);
        tf_from_location.setVisible(false);
        tf_from_branch_id.setVisible(false);
        tf_from_location_id.setVisible(false);
    }

    List<S1_branch_locations.to_branch_locations> branch_location_list2 = new ArrayList();

    private void init_branch_locations2() {

        Object[][] obj = new Object[branch_location_list2.size()][2];
        int i = 0;
        for (S1_branch_locations.to_branch_locations to : branch_location_list2) {
            obj[i][0] = " " + to.branch;
            obj[i][1] = " " + to.location;
            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {150, 120};
        int width = 0;
        String[] col_names = {"Branch", "Location"};
        TableRenderer tr = new TableRenderer();
        TableRenderer.setPopup(tf_from_branch, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                S1_branch_locations.to_branch_locations to = branch_location_list2.get(data.selected_row);
                tf_from_branch.setText("" + to.branch);
                tf_from_branch_id.setText("" + to.branch_id);

                tf_from_location.setText("" + to.location);
                tf_from_location_id.setText("" + to.id);
            }
        });
    }

    String my_branch = "";
    String my_branch_id = "";
    String my_location = "";
    String my_location_id = "";

    private void set_default_branch() {
        servicing.branch_locations.S1_branch_locations.to_branch_locations to = S4_branch_locations.ret_data();
        my_branch = to.branch;
        my_branch_id = to.branch_id;
        my_location = to.location;
        my_location_id = "" + to.id;

        tf_from_branch.setText(my_branch);
        tf_from_branch_id.setText(my_branch_id);
        tf_from_location.setText(my_location);
        tf_from_location_id.setText(my_location_id);
    }

    private void hiden() {
        jLabel5.setVisible(false);
        tf_qty.setVisible(false);
        jLabel6.setVisible(false);
        tf_unit.setVisible(false);
        jLabel7.setVisible(false);
        jScrollPane1.setVisible(false);
        jLabel8.setVisible(false);
        jScrollPane2.setVisible(false);
        btn_edit1.setVisible(false);
        tf_service_by_id.setVisible(false);
        tf_customer_id.setVisible(false);
        btn_edit2.setVisible(false);
        tf_service_type_id.setVisible(false);
        tf_service_by_id.setVisible(false);
        tf_customer_id.setVisible(false);
        btn_edit3.setVisible(false);
        tf_department_id1.setVisible(false);
        tf_department_id2.setVisible(false);
    }

    private void init_dep() {
        List<My_services_departments.to_my_services_departments> datas = My_services_departments.ret_data("");
        String dep = "";
        String dep_id = "";
        String manager = "";
        String manager_id = "";
        int i = 0;
        for (My_services_departments.to_my_services_departments to : datas) {
            if (i == 0) {
                dep = to.department;
                dep_id = "" + to.id;
                manager = to.manager;
                manager_id = to.manager_id;
                break;
            }
        }
        tf_department1.setText(dep);
        tf_department_id1.setText(dep_id);
    }

    private void init_trans_type() {
        List<S1_my_service_type.to_my_service_type> datas = S1_my_service_type.ret_data("");
        String type = "";
        String type_id = "";
        int i = 0;
        for (S1_my_service_type.to_my_service_type to : datas) {
            if (i == 0) {
                type = to.service;
                type_id = "" + to.id;
                break;
            }
        }
        tf_service_type.setText(type);
        tf_service_type_id.setText(type_id);

        tf_service_type1.setText(type);
        tf_service_type_id1.setText(type_id);
    }

    private void init_tr() {
        String where = " where location_id='" + my_location_id + "' ";
        tf_transaction_no.setText(My_services.increment_id(where));
    }

    private void focus() {
        JTextField[] tf = {jTextField7, tf_contact_no, tf_department2, tf_service_slip_no, tf_serviced_by, tf_customer_name, tf_qty, tf_unit, tf_amount, jTextField12, tf_service_type, tf_department1, tf_service_type1, jTextField1, jTextField2, jTextField3, jTextField4, jTextField5, tf_service_description1, tf_service_qty1, tf_service_price1};
        JTextField[] tf3 = {tf_service_barcode, tf_service_description, tf_service_item_code, tf_service_qty};
        Focus_Fire.onFocus_lostFocus(tf);
        Focus_Fire.select_all(tf);
        Focus_Fire.onFocus_lostFocus(tf3);
        Focus_Fire.select_all(tf3);
        JTextArea[] tf2 = {tf_description, tf_problem, tf_remarks};
        Focus_Fire.onFocus_lostFocus(tf2);
        Focus_Fire.select_all(tf2);
    }

    public void do_pass() {

    }

    // <editor-fold defaultstate="collapsed" desc="Key">
    private void disposed() {
        this.dispose();
    }

    private void init_key() {
        KeyMapping.mapKeyWIFW(getSurface(),
                              KeyEvent.VK_ESCAPE, new KeyAction() {

                          @Override
                          public void actionPerformed(ActionEvent e) {
//                btn_0.doClick();
                              disposed();
                          }
                      });
    }
    // </editor-fold>

    public class CustomRenderer extends DefaultTableCellRenderer {

        private static final long serialVersionUID = 6703872492730589499L;

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (table.getValueAt(row, 7).equals(" On Going")) {

                int aw = Integer.parseInt(table.getValueAt(row, 3).toString());
                if (aw > 5) {
                    cellComponent.setBackground(new java.awt.Color(227, 185, 185));
                } else {
                    cellComponent.setBackground(new java.awt.Color(238, 230, 133));
                }
            }
            if (table.getValueAt(row, 7).equals(" Finished")) {
                cellComponent.setBackground(new java.awt.Color(156, 203, 25));
            }

            if (table.getValueAt(row, 7).equals(" Released")) {
                cellComponent.setBackground(new java.awt.Color(229, 188, 59));
            }
            if (table.getValueAt(row, 7).equals(" On Hold")) {
                cellComponent.setBackground(new java.awt.Color(139, 134, 130));
            }

            return cellComponent;
        }
    }
    private ArrayListModel tbl_my_services_ALM;
    private Tblmy_servicesModel tbl_my_services_M;

    private void init_tbl_my_services() {
        tbl_my_services_ALM = new ArrayListModel();
        tbl_my_services_M = new Tblmy_servicesModel(tbl_my_services_ALM);
        tbl_my_services.getTableHeader().setPreferredSize(new Dimension(100, 40));
        tbl_my_services.setModel(tbl_my_services_M);
        tbl_my_services.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_my_services.setRowHeight(25);
        int[] tbl_widths_my_services = {100, 100, 70, 40, 100, 100, 100, 100, 30, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_my_services.length; i < n; i++) {
            if (i == 6) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_my_services, i, tbl_widths_my_services[i]);
        }
        Dimension d = tbl_my_services.getTableHeader().getPreferredSize();
        d.height = 30;
        tbl_my_services.getTableHeader().setPreferredSize(d);
        tbl_my_services.getTableHeader().setFont(new java.awt.Font("Arial", 0, 11));
        tbl_my_services.setRowHeight(25);
        tbl_my_services.setFont(new java.awt.Font("Arial", 0, 11));
        tbl_my_services.getColumnModel().getColumn(0).setCellRenderer(new CustomRenderer());
        tbl_my_services.getColumnModel().getColumn(1).setCellRenderer(new CustomRenderer());
        tbl_my_services.getColumnModel().getColumn(2).setCellRenderer(new CustomRenderer());
        tbl_my_services.getColumnModel().getColumn(3).setCellRenderer(new CustomRenderer());
        tbl_my_services.getColumnModel().getColumn(4).setCellRenderer(new CustomRenderer());
        tbl_my_services.getColumnModel().getColumn(5).setCellRenderer(new CustomRenderer());
        tbl_my_services.getColumnModel().getColumn(6).setCellRenderer(new CustomRenderer());
        tbl_my_services.getColumnModel().getColumn(7).setCellRenderer(new CustomRenderer());

//        tbl_my_services.getColumnModel().getColumn(8).setCellRenderer(new CustomRenderer());
    }

    private void loadData_my_services(List<to_my_services> acc) {
        tbl_my_services_ALM.clear();
        tbl_my_services_ALM.addAll(acc);
    }

    public static class Tblmy_servicesModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Transaction #", "Service Slip #", "Date", "Days", "Customer", "Serviced By", "Problem", "Status", "", "customer_name", "customer_id", "qty", "unit", "description", "problem", "date_received", "date_assigned", "date_released", "added_by", "remarks", "status", "service_type", "service_type_id", "amount", "cashier", "cashier_id"
        };

        public Tblmy_servicesModel(ListModel listmodel) {
            super(listmodel, COLUMNS);
        }

        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }

        @Override
        public Class getColumnClass(int col) {
            if (col == 8) {
                return Boolean.class;
            }
            return Object.class;
        }

        @Override
        public Object getValueAt(int row, int col) {
            to_my_services tt = (to_my_services) getRow(row);
            switch (col) {
                case 0:
                    return " " + tt.transaction_no;
                case 1:
                    return " " + tt.service_slip_no;
                case 2:
                    return " " + DateType.convert_slash_datetime2(tt.date_assigned);
                case 3:
                    if (tt.status == 0) {
                        try {
                            Date d = DateType.sf.parse(tt.date_assigned);
                            int days = DateUtils1.count_days(d, new Date());
                            return days;
                        } catch (ParseException ex) {
                            Logger.getLogger(Dlg_my_services.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        return "";
                    }
                case 4:
                    return " " + tt.customer_name;
                case 5:
                    return " " + tt.serviced_by;
                case 6:
                    return " " + tt.problem;
                case 7:
                    if (tt.status == 0) {
                        return " On Going";
                    }
                    if (tt.status == 1) {
                        return " Finished";
                    }
                    if (tt.status == 2) {
                        return " Released";
                    }
                    if (tt.status == 3) {
                        return " On Hold";
                    }

                case 8:
                    return tt.selected;
                case 9:
                    return tt.customer_name;
                case 10:
                    return tt.customer_id;
                case 11:
                    return tt.qty;
                case 12:
                    return tt.unit;
                case 13:
                    return tt.description;
                case 14:
                    return tt.problem;
                case 15:
                    return tt.date_received;
                case 16:
                    return tt.date_assigned;
                case 17:
                    return tt.date_released;
                case 18:
                    return tt.added_by;
                case 19:
                    return tt.remarks;
                case 20:
                    return tt.status;
                case 21:
                    return tt.service_type;
                case 22:
                    return tt.service_type_id;
                case 23:
                    return tt.amount;
                case 24:
                    return tt.cashier;
                default:
                    return tt.cashier_id;
            }
        }
    }

    private void enables(boolean stmt) {
        jCheckBox17.setEnabled(stmt);
        jCheckBox3.setEnabled(stmt);
        jCheckBox4.setEnabled(stmt);
        jCheckBox5.setEnabled(stmt);
        jCheckBox13.setEnabled(stmt);
        jCheckBox14.setEnabled(stmt);
        jCheckBox19.setEnabled(stmt);
        jCheckBox6.setEnabled(stmt);
        jCheckBox7.setEnabled(stmt);
        jCheckBox8.setEnabled(stmt);
        jCheckBox9.setEnabled(stmt);
        jCheckBox15.setEnabled(stmt);

        jCheckBox11.setEnabled(stmt);
        tf_department1.setEnabled(stmt);
        jCheckBox18.setEnabled(stmt);
        tf_department2.setEnabled(stmt);
        jCheckBox12.setEnabled(stmt);
        tf_service_type1.setEnabled(stmt);
        jTextField12.setEnabled(stmt);
        jButton9.setEnabled(stmt);

    }

    private void data_cols() {
        jProgressBar1.setString("Loading...Please wait...");
        jProgressBar1.setIndeterminate(true);
        enables(false);
        String where = "";
        String search = jTextField12.getText();
        if (jCheckBox3.isSelected()) {
            where = " where customer_name like '%" + search + "%' ";
        }
        if (jCheckBox4.isSelected()) {
            where = " where description like '%" + search + "%' ";
        }
        if (jCheckBox5.isSelected()) {
            where = " where problem like '%" + search + "%' ";
        }
        if (jCheckBox13.isSelected()) {
            where = " where transaction_no like '%" + search + "%' ";
        }
        if (jCheckBox14.isSelected()) {
            where = " where service_slip_no like '%" + search + "%' ";
        }

        String trans_no = "";
        if (jCheckBox19.isSelected()) {
            String w = " where barcode ='" + jTextField12.getText() + "' ";

            List<My_services_description_customers.to_my_services_description_customers> aw = My_services_description_customers.ret_data3(w);
            for (My_services_description_customers.to_my_services_description_customers aww : aw) {
                trans_no = aww.transaction_no;
            }
            if (!trans_no.isEmpty()) {
                where = " where transaction_no like '%" + trans_no + "%' ";
            } else {
                where = " where transaction_no like '%" + "" + "%' ";
            }
        }

        if (jCheckBox6.isSelected()) {
            where = where + " ";
        }
        if (jCheckBox7.isSelected()) {
            where = where + " and status='" + "0" + "' ";
        }
        if (jCheckBox8.isSelected()) {
            where = where + " and status='" + "1" + "' ";
        }
        if (jCheckBox9.isSelected()) {
            where = where + " and status='" + "2" + "' ";
        }
        if (jCheckBox15.isSelected()) {
            where = where + " and status='" + "3" + "' ";
        }
        if (!jCheckBox11.isSelected()) {
            where = where + " and department_id='" + tf_department_id1.getText() + "' ";
        }

        if (!jCheckBox12.isSelected()) {
            where = where + " and service_type_id='" + tf_service_type_id1.getText() + "' ";
        }
        String from = DateType.sf.format(dp_from.getDate());
        String to = DateType.sf.format(dp_to.getDate());
        if (!jCheckBox17.isSelected()) {
            where = where + " and Date(date_assigned) between '" + from + "' and '" + to + "' ";
        }
        if (!jCheckBox18.isSelected()) {
            where = where + " and service_by_id = '" + tf_department_id2.getText() + "'  ";
        }

        where = where + " and location_id ='" + tf_from_location_id.getText() + "' order by transaction_no asc";
        System.out.println(where);
        List<to_my_services> datas = My_services.ret_data(where);

        loadData_my_services(datas);
        int on_going = 0;
        int finished = 0;
        int released = 0;
        int total = 0;
        int on_hold = 0;
        for (to_my_services to1 : datas) {
            if (to1.status == 0) {
                on_going++;
            }
            if (to1.status == 1) {
                finished++;
            }
            if (to1.status == 2) {
                released++;
            }
            if (to1.status == 3) {
                on_hold++;
            }
            total++;
        }
        jLabel19.setText(FitIn.fmt_woc(on_going));
        jLabel20.setText(FitIn.fmt_woc(finished));
        jLabel23.setText(FitIn.fmt_woc(released));
        jLabel39.setText(FitIn.fmt_woc(on_hold));
        jLabel41.setText(FitIn.fmt_woc(total));
        jProgressBar1.setString("Finished...");
        jProgressBar1.setIndeterminate(false);
        enables(true);

    }

    String department_manager = "";
    String department_manager_id = "";
    String department = "";
    String department_id = "";

    private void add_my_services() {
        int id = -1;
        String where = " where location_id='" + my_location_id + "' ";
        String transaction_no = My_services.increment_id(where);
        String service_slip_no = tf_service_slip_no.getText();
        String serviced_by = tf_serviced_by.getText();
        String service_by_id = tf_service_by_id.getText();

        String customer_name = tf_customer_name.getText();
        String customer_id = tf_customer_id.getText();
        double qty = FitIn.toDouble(tf_qty.getText());
        String unit = tf_unit.getText();
        String description = tf_description.getText();
        String problem = tf_problem.getText();
        String date_received = DateType.sf.format(dp_assigned.getDate());
        String date_assigned = DateType.sf.format(dp_assigned.getDate());
        String date_released = DateType.sf.format(dp_assigned.getDate());
        String added_by = "";
        String remarks = tf_remarks.getText();
        int status = 0;
        if (jCheckBox1.isSelected()) {
            status = 0;
        }
        if (jCheckBox2.isSelected()) {
            status = 1;
        }
        if (jCheckBox10.isSelected()) {
            status = 2;
        }
        if (jCheckBox16.isSelected()) {
            status = 3;
        }
        String service_type = tf_service_type.getText();
        String service_type_id = tf_service_type_id.getText();
        double amount = FitIn.toDouble(tf_amount.getText());
        String cashier = "";
        String cashier_id = "";
        String user_id = MyUser.getUser_id();
        String user_screen_name = MyUser.getUser_screen_name();
        String customer_contact_no = tf_contact_no.getText();

        to_my_services to = new to_my_services(id, transaction_no, service_slip_no, serviced_by, service_by_id, department_manager, department_manager_id, department, department_id, customer_name, customer_id, qty, unit, description, problem, date_received, date_assigned, date_released, added_by, remarks, status, service_type, service_type_id, amount, cashier, cashier_id, false, user_id, user_screen_name, customer_contact_no, my_branch, my_branch_id, my_location, my_location_id);
//        My_services.add_my_services(to);
        add_all_others(transaction_no);
        add_all_problems(transaction_no);
        add_all_replacements(transaction_no);
        add_all_services(transaction_no);
        data_cols();
        clear_my_services();
        tbl_my_services_description_ALM.clear();
        tbl_my_services_description_M.fireTableDataChanged();
        tbl_my_services_item_replacements_ALM.clear();
        tbl_my_services_item_replacements_M.fireTableDataChanged();
        tbl_my_services_others_ALM.clear();
        tbl_my_services_others_M.fireTableDataChanged();
        tbl_my_services_problems_ALM.clear();
        tbl_my_services_problems_M.fireTableDataChanged();
        compute_all();
        Alert.set(1, "");

    }

    private void add_all_services(String transaction_no) {

        String customer_name = tf_customer_name.getText();
        String customer_id = tf_customer_id.getText();
        List<S1_my_services_description.to_my_services_description> desc = tbl_my_services_description_ALM;
        List<My_services_description_customers.to_my_services_description_customers> da = new ArrayList();
        for (S1_my_services_description.to_my_services_description t5 : desc) {
            My_services_description_customers.to_my_services_description_customers t2
                    = new My_services_description_customers.to_my_services_description_customers(
                            0, t5.description, t5.amount, customer_id, customer_name, transaction_no, DateType.datetime.format(new Date()), MyUser.user_name, t5.unit, t5.barcode, my_branch, my_branch_id, my_location, my_location_id);
            System.out.println("Desc: " + t5.description);
            da.add(t2);
        }
        My_services_description_customers.add_my_services_description_customers(da);
    }

    private void add_all_problems(String transaction_no) {
        List<My_services_problems_customers.to_my_services_problems_customers> datas = new ArrayList();
        List<S1_my_services_problems.to_my_services_problems> probs = tbl_my_services_problems_ALM;
        for (S1_my_services_problems.to_my_services_problems to : probs) {
            int id = 0;
            String problem = to.problem;
            String customer_id = tf_customer_id.getText();
            String customer_name = tf_customer_name.getText();

            String date_added = DateType.datetime.format(new Date());
            double am = to.amount;
            My_services_problems_customers.to_my_services_problems_customers to1 = new My_services_problems_customers.to_my_services_problems_customers(id, problem, customer_id, customer_name, transaction_no, date_added, am, my_branch, my_branch_id, my_location, my_location_id);
            datas.add(to1);
        }
        My_services_problems_customers.add_my_services_problems_customers(datas);
    }

    private void add_all_replacements(String transaction_no) {
        List<My_services_item_replacements_customers.to_my_services_item_replacements_customers> datas = new ArrayList();
        List<S1_my_services_item_replacements.to_my_services_item_replacements> reps = tbl_my_services_item_replacements_ALM;
        String customer_name = tf_customer_name.getText();
        String customer_id = tf_customer_id.getText();
        for (S1_my_services_item_replacements.to_my_services_item_replacements to : reps) {
            int id = to.id;
            String item_code = to.item_code;
            String barcode = to.barcode;
            String description = to.description;
            double qty = to.qty;
            double selling_price = to.price;
            String date_added = DateType.now();
            String user_name = MyUser.getUser_name();
            String category = to.category;
            String category_id = to.category_id;
            String classification = to.classification;
            String classification_id = to.classification_id;
            String sub_classification = to.sub_classification;
            String sub_classification_id = to.sub_classification_id;
            String unit = to.unit;
            double conversion = to.conversion;
            String item_type = to.item_type;
            int status = to.status;
            String supplier = to.supplier;
            int fixed_price = to.fixed_price;
            String supplier_id = to.supplier_id;
            int multi_level_pricing = to.multi_level_pricing;
            int vatable = to.vatable;
            double reorder_level = to.reorder_level;
            double markup = to.markup;
            String brand = to.brand;
            String brand_id = to.brand_id;
            String model = to.model;
            String model_id = to.model_id;
            String selling_type = to.selling_type;
            String branch = to.branch;
            String branch_code = to.branch_code;
            String location = to.location;
            String location_id = to.location_id;
            String serial_no = to.serial_no;
            String user_id = MyUser.getUser_id();
            String user_screen_name = MyUser.getUser_screen_name();

            My_services_item_replacements_customers.to_my_services_item_replacements_customers to1 = new My_services_item_replacements_customers.to_my_services_item_replacements_customers(id, transaction_no, customer_id, customer_name, item_code, barcode, description, qty, selling_price, date_added, user_name, category, category_id, classification, classification_id, sub_classification, sub_classification_id, unit, conversion, item_type, status, supplier, fixed_price, supplier_id, multi_level_pricing, vatable, reorder_level, markup, brand, brand_id, model, model_id, selling_type, branch, branch_code, location, location_id, serial_no, user_id, user_screen_name);
            datas.add(to1);
        }

        My_services_item_replacements_customers.add_data(datas);
    }

    private void add_all_others(String transaction_no) {

        List<My_services_others_customers.to_my_services_others_customers> datas = new ArrayList();
        List<S1_my_services_others.to_my_services_others> others = tbl_my_services_others_ALM;
        for (S1_my_services_others.to_my_services_others to : others) {
            String user_name = MyUser.user_name;
            int id = -1;
            String customer_id = tf_customer_id.getText();
            String customer_name = tf_customer_name.getText();

            String date_added = DateType.datetime.format(new Date());
            String name = to.name;
            System.out.println("Name: " + name);
            double amount = to.amount;
            double qty = to.qty;
            My_services_others_customers.to_my_services_others_customers to1 = new My_services_others_customers.to_my_services_others_customers(id, customer_id, customer_name, transaction_no, date_added, name, amount, qty, my_branch, my_branch_id, my_location, my_location_id);
            datas.add(to1);
        }

        My_services_others_customers.add_my_services_others_customers(datas);
    }

    private void select_my_services() {
        int row = tbl_my_services.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_my_services to = (to_my_services) tbl_my_services_ALM.get(tbl_my_services.convertRowIndexToModel(row));
        int col = tbl_my_services.getSelectedColumn();
        if (col == 8) {
            if (to.selected == true) {
                to.setSelected(false);
            } else {
                to.setSelected(true);
            }
            tbl_my_services_M.fireTableDataChanged();
        } else {

            tf_transaction_no.setText(to.transaction_no);
            tf_service_slip_no.setText(to.service_slip_no);
            tf_serviced_by.setText(to.serviced_by);
            tf_service_by_id.setText(to.service_by_id);

            department_manager = to.department_manager;
            department_manager_id = to.department_manager_id;
            department = to.department;
            department_id = to.department_id;
            tf_customer_name.setText(to.customer_name);
            tf_customer_id.setText(to.customer_id);
            tf_qty.setText(FitIn.fmt_woc(to.qty));
            tf_unit.setText(to.unit);
            tf_description.setText(to.description);
            tf_problem.setText(to.problem);
            tf_contact_no.setText(to.customer_contact_no);
            try {
                Date released = DateType.sf.parse(to.date_released);
                Date received = DateType.sf.parse(to.date_received);
                Date assigned = DateType.sf.parse(to.date_assigned);
                dp_received.setDate(received);
                dp_assigned.setDate(assigned);
                dp_released.setDate(released);
            } catch (ParseException ex) {
                Logger.getLogger(Dlg_my_services.class.getName()).log(Level.SEVERE, null, ex);
            }

            tf_remarks.setText(to.remarks);

            if (to.status == 0) {
                jCheckBox1.setSelected(true);
            }

            if (to.status == 1) {
                jCheckBox2.setSelected(true);
            }

            if (to.status == 2) {
                jCheckBox3.setSelected(true);
            }

            tf_service_type.setText(to.service_type);
            tf_service_type_id.setText(to.service_type_id);
            tf_amount.setText(FitIn.fmt_wc_0(to.amount));

            jButton5.setEnabled(false);
            if (view_only == 0) {
                if (cashier_only == 0) {
                    jButton4.setEnabled(true);
                    jButton3.setEnabled(true);
                }

            }

            data_cols_description();
            data_probs();
            data_cols_item_replacements();
            data_cols_others();
            compute_all();

        }

    }

    private void edit_my_services() {
        int row = tbl_my_services.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_my_services to = (to_my_services) tbl_my_services_ALM.get(tbl_my_services.convertRowIndexToModel(row));
        int id = to.id;
        String transaction_no = tf_transaction_no.getText();
        String service_slip_no = tf_service_slip_no.getText();
        String serviced_by = tf_serviced_by.getText();
        String service_by_id = tf_service_by_id.getText();

        String customer_name = tf_customer_name.getText();
        String customer_id = tf_customer_id.getText();
        double qty = FitIn.toDouble(tf_qty.getText());
        String unit = tf_unit.getText();
        String description = tf_description.getText();
        String problem = tf_problem.getText();
        String date_received = DateType.sf.format(dp_received.getDate());
        String date_assigned = DateType.sf.format(dp_assigned.getDate());
        String date_released = DateType.sf.format(dp_released.getDate());
        String added_by = "";
        String remarks = tf_remarks.getText();
        int status = 0;
        if (jCheckBox1.isSelected()) {
            status = 0;
        }
        if (jCheckBox2.isSelected()) {
            status = 1;
        }
        if (jCheckBox10.isSelected()) {
            status = 2;
        }
        if (jCheckBox16.isSelected()) {
            status = 3;
        }

        String service_type = tf_service_type.getText();
        String service_type_id = tf_service_type_id.getText();
        double amount = FitIn.toDouble(tf_amount.getText());
        String cashier = "";
        String cashier_id = "";
        String user_id = MyUser.getUser_id();
        String user_screen_name = MyUser.getUser_screen_name();
        String customer_contact_no = tf_contact_no.getText();

        to_my_services to1 = new to_my_services(id, transaction_no, service_slip_no, serviced_by, service_by_id, department_manager, department_manager_id, department, department_id, customer_name, customer_id, qty, unit, description, problem, date_received, date_assigned, date_released, added_by, remarks, status, service_type, service_type_id, amount, cashier, cashier_id, false, user_id, user_screen_name, customer_contact_no, to.branch, to.branch_id, to.location, to.location_id);
        My_services.edit_my_services(to1);
        data_cols();

        tbl_my_services_description_ALM.clear();
        tbl_my_services_description_M.fireTableDataChanged();
        tbl_my_services_problems_ALM.clear();
        tbl_my_services_problems_M.fireTableDataChanged();
        clear_my_services();
        Alert.set(2, "");
    }

    private void clear_my_services() {

        tf_transaction_no.setText("");
        tf_service_slip_no.setText("");
        tf_serviced_by.setText("");
        tf_service_by_id.setText("");
        department_manager = "";
        department_manager_id = "";
        department = "";
        department_id = "";
        tf_customer_name.setText("");
        tf_customer_id.setText("");
        tf_qty.setText("");
        tf_unit.setText("");
        tf_description.setText("");
        tf_problem.setText("");
        tf_remarks.setText("");
        jCheckBox1.setSelected(true);
        tf_service_type.setText("");
        tf_service_type_id.setText("");
        tf_amount.setText("");
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField7.setText("");
        init_tr();

    }

    private void delete_my_services() {
        final int row = tbl_my_services.getSelectedRow();
        if (row < 0) {
            return;
        }
        Window p = (Window) this;
        Dlg_my_service_confirm nd = Dlg_my_service_confirm.create(p, true);
        nd.setTitle("");
        nd.setCallback(new Dlg_my_service_confirm.Callback() {
            @Override
            public void ok(CloseDialog closeDialog, Dlg_my_service_confirm.OutputData data) {
                closeDialog.ok();
                to_my_services to = (to_my_services) tbl_my_services_ALM.get(tbl_my_services.convertRowIndexToModel(row));
                My_services.delete_my_services(to);
                data_cols();
                clear_my_services();
                tbl_my_services_description_ALM.clear();
                tbl_my_services_description_M.fireTableDataChanged();
                tbl_my_services_description_ALM.clear();
                tbl_my_services_description_M.fireTableDataChanged();
                tbl_my_services_problems_ALM.clear();
                tbl_my_services_problems_M.fireTableDataChanged();
                Alert.set(3, "");
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);

    }

    List<My_services_crews.to_my_services_crews> manager_list = new ArrayList();

    private void init_manager() {
        String search = tf_serviced_by.getText();
        manager_list.clear();
        String where = " where lname like '%" + search + "%' and location_id='" + my_location_id + "' "
                + " or fname like '%" + search + "%' and location_id='" + my_location_id + "' order by lname asc";
        manager_list = My_services_crews.ret_data(where);
        Object[][] obj = new Object[manager_list.size()][1];
        int i = 0;
        for (My_services_crews.to_my_services_crews to : manager_list) {
            obj[i][0] = to.fname + " " + to.mi + " " + to.lname;
            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {300};
        int width = 0;
        String[] col_names = {""};
        TableRenderer tr = new TableRenderer();
        TableRenderer.setPopup(tf_serviced_by, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                My_services_crews.to_my_services_crews to = manager_list.get(data.selected_row);
                tf_serviced_by.setText("" + to.fname + " " + to.mi + " " + to.lname);
                tf_service_by_id.setText("" + to.id);
                tf_customer_name.grabFocus();
                department_manager = to.manager;
                department_manager_id = to.manager_id;
                department = to.department;
                department_id = to.department_id;
            }
        });
    }

    List<My_services_customers.to_my_services_customers> customer_list = new ArrayList();

    private void init_customer() {
        String search = tf_customer_name.getText();
        customer_list.clear();
        String where = " where customer_name like '%" + search + "%' and location_id='" + my_location_id + "' order by customer_name asc ";
        customer_list = My_services_customers.ret_data(where);
        if (customer_list.isEmpty()) {
//            add_customer();
            customers();
        } else {
            Object[][] obj = new Object[customer_list.size()][1];
            int i = 0;
            for (My_services_customers.to_my_services_customers to : customer_list) {
                obj[i][0] = " " + to.customer_name;
                i++;
            }
            JLabel[] labels = {};
            int[] tbl_widths_customers = {300};
            int width = 0;
            String[] col_names = {""};
            TableRenderer tr = new TableRenderer();
            TableRenderer.setPopup(tf_customer_name, obj, labels, tbl_widths_customers, col_names);
            tr.setCallback(new TableRenderer.Callback() {
                @Override
                public void ok(TableRenderer.OutputData data) {
                    My_services_customers.to_my_services_customers to = customer_list.get(data.selected_row);
                    tf_customer_name.setText("" + to.customer_name);
                    tf_customer_id.setText("" + to.customer_no);
                    tf_contact_no.setText(to.contact_no);
                    tf_qty.grabFocus();
                }
            });
        }
    }

    private void add_customer() {
        String customer_no = My_services_customers.increment_id(my_branch_id);
        String customer_name = tf_customer_name.getText();
        String address = "";
        String contact_no = "";
        double balance = 0;
        My_services_customers.to_my_services_customers to = new My_services_customers.to_my_services_customers(-1, customer_no, customer_name, address, contact_no, balance, my_branch, my_branch_id, my_location, my_location_id);
        My_services_customers.add_my_services_customers(to);
    }

    List<My_services_departments.to_my_services_departments> department_list = new ArrayList();

    private void init_departments() {
        String search = tf_department1.getText();
        department_list.clear();
        String where = " where location_id='" + my_location_id + "' ";
        department_list = My_services_departments.ret_data(where);
        Object[][] obj = new Object[department_list.size()][1];
        int i = 0;
        for (My_services_departments.to_my_services_departments to : department_list) {
            obj[i][0] = to.department;
            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {300};
        int width = 0;
        String[] col_names = {""};
        TableRenderer tr = new TableRenderer();
        TableRenderer.setPopup(tf_department1, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                My_services_departments.to_my_services_departments to = department_list.get(data.selected_row);
                tf_department_id1.setText("" + to.id);
                tf_department1.setText("" + to.department);
                data_cols();
            }
        });
    }

    List<S1_my_service_type.to_my_service_type> trans_list = new ArrayList();

    private void init_type() {
        String search = tf_service_type.getText();
        trans_list.clear();
        String where = "";
        trans_list = S1_my_service_type.ret_data(where);
        Object[][] obj = new Object[trans_list.size()][1];
        int i = 0;
        for (S1_my_service_type.to_my_service_type to : trans_list) {
            obj[i][0] = to.service;
            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {300};
        int width = 0;
        String[] col_names = {""};
        TableRenderer tr = new TableRenderer();
        TableRenderer.setPopup(tf_service_type, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                S1_my_service_type.to_my_service_type to = trans_list.get(data.selected_row);
                tf_service_type_id.setText("" + to.id);
                tf_service_type.setText("" + to.service);

            }
        });
    }

    private void init_type2() {
        String search = tf_service_type1.getText();
        trans_list.clear();
        String where = " where location_id='" + my_location_id + "' ";
        trans_list = S1_my_service_type.ret_data(where);
        Object[][] obj = new Object[trans_list.size()][1];
        int i = 0;
        for (S1_my_service_type.to_my_service_type to : trans_list) {
            obj[i][0] = to.service;
            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {tf_service_type1.getWidth()};
        int width = 0;
        String[] col_names = {""};
        TableRenderer tr = new TableRenderer();
        TableRenderer.setPopup(tf_service_type1, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                S1_my_service_type.to_my_service_type to = trans_list.get(data.selected_row);
                tf_service_type_id1.setText("" + to.id);
                tf_service_type1.setText("" + to.service);
                data_cols();
            }
        });
    }

    private void departments() {
        Window p = (Window) this;
        Dlg_my_services_departments nd = Dlg_my_services_departments.create(p, true);
        nd.setTitle("");
        nd.setCallback(new Dlg_my_services_departments.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_my_services_departments.OutputData data) {
                closeDialog.ok();

            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }

    private void members() {
        Window p = (Window) this;
        Dlg_my_services_crews nd = Dlg_my_services_crews.create(p, true);
        nd.setTitle("");
        nd.setCallback(new Dlg_my_services_crews.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_my_services_crews.OutputData data) {
                closeDialog.ok();
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }

    private void customers() {
        Window p = (Window) this;
        Dlg_my_services_customers nd = Dlg_my_services_customers.create(p, true);
        nd.setTitle("");

        nd.setCallback(new Dlg_my_services_customers.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_my_services_customers.OutputData data) {
                closeDialog.ok();
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }

    private void type() {
        Window p = (Window) this;
        Dlg_my_service_type nd = Dlg_my_service_type.create(p, true);
        nd.setTitle("");
        nd.setCallback(new Dlg_my_service_type.Callback() {
            @Override
            public void ok(CloseDialog closeDialog, Dlg_my_service_type.OutputData data) {
                closeDialog.ok();

            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }

    private ArrayListModel tbl_my_services_description_ALM;
    private Tblmy_services_descriptionModel tbl_my_services_description_M;
    int description_size = 40;

    private void init_tbl_my_services_description() {
        tbl_my_services_description_ALM = new ArrayListModel();
        tbl_my_services_description_M = new Tblmy_services_descriptionModel(tbl_my_services_description_ALM);
        tbl_my_services_description.getTableHeader().setPreferredSize(new Dimension(100, 40));
        tbl_my_services_description.setModel(tbl_my_services_description_M);
        tbl_my_services_description.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_my_services_description.setRowHeight(25);
        int[] tbl_widths_my_services_description = {30, 100, description_size};
        for (int i = 0, n = tbl_widths_my_services_description.length; i < n; i++) {
            if (i == 1) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_my_services_description, i, tbl_widths_my_services_description[i]);
        }
        Dimension d = tbl_my_services_description.getTableHeader().getPreferredSize();
        d.height = 0;
        tbl_my_services_description.getTableHeader().setPreferredSize(d);
        tbl_my_services_description.getTableHeader().setFont(new java.awt.Font("Arial", 0, 11));
        tbl_my_services_description.setRowHeight(25);
        tbl_my_services_description.setFont(new java.awt.Font("Arial", 0, 11));
    }

    private void loadData_my_services_description(List<to_my_services_description> acc) {
        tbl_my_services_description_ALM.clear();
        tbl_my_services_description_ALM.addAll(acc);
    }

    public static class Tblmy_services_descriptionModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Qty", "Description", " "
        };

        public Tblmy_services_descriptionModel(ListModel listmodel) {
            super(listmodel, COLUMNS);
        }

        @Override
        public boolean isCellEditable(int row, int column) {

            return false;
        }

        @Override
        public Class getColumnClass(int col) {
            if (col == 1000) {
                return Boolean.class;
            }
            return Object.class;
        }

        @Override
        public Object getValueAt(int row, int col) {
            to_my_services_description tt = (to_my_services_description) getRow(row);
            switch (col) {
                case 0:
                    return " " + FitIn.fmt_woc(tt.amount);
                case 1:
                    return " " + tt.description;
                default:
                    return " Delete";
            }
        }
    }

    private void data_cols_description() {
        int row = tbl_my_services.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_my_services to = (to_my_services) tbl_my_services_ALM.get(tbl_my_services.convertRowIndexToModel(row));

        String where = "where transaction_no='" + to.transaction_no + "' order by description asc";
        System.out.println(where);
        loadData_my_services_description(My_services_description_customers.ret_data(where));
    }

    List<S1_my_services_description.to_my_services_description> description_list = new ArrayList();

    private void init_description() {
        String search = jTextField1.getText();
        description_list.clear();
        String where = " where description like '%" + search + "%' "
                + "   order by description asc";
        description_list = S1_my_services_description.ret_data(where);
        Object[][] obj = new Object[description_list.size()][1];
        int i = 0;
        for (S1_my_services_description.to_my_services_description to : description_list) {
            obj[i][0] = to.description;
            i++;
        }
        if (description_list.isEmpty()) {
            to_my_services_description t = new to_my_services_description(0, search, 0, "", "");
            S1_my_services_description.add_my_services_description(t);
            jTextField2.grabFocus();
        } else {
            JLabel[] labels = {};
            int[] tbl_widths_customers = {300};
            int width = 0;
            String[] col_names = {""};
            TableRenderer tr = new TableRenderer();
            TableRenderer.setPopup(jTextField1, obj, labels, tbl_widths_customers, col_names);
            tr.setCallback(new TableRenderer.Callback() {
                @Override
                public void ok(TableRenderer.OutputData data) {
                    S1_my_services_description.to_my_services_description to = description_list.get(data.selected_row);
                    jTextField1.setText("" + to.description);
                    jTextField2.grabFocus();
                }
            });
        }
    }

    private void add_description() {
        String search = jTextField1.getText();
        double amount = FitIn.toDouble(jTextField2.getText());
        String unit = jTextField3.getText();
        String barcode = jTextField7.getText();
        to_my_services_description t = new to_my_services_description(-1, search, amount, unit, barcode);
        if (jButton5.isEnabled()) {
            tbl_my_services_description_ALM.add(t);
            tbl_my_services_description_M.fireTableDataChanged();
            jTextField1.setText("");
            jTextField2.setText("");
            jTextField3.setText("");
            jTextField1.grabFocus();
        } else {
            int id = 0;
            String description = jTextField1.getText();
            String customer_id = tf_customer_id.getText();
            String customer_name = tf_customer_name.getText();
            String transaction_no = tf_transaction_no.getText();
            String date_added = DateType.datetime.format(new Date());
            String user_name = MyUser.user_name;

            My_services_description_customers.to_my_services_description_customers t1 = new My_services_description_customers.to_my_services_description_customers(0, description, amount, customer_id, customer_name, transaction_no, date_added, user_name, unit, barcode, my_branch, my_branch_id, my_location, my_location_id);
            My_services_description_customers.add_my_services_description_customers(t1);
            data_cols_description();
            jTextField1.setText("");
            jTextField2.setText("");
            jTextField3.setText("");
            jTextField1.grabFocus();
        }

    }

    private void delete_description() {
        int row = tbl_my_services_description.getSelectedRow();
        if (row < 0) {
            return;
        }
        int col = tbl_my_services_description.getSelectedColumn();
        if (col < 0) {
            return;
        }

        to_my_services_description to = (to_my_services_description) tbl_my_services_description_ALM.get(tbl_my_services_description.convertRowIndexToModel(row));

        if (col == 2) {
            if (jButton5.isEnabled()) {
                tbl_my_services_description_ALM.remove(row);
                tbl_my_services_description_M.fireTableDataChanged();
            } else if (view_only == 0) {
//                My_services_description_customers.delete_my_services_description_customers(to);
                data_cols_description();
            }
        } else {
            jTextField1.setText(to.description);
            jTextField3.setText(to.unit);
            jTextField2.setText(FitIn.fmt_woc(to.amount));
            jTextField7.setText(to.barcode);
            if (view_only == 0) {
                btn_edit1.setVisible(true);
            }

        }
    }

    private void edit_description() {
        int row = tbl_my_services_description.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_my_services_description to = (to_my_services_description) tbl_my_services_description_ALM.get(
                tbl_my_services_description.convertRowIndexToModel(row));
        if (to.id == -1) {
            double qty = FitIn.toDouble(jTextField2.getText());
            String unit = jTextField3.getText();
            to.setAmount(qty);
            to.setUnit(unit);
            tbl_my_services_description_M.fireTableDataChanged();
            btn_edit1.setVisible(false);
            jTextField1.setText("");
            jTextField2.setText("");
            jTextField3.setText("");
            jTextField7.setText("");
            btn_edit1.setVisible(false);
            String barcode = jTextField7.getText();
        } else {
            int id = to.id;
            String description = jTextField1.getText();
            String customer_id = tf_customer_id.getText();
            String customer_name = tf_customer_name.getText();
            String transaction_no = tf_transaction_no.getText();
            String date_added = DateType.datetime.format(new Date());
            String user_name = MyUser.user_name;
            double qty = FitIn.toDouble(jTextField2.getText());
            String unit = jTextField3.getText();
            String barcode = jTextField7.getText();
            My_services_description_customers.to_my_services_description_customers s = new My_services_description_customers.to_my_services_description_customers(id, description, qty, customer_id, customer_name, transaction_no, date_added, user_name, unit, barcode, my_branch, my_branch_id, my_location, my_location_id);
            My_services_description_customers.edit_my_services_description_customers(s);
            data_cols_description();
            jTextField1.setText("");
            jTextField2.setText("");
            jTextField3.setText("");
            jTextField7.setText("");
            btn_edit1.setVisible(false);

        }
    }
    List<S1_my_services_uom.to_my_services_uom> uom_list = new ArrayList();

    private void init_uom() {
        String search = jTextField3.getText();
        uom_list.clear();
        String where = " where uom like '%" + search + "%' order by uom asc ";
        uom_list = S1_my_services_uom.ret_data(where);
        Object[][] obj = new Object[uom_list.size()][1];
        int i = 0;
        for (S1_my_services_uom.to_my_services_uom to : uom_list) {
            obj[i][0] = to.uom;
            i++;
        }
        if (uom_list.isEmpty()) {
            if (!search.isEmpty()) {
                S1_my_services_uom.to_my_services_uom t5 = new S1_my_services_uom.to_my_services_uom(0, search);
                S1_my_services_uom.add_my_services_uom(t5);
            }
        } else {
            JLabel[] labels = {};
            int[] tbl_widths_customers = {300};
            int width = 0;
            String[] col_names = {""};
            TableRenderer tr = new TableRenderer();
            TableRenderer.setPopup(jTextField3, obj, labels, tbl_widths_customers, col_names);
            tr.setCallback(new TableRenderer.Callback() {
                @Override
                public void ok(TableRenderer.OutputData data) {
                    S1_my_services_uom.to_my_services_uom to = uom_list.get(data.selected_row);
                    jTextField3.setText("" + to.uom);
                    if (!btn_edit1.isVisible()) {
                        add_description();
                    }
                }
            });
        }
    }

    List<S1_my_services_description.to_my_services_description> problem_list = new ArrayList();

    private void init_problem() {
        String search = jTextField1.getText();
        description_list.clear();
        String where = " where description like '%" + search + "%' "
                + "   order by description asc";
        description_list = S1_my_services_description.ret_data(where);
        Object[][] obj = new Object[description_list.size()][1];
        int i = 0;
        for (S1_my_services_description.to_my_services_description to : description_list) {
            obj[i][0] = to.description;
            i++;
        }
        if (description_list.isEmpty()) {
            to_my_services_description t = new to_my_services_description(0, search, 0, "", "");
            S1_my_services_description.add_my_services_description(t);
            jTextField2.grabFocus();
        } else {
            JLabel[] labels = {};
            int[] tbl_widths_customers = {300};
            int width = 0;
            String[] col_names = {""};
            TableRenderer tr = new TableRenderer();
            TableRenderer.setPopup(jTextField1, obj, labels, tbl_widths_customers, col_names);
            tr.setCallback(new TableRenderer.Callback() {
                @Override
                public void ok(TableRenderer.OutputData data) {
                    S1_my_services_description.to_my_services_description to = description_list.get(data.selected_row);
                    jTextField1.setText("" + to.description);
                    jTextField2.grabFocus();
                }
            });
        }
    }

    List<S1_my_services_problems.to_my_services_problems> prob_list = new ArrayList();

    private void init_prob() {
        String search = jTextField4.getText();
        prob_list.clear();
        String where = " where problem like '%" + search + "%' order by problem asc ";
        prob_list = S1_my_services_problems.ret_data(where);
        Object[][] obj = new Object[prob_list.size()][1];
        int i = 0;
        for (S1_my_services_problems.to_my_services_problems to : prob_list) {
            obj[i][0] = to.problem;
            i++;
        }
        if (prob_list.isEmpty()) {
            double am = FitIn.toDouble(jTextField5.getText());
            S1_my_services_problems.to_my_services_problems to = new S1_my_services_problems.to_my_services_problems(0, search, am);
            if (!search.isEmpty()) {
                S1_my_services_problems.add_my_services_problems(to);
                add_prob();
            }
        } else {
            JLabel[] labels = {};
            int[] tbl_widths_customers = {300};
            int width = 0;
            String[] col_names = {""};
            TableRenderer tr = new TableRenderer();
            TableRenderer.setPopup(jTextField4, obj, labels, tbl_widths_customers, col_names);
            tr.setCallback(new TableRenderer.Callback() {
                @Override
                public void ok(TableRenderer.OutputData data) {
                    S1_my_services_problems.to_my_services_problems to = prob_list.get(data.selected_row);
                    jTextField4.setText("" + to.problem);
                    jTextField5.grabFocus();
                    add_prob();
                }
            });
        }
    }
    private ArrayListModel tbl_my_services_problems_ALM;
    private Tblmy_services_problemsModel tbl_my_services_problems_M;
    int problem_size = 40;

    private void init_tbl_my_services_problems() {
        tbl_my_services_problems_ALM = new ArrayListModel();
        tbl_my_services_problems_M = new Tblmy_services_problemsModel(tbl_my_services_problems_ALM);
        tbl_my_services_problems.getTableHeader().setPreferredSize(new Dimension(100, 40));
        tbl_my_services_problems.setModel(tbl_my_services_problems_M);
        tbl_my_services_problems.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_my_services_problems.setRowHeight(25);
        int[] tbl_widths_my_services_problems = {100, 60, problem_size};
        for (int i = 0, n = tbl_widths_my_services_problems.length; i < n; i++) {
            if (i == 0) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_my_services_problems, i, tbl_widths_my_services_problems[i]);
        }
        Dimension d = tbl_my_services_problems.getTableHeader().getPreferredSize();
        d.height = 0;
        tbl_my_services_problems.getTableHeader().setPreferredSize(d);
        tbl_my_services_problems.getTableHeader().setFont(new java.awt.Font("Arial", 0, 11));
        tbl_my_services_problems.setRowHeight(25);
        tbl_my_services_problems.setFont(new java.awt.Font("Arial", 0, 11));
        TableWidthUtilities.setColumnRightRenderer(tbl_my_services_problems, 1);
    }

    private void loadData_my_services_problems(List<S1_my_services_problems.to_my_services_problems> acc) {
        tbl_my_services_problems_ALM.clear();
        tbl_my_services_problems_ALM.addAll(acc);
    }

    public static class Tblmy_services_problemsModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Problem", "Amount", "Action"
        };

        public Tblmy_services_problemsModel(ListModel listmodel) {
            super(listmodel, COLUMNS);
        }

        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }

        @Override
        public Class getColumnClass(int col) {
            if (col == 1000) {
                return Boolean.class;
            }
            return Object.class;
        }

        @Override
        public Object getValueAt(int row, int col) {
            S1_my_services_problems.to_my_services_problems tt = (S1_my_services_problems.to_my_services_problems) getRow(row);
            switch (col) {
                case 0:
                    return "  " + tt.problem;
                case 1:
                    return "  " + FitIn.fmt_wc_0(tt.amount) + " ";
                default:
                    return " Delete";
            }
        }
    }

    private void data_probs() {
        int row = tbl_my_services.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_my_services to = (to_my_services) tbl_my_services_ALM.get(tbl_my_services.convertRowIndexToModel(row));
        String where = " where transaction_no='" + to.transaction_no + "' order by problem asc";

//        List<S1_my_services_problems.to_my_services_problems> datas = My_services_problems_customers.ret_data(where);
//
//        loadData_my_services_problems(datas);
    }

    private void add_prob() {
        String prob = jTextField4.getText();
        double am = FitIn.toDouble(jTextField5.getText());
        if (jButton5.isEnabled()) {
            S1_my_services_problems.to_my_services_problems to = new S1_my_services_problems.to_my_services_problems(-1, prob, am);
            tbl_my_services_problems_ALM.add(to);
            tbl_my_services_problems_M.fireTableDataChanged();
            jTextField4.setText("");
            jTextField5.setText("");
        } else {
            int id = 0;
            String problem = prob;
            String customer_id = tf_customer_id.getText();
            String customer_name = tf_customer_name.getText();
            String transaction_no = tf_transaction_no.getText();
            String date_added = DateType.datetime.format(new Date());
            My_services_problems_customers.to_my_services_problems_customers to = new My_services_problems_customers.to_my_services_problems_customers(id, problem, customer_id, customer_name, transaction_no, date_added, am, my_branch, my_branch_id, my_location, my_location_id);

            My_services_problems_customers.add_my_services_problems_customers(to);
            data_probs();
            jTextField4.setText("");
            jTextField5.setText("");
        }
        compute_all();
    }

    private void edit_prob() {
        int row = tbl_my_services_problems.getSelectedRow();
        if (row < 0) {
            return;
        }
        String prob = jTextField4.getText();
        double am = FitIn.toDouble(jTextField5.getText());
        S1_my_services_problems.to_my_services_problems to = (S1_my_services_problems.to_my_services_problems) tbl_my_services_problems_ALM.get(tbl_my_services_problems.convertRowIndexToModel(row));
        if (jButton5.isEnabled()) {
            to.setAmount(am);
            to.setProblem(prob);
            tbl_my_services_problems_M.fireTableDataChanged();
            jTextField4.setText("");
            jTextField5.setText("");
            btn_edit2.setVisible(false);
        } else {
            int id = to.id;
            String problem = prob;
            String customer_id = tf_customer_id.getText();
            String customer_name = tf_customer_name.getText();
            String transaction_no = tf_transaction_no.getText();
            String date_added = DateType.datetime.format(new Date());
            My_services_problems_customers.to_my_services_problems_customers to2 = new My_services_problems_customers.to_my_services_problems_customers(id, problem, customer_id, customer_name, transaction_no, date_added, am, my_branch, my_branch_id, my_location, my_location_id);
            My_services_problems_customers.edit_my_services_problems_customers(to2);
            data_probs();
            jTextField4.setText("");
            jTextField5.setText("");
            btn_edit2.setVisible(false);
        }
        compute_all();
    }

    private void delete_prob() {
        int row = tbl_my_services_problems.getSelectedRow();
        if (row < 0) {
            return;
        }
        int col = tbl_my_services_problems.getSelectedColumn();
        if (col < 0) {
            return;
        }
        if (col == 2) {
            if (jButton5.isEnabled()) {
                tbl_my_services_problems_ALM.remove(row);
                tbl_my_services_problems_M.fireTableDataChanged();
            } else if (view_only == 0) {
                S1_my_services_problems.to_my_services_problems to = (S1_my_services_problems.to_my_services_problems) tbl_my_services_problems_ALM.get(tbl_my_services_problems.convertRowIndexToModel(row));
                My_services_problems_customers.delete_my_services_problems_customers("" + to.id);
                data_probs();
            }
        } else {
            S1_my_services_problems.to_my_services_problems to = (S1_my_services_problems.to_my_services_problems) tbl_my_services_problems_ALM.get(tbl_my_services_problems.convertRowIndexToModel(row));

            jTextField4.setText(to.problem);
            jTextField5.setText(FitIn.fmt_wc_0(to.amount));
            if (view_only == 0) {
                btn_edit2.setVisible(true);
            }

        }
        compute_all();
    }

    List<Inventory.to_inventory> inventory_list = new ArrayList();
    int item_selected = -1;

    private void init_inventory() {
        String search = tf_service_item_code.getText();
        String where = " where  barcode like '" + search + "' "
                + " or description like '%" + search + "%'"
                + " or main_barcode like '" + search + "'"
                + " group by main_barcode,barcode order by description asc";
        inventory_list.clear();
        inventory_list = Inventory.ret_data4(where);

        Object[][] obj = new Object[inventory_list.size()][2];
        int i = 0;
        for (Inventory.to_inventory to : inventory_list) {
            obj[i][0] = to.barcodes;
            obj[i][1] = to.description;
            i++;
        }

        JLabel[] labels = {};
        int w1 = tf_service_item_code.getWidth();
        int[] tbl_widths_customers = {40, 300};
        int width = 0;
        for (int w : tbl_widths_customers) {
            width += w;
        }
        String[] col_names = {"Code", "Description"};
        TableRenderer tr = new TableRenderer();
        TableRenderer.setPopup2(tf_service_item_code, obj, labels, tbl_widths_customers, col_names, width);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                Inventory.to_inventory to = inventory_list.get(data.selected_row);
                item_selected = data.selected_row;
                tf_service_item_code.setText(to.barcodes);
                tf_service_description.setText(to.description);
                tf_service_barcode.setText(to.barcode);
                tf_service_price.setText(FitIn.fmt_wc_0(to.selling_price));
                tf_service_qty.grabFocus();
            }
        });
    }

    private ArrayListModel tbl_my_services_item_replacements_ALM;
    private Tblmy_services_item_replacementsModel tbl_my_services_item_replacements_M;

    private void init_tbl_my_services_item_replacements() {
        tbl_my_services_item_replacements_ALM = new ArrayListModel();
        tbl_my_services_item_replacements_M = new Tblmy_services_item_replacementsModel(tbl_my_services_item_replacements_ALM);
        tbl_my_services_item_replacements.getTableHeader().setPreferredSize(new Dimension(100, 40));
        tbl_my_services_item_replacements.setModel(tbl_my_services_item_replacements_M);
        tbl_my_services_item_replacements.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_my_services_item_replacements.setRowHeight(25);
        int[] tbl_widths_my_services_item_replacements = {40, 100, 80, 40};
        for (int i = 0, n = tbl_widths_my_services_item_replacements.length; i < n; i++) {
            if (i == 1) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_my_services_item_replacements, i, tbl_widths_my_services_item_replacements[i]);
        }
        Dimension d = tbl_my_services_item_replacements.getTableHeader().getPreferredSize();
        d.height = 0;
        tbl_my_services_item_replacements.getTableHeader().setPreferredSize(d);
        tbl_my_services_item_replacements.getTableHeader().setFont(new java.awt.Font("Arial", 0, 11));
        tbl_my_services_item_replacements.setRowHeight(25);
        tbl_my_services_item_replacements.setFont(new java.awt.Font("Arial", 0, 11));
        TableWidthUtilities.setColumnRightRenderer(tbl_my_services_item_replacements, 2);
    }

    private void loadData_my_services_item_replacements(List<S1_my_services_item_replacements.to_my_services_item_replacements> acc) {
        tbl_my_services_item_replacements_ALM.clear();
        tbl_my_services_item_replacements_ALM.addAll(acc);
    }

    public static class Tblmy_services_item_replacementsModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Qty", "Description", "Price", "qty"
        };

        public Tblmy_services_item_replacementsModel(ListModel listmodel) {
            super(listmodel, COLUMNS);
        }

        @Override
        public boolean isCellEditable(int row, int column) {

            return false;
        }

        @Override
        public Class getColumnClass(int col) {
            if (col == 1000) {
                return Boolean.class;
            }
            return Object.class;
        }

        @Override
        public Object getValueAt(int row, int col) {
            S1_my_services_item_replacements.to_my_services_item_replacements tt = (S1_my_services_item_replacements.to_my_services_item_replacements) getRow(row);
            switch (col) {
                case 0:
                    return " " + FitIn.fmt_woc(tt.qty);
                case 1:
                    return " " + tt.description;
                case 2:
                    return " " + FitIn.fmt_wc_0(tt.price) + " ";
                default:
                    return " Delete";
            }
        }
    }

    private void data_cols_item_replacements() {
        int row = tbl_my_services.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_my_services to = (to_my_services) tbl_my_services_ALM.get(tbl_my_services.convertRowIndexToModel(row));
        String where = " where transaction_no='" + to.transaction_no + "' order by description asc";
        List<S1_my_services_item_replacements.to_my_services_item_replacements> datas = My_services_item_replacements_customers.ret_data2(My_services_item_replacements_customers.ret_data(where));
        loadData_my_services_item_replacements(datas);
    }

    private void add_replacement() {

        if (item_selected == -1) {
            return;
        }
        Inventory.to_inventory to = (Inventory.to_inventory) inventory_list.get(item_selected);

        if (jButton5.isEnabled()) {
            String barcode = tf_service_barcode.getText();
            String description = tf_service_description.getText();
            double qty = FitIn.toDouble(tf_service_qty.getText());
            double price = FitIn.toDouble(tf_service_price.getText());
            String item_code = tf_service_item_code.getText();
            String category = to.category;
            String category_id = to.category_id;
            String classification = to.classification;
            String classification_id = to.classification_id;
            String sub_classification = to.sub_classification;
            String sub_classification_id = to.sub_classification_id;
            String unit = to.unit;
            double conversion = to.conversion;
            String item_type = to.item_type;
            int status = to.status;
            String supplier = to.supplier;
            int fixed_price = to.fixed_price;
            String supplier_id = to.supplier_id;
            int multi_level_pricing = to.multi_level_pricing;
            int vatable = to.vatable;
            double reorder_level = to.reorder_level;
            double markup = to.markup;
            String brand = to.brand;
            String brand_id = to.brand_id;
            String model = to.model;
            String model_id = to.model_id;
            String selling_type = "" + to.selling_type;
            String branch = to.branch;
            String branch_code = to.branch_code;
            String location = to.location;
            String location_id = to.location_id;
            String serial_no = "";
            String user_id = MyUser.getUser_id();
            String user_screen_name = MyUser.getUser_screen_name();

            to_my_services_item_replacements to1 = new to_my_services_item_replacements(WIDTH, barcode, description, qty, price, item_code, category, category_id, classification, classification_id, sub_classification, sub_classification_id, unit, conversion, item_type, status, supplier, fixed_price, supplier_id, multi_level_pricing, vatable, reorder_level, markup, brand, brand_id, model, model_id, selling_type, branch, branch_code, location, location_id, serial_no, user_id, user_screen_name);

            tbl_my_services_item_replacements_ALM.add(to1);
            tbl_my_services_item_replacements_M.fireTableDataChanged();
        } else {
            int id = 0;
            String customer_id = tf_customer_id.getText();
            String customer_name = tf_customer_name.getText();
            String transaction_no = tf_transaction_no.getText();
            double selling_price = FitIn.toDouble(tf_service_price.getText());
            String date_added = DateType.datetime.format(new Date());
            String user_name = MyUser.user_name;

            String item_code = to.barcodes;
            String barcode = to.barcode;
            String description = to.description;
            double qty = FitIn.toDouble(tf_service_qty.getText());
            String category = to.category;
            String category_id = to.category_id;
            String classification = to.classification;
            String classification_id = to.classification_id;
            String sub_classification = to.sub_classification;
            String sub_classification_id = to.sub_classification_id;
            String unit = to.unit;
            double conversion = to.conversion;
            String item_type = to.item_type;
            int status = to.status;
            String supplier = to.supplier;
            int fixed_price = to.fixed_price;
            String supplier_id = to.supplier_id;
            int multi_level_pricing = to.multi_level_pricing;
            int vatable = to.vatable;
            double reorder_level = to.reorder_level;
            double markup = to.markup;
            String brand = to.brand;
            String brand_id = to.brand_id;
            String model = to.model;
            String model_id = to.model_id;
            String selling_type = "" + to.selling_type;
            String branch = to.branch;
            String branch_code = to.branch_code;
            String location = to.location;
            String location_id = to.location_id;
            String serial_no = "";
            String user_id = MyUser.getUser_id();
            String user_screen_name = MyUser.getUser_screen_name();

            My_services_item_replacements_customers.to_my_services_item_replacements_customers t1 = new My_services_item_replacements_customers.to_my_services_item_replacements_customers(id, transaction_no, customer_id, customer_name, item_code, barcode, description, qty, selling_price, date_added, user_name, category, category_id, classification, classification_id, sub_classification, sub_classification_id, unit, conversion, item_type, status, supplier, fixed_price, supplier_id, multi_level_pricing, vatable, reorder_level, markup, brand, brand_id, model, model_id, selling_type, branch, branch_code, location, location_id, serial_no, user_id, user_screen_name);
            List<My_services_item_replacements_customers.to_my_services_item_replacements_customers> d = new ArrayList();
            d.add(t1);
            My_services_item_replacements_customers.add_data(d);
            data_cols_item_replacements();
        }
        tf_service_barcode.setText("");
        tf_service_description.setText("");
        tf_service_qty.setText("");
        tf_service_price.setText("");
        tf_service_item_code.setText("");
        tf_service_item_code.grabFocus();
        compute_all();
    }

    private void delete_replacement() {

        int row = tbl_my_services_item_replacements.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_my_services_item_replacements to = (to_my_services_item_replacements) tbl_my_services_item_replacements_ALM.get(tbl_my_services_item_replacements.convertRowIndexToModel(row));
        int col = tbl_my_services_item_replacements.getSelectedColumn();
        if (col == 3) {

            if (jButton5.isEnabled()) {
                tbl_my_services_item_replacements_ALM.remove(row);
                tbl_my_services_item_replacements_M.fireTableDataChanged();
                tf_service_item_code.grabFocus();
            } else if (view_only == 0) {
                My_services_item_replacements_customers.delete_my_services_item_replacements_customers("" + to.id);
                data_cols_item_replacements();
            }
        } else {

        }
        compute_all();
    }
    int view_only = 0;

    public void do_view_only() {
        jButton2.setEnabled(false);
        jButton6.setEnabled(false);
        jButton8.setEnabled(false);
        jButton7.setEnabled(false);
        jTextField5.setEnabled(false);
        tf_service_item_code.setEnabled(false);
        tf_service_barcode.setEnabled(false);
        tf_service_qty.setEnabled(false);
        tf_service_description.setEnabled(false);
        tf_service_price.setEnabled(false);
        tf_service_description1.setEnabled(false);
        tf_service_qty1.setEnabled(false);
        tf_service_price1.setEnabled(false);
        jCheckBox1.setEnabled(false);
        jCheckBox2.setEnabled(false);
        jCheckBox10.setEnabled(false);
        jCheckBox16.setEnabled(false);
        view_only = 1;
        tf_service_item_code.setEnabled(false);
        tf_service_qty.setEnabled(false);
        description_size = 0;
        problem_size = 0;
        others_size = 0;
        init_tbl_my_services_description();
        init_tbl_my_services_problems();
        init_tbl_my_services_item_replacements();
        init_tbl_my_services_others();

    }
    int cashier_only = 0;

    public void do_cashier() {
        jButton2.setEnabled(false);
        jButton6.setEnabled(false);
        jButton8.setEnabled(false);
        jButton7.setEnabled(false);
        jButton1.setEnabled(false);
        jButton5.setEnabled(false);
        cashier_only = 1;
        jTextField1.setVisible(false);
        jLabel26.setVisible(false);
        jTextField2.setVisible(false);
        jLabel28.setVisible(false);
        jTextField3.setVisible(false);
        jLabel27.setVisible(false);

        jTextField4.setVisible(false);
        jLabel29.setVisible(false);
        jTextField5.setVisible(false);
        jLabel30.setVisible(false);

        description_size = 0;
        problem_size = 0;
        init_tbl_my_services_description();
        init_tbl_my_services_problems();
        init_tbl_my_services_item_replacements();
    }

    private void compute_all() {
        double total = 0;
        List<to_my_services_description> desc = tbl_my_services_description_ALM;
        List<S1_my_services_problems.to_my_services_problems> probs = tbl_my_services_problems_ALM;
        List<to_my_services_item_replacements> reps = tbl_my_services_item_replacements_ALM;
        List<S1_my_services_others.to_my_services_others> others = tbl_my_services_others_ALM;
        for (S1_my_services_problems.to_my_services_problems to : probs) {
            total += to.amount;
        }
        for (to_my_services_item_replacements to : reps) {
            total += to.price * to.qty;
        }
        for (S1_my_services_others.to_my_services_others to : others) {
            total += to.amount * to.qty;
        }
        tf_amount.setText(FitIn.fmt_wc_0(total));
    }

    private ArrayListModel tbl_my_services_others_ALM;
    private Tblmy_services_othersModel tbl_my_services_others_M;
    int others_size = 40;

    private void init_tbl_my_services_others() {
        tbl_my_services_others_ALM = new ArrayListModel();
        tbl_my_services_others_M = new Tblmy_services_othersModel(tbl_my_services_others_ALM);
        tbl_my_services_others.getTableHeader().setPreferredSize(new Dimension(100, 40));
        tbl_my_services_others.setModel(tbl_my_services_others_M);
        tbl_my_services_others.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_my_services_others.setRowHeight(25);
        int[] tbl_widths_my_services_others = {50, 100, 70, others_size};
        for (int i = 0, n = tbl_widths_my_services_others.length; i < n; i++) {
            if (i == 1) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_my_services_others, i, tbl_widths_my_services_others[i]);
        }

        Dimension d = tbl_my_services_others.getTableHeader().getPreferredSize();
        d.height = 0;
        tbl_my_services_others.getTableHeader().setPreferredSize(d);
        tbl_my_services_others.getTableHeader().setFont(new java.awt.Font("Arial", 0, 11));
        tbl_my_services_others.setRowHeight(25);
        tbl_my_services_others.setFont(new java.awt.Font("Arial", 0, 11));
        TableWidthUtilities.setColumnRightRenderer(tbl_my_services_others, 2);
    }

    private void loadData_my_services_others(List<to_my_services_others> acc) {
        tbl_my_services_others_ALM.clear();
        tbl_my_services_others_ALM.addAll(acc);
    }

    public static class Tblmy_services_othersModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Qty", "Description", "Amount", "Action"
        };

        public Tblmy_services_othersModel(ListModel listmodel) {
            super(listmodel, COLUMNS);
        }

        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }

        @Override
        public Class getColumnClass(int col) {
            if (col == 1000) {
                return Boolean.class;
            }
            return Object.class;
        }

        @Override
        public Object getValueAt(int row, int col) {
            to_my_services_others tt = (to_my_services_others) getRow(row);
            switch (col) {
                case 0:
                    return " " + FitIn.fmt_woc(tt.qty);
                case 1:
                    return " " + tt.name;
                case 2:
                    return FitIn.fmt_wc_0(tt.amount) + " ";
                default:
                    return " Delete";
            }
        }
    }

    private void data_cols_others() {
        int row = tbl_my_services.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_my_services to = (to_my_services) tbl_my_services_ALM.get(tbl_my_services.convertRowIndexToModel(row));
        String where = " where transaction_no='" + to.transaction_no + "' ";
        loadData_my_services_others(My_services_others_customers.ret_data(where));
    }

    List<S1_my_services_others.to_my_services_others> others_list = new ArrayList();

    private void init_others() {
        String search = tf_service_description1.getText();
        others_list.clear();
        String where = " where name like '%" + search + "%' order by name asc ";
        others_list = S1_my_services_others.ret_data(where);
        Object[][] obj = new Object[others_list.size()][1];
        int i = 0;
        for (S1_my_services_others.to_my_services_others to : others_list) {
            obj[i][0] = to.name;
            i++;
        }
        if (others_list.isEmpty()) {
            double am = FitIn.toDouble(jTextField5.getText());
            S1_my_services_others.to_my_services_others to = new S1_my_services_others.to_my_services_others(0, search, am, 0);
            if (!search.isEmpty()) {
                S1_my_services_others.add_my_services_others(to);
                tf_service_qty1.grabFocus();
            }
        } else {
            JLabel[] labels = {};
            int[] tbl_widths_customers = {300};
            int width = 0;
            String[] col_names = {""};
            TableRenderer tr = new TableRenderer();
            TableRenderer.setPopup(tf_service_description1, obj, labels, tbl_widths_customers, col_names);
            tr.setCallback(new TableRenderer.Callback() {
                @Override
                public void ok(TableRenderer.OutputData data) {
                    S1_my_services_others.to_my_services_others to = others_list.get(data.selected_row);
                    tf_service_description1.setText("" + to.name);
                    tf_service_qty1.grabFocus();
                }
            });
        }
    }

    private void add_others() {
        if (jButton5.isEnabled()) {
            double amount = FitIn.toDouble(tf_service_price1.getText());
            double qty = FitIn.toDouble(tf_service_qty1.getText());
            String description = tf_service_description1.getText();
            S1_my_services_others.to_my_services_others to = new S1_my_services_others.to_my_services_others(0, description, amount, qty);
            tbl_my_services_others_ALM.add(to);
            tbl_my_services_others_M.fireTableDataChanged();
            tf_service_description1.setText("");
            tf_service_qty1.setText("");
            tf_service_price1.setText("");
            tf_service_description1.grabFocus();
        } else {

            int id = -1;
            String customer_id = tf_customer_id.getText();
            String customer_name = tf_customer_name.getText();
            String transaction_no = tf_transaction_no.getText();
            String date_added = DateType.datetime.format(new Date());
            String name = tf_service_description1.getText();
            double amount = FitIn.toDouble(tf_service_price1.getText());
            double qty = FitIn.toDouble(tf_service_qty1.getText());
            My_services_others_customers.to_my_services_others_customers to = new My_services_others_customers.to_my_services_others_customers(id, customer_id, customer_name, transaction_no, date_added, name, amount, qty, my_branch, my_branch_id, my_location, my_location_id);
            My_services_others_customers.add_my_services_others_customers(to);
            data_cols_others();
            tf_service_description1.setText("");
            tf_service_qty1.setText("");
            tf_service_price1.setText("");
            tf_service_description1.grabFocus();
        }
        compute_all();
    }

    private void delete_others() {
        int row = tbl_my_services_others.getSelectedRow();
        if (row < 0) {
            return;
        }
        int col = tbl_my_services_others.getSelectedColumn();
        to_my_services_others to = (to_my_services_others) tbl_my_services_others_ALM.get(tbl_my_services_others.convertRowIndexToModel(row));
        if (jButton5.isEnabled()) {
            if (col == 3) {
                tbl_my_services_others_ALM.remove(row);
                tbl_my_services_others_M.fireTableDataChanged();
                tf_service_description1.setText("");
                tf_service_qty1.setText("");
                tf_service_price1.setText("");
                tf_service_description1.grabFocus();
            } else {
                tf_service_description1.setText(to.name);
                tf_service_qty1.setText(FitIn.fmt_woc(to.qty));
                tf_service_price1.setText(FitIn.fmt_wc_0(to.amount));
                btn_edit3.setVisible(true);
            }
        } else if (col == 3) {
            if (view_only == 0) {
                My_services_others_customers.delete_my_services_others_customers("" + to.id);
                data_cols_others();
                tf_service_description1.setText("");
                tf_service_qty1.setText("");
                tf_service_price1.setText("");
                tf_service_description1.grabFocus();
            }

        } else {
            tf_service_description1.setText(to.name);
            tf_service_qty1.setText(FitIn.fmt_woc(to.qty));
            tf_service_price1.setText(FitIn.fmt_wc_0(to.amount));
            if (view_only == 0) {
                btn_edit3.setVisible(true);
            }
        }
        compute_all();
    }

    private void edit_others() {
        int row = tbl_my_services_others.getSelectedRow();
        if (row < 0) {
            return;
        }
        int col = tbl_my_services_others.getSelectedColumn();
        to_my_services_others to = (to_my_services_others) tbl_my_services_others_ALM.get(tbl_my_services_others.convertRowIndexToModel(row));
        if (jButton5.isEnabled()) {
            String name = tf_service_description1.getText();
            double amount = FitIn.toDouble(tf_service_price1.getText());
            double qty = FitIn.toDouble(tf_service_qty1.getText());
            to.setAmount(amount);
            to.setName(name);
            to.setQty(qty);
            tbl_my_services_others_M.fireTableDataChanged();
            tf_service_description1.setText("");
            tf_service_qty1.setText("");
            tf_service_price1.setText("");
            tf_service_description1.grabFocus();
            btn_edit3.setVisible(false);
        } else {

            int id = to.id;
            String customer_id = tf_customer_id.getText();
            String customer_name = tf_customer_name.getText();
            String transaction_no = tf_transaction_no.getText();
            String date_added = DateType.datetime.format(new Date());
            String name = tf_service_description1.getText();
            double amount = FitIn.toDouble(tf_service_price1.getText());
            double qty = FitIn.toDouble(tf_service_qty1.getText());
            My_services_others_customers.to_my_services_others_customers to1 = new My_services_others_customers.to_my_services_others_customers(id, customer_id, customer_name, transaction_no, date_added, name, amount, qty, my_branch, my_branch_id, my_location, my_location_id);
            My_services_others_customers.edit_my_services_others_customers(to1);

            tf_service_description1.setText("");
            tf_service_qty1.setText("");
            tf_service_price1.setText("");
            tf_service_description1.grabFocus();
            data_cols_others();
            btn_edit3.setVisible(false);

        }
        compute_all();
    }

    private void popup(MouseEvent evt) {
        if (evt.isPopupTrigger()) {
            jPopupMenu1.show(tbl_my_services, evt.getX(), evt.getY());
        }
    }

    private void transfer_job() {
        List<to_my_services> datas = tbl_my_services_ALM;
        final List<to_my_services> selected = new ArrayList();
        for (to_my_services to : datas) {
            if (to.selected == true) {
                selected.add(to);
            }
        }

        Window p = (Window) this;
        Dlg_my_service_transfer_job_to nd = Dlg_my_service_transfer_job_to.create(p, true);
        nd.setTitle("");
        nd.do_pass(selected);
        nd.setCallback(new Dlg_my_service_transfer_job_to.Callback() {
            @Override
            public void ok(CloseDialog closeDialog, Dlg_my_service_transfer_job_to.OutputData data) {
                closeDialog.ok();
                My_services.transfer_job(selected, data.service_by, data.service_by_id, data.manager, data.manager_id, data.department, data.department_id);
                data_cols();
                Alert.set(2, "");
            }
        });

        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }

    List<My_services_crews.to_my_services_crews> service_by_list = new ArrayList();

    private void init_service_by() {
        String search = tf_department2.getText();
        service_by_list.clear();
        String where = " where "
                + " lname like '%" + search + "%' and location_id='" + my_location_id + "' "
                + " or fname like '%" + search + "%'  and location_id='" + my_location_id + "' "
                + " order by lname asc";
        if (!jCheckBox11.isSelected()) {
            where = " where "
                    + " lname like '%" + search + "%' and department_id='" + tf_department_id1.getText() + "' and location_id='" + my_location_id + "' "
                    + " or fname like '%" + search + "%' and department_id='" + tf_department_id1.getText() + "' and location_id='" + my_location_id + "' "
                    + " order by lname asc";
        }

        service_by_list = My_services_crews.ret_data(where);
        Object[][] obj = new Object[service_by_list.size()][1];
        int i = 0;
        for (My_services_crews.to_my_services_crews to : service_by_list) {
            obj[i][0] = to.fname + " " + to.mi + " " + to.lname;
            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {300};
        int width = 0;
        String[] col_names = {""};
        TableRenderer tr = new TableRenderer();
        TableRenderer.setPopup(tf_department2, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                My_services_crews.to_my_services_crews to = service_by_list.get(data.selected_row);
                tf_department2.setText("" + to.fname + " " + to.mi + " " + to.lname);
                tf_department_id2.setText("" + to.id);
                data_cols();
            }
        });
    }

    private void print_barcode() {
        int row = tbl_my_services.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_my_services to = (to_my_services) tbl_my_services_ALM.get(tbl_my_services.convertRowIndexToModel(row));
        Window p = (Window) this;
        Dlg_my_services_print_barcodes nd = Dlg_my_services_print_barcodes.create(p, true);
        nd.setTitle("");
//        nd.do_pass(to.transaction_no);
        nd.setCallback(new Dlg_my_services_print_barcodes.Callback() {
            @Override
            public void ok(CloseDialog closeDialog, Dlg_my_services_print_barcodes.OutputData data) {
                closeDialog.ok();
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }

}
