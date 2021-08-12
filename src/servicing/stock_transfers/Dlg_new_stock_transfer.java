/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicing.stock_transfers;

import servicing.branch_locations.S1_branch_locations;
import servicing.branch_locations.S4_branch_locations;
import servicing.branches.Branches;
import servicing.inventory.Dlg_inventory_cloud_transactions_local;
import servicing.inventory.Dlg_inventory_cloud_transactions_main;
import servicing.inventory.Dlg_inventory_uom;
import servicing.inventory.Inventory;
import servicing.inventory.Inventory_barcodes;
import servicing.inventory.S2_inventory_barcodes;
import servicing.inventory.uom;
import servicing.inventory_reports.Dlg_report_inventory_ledger;
import servicing.receipts.Stock_transfers_items;
import servicing.receipts.Stock_transfers_items.to_stock_transfers_items;
import servicing.stock_transfers.Stock_transfers.to_stock_transfers;
import servicing.synch.Synch_stock_transfers;
import servicing.users.MyUser;
import servicing.users.User_previlege_others;
import servicing.utils.Alert;
import servicing.utils.Button;
import servicing.utils.DateType;
import servicing.utils.Dlg_confirm_action;
import servicing.utils.Dlg_confirm_cloud;
import servicing.utils.Dlg_confirm_delete;
import servicing.utils.Focus_Fire;
import servicing.utils.MyConnection;
import servicing.utils.TableRenderer;
import servicing.utils.Users;
import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.InputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.FitIn;
import mijzcx.synapse.desk.utils.JasperUtil;
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;
import mijzcx.synapse.desk.utils.TableWidthUtilities;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.swing.JRViewer;
import servicing.branch_locations.Branch_locations;

import synsoftech.fields.Field;
import synsoftech.util.ImageRenderer;

/**
 *
 * @author Guinness
 */
public class Dlg_new_stock_transfer extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_new_stock_transfer
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
    private Dlg_new_stock_transfer(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_new_stock_transfer(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_new_stock_transfer() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_new_stock_transfer myRef;

    private void setThisRef(Dlg_new_stock_transfer myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_new_stock_transfer> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_new_stock_transfer create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_new_stock_transfer create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_new_stock_transfer dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_new_stock_transfer((java.awt.Frame) parent, false);
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
            Dlg_new_stock_transfer dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_new_stock_transfer((java.awt.Dialog) parent, false);
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

        Dlg_new_stock_transfer dialog = Dlg_new_stock_transfer.create(new javax.swing.JFrame(), true);
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

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        buttonGroup5 = new javax.swing.ButtonGroup();
        buttonGroup6 = new javax.swing.ButtonGroup();
        buttonGroup7 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tf_from_branch = new javax.swing.JTextField();
        tf_from_branch_id = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tf_from_location = new javax.swing.JTextField();
        tf_from_location_id = new javax.swing.JTextField();
        tf_to_location = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tf_to_location_id = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tf_to_branch_id = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        tf_to_branch = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tf_remarks = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_stock_transfers_items = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        tf_search = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jCheckBox6 = new javax.swing.JCheckBox();
        jCheckBox7 = new javax.swing.JCheckBox();
        jCheckBox8 = new javax.swing.JCheckBox();
        jCheckBox9 = new javax.swing.JCheckBox();
        jButton1 = new Button.Info();
        jButton5 = new Button.Primary();
        jButton6 = new Button.Default();
        jLabel33 = new javax.swing.JLabel();
        jDateChooser5 = new com.toedter.calendar.JDateChooser();
        jPanel18 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton7 = new Button.Success();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_stock_transfers = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel17 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jLabel11 = new javax.swing.JLabel();
        jButton2 = new Button.Default();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        tf_from_branch1 = new Field.Combo();
        tf_from_location1 = new Field.Combo();
        jLabel20 = new javax.swing.JLabel();
        jCheckBox5 = new javax.swing.JCheckBox();
        jCheckBox10 = new javax.swing.JCheckBox();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jCheckBox11 = new javax.swing.JCheckBox();
        tf_from_location2 = new Field.Combo();
        tf_from_branch2 = new Field.Combo();
        jCheckBox12 = new javax.swing.JCheckBox();
        jCheckBox21 = new javax.swing.JCheckBox();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jProgressBar2 = new javax.swing.JProgressBar();
        jPanel14 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jCheckBox13 = new javax.swing.JCheckBox();
        jButton3 = new Button.Default();
        jCheckBox14 = new javax.swing.JCheckBox();
        jCheckBox15 = new javax.swing.JCheckBox();
        jLabel24 = new javax.swing.JLabel();
        jCheckBox16 = new javax.swing.JCheckBox();
        jLabel25 = new javax.swing.JLabel();
        jCheckBox17 = new javax.swing.JCheckBox();
        jCheckBox18 = new javax.swing.JCheckBox();
        jCheckBox19 = new javax.swing.JCheckBox();
        tf_from_location3 = new Field.Combo();
        jLabel27 = new javax.swing.JLabel();
        tf_from_branch3 = new Field.Combo();
        jLabel28 = new javax.swing.JLabel();
        jCheckBox20 = new javax.swing.JCheckBox();
        jLabel29 = new javax.swing.JLabel();
        tf_from_branch4 = new Field.Combo();
        jDateChooser3 = new com.toedter.calendar.JDateChooser();
        tf_from_location4 = new Field.Combo();
        jDateChooser4 = new com.toedter.calendar.JDateChooser();
        jLabel31 = new javax.swing.JLabel();
        jCheckBox22 = new javax.swing.JCheckBox();
        jLabel34 = new javax.swing.JLabel();
        jCheckBox23 = new javax.swing.JCheckBox();
        jCheckBox24 = new javax.swing.JCheckBox();
        jLabel35 = new javax.swing.JLabel();
        jCheckBox25 = new javax.swing.JCheckBox();
        jCheckBox26 = new javax.swing.JCheckBox();
        jCheckBox27 = new javax.swing.JCheckBox();
        jLabel37 = new javax.swing.JLabel();
        jCheckBox28 = new javax.swing.JCheckBox();
        jCheckBox29 = new javax.swing.JCheckBox();
        jCheckBox30 = new javax.swing.JCheckBox();
        jCheckBox31 = new javax.swing.JCheckBox();
        jLabel36 = new javax.swing.JLabel();
        tf_search1 = new Field.Search();
        jPanel16 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        jProgressBar3 = new javax.swing.JProgressBar();
        jPanel13 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img/transactions.png"))); // NOI18N
        jMenuItem1.setText("Finalize Stock Transfer");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img/sales_orders.png"))); // NOI18N
        jMenuItem2.setText("Create Patch File");
        jPopupMenu1.add(jMenuItem2);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Trans #:");

        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("From:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Branch:");

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

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Location:");

        tf_from_location.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_from_location.setFocusable(false);
        tf_from_location.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_from_locationActionPerformed(evt);
            }
        });

        tf_from_location_id.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_from_location_id.setFocusable(false);

        tf_to_location.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_to_location.setFocusable(false);
        tf_to_location.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_to_locationActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Branch:");

        tf_to_location_id.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_to_location_id.setFocusable(false);
        tf_to_location_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_to_location_idActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("To:");

        tf_to_branch_id.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_to_branch_id.setFocusable(false);
        tf_to_branch_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_to_branch_idActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Location:");

        tf_to_branch.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
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

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Remarks:");

        tf_remarks.setColumns(20);
        tf_remarks.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_remarks.setLineWrap(true);
        tf_remarks.setRows(5);
        jScrollPane2.setViewportView(tf_remarks);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        tbl_stock_transfers_items.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_stock_transfers_items.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_stock_transfers_itemsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_stock_transfers_items);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Search:");

        tf_search.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_searchActionPerformed(evt);
            }
        });

        jLabel14.setText("Total Transactions:");

        jLabel15.setText("0");

        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel30.setText("Filter by:");

        jCheckBox6.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup2.add(jCheckBox6);
        jCheckBox6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox6.setSelected(true);
        jCheckBox6.setText("[F1]-All");
        jCheckBox6.setFocusable(false);

        jCheckBox7.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup2.add(jCheckBox7);
        jCheckBox7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox7.setText("[F2]-Item Code");
        jCheckBox7.setFocusable(false);

        jCheckBox8.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup2.add(jCheckBox8);
        jCheckBox8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox8.setText("[F3]-Barcode");
        jCheckBox8.setFocusable(false);

        jCheckBox9.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup2.add(jCheckBox9);
        jCheckBox9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox9.setText("[F4]-Description");
        jCheckBox9.setFocusable(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 945, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_search))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCheckBox6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCheckBox7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCheckBox8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCheckBox9)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox6)
                    .addComponent(jCheckBox7)
                    .addComponent(jCheckBox8)
                    .addComponent(jCheckBox9))
                .addGap(1, 1, 1)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tf_search, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15))
                .addGap(10, 10, 10))
        );

        jButton1.setText("Update Post");
        jButton1.setEnabled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton5.setText("Post");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("New Post");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel33.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel33.setText("Date:");

        jDateChooser5.setDate(new Date());
        jDateChooser5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jPanel18.setOpaque(false);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icons_menu_maintenance/cloud-computing.png"))); // NOI18N
        jButton4.setText("Cloud Transfers");
        jButton4.setFocusable(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icons_menu_maintenance/cloud-computing (1).png"))); // NOI18N
        jButton8.setText("Upload/Sync");
        jButton8.setFocusable(false);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icons_menu_maintenance/cloud-computing (2).png"))); // NOI18N
        jButton9.setText("Check Items");
        jButton9.setFocusable(false);
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icons_menu_maintenance/pendrive.png"))); // NOI18N
        jButton10.setText("Usb Transfers");
        jButton10.setFocusable(false);
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                    .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                .addComponent(jButton4)
                .addGap(2, 2, 2)
                .addComponent(jButton10)
                .addGap(2, 2, 2)
                .addComponent(jButton8)
                .addGap(2, 2, 2)
                .addComponent(jButton9))
        );

        jButton7.setText("Finalize");
        jButton7.setEnabled(false);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField2)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tf_from_location, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                                    .addComponent(tf_from_branch))
                                .addGap(0, 0, 0)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tf_from_location_id, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tf_from_branch_id, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2)))
                .addGap(39, 39, 39)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_to_location)
                            .addComponent(tf_to_branch))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tf_to_branch_id, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_to_location_id, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addComponent(jDateChooser5, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jDateChooser5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(5, 5, 5)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(tf_to_branch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(tf_to_branch_id, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(23, 23, 23)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(tf_from_branch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(tf_from_branch_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(4, 4, 4)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(1, 1, 1)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(tf_from_location, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(tf_from_location_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(tf_to_location, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(tf_to_location_id, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(jLabel9))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                                                .addComponent(jButton5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jButton6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                            .addComponent(jButton7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(2, 2, 2)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(2, 2, 2))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Stock Transfer", jPanel4);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        tbl_stock_transfers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_stock_transfers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_stock_transfersMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tbl_stock_transfersMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbl_stock_transfersMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbl_stock_transfersMouseReleased(evt);
            }
        });
        jScrollPane3.setViewportView(tbl_stock_transfers);

        jLabel12.setText("No. of Transactions:");

        jLabel13.setText("0");

        jProgressBar1.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        jProgressBar1.setString("");
        jProgressBar1.setStringPainted(true);

        jLabel17.setText("Status:");

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setText("Search:");

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(1, 1, 1)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 947, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12)
                        .addComponent(jLabel13)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10))
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Date From:");

        jDateChooser1.setDate(new Date());
        jDateChooser1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jDateChooser2.setDate(new Date());
        jDateChooser2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("To:");

        jButton2.setText("Search");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jCheckBox1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox1.setSelected(true);
        jCheckBox1.setText("All");

        buttonGroup1.add(jCheckBox2);
        jCheckBox2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox2.setText("All");

        buttonGroup1.add(jCheckBox3);
        jCheckBox3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox3.setSelected(true);
        jCheckBox3.setText("Posted");

        buttonGroup1.add(jCheckBox4);
        jCheckBox4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox4.setText("Finalized");

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setText("Status:");

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel19.setText("From Branch:");

        tf_from_branch1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_from_branch1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_from_branch1MouseClicked(evt);
            }
        });
        tf_from_branch1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_from_branch1ActionPerformed(evt);
            }
        });

        tf_from_location1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_from_location1.setFocusable(false);
        tf_from_location1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_from_location1ActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel20.setText("Location:");

        jCheckBox5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox5.setText("All");
        jCheckBox5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox5ActionPerformed(evt);
            }
        });

        jCheckBox10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox10.setSelected(true);
        jCheckBox10.setText("All");

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel21.setText("To Branch:");

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel22.setText("Location:");

        jCheckBox11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox11.setSelected(true);
        jCheckBox11.setText("All");

        tf_from_location2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_from_location2.setFocusable(false);
        tf_from_location2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_from_location2ActionPerformed(evt);
            }
        });

        tf_from_branch2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_from_branch2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_from_branch2MouseClicked(evt);
            }
        });
        tf_from_branch2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_from_branch2ActionPerformed(evt);
            }
        });

        jCheckBox12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox12.setText("All");

        buttonGroup1.add(jCheckBox21);
        jCheckBox21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox21.setText("Deleted");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox10))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox5)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tf_from_branch1, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
                            .addComponent(tf_from_location1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                            .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox11)
                            .addComponent(jCheckBox12, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_from_location2)
                            .addComponent(tf_from_branch2)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jCheckBox2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCheckBox3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCheckBox4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jCheckBox1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBox5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tf_from_branch1))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(tf_from_location1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jCheckBox10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBox12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tf_from_branch2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(tf_from_location2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jCheckBox11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addGap(1, 1, 1)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jCheckBox1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jDateChooser2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBox3)
                            .addComponent(jCheckBox4)
                            .addComponent(jCheckBox21)))
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Reports", jPanel5);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 967, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 575, Short.MAX_VALUE)
        );

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));

        jLabel26.setText("State:");

        jProgressBar2.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        jProgressBar2.setString("");
        jProgressBar2.setStringPainted(true);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jProgressBar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jProgressBar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(5, 5, 5))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(1, 1, 1)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Print Preview", jPanel8);

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel23.setText("To:");

        jCheckBox13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox13.setText("All");

        jButton3.setText("Search");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jCheckBox14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox14.setText("All");

        jCheckBox15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox15.setText("All");

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel24.setText("To Branch:");

        buttonGroup4.add(jCheckBox16);
        jCheckBox16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox16.setText("All");

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel25.setText("Location:");

        buttonGroup4.add(jCheckBox17);
        jCheckBox17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox17.setText("Posted");

        jCheckBox18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox18.setText("All");

        buttonGroup4.add(jCheckBox19);
        jCheckBox19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox19.setSelected(true);
        jCheckBox19.setText("Finalized");

        tf_from_location3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_from_location3.setFocusable(false);
        tf_from_location3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_from_location3ActionPerformed(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel27.setText("Status:");

        tf_from_branch3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_from_branch3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_from_branch3MouseClicked(evt);
            }
        });
        tf_from_branch3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_from_branch3ActionPerformed(evt);
            }
        });

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel28.setText("From Branch:");

        jCheckBox20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox20.setText("All");

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel29.setText("Date From:");

        tf_from_branch4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_from_branch4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_from_branch4MouseClicked(evt);
            }
        });
        tf_from_branch4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_from_branch4ActionPerformed(evt);
            }
        });

        jDateChooser3.setDate(new Date());
        jDateChooser3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        tf_from_location4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_from_location4.setFocusable(false);
        tf_from_location4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_from_location4ActionPerformed(evt);
            }
        });

        jDateChooser4.setDate(new Date());
        jDateChooser4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel31.setText("Location:");

        buttonGroup4.add(jCheckBox22);
        jCheckBox22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox22.setText("Deleted");

        jLabel34.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel34.setText("Print:");

        buttonGroup5.add(jCheckBox23);
        jCheckBox23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox23.setSelected(true);
        jCheckBox23.setText("Selling Price");

        buttonGroup5.add(jCheckBox24);
        jCheckBox24.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox24.setText("Cost");

        jLabel35.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel35.setText("Type:");

        buttonGroup6.add(jCheckBox25);
        jCheckBox25.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox25.setSelected(true);
        jCheckBox25.setText("All");

        buttonGroup6.add(jCheckBox26);
        jCheckBox26.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox26.setText("Donation");

        buttonGroup6.add(jCheckBox27);
        jCheckBox27.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox27.setText("Snacks");

        jLabel37.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel37.setText("Search Filter:");

        buttonGroup7.add(jCheckBox28);
        jCheckBox28.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox28.setSelected(true);
        jCheckBox28.setText("[F1]-All");

        buttonGroup7.add(jCheckBox29);
        jCheckBox29.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox29.setText("[F2]-Item Code");

        buttonGroup7.add(jCheckBox30);
        jCheckBox30.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox30.setText("[F3]-Barcode");

        buttonGroup7.add(jCheckBox31);
        jCheckBox31.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox31.setText("[F4]-Description");

        jLabel36.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel36.setText("Search:");

        tf_search1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_search1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_search1MouseClicked(evt);
            }
        });
        tf_search1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_search1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel15Layout.createSequentialGroup()
                                        .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jCheckBox14))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                                        .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jCheckBox13)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tf_from_branch4, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
                                    .addComponent(tf_from_location4)))
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel15Layout.createSequentialGroup()
                                        .addComponent(jCheckBox16)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jCheckBox17)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jCheckBox19)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jCheckBox22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel15Layout.createSequentialGroup()
                                        .addComponent(jCheckBox15)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel23)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jDateChooser4, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                            .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel15Layout.createSequentialGroup()
                            .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(tf_search1))
                        .addGroup(jPanel15Layout.createSequentialGroup()
                            .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jCheckBox28)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jCheckBox29)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jCheckBox30)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jCheckBox31, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox18)
                            .addComponent(jCheckBox20, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_from_location3)
                            .addComponent(tf_from_branch3)))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jCheckBox23)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox24))
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox25)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCheckBox26)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCheckBox27)))
                        .addGap(0, 209, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBox13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tf_from_branch4))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel31, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(tf_from_location4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jCheckBox14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBox20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tf_from_branch3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(tf_from_location3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jCheckBox18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jCheckBox15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jDateChooser3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jDateChooser4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jCheckBox25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jCheckBox26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jCheckBox27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jCheckBox23, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jCheckBox24))
                            .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jCheckBox16, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jCheckBox17)
                                .addComponent(jCheckBox19)
                                .addComponent(jCheckBox22)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBox28)
                            .addComponent(jCheckBox29)
                            .addComponent(jCheckBox30)
                            .addComponent(jCheckBox31))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_search1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 377, Short.MAX_VALUE)
        );

        jPanel17.setBackground(new java.awt.Color(255, 255, 255));

        jLabel32.setText("State:");

        jProgressBar3.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        jProgressBar3.setString("");
        jProgressBar3.setStringPainted(true);

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel32)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jProgressBar3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jProgressBar3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(5, 5, 5))
        );

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(1, 1, 1)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        jTabbedPane1.addTab("Item/s Transferred", jPanel14);

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 967, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Loading List", jPanel13);

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 967, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Item Ledger", jPanel10);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jTabbedPane1)
                .addGap(5, 5, 5))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jTabbedPane1)
                .addContainerGap())
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

    private void tf_from_branchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_from_branchActionPerformed
        init_branch_locations2();
    }//GEN-LAST:event_tf_from_branchActionPerformed

    private void tf_to_branchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_to_branchActionPerformed
        init_branch_locations3();
    }//GEN-LAST:event_tf_to_branchActionPerformed

    private void tf_from_locationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_from_locationActionPerformed
        init_branch_locations(tf_from_location, tf_from_location_id, tf_from_branch_id);
    }//GEN-LAST:event_tf_from_locationActionPerformed

    private void tf_to_locationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_to_locationActionPerformed
        init_branch_locations(tf_to_location, tf_to_location_id, tf_to_branch_id);
    }//GEN-LAST:event_tf_to_locationActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        add_stock_transfer();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void tf_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_searchActionPerformed
        init_inventory_barcodes();
    }//GEN-LAST:event_tf_searchActionPerformed

    private void tbl_stock_transfersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_stock_transfersMouseClicked
        select_stock_transfer(evt);
    }//GEN-LAST:event_tbl_stock_transfersMouseClicked

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed

        new_post();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        data_cols();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tbl_stock_transfers_itemsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_stock_transfers_itemsMouseClicked
        update_queue_items();
    }//GEN-LAST:event_tbl_stock_transfers_itemsMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        update_stock_transfer();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tbl_stock_transfersMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_stock_transfersMousePressed
        show_popup(evt);
    }//GEN-LAST:event_tbl_stock_transfersMousePressed

    private void tbl_stock_transfersMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_stock_transfersMouseReleased
        show_popup(evt);
    }//GEN-LAST:event_tbl_stock_transfersMouseReleased

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        finalize_transfer();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void tf_to_branch_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_to_branch_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_to_branch_idActionPerformed

    private void tf_to_location_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_to_location_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_to_location_idActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        init_receipts();
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void tf_from_branchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_from_branchMouseClicked
        init_branch_locations2();
    }//GEN-LAST:event_tf_from_branchMouseClicked

    private void tf_to_branchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_to_branchMouseClicked
        init_branch_locations3();
    }//GEN-LAST:event_tf_to_branchMouseClicked

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        finalize_transfer();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void tf_from_branch1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_from_branch1MouseClicked
        init_branch_locations4(tf_from_branch1, tf_from_location1);
    }//GEN-LAST:event_tf_from_branch1MouseClicked

    private void tf_from_branch1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_from_branch1ActionPerformed
        init_branch_locations4(tf_from_branch1, tf_from_location1);
    }//GEN-LAST:event_tf_from_branch1ActionPerformed

    private void tf_from_location1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_from_location1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_from_location1ActionPerformed

    private void tf_from_location2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_from_location2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_from_location2ActionPerformed

    private void tf_from_branch2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_from_branch2MouseClicked
        init_branch_locations4(tf_from_branch2, tf_from_location2);
    }//GEN-LAST:event_tf_from_branch2MouseClicked

    private void tf_from_branch2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_from_branch2ActionPerformed
        init_branch_locations4(tf_from_branch2, tf_from_location2);
    }//GEN-LAST:event_tf_from_branch2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        get_items_ordered();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void tf_from_location3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_from_location3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_from_location3ActionPerformed

    private void tf_from_branch3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_from_branch3MouseClicked
        init_branch_locations4(tf_from_branch3, tf_from_location3);
    }//GEN-LAST:event_tf_from_branch3MouseClicked

    private void tf_from_branch3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_from_branch3ActionPerformed
        init_branch_locations4(tf_from_branch3, tf_from_location3);
    }//GEN-LAST:event_tf_from_branch3ActionPerformed

    private void tf_from_branch4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_from_branch4MouseClicked
        init_branch_locations4(tf_from_branch4, tf_from_location4);
    }//GEN-LAST:event_tf_from_branch4MouseClicked

    private void tf_from_branch4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_from_branch4ActionPerformed
        init_branch_locations4(tf_from_branch4, tf_from_location4);
    }//GEN-LAST:event_tf_from_branch4ActionPerformed

    private void tf_from_location4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_from_location4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_from_location4ActionPerformed

    private void tbl_stock_transfersMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_stock_transfersMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_stock_transfersMouseEntered

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        cloud_transfers();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        check_for_synch();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        check_items();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jCheckBox5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox5ActionPerformed
        check_all_branches("from");
    }//GEN-LAST:event_jCheckBox5ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        usb_transfers();
    }//GEN-LAST:event_jButton10ActionPerformed

    private void tf_search1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_search1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_search1MouseClicked

    private void tf_search1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_search1ActionPerformed
        init_inventory_barcodes_items_transfered();
    }//GEN-LAST:event_tf_search1ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.ButtonGroup buttonGroup5;
    private javax.swing.ButtonGroup buttonGroup6;
    private javax.swing.ButtonGroup buttonGroup7;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
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
    private javax.swing.JCheckBox jCheckBox20;
    private javax.swing.JCheckBox jCheckBox21;
    private javax.swing.JCheckBox jCheckBox22;
    private javax.swing.JCheckBox jCheckBox23;
    private javax.swing.JCheckBox jCheckBox24;
    private javax.swing.JCheckBox jCheckBox25;
    private javax.swing.JCheckBox jCheckBox26;
    private javax.swing.JCheckBox jCheckBox27;
    private javax.swing.JCheckBox jCheckBox28;
    private javax.swing.JCheckBox jCheckBox29;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox30;
    private javax.swing.JCheckBox jCheckBox31;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JCheckBox jCheckBox7;
    private javax.swing.JCheckBox jCheckBox8;
    private javax.swing.JCheckBox jCheckBox9;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private com.toedter.calendar.JDateChooser jDateChooser3;
    private com.toedter.calendar.JDateChooser jDateChooser4;
    private com.toedter.calendar.JDateChooser jDateChooser5;
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
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JProgressBar jProgressBar2;
    private javax.swing.JProgressBar jProgressBar3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTable tbl_stock_transfers;
    private javax.swing.JTable tbl_stock_transfers_items;
    private javax.swing.JTextField tf_from_branch;
    private javax.swing.JTextField tf_from_branch1;
    private javax.swing.JTextField tf_from_branch2;
    private javax.swing.JTextField tf_from_branch3;
    private javax.swing.JTextField tf_from_branch4;
    private javax.swing.JTextField tf_from_branch_id;
    private javax.swing.JTextField tf_from_location;
    private javax.swing.JTextField tf_from_location1;
    private javax.swing.JTextField tf_from_location2;
    private javax.swing.JTextField tf_from_location3;
    private javax.swing.JTextField tf_from_location4;
    private javax.swing.JTextField tf_from_location_id;
    private javax.swing.JTextArea tf_remarks;
    private javax.swing.JTextField tf_search;
    private javax.swing.JTextField tf_search1;
    private javax.swing.JTextField tf_to_branch;
    private javax.swing.JTextField tf_to_branch_id;
    private javax.swing.JTextField tf_to_location;
    private javax.swing.JTextField tf_to_location_id;
    // End of variables declaration//GEN-END:variables
    private void myInit() {
//        [255,153,0]
//        System.setProperty("pool_db", "db_smis_dumaguete_angel_buns");
//        System.setProperty("pool_db", "db_smis_kabankalan_with_encoding");

//        System.setProperty("pool_db", "db_smis_dumaguete_refreshments_store");
//        System.setProperty("pool_db", "db_smis_dumaguete_refreshments_bodega");
//        System.setProperty("pool_db", "db_algorithm");
//        MyUser.setUser_id("1");
//        System.setProperty("pool_host", "192.168.1.51");
//        System.setProperty("main_branch", "true");
//        System.setProperty("active_branches", "10");
//        System.setProperty("cloud_host", "128.199.80.53"); 
//        System.setProperty("cloud_user", "smis2");
//        System.setProperty("cloud_password", "nopassword101");
//        System.setProperty("cloud_db", "db_algorithm_development");
//        System.setProperty("main_branch", "false");
//        System.setProperty("delete_stock_transfers_finalized", "true");
//        System.setProperty("pool_db", "db_algorithm");
//        System.setProperty("cloud_stock_transfer_insert", "true");
        init_key();
        focus();
        init_tbl_stock_transfers();
        jTextField2.grabFocus();
        set_default_branch();
        init_tbl_stock_transfers_items();
        tf_to_location.grabFocus();
        item_ledger();
        tf_from_branch_id.setVisible(false);
        tf_from_location_id.setVisible(false);
        tf_to_branch_id.setVisible(false);
        tf_to_location_id.setVisible(false);
        String where = " order by branch,location asc ";
        branch_location_list2 = S1_branch_locations.ret_location_where(where);
        branch_location_list3 = branch_location_list2;
        branch_location_list4 = branch_location_list3;

        String where3 = " where user_id='" + MyUser.getUser_id() + "' ";
        stock_transfer_privileges = Stock_transfer_privileges.ret_data(where3);

        init_no();
        tf_to_branch.grabFocus();

        String cloud_host = System.getProperty("cloud_host", "");
        if (!cloud_host.isEmpty()) {
            jButton4.setVisible(true);
            jButton8.setVisible(true);
//            jLabel38.setVisible(true);
//            jLabel37.setVisible(true);
//            ret_for_upload();
        } else {
            jButton4.setVisible(false);
            jButton8.setVisible(false);
//            jLabel38.setVisible(false);
//            jLabel37.setVisible(false);
        }
//        String main_branch = System.getProperty("main_branch", "false");
//        if (main_branch.equalsIgnoreCase("false")) {
////            check_items();
//        } else {
//            SwingUtilities.invokeLater(new Runnable() {
//                @Override
//                public void run() {
//                    check_for_upload();
//                }
//            });
//
//        }
    }

    String my_branch = "";
    String my_branch_id = "";
    String my_location = "";
    String my_location_id = "";

    String my_at_branch = "";
    String my_at_branch_id = "";
    String my_at_location = "";
    String my_at_location_id = "";
    static int show_cost = 1;
    static int hide_price = 0;
    List<Stock_transfer_privileges.to_stock_transfer_privileges> stock_transfer_privileges = new ArrayList();

    private void item_ledger() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                jPanel11.setLayout(new BorderLayout());
                Dlg_report_inventory_ledger dlg = new Dlg_report_inventory_ledger();
                jPanel11.add(dlg.getSurface());
            }
        });

    }

    private void set_default_branch() {
        S1_branch_locations.to_branch_locations to = S4_branch_locations.ret_data();
        tf_from_branch.setText(to.branch);
        tf_from_branch_id.setText(to.branch_id);
        tf_from_location.setText(to.location);
        tf_from_location_id.setText("" + to.id);

        my_branch = to.branch;
        my_branch_id = to.branch_id;
        my_location = to.location;
        my_location_id = "" + to.id;

        Field.Combo f_br = (Field.Combo) tf_from_branch1;
        Field.Combo f_lo = (Field.Combo) tf_from_location1;
        f_br.setText(to.branch);
        f_br.setId(to.branch_id);
        f_lo.setText(to.location);
        f_lo.setId("" + to.id);

        Field.Combo t_br = (Field.Combo) tf_from_branch2;
        Field.Combo t_lo = (Field.Combo) tf_from_location2;
        t_br.setText(to.branch);
        t_br.setId(to.branch_id);
        t_lo.setText(to.location);
        t_lo.setId("" + to.id);

        Field.Combo f_br2 = (Field.Combo) tf_from_branch4;
        Field.Combo f_lo2 = (Field.Combo) tf_from_location4;
        f_br2.setText(to.branch);
        f_br2.setId(to.branch_id);
        f_lo2.setText(to.location);
        f_lo2.setId("" + to.id);

        Field.Combo t_br2 = (Field.Combo) tf_from_branch3;
        Field.Combo t_lo2 = (Field.Combo) tf_from_location3;
        t_br2.setText(to.branch);
        t_br2.setId(to.branch_id);
        t_lo2.setText(to.location);
        t_lo2.setId("" + to.id);

        String wheree = " where user_id='" + MyUser.getUser_id() + "' and name like '" + "Stock Transfer - Show Cost - (Add)" + "' limit 1";
        List<User_previlege_others.to_user_previlege_others> datas = User_previlege_others.ret_data(wheree);
        if (datas.isEmpty()) {
            show_cost = 0;
        } else {
            show_cost = 1;
        }

        String wheree2 = " where user_id='" + MyUser.getUser_id() + "' and name like '" + "Stock Transfer - Hide Price - (Add)" + "' limit 1";
        List<User_previlege_others.to_user_previlege_others> datas2 = User_previlege_others.ret_data(wheree2);
        if (datas2.isEmpty()) {
            hide_price = 0;
        } else {
            hide_price = 1;
        }

    }

    List<Stock_transfers.to_stock_transfers> receipt_list = new ArrayList();

    private void init_receipts() {
        if (!jTextField2.isEnabled()) {
            return;
        }
        String search = jTextField2.getText();
        receipt_list.clear();
        String where = " where transaction_no like '%" + search + "%' order by id asc ";
        receipt_list = Stock_transfers.ret_data(where);
        Object[][] obj = new Object[receipt_list.size()][1];
        int i = 0;
        for (Stock_transfers.to_stock_transfers to : receipt_list) {
            obj[i][0] = " " + to.transaction_no;
            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {jTextField2.getWidth()};
        int width = 0;
        String[] col_names = {"Transaction #"};
        TableRenderer tr = new TableRenderer();
        TableRenderer.
                setPopup(jTextField2, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                Stock_transfers.to_stock_transfers to = receipt_list.
                        get(data.selected_row);
                Stock_transfers.to_stock_transfers t = receipt_list.get(data.selected_row);
                jTextField2.setText(t.transaction_no);
                jTextField2.setEnabled(false);
                select_transaction();
            }
        });

    }

    private void select_transaction() {
        String where2 = " where transaction_no='" + jTextField2.getText() + "' ";
        to_stock_transfers to = Stock_transfers.to(where2);
        String where = " where stock_transfer_id='" + to.transaction_no + "' order by description asc ";
        loadData_stock_transfers_items(Stock_transfers_items.ret_data(where));

        jLabel15.setText("" + tbl_stock_transfers_items_ALM.size());

        jTextField2.setText(to.transaction_no);
        tf_from_branch.setText(to.from_branch);
        tf_from_branch_id.setText(to.from_branch_id);
        tf_from_location.setText(to.from_location);
        tf_from_location_id.setText(to.from_location_id);

        tf_to_branch.setText(to.to_branch);
        tf_to_branch_id.setText(to.to_branch_id);
        tf_to_location.setText(to.to_location);
        tf_to_location_id.setText(to.to_location_id);
        tf_remarks.setText(to.remarks);

        jTextField2.setEnabled(true);
        jButton5.setEnabled(false);
        jButton1.setEnabled(true);
    }

    private void init_no() {
        jTextField2.setText(Stock_transfers.increment_id(my_branch_id));
    }

    List<S1_branch_locations.to_branch_locations> branch_location_list = new ArrayList();

    private void init_branch_locations(final JTextField tf1, final JTextField tf2, final JTextField tf3) {
        String branch_id = tf3.getText();
        branch_location_list.clear();
        String where = " where branch_id='" + tf3.getText() + "' and location like '%" + tf1.getText() + "%' ";
        branch_location_list = S1_branch_locations.ret_location_where(where);
        Object[][] obj = new Object[branch_location_list.size()][2];
        int i = 0;
        for (S1_branch_locations.to_branch_locations to : branch_location_list) {
            obj[i][0] = to.id;
            obj[i][1] = to.location;
            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {0, 200};
        int width = 0;
        String[] col_names = {"Code", "Location"};
        TableRenderer tr = new TableRenderer();
        TableRenderer.
                setPopup(tf1, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                S1_branch_locations.to_branch_locations to = branch_location_list.
                        get(data.selected_row);
                tf1.setText("" + to.location);
                tf2.setText("" + to.id);
            }
        });
    }

    List<S1_branch_locations.to_branch_locations> branch_location_list2 = new ArrayList();

    private void init_branch_locations2() {
        if (!tf_from_branch.isEnabled()) {
            return;
        }
        Object[][] obj = new Object[branch_location_list2.size()][2];
        int i = 0;
        for (S1_branch_locations.to_branch_locations to : branch_location_list2) {
            obj[i][0] = " " + to.branch;
            obj[i][1] = " " + to.location;
            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {120, 90};
        int width = 0;
        String[] col_names = {"Branch", "Location"};
        TableRenderer tr = new TableRenderer();
        TableRenderer.setPopup(tf_from_branch, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                S1_branch_locations.to_branch_locations to = branch_location_list2.get(data.selected_row);

                int add_transfer = 0;
                String to_location_id = tf_to_location_id.getText();
                if (tf_to_location.getText().isEmpty()) {
                    for (Stock_transfer_privileges.to_stock_transfer_privileges stp : stock_transfer_privileges) {
                        if (stp.from_location_id.equalsIgnoreCase("" + to.id) && stp.add_transfer == 1) {
                            add_transfer = 1;
                            break;
                        }
                    }
                } else {
                    for (Stock_transfer_privileges.to_stock_transfer_privileges stp : stock_transfer_privileges) {
                        if (stp.from_location_id.equalsIgnoreCase("" + to.id) && stp.to_location_id.equalsIgnoreCase(to_location_id) && stp.add_transfer == 1) {
                            add_transfer = 1;
                            break;
                        }
                    }
                }

                if (add_transfer == 1) {
                    tf_from_branch.setText("" + to.branch);
                    tf_from_branch_id.setText("" + to.branch_id);

                    tf_from_location.setText("" + to.location);
                    tf_from_location_id.setText("" + to.id);
                } else {
                    Alert.set(0, "Privilege to transfer this location not added!");
                }

            }
        });
    }

    List<S1_branch_locations.to_branch_locations> branch_location_list4 = new ArrayList();

    private void init_branch_locations4(JTextField b, JTextField l) {
        final Field.Combo br = (Field.Combo) b;
        final Field.Combo lo = (Field.Combo) l;
        Object[][] obj = new Object[branch_location_list4.size()][2];
        int i = 0;
        for (S1_branch_locations.to_branch_locations to : branch_location_list4) {
            obj[i][0] = " " + to.branch;
            obj[i][1] = " " + to.location;
            i++;
        }

        JLabel[] labels = {};
        int[] tbl_widths_customers = {120, 90};
        int width = 0;
        String[] col_names = {"Branch", "Location"};
        TableRenderer tr = new TableRenderer();
        TableRenderer.setPopup(b, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                S1_branch_locations.to_branch_locations to = branch_location_list4.get(data.selected_row);
                br.setText("" + to.branch);
                br.setId("" + to.branch_id);
                lo.setText("" + to.location);
                lo.setId("" + to.id);
            }
        });
    }

    List<S1_branch_locations.to_branch_locations> branch_location_list3 = new ArrayList();

    private void init_branch_locations3() {
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
                int add_transfer = 0;
                String from_location_id = tf_from_location_id.getText();
                for (Stock_transfer_privileges.to_stock_transfer_privileges stp : stock_transfer_privileges) {
                    if (stp.to_location_id.equalsIgnoreCase("" + to.id) && stp.from_location_id.equalsIgnoreCase(from_location_id) && stp.add_transfer == 1) {
                        add_transfer = 1;
                        break;
                    }
                }

                if (add_transfer == 1) {
                    tf_to_branch.setText("" + to.branch);
                    tf_to_branch_id.setText("" + to.branch_id);

                    tf_to_location.setText("" + to.location);
                    tf_to_location_id.setText("" + to.id);
                } else {
                    Alert.set(0, "Privilege to transfer this location not added!");
                }

            }
        });
    }

    List<Branches.to_branches> branches_list = new ArrayList();

    private void init_branches(final JTextField tf1, final JTextField tf2) {
        String search = tf1.getText();
        branches_list.clear();
        branches_list = Branches.ret_data3(search);
        Object[][] obj = new Object[branches_list.size()][2];
        int i = 0;
        for (Branches.to_branches to : branches_list) {
            obj[i][0] = to.id;
            obj[i][1] = to.branch;
            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {0, 200};
        int width = 0;
        String[] col_names = {"Code", "Branch"};
        TableRenderer tr = new TableRenderer();
        TableRenderer.setPopup(tf1, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                Branches.to_branches to = branches_list.
                        get(data.selected_row);
                tf1.setText(to.branch);
                tf2.setText("" + to.id);

            }
        });
    }

    private void focus() {
        JTextField[] tf = {jTextField2, tf_from_branch, tf_from_location, tf_to_branch, tf_to_location, tf_search, jTextField1};
        JTextArea[] area = {tf_remarks};
        Focus_Fire.onFocus_lostFocus(tf);
        Focus_Fire.select_all(tf);
        Focus_Fire.onFocus_lostFocus(area);
        Focus_Fire.select_all(area);
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
        KeyMapping.mapKeyWIFW(getSurface(),
                              KeyEvent.VK_CONTROL, new KeyAction() {
                          @Override
                          public void actionPerformed(ActionEvent e) {
                              jButton5.doClick();
                          }
                      });
        tf_search.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_F1) {
                    jCheckBox6.setSelected(true);
                }
                if (e.getKeyCode() == KeyEvent.VK_F2) {
                    jCheckBox7.setSelected(true);
                }
                if (e.getKeyCode() == KeyEvent.VK_F3) {
                    jCheckBox8.setSelected(true);
                }
                if (e.getKeyCode() == KeyEvent.VK_F4) {
                    jCheckBox9.setSelected(true);
                }
            }
        });
    }
    // </editor-fold>

    private ArrayListModel tbl_stock_transfers_ALM;
    private Tblstock_transfersModel tbl_stock_transfers_M;

    private void init_tbl_stock_transfers() {
        tbl_stock_transfers_ALM = new ArrayListModel();
        tbl_stock_transfers_M = new Tblstock_transfersModel(tbl_stock_transfers_ALM);
        tbl_stock_transfers.getTableHeader().setPreferredSize(new Dimension(100, 40));
        tbl_stock_transfers.setModel(tbl_stock_transfers_M);
        tbl_stock_transfers.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_stock_transfers.setRowHeight(25);
        int[] tbl_widths_stock_transfers = {70, 100, 150, 150, 100, 60, 50, 50, 50, 30, 0, 0, 0};
        for (int i = 0, n = tbl_widths_stock_transfers.length; i < n; i++) {
            if (i == 2 || i == 3) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_stock_transfers, i, tbl_widths_stock_transfers[i]);
        }
        Dimension d = tbl_stock_transfers.getTableHeader().getPreferredSize();
        d.height = 25;
        tbl_stock_transfers.getTableHeader().setPreferredSize(d);
        tbl_stock_transfers.getTableHeader().setFont(new java.awt.Font("Arial", 0, 12));
        tbl_stock_transfers.setRowHeight(25);
        tbl_stock_transfers.setFont(new java.awt.Font("Arial", 0, 12));
        tbl_stock_transfers.getColumnModel().getColumn(9).setCellRenderer(new ImageRenderer());
    }

    private void loadData_stock_transfers(List<to_stock_transfers> acc) {
        tbl_stock_transfers_ALM.clear();
        tbl_stock_transfers_ALM.addAll(acc);
    }

    public static class Tblstock_transfersModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Trans #", "Date", "From", "To", "Finalized by.", "Status", "", "", "", "", "", "", "from_location_id"
        };

        public Tblstock_transfersModel(ListModel listmodel) {
            super(listmodel, COLUMNS);
        }

        @Override
        public boolean isCellEditable(int row, int column) {

            return false;
        }

        @Override
        public Class getColumnClass(int col) {
            if (col == 10) {
                return Boolean.class;
            }
            return Object.class;
        }

        @Override
        public Object getValueAt(int row, int col) {
            to_stock_transfers tt = (to_stock_transfers) getRow(row);
            switch (col) {
                case 0:
                    return " " + tt.transaction_no;
                case 1:
                    return " " + DateType.convert_slash_datetime(tt.date_added);
                case 2:
                    return " " + tt.from_branch + " : " + tt.from_location;
                case 3:
                    return " " + tt.to_branch + " : " + tt.to_location;
                case 4:
                    if (tt.finalized_by == null) {
                        return " ";
                    } else {
                        return " " + tt.finalized_by;
                    }

                case 5:
                    if (tt.status == 0) {
                        return " Posted";
                    } else if (tt.status == 2) {
                        return " Deleted";
                    } else {
                        return " Finalized";
                    }
                case 6:
                    return " Update";
                case 7:
                    return " Delete";
                case 8:
                    return " Print";
                case 9:
                    if (tt.is_uploaded == 0) {
                        return "/POS/icons4/cloud-storage-uploading-option (3).png";
                    } else if (tt.is_uploaded == 2) {
                        return "/POS/icons4/cloud-storage-uploading-option (4).png";
                    } else if (tt.is_uploaded == 3) {
                        return "/POS/icons4/cloud-storage-uploading-option (6)";
                    } else if (tt.is_uploaded == 4) {
                        return "/POS/icons4/cloud-storage-uploading-option (5).png";
                    } else {
                        return "/POS/icons4/cloud-storage-uploading-option (2).png";
                    }
                case 10:
                    return " Print";
                case 11:
                    return tt.from_location;
                default:
                    return tt.from_location_id;
            }
        }
    }

    private void data_cols() {

        String date_from = DateType.sf.format(jDateChooser1.getDate());
        String date_to = DateType.sf.format(jDateChooser2.getDate());

        String where = " where remarks like '%" + "" + "%' ";

        if (!jCheckBox1.isSelected()) {
            where = where + " and Date(date_added) between '" + date_from + "' and '" + date_to + "' ";
        }
        if (jCheckBox3.isSelected()) {
            where = where + " and status=0 ";
        }
        if (jCheckBox4.isSelected()) {
            where = where + " and status=1 ";
        }
        if (jCheckBox21.isSelected()) {
            where = where + " and status=2 ";
        }
        Field.Combo f_br = (Field.Combo) tf_from_branch1;
        Field.Combo f_lo = (Field.Combo) tf_from_location1;
        Field.Combo t_br = (Field.Combo) tf_from_branch2;
        Field.Combo t_lo = (Field.Combo) tf_from_location2;

        if (!jCheckBox10.isSelected() && !jCheckBox5.isSelected()) {
            where = where + " and from_location_id='" + f_lo.getId() + "' ";
        }
        if (jCheckBox10.isSelected() && !jCheckBox5.isSelected()) {
            where = where + " and from_branch_id='" + f_br.getId() + "' ";
        }

        if (!jCheckBox11.isSelected() && !jCheckBox12.isSelected()) {
            where = where + " and to_location_id='" + t_lo.getId() + "' ";
        }
        if (jCheckBox11.isSelected() && !jCheckBox12.isSelected()) {
            where = where + " and to_branch_id='" + t_br.getId() + "' ";
        }
        where = where + " order by id desc,Date(date_added) desc ";
//        System.out.println(where);
        List<to_stock_transfers> transfers = Stock_transfers.ret_data(where);
        List<to_stock_transfers> filter_transfers = new ArrayList();

        for (to_stock_transfers transfer : transfers) {
            int exists = 0;
            for (Stock_transfer_privileges.to_stock_transfer_privileges priv : stock_transfer_privileges) {
                if ((priv.from_location_id.equalsIgnoreCase(transfer.from_location_id)) && (priv.to_location_id.equalsIgnoreCase(transfer.to_location_id)) && (priv.report_transfer == 1)) {
                    exists = 1;
                    break;
                }
            }
            if (exists == 1) {
                filter_transfers.add(transfer);
            }
        }

        loadData_stock_transfers(filter_transfers);
        int for_upload = 0;
        int waiting_for_finalization = 0;
        for (to_stock_transfers to : transfers) {
            if (to.is_uploaded == 0) {
                for_upload++;
            }
            if (to.status == 0 && to.is_uploaded == 1) {
                waiting_for_finalization++;
            }
        }
//        jLabel38.setText("" + (for_upload + waiting_for_finalization));

        jLabel13.setText("" + tbl_stock_transfers_ALM.size());
    }

    private void add_stock_transfer() {
        if (tf_to_location_id.getText().isEmpty()) {
            Alert.set(0, "Please select location to transfer!");
            return;
        }

        int id = 0;
        final String transaction_no = Stock_transfers.increment_id(my_branch_id);
        String user_name = Users.user_name;

        String date_added = DateType.sf.format(jDateChooser5.getDate());
        String time = DateType.time4.format(new Date());
        date_added = date_added + " " + time;
        String remarks = tf_remarks.getText();
        String to_branch = tf_to_branch.getText();
        String to_branch_id = tf_to_branch_id.getText();
        String to_location = tf_to_location.getText();
        String to_location_id = tf_to_location_id.getText();

        String from_branch = tf_from_branch.getText();
        String from_branch_id = tf_from_branch_id.getText();
        String from_location = tf_from_location.getText();
        String from_location_id = tf_from_location_id.getText();

        String at_branch = my_branch;
        String at_branch_id = my_branch_id;
        String at_location = my_location;
        String at_location_id = my_location_id;
        int is_uploaded = 0;
        String finalized_by_id = MyUser.getUser_id();
        String finalized_by = MyUser.getUser_screen_name();

        final Stock_transfers.to_stock_transfers rpt = new to_stock_transfers(id, transaction_no, user_name, date_added, remarks, to_branch, to_branch_id, to_location,
                                                                              to_location_id, from_branch, from_branch_id, from_location, from_location_id, 0, false, at_branch, at_branch_id, at_location, at_location_id,
                                                                              is_uploaded, finalized_by_id, finalized_by);
        Window p = (Window) this;
        Dlg_confirm_action nd = Dlg_confirm_action.create(p, true);
        nd.setTitle("");
        nd.do_pass("Are you sure you want to post this transaction?");
        nd.setCallback(new Dlg_confirm_action.Callback() {
            @Override
            public void ok(CloseDialog closeDialog, Dlg_confirm_action.OutputData data) {
                closeDialog.ok();

                List<Stock_transfers_items.to_stock_transfers_items> datas = tbl_stock_transfers_items_ALM;
                Stock_transfers.add_stock_transfers(rpt, datas);

                data_cols();
                new_post();
                Alert.set(1, "");

            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);

    }

    private void upload_transction_to_cloud(final String transaction_no, final String at_location_id, final to_stock_transfers to) {
        if (to.status == 1 && to.is_uploaded == 1) {
            Alert.set(0, "Transaction already Uploaded and Finalized");

        } else if (to.status == 2) {
            Alert.set(0, "Transaction Deleted!");
        } else if (to.status == 0 && to.is_uploaded == 1) {
            int connected = MyConnection.check_cloud_connection();
            if (connected == 0) {
                Alert.set(0, "Error Connecting to cloud server!");
            } else {
                jProgressBar1.setString("Loading...Please wait...");
                jProgressBar1.setIndeterminate(true);
                Thread t = new Thread(new Runnable() {

                    @Override
                    public void run() {
                        String where = " where transaction_no ='" + transaction_no + "' and at_location_id='" + at_location_id + "' ";
                        List<Stock_transfers.to_stock_transfers> stock_transfers = Stock_transfers.ret_data_cloud(where);
                        if (!stock_transfers.isEmpty()) {
                            Stock_transfers.to_stock_transfers st = (Stock_transfers.to_stock_transfers) stock_transfers.get(0);
                            List<Stock_transfers_items.to_stock_transfers_items> datas = tbl_stock_transfers_items_ALM;
                            if (st.status == 1 && st.is_uploaded == 1) {
                                confirm_finalize_cloud(to, datas);

                            } else {
                                Alert.set(0, "Transaction not yet finalized by the other branch");
                            }

                        }
                        jProgressBar1.setString("Finished...");
                        jProgressBar1.setIndeterminate(false);
                    }
                });
                t.start();
            }

        } else {
            Window p = (Window) this;
            Dlg_new_stock_transfer_upload_to_cloud nd = Dlg_new_stock_transfer_upload_to_cloud.create(p, true);
            nd.setTitle("");
            nd.do_pass(transaction_no);
            nd.setCallback(new Dlg_new_stock_transfer_upload_to_cloud.Callback() {
                @Override
                public void ok(CloseDialog closeDialog, Dlg_new_stock_transfer_upload_to_cloud.OutputData data) {
                    closeDialog.ok();
                    data_cols();
                }
            });
            nd.setLocationRelativeTo(this);
            nd.setVisible(true);
        }

    }

    private void confirm_finalize_cloud(final Stock_transfers.to_stock_transfers to, final List<Stock_transfers_items.to_stock_transfers_items> datas) {
        Window p = (Window) this;
        Dlg_confirm_action nd = Dlg_confirm_action.create(p, true);
        nd.setTitle("");
        nd.do_pass("Proceed Finalizing Transaction");
        nd.setCallback(new Dlg_confirm_action.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_confirm_action.OutputData data) {
                closeDialog.ok();
                String finalized_by_id = MyUser.getUser_id();
                String finalized_by = MyUser.getUser_screen_name();
                Stock_transfers.finalize(to, datas, finalized_by_id, finalized_by);
                Synch_stock_transfers.update_status_stock_transfer(to.transaction_no, 1);
                data_cols();
                Alert.set(0, "Stock Transfer Finalized");
                init_no();
                tf_remarks.setText("");
                jButton5.setEnabled(true);
                jButton1.setEnabled(false);
                jButton7.setEnabled(false);
                tf_to_branch.setText("");
                tf_to_branch_id.setText("");
                tf_to_location.setText("");
                tf_to_location_id.setText("");
                tbl_stock_transfers_items_ALM.clear();
                tbl_stock_transfers_items_M.fireTableDataChanged();
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);

    }

    private void update_stock_transfer() {
        final int row = tbl_stock_transfers.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_stock_transfers to = (to_stock_transfers) tbl_stock_transfers_ALM.get(tbl_stock_transfers.convertRowIndexToModel(row));
        if (to.status == 1) {
            Alert.set(0, "Transaction Already Finalized!");
            return;
        }
        if (to.status == 2) {
            Alert.set(0, "Stock Transfer Status [Deleted]!");
            return;
        }

        int id = to.id;
        String transaction_no = to.transaction_no;
        String user_name = to.user_name;
        String date_added = DateType.datetime.format(jDateChooser5.getDate());
        String remarks = tf_remarks.getText();
        String to_branch = to.to_branch;
        String to_branch_id = to.to_branch_id;
        String to_location = to.to_location;
        String to_location_id = to.to_location_id;
        String from_branch = to.from_branch;
        String from_branch_id = to.from_branch_id;
        String from_location = to.from_location;
        String from_location_id = to.from_location_id;
        String at_branch = to.at_branch;
        String at_branch_id = to.at_branch_id;
        String at_location = to.at_location;
        String at_location_id = to.at_location_id;
        int is_uploaded = to.status;
        int exists = 0;
        for (Stock_transfer_privileges.to_stock_transfer_privileges priv : stock_transfer_privileges) {
            if ((priv.from_location_id.equalsIgnoreCase(from_location_id)) && (priv.to_location_id.equalsIgnoreCase(to_location_id)) && (priv.edit_transfer == 1)) {
                exists = 1;
                break;
            }
        }
        if (exists == 0) {
            Alert.set(0, "Privilege to Update transfer to this location not added!");
            return;
        }
        String finalized_by_id = MyUser.getUser_id();
        String finalized_by = MyUser.getUser_screen_name();
        final Stock_transfers.to_stock_transfers rpt = new to_stock_transfers(id, transaction_no, user_name, date_added, remarks, to_branch, to_branch_id, to_location,
                                                                              to_location_id, from_branch, from_branch_id, from_location, from_location_id, 0, false, at_branch, at_branch_id, at_location, at_location_id,
                                                                              is_uploaded, finalized_by_id, finalized_by);
        Window p = (Window) this;
        Dlg_confirm_action nd = Dlg_confirm_action.create(p, true);
        nd.setTitle("");

        nd.setCallback(new Dlg_confirm_action.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_confirm_action.OutputData data) {
                closeDialog.ok();
                Stock_transfers.edit_stock_transfers2(rpt);
                data_cols();
                new_post();
                Alert.set(2, "");

//                String cloud_host = System.getProperty("cloud_host", "128.199.80.53");
//                if (!cloud_host.isEmpty()) {
//                    upload_update_transction_to_cloud(rpt);
//                }
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);

    }

    private void upload_update_transction_to_cloud(Stock_transfers.to_stock_transfers rpt) {
        Window p = (Window) this;
        Dlg_new_stock_transfer_upload_to_cloud nd = Dlg_new_stock_transfer_upload_to_cloud.create(p, true);
        nd.setTitle("");
        nd.do_update(rpt);
        nd.setCallback(new Dlg_new_stock_transfer_upload_to_cloud.Callback() {
            @Override
            public void ok(CloseDialog closeDialog, Dlg_new_stock_transfer_upload_to_cloud.OutputData data) {
                closeDialog.ok();

            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }

    private void delete_stock_transfer() {
//        final int row = tbl_stock_transfers.getSelectedRow();
//        if (row < 0) {
//            return;
//        }
//        int col = tbl_stock_transfers.getSelectedColumn();
//        final to_stock_transfers to = (to_stock_transfers) tbl_stock_transfers_ALM.get(tbl_stock_transfers.convertRowIndexToModel(row));
//        if (to.status == 1) {
//            Alert.set(0, "Cannot delete finalized transaction!");
//            return;
//        }
//        if (to.status == 2) {
//            Alert.set(0, "Stock Transfer Status [Deleted]!");
//            return;
//        }
//        Window p = (Window) this;
//        Dlg_confirm_action nd = Dlg_confirm_action.create(p, true);
//        nd.setTitle("");
//        nd.setCallback(new Dlg_confirm_action.Callback() {
//            @Override
//            public void ok(CloseDialog closeDialog, Dlg_confirm_action.OutputData data) {
//                closeDialog.ok();
//                Stock_transfers.delete_stock_transfers(to);
//                data_cols();
//                tbl_stock_transfers_items_ALM.clear();
//                tbl_stock_transfers_items_M.fireTableDataChanged();
//                tf_to_location.setText("");
//                tf_to_location_id.setText("");
//                tf_remarks.setText("");
//                init_no();
//                tf_to_location.grabFocus();
//                Alert.set(3, "");
//            }
//        });
//        nd.setLocationRelativeTo(this);
//        nd.setVisible(true);

    }

    List<Inventory_barcodes.to_inventory_barcodes> inventory_barcoders_list = new ArrayList();

    private void init_inventory_barcodes() {
        if (jButton7.getText().equalsIgnoreCase("Post and Finalize")) {
            Alert.set(0, "Editing Disabled!");
            return;
        }
        jProgressBar1.setString("Searching...");
        jProgressBar1.setIndeterminate(true);
        tf_search.setEnabled(false);
        Thread t = new Thread(new Runnable() {

            @Override
            public void run() {
                String search = tf_search.getText();
                String where = " where ";
                if (jCheckBox6.isSelected()) {
                    where = where + "  main_barcode like '" + search + "' and location_id='" + tf_from_location_id.getText() + "' "
                            + " or barcode='" + search + "' and location_id='" + tf_from_location_id.getText() + "' "
                            + " or description like '%" + search + "%' and location_id='" + tf_from_location_id.getText() + "' ";
                }
                if (jCheckBox7.isSelected()) {
                    where = where + " main_barcode like '" + search + "' and location_id='" + tf_from_location_id.getText() + "' "
                            + "  ";
                }
                if (jCheckBox8.isSelected()) {
                    where = where + "  "
                            + "  barcode='" + search + "' and location_id='" + tf_from_location_id.getText() + "' ";
                }
                if (jCheckBox9.isSelected()) {
                    where = where + "  description like '%" + search + "%' and location_id='" + tf_from_location_id.getText() + "' ";
                }
                where = where + " order by description asc ";
                inventory_barcoders_list.clear();
                inventory_barcoders_list = Inventory_barcodes.ret_where(where);
                if (inventory_barcoders_list.isEmpty()) {
                    Alert.set(0, "Item Not Found");
                    jProgressBar1.setString("Finished...");
                    jProgressBar1.setIndeterminate(false);
                    tf_search.setEnabled(true);
                    tf_search.grabFocus();
                }
                if (inventory_barcoders_list.size() == 1) {
                    Inventory_barcodes.to_inventory_barcodes t = inventory_barcoders_list.get(0);
                    add_item(t);
                    tf_search.setEnabled(true);
                    tf_search.grabFocus();
                }
                if (inventory_barcoders_list.size() > 1) {
                    Object[][] obj = new Object[inventory_barcoders_list.size()][5];
                    int i = 0;
                    for (Inventory_barcodes.to_inventory_barcodes to : inventory_barcoders_list) {
                        obj[i][0] = " " + FitIn.fmt_woc(to.product_qty);
                        obj[i][1] = " " + to.main_barcode;
                        obj[i][2] = " " + to.description;
                        String unit = "";
                        Dlg_inventory_uom.to_uom uoms = uom.default_uom(to.unit);
                        if (uoms != null) {
                            unit = uoms.uom;
                        }
                        obj[i][3] = " " + unit;
                        obj[i][4] = " " + FitIn.fmt_wc_0(to.selling_price);
                        i++;
                    }
                    JLabel[] labels = {};
                    double width = tf_search.getWidth();
                    width = width * .60;
                    int w = FitIn.toInt("" + width);
                    int[] tbl_widths_customers = {50, 70, w - 70, 50, 70};
                    String[] col_names = {"Qty", "Item Code", "Description", "Unit", "Price"};
                    TableRenderer tr = new TableRenderer();
                    TableRenderer.setPopup(tf_search, obj, labels, tbl_widths_customers, col_names);
                    jProgressBar1.setString("Finished...");
                    jProgressBar1.setIndeterminate(false);
                    tf_search.setEnabled(true);
                    tf_search.grabFocus();
                    tr.setCallback(new TableRenderer.Callback() {
                        @Override
                        public void ok(TableRenderer.OutputData data) {
                            Inventory_barcodes.to_inventory_barcodes t = inventory_barcoders_list.get(data.selected_row);
                            add_item(t);

                        }
                    });
                }

            }
        });
        t.start();
    }

    private void add_item(final Inventory_barcodes.to_inventory_barcodes t) {
        Window p = (Window) this;
        Dlg_new_stock_transfer_qty nd = Dlg_new_stock_transfer_qty.create(p, true);
        nd.setTitle("");
        nd.do_pass(1, "", t.main_barcode, t.barcode, t.description, t.product_qty, t.unit);
        nd.setCallback(new Dlg_new_stock_transfer_qty.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_new_stock_transfer_qty.OutputData data) {
                closeDialog.ok();
                int id = 0;
                String barcode = t.main_barcode;
                String description = t.description;
                String generic_name = t.generic_name;
                String category = t.category;
                String category_id = t.category_id;
                String classification = t.classification;
                String classification_id = t.classification_id;
                String sub_classification = t.sub_classification;
                String sub_classification_id = t.sub_classification_id;
                double product_qty = data.qty;
                String unit = data.unit;
                double conversion = data.conversion;
                double selling_price = data.selling_price;
                String date_added = DateType.now();
                String user_name = Users.user_name;
                String item_type = t.item_type;
                int status = 0;
                String supplier = t.supplier;
                int fixed_price = t.fixed_price;
                double cost = t.cost;
                String supplier_id = t.supplier_id;
                int multi_level_pricing = t.multi_level_pricing;
                int vatable = t.vatable;
                double reorder_level = t.reorder_level;
                double markup = t.markup;
                String main_barcode = t.barcode;
                String brand = t.brand;
                String brand_id = t.brand_id;
                String model = t.model;
                String model_id = t.model_id;
                int selling_type = t.selling_type;
                String branch = t.branch;
                String branch_code = t.branch_code;
                String location = t.location;
                String location_id = t.location_id;
                String serial_no = data.serial_no;
                serial_no = serial_no.replaceAll("\n", ",");
                String to_branch = "";
                String to_branch_id = "";
                String to_location = "";
                String to_location_id = "";
                String at_branch = my_branch;
                String at_branch_id = my_branch_id;
                String at_location = my_location;
                String at_location_id = my_location_id;
                to_stock_transfers_items field = new to_stock_transfers_items(id, barcode, description, generic_name, category, category_id, classification, classification_id, sub_classification, sub_classification_id, product_qty, unit, conversion, selling_price, date_added, user_name, item_type, status, supplier, fixed_price, cost, supplier_id, multi_level_pricing, vatable, reorder_level, markup, main_barcode, brand, brand_id, model, model_id, selling_type, branch, branch_code, location, location_id, "", serial_no, to_branch, to_branch_id, to_location, to_location_id, at_branch, at_branch_id, at_location, at_location_id
                );
                if (jButton5.isEnabled()) {
                    tbl_stock_transfers_items_ALM.add(field);
                    tbl_stock_transfers_items_M.fireTableDataChanged();
                } else {
                    int row = tbl_stock_transfers.getSelectedRow();
                    if (row < 0) {
                        return;
                    }
                    to_stock_transfers to = (to_stock_transfers) tbl_stock_transfers_ALM.get(tbl_stock_transfers.convertRowIndexToModel(row));
                    if (to.status == 1) {
                        Alert.set(0, "Stock Transfer Status [Finalized]!");
                        return;
                    }
                    if (to.status == 2) {
                        Alert.set(0, "Stock Transfer Status [Deleted]!");
                        return;
                    }
                    int exists = 0;
                    for (Stock_transfer_privileges.to_stock_transfer_privileges priv : stock_transfer_privileges) {
                        if ((priv.from_location_id.equalsIgnoreCase(to.from_location_id)) && (priv.to_location_id.equalsIgnoreCase(to.to_location_id)) && (priv.add_transfer == 1)) {
                            exists = 1;
                            break;
                        }
                    }
                    if (exists == 0) {
                        Alert.set(0, "Privilege to Add transfer to this location not added!");
                        return;
                    }
                    List<Stock_transfers_items.to_stock_transfers_items> datas = new ArrayList();
                    datas.add(field);
                    Stock_transfers_items.add_stock_transfers_items2(datas, to.transaction_no, to);
                    data_cols_items();
                    Alert.set(1, "");
//                    String cloud_host = System.getProperty("cloud_host", "128.199.80.53");
//                    if (!cloud_host.isEmpty()) {
//                        upload_update_item_transction_to_cloud(to.transaction_no, to.at_location_id);
//                    }
                }
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }
    private ArrayListModel tbl_stock_transfers_items_ALM;
    private Tblstock_transfers_itemsModel tbl_stock_transfers_items_M;

    private void init_tbl_stock_transfers_items() {
        tbl_stock_transfers_items_ALM = new ArrayListModel();
        tbl_stock_transfers_items_M = new Tblstock_transfers_itemsModel(tbl_stock_transfers_items_ALM);
        tbl_stock_transfers_items.getTableHeader().setPreferredSize(new Dimension(100, 40));
        tbl_stock_transfers_items.setModel(tbl_stock_transfers_items_M);
        tbl_stock_transfers_items.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_stock_transfers_items.setRowHeight(25);
        int[] tbl_widths_stock_transfers_items = {100, 100, 50, 50, 80, 80, 50, 50, 50, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_stock_transfers_items.length; i < n; i++) {
            if (i == 1) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_stock_transfers_items, i, tbl_widths_stock_transfers_items[i]);
        }
        Dimension d = tbl_stock_transfers_items.getTableHeader().getPreferredSize();
        d.height = 25;
        tbl_stock_transfers_items.getTableHeader().setPreferredSize(d);
        tbl_stock_transfers_items.getTableHeader().setFont(new java.awt.Font("Arial", 0, 11));
        tbl_stock_transfers_items.setRowHeight(25);
        tbl_stock_transfers_items.setFont(new java.awt.Font("Arial", 0, 11));
    }

    private void loadData_stock_transfers_items(List<to_stock_transfers_items> acc) {
        tbl_stock_transfers_items_ALM.clear();
        tbl_stock_transfers_items_ALM.addAll(acc);
    }

    public static class Tblstock_transfers_itemsModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Code", "Description", "Qty", "Unit", "Cost", "Price", "", "", "Status", "sub_classification_id", "product_qty", "unit", "conversion", "selling_price", "date_added", "user_name", "item_type", "status", "supplier", "fixed_price", "cost", "supplier_id", "multi_level_pricing", "vatable", "reorder_level", "markup", "barcodes", "brand", "brand_id", "model", "model_id", "selling_type", "branch", "branch_code", "location", "location_id"
        };

        public Tblstock_transfers_itemsModel(ListModel listmodel) {
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
            to_stock_transfers_items tt = (to_stock_transfers_items) getRow(row);
            switch (col) {
                case 0:
                    return " " + tt.barcode;
                case 1:
                    return " " + tt.description;
                case 2:
                    return " " + FitIn.fmt_woc(tt.product_qty);
                case 3:
                    String uom = tt.unit;
                    String[] list = uom.split(",");
                    String unit = "";
                    int o = 0;
                    for (String s : list) {
                        int i = s.indexOf(":");
                        unit = s.substring(1, i);
                        o++;
                    }
                    return " " + unit;
                case 4:
                    if (show_cost == 1) {
                        return " " + FitIn.fmt_wc_0(tt.cost);
                    } else {
                        return " ";
                    }

                case 5:

                    if (hide_price == 1) {
                        return " ";
                    } else {
                        return " " + FitIn.fmt_wc_0(tt.selling_price);
                    }

                case 6:
                    return " Update";
                case 7:
                    return " Delete";
                case 8:
                    if (tt.status == 0 && tt.id == 0) {
                        return " ";
                    } else if (tt.status == 1) {
                        return " Finalized";
                    } else if (tt.status == 0 && tt.id != 0) {
                        return " Posted";
                    } else {
                        return " Deleted";
                    }
                case 9:
                    return tt.sub_classification_id;
                case 10:
                    return tt.product_qty;
                case 11:
                    return tt.unit;
                case 12:
                    return tt.conversion;
                case 13:
                    return tt.selling_price;
                case 14:
                    return tt.date_added;
                case 15:
                    return tt.user_name;
                case 16:
                    return tt.item_type;
                case 17:
                    return tt.status;
                case 18:
                    return tt.supplier;
                case 19:
                    return tt.fixed_price;
                case 20:
                    return tt.cost;
                case 21:
                    return tt.supplier_id;
                case 22:
                    return tt.multi_level_pricing;
                case 23:
                    return tt.vatable;
                case 24:
                    return tt.reorder_level;
                case 25:
                    return tt.markup;
                case 26:
                    return tt.barcodes;
                case 27:
                    return tt.brand;
                case 28:
                    return tt.brand_id;
                case 29:
                    return tt.model;
                case 30:
                    return tt.model_id;
                case 31:
                    return tt.selling_type;
                case 32:
                    return tt.branch;
                case 33:
                    return tt.branch_code;
                case 34:
                    return tt.location;
                default:
                    return tt.location_id;
            }
        }
    }

    private void data_cols_items() {

        int row = tbl_stock_transfers.getSelectedRow();
        if (row < 0) {
            return;
        }
        int col = tbl_stock_transfers.getSelectedColumn();
        to_stock_transfers to = (to_stock_transfers) tbl_stock_transfers_ALM.get(tbl_stock_transfers.convertRowIndexToModel(row));
        String where = " where stock_transfer_id='" + to.transaction_no + "'  ";
        loadData_stock_transfers_items(Stock_transfers_items.ret_data(where));

        jLabel15.setText("" + tbl_stock_transfers_items_ALM.size());
        if (col == 8) {
            get_customers_aging();
        }

        if (col == 6) {
            select_transfer();
            jTabbedPane1.setSelectedIndex(0);
            jButton5.setEnabled(false);
            jButton1.setEnabled(true);
        }
        if (col == 7) {
            delete_stock_transfer();
        }

        if (col == 10) {
            if (to.isSelected()) {
                to.setSelected(false);
                tbl_stock_transfers_M.fireTableDataChanged();
            } else {
                to.setSelected(true);
                tbl_stock_transfers_M.fireTableDataChanged();
            }
        }

    }

    private void select_transfer() {
        int row = tbl_stock_transfers.getSelectedRow();
        if (row < 0) {
            return;
        }
        final to_stock_transfers to = (to_stock_transfers) tbl_stock_transfers_ALM.get(tbl_stock_transfers.convertRowIndexToModel(row));
        jTextField2.setText(to.transaction_no);
        tf_from_branch.setText(to.from_branch);
        tf_from_branch_id.setText(to.from_branch_id);
        tf_from_location.setText(to.from_location);
        tf_from_location_id.setText(to.from_location_id);

        tf_to_branch.setText(to.to_branch);
        tf_to_branch_id.setText(to.to_branch_id);
        tf_to_location.setText(to.to_location);
        tf_to_location_id.setText(to.to_location_id);
        tf_remarks.setText(to.remarks);

    }

    private void get_customers_aging() {

        int row = tbl_stock_transfers.getSelectedRow();
        if (row < 0) {
            return;
        }
        final to_stock_transfers to = (to_stock_transfers) tbl_stock_transfers_ALM.get(tbl_stock_transfers.convertRowIndexToModel(row));

        jProgressBar2.setString("Loading... Please wait...");
        jProgressBar2.setIndeterminate(true);

        Thread t = new Thread(new Runnable() {

            @Override
            public void run() {
                List<Srpt_stock_transfer.field> datas = new ArrayList();
                List<to_stock_transfers_items> fields = tbl_stock_transfers_items_ALM;
                for (to_stock_transfers_items f : fields) {
                    String item_code = f.barcode;
                    String barcode = f.barcodes;
                    String description = f.description;
                    double qty = f.product_qty;
                    String unit = "";
                    Dlg_inventory_uom.to_uom uoms = uom.default_uom(f.unit);
                    if (uoms != null) {
                        unit = uoms.uom;
                    }
                    String serial_no = f.serial_no;
                    double price = f.selling_price;
                    double amount = f.selling_price * f.product_qty;
                    Srpt_stock_transfer.field rpt = new Srpt_stock_transfer.field(item_code, barcode, description, qty, unit, serial_no, price, amount);
                    datas.add(rpt);
                }
                String business_name = System.getProperty("business_name", "Algorithm Computer Services");
                String date = DateType.convert_slash_datetime2(to.date_added);
//                System.out.println(date);
                String printed_by = "Administrator";
                String transaction_no = to.transaction_no;
                String from_branch = to.from_branch;
                String from_location = to.from_location;
                String to_branch = to.to_branch;
                String to_location = to.to_location;
                String remarks = to.remarks;
                String address = System.getProperty("address", "");
                String contact_no = System.getProperty("contact_no", "");
                String status = "Posted";
                if (to.status == 1) {
                    status = "Finalized";
                }
                if (to.status == 2) {
                    status = "Deleted";
                }
                Srpt_stock_transfer rpt = new Srpt_stock_transfer(transaction_no, from_branch, from_location, to_branch, to_location, business_name, address, contact_no, date, status, remarks);
                rpt.fields.addAll(datas);
                String jrxml = "rpt_stock_transfer.jrxml";
                report_customers_aging(rpt, jrxml);
                jProgressBar2.setString("Finished...");
                jProgressBar2.setIndeterminate(false);
                jTabbedPane1.setSelectedIndex(2);
            }
        });

        t.start();
    }

    private void report_customers_aging(final Srpt_stock_transfer to, String jrxml_name) {
        jPanel9.removeAll();
        jPanel9.setLayout(new BorderLayout());
        try {
            JRViewer viewer = get_viewer_customers_aging(to, jrxml_name);
            JPanel pnl = new JPanel();
            pnl.add(viewer);
            pnl.setVisible(true);
            pnl.setVisible(true);
            jPanel9.add(viewer);
            jPanel9.updateUI();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer_customers_aging(Srpt_stock_transfer to, String rpt_name) {
        try {
            return JasperUtil.getJasperViewer(
                    compileJasper_aging(rpt_name),
                    JasperUtil.setParameter(to),
                    JasperUtil.makeDatasource(to.fields));
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
        }
    }

    public static JasperReport compileJasper_aging(String rpt_name) {
        try {
            String jrxml = rpt_name;
            InputStream is = Srpt_stock_transfer.class.
                    getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);
            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

    private void update_queue_items() {
        int row = tbl_stock_transfers_items.getSelectedRow();
        if (row < 0) {
            return;
        }
        int col = tbl_stock_transfers_items.getSelectedColumn();
        final to_stock_transfers_items to = (to_stock_transfers_items) tbl_stock_transfers_items_ALM.get(row);
        if (to.id == 0) {
            if (col == 6) {
                Window p = (Window) this;
                Dlg_new_stock_transfer_qty nd = Dlg_new_stock_transfer_qty.create(p, true);
                nd.setTitle("");
                nd.do_pass(to.product_qty, to.serial_no, to.barcode, to.barcodes, to.description, 0, to.unit);
                nd.setCallback(new Dlg_new_stock_transfer_qty.Callback() {
                    @Override
                    public void ok(CloseDialog closeDialog, Dlg_new_stock_transfer_qty.OutputData data) {
                        closeDialog.ok();
                        to.setProduct_qty(data.qty);
                        to.setSerial_no(data.serial_no);
                        tbl_stock_transfers_items_M.fireTableDataChanged();
                        Alert.set(2, "");
                    }
                });
                nd.setLocationRelativeTo(this);
                nd.setVisible(true);
            }
            if (col == 7) {
                tbl_stock_transfers_items_ALM.remove(row);
                tbl_stock_transfers_items_M.fireTableDataChanged();
            }
        } else {
            if (to.status == 1) {
                Alert.set(0, "Stock Transfer Status [Finalized]!");
                return;
            }
            if (to.status == 2) {
                Alert.set(0, "Stock Transfer Status [Deleted]!");
                return;
            }
            if (jButton7.getText().equalsIgnoreCase("Post and Finalize")) {
                Alert.set(0, "Editing Disabled!");
                return;
            }
            int exists = 0;
            for (Stock_transfer_privileges.to_stock_transfer_privileges priv : stock_transfer_privileges) {
                if ((priv.from_location_id.equalsIgnoreCase(to.location_id)) && (priv.to_location_id.equalsIgnoreCase(to.to_location_id)) && (priv.edit_transfer == 1)) {
                    exists = 1;
                    break;
                }
            }
            if (exists == 0) {
                Alert.set(0, "Privilege to Edit transfer to this location not added!");
                return;
            }
            if (col == 6) {
                Window p = (Window) this;
                Dlg_new_stock_transfer_qty nd = Dlg_new_stock_transfer_qty.create(p, true);
                nd.setTitle("");
                nd.do_pass(to.product_qty, to.serial_no, to.barcode, to.barcodes, to.description, 0, to.unit);
                nd.setCallback(new Dlg_new_stock_transfer_qty.Callback() {
                    @Override
                    public void ok(CloseDialog closeDialog, Dlg_new_stock_transfer_qty.OutputData data) {
                        closeDialog.ok();
                        Stock_transfers_items.edit_stock_transfers_items2("" + to.id, data.qty, data.serial_no, to.stock_transfer_id);
                        data_cols_items();
                        Alert.set(2, "");
//                        String cloud_host = System.getProperty("cloud_host", "128.199.80.53");
//                        if (!cloud_host.isEmpty()) {
//                            upload_update_item_transction_to_cloud(to.stock_transfer_id, to.at_location_id);
//                        }
                    }
                });

                nd.setLocationRelativeTo(this);
                nd.setVisible(true);
            }

            if (col == 7) {
//                if (!jButton7.isEnabled()) {
//                    return;
//                }
                if (jButton7.getText().equalsIgnoreCase("Post and Finalize")) {
                    Alert.set(0, "Editing Disabled!");
                    return;
                }
                int exists2 = 0;
                for (Stock_transfer_privileges.to_stock_transfer_privileges priv : stock_transfer_privileges) {
                    if ((priv.from_location_id.equalsIgnoreCase(to.location_id)) && (priv.to_location_id.equalsIgnoreCase(to.to_location_id)) && (priv.delete_transfer == 1)) {
                        exists2 = 1;
                        break;
                    }
                }
                if (exists2 == 0) {
                    Alert.set(0, "Privilege to Delete transfer to this location not added!");
                    return;
                }
                Window p = (Window) this;
                Dlg_confirm_delete nd = Dlg_confirm_delete.create(p, true);
                nd.setTitle("");
                nd.setCallback(new Dlg_confirm_delete.Callback() {

                    @Override
                    public void ok(CloseDialog closeDialog, Dlg_confirm_delete.OutputData data) {
                        closeDialog.ok();
                        Stock_transfers_items.delete_stock_transfers_items2("" + to.id, to.stock_transfer_id);
                        data_cols_items();
                        Alert.set(3, "");
//                        String cloud_host = System.getProperty("cloud_host", "128.199.80.53");
//                        if (!cloud_host.isEmpty()) {
//                            upload_update_item_transction_to_cloud(to.stock_transfer_id, to.at_location_id);
//                        }
                    }
                });
                nd.setLocationRelativeTo(this);
                nd.setVisible(true);

            }
        }

    }

    private void upload_update_item_transction_to_cloud(String transaction_no, String at_location_id) {
        Window p = (Window) this;
        Dlg_new_stock_transfer_upload_to_cloud nd = Dlg_new_stock_transfer_upload_to_cloud.create(p, true);
        nd.setTitle("");
        nd.do_update_new_item(transaction_no, at_location_id);
        nd.setCallback(new Dlg_new_stock_transfer_upload_to_cloud.Callback() {
            @Override
            public void ok(CloseDialog closeDialog, Dlg_new_stock_transfer_upload_to_cloud.OutputData data) {
                closeDialog.ok();

            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }

    private void show_popup(MouseEvent evt) {

//        int col = tbl_stock_transfers.getSelectedColumn();
//        jMenuItem1.setVisible(false);
//        jMenuItem2.setVisible(false);
//        if (col == 4) {
//            int row = tbl_stock_transfers.getSelectedRow();
//            if (row < 0) {
//                return;
//            }
//            String where = " where user_name='" + Users.user_name + "' order by previledge asc";
//            List<S1_user_previleges.to_user_previleges> datas = S1_user_previleges.ret_data(where);
//            int exists = 0;
//            for (S1_user_previleges.to_user_previleges to : datas) {
//                if (to.previledge.equalsIgnoreCase("Finalize Stock Transfer")) {
//                    exists = 1;
//                    break;
//                }
//            }
//
//            if (exists == 1) {
//                data_cols_items();
//                if (evt.isPopupTrigger()) {
//                    jMenuItem1.setVisible(true);
//                    jPopupMenu1.show(tbl_stock_transfers, evt.getX(), evt.getY());
//                }
//            }
//        }
    }

    private void select_stock_transfer(MouseEvent evt) {
        int row = tbl_stock_transfers.getSelectedRow();
        if (row < 0) {
            return;
        }

        to_stock_transfers to = (to_stock_transfers) tbl_stock_transfers_ALM.get(tbl_stock_transfers.convertRowIndexToModel(row));
        jTextField2.setText(to.transaction_no);
        tf_remarks.setText(to.remarks);
        tf_from_branch.setText(to.from_branch);
        tf_from_branch_id.setText(to.from_branch_id);
        tf_from_location.setText(to.from_location);
        tf_from_location_id.setText(to.from_location_id);

        tf_to_branch.setText(to.to_branch);
        tf_to_branch_id.setText(to.to_branch_id);
        tf_to_location.setText(to.to_location);
        tf_to_location_id.setText(to.to_location_id);

        try {
            Date d = DateType.datetime.parse(to.date_added);
            jDateChooser5.setDate(d);
        } catch (ParseException ex) {
            Logger.getLogger(Dlg_new_stock_transfer.class.getName()).log(Level.SEVERE, null, ex);
        }

        data_cols_items();

        int col = tbl_stock_transfers.getSelectedColumn();
//        System.out.println("Col: " + col);
        if (col == 6) {

            Button.Success btn1 = (Button.Success) jButton7;
            Button.Info btn2 = (Button.Info) jButton1;
            Button.Primary btn3 = (Button.Primary) jButton5;
            btn1.set_enabled(false);
            btn2.set_enabled(false);
            btn3.set_enabled(true);

            jTabbedPane1.setSelectedIndex(0);
            btn3.set_enabled(false);

            tf_from_branch.setEnabled(false);
            tf_to_branch.setEnabled(false);
            if (to.status == 0) {
                btn1.set_enabled(true);
                btn2.set_enabled(true);
            } else {
                btn1.set_enabled(false);
                btn2.set_enabled(false);
            }

        } else if (col == 7) {

            delete_transfer();

        } else if (col == 8) {
            get_customers_aging();

        } else if (col == 9) {
//            upload_transction_to_cloud(to.transaction_no, to.at_location_id, to);

        } else {

        }
    }

    private void delete_transfer() {

        int row = tbl_stock_transfers.getSelectedRow();
        if (row < 0) {
            return;
        }
        int col = tbl_stock_transfers.getSelectedColumn();
        if (col != 7) {
            return;
        }
        final to_stock_transfers to = (to_stock_transfers) tbl_stock_transfers_ALM.get(tbl_stock_transfers.convertRowIndexToModel(row));
        final String delete_stock_transfers_finalized = System.getProperty("delete_stock_transfers_finalized", "false");
        if (to.status == 2) {
            Alert.set(0, "Stock Transfer Status [Deleted]!");
            return;
        }
        if (delete_stock_transfers_finalized.equalsIgnoreCase("false")) {
            if (to.status == 1) {
                Alert.set(0, "Cannot delete finalized transaction!");
                return;
            }
        }

        int exists = 0;
        for (Stock_transfer_privileges.to_stock_transfer_privileges priv : stock_transfer_privileges) {
            if ((priv.from_location_id.equalsIgnoreCase(to.from_location_id)) && (priv.to_location_id.equalsIgnoreCase(to.to_location_id)) && (priv.delete_transfer == 1)) {
                exists = 1;
                break;
            }
        }
        if (exists == 0) {
            Alert.set(0, "Privilege to Delete transfer to this location not added!");
            return;
        }
        Window p = (Window) this;
        Dlg_confirm_delete nd = Dlg_confirm_delete.create(p, true);
        nd.setTitle("");
        nd.setCallback(new Dlg_confirm_delete.Callback() {
            @Override
            public void ok(CloseDialog closeDialog, Dlg_confirm_delete.OutputData data) {
                closeDialog.ok();
                List<Stock_transfers_items.to_stock_transfers_items> items = tbl_stock_transfers_items_ALM;
                if (delete_stock_transfers_finalized.equalsIgnoreCase("true") && to.status == 1) {
                    Stock_transfers.delete_stock_transfers2(to, items);
                }
                if (to.status == 1 && delete_stock_transfers_finalized.equalsIgnoreCase("false")) {
                    Alert.set(0, "Receipt-Status [Finalized]!");
                    return;
                }
                if (to.status == 0) {
                    Stock_transfers.delete_stock_transfers(to);
                }

                data_cols();
                new_post();
                Alert.set(3, "");

            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }

    private void finalize_transfer() {
        if (jButton7.getText().equalsIgnoreCase("Finalize")) {
            final int row = tbl_stock_transfers.getSelectedRow();
            if (row < 0) {
                return;
            }
            final to_stock_transfers to = (to_stock_transfers) tbl_stock_transfers_ALM.get(tbl_stock_transfers.convertRowIndexToModel(row));
            if (to.status == 1) {
                Alert.set(0, "Stock Transfer-Status [Finalized]");
                return;
            }
            if (to.status == 2) {
                Alert.set(0, "Stock Transfer-Status [Deleted]");
                return;
            }
            int exists = 0;
            for (Stock_transfer_privileges.to_stock_transfer_privileges priv : stock_transfer_privileges) {
                if ((priv.from_location_id.equalsIgnoreCase(to.from_location_id)) && (priv.to_location_id.equalsIgnoreCase(to.to_location_id)) && (priv.finalize_transfer == 1)) {
                    exists = 1;
                    break;
                }
            }
            if (exists == 0) {
                Alert.set(0, "Privilege to Finalize transfer to this location not added!");
                return;
            }
            Window p = (Window) this;
            Dlg_confirm_action nd = Dlg_confirm_action.create(p, true);
            nd.setTitle("");
            nd.do_pass("Are you sure you want to finalize this transaction?");

            nd.setCallback(new Dlg_confirm_action.Callback() {
                @Override
                public void ok(CloseDialog closeDialog, Dlg_confirm_action.OutputData data) {
                    closeDialog.ok();
                    if (jButton7.getText().equalsIgnoreCase("Finalize")) {
                        List<Stock_transfers_items.to_stock_transfers_items> datas = tbl_stock_transfers_items_ALM;
                        String finalized_by_id = MyUser.getUser_id();
                        String finalized_by = MyUser.getUser_screen_name();
                        Stock_transfers.finalize(to, datas, finalized_by_id, finalized_by);
                        data_cols();
                        new_post();
                        Alert.set(0, "Stock Transfer Finalized");
                    }
                }
            });
            nd.setLocationRelativeTo(this);
            nd.setVisible(true);
        } else {

            Window p = (Window) this;
            Dlg_confirm_action nd = Dlg_confirm_action.create(p, true);
            nd.setTitle("");
            nd.do_pass("Are you sure you want to post and finalize this transaction?");
            nd.setCallback(new Dlg_confirm_action.Callback() {
                @Override
                public void ok(CloseDialog closeDialog, Dlg_confirm_action.OutputData data) {
                    closeDialog.ok();
                    int id = 0;
                    final String transaction_no = jTextField2.getText();
                    String user_name = Users.user_name;
                    String date_added = DateType.sf.format(jDateChooser5.getDate());
                    String remarks = tf_remarks.getText();
                    String to_branch = tf_to_branch.getText();
                    String to_branch_id = tf_to_branch_id.getText();
                    String to_location = tf_to_location.getText();
                    String to_location_id = tf_to_location_id.getText();

                    String from_branch = tf_from_branch.getText();
                    String from_branch_id = tf_from_branch_id.getText();
                    String from_location = tf_from_location.getText();
                    String from_location_id = tf_from_location_id.getText();

                    String at_branch = my_at_branch;
                    String at_branch_id = my_at_branch_id;
                    String at_location = my_at_location;
                    String at_location_id = my_at_location_id;
                    int is_uploaded = 1;
                    String finalized_by_id = MyUser.getUser_id();
                    String finalized_by = MyUser.getUser_screen_name();
                    final Stock_transfers.to_stock_transfers rpt = new to_stock_transfers(id, transaction_no, user_name, date_added, remarks, to_branch, to_branch_id, to_location, to_location_id, from_branch, from_branch_id, from_location, from_location_id, 0, false, at_branch, at_branch_id, at_location, at_location_id, is_uploaded, finalized_by_id, finalized_by);
                    List<Stock_transfers_items.to_stock_transfers_items> datas = tbl_stock_transfers_items_ALM;
                    Stock_transfers.add_stock_transfers(rpt, datas);
                    Stock_transfers.finalize(rpt, datas, finalized_by_id, finalized_by);
                    Synch_stock_transfers.update_status_stock_transfer(rpt.transaction_no, 1);
                    Synch_stock_transfers.update_status_stock_transfer_cloud(rpt.transaction_no, 1, rpt.at_location_id);
                    data_cols();
                    Alert.set(0, "Stock Transfer Finalized");
                    init_no();
                    tf_remarks.setText("");
                    jButton5.setEnabled(true);
                    jButton1.setEnabled(false);
                    jButton7.setEnabled(false);

                    jTextField2.setEnabled(true);
                    jDateChooser5.setEnabled(true);
                    tf_from_branch.setEnabled(true);
                    tf_to_branch.setEnabled(true);
                    jButton7.setText("Finalize");

                    tf_to_branch.setText("");
                    tf_to_branch_id.setText("");
                    tf_to_location.setText("");
                    tf_to_location_id.setText("");

                    my_at_branch = "";
                    my_at_branch_id = "";
                    my_at_location = "";
                    my_at_location_id = "";
                    tbl_stock_transfers_items_ALM.clear();
                    tbl_stock_transfers_items_M.fireTableDataChanged();

                }
            });
            nd.setLocationRelativeTo(this);
            nd.setVisible(true);
        }

    }

    private void cloud_insert(final List<String> query, String stmt) {
        Window p = (Window) this;
        Dlg_confirm_cloud nd = Dlg_confirm_cloud.create(p, true);
        nd.setTitle("");
        nd.do_pass(stmt);
        nd.setCallback(new Dlg_confirm_cloud.Callback() {
            @Override
            public void ok(CloseDialog closeDialog, Dlg_confirm_cloud.OutputData data) {
                closeDialog.ok();
                MyConnection.exec_cloud_query(query);
                Alert.set(0, "Successfully saved to cloud!");
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }

    //<editor-fold defaultstate="collapsed" desc=" items ordered ">
    private void get_items_ordered() {

        jProgressBar3.setString("Loading... Please wait...");
        jProgressBar3.setIndeterminate(true);

        Thread t = new Thread(new Runnable() {

            @Override
            public void run() {
                String date_from = DateType.sf.format(jDateChooser3.getDate());
                String date_to = DateType.sf.format(jDateChooser4.getDate());

                String where = " where st.category like '%" + "" + "%' ";
                String status = "All";
                if (!jCheckBox28.isSelected()) {
                    Field.Search se = (Field.Search) tf_search1;
                    where = where + " and st.barcode='" + se.getId() + "' ";
                }
                if (!jCheckBox15.isSelected()) {
                    where = where + " and Date(st.date_added) between '" + date_from + "' and '" + date_to + "' ";
                }
                if (jCheckBox17.isSelected()) {
                    where = where + " and st.status=0 ";
                    status = "Posted";
                }
                if (jCheckBox19.isSelected()) {
                    where = where + " and st.status=1 ";
                    status = "Finalized";
                }
                if (jCheckBox22.isSelected()) {
                    where = where + " and st.status=2 ";
                    status = "Deleted";
                }
                Field.Combo f_br = (Field.Combo) tf_from_branch4;
                Field.Combo f_lo = (Field.Combo) tf_from_location4;
                Field.Combo t_br = (Field.Combo) tf_from_branch3;
                Field.Combo t_lo = (Field.Combo) tf_from_location3;

                if (!jCheckBox14.isSelected() && !jCheckBox13.isSelected()) {
                    where = where + " and st.location_id='" + f_lo.getId() + "' ";
                }
                if (jCheckBox14.isSelected() && !jCheckBox13.isSelected()) {
                    where = where + " and st.branch_code='" + f_br.getId() + "' ";
                }

                if (!jCheckBox18.isSelected() && !jCheckBox20.isSelected()) {
                    where = where + " and st.to_location_id='" + t_lo.getId() + "' ";
                }
                if (jCheckBox18.isSelected() && !jCheckBox20.isSelected()) {
                    where = where + " and st.to_branch_id='" + t_br.getId() + "' ";
                }
                if (!jCheckBox25.isSelected()) {
                    if (jCheckBox26.isSelected()) {
                        where = " join stock_transfers as s "
                                + " on s.transaction_no = st.stock_transfer_id "
                                + where + " and s.remarks like '%" + "donat" + "%' ";
                    } else {
                        where = " join stock_transfers as s "
                                + " on s.transaction_no = st.stock_transfer_id "
                                + where + " and s.remarks like '%" + "snack" + "%' ";
                    }

                }
                where = where + " "
                        + " group by Date(st.date_added),st.to_location_id,st.barcode,st.selling_price "
                        + " order by Date(st.date_added),st.to_location_id,st.barcode,st.description asc ";

                int is_price = 0;
                if (jCheckBox23.isSelected()) {
                    is_price = 1;
                }
                System.out.println("where: " + where);
                List<Srpt_transferred_items.field> fields = Srpt_transferred_items.ret_data(where, is_price);

                String business_name = System.getProperty("business_name", "Algorithm Computer Services");
                String address = System.getProperty("address", "Daro, Dumaguete City Negros Oriental");
                String date = DateType.slash.format(jDateChooser3.getDate()) + " - " + DateType.slash.format(jDateChooser4.getDate());

                String from_branch = tf_from_branch4.getText();
                String from_location = tf_from_location4.getText();
                if (jCheckBox14.isSelected()) {
                    from_location = "All";
                }
                if (jCheckBox13.isSelected()) {
                    from_branch = "All";
                    from_location = "All";
                }
                String to_branch = tf_from_branch3.getText();

                String to_location = tf_from_location3.getText();
                if (jCheckBox18.isSelected()) {
                    to_location = "All";
                }
                if (jCheckBox20.isSelected()) {
                    to_branch = "All";
                    to_location = "All";
                }
                String am = "Selling Price";
                if (jCheckBox24.isSelected()) {
                    am = "Cost";
                }
                Srpt_transferred_items rpt = new Srpt_transferred_items(business_name, address, date, from_branch, from_location, to_branch, to_location, status, am);
                rpt.fields.addAll(fields);
                String jrxml = "rpt_transferred_items.jrxml";
                report_items_ordered(rpt, jrxml);
                jProgressBar3.setString("Finished...");
                jProgressBar3.setIndeterminate(false);

            }
        });

        t.start();
    }

    private void report_items_ordered(final Srpt_transferred_items to, String jrxml_name) {
        jPanel16.removeAll();
        jPanel16.setLayout(new BorderLayout());
        try {
            JRViewer viewer = get_viewer_items_ordered(to, jrxml_name);
            JPanel pnl = new JPanel();
            pnl.add(viewer);
            pnl.setVisible(true);
            pnl.setVisible(true);
            jPanel16.add(viewer);
            jPanel16.updateUI();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer_items_ordered(Srpt_transferred_items to, String rpt_name) {
        try {
            return JasperUtil.getJasperViewer(
                    compileJasper_items_ordered(rpt_name),
                    JasperUtil.setParameter(to),
                    JasperUtil.makeDatasource(to.fields));
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
        }
    }

    public static JasperReport compileJasper_items_ordered(String rpt_name) {
        try {
            String jrxml = rpt_name;
            InputStream is = Srpt_transferred_items.class.
                    getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);
            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }
    //</editor-fold>

    private void cloud_transfers() {
        Window p = (Window) this;
        Dlg_new_stock_transfer_cloud_transactions nd = Dlg_new_stock_transfer_cloud_transactions.create(p, true);
        nd.setTitle("");
        nd.setCallback(new Dlg_new_stock_transfer_cloud_transactions.Callback() {
            @Override
            public void ok(CloseDialog closeDialog, Dlg_new_stock_transfer_cloud_transactions.OutputData data) {
                closeDialog.ok();
                jButton7.setText("Post and Finalize");
                loadData_stock_transfers_items(data.stock_transfer_items);
                jLabel15.setText("" + data.stock_transfer_items.size());

                jTextField2.setText(data.stock_transfer.transaction_no);
                tf_from_branch.setText(data.stock_transfer.from_branch);
                tf_from_branch_id.setText(data.stock_transfer.from_branch_id);
                tf_from_location.setText(data.stock_transfer.from_location);
                tf_from_location_id.setText(data.stock_transfer.from_location_id);

                tf_to_branch.setText(data.stock_transfer.to_branch);
                tf_to_branch_id.setText(data.stock_transfer.to_branch_id);
                tf_to_location.setText(data.stock_transfer.to_location);
                tf_to_location_id.setText(data.stock_transfer.to_location_id);
                tf_remarks.setText(data.stock_transfer.remarks);

                my_at_branch = data.stock_transfer.at_branch;
                my_at_branch_id = data.stock_transfer.at_branch_id;
                my_at_location = data.stock_transfer.at_location;
                my_at_location_id = data.stock_transfer.at_location_id;
                try {
                    Date d = DateType.datetime.parse(data.stock_transfer.date_added);
                    jDateChooser5.setDate(d);

                } catch (ParseException ex) {
                    Logger.getLogger(Dlg_new_stock_transfer.class.getName()).log(Level.SEVERE, null, ex);
                }
                jButton7.setEnabled(true);
                jTextField2.setEnabled(false);
                jDateChooser5.setEnabled(false);
                jButton5.setEnabled(false);
                jButton1.setEnabled(false);
                tf_from_branch.setEnabled(false);
                tf_to_branch.setEnabled(false);
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }

    private void check_for_synch() {
        String cloud_host = System.getProperty("cloud_host", "");
        if (!cloud_host.isEmpty()) {
            String ab = System.getProperty("active_branches", "10");
            String where = " where remarks like '%%' ";
            where = where + " and status=0 and is_uploaded<> 1 "
                    + " or remarks like '%%' and status=0 and is_uploaded= 1 "
                    + " or  remarks like '%%' and status=1 and is_uploaded=0 ";
            List<to_stock_transfers> transfers = Stock_transfers.ret_data(where);
//            System.out.println("transfers: " + transfers.size());
            int for_upload = 0;
            int waiting_finalization = 0;
            for (to_stock_transfers to : transfers) {
                if (to.status == 0 && to.is_uploaded == 1) {
                    if (!to.to_branch_id.equalsIgnoreCase(my_branch_id)) {
                        waiting_finalization++;
                    }
                }
                if (to.status == 0 && to.is_uploaded != 1 || to.status == 1 && to.is_uploaded == 0) {
                    for_upload++;
                }
            }
//            System.out.println("for_upload: " + for_upload);
//            System.out.println("waiting_finalization: " + waiting_finalization);
            if (for_upload > 0 || waiting_finalization > 0) {
                Window p = (Window) this;
                Dlg_stock_transfer_check_upload nd = Dlg_stock_transfer_check_upload.create(p, true);
                nd.setTitle("");
                nd.do_pass(for_upload, waiting_finalization, my_branch_id);
                nd.setCallback(new Dlg_stock_transfer_check_upload.Callback() {
                    @Override
                    public void ok(CloseDialog closeDialog, Dlg_stock_transfer_check_upload.OutputData data) {
                        closeDialog.ok();
                    }
                });

                nd.setLocationRelativeTo(this);
                nd.setVisible(true);
            }
        }
    }

    private void check_for_upload() {
        List<Inventory.to_inventory> to_add = new ArrayList();
        List<Inventory.to_inventory> to_update = new ArrayList();
        String cloud_host = System.getProperty("cloud_host", "");
        if (!cloud_host.isEmpty()) {
            System.out.println("Retrieving records...");
            String where = " where is_uploaded=0 or is_uploaded=2 ";
            List<Inventory.to_inventory> inventory_local = Inventory.ret_data22(where);

            for (Inventory.to_inventory to : inventory_local) {
                if (to.is_uploaded == 0) {
                    to_add.add(to);
                }
                if (to.is_uploaded == 2) {
                    to_update.add(to);
                }
            }
            int count = to_add.size() + to_update.size();
            if (count > 0) {
//                jLabel39.setBackground(new Color(255, 153, 0));

            } else {
//                jLabel39.setBackground(new Color(153, 153, 153));
            }
//            jLabel39.setText(FitIn.fmt_woc(to_add.size() + to_update.size()));

        }
    }

    private void check_items() {
        String main_branch = System.getProperty("main_branch", "false");
        if (main_branch.equalsIgnoreCase("true")) {
            Window p = (Window) this;
            Dlg_inventory_cloud_transactions_main nd = Dlg_inventory_cloud_transactions_main.create(p, true);
            nd.setTitle("");
            nd.setCallback(new Dlg_inventory_cloud_transactions_main.Callback() {
                @Override
                public void ok(CloseDialog closeDialog, Dlg_inventory_cloud_transactions_main.OutputData data) {
                    closeDialog.ok();
                }
            });
            nd.setLocationRelativeTo(this);
            nd.setVisible(true);
        } else {
            Window p = (Window) this;
            Dlg_inventory_cloud_transactions_local nd = Dlg_inventory_cloud_transactions_local.create(p, true);
            nd.setTitle("");
            nd.setCallback(new Dlg_inventory_cloud_transactions_local.Callback() {

                @Override
                public void ok(CloseDialog closeDialog, Dlg_inventory_cloud_transactions_local.OutputData data) {
                    closeDialog.ok();

                }
            });
            nd.setLocationRelativeTo(this);
            nd.setVisible(true);
        }

    }

    private void ret_for_upload() {

        Thread t = new Thread(new Runnable() {

            @Override
            public void run() {

                String ab = System.getProperty("active_branches", "10");
                String where = " where remarks like '%%'";
                where = where + " and status=0 and is_uploaded<> 1 or status=0 and is_uploaded= 1 or status=1 and is_uploaded=0 ";
                List<to_stock_transfers> transfers = Stock_transfers.ret_data(where);
                int for_upload = 0;
                int waiting_finalization = 0;
                for (to_stock_transfers to : transfers) {
                    if (to.status == 0 && to.is_uploaded == 1) {
                        if (to.to_branch_id.equalsIgnoreCase(my_branch_id)) {
                            waiting_finalization++;

                        }

                    }

                    if (to.status == 0 && to.is_uploaded != 1 || to.status == 1 && to.is_uploaded == 0) {
                        for_upload++;
                    }

                }
                System.out.println("for_upload: " + for_upload);
                System.out.println("waiting_finalization: " + waiting_finalization);
//                jLabel38.setText("" + (for_upload + waiting_finalization));
            }
        });
        t.start();
    }

    private void new_post() {

        init_no();
        tf_remarks.setText("");

        tf_to_branch.setText("");
        tf_to_branch_id.setText("");
        tf_to_location.setText("");
        tf_to_location_id.setText("");
        tbl_stock_transfers_items_ALM.clear();
        tbl_stock_transfers_items_M.fireTableDataChanged();
        tbl_stock_transfers.clearSelection();
        tf_from_branch.setEnabled(true);
        tf_to_branch.setEnabled(true);

        Button.Success btn1 = (Button.Success) jButton7;
        Button.Info btn2 = (Button.Info) jButton1;
        Button.Primary btn3 = (Button.Primary) jButton5;
        btn1.set_enabled(false);
        btn2.set_enabled(false);
        btn3.set_enabled(true);

    }

    private void check_all_branches(String stmt) {

//        S1_branch_locations.to_branch_locations to = branch_location_list2
        if (stmt.equals("from")) {
            int count = 0;
            for (Stock_transfer_privileges.to_stock_transfer_privileges stp : stock_transfer_privileges) {
                if (stp.add_transfer == 1) {
                    count++;
                }
            }
//            System.out.println("count: " + count);
//            System.out.println("stock_transfer_privileges: " + stock_transfer_privileges.size());
        }
    }

    private void usb_transfers() {
        Window p = (Window) this;
        Dlg_stock_transfer_usb nd = Dlg_stock_transfer_usb.create(p, true);
        nd.setTitle("");
        nd.do_pass();
        nd.setCallback(new Dlg_stock_transfer_usb.Callback() {
            @Override
            public void ok(CloseDialog closeDialog, Dlg_stock_transfer_usb.OutputData data) {

                closeDialog.ok();

            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }

    private void init_inventory_barcodes_items_transfered() {

        String search = tf_search1.getText();

        String where = "  where location_id='" + my_location_id + "' ";

        if (jCheckBox29.isSelected()) {
            where = where + "  and main_barcode like '" + search + "'  ";
        }
        if (jCheckBox30.isSelected()) {
            where = " and barcode='" + search + "'  ";

        }
        if (jCheckBox31.isSelected()) {
            where = where + "  and description like  '%" + search + "%'   ";
        }

        where = where + " order by description asc ";
        System.out.println(where);
        final List<Inventory_barcodes.to_inventory_barcodes> ibl = S2_inventory_barcodes.ret_data(where);

        if (ibl.size() >= 1) {
            Object[][] obj = new Object[ibl.size()][2];
            int i = 0;
            for (Inventory_barcodes.to_inventory_barcodes to : ibl) {
                obj[i][0] = " " + to.main_barcode;
                obj[i][1] = " " + to.description;
//                obj[i][2] = " " + to.description;
                i++;
            }

            JLabel[] labels = {};
            double width = tf_search1.getWidth();
            width = width * .60;
            int w = FitIn.toInt("" + width);
            int[] tbl_widths_customers = {60, tf_search1.getWidth() - 60};
            String[] col_names = {"Item Code", "Description"};
            TableRenderer tr = new TableRenderer();
            TableRenderer.setPopup(tf_search1, obj, labels, tbl_widths_customers, col_names);
            tr.setCallback(new TableRenderer.Callback() {
                @Override
                public void ok(TableRenderer.OutputData data) {
                    Inventory_barcodes.to_inventory_barcodes t = ibl.get(data.selected_row);
                    Field.Search item = (Field.Search) tf_search1;
                    item.setText(t.description);
                    item.setId(t.main_barcode);

                }
            });

        }
        tf_search.setEnabled(true);
    }

}
