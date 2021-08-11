/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicing.my_services;

import servicing.reports.Dlg_my_services_print_barcodes;
import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.FitIn;
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;
import mijzcx.synapse.desk.utils.TableWidthUtilities;
import servicing.branch_locations.Branch_locations;
import servicing.inventory.Inventory;
import servicing.my_services.My_services_barcodes_customers.to_my_services_barcodes_customers;
import servicing.my_services.My_services_description_customers.to_my_services_description_customers;
import servicing.my_services.S1_my_services_description.to_my_services_description;
import servicing.my_services.My_services_problems_customers.to_my_services_problems_customers;
import servicing.my_services.My_services_item_replacements_customers.to_my_services_item_replacements_customers;
import servicing.my_services.My_services_others_customers.to_my_services_others_customers;
import servicing.users.MyUser;
import servicing.utils.Alert;
import servicing.utils.DateType;
import servicing.utils.DateUtils1;
import servicing.utils.Dlg_confirm_action;
import servicing.utils.TableRenderer;
import synsoftech.fields.Button;
import synsoftech.fields.Field;
import synsoftech.util.ImageRenderer1;

/**
 *
 * @author Guinness
 */
public class Dlg_services extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_services
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
    private Dlg_services(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_services(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_services() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_services myRef;

    private void setThisRef(Dlg_services myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_services> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_services create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_services create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_services dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_services((java.awt.Frame) parent, false);
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
            Dlg_services dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_services((java.awt.Dialog) parent, false);
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

        Dlg_services dialog = Dlg_services.create(new javax.swing.JFrame(), true);
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
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_my_services_description_customers = new javax.swing.JTable();
        jLabel48 = new javax.swing.JLabel();
        tf_description_description = new Field.Combo();
        jLabel51 = new javax.swing.JLabel();
        tf_contact_no2 = new Field.Input();
        jLabel52 = new javax.swing.JLabel();
        tf_contact_no3 = new Field.Input();
        tf_contact_no4 = new Field.Input();
        jLabel53 = new javax.swing.JLabel();
        jButton11 = new Button.Default();
        jButton12 = new Button.Success();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbl_my_services_problems_customers = new javax.swing.JTable();
        jButton13 = new Button.Default();
        jButton14 = new Button.Success();
        jLabel54 = new javax.swing.JLabel();
        tf_contact_no5 = new Field.Input();
        tf_contact_no6 = new Field.Combo();
        jLabel55 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel56 = new javax.swing.JLabel();
        tf_contact_no7 = new Field.Input();
        tf_contact_no8 = new Field.Input();
        jLabel57 = new javax.swing.JLabel();
        jButton15 = new Button.Default();
        jButton16 = new Button.Success();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbl_my_services_item_replacements_customers = new javax.swing.JTable();
        tf_contact_no9 = new Field.Input();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        tf_contact_no10 = new Field.Input();
        jLabel60 = new javax.swing.JLabel();
        tf_contact_no11 = new Field.Input();
        jLabel8 = new javax.swing.JLabel();
        tf_to_branch = new Field.Combo();
        jLabel17 = new javax.swing.JLabel();
        tf_to_location = new Field.Combo();
        jPanel9 = new javax.swing.JPanel();
        jLabel61 = new javax.swing.JLabel();
        tf_contact_no12 = new Field.Input();
        jLabel62 = new javax.swing.JLabel();
        tf_contact_no13 = new Field.Input();
        tf_contact_no14 = new Field.Input();
        jLabel63 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tbl_my_services_others_customers = new javax.swing.JTable();
        jButton17 = new Button.Default();
        jButton18 = new Button.Success();
        jPanel10 = new javax.swing.JPanel();
        jLabel64 = new javax.swing.JLabel();
        tf_contact_no15 = new Field.Input();
        jButton20 = new Button.Success();
        jScrollPane7 = new javax.swing.JScrollPane();
        tbl_my_services_barcodes_customers = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        tf_transaction_no = new Field.Input();
        jLabel5 = new javax.swing.JLabel();
        tf_service_slip_no = new Field.Input();
        tf_serviced_by = new Field.Combo();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tf_customer_name = new Field.Combo();
        jLabel47 = new javax.swing.JLabel();
        tf_contact_no = new Field.Input();
        jTextField6 = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tf_remarks = new javax.swing.JTextArea();
        jLabel11 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        dp_received = new com.toedter.calendar.JDateChooser();
        jLabel14 = new javax.swing.JLabel();
        tf_amount = new javax.swing.JTextField();
        dp_released = new com.toedter.calendar.JDateChooser();
        jLabel42 = new javax.swing.JLabel();
        dp_assigned = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        tf_service_type1 = new Field.Combo();
        jLabel12 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox10 = new javax.swing.JCheckBox();
        jCheckBox16 = new javax.swing.JCheckBox();
        jButton5 = new Button.Success();
        jButton9 = new Button.Default();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        dp_to = new com.toedter.calendar.JDateChooser();
        jLabel37 = new javax.swing.JLabel();
        dp_from = new com.toedter.calendar.JDateChooser();
        jCheckBox17 = new javax.swing.JCheckBox();
        jLabel36 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jCheckBox5 = new javax.swing.JCheckBox();
        jCheckBox13 = new javax.swing.JCheckBox();
        jCheckBox14 = new javax.swing.JCheckBox();
        cb_barcode = new javax.swing.JCheckBox();
        jLabel16 = new javax.swing.JLabel();
        jCheckBox6 = new javax.swing.JCheckBox();
        jCheckBox7 = new javax.swing.JCheckBox();
        jCheckBox8 = new javax.swing.JCheckBox();
        jCheckBox9 = new javax.swing.JCheckBox();
        jCheckBox15 = new javax.swing.JCheckBox();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jCheckBox12 = new javax.swing.JCheckBox();
        jCheckBox11 = new javax.swing.JCheckBox();
        tf_department1 = new Field.Combo();
        tf_service_type = new Field.Combo();
        tf_department_id1 = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        jCheckBox18 = new javax.swing.JCheckBox();
        tf_service_by = new Field.Combo();
        tf_department_id2 = new javax.swing.JTextField();
        tf_service_type_id = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_my_services = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel3 = new javax.swing.JLabel();
        jTextField12 = new Field.Search();
        jButton1 = new Button.Default();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        tbl_my_services_description_customers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_my_services_description_customers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_my_services_description_customersMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_my_services_description_customers);

        jLabel48.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel48.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel48.setText("Description:");

        tf_description_description.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_description_description.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_description_descriptionActionPerformed(evt);
            }
        });

        jLabel51.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel51.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel51.setText("Barcode:");

        tf_contact_no2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_contact_no2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_contact_no2ActionPerformed(evt);
            }
        });

        jLabel52.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel52.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel52.setText("Qty:");

        tf_contact_no3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_contact_no3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_contact_no3ActionPerformed(evt);
            }
        });

        tf_contact_no4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_contact_no4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_contact_no4ActionPerformed(evt);
            }
        });

        jLabel53.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel53.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel53.setText("Unit:");

        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/servicing/icons/new-file.png"))); // NOI18N
        jButton11.setToolTipText("New");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/servicing/icons/icon.png"))); // NOI18N
        jButton12.setToolTipText("Save");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel52, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel48, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel51, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_contact_no2)
                            .addComponent(tf_description_description)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(tf_contact_no3, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel53)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addGap(0, 52, Short.MAX_VALUE)
                                        .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(tf_contact_no4))))))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_description_description, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_contact_no2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_contact_no3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_contact_no4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab(" Description", jPanel6);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        tbl_my_services_problems_customers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_my_services_problems_customers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_my_services_problems_customersMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tbl_my_services_problems_customers);

        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/servicing/icons/new-file.png"))); // NOI18N
        jButton13.setToolTipText("New");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/servicing/icons/icon.png"))); // NOI18N
        jButton14.setToolTipText("Save");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jLabel54.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel54.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel54.setText("Amount:");

        tf_contact_no5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_contact_no5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_contact_no5ActionPerformed(evt);
            }
        });

        tf_contact_no6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_contact_no6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_contact_no6ActionPerformed(evt);
            }
        });

        jLabel55.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel55.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel55.setText("Problem:");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel55, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel54, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_contact_no5)
                            .addComponent(tf_contact_no6)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(148, 200, Short.MAX_VALUE)
                                .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_contact_no6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_contact_no5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab(" Problem", jPanel7);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        jLabel56.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel56.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel56.setText("Item Code:");

        tf_contact_no7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_contact_no7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_contact_no7ActionPerformed(evt);
            }
        });

        tf_contact_no8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_contact_no8.setFocusable(false);
        tf_contact_no8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_contact_no8ActionPerformed(evt);
            }
        });

        jLabel57.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel57.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel57.setText("Description:");

        jButton15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/servicing/icons/new-file.png"))); // NOI18N
        jButton15.setToolTipText("New");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jButton16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/servicing/icons/icon.png"))); // NOI18N
        jButton16.setToolTipText("Save");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        tbl_my_services_item_replacements_customers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_my_services_item_replacements_customers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_my_services_item_replacements_customersMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tbl_my_services_item_replacements_customers);

        tf_contact_no9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_contact_no9.setFocusable(false);
        tf_contact_no9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_contact_no9ActionPerformed(evt);
            }
        });

        jLabel58.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel58.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel58.setText("Barcode:");

        jLabel59.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel59.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel59.setText("Qty:");

        tf_contact_no10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_contact_no10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_contact_no10ActionPerformed(evt);
            }
        });

        jLabel60.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel60.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel60.setText("Selling Price:");

        tf_contact_no11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_contact_no11.setFocusable(false);
        tf_contact_no11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_contact_no11ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("Branch:");

        tf_to_branch.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_to_branch.setFocusable(false);
        tf_to_branch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_to_branchMouseClicked(evt);
            }
        });
        tf_to_branch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_to_branchActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel17.setText("Location:");

        tf_to_location.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_to_location.setFocusable(false);
        tf_to_location.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_to_locationMouseClicked(evt);
            }
        });
        tf_to_location.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_to_locationActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel59, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel56, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel57, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(tf_contact_no10, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel60)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tf_contact_no11))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(tf_contact_no8)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(tf_contact_no7)
                                .addGap(5, 5, 5)
                                .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tf_contact_no9))))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_to_location)
                            .addComponent(tf_to_branch))))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_to_branch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_to_location, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_contact_no7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_contact_no9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_contact_no8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_contact_no10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_contact_no11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab(" Replacement", jPanel8);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        jLabel61.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel61.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel61.setText("Qty:");

        tf_contact_no12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_contact_no12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_contact_no12ActionPerformed(evt);
            }
        });

        jLabel62.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel62.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel62.setText("Amount:");

        tf_contact_no13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_contact_no13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_contact_no13ActionPerformed(evt);
            }
        });

        tf_contact_no14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_contact_no14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_contact_no14ActionPerformed(evt);
            }
        });

        jLabel63.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel63.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel63.setText("Description:");

        tbl_my_services_others_customers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_my_services_others_customers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_my_services_others_customersMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tbl_my_services_others_customers);

        jButton17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/servicing/icons/new-file.png"))); // NOI18N
        jButton17.setToolTipText("New");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        jButton18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/servicing/icons/icon.png"))); // NOI18N
        jButton18.setToolTipText("Save");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel61, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel63))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(tf_contact_no13)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(tf_contact_no12)
                                .addGap(5, 5, 5)
                                .addComponent(jLabel62, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tf_contact_no14)))))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_contact_no13, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel61, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_contact_no12, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel62, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_contact_no14, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab(" Others", jPanel9);

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));

        jLabel64.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel64.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel64.setText("Barcode:");

        tf_contact_no15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_contact_no15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_contact_no15ActionPerformed(evt);
            }
        });

        jButton20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/servicing/icons/icon.png"))); // NOI18N
        jButton20.setToolTipText("Save");
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });

        tbl_my_services_barcodes_customers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_my_services_barcodes_customers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_my_services_barcodes_customersMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tbl_my_services_barcodes_customers);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel64)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_contact_no15))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton20, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tf_contact_no15, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                    .addComponent(jLabel64, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton20, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Barcodes", jPanel10);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Transaction No:");

        tf_transaction_no.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_transaction_no.setFocusable(false);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Service Slip No:");

        tf_service_slip_no.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_service_slip_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_service_slip_noActionPerformed(evt);
            }
        });

        tf_serviced_by.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_serviced_by.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_serviced_byActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Service by:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Customer:");

        tf_customer_name.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_customer_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_customer_nameActionPerformed(evt);
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

        jTextField6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField6.setText("+");
        jTextField6.setFocusable(false);
        jTextField6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField6MouseClicked(evt);
            }
        });
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });

        jScrollPane3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane3.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        tf_remarks.setColumns(20);
        tf_remarks.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_remarks.setLineWrap(true);
        tf_remarks.setRows(5);
        jScrollPane3.setViewportView(tf_remarks);

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel11.setText("Remarks:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("Date Received:");

        dp_received.setDate(new Date());
        dp_received.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel14.setText("Total Due:");

        tf_amount.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_amount.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tf_amount.setText("0.00");
        tf_amount.setFocusable(false);

        dp_released.setDate(new Date());
        dp_released.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel42.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel42.setText("Released:");

        dp_assigned.setDate(new Date());
        dp_assigned.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("Date Assigned:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel13.setText("Trans Type:");

        tf_service_type1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_service_type1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_service_type1ActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel12.setText("Status:");

        buttonGroup3.add(jCheckBox1);
        jCheckBox1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jCheckBox1.setSelected(true);
        jCheckBox1.setText("OnGoing");
        jCheckBox1.setOpaque(false);

        buttonGroup3.add(jCheckBox2);
        jCheckBox2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jCheckBox2.setText("Finished");
        jCheckBox2.setOpaque(false);

        buttonGroup3.add(jCheckBox10);
        jCheckBox10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jCheckBox10.setText("Released");
        jCheckBox10.setOpaque(false);

        buttonGroup3.add(jCheckBox16);
        jCheckBox16.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jCheckBox16.setText("OnHold");
        jCheckBox16.setOpaque(false);

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/servicing/icons/icon.png"))); // NOI18N
        jButton5.setText("Save");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/servicing/icons/new-file.png"))); // NOI18N
        jButton9.setText("New");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(tf_service_type1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(dp_assigned, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                                .addComponent(jLabel47, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(dp_received, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel42)
                                .addGap(2, 2, 2)
                                .addComponent(dp_released, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(tf_customer_name)
                                .addGap(1, 1, 1)
                                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(tf_serviced_by)
                            .addComponent(tf_contact_no)
                            .addComponent(tf_service_slip_no, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tf_transaction_no)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_amount)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_transaction_no, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_service_slip_no, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_serviced_by, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_customer_name, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_contact_no, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE))
                .addGap(1, 1, 1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dp_received, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dp_released, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dp_assigned, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_service_type1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox16, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                    .addComponent(tf_amount))
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(25, 25, 25))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        dp_to.setDate(new Date());
        dp_to.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel37.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel37.setText("To:");

        dp_from.setDate(new Date());
        dp_from.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jCheckBox17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox17.setSelected(true);
        jCheckBox17.setText("All");
        jCheckBox17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox17ActionPerformed(evt);
            }
        });

        jLabel36.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel36.setText("Date From:");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel15.setText("Search by:");

        buttonGroup1.add(jCheckBox3);
        jCheckBox3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox3.setSelected(true);
        jCheckBox3.setText("Name");
        jCheckBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox3ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jCheckBox4);
        jCheckBox4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox4.setText("Description");
        jCheckBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox4ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jCheckBox5);
        jCheckBox5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox5.setText("Problem");
        jCheckBox5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox5ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jCheckBox13);
        jCheckBox13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox13.setText("Transaction #");
        jCheckBox13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox13ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jCheckBox14);
        jCheckBox14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox14.setText("Service Slip #");
        jCheckBox14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox14ActionPerformed(evt);
            }
        });

        buttonGroup1.add(cb_barcode);
        cb_barcode.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cb_barcode.setText("Barcode");
        cb_barcode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_barcodeActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel16.setText("Status:");

        buttonGroup2.add(jCheckBox6);
        jCheckBox6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox6.setSelected(true);
        jCheckBox6.setText("All");
        jCheckBox6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox6ActionPerformed(evt);
            }
        });

        buttonGroup2.add(jCheckBox7);
        jCheckBox7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox7.setText("On Going");
        jCheckBox7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox7ActionPerformed(evt);
            }
        });

        buttonGroup2.add(jCheckBox8);
        jCheckBox8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox8.setText("Finished");
        jCheckBox8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox8ActionPerformed(evt);
            }
        });

        buttonGroup2.add(jCheckBox9);
        jCheckBox9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox9.setText("Released");
        jCheckBox9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox9ActionPerformed(evt);
            }
        });

        buttonGroup2.add(jCheckBox15);
        jCheckBox15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox15.setText("On Hold");
        jCheckBox15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox15ActionPerformed(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel24.setText("Department:");

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel25.setText("Type:");

        jCheckBox12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox12.setSelected(true);
        jCheckBox12.setText("All");
        jCheckBox12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox12ActionPerformed(evt);
            }
        });

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

        tf_service_type.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_service_type.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_service_typeActionPerformed(evt);
            }
        });

        tf_department_id1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_department_id1.setFocusable(false);

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

        tf_service_by.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_service_by.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_service_byActionPerformed(evt);
            }
        });

        tf_department_id2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_department_id2.setFocusable(false);

        tf_service_type_id.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_service_type_id.setFocusable(false);
        tf_service_type_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_service_type_idActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel36, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jCheckBox17, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dp_from, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel37)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dp_to, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jCheckBox3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCheckBox5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCheckBox13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCheckBox14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cb_barcode, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jCheckBox11, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tf_department1)
                                .addGap(0, 0, 0)
                                .addComponent(tf_department_id1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(jLabel44)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox18, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tf_service_by))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jCheckBox6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCheckBox7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCheckBox8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCheckBox9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCheckBox15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel25)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tf_service_type)))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_service_type_id, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_department_id2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(15, 15, 15))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dp_to, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dp_from, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox17, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jCheckBox3)
                        .addComponent(jCheckBox4)
                        .addComponent(jCheckBox5)
                        .addComponent(jCheckBox13)
                        .addComponent(jCheckBox14)
                        .addComponent(cb_barcode))
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCheckBox7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox15, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_service_type, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox12, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_service_type_id, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tf_department1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jCheckBox11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tf_department_id1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jCheckBox18, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tf_service_by, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tf_department_id2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

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
        tbl_my_services.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_my_servicesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_my_services);

        jLabel1.setText("No. of rows:");

        jLabel2.setText("0");

        jProgressBar1.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        jProgressBar1.setString("");
        jProgressBar1.setStringPainted(true);

        jLabel3.setText("Status:");

        jTextField12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField12ActionPerformed(evt);
            }
        });

        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jTextField12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 439, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2)
                        .addComponent(jLabel3))
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void jTextField12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField12ActionPerformed
        data_cols();
    }//GEN-LAST:event_jTextField12ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed

        clear_my_services();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jCheckBox17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox17ActionPerformed
        data_cols();
    }//GEN-LAST:event_jCheckBox17ActionPerformed

    private void jCheckBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox3ActionPerformed
        data_cols();
    }//GEN-LAST:event_jCheckBox3ActionPerformed

    private void jCheckBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox4ActionPerformed
        data_cols();
    }//GEN-LAST:event_jCheckBox4ActionPerformed

    private void jCheckBox5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox5ActionPerformed
        data_cols();
    }//GEN-LAST:event_jCheckBox5ActionPerformed

    private void jCheckBox13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox13ActionPerformed
        data_cols();
    }//GEN-LAST:event_jCheckBox13ActionPerformed

    private void jCheckBox14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox14ActionPerformed
        data_cols();
    }//GEN-LAST:event_jCheckBox14ActionPerformed

    private void cb_barcodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_barcodeActionPerformed
        data_cols();
    }//GEN-LAST:event_cb_barcodeActionPerformed

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

    private void jCheckBox15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox15ActionPerformed
        data_cols();
    }//GEN-LAST:event_jCheckBox15ActionPerformed

    private void jCheckBox12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox12ActionPerformed
        data_cols();
    }//GEN-LAST:event_jCheckBox12ActionPerformed

    private void jCheckBox11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox11ActionPerformed
        data_cols();
    }//GEN-LAST:event_jCheckBox11ActionPerformed

    private void tf_department1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_department1ActionPerformed
        init_departments();
    }//GEN-LAST:event_tf_department1ActionPerformed

    private void tf_service_typeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_service_typeActionPerformed
        init_type2();
    }//GEN-LAST:event_tf_service_typeActionPerformed

    private void jCheckBox18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox18ActionPerformed
        data_cols();
    }//GEN-LAST:event_jCheckBox18ActionPerformed

    private void tf_service_byActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_service_byActionPerformed
        init_service_by();
    }//GEN-LAST:event_tf_service_byActionPerformed

    private void tf_service_type_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_service_type_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_service_type_idActionPerformed

    private void tf_service_slip_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_service_slip_noActionPerformed
        tf_serviced_by.grabFocus();
    }//GEN-LAST:event_tf_service_slip_noActionPerformed

    private void tf_serviced_byActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_serviced_byActionPerformed
        init_manager();
    }//GEN-LAST:event_tf_serviced_byActionPerformed

    private void tf_customer_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_customer_nameActionPerformed
        init_customer();
    }//GEN-LAST:event_tf_customer_nameActionPerformed

    private void tf_contact_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_contact_noActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_contact_noActionPerformed

    private void jTextField6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField6MouseClicked
        customers();
    }//GEN-LAST:event_jTextField6MouseClicked

    private void tf_service_type1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_service_type1ActionPerformed
        init_type();
    }//GEN-LAST:event_tf_service_type1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        save_my_services();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void tf_description_descriptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_description_descriptionActionPerformed
        init_description_description();
    }//GEN-LAST:event_tf_description_descriptionActionPerformed

    private void tf_contact_no2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_contact_no2ActionPerformed
        tf_contact_no3.grabFocus();
    }//GEN-LAST:event_tf_contact_no2ActionPerformed

    private void tf_contact_no3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_contact_no3ActionPerformed
        tf_contact_no4.grabFocus();
    }//GEN-LAST:event_tf_contact_no3ActionPerformed

    private void tf_contact_no4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_contact_no4ActionPerformed
        init_uom();
    }//GEN-LAST:event_tf_contact_no4ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        new_description();
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        save_description();
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        new_my_services_problems_customers();
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        save_my_services_problems_customers();
    }//GEN-LAST:event_jButton14ActionPerformed

    private void tf_contact_no5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_contact_no5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_contact_no5ActionPerformed

    private void tf_contact_no6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_contact_no6ActionPerformed
        init_prob();
    }//GEN-LAST:event_tf_contact_no6ActionPerformed

    private void tf_contact_no7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_contact_no7ActionPerformed
        init_inventory();
    }//GEN-LAST:event_tf_contact_no7ActionPerformed

    private void tf_contact_no8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_contact_no8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_contact_no8ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        new_my_services_item_replacements_customers();
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        save_my_services_item_replacements_customers();
    }//GEN-LAST:event_jButton16ActionPerformed

    private void tf_contact_no9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_contact_no9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_contact_no9ActionPerformed

    private void tf_contact_no10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_contact_no10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_contact_no10ActionPerformed

    private void tf_contact_no11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_contact_no11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_contact_no11ActionPerformed

    private void tf_contact_no12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_contact_no12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_contact_no12ActionPerformed

    private void tf_contact_no13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_contact_no13ActionPerformed
        init_others();
    }//GEN-LAST:event_tf_contact_no13ActionPerformed

    private void tf_contact_no14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_contact_no14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_contact_no14ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        new_my_services_others_customers();
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        save_my_services_others_customers();
    }//GEN-LAST:event_jButton18ActionPerformed

    private void tbl_my_services_description_customersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_my_services_description_customersMouseClicked
        select_description();
    }//GEN-LAST:event_tbl_my_services_description_customersMouseClicked

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void tbl_my_servicesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_my_servicesMouseClicked
        select_my_services();
    }//GEN-LAST:event_tbl_my_servicesMouseClicked

    private void tbl_my_services_problems_customersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_my_services_problems_customersMouseClicked
        select_my_services_problems_customers();
    }//GEN-LAST:event_tbl_my_services_problems_customersMouseClicked

    private void tbl_my_services_item_replacements_customersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_my_services_item_replacements_customersMouseClicked
        select_my_services_item_replacements_customers();
    }//GEN-LAST:event_tbl_my_services_item_replacements_customersMouseClicked

    private void tbl_my_services_others_customersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_my_services_others_customersMouseClicked
        select_my_services_others_customers();
    }//GEN-LAST:event_tbl_my_services_others_customersMouseClicked

    private void tf_contact_no15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_contact_no15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_contact_no15ActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        save_my_services_barcodes_customers();
    }//GEN-LAST:event_jButton20ActionPerformed

    private void tbl_my_services_barcodes_customersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_my_services_barcodes_customersMouseClicked
        select_my_services_barcodes_customers();
    }//GEN-LAST:event_tbl_my_services_barcodes_customersMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        data_cols();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tf_to_branchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_to_branchMouseClicked
        init_branch_locations();
    }//GEN-LAST:event_tf_to_branchMouseClicked

    private void tf_to_branchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_to_branchActionPerformed
        init_branch_locations();
    }//GEN-LAST:event_tf_to_branchActionPerformed

    private void tf_to_locationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_to_locationActionPerformed
        init_branch_locations2();
    }//GEN-LAST:event_tf_to_locationActionPerformed

    private void tf_to_locationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_to_locationMouseClicked
        init_branch_locations2();
    }//GEN-LAST:event_tf_to_locationMouseClicked

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JCheckBox cb_barcode;
    private com.toedter.calendar.JDateChooser dp_assigned;
    private com.toedter.calendar.JDateChooser dp_from;
    private com.toedter.calendar.JDateChooser dp_received;
    private com.toedter.calendar.JDateChooser dp_released;
    private com.toedter.calendar.JDateChooser dp_to;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton5;
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
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
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTable tbl_my_services;
    private javax.swing.JTable tbl_my_services_barcodes_customers;
    private javax.swing.JTable tbl_my_services_description_customers;
    private javax.swing.JTable tbl_my_services_item_replacements_customers;
    private javax.swing.JTable tbl_my_services_others_customers;
    private javax.swing.JTable tbl_my_services_problems_customers;
    private javax.swing.JTextField tf_amount;
    private javax.swing.JTextField tf_contact_no;
    private javax.swing.JTextField tf_contact_no10;
    private javax.swing.JTextField tf_contact_no11;
    private javax.swing.JTextField tf_contact_no12;
    private javax.swing.JTextField tf_contact_no13;
    private javax.swing.JTextField tf_contact_no14;
    private javax.swing.JTextField tf_contact_no15;
    private javax.swing.JTextField tf_contact_no2;
    private javax.swing.JTextField tf_contact_no3;
    private javax.swing.JTextField tf_contact_no4;
    private javax.swing.JTextField tf_contact_no5;
    private javax.swing.JTextField tf_contact_no6;
    private javax.swing.JTextField tf_contact_no7;
    private javax.swing.JTextField tf_contact_no8;
    private javax.swing.JTextField tf_contact_no9;
    private javax.swing.JTextField tf_customer_name;
    private javax.swing.JTextField tf_department1;
    private javax.swing.JTextField tf_department_id1;
    private javax.swing.JTextField tf_department_id2;
    private javax.swing.JTextField tf_description_description;
    private javax.swing.JTextArea tf_remarks;
    private javax.swing.JTextField tf_service_by;
    private javax.swing.JTextField tf_service_slip_no;
    private javax.swing.JTextField tf_service_type;
    private javax.swing.JTextField tf_service_type1;
    private javax.swing.JTextField tf_service_type_id;
    private javax.swing.JTextField tf_serviced_by;
    private javax.swing.JTextField tf_to_branch;
    private javax.swing.JTextField tf_to_location;
    private javax.swing.JTextField tf_transaction_no;
    // End of variables declaration//GEN-END:variables
    private void myInit() {

        System.setProperty("pool_host", "localhost");
        System.setProperty("pool_db", "db_algorithm");
        MyUser.setUser_id("1");

        init_key();
        set_default_branch();
//       
        init_transaction_no();

//        jPanel2.setVisible(false);
        tf_service_type_id.setVisible(false);
        tf_department_id1.setVisible(false);
        tf_department_id2.setVisible(false);

        //test
        do_pass(1);
    }
    String location_ids = "";

    private void set_default_branch() {

        Branch_locations.to_branch_locations to = S4_branch_locations.ret_data();
        location_ids = "" + to.id;
        Field.Combo f_br = (Field.Combo) tf_to_branch;
        f_br.setText(to.branch);
        f_br.setId(to.branch_id);

        String where = " order by branch,location asc ";
        branch_location_list = S1_branch_locations.ret_location_where(where);
    }

    int my_account_control = 0;

    //1=all
    //2=view
    //3=view/encde
    //4=view/encode/update-own-transaction
    public void do_pass(final int account) {
        my_account_control = account;

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                if (account == 2) {
                    jButton5.setVisible(false);
                    jButton9.setVisible(false);

                    //<editor-fold defaultstate="collapsed" desc=" buttons ">
                    jButton11.setVisible(false);
                    jButton12.setVisible(false);
                    jButton13.setVisible(false);
                    jButton14.setVisible(false);
                    jButton15.setVisible(false);
                    jButton16.setVisible(false);
                    jButton17.setVisible(false);
                    jButton18.setVisible(false);
                    jButton20.setVisible(false);
                    //</editor-fold>
                    //<editor-fold defaultstate="collapsed" desc=" fields ">
                    tf_service_slip_no.setFocusable(false);
                    tf_serviced_by.setFocusable(false);
                    tf_customer_name.setFocusable(false);
                    tf_contact_no.setFocusable(false);
                    tf_remarks.setFocusable(false);
                    tf_service_type1.setFocusable(false);
                    dp_received.setEnabled(false);
                    dp_released.setEnabled(false);
                    dp_assigned.setEnabled(false);
                    jCheckBox1.setEnabled(false);
                    jCheckBox2.setEnabled(false);
                    jCheckBox10.setEnabled(false);
                    jCheckBox16.setEnabled(false);
                    jTextField6.setVisible(false);

                    tf_description_description.setFocusable(false);
                    tf_contact_no2.setFocusable(false);
                    tf_contact_no3.setFocusable(false);
                    tf_contact_no4.setFocusable(false);

                    tf_contact_no6.setFocusable(false);
                    tf_contact_no5.setFocusable(false);

                    tf_contact_no7.setFocusable(false);
                    tf_contact_no9.setFocusable(false);
                    tf_contact_no8.setFocusable(false);
                    tf_contact_no10.setFocusable(false);
                    tf_contact_no11.setFocusable(false);

                    tf_contact_no13.setFocusable(false);
                    tf_contact_no12.setFocusable(false);
                    tf_contact_no14.setFocusable(false);

                    tf_contact_no15.setFocusable(false);
                    //</editor-fold>
                }

                if (account == 3) {

                }
                init_tbl_my_services();
                init_tbl_my_services_description_customers(tbl_my_services_description_customers);
                init_tbl_my_services_problems_customers(tbl_my_services_problems_customers);
                init_tbl_my_services_item_replacements_customers(tbl_my_services_item_replacements_customers);
                init_tbl_my_services_others_customers(tbl_my_services_others_customers);
                init_tbl_my_services_barcodes_customers(tbl_my_services_barcodes_customers);
            }
        });

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

    //<editor-fold defaultstate="collapsed" desc=" Combos ">
    List<My_services_departments.to_my_services_departments> department_list = new ArrayList();

    private void init_departments() {

        department_list.clear();
        String where = " where location_id='" + MyUser.getLocation_id() + "' ";
        department_list = My_services_departments.ret_data(where);
        Object[][] obj = new Object[department_list.size()][1];
        int i = 0;
        for (My_services_departments.to_my_services_departments to : department_list) {
            obj[i][0] = " " + to.department;
            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {tf_department1.getWidth()};
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
    List<My_services_crews.to_my_services_crews> service_by_list = new ArrayList();

    private void init_service_by() {
        String search = tf_service_by.getText();
        service_by_list.clear();
        String where = " where "
                + " lname like '%" + search + "%' and location_id='" + MyUser.getLocation_id() + "' "
                + " or fname like '%" + search + "%'  and location_id='" + MyUser.getLocation_id() + "' "
                + " order by lname asc";
        if (!jCheckBox11.isSelected()) {
            where = " where "
                    + " lname like '%" + search + "%' and department_id='" + tf_department_id1.getText() + "' and location_id='" + MyUser.getLocation_id() + "' "
                    + " or fname like '%" + search + "%' and department_id='" + tf_department_id1.getText() + "' and location_id='" + MyUser.getLocation_id() + "' "
                    + " order by lname asc";
        }

        service_by_list = My_services_crews.ret_data(where);
        Object[][] obj = new Object[service_by_list.size()][1];
        int i = 0;
        for (My_services_crews.to_my_services_crews to : service_by_list) {
            obj[i][0] = " " + to.fname + " " + to.mi + " " + to.lname;
            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {tf_service_by.getWidth()};
        int width = 0;
        String[] col_names = {""};
        TableRenderer tr = new TableRenderer();
        TableRenderer.setPopup(tf_service_by, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                My_services_crews.to_my_services_crews to = service_by_list.get(data.selected_row);
                tf_service_by.setText("" + to.fname + " " + to.mi + " " + to.lname);
                tf_department_id2.setText("" + to.id);
                data_cols();
            }
        });
    }
    List<S1_my_service_type.to_my_service_type> trans_list = new ArrayList();

    private void init_type2() {
        final Field.Combo combo = (Field.Combo) tf_service_type;

        trans_list.clear();
        String where = " where location_id='" + MyUser.getLocation_id() + "' ";
        trans_list = S1_my_service_type.ret_data(where);
        Object[][] obj = new Object[trans_list.size()][1];
        int i = 0;
        for (S1_my_service_type.to_my_service_type to : trans_list) {
            obj[i][0] = " " + to.service;
            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {tf_service_type.getWidth()};
        int width = 0;
        String[] col_names = {""};
        TableRenderer tr = new TableRenderer();
        TableRenderer.setPopup(tf_service_type, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                S1_my_service_type.to_my_service_type to = trans_list.get(data.selected_row);
                tf_service_type_id.setText("" + to.id);
                combo.setText("" + to.service);
                combo.setId("" + to.id);
                data_cols();
            }
        });
    }
    List<My_services_crews.to_my_services_crews> manager_list = new ArrayList();
    String my_department_manager;
    String my_department_manager_id;
    String my_department;
    String my_department_id;

    private void init_manager() {
        String search = tf_serviced_by.getText();
        manager_list.clear();
        String where = " where lname like '%" + search + "%' and location_id='" + MyUser.getLocation_id() + "' "
                + " or fname like '%" + search + "%' and location_id='" + MyUser.getLocation_id() + "' order by lname asc";
        manager_list = My_services_crews.ret_data(where);
        Object[][] obj = new Object[manager_list.size()][1];
        int i = 0;
        for (My_services_crews.to_my_services_crews to : manager_list) {
            obj[i][0] = " " + to.fname + " " + to.mi + " " + to.lname;
            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {tf_serviced_by.getWidth()};
        int width = 0;
        String[] col_names = {""};
        TableRenderer tr = new TableRenderer();
        TableRenderer.setPopup(tf_serviced_by, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                Field.Combo service = (Field.Combo) tf_serviced_by;
                My_services_crews.to_my_services_crews to = manager_list.get(data.selected_row);
                service.setText("" + to.fname + " " + to.mi + " " + to.lname);
                service.setId("" + to.id);
                my_department_manager = to.manager;
                my_department_manager_id = to.manager_id;
                my_department = to.department;
                my_department_id = to.department_id;
                tf_customer_name.grabFocus();

            }
        });
    }
    List<My_services_customers.to_my_services_customers> customer_list = new ArrayList();

    private void init_customer() {
        String search = tf_customer_name.getText();
        customer_list.clear();
        String where = " where customer_name like '%" + search + "%' and location_id='" + MyUser.getLocation_id() + "' order by customer_name asc ";
        customer_list = My_services_customers.ret_data(where);
        if (customer_list.isEmpty()) {

            customers();
        } else {
            Object[][] obj = new Object[customer_list.size()][1];
            int i = 0;
            for (My_services_customers.to_my_services_customers to : customer_list) {
                obj[i][0] = " " + to.customer_name;
                i++;
            }
            JLabel[] labels = {};
            int[] tbl_widths_customers = {tf_customer_name.getWidth()};
            int width = 0;
            String[] col_names = {""};
            TableRenderer tr = new TableRenderer();
            TableRenderer.setPopup(tf_customer_name, obj, labels, tbl_widths_customers, col_names);
            tr.setCallback(new TableRenderer.Callback() {
                @Override
                public void ok(TableRenderer.OutputData data) {
                    Field.Combo customer = (Field.Combo) tf_customer_name;
                    My_services_customers.to_my_services_customers to = customer_list.get(data.selected_row);
                    customer.setText("" + to.customer_name);
                    customer.setId("" + to.id);
                    tf_contact_no.setText(to.contact_no);

                }
            });
        }
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

    private void init_type() {

        String where = "";
        trans_list = S1_my_service_type.ret_data(where);
        Object[][] obj = new Object[trans_list.size()][1];
        int i = 0;
        for (S1_my_service_type.to_my_service_type to : trans_list) {
            obj[i][0] = " " + to.service;
            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {tf_service_type1.getWidth()};
        int width = 0;
        String[] col_names = {""};
        TableRenderer tr = new TableRenderer();
        TableRenderer.setPopup(tf_service_type, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                Field.Combo serv_type = (Field.Combo) tf_service_type1;
                S1_my_service_type.to_my_service_type to = trans_list.get(data.selected_row);
                serv_type.setId("" + to.id);
                serv_type.setText("" + to.service);

            }
        });
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" My Services ">
    private void init_transaction_no() {
        String where = " where location_id='" + MyUser.getLocation_id() + "' ";
        String transaction_no = My_services.increment_id(where);
        tf_transaction_no.setText(transaction_no);
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

        int update = 30;
        int delete = 30;

        if (my_account_control == 2 || my_account_control == 3) {

            update = 0;
            delete = 0;
        }
        if (my_account_control == 4) {
            update = 30;
            delete = 0;
        }

        int[] tbl_widths_my_services = {100, 100, 70, 40, 100, 100, 0, 30, 0, update, delete, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_my_services.length; i < n; i++) {
            if (i == 4 || i == 5) {
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
        tbl_my_services.getColumnModel().getColumn(7).setCellRenderer(new ImageRenderer1());
        tbl_my_services.getColumnModel().getColumn(9).setCellRenderer(new ImageRenderer1());
        tbl_my_services.getColumnModel().getColumn(10).setCellRenderer(new ImageRenderer1());

    }

    private void loadData_my_services(List<My_services.to_my_services> acc) {
        tbl_my_services_ALM.clear();
        tbl_my_services_ALM.addAll(acc);
    }

    public static class Tblmy_servicesModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Transaction #", "Service Slip #", "Date", "Days", "Customer", "Serviced By", "Problem", "", "", "", "", "qty", "unit", "description", "problem", "date_received", "date_assigned", "date_released", "added_by", "remarks", "status", "service_type", "service_type_id", "amount", "cashier", "cashier_id"
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
            My_services.to_my_services tt = (My_services.to_my_services) getRow(row);
            switch (col) {
                case 0:
                    return " " + tt.transaction_no;
                case 1:
                    return " " + tt.service_slip_no;
                case 2:
                    return " " + DateType.convert_slash_datetime2(tt.date_assigned);
                case 3:
                    try {
                        Date d = DateType.sf.parse(tt.date_assigned);
                        int days = DateUtils1.count_days(d, new Date());
                        return " " + days;
                    } catch (ParseException ex) {
                        Logger.getLogger(Dlg_my_services.class.getName()).log(Level.SEVERE, null, ex);
                    }
                case 4:
                    return " " + tt.customer_name;
                case 5:
                    return " " + tt.serviced_by;
                case 6:
                    return " " + tt.problem;
                case 7:

                    if (tt.status == 0) {
                        try {
                            Date d = DateType.sf.parse(tt.date_assigned);
                            int days = DateUtils1.count_days(d, new Date());
                            if (days > 10) {
                                return "/servicing/icons/check-mark (3).png";
                            } else {
                                return "/servicing/icons/check-mark (2).png";
                            }
                        } catch (ParseException ex) {
                            Logger.getLogger(Dlg_my_services.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    if (tt.status == 1) {
                        return "/servicing/icons/check-mark (1).png";
                    }
                    if (tt.status == 2) {
                        return "/servicing/icons/check-mark.png";
                    }
                    if (tt.status == 3) {
                        return "/servicing/icons/check-mark (4).png";
                    }

                case 8:
                    return tt.selected;
                case 9:
                    return "/servicing/icons/edit.png";
                case 10:
                    return "/servicing/icons/remove11.png";
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

    private void data_cols() {
        jProgressBar1.setString("Loading...Please wait...");
        jProgressBar1.setIndeterminate(true);
        enables(false);
        String where = "";
        String search = jTextField12.getText();
        if (search.isEmpty()) {
            tbl_my_services_ALM.clear();
            clear_my_services();
            jProgressBar1.setString("Finished...");
            jProgressBar1.setIndeterminate(false);
            jTextField12.grabFocus();
            enables(true);
            jTextField12.grabFocus();
            return;
        }
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
        if (cb_barcode.isSelected()) {
            String w = " where barcode ='" + jTextField12.getText() + "' ";

            List<My_services_barcodes_customers.to_my_services_barcodes_customers> aw = My_services_barcodes_customers.ret_data(w);
            for (My_services_barcodes_customers.to_my_services_barcodes_customers aww : aw) {
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
            where = where + " and service_type_id='" + tf_service_type_id.getText() + "' ";
        }
        String from = DateType.sf.format(dp_from.getDate());
        String to = DateType.sf.format(dp_to.getDate());
        if (!jCheckBox17.isSelected()) {
            where = where + " and Date(date_assigned) between '" + from + "' and '" + to + "' ";
        }
        if (!jCheckBox18.isSelected()) {
            where = where + " and service_by_id = '" + tf_department_id2.getText() + "'  ";
        }

        where = where + " and location_id ='" + location_ids + "' order by id desc ";
        System.out.println(where);
        List<My_services.to_my_services> datas = My_services.ret_data(where);
        loadData_my_services(datas);
        int on_going = 0;
        int finished = 0;
        int released = 0;
        int total = 0;
        int on_hold = 0;
        for (My_services.to_my_services to1 : datas) {
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
        jLabel2.setText("" + datas.size());
        jProgressBar1.setString("Finished...");
        jProgressBar1.setIndeterminate(false);
        enables(true);

    }

    private void enables(boolean stmt) {
        jCheckBox17.setEnabled(stmt);
        jCheckBox3.setEnabled(stmt);
        jCheckBox4.setEnabled(stmt);
        jCheckBox5.setEnabled(stmt);
        jCheckBox13.setEnabled(stmt);
        jCheckBox14.setEnabled(stmt);
        cb_barcode.setEnabled(stmt);
        jCheckBox6.setEnabled(stmt);
        jCheckBox7.setEnabled(stmt);
        jCheckBox8.setEnabled(stmt);
        jCheckBox9.setEnabled(stmt);
        jCheckBox15.setEnabled(stmt);

        jCheckBox11.setEnabled(stmt);
        tf_department1.setEnabled(stmt);
        jCheckBox18.setEnabled(stmt);
        tf_service_by.setEnabled(stmt);
        jCheckBox12.setEnabled(stmt);
        tf_service_type.setEnabled(stmt);
        jTextField12.setEnabled(stmt);
        jButton9.setEnabled(stmt);
    }

    private void save_my_services() {

        int row = tbl_my_services.getSelectedRow();
        if (row < 0) {
            int id = 0;
            String where = " where location_id='" + MyUser.getLocation_id() + "' ";
            String transaction_no = My_services.increment_id(where);
            where = " where transaction_no='" + transaction_no + "' and location_id='" + MyUser.getLocation_id() + "' ";
            List<My_services.to_my_services> datas = My_services.ret_data(where);
            if (!datas.isEmpty()) {
                Alert.set(0, "Transaction No exists!");
//                save_my_services();
                return;
            }
            Field.Combo serv_by = (Field.Combo) tf_serviced_by;
            Field.Combo customer = (Field.Combo) tf_customer_name;
            Field.Combo serv_type = (Field.Combo) tf_service_type1;
            String service_slip_no = tf_service_slip_no.getText();
            String serviced_by = serv_by.getText();
            String service_by_id = serv_by.getId();
            String department_manager = my_department_manager;
            String department_manager_id = my_department_manager_id;
            String department = my_department;
            String department_id = my_department_id;
            String customer_name = customer.getText();
            String customer_id = customer.getId();
            double qty = 0;
            String unit = "";
            String description = "";
            String problem = "";
            String date_received = DateType.sf.format(dp_received.getDate());
            String date_assigned = DateType.sf.format(dp_assigned.getDate());
            String date_released = DateType.sf.format(dp_released.getDate());
            String added_by = MyUser.getUser_name();
            String remarks = tf_remarks.getText();
            int status = 0;
            String service_type = serv_type.getText();
            String service_type_id = serv_type.getId();
            double amount = 0;
            String cashier = "";
            String cashier_id = "";
            boolean selected = false;
            String user_id = MyUser.getUser_id();
            String user_screen_name = MyUser.getUser_screen_name();
            String customer_contact_no = tf_contact_no.getText();
            String branch = MyUser.getBranch();
            String branch_id = MyUser.getBranch_id();
            String location = MyUser.getLocation();
            String location_id = MyUser.getLocation_id();
            My_services.to_my_services service = new My_services.to_my_services(id, transaction_no, service_slip_no, serviced_by, service_by_id, department_manager, department_manager_id, department, department_id, customer_name, customer_id, qty, unit, description, problem, date_received, date_assigned, date_released, added_by, remarks, status, service_type, service_type_id, amount, cashier, cashier_id, selected, user_id, user_screen_name, customer_contact_no, branch, branch_id, location, location_id);
            List<to_my_services_description_customers> descriptions = tbl_my_services_description_customers_ALM;
            List<My_services_problems_customers.to_my_services_problems_customers> problems = tbl_my_services_problems_customers_ALM;
            List<My_services_item_replacements_customers.to_my_services_item_replacements_customers> replacements = tbl_my_services_item_replacements_customers_ALM;
            List<to_my_services_others_customers> others = tbl_my_services_others_customers_ALM;
            Window p = (Window) this;
            Dlg_confirm_action nd = Dlg_confirm_action.create(p, true);
            nd.setTitle("");
            nd.do_pass();
            nd.setCallback(new Dlg_confirm_action.Callback() {

                @Override
                public void ok(CloseDialog closeDialog, Dlg_confirm_action.OutputData data) {
                    closeDialog.ok();
                    My_services.add_my_services(service, descriptions, problems, replacements, others);
                    data_cols();
                    Alert.set(1, "");
                    clear_my_services();
                }
            });
            nd.setLocationRelativeTo(this);
            nd.setVisible(true);

        } else {
            if (my_account_control == 2 || my_account_control == 3) {
                return;
            }
            My_services.to_my_services service = (My_services.to_my_services) tbl_my_services_ALM.get(row);
            int id = service.id;
            String transaction_no = service.transaction_no;
            Field.Combo serv_by = (Field.Combo) tf_serviced_by;
            Field.Combo customer = (Field.Combo) tf_customer_name;
            Field.Combo serv_type = (Field.Combo) tf_service_type1;
            String service_slip_no = tf_service_slip_no.getText();
            String serviced_by = serv_by.getText();
            String service_by_id = serv_by.getId();
            String department_manager = my_department_manager;
            String department_manager_id = my_department_manager_id;
            String department = my_department;
            String department_id = my_department_id;

            String customer_name = customer.getText();
            String customer_id = customer.getId();
            double qty = 0;
            String unit = "";
            String description = "";
            String problem = "";
            String date_received = DateType.sf.format(dp_received.getDate());
            String date_assigned = DateType.sf.format(dp_assigned.getDate());
            String date_released = DateType.sf.format(dp_released.getDate());
            String added_by = MyUser.getUser_name();
            String remarks = tf_remarks.getText();
            int status = 0;
            if (jCheckBox2.isSelected()) {
                status = 1;
            }
            if (jCheckBox10.isSelected()) {
                status = 2;
            }
            if (jCheckBox16.isSelected()) {
                status = 3;
            }
            String service_type = serv_type.getText();
            String service_type_id = serv_type.getId();
            double amount = 0;
            String cashier = "";
            String cashier_id = "";
            boolean selected = false;
            String user_id = service.user_id;
            String user_screen_name = service.user_screen_name;
            String customer_contact_no = tf_contact_no.getText();
            String branch = service.branch;
            String branch_id = service.branch_id;
            String location = service.location;
            String location_id = service.location_id;
            My_services.to_my_services service2 = new My_services.to_my_services(id, transaction_no, service_slip_no, serviced_by, service_by_id, department_manager, department_manager_id, department, department_id, customer_name, customer_id, qty, unit, description, problem, date_received, date_assigned, date_released, added_by, remarks, status, service_type, service_type_id, amount, cashier, cashier_id, selected, user_id, user_screen_name, customer_contact_no, branch, branch_id, location, location_id);
            Window p = (Window) this;
            Dlg_confirm_action nd = Dlg_confirm_action.create(p, true);
            nd.setTitle("");
            nd.setCallback(new Dlg_confirm_action.Callback() {
                @Override
                public void ok(CloseDialog closeDialog, Dlg_confirm_action.OutputData data) {
                    closeDialog.ok();
                    My_services.edit_my_services(service2);
                    data_cols();
                    Alert.set(2, "");
                    clear_my_services();
                }
            });
            nd.setLocationRelativeTo(this);
            nd.setVisible(true);

        }

    }

    private void clear_my_services() {
        Field.Combo serv_by = (Field.Combo) tf_serviced_by;
        Field.Combo customer = (Field.Combo) tf_customer_name;
        Field.Combo serv_type = (Field.Combo) tf_service_type1;

        init_transaction_no();
        tf_service_slip_no.setText("");
        serv_by.setText("");
        serv_by.setId("");
        my_department_manager = "";
        my_department_manager_id = "";
        my_department = "";
        my_department_id = "";

        customer.setText("");
        customer.setId("");
        tf_contact_no.setText("");
        tf_remarks.setText("");
        serv_type.setText("");
        serv_type.setId("");
        tf_amount.setText("0.00");
        dp_received.setDate(new Date());
        dp_released.setDate(new Date());
        dp_assigned.setDate(new Date());
        tbl_my_services_description_customers_ALM.clear();
        tbl_my_services_barcodes_customers_ALM.clear();
        tbl_my_services_item_replacements_customers_ALM.clear();
        tbl_my_services_others_customers_ALM.clear();
        tbl_my_services_problems_customers_ALM.clear();
        tf_service_slip_no.grabFocus();
        tbl_my_services.clearSelection();

    }

    private void select_my_services() {
        int row = tbl_my_services.getSelectedRow();
        if (row < 0) {
            return;
        }
        Field.Combo serv_by = (Field.Combo) tf_serviced_by;
        Field.Combo customer = (Field.Combo) tf_customer_name;
        Field.Combo serv_type = (Field.Combo) tf_service_type1;
        final My_services.to_my_services service = (My_services.to_my_services) tbl_my_services_ALM.get(row);
        int col = tbl_my_services.getSelectedColumn();
        if (col <= 9) {
            //edit
            tf_transaction_no.setText(service.transaction_no);
            tf_service_slip_no.setText(service.service_slip_no);
            serv_by.setText(service.serviced_by);
            serv_by.setId(service.service_by_id);
            my_department_manager = service.department_manager;
            my_department_manager_id = service.department_manager_id;
            my_department = service.department;
            my_department_id = service.department_id;

            customer.setText(service.customer_name);
            customer.setId(service.customer_id);
            tf_contact_no.setText(service.customer_contact_no);
            tf_remarks.setText(service.remarks);
            serv_type.setText(service.service_type);
            serv_type.setId(service.service_type_id);

            try {
                dp_received.setDate(DateType.sf.parse(service.date_received));
                dp_released.setDate(DateType.sf.parse(service.date_released));
                dp_assigned.setDate(DateType.sf.parse(service.date_assigned));
            } catch (ParseException ex) {
                Logger.getLogger(Dlg_services.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (service.status == 0) {
                jCheckBox1.setSelected(true);
            }
            if (service.status == 1) {
                jCheckBox2.setSelected(true);
            }
            if (service.status == 2) {
                jCheckBox10.setSelected(true);
            }
            if (service.status == 3) {
                jCheckBox16.setSelected(true);
            }
            ret_my_services_descriptions();
            ret_my_services_customers_problems();
            ret_my_services_item_replacements_customers();
            ret_my_services_others_customers();
            ret_my_services_barcodes_customers();
        }
        if (col == 10) {
            //delete
            Window p = (Window) this;
            Dlg_confirm_action nd = Dlg_confirm_action.create(p, true);
            nd.setTitle("");

            nd.setCallback(new Dlg_confirm_action.Callback() {

                @Override
                public void ok(CloseDialog closeDialog, Dlg_confirm_action.OutputData data) {
                    closeDialog.ok();
                    My_services.delete_my_services(service);
                    data_cols();
                    Alert.set(3, "");
                    clear_my_services();
                }
            });
            nd.setLocationRelativeTo(jScrollPane1);
            nd.setVisible(true);
        }
    }

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc=" My_services_description_customers "> 
    public static ArrayListModel tbl_my_services_description_customers_ALM;
    public static Tblmy_services_description_customersModel tbl_my_services_description_customers_M;

    public void init_tbl_my_services_description_customers(JTable tbl_my_services_description_customers) {
        tbl_my_services_description_customers_ALM = new ArrayListModel();
        tbl_my_services_description_customers_M = new Tblmy_services_description_customersModel(tbl_my_services_description_customers_ALM);
        tbl_my_services_description_customers.setModel(tbl_my_services_description_customers_M);
        tbl_my_services_description_customers.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_my_services_description_customers.setRowHeight(25);
        int update = 30;
        int delete = 30;
        if (my_account_control == 2 || my_account_control == 3) {
            update = 0;
            delete = 0;
        }
        if (my_account_control == 4) {
            update = 30;
            delete = 0;
        }

        int[] tbl_widths_my_services_description_customers = {70, 40, 100, update, delete, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_my_services_description_customers.length; i < n; i++) {
            if (i == 2) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_my_services_description_customers, i, tbl_widths_my_services_description_customers[i]);
        }
        Dimension d = tbl_my_services_description_customers.getTableHeader().getPreferredSize();
        d.height = 25;
        tbl_my_services_description_customers.getTableHeader().setPreferredSize(d);
        tbl_my_services_description_customers.getTableHeader().setFont(new java.awt.Font("Arial", 0, 12));
        tbl_my_services_description_customers.setRowHeight(25);
        tbl_my_services_description_customers.setFont(new java.awt.Font("Arial", 0, 12));
        tbl_my_services_description_customers.getColumnModel().getColumn(3).setCellRenderer(new ImageRenderer1());
        tbl_my_services_description_customers.getColumnModel().getColumn(4).setCellRenderer(new ImageRenderer1());
    }

    public static void loadData_my_services_description_customers(List<to_my_services_description_customers> acc) {
        tbl_my_services_description_customers_ALM.clear();
        tbl_my_services_description_customers_ALM.addAll(acc);
    }

    public static class Tblmy_services_description_customersModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Date", "Qty", "Description", "", "", "transaction_no", "date_added", "user_name", "unit", "barcode", "branch", "branch_id", "location", "location_id"
        };

        public Tblmy_services_description_customersModel(ListModel listmodel) {
            super(listmodel, COLUMNS);
        }

        @Override
        public boolean isCellEditable(int row, int column) {
            if (column == 100) {
                return true;
            }
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
            to_my_services_description_customers tt = (to_my_services_description_customers) getRow(row);
            switch (col) {
                case 0:
                    return " " + DateType.convert_slash_datetime(tt.date_added);
                case 1:
                    return " " + FitIn.fmt_woc(tt.amount);
                case 2:
                    return " " + tt.description;
                case 3:
                    return "/servicing/icons/edit.png";
                case 4:
                    return "/servicing/icons/remove11.png";
                case 5:
                    return tt.transaction_no;
                case 6:
                    return tt.date_added;
                case 7:
                    return tt.user_name;
                case 8:
                    return tt.unit;
                case 9:
                    return tt.barcode;
                case 10:
                    return tt.branch;
                case 11:
                    return tt.branch_id;
                case 12:
                    return tt.location;
                default:
                    return tt.location_id;
            }
        }
    }

    private void ret_my_services_descriptions() {
        int row = tbl_my_services.getSelectedRow();
        if (row < 0) {
            return;
        }

        My_services.to_my_services service = (My_services.to_my_services) tbl_my_services_ALM.get(row);
        String where = " where transaction_no='" + service.transaction_no + "' ";
        List<to_my_services_description_customers> descriptions = My_services_description_customers.ret_data3(where);
        loadData_my_services_description_customers(descriptions);
    }
    List<S1_my_services_description.to_my_services_description> description_list = new ArrayList();

    //<editor-fold defaultstate="collapsed" desc=" combo ">
    private void init_description_description() {
        String search = tf_description_description.getText();
        description_list.clear();
        String where = " where description like '%" + search + "%' "
                + "   order by description asc";
        description_list = S1_my_services_description.ret_data(where);
        Object[][] obj = new Object[description_list.size()][1];
        int i = 0;
        for (S1_my_services_description.to_my_services_description to : description_list) {
            obj[i][0] = " " + to.description;
            i++;
        }
        if (description_list.isEmpty()) {
            to_my_services_description t = new to_my_services_description(0, search, 0, "", "");
            S1_my_services_description.add_my_services_description(t);
            tf_contact_no2.grabFocus();
        } else {
            JLabel[] labels = {};
            int[] tbl_widths_customers = {tf_description_description.getWidth()};
            int width = 0;
            String[] col_names = {""};
            TableRenderer tr = new TableRenderer();
            TableRenderer.setPopup(tf_description_description, obj, labels, tbl_widths_customers, col_names);
            tr.setCallback(new TableRenderer.Callback() {
                @Override
                public void ok(TableRenderer.OutputData data) {
                    S1_my_services_description.to_my_services_description to = description_list.get(data.selected_row);
                    tf_description_description.setText("" + to.description);
                    tf_contact_no2.grabFocus();
                }
            });
        }
    }
    List<S1_my_services_uom.to_my_services_uom> uom_list = new ArrayList();

    private void init_uom() {
        String search = tf_contact_no4.getText();
        uom_list.clear();
        String where = " where uom like '%" + search + "%' order by uom asc ";
        uom_list = S1_my_services_uom.ret_data(where);
        Object[][] obj = new Object[uom_list.size()][1];
        int i = 0;
        for (S1_my_services_uom.to_my_services_uom to : uom_list) {
            obj[i][0] = " " + to.uom;
            i++;
        }
        if (uom_list.isEmpty()) {
            if (!search.isEmpty()) {
                S1_my_services_uom.to_my_services_uom t5 = new S1_my_services_uom.to_my_services_uom(0, search);
                S1_my_services_uom.add_my_services_uom(t5);
            }
        } else {
            JLabel[] labels = {};
            int[] tbl_widths_customers = {tf_contact_no4.getWidth()};
            int width = 0;
            String[] col_names = {""};
            TableRenderer tr = new TableRenderer();
            TableRenderer.setPopup(tf_contact_no4, obj, labels, tbl_widths_customers, col_names);
            tr.setCallback(new TableRenderer.Callback() {
                @Override
                public void ok(TableRenderer.OutputData data) {
                    S1_my_services_uom.to_my_services_uom to = uom_list.get(data.selected_row);
                    tf_contact_no4.setText("" + to.uom);

                }
            });
        }
    }
    //</editor-fold>

    private void save_description() {
        int row = tbl_my_services_description_customers.getSelectedRow();
        Field.Combo customer = (Field.Combo) tf_customer_name;
        String description = tf_description_description.getText();
        if (description.isEmpty()) {
            Alert.set(0, "Enter description");
            tf_description_description.grabFocus();
            return;
        }
        double amount = FitIn.toDouble(tf_contact_no3.getText());
        if (amount <= 0) {
            Alert.set(0, "Enter quantity");
            tf_contact_no3.grabFocus();
            return;
        }
        String barcode = tf_contact_no2.getText();
        String unit = tf_contact_no4.getText();

        if (row < 0) {
            int row2 = tbl_my_services.getSelectedRow();
            if (row2 < 0) {
                int id = 0;
                String customer_id = customer.getId();
                String customer_name = customer.getText();
                String transaction_no = "";
                String date_added = DateType.now();
                String user_name = MyUser.getUser_name();
                String branch = MyUser.getBranch();
                String branch_id = MyUser.getBranch_id();
                String location = MyUser.getLocation();
                String location_id = MyUser.getLocation_id();
                My_services_description_customers.to_my_services_description_customers desc = new to_my_services_description_customers(id, description, amount, customer_id, customer_name, transaction_no, date_added, user_name, unit, barcode, branch, branch_id, location, location_id);
                tbl_my_services_description_customers_ALM.add(desc);

            } else {
                My_services.to_my_services service = (My_services.to_my_services) tbl_my_services_ALM.get(row2);
                int id = 0;
                String customer_id = service.customer_id;
                String customer_name = service.customer_name;
                String transaction_no = service.transaction_no;
                String date_added = DateType.now();
                String user_name = MyUser.getUser_name();
                String branch = service.branch;
                String branch_id = service.branch_id;
                String location = service.location;
                String location_id = service.location_id;
                My_services_description_customers.to_my_services_description_customers desc2 = new to_my_services_description_customers(id, description, amount, customer_id, customer_name, transaction_no, date_added, user_name, unit, barcode, branch, branch_id, location, location_id);
                My_services_description_customers.add_my_services_description_customers(desc2);
                ret_my_services_descriptions();
                Alert.set(1, "");

            }
            new_description();
        } else {
            My_services_description_customers.to_my_services_description_customers desc = (My_services_description_customers.to_my_services_description_customers) tbl_my_services_description_customers_ALM.get(row);
            if (desc.id == 0) {
                desc.setDescription(description);
                desc.setAmount(amount);
                desc.setBarcode(barcode);
                desc.setUnit(unit);
                tbl_my_services_description_customers_M.fireTableDataChanged();

            } else {
                if (my_account_control == 2 || my_account_control == 3) {
                    return;
                }
                int id = desc.id;
                String customer_id = desc.customer_id;
                String customer_name = desc.customer_name;
                String transaction_no = desc.transaction_no;
                String date_added = desc.date_added;
                String user_name = desc.user_name;
                String branch = desc.branch;
                String branch_id = desc.branch_id;
                String location = desc.location;
                String location_id = desc.location_id;
                My_services_description_customers.to_my_services_description_customers desc2 = new to_my_services_description_customers(id, description, amount, customer_id, customer_name, transaction_no, date_added, user_name, unit, barcode, branch, branch_id, location, location_id);
                My_services_description_customers.edit_my_services_description_customers(desc2);
                ret_my_services_descriptions();
                Alert.set(2, "");
            }

            new_description();
        }
    }

    private void select_description() {
        final int row = tbl_my_services_description_customers.getSelectedRow();
        if (row < 0) {
            return;
        }
        final My_services_description_customers.to_my_services_description_customers desc = (My_services_description_customers.to_my_services_description_customers) tbl_my_services_description_customers_ALM.get(row);
        int col = tbl_my_services_description_customers.getSelectedColumn();
        if (col == 3) {
            //edit
            tf_description_description.setText(desc.description);
            tf_contact_no2.setText(desc.barcode);
            tf_contact_no4.setText(desc.unit);
            tf_contact_no3.setText(FitIn.fmt_woc(desc.amount));

        }
        if (col == 4) {
            //delete
            if (desc.id == 0) {
                tbl_my_services_description_customers_ALM.remove(row);
                tf_description_description.grabFocus();
            } else {
                Window p = (Window) this;
                Dlg_confirm_action nd = Dlg_confirm_action.create(p, true);
                nd.setTitle("");
                nd.setCallback(new Dlg_confirm_action.Callback() {
                    @Override
                    public void ok(CloseDialog closeDialog, Dlg_confirm_action.OutputData data) {
                        closeDialog.ok();
                        My_services_description_customers.delete_my_services_description_customers(desc);
                        ret_my_services_descriptions();
                        Alert.set(3, "");
                        new_description();
                    }
                });
                nd.setLocationRelativeTo(jTabbedPane1);
                nd.setVisible(true);
            }

        }
    }

    private void new_description() {
        tf_description_description.setText("");
        tf_contact_no2.setText("");
        tf_contact_no4.setText("");
        tf_contact_no3.setText("");
        tbl_my_services_description_customers.clearSelection();
        tf_description_description.grabFocus();

    }
//</editor-fold> 
    //<editor-fold defaultstate="collapsed" desc=" my_services_problems_customers "> 
    public static ArrayListModel tbl_my_services_problems_customers_ALM;
    public static Tblmy_services_problems_customersModel tbl_my_services_problems_customers_M;

    public void init_tbl_my_services_problems_customers(JTable tbl_my_services_problems_customers) {
        tbl_my_services_problems_customers_ALM = new ArrayListModel();
        tbl_my_services_problems_customers_M = new Tblmy_services_problems_customersModel(tbl_my_services_problems_customers_ALM);
        tbl_my_services_problems_customers.setModel(tbl_my_services_problems_customers_M);
        tbl_my_services_problems_customers.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_my_services_problems_customers.setRowHeight(25);
        int update = 30;
        int delete = 30;
        if (my_account_control == 2 || my_account_control == 3) {
            update = 0;
            delete = 0;
        }
        if (my_account_control == 4) {
            update = 30;
            delete = 0;
        }

        int[] tbl_widths_my_services_problems_customers = {70, 100, 80, update, delete, 0, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_my_services_problems_customers.length; i < n; i++) {
            if (i == 1) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_my_services_problems_customers, i, tbl_widths_my_services_problems_customers[i]);
        }
        Dimension d = tbl_my_services_problems_customers.getTableHeader().getPreferredSize();
        d.height = 25;
        tbl_my_services_problems_customers.getTableHeader().setPreferredSize(d);
        tbl_my_services_problems_customers.getTableHeader().setFont(new java.awt.Font("Arial", 0, 12));
        tbl_my_services_problems_customers.setRowHeight(25);
        tbl_my_services_problems_customers.setFont(new java.awt.Font("Arial", 0, 12));
        tbl_my_services_problems_customers.getColumnModel().getColumn(3).setCellRenderer(new ImageRenderer1());
        tbl_my_services_problems_customers.getColumnModel().getColumn(4).setCellRenderer(new ImageRenderer1());
        TableWidthUtilities.setColumnRightRenderer(tbl_my_services_problems_customers, 2);
    }

    public static void loadData_my_services_problems_customers(List<to_my_services_problems_customers> acc) {
        tbl_my_services_problems_customers_ALM.clear();
        tbl_my_services_problems_customers_ALM.addAll(acc);
    }

    public static class Tblmy_services_problems_customersModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Date", "Description", "Amount", "", "", "date_added", "amount", "branch", "branch_id", "location", "location_id"
        };

        public Tblmy_services_problems_customersModel(ListModel listmodel) {
            super(listmodel, COLUMNS);
        }

        @Override
        public boolean isCellEditable(int row, int column) {
            if (column == 100) {
                return true;
            }
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
            to_my_services_problems_customers tt = (to_my_services_problems_customers) getRow(row);
            switch (col) {
                case 0:
                    return " " + DateType.convert_slash_datetime(tt.date_added);
                case 1:
                    return " " + tt.problem;
                case 2:

                    return FitIn.fmt_wc_0(tt.amount) + " ";
                case 3:
                    return "/servicing/icons/edit.png";
                case 4:
                    return "/servicing/icons/remove11.png";
                case 5:
                    return tt.date_added;
                case 6:
                    return tt.amount;
                case 7:
                    return tt.branch;
                case 8:
                    return tt.branch_id;
                case 9:
                    return tt.location;
                default:
                    return tt.location_id;
            }
        }
    }

    private void ret_my_services_customers_problems() {
        int row = tbl_my_services.getSelectedRow();
        if (row < 0) {
            return;
        }

        My_services.to_my_services service = (My_services.to_my_services) tbl_my_services_ALM.get(row);
        String where = " where transaction_no='" + service.transaction_no + "' ";
        List<My_services_problems_customers.to_my_services_problems_customers> problems = My_services_problems_customers.ret_data(where);
        loadData_my_services_problems_customers(problems);
    }

    List<S1_my_services_problems.to_my_services_problems> prob_list = new ArrayList();

    //<editor-fold defaultstate="collapsed" desc=" combo ">
    private void init_prob() {
        String search = tf_contact_no6.getText();
        prob_list.clear();
        String where = " where problem like '%" + search + "%' order by problem asc ";
        prob_list = S1_my_services_problems.ret_data(where);
        Object[][] obj = new Object[prob_list.size()][1];
        int i = 0;
        for (S1_my_services_problems.to_my_services_problems to : prob_list) {
            obj[i][0] = " " + to.problem;
            i++;
        }
        if (prob_list.isEmpty()) {
            double am = FitIn.toDouble(tf_contact_no6.getText());
            S1_my_services_problems.to_my_services_problems to = new S1_my_services_problems.to_my_services_problems(0, search, am);
            if (!search.isEmpty()) {
                S1_my_services_problems.add_my_services_problems(to);
                tf_contact_no5.grabFocus();
            }
        } else {
            JLabel[] labels = {};
            int[] tbl_widths_customers = {tf_contact_no6.getWidth()};
            String[] col_names = {""};
            TableRenderer tr = new TableRenderer();
            TableRenderer.setPopup(tf_contact_no6, obj, labels, tbl_widths_customers, col_names);
            tr.setCallback(new TableRenderer.Callback() {
                @Override
                public void ok(TableRenderer.OutputData data) {
                    S1_my_services_problems.to_my_services_problems to = prob_list.get(data.selected_row);
                    tf_contact_no6.setText("" + to.problem);
                    tf_contact_no5.grabFocus();

                }
            });
        }
    }

    //</editor-fold>
    private void save_my_services_problems_customers() {
        int row = tbl_my_services_problems_customers.getSelectedRow();
        Field.Combo customer = (Field.Combo) tf_customer_name;
        if (row < 0) {
            int row2 = tbl_my_services.getSelectedRow();
            if (row2 < 0) {
                //add temporary
                int id = 0;
                String problem = tf_contact_no6.getText();
                String customer_id = customer.getId();
                String customer_name = customer.getText();
                String transaction_no = "";
                String date_added = DateType.now();
                double amount = FitIn.toDouble(tf_contact_no5.getText());
                String branch = MyUser.getBranch();
                String branch_id = MyUser.getBranch_id();
                String location = MyUser.getLocation();
                String location_id = MyUser.getLocation_id();
                My_services_problems_customers.to_my_services_problems_customers prob = new to_my_services_problems_customers(id, problem, customer_id, customer_name, transaction_no, date_added, amount, branch, branch_id, location, location_id);
                tbl_my_services_problems_customers_ALM.add(prob);

            } else {
                //add new problem to transaction
                My_services.to_my_services service = (My_services.to_my_services) tbl_my_services_ALM.get(row2);

                int id = 0;
                String problem = tf_contact_no6.getText();
                String customer_id = service.customer_id;
                String customer_name = service.customer_name;
                String transaction_no = service.transaction_no;
                String date_added = DateType.now();
                double amount = FitIn.toDouble(tf_contact_no5.getText());
                String branch = service.branch;
                String branch_id = service.branch_id;
                String location = service.location;
                String location_id = service.location_id;

                My_services_problems_customers.to_my_services_problems_customers prob = new to_my_services_problems_customers(id, problem, customer_id, customer_name, transaction_no, date_added, amount, branch, branch_id, location, location_id);

                My_services_problems_customers.add_my_services_problems_customers(prob);
                ret_my_services_customers_problems();
                Alert.set(1, "");

            }
            new_my_services_problems_customers();
        } else {
            My_services_problems_customers.to_my_services_problems_customers prob = (My_services_problems_customers.to_my_services_problems_customers) tbl_my_services_problems_customers_ALM.get(row);
            if (prob.id == 0) {
                String problem = tf_contact_no6.getText();
                double amount = FitIn.toDouble(tf_contact_no5.getText());
                prob.setAmount(amount);
                prob.setProblem(problem);
                tbl_my_services_problems_customers_M.fireTableDataChanged();
            } else {
                if (my_account_control == 2 || my_account_control == 3) {
                    return;
                }
                int id = prob.id;
                String problem = tf_contact_no6.getText();
                String customer_id = prob.customer_id;
                String customer_name = prob.customer_name;
                String transaction_no = prob.transaction_no;
                String date_added = prob.date_added;
                double amount = FitIn.toDouble(tf_contact_no5.getText());
                String branch = prob.branch;
                String branch_id = prob.branch_id;
                String location = prob.location;
                String location_id = prob.location_id;

                My_services_problems_customers.to_my_services_problems_customers prob2 = new to_my_services_problems_customers(id, problem, customer_id, customer_name, transaction_no, date_added, amount, branch, branch_id, location, location_id);
                My_services_problems_customers.edit_my_services_problems_customers(prob2);
                ret_my_services_customers_problems();
                Alert.set(2, "");
            }
            new_my_services_problems_customers();
        }
    }

    private void select_my_services_problems_customers() {
        int row = tbl_my_services_problems_customers.getSelectedRow();
        if (row < 0) {
            return;
        }
        final My_services_problems_customers.to_my_services_problems_customers prob = (My_services_problems_customers.to_my_services_problems_customers) tbl_my_services_problems_customers_ALM.get(row);

        int col = tbl_my_services_problems_customers.getSelectedColumn();
        if (col == 3) {
            tf_contact_no6.setText(prob.problem);
            tf_contact_no5.setText(FitIn.fmt_wc_0(prob.amount));
        }
        if (col == 4) {
            if (prob.id == 0) {
                tbl_my_services_problems_customers_ALM.remove(row);
                tbl_my_services_problems_customers_M.fireTableDataChanged();
            } else {
                Window p = (Window) this;
                Dlg_confirm_action nd = Dlg_confirm_action.create(p, true);
                nd.setTitle("");

                nd.setCallback(new Dlg_confirm_action.Callback() {

                    @Override
                    public void ok(CloseDialog closeDialog, Dlg_confirm_action.OutputData data) {
                        closeDialog.ok();
                        My_services_problems_customers.delete_my_services_problems_customers("" + prob.id);
                        ret_my_services_customers_problems();
                        Alert.set(2, "");
                        new_my_services_problems_customers();
                    }
                });
                nd.setLocationRelativeTo(jTabbedPane1);
                nd.setVisible(true);
            }
        }
    }

    private void new_my_services_problems_customers() {
        tf_contact_no6.setText("");
        tf_contact_no5.setText("");
        tbl_my_services_problems_customers.clearSelection();
        tf_contact_no6.grabFocus();
    }
//</editor-fold> 
    //<editor-fold defaultstate="collapsed" desc=" my_services_item_replacements_customers "> 
    public static ArrayListModel tbl_my_services_item_replacements_customers_ALM;
    public static Tblmy_services_item_replacements_customersModel tbl_my_services_item_replacements_customers_M;

    public void init_tbl_my_services_item_replacements_customers(JTable tbl_my_services_item_replacements_customers) {
        tbl_my_services_item_replacements_customers_ALM = new ArrayListModel();
        tbl_my_services_item_replacements_customers_M = new Tblmy_services_item_replacements_customersModel(tbl_my_services_item_replacements_customers_ALM);
        tbl_my_services_item_replacements_customers.setModel(tbl_my_services_item_replacements_customers_M);
        tbl_my_services_item_replacements_customers.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_my_services_item_replacements_customers.setRowHeight(25);
        int update = 30;
        int delete = 30;
        if (my_account_control == 2 || my_account_control == 3) {
            update = 0;
            delete = 0;
        }
        if (my_account_control == 4) {
            update = 30;
            delete = 0;
        }

        int[] tbl_widths_my_services_item_replacements_customers = {70, 30, 100, 70, update, delete, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_my_services_item_replacements_customers.length; i < n; i++) {
            if (i == 2) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_my_services_item_replacements_customers, i, tbl_widths_my_services_item_replacements_customers[i]);
        }
        Dimension d = tbl_my_services_item_replacements_customers.getTableHeader().getPreferredSize();
        d.height = 25;
        tbl_my_services_item_replacements_customers.getTableHeader().setPreferredSize(d);
        tbl_my_services_item_replacements_customers.getTableHeader().setFont(new java.awt.Font("Arial", 0, 12));
        tbl_my_services_item_replacements_customers.setRowHeight(25);
        tbl_my_services_item_replacements_customers.setFont(new java.awt.Font("Arial", 0, 12));
        tbl_my_services_item_replacements_customers.getColumnModel().getColumn(4).setCellRenderer(new ImageRenderer1());
        tbl_my_services_item_replacements_customers.getColumnModel().getColumn(5).setCellRenderer(new ImageRenderer1());
        TableWidthUtilities.setColumnRightRenderer(tbl_my_services_item_replacements_customers, 3);
    }

    public static void loadData_my_services_item_replacements_customers(List<to_my_services_item_replacements_customers> acc) {
        tbl_my_services_item_replacements_customers_ALM.clear();
        tbl_my_services_item_replacements_customers_ALM.addAll(acc);
    }

    public static class Tblmy_services_item_replacements_customersModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Date", "Qty", "Description", "Amount", "", "", "description", "qty", "selling_price", "date_added", "user_name", "category", "category_id", "classification", "classification_id", "sub_classification", "sub_classification_id", "unit", "conversion", "item_type", "status", "supplier", "fixed_price", "supplier_id", "multi_level_pricing", "vatable", "reorder_level", "markup", "brand", "brand_id", "model", "model_id", "selling_type", "branch", "branch_code", "location", "location_id", "serial_no", "user_id", "user_screen_name"
        };

        public Tblmy_services_item_replacements_customersModel(ListModel listmodel) {
            super(listmodel, COLUMNS);
        }

        @Override
        public boolean isCellEditable(int row, int column) {
            if (column == 100) {
                return true;
            }
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
            to_my_services_item_replacements_customers tt = (to_my_services_item_replacements_customers) getRow(row);
            switch (col) {
                case 0:
                    return " " + DateType.convert_slash_datetime(tt.date_added);
                case 1:
                    return " " + FitIn.fmt_woc(tt.qty);
                case 2:
                    return " " + tt.description;
                case 3:
                    return FitIn.fmt_wc_0(tt.qty * tt.selling_price) + " ";
                case 4:
                    return "/servicing/icons/edit.png";
                case 5:
                    return "/servicing/icons/remove11.png";
                case 6:
                    return tt.description;
                case 7:
                    return tt.qty;
                case 8:
                    return tt.selling_price;
                case 9:
                    return tt.date_added;
                case 10:
                    return tt.user_name;
                case 11:
                    return tt.category;
                case 12:
                    return tt.category_id;
                case 13:
                    return tt.classification;
                case 14:
                    return tt.classification_id;
                case 15:
                    return tt.sub_classification;
                case 16:
                    return tt.sub_classification_id;
                case 17:
                    return tt.unit;
                case 18:
                    return tt.conversion;
                case 19:
                    return tt.item_type;
                case 20:
                    return tt.status;
                case 21:
                    return tt.supplier;
                case 22:
                    return tt.fixed_price;
                case 23:
                    return tt.supplier_id;
                case 24:
                    return tt.multi_level_pricing;
                case 25:
                    return tt.vatable;
                case 26:
                    return tt.reorder_level;
                case 27:
                    return tt.markup;
                case 28:
                    return tt.brand;
                case 29:
                    return tt.brand_id;
                case 30:
                    return tt.model;
                case 31:
                    return tt.model_id;
                case 32:
                    return tt.selling_type;
                case 33:
                    return tt.branch;
                case 34:
                    return tt.branch_code;
                case 35:
                    return tt.location;
                case 36:
                    return tt.location_id;
                case 37:
                    return tt.serial_no;
                case 38:
                    return tt.user_id;
                default:
                    return tt.user_screen_name;
            }
        }
    }

    private void ret_my_services_item_replacements_customers() {
        int row = tbl_my_services.getSelectedRow();
        if (row < 0) {
            return;
        }

        My_services.to_my_services service = (My_services.to_my_services) tbl_my_services_ALM.get(row);
        String where = " where transaction_no='" + service.transaction_no + "' ";
        List<My_services_item_replacements_customers.to_my_services_item_replacements_customers> replacements = My_services_item_replacements_customers.ret_data(where);
        loadData_my_services_item_replacements_customers(replacements);
    }

    //<editor-fold defaultstate="collapsed" desc=" combo ">
    List<Inventory.to_inventory> inventory_list = new ArrayList();
    int item_selected = -1;

    private void init_inventory() {
        Field.Combo loc = (Field.Combo) tf_to_location;
        if (loc.getId().isEmpty() || loc.getText().isEmpty()) {
            Alert.set(0, "Please select a location!");
            return;
        }
        String search = tf_contact_no7.getText();
        String where = " where  barcode like '" + search + "' and location_id='" + loc.getId() + "' "
                + " or description like '%" + search + "%' and location_id='" + loc.getId() + "' "
                + " or main_barcode like '" + search + "' and location_id='" + loc.getId() + "' "
                + "  order by description asc";
        inventory_list.clear();
        inventory_list = Inventory.ret_data4(where);
        Object[][] obj = new Object[inventory_list.size()][3];
        int i = 0;
        for (Inventory.to_inventory to : inventory_list) {
            obj[i][0] = " " + to.product_qty;
            obj[i][1] = " " + to.barcodes;
            obj[i][2] = " " + to.description;
            i++;
        }

        JLabel[] labels = {};
        int w1 = tf_contact_no7.getWidth();
        int[] tbl_widths_customers = {50, 150, tf_contact_no8.getWidth() + 200};
        int width = 0;
        for (int w : tbl_widths_customers) {
            width += w;
        }
        String[] col_names = {"Qty", "Code", "Description"};
        TableRenderer tr = new TableRenderer();
        TableRenderer.setPopup2(tf_contact_no7, obj, labels, tbl_widths_customers, col_names, width);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                Inventory.to_inventory to = inventory_list.get(data.selected_row);
                if (to.product_qty < 1) {
                    Alert.set(0, "Insufficient stock/s");
                    return;
                }
                item_selected = data.selected_row;
                tf_contact_no7.setText(to.barcodes);
                tf_contact_no8.setText(to.description);
                tf_contact_no9.setText(to.barcode);
                tf_contact_no11.setText(FitIn.fmt_wc_0(to.selling_price));
                tf_contact_no10.grabFocus();
            }
        });
    }

    //</editor-fold>
    private void save_my_services_item_replacements_customers() {
        int row = tbl_my_services_item_replacements_customers.getSelectedRow();
        if (row < 0) {
            int row2 = tbl_my_services.getSelectedRow();
            Inventory.to_inventory item = inventory_list.get(item_selected);
            if (item_selected == -1) {
                return;
            }
            if (row2 < 0) {
                Field.Combo cust = (Field.Combo) tf_customer_name;
                int id = 0;
                String transaction_no = "";
                String customer_id = cust.getId();
                String customer_name = cust.getText();
                String item_code = tf_contact_no7.getText();
                String barcode = tf_contact_no9.getText();
                String description = tf_contact_no8.getText();
                double qty = FitIn.toDouble(tf_contact_no10.getText());
                if (qty <= 0) {
                    Alert.set(0, "Input Quantity");
                    tf_contact_no10.grabFocus();
                    return;
                }
                double selling_price = FitIn.toDouble(tf_contact_no11.getText());
                String date_added = DateType.now();
                String user_name = MyUser.getUser_name();
                String category = item.category;
                String category_id = item.category_id;
                String classification = item.classification;
                String classification_id = item.classification_id;
                String sub_classification = item.sub_classification;
                String sub_classification_id = item.sub_classification_id;
                String unit = item.unit;
                double conversion = item.conversion;
                String item_type = item.item_type;
                int status = item.status;
                String supplier = item.supplier;
                int fixed_price = item.fixed_price;
                String supplier_id = item.supplier;
                int multi_level_pricing = item.multi_level_pricing;
                int vatable = item.vatable;
                double reorder_level = item.reorder_level;
                double markup = item.markup;
                String brand = item.brand;
                String brand_id = item.brand_id;
                String model = item.model;
                String model_id = item.model_id;
                String selling_type = "" + item.selling_type;
                String branch = item.branch;
                String branch_code = item.branch_code;
                String location = item.location;
                String location_id = item.location_id;
                String serial_no = "";
                String user_id = MyUser.getUser_id();
                String user_screen_name = MyUser.getUser_screen_name();
                My_services_item_replacements_customers.to_my_services_item_replacements_customers replacement = new to_my_services_item_replacements_customers(id, transaction_no, customer_id, customer_name, item_code, barcode, description, qty, selling_price, date_added, user_name, category, category_id, classification, classification_id, sub_classification, sub_classification_id, unit, conversion, item_type, status, supplier, fixed_price, supplier_id, multi_level_pricing, vatable, reorder_level, markup, brand, brand_id, model, model_id, selling_type, branch, branch_code, location, location_id, serial_no, user_id, user_screen_name);
                tbl_my_services_item_replacements_customers_ALM.add(replacement);
            } else {

                My_services.to_my_services service = (My_services.to_my_services) tbl_my_services_ALM.get(row2);
                int id = 0;
                String transaction_no = service.transaction_no;
                String customer_id = service.customer_id;
                String customer_name = service.customer_name;
                String item_code = tf_contact_no7.getText();
                String barcode = tf_contact_no9.getText();
                String description = tf_contact_no8.getText();
                double qty = FitIn.toDouble(tf_contact_no10.getText());
                if (qty <= 0) {
                    Alert.set(0, "Input Quantity");
                    tf_contact_no10.grabFocus();
                    return;
                }
                double selling_price = FitIn.toDouble(tf_contact_no11.getText());
                String date_added = DateType.now();
                String user_name = service.added_by;
                String category = item.category;
                String category_id = item.category_id;
                String classification = item.classification;
                String classification_id = item.classification_id;
                String sub_classification = item.sub_classification;
                String sub_classification_id = item.sub_classification_id;
                String unit = item.unit;
                double conversion = item.conversion;
                String item_type = item.item_type;
                int status = item.status;
                String supplier = item.supplier;
                int fixed_price = item.fixed_price;
                String supplier_id = item.supplier;
                int multi_level_pricing = item.multi_level_pricing;
                int vatable = item.vatable;
                double reorder_level = item.reorder_level;
                double markup = item.markup;
                String brand = item.brand;
                String brand_id = item.brand_id;
                String model = item.model;
                String model_id = item.model_id;
                String selling_type = "" + item.selling_type;
                String branch = item.branch;
                String branch_code = item.branch_code;
                String location = item.location;
                String location_id = item.location_id;
                String serial_no = "";
                String user_id = service.user_id;
                String user_screen_name = service.user_screen_name;
                My_services_item_replacements_customers.to_my_services_item_replacements_customers replacement = new to_my_services_item_replacements_customers(id, transaction_no, customer_id, customer_name, item_code, barcode, description, qty, selling_price, date_added, user_name, category, category_id, classification, classification_id, sub_classification, sub_classification_id, unit, conversion, item_type, status, supplier, fixed_price, supplier_id, multi_level_pricing, vatable, reorder_level, markup, brand, brand_id, model, model_id, selling_type, branch, branch_code, location, location_id, serial_no, user_id, user_screen_name);

                List<My_services_item_replacements_customers.to_my_services_item_replacements_customers> datas = new ArrayList();
                datas.add(replacement);
                My_services_item_replacements_customers.add_data(datas);
                ret_my_services_item_replacements_customers();
                Alert.set(1, "");
            }
            new_my_services_item_replacements_customers();
        } else {
            My_services_item_replacements_customers.to_my_services_item_replacements_customers replacement = (My_services_item_replacements_customers.to_my_services_item_replacements_customers) tbl_my_services_item_replacements_customers_ALM.get(row);
            if (replacement.id == 0) {
                String item_code = tf_contact_no7.getText();
                String barcode = tf_contact_no9.getText();
                String description = tf_contact_no8.getText();
                double qty = FitIn.toDouble(tf_contact_no10.getText());
                if (qty <= 0) {
                    Alert.set(0, "Input Quantity");
                    tf_contact_no10.grabFocus();
                    return;
                }
                double selling_price = FitIn.toDouble(tf_contact_no11.getText());
                replacement.setBarcode(barcode);
                replacement.setDescription(description);
                replacement.setItem_code(item_code);
                replacement.setQty(qty);
                replacement.setSelling_price(selling_price);
                tbl_my_services_item_replacements_customers_M.fireTableDataChanged();
            } else {
                if (my_account_control == 2 || my_account_control == 3) {
                    return;
                }
                int id = replacement.id;
                String transaction_no = replacement.transaction_no;
                String customer_id = replacement.customer_id;
                String customer_name = replacement.customer_name;
                String item_code = tf_contact_no7.getText();
                String barcode = tf_contact_no9.getText();
                String description = tf_contact_no8.getText();
                double qty = FitIn.toDouble(tf_contact_no10.getText());
                if (qty <= 0) {
                    Alert.set(0, "Input Quantity");
                    tf_contact_no10.grabFocus();
                    return;
                }
                double selling_price = FitIn.toDouble(tf_contact_no11.getText());
                String date_added = replacement.date_added;
                String user_name = replacement.user_name;
                String category = replacement.category;
                String category_id = replacement.category_id;
                String classification = replacement.classification;
                String classification_id = replacement.classification_id;
                String sub_classification = replacement.sub_classification;
                String sub_classification_id = replacement.sub_classification_id;
                String unit = replacement.unit;
                double conversion = replacement.conversion;
                String item_type = replacement.item_type;
                int status = replacement.status;
                String supplier = replacement.supplier;
                int fixed_price = replacement.fixed_price;
                String supplier_id = replacement.supplier;
                int multi_level_pricing = replacement.multi_level_pricing;
                int vatable = replacement.vatable;
                double reorder_level = replacement.reorder_level;
                double markup = replacement.markup;
                String brand = replacement.brand;
                String brand_id = replacement.brand_id;
                String model = replacement.model;
                String model_id = replacement.model_id;
                String selling_type = replacement.selling_type;
                String branch = replacement.branch;
                String branch_code = replacement.branch_code;
                String location = replacement.location;
                String location_id = replacement.location_id;
                String serial_no = replacement.serial_no;
                String user_id = replacement.user_id;
                String user_screen_name = replacement.user_screen_name;
                My_services_item_replacements_customers.to_my_services_item_replacements_customers replacement2 = new to_my_services_item_replacements_customers(id, transaction_no, customer_id, customer_name, item_code, barcode, description, qty, selling_price, date_added, user_name, category, category_id, classification, classification_id, sub_classification, sub_classification_id, unit, conversion, item_type, status, supplier, fixed_price, supplier_id, multi_level_pricing, vatable, reorder_level, markup, brand, brand_id, model, model_id, selling_type, branch, branch_code, location, location_id, serial_no, user_id, user_screen_name);

                My_services_item_replacements_customers.update_data(replacement2);
                ret_my_services_item_replacements_customers();
                Alert.set(2, "");
            }
            new_my_services_item_replacements_customers();
        }
    }

    private void select_my_services_item_replacements_customers() {
        int row = tbl_my_services_item_replacements_customers.getSelectedRow();
        if (row < 0) {
            return;
        }
        final My_services_item_replacements_customers.to_my_services_item_replacements_customers replacement = (My_services_item_replacements_customers.to_my_services_item_replacements_customers) tbl_my_services_item_replacements_customers_ALM.get(row);

        int col = tbl_my_services_item_replacements_customers.getSelectedColumn();
        if (col == 4) {
            tf_contact_no7.setText(replacement.item_code);
            tf_contact_no9.setText(replacement.barcode);
            tf_contact_no8.setText(replacement.description);
            tf_contact_no10.setText(FitIn.fmt_woc(replacement.qty));
            tf_contact_no11.setText(FitIn.fmt_wc_0(replacement.selling_price));
        }
        if (col == 5) {
            if (replacement.id == 0) {
                tbl_my_services_item_replacements_customers_ALM.remove(row);
                tbl_my_services_item_replacements_customers_M.fireTableDataChanged();
                new_my_services_item_replacements_customers();
            } else {
                Window p = (Window) this;
                Dlg_confirm_action nd = Dlg_confirm_action.create(p, true);
                nd.setTitle("");

                nd.setCallback(new Dlg_confirm_action.Callback() {

                    @Override
                    public void ok(CloseDialog closeDialog, Dlg_confirm_action.OutputData data) {
                        closeDialog.ok();
                        My_services_item_replacements_customers.delete_my_services_item_replacements_customers("" + replacement.id);
                        ret_my_services_item_replacements_customers();
                        Alert.set(3, "");
                        new_my_services_item_replacements_customers();
                    }
                });
                nd.setLocationRelativeTo(jTabbedPane1);
                nd.setVisible(true);
            }
        }
    }

    private void new_my_services_item_replacements_customers() {
        item_selected = -1;
        tf_contact_no7.setText("");
        tf_contact_no9.setText("");
        tf_contact_no8.setText("");
        tf_contact_no10.setText("");
        tf_contact_no11.setText("");
        tbl_my_services_item_replacements_customers.clearSelection();
        tf_contact_no7.grabFocus();
    }
//</editor-fold> 
    //<editor-fold defaultstate="collapsed" desc=" my_services_others_customers "> 
    public static ArrayListModel tbl_my_services_others_customers_ALM;
    public static Tblmy_services_others_customersModel tbl_my_services_others_customers_M;

    public void init_tbl_my_services_others_customers(JTable tbl_my_services_others_customers) {
        tbl_my_services_others_customers_ALM = new ArrayListModel();
        tbl_my_services_others_customers_M = new Tblmy_services_others_customersModel(tbl_my_services_others_customers_ALM);
        tbl_my_services_others_customers.setModel(tbl_my_services_others_customers_M);
        tbl_my_services_others_customers.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_my_services_others_customers.setRowHeight(25);
        int update = 30;
        int delete = 30;
        if (my_account_control == 2 || my_account_control == 3) {
            update = 0;
            delete = 0;
        }
        if (my_account_control == 4) {
            update = 30;
            delete = 0;
        }

        int[] tbl_widths_my_services_others_customers = {30, 100, 70, update, delete, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_my_services_others_customers.length; i < n; i++) {
            if (i == 1) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_my_services_others_customers, i, tbl_widths_my_services_others_customers[i]);
        }
        Dimension d = tbl_my_services_others_customers.getTableHeader().getPreferredSize();
        d.height = 25;
        tbl_my_services_others_customers.getTableHeader().setPreferredSize(d);
        tbl_my_services_others_customers.getTableHeader().setFont(new java.awt.Font("Arial", 0, 12));
        tbl_my_services_others_customers.setRowHeight(25);
        tbl_my_services_others_customers.setFont(new java.awt.Font("Arial", 0, 12));
        tbl_my_services_others_customers.getColumnModel().getColumn(3).setCellRenderer(new ImageRenderer1());
        tbl_my_services_others_customers.getColumnModel().getColumn(4).setCellRenderer(new ImageRenderer1());
        TableWidthUtilities.setColumnRightRenderer(tbl_my_services_others_customers, 2);
    }

    public static void loadData_my_services_others_customers(List<to_my_services_others_customers> acc) {
        tbl_my_services_others_customers_ALM.clear();
        tbl_my_services_others_customers_ALM.addAll(acc);
    }

    public static class Tblmy_services_others_customersModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Qty", "Description", "Amount", "", "", "name", "amount", "qty", "branch", "branch_id", "location", "location_id"
        };

        public Tblmy_services_others_customersModel(ListModel listmodel) {
            super(listmodel, COLUMNS);
        }

        @Override
        public boolean isCellEditable(int row, int column) {
            if (column == 100) {
                return true;
            }
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
            to_my_services_others_customers tt = (to_my_services_others_customers) getRow(row);
            switch (col) {
                case 0:
                    return " " + FitIn.fmt_woc(tt.qty);
                case 1:
                    return " " + tt.name;
                case 2:
                    return FitIn.fmt_wc_0(tt.qty * tt.amount) + " ";
                case 3:
                    return "/servicing/icons/edit.png";
                case 4:
                    return "/servicing/icons/remove11.png";
                case 5:
                    return tt.name;
                case 6:
                    return tt.amount;
                case 7:
                    return tt.qty;
                case 8:
                    return tt.branch;
                case 9:
                    return tt.branch_id;
                case 10:
                    return tt.location;
                default:
                    return tt.location_id;
            }
        }
    }

    private void ret_my_services_others_customers() {
        int row = tbl_my_services.getSelectedRow();
        if (row < 0) {
            return;
        }

        My_services.to_my_services service = (My_services.to_my_services) tbl_my_services_ALM.get(row);
        String where = " where transaction_no='" + service.transaction_no + "' ";
        List<My_services_others_customers.to_my_services_others_customers> others = My_services_others_customers.ret_data2(where);
        loadData_my_services_others_customers(others);
    }

    //<editor-fold defaultstate="collapsed" desc=" combo ">
    List<S1_my_services_others.to_my_services_others> others_list = new ArrayList();

    private void init_others() {
        String search = tf_contact_no13.getText();
        others_list.clear();
        String where = " where name like '%" + search + "%' order by name asc ";
        others_list = S1_my_services_others.ret_data(where);
        Object[][] obj = new Object[others_list.size()][1];
        int i = 0;
        for (S1_my_services_others.to_my_services_others to : others_list) {
            obj[i][0] = " " + to.name;
            i++;
        }
        if (others_list.isEmpty()) {
            double am = FitIn.toDouble(tf_contact_no14.getText());
            S1_my_services_others.to_my_services_others to = new S1_my_services_others.to_my_services_others(0, search, am, 0);
            if (!search.isEmpty()) {
                S1_my_services_others.add_my_services_others(to);
                tf_contact_no12.grabFocus();
            }
        } else {
            JLabel[] labels = {};
            int[] tbl_widths_customers = {tf_contact_no13.getWidth()};

            String[] col_names = {""};
            TableRenderer tr = new TableRenderer();
            TableRenderer.setPopup(tf_contact_no13, obj, labels, tbl_widths_customers, col_names);
            tr.setCallback(new TableRenderer.Callback() {
                @Override
                public void ok(TableRenderer.OutputData data) {
                    S1_my_services_others.to_my_services_others to = others_list.get(data.selected_row);
                    tf_contact_no13.setText("" + to.name);
                    tf_contact_no12.grabFocus();
                }
            });
        }
    }

    //</editor-fold>
    private void save_my_services_others_customers() {
        int row = tbl_my_services_others_customers.getSelectedRow();
        if (row < 0) {
            int row2 = tbl_my_services.getSelectedRow();
            if (row2 < 0) {
                Field.Combo cust = (Field.Combo) tf_customer_name;
                int id = 0;
                String customer_id = cust.getId();
                String customer_name = cust.getText();
                String transaction_no = "";
                String date_added = DateType.now();
                String name = tf_contact_no13.getText();
                double amount = FitIn.toDouble(tf_contact_no14.getText());
                double qty = FitIn.toDouble(tf_contact_no12.getText());
                String branch = MyUser.getBranch();
                String branch_id = MyUser.getBranch_id();
                String location = MyUser.getLocation();
                String location_id = MyUser.getLocation_id();
                to_my_services_others_customers other = new to_my_services_others_customers(id, customer_id, customer_name, transaction_no, date_added, name, amount, qty, branch, branch_id, location, location_id);
                tbl_my_services_others_customers_ALM.add(other);
            } else {
                My_services.to_my_services service = (My_services.to_my_services) tbl_my_services_ALM.get(row2);
                int id = 0;
                String customer_id = service.customer_id;
                String customer_name = service.customer_name;
                String transaction_no = service.transaction_no;
                String date_added = DateType.now();
                String name = tf_contact_no13.getText();
                double amount = FitIn.toDouble(tf_contact_no14.getText());
                double qty = FitIn.toDouble(tf_contact_no12.getText());
                String branch = service.branch;
                String branch_id = service.branch_id;
                String location = service.location;
                String location_id = service.location_id;
                to_my_services_others_customers other = new to_my_services_others_customers(id, customer_id, customer_name, transaction_no, date_added, name, amount, qty, branch, branch_id, location, location_id);

                My_services_others_customers.add_my_services_others_customers(other);
                ret_my_services_others_customers();
                Alert.set(1, "");
            }
            new_my_services_others_customers();
        } else {
            to_my_services_others_customers other = (to_my_services_others_customers) tbl_my_services_others_customers_ALM.get(row);
            if (other.id == 0) {
                String name = tf_contact_no13.getText();
                double amount = FitIn.toDouble(tf_contact_no14.getText());
                double qty = FitIn.toDouble(tf_contact_no12.getText());
                other.setName(name);
                other.setAmount(amount);
                other.setQty(qty);
                tbl_my_services_others_customers_M.fireTableDataChanged();
            } else {
                if (my_account_control == 2 || my_account_control == 3) {
                    return;
                }
                int id = other.id;
                String customer_id = other.customer_id;
                String customer_name = other.customer_name;
                String transaction_no = other.transaction_no;
                String date_added = other.date_added;
                String name = tf_contact_no13.getText();
                double amount = FitIn.toDouble(tf_contact_no14.getText());
                double qty = FitIn.toDouble(tf_contact_no12.getText());
                String branch = other.branch;
                String branch_id = other.branch_id;
                String location = other.location;
                String location_id = other.location_id;
                to_my_services_others_customers other2 = new to_my_services_others_customers(id, customer_id, customer_name, transaction_no, date_added, name, amount, qty, branch, branch_id, location, location_id);
                My_services_others_customers.edit_my_services_others_customers(other2);
                ret_my_services_others_customers();
                Alert.set(2, "");

            }
            new_my_services_others_customers();
        }
    }

    private void select_my_services_others_customers() {
        int row = tbl_my_services_others_customers.getSelectedRow();
        if (row < 0) {
            return;
        }
        final to_my_services_others_customers other = (to_my_services_others_customers) tbl_my_services_others_customers_ALM.get(row);
        int col = tbl_my_services_others_customers.getSelectedColumn();
        if (col == 3) {
            tf_contact_no13.setText(other.name);
            tf_contact_no12.setText(FitIn.fmt_woc(other.qty));
            tf_contact_no14.setText(FitIn.fmt_wc_0(other.amount));
        }
        if (col == 4) {
            if (other.id == 0) {
                tbl_my_services_others_customers_ALM.remove(row);
                tbl_my_services_others_customers_M.fireTableDataChanged();
                new_my_services_others_customers();
            } else {
                Window p = (Window) this;
                Dlg_confirm_action nd = Dlg_confirm_action.create(p, true);
                nd.setTitle("");

                nd.setCallback(new Dlg_confirm_action.Callback() {

                    @Override
                    public void ok(CloseDialog closeDialog, Dlg_confirm_action.OutputData data) {
                        closeDialog.ok();
                        My_services_others_customers.delete_my_services_others_customers("" + other.id);
                        ret_my_services_others_customers();
                        Alert.set(3, "");
                        new_my_services_others_customers();
                    }
                });
                nd.setLocationRelativeTo(jTabbedPane1);
                nd.setVisible(true);
            }
        }
    }

    private void new_my_services_others_customers() {
        tf_contact_no13.setText("");
        tf_contact_no12.setText("");
        tf_contact_no14.setText("");
        tbl_my_services_others_customers.clearSelection();
        tf_contact_no13.grabFocus();
    }
//</editor-fold> 
    //<editor-fold defaultstate="collapsed" desc=" my_services_barcodes_customers "> 
    public static ArrayListModel tbl_my_services_barcodes_customers_ALM;
    public static Tblmy_services_barcodes_customersModel tbl_my_services_barcodes_customers_M;

    public void init_tbl_my_services_barcodes_customers(JTable tbl_my_services_barcodes_customers) {
        tbl_my_services_barcodes_customers_ALM = new ArrayListModel();
        tbl_my_services_barcodes_customers_M = new Tblmy_services_barcodes_customersModel(tbl_my_services_barcodes_customers_ALM);
        tbl_my_services_barcodes_customers.setModel(tbl_my_services_barcodes_customers_M);
        tbl_my_services_barcodes_customers.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_my_services_barcodes_customers.setRowHeight(25);
        int update = 30;
        int delete = 30;
        if (my_account_control == 2 || my_account_control == 3) {
            update = 0;
            delete = 0;
        }
        if (my_account_control == 4) {
            update = 30;
            delete = 0;
        }

        int[] tbl_widths_my_services_barcodes_customers = {100, update, delete, 30, 0, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_my_services_barcodes_customers.length; i < n; i++) {
            if (i == 0) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_my_services_barcodes_customers, i, tbl_widths_my_services_barcodes_customers[i]);
        }
        Dimension d = tbl_my_services_barcodes_customers.getTableHeader().getPreferredSize();
        d.height = 25;
        tbl_my_services_barcodes_customers.getTableHeader().setPreferredSize(d);
        tbl_my_services_barcodes_customers.getTableHeader().setFont(new java.awt.Font("Arial", 0, 12));
        tbl_my_services_barcodes_customers.setRowHeight(25);
        tbl_my_services_barcodes_customers.setFont(new java.awt.Font("Arial", 0, 12));
        tbl_my_services_barcodes_customers.getColumnModel().getColumn(1).setCellRenderer(new ImageRenderer1());
        tbl_my_services_barcodes_customers.getColumnModel().getColumn(2).setCellRenderer(new ImageRenderer1());
    }

    public static void loadData_my_services_barcodes_customers(List<to_my_services_barcodes_customers> acc) {
        tbl_my_services_barcodes_customers_ALM.clear();
        tbl_my_services_barcodes_customers_ALM.addAll(acc);
    }

    public static class Tblmy_services_barcodes_customersModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Barcode", "", "", "", "date_added", "barcode", "branch", "branch_id", "location", "location_id"
        };

        public Tblmy_services_barcodes_customersModel(ListModel listmodel) {
            super(listmodel, COLUMNS);
        }

        @Override
        public boolean isCellEditable(int row, int column) {
            if (column == 100) {
                return true;
            }
            return false;
        }

        @Override
        public Class getColumnClass(int col) {
            if (col == 3) {
                return Boolean.class;
            }
            return Object.class;
        }

        @Override
        public Object getValueAt(int row, int col) {
            to_my_services_barcodes_customers tt = (to_my_services_barcodes_customers) getRow(row);
            switch (col) {
                case 0:
                    return " " + tt.barcode;
                case 1:
                    return "/servicing/icons/edit.png";
                case 2:
                    return "/servicing/icons/remove11.png";
                case 3:
                    return tt.selected;
                case 4:
                    return tt.date_added;
                case 5:
                    return tt.barcode;
                case 6:
                    return tt.branch;
                case 7:
                    return tt.branch_id;
                case 8:
                    return tt.location;
                default:
                    return tt.location_id;
            }
        }
    }

    private void ret_my_services_barcodes_customers() {
        int row = tbl_my_services.getSelectedRow();
        if (row < 0) {
            return;
        }
        My_services.to_my_services service = (My_services.to_my_services) tbl_my_services_ALM.get(row);
        String where = " where transaction_no='" + service.transaction_no + "' ";
        List<My_services_barcodes_customers.to_my_services_barcodes_customers> barcode = My_services_barcodes_customers.ret_data(where);
        loadData_my_services_barcodes_customers(barcode);
    }

    private void save_my_services_barcodes_customers() {
        int row = tbl_my_services.getSelectedRow();
        if (row < 0) {
            Alert.set(0, "Select Transaction!");
            return;
        }
        My_services.to_my_services service = (My_services.to_my_services) tbl_my_services_ALM.get(row);
        int id = 0;
        String customer_id = service.customer_id;
        String customer_name = service.customer_name;
        String transaction_no = service.transaction_no;
        String date_added = DateType.now();
        String barcode = tf_contact_no15.getText();
        if (barcode.isEmpty()) {
            return;
        }
        String where = " where barcode='" + barcode + "' ";
        List<My_services_barcodes_customers.to_my_services_barcodes_customers> datas = My_services_barcodes_customers.ret_data(where);
        if (!datas.isEmpty()) {
            Alert.set(0, "Barcode already exists!");
            return;
        }
        String branch = service.branch;
        String branch_id = service.branch_id;
        String location = service.location;
        String location_id = service.location_id;
        to_my_services_barcodes_customers barcode1 = new to_my_services_barcodes_customers(id, customer_id, customer_name, transaction_no, date_added, barcode, branch, branch_id, location, location_id, true);
        My_services_barcodes_customers.add_data(barcode1);
        ret_my_services_barcodes_customers();
        Alert.set(1, "");
    }

    private void select_my_services_barcodes_customers() {
        int row = tbl_my_services_barcodes_customers.getSelectedRow();
        if (row < 0) {
            return;
        }
        final to_my_services_barcodes_customers barcode = (to_my_services_barcodes_customers) tbl_my_services_barcodes_customers_ALM.get(row);
        int col = tbl_my_services_barcodes_customers.getSelectedColumn();
        if (col == 3) {
            if (barcode.selected == true) {
                barcode.setSelected(false);
            } else {
                barcode.setSelected(true);
            }
            tbl_my_services_barcodes_customers_M.fireTableDataChanged();
        }
        if (col == 2) {
            Window p = (Window) this;
            Dlg_confirm_action nd = Dlg_confirm_action.create(p, true);
            nd.setTitle("");

            nd.setCallback(new Dlg_confirm_action.Callback() {

                @Override
                public void ok(CloseDialog closeDialog, Dlg_confirm_action.OutputData data) {
                    closeDialog.ok();
                    My_services_barcodes_customers.delete_data(barcode);
                    ret_my_services_barcodes_customers();
                    Alert.set(3, "");
                }
            });
            nd.setLocationRelativeTo(jTabbedPane1);
            nd.setVisible(true);
        }
    }

    private void new_my_services_barcodes_customers() {
        String barcode = My_services_barcodes_customers.increment_id();
        tf_contact_no15.setText(barcode);
    }
//</editor-fold> 

    private void print_barcodes() {
        List<to_my_services_barcodes_customers> barcodes = tbl_my_services_barcodes_customers_ALM;
        List<String> codes = new ArrayList();
        for (to_my_services_barcodes_customers to : barcodes) {
            if (to.selected == true) {
                codes.add(to.barcode);
            }
        }
        Window p = (Window) this;
        Dlg_my_services_print_barcodes nd = Dlg_my_services_print_barcodes.create(p, true);
        nd.setTitle("");
        nd.do_pass(codes);
        nd.setCallback(new Dlg_my_services_print_barcodes.Callback() {
            @Override
            public void ok(CloseDialog closeDialog, Dlg_my_services_print_barcodes.OutputData data) {
                closeDialog.ok();
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }

    List<S1_branch_locations.to_branch_locations> branch_location_list3 = new ArrayList();

    private void init_branch_locations() {
        if (!tf_to_branch.isEnabled()) {
            return;
        }
        Object[][] obj = new Object[branch_location_list3.size()][2];
        int i = 0;
        for (S1_branch_locations.to_branch_locations to : branch_location_list3) {
            obj[i][0] = " " + to.branch;
            obj[i][1] = " " + to.location;
            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {120, 90};
        int width = 0;
        String[] col_names = {"Branch", "Location"};
        TableRenderer tr = new TableRenderer();
        TableRenderer.setPopup(tf_to_branch, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                S1_branch_locations.to_branch_locations to = branch_location_list3.get(data.selected_row);
                Field.Combo br = (Field.Combo) tf_to_branch;

                br.setText("" + to.branch);
                br.setId("" + to.branch_id);

            }
        });
    }

    List<S1_branch_locations.to_branch_locations> branch_location_list = new ArrayList();

    private void init_branch_locations2() {

        Field.Combo br = (Field.Combo) tf_to_branch;
        Field.Combo loc = (Field.Combo) tf_to_location;

        branch_location_list.clear();
        String where = " where branch_id='" + br.getId() + "' order by location asc ";
        branch_location_list = S1_branch_locations.ret_location_where(where);
        Object[][] obj = new Object[branch_location_list.size()][2];
        int i = 0;
        for (S1_branch_locations.to_branch_locations to : branch_location_list) {
            obj[i][0] = " " + to.id;
            obj[i][1] = " " + to.location;
            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {0, tf_to_location.getWidth()};
        int width = 0;
        String[] col_names = {"Code", "Location"};
        TableRenderer tr = new TableRenderer();
        TableRenderer.
                setPopup(tf_to_location, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                S1_branch_locations.to_branch_locations to = branch_location_list.
                        get(data.selected_row);

                loc.setText("" + to.location);
                loc.setId("" + to.id);
            }
        });
    }

}
