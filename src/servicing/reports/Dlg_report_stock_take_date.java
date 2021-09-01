/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicing.reports;

import servicing.branch_locations.S1_branch_locations;
import servicing.branch_locations.S4_branch_locations;
import servicing.category.S1_inventory_category;
import servicing.category.S1_inventory_classification;
import servicing.category.S1_inventory_model;
import servicing.category.S1_inventory_sub_classification;
import servicing.inventory.Dlg_inventory_uom;
import servicing.inventory.Inventory_barcodes;
import servicing.inventory.uom;
import servicing.utils.TableRenderer;
import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
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
import synsoftech.fields.Button;
import synsoftech.fields.Field;
import synsoftech.util.DateType;

/**
 *
 * @author Guinness
 */
public class Dlg_report_stock_take_date extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_report_stock_take
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
    private Dlg_report_stock_take_date(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_report_stock_take_date(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_report_stock_take_date() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_report_stock_take_date myRef;

    private void setThisRef(Dlg_report_stock_take_date myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_report_stock_take_date> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_report_stock_take_date create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_report_stock_take_date create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_report_stock_take_date dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_report_stock_take_date((java.awt.Frame) parent, false);
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
            Dlg_report_stock_take_date dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_report_stock_take_date((java.awt.Dialog) parent, false);
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

        Dlg_report_stock_take_date dialog = Dlg_report_stock_take_date.create(new javax.swing.JFrame(), true);
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
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel12 = new javax.swing.JLabel();
        jCheckBox2 = new javax.swing.JCheckBox();
        jTextField2 = new Field.Combo();
        jTextField1 = new Field.Combo();
        jCheckBox3 = new javax.swing.JCheckBox();
        jLabel10 = new javax.swing.JLabel();
        jButton3 = new Button.Search();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new Field.Search();
        jCheckBox4 = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();
        tf_category = new Field.Combo();
        jCheckBox5 = new javax.swing.JCheckBox();
        jLabel6 = new javax.swing.JLabel();
        jCheckBox6 = new javax.swing.JCheckBox();
        tf_classification = new Field.Combo();
        jLabel7 = new javax.swing.JLabel();
        jCheckBox7 = new javax.swing.JCheckBox();
        tf_sub_classification = new Field.Combo();
        tf_model = new Field.Combo();
        jCheckBox8 = new javax.swing.JCheckBox();
        jLabel9 = new javax.swing.JLabel();
        tf_brand = new Field.Combo();
        jCheckBox14 = new javax.swing.JCheckBox();
        jLabel8 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jCheckBox10 = new javax.swing.JCheckBox();
        jCheckBox11 = new javax.swing.JCheckBox();
        jCheckBox12 = new javax.swing.JCheckBox();
        jCheckBox13 = new javax.swing.JCheckBox();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel13 = new javax.swing.JLabel();
        jCheckBox9 = new javax.swing.JCheckBox();
        jLabel14 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_ledger = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Date:");

        jDateChooser1.setDate(new Date());
        jDateChooser1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Choose Branch:");

        jCheckBox2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox2.setText("All");

        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField2MouseClicked(evt);
            }
        });
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField1.setFocusable(false);
        jTextField1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField1MouseClicked(evt);
            }
        });
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jCheckBox3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox3.setText("All");
        jCheckBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox3ActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Choose Location:");

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icons3/search19.png"))); // NOI18N
        jButton3.setToolTipText("Search");
        jButton3.setContentAreaFilled(false);
        jButton3.setFocusable(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Search Item:");

        jTextField3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField3MouseClicked(evt);
            }
        });
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jCheckBox4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox4.setSelected(true);
        jCheckBox4.setText("All");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Category:");

        tf_category.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_category.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_categoryMouseClicked(evt);
            }
        });
        tf_category.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_categoryActionPerformed(evt);
            }
        });

        jCheckBox5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox5.setSelected(true);
        jCheckBox5.setText("All");
        jCheckBox5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox5ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Classification:");

        jCheckBox6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox6.setSelected(true);
        jCheckBox6.setText("All");

        tf_classification.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_classification.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_classificationMouseClicked(evt);
            }
        });
        tf_classification.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_classificationActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Sub-Classification:");

        jCheckBox7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox7.setSelected(true);
        jCheckBox7.setText("All");

        tf_sub_classification.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_sub_classification.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_sub_classificationMouseClicked(evt);
            }
        });
        tf_sub_classification.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_sub_classificationActionPerformed(evt);
            }
        });

        tf_model.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_model.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_modelMouseClicked(evt);
            }
        });
        tf_model.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_modelActionPerformed(evt);
            }
        });

        jCheckBox8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox8.setSelected(true);
        jCheckBox8.setText("All");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("Model:");

        tf_brand.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_brand.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_brandMouseClicked(evt);
            }
        });
        tf_brand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_brandActionPerformed(evt);
            }
        });

        jCheckBox14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox14.setSelected(true);
        jCheckBox14.setText("All");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("Brand:");

        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel30.setText("Search filter:");

        buttonGroup1.add(jCheckBox10);
        jCheckBox10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox10.setText("[F1]-All");
        jCheckBox10.setFocusable(false);

        buttonGroup1.add(jCheckBox11);
        jCheckBox11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox11.setText("[F2]-Item Code");
        jCheckBox11.setFocusable(false);

        buttonGroup1.add(jCheckBox12);
        jCheckBox12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox12.setText("[F3]-Barcode");
        jCheckBox12.setFocusable(false);

        buttonGroup1.add(jCheckBox13);
        jCheckBox13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox13.setText("[F4]-Description");
        jCheckBox13.setFocusable(false);

        jCheckBox1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox1.setSelected(true);
        jCheckBox1.setText("Cost/Price");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Report Type:");

        jCheckBox9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jCheckBox9.setSelected(true);
        jCheckBox9.setText("Short/Long");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("Print:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField3))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox10, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBox12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tf_brand, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tf_classification, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tf_sub_classification))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tf_model, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jCheckBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_category))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                            .addComponent(jCheckBox1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox9, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox2)
                            .addComponent(jCheckBox3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField2)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jCheckBox2)
                        .addGap(1, 1, 1)
                        .addComponent(jCheckBox3))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jCheckBox9))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jCheckBox1)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tf_category, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jCheckBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(1, 1, 1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jCheckBox6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tf_classification, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBox7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(tf_sub_classification, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(1, 1, 1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox14, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_model, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_brand, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCheckBox10)
                            .addComponent(jCheckBox11)
                            .addComponent(jCheckBox12)
                            .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBox13))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBox4)))
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5))
        );

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        tbl_ledger.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbl_ledger);

        jLabel5.setText("Total no. of rows:");

        jLabel11.setText("0");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 881, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel11))
                .addGap(5, 5, 5))
        );

        jTabbedPane1.addTab("Tabular", jPanel4);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 901, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 363, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Print Preview", jPanel5);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Status:");

        jProgressBar1.setString("");
        jProgressBar1.setStringPainted(true);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(1, 1, 1)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void jTextField2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField2MouseClicked
        init_branch_locations(jTextField2, jTextField1);
    }//GEN-LAST:event_jTextField2MouseClicked

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        init_branch_locations(jTextField2, jTextField1);
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField1MouseClicked
        //        init_branch_locations();
    }//GEN-LAST:event_jTextField1MouseClicked

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        //        init_branch_locations();
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        set_report();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTextField3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3MouseClicked

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        init_inventory_barcodes();
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jCheckBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox3ActionPerformed

    private void tf_categoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_categoryMouseClicked
        init_categories();
    }//GEN-LAST:event_tf_categoryMouseClicked

    private void tf_categoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_categoryActionPerformed
        init_categories();
    }//GEN-LAST:event_tf_categoryActionPerformed

    private void tf_classificationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_classificationMouseClicked
        init_classification();
    }//GEN-LAST:event_tf_classificationMouseClicked

    private void tf_classificationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_classificationActionPerformed
        init_classification();
    }//GEN-LAST:event_tf_classificationActionPerformed

    private void tf_sub_classificationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_sub_classificationMouseClicked
        init_sub_classification();
    }//GEN-LAST:event_tf_sub_classificationMouseClicked

    private void tf_sub_classificationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_sub_classificationActionPerformed
        init_sub_classification();
    }//GEN-LAST:event_tf_sub_classificationActionPerformed

    private void tf_modelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_modelMouseClicked
        init_model();
    }//GEN-LAST:event_tf_modelMouseClicked

    private void tf_modelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_modelActionPerformed
        init_model();
    }//GEN-LAST:event_tf_modelActionPerformed

    private void tf_brandMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_brandMouseClicked
        init_brand();
    }//GEN-LAST:event_tf_brandMouseClicked

    private void tf_brandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_brandActionPerformed
        init_brand();
    }//GEN-LAST:event_tf_brandActionPerformed

    private void jCheckBox5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox5ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton3;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox10;
    private javax.swing.JCheckBox jCheckBox11;
    private javax.swing.JCheckBox jCheckBox12;
    private javax.swing.JCheckBox jCheckBox13;
    private javax.swing.JCheckBox jCheckBox14;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JCheckBox jCheckBox7;
    private javax.swing.JCheckBox jCheckBox8;
    private javax.swing.JCheckBox jCheckBox9;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTable tbl_ledger;
    private javax.swing.JTextField tf_brand;
    private javax.swing.JTextField tf_category;
    private javax.swing.JTextField tf_classification;
    private javax.swing.JTextField tf_model;
    private javax.swing.JTextField tf_sub_classification;
    // End of variables declaration//GEN-END:variables
    private void myInit() {
//        System.setProperty("pool_db", "db_smis_dumaguete_angel_buns");
        init_key();
        set_default_branch();
        init_tbl_ledger();
    }

    private void set_default_branch() {
        S1_branch_locations.to_branch_locations to = S4_branch_locations.ret_data();
        String where = " order by branch,location asc  ";
        branch_location_list = S1_branch_locations.ret_location_where(where);

        Field.Combo lo = (Field.Combo) jTextField1;
        Field.Combo br = (Field.Combo) jTextField2;
        lo.setText(to.location);
        lo.setId("" + to.id);

        br.setText(to.branch);
        br.setId("" + to.branch_id);

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

    private void set_report() {

        jProgressBar1.setString("Loading... Please wait...");
        jProgressBar1.setIndeterminate(true);
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                String where = " where user_name like '%" + "" + "%' ";
                Field.Search item = (Field.Search) jTextField3;
                Field.Combo loc = (Field.Combo) jTextField1;
                Field.Combo br = (Field.Combo) jTextField2;
                if (!jCheckBox4.isSelected()) {
                    where = where + " and main_barcode='" + item.getId() + "' ";
                }
                if (!jCheckBox2.isSelected() && !jCheckBox3.isSelected()) {
                    where = where + " and location_id='" + loc.getId() + "' ";
                }
                if (!jCheckBox2.isSelected() && jCheckBox3.isSelected()) {
                    where = where + " and branch_code='" + br.getId() + "' ";
                }
                String category = "All";
                String classification = "All";
                String sub_classification = "All";
                String brand = "All";
                String model = "All";
                if (!jCheckBox5.isSelected()) {
                    Field.Combo cat = (Field.Combo) tf_category;
                    where = where + " and category_id ='" + cat.getId() + "' ";
                    category = cat.getText();
                }
                if (!jCheckBox6.isSelected()) {
                    Field.Combo clas = (Field.Combo) tf_classification;
                    where = where + " and classification_id ='" + clas.getId() + "' ";
                    classification = clas.getText();
                }
                if (!jCheckBox7.isSelected()) {
                    Field.Combo sub_clas = (Field.Combo) tf_sub_classification;
                    where = where + " and sub_class_id ='" + sub_clas.getId() + "' ";
                    sub_classification = sub_clas.getText();
                }

                if (!jCheckBox14.isSelected()) {
                    Field.Combo bra = (Field.Combo) tf_brand;
                    where = where + " and brand_id ='" + bra.getId() + "' ";
                    brand = bra.getText();
                }
                if (!jCheckBox8.isSelected()) {
                    Field.Combo mod = (Field.Combo) tf_model;
                    where = where + " and model_id ='" + mod.getId() + "' ";
                    model = mod.getText();
                }

                where = where + " order by description asc ";
                String year = DateType.y.format(jDateChooser1.getDate());
                int month = FitIn.toInt(DateType.m1.format(jDateChooser1.getDate()));
//                System.out.println("month: "+month);
                boolean is_month_selected = true;
                String search_date = DateType.sf.format(jDateChooser1.getDate());
                List<Srpt_stock_take_by_date.field> fields = Srpt_stock_take_by_date.ret_where(where, year, month, is_month_selected, search_date);

                String business_name = System.getProperty("business_name", "Algorithm Computer Services");
                String address = System.getProperty("address", "Daro, Dumaguete City");
                String date = DateType.slash.format(jDateChooser1.getDate());
                String branch = jTextField2.getText();
                String location = jTextField1.getText();
                if (jCheckBox2.isSelected()) {
                    branch = "All";
                    location = "All";
                }
                if (jCheckBox3.isSelected() && !jCheckBox2.isSelected()) {

                    location = "All";
                }
                Srpt_stock_take_by_date rpt = new Srpt_stock_take_by_date(category, classification, sub_classification, brand, model, business_name, date, branch, location);
                rpt.fields.addAll(fields);
                String jrxml = "rpt_stock_take_date.jrxml";
                if (!jCheckBox9.isSelected()) {
                    jrxml = "rpt_stock_take_date_long.jrxml";
                }
                if (!jCheckBox1.isSelected()) {
                    jrxml = "rpt_stock_take_date_price.jrxml";
                    if (!jCheckBox9.isSelected()) {
                        jrxml = "rpt_stock_take_date_price_long.jrxml";
                    }
                }
                jLabel11.setText("" + fields.size());
                report_customers_aging(rpt, jrxml);
                loadData_ledger(fields);
                jProgressBar1.setString("Finished...");
                jProgressBar1.setIndeterminate(false);
            }
        });

        t.start();
    }

    private void report_customers_aging(final Srpt_stock_take_by_date to, String jrxml_name) {
        jPanel5.removeAll();
        jPanel5.setLayout(new BorderLayout());
        try {
            JRViewer viewer = get_viewer_customers_aging(to, jrxml_name);
            JPanel pnl = new JPanel();
            pnl.add(viewer);
            pnl.setVisible(true);
            pnl.setVisible(true);
            jPanel5.add(viewer);
            jPanel5.updateUI();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer_customers_aging(Srpt_stock_take_by_date to, String rpt_name) {
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
            InputStream is = Srpt_stock_take_by_date.class.
                    getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);
            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

    List<S1_branch_locations.to_branch_locations> branch_location_list = new ArrayList();

    private void init_branch_locations(JTextField b, JTextField t) {
        final Field.Combo br = (Field.Combo) b;
        final Field.Combo lo = (Field.Combo) t;

        Object[][] obj = new Object[branch_location_list.size()][2];
        int i = 0;
        for (S1_branch_locations.to_branch_locations to : branch_location_list) {
            obj[i][0] = " " + to.branch + " - [ " + to.location + " ]";

            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {lo.getWidth()};
        int width = 0;
        String[] col_names = {"Code"};
        TableRenderer tr = new TableRenderer();
        TableRenderer.setPopup(br, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                S1_branch_locations.to_branch_locations to = branch_location_list.get(data.selected_row);
                lo.setText("" + to.location);
                lo.setId("" + to.id);
                br.setText(to.branch);
                br.setId("" + to.branch_id);
            }
        });
    }

    List<Inventory_barcodes.to_inventory_barcodes> inventory_barcoders_list = new ArrayList();

    private void init_inventory_barcodes() {
        final Field.Combo br = (Field.Combo) jTextField1;
        jProgressBar1.setString("Searching...");
        jProgressBar1.setIndeterminate(true);
        jTextField1.setEnabled(false);
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                String search = jTextField3.getText();
                String where = " where ";
                if (jCheckBox10.isSelected()) {
                    where = where + "  main_barcode like '" + search + "' and location_id='" + br.getId() + "' "
                            + " or barcode like '" + search + "' and location_id='" + br.getId() + "' "
                            + " or description like '%" + search + "%' and location_id='" + br.getId() + "'";
                }
                if (jCheckBox11.isSelected()) {
                    where = where + "  main_barcode like '" + search + "' and location_id='" + br.getId() + "' "
                            + "  ";
                }
                if (jCheckBox12.isSelected()) {
                    where = where + " "
                            + "  barcode like '" + search + "' and location_id='" + br.getId() + "'";
                }
                if (jCheckBox13.isSelected()) {
                    where = where + "  description like '%" + search + "%' and location_id='" + br.getId() + "' ";
                }
                where = where + " order by description asc ";

                inventory_barcoders_list.clear();
                inventory_barcoders_list = Inventory_barcodes.ret_where(where);

                if (inventory_barcoders_list.size() == 1) {
                    Inventory_barcodes.to_inventory_barcodes to = (Inventory_barcodes.to_inventory_barcodes) inventory_barcoders_list.get(0);
                    Field.Search se = (Field.Search) jTextField3;
                    se.setText(to.description);
                    se.setId(to.main_barcode);

                }
                if (inventory_barcoders_list.size() > 1) {
                    Object[][] obj = new Object[inventory_barcoders_list.size()][6];
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

                        unit = unit.replaceAll("#", "/");
                        obj[i][3] = " " + unit;
                        obj[i][4] = " " + FitIn.fmt_wc_0(to.cost);
                        obj[i][5] = " " + FitIn.fmt_wc_0(to.selling_price);
                        i++;
                    }
                    JLabel[] labels = {};
                    double width = jTextField3.getWidth();
                    width = width * .60;
                    int w = FitIn.toInt("" + width);
                    int[] tbl_widths_customers = {50, 100, w, 30, 50, 50};
                    String[] col_names = {"Qty", "ItemCode", "Description", "Unit", "Cost", "Price"};
                    TableRenderer tr = new TableRenderer();
                    TableRenderer.setPopup(jTextField3, obj, labels, tbl_widths_customers, col_names);

                    tr.setCallback(new TableRenderer.Callback() {
                        @Override
                        public void ok(TableRenderer.OutputData data) {
                            Inventory_barcodes.to_inventory_barcodes to = (Inventory_barcodes.to_inventory_barcodes) inventory_barcoders_list.get(data.selected_row);
                            Field.Search se = (Field.Search) jTextField3;
                            se.setText(to.description);
                            se.setId(to.main_barcode);

                        }
                    });
                }
                jProgressBar1.setString("Finished...");
                jProgressBar1.setIndeterminate(false);
            }
        });
        t.start();
    }

    List<S1_inventory_category.to_inventory_category> categories = new ArrayList();

    private void init_categories() {
        if (!jCheckBox5.isSelected()) {
            String where = " where name like '%" + tf_category.getText() + "%' order by name asc";
            categories.clear();
            categories = S1_inventory_category.ret_data2(where);
            Object[][] obj = new Object[categories.size()][1];
            int i = 0;
            for (S1_inventory_category.to_inventory_category to : categories) {
                obj[i][0] = " " + to.name.toUpperCase();
                i++;
            }
            JLabel[] labels = {};
            int[] tbl_widths_customers = {tf_category.getWidth()};
            String[] col_names = {"Name"};
            TableRenderer tr = new TableRenderer();
            TableRenderer.setPopup(tf_category, obj, labels, tbl_widths_customers, col_names);
            tr.setCallback(new TableRenderer.Callback() {
                @Override
                public void ok(TableRenderer.OutputData data) {
                    Field.Combo category = (Field.Combo) tf_category;
                    S1_inventory_category.to_inventory_category to = (S1_inventory_category.to_inventory_category) categories.get(data.selected_row);
                    category.setId("" + to.id);
                    category.setText("" + to.name.toUpperCase());

                }
            });
        }

    }
    List<S1_inventory_classification.to_inventory_classification> classification_list = new ArrayList();

    private void init_classification() {
        if (!jCheckBox6.isSelected()) {
            Field.Combo category = (Field.Combo) tf_category;
            String where = " where name like '%" + tf_classification.getText() + "%' and category_code='" + category.getId() + "' order by name asc";
            if (jCheckBox5.isSelected()) {
                where = " where name like '%" + tf_classification.getText() + "%'  order by name asc";
            }
            classification_list.clear();
            classification_list = S1_inventory_classification.ret_data2(where);
            Object[][] obj = new Object[classification_list.size()][1];
            int i = 0;
            for (S1_inventory_classification.to_inventory_classification to : classification_list) {
                obj[i][0] = " " + to.name.toUpperCase();
                i++;
            }
            JLabel[] labels = {};
            int[] tbl_widths_customers = {tf_classification.getWidth()};

            String[] col_names = {"Name"};
            TableRenderer tr = new TableRenderer();
            TableRenderer.
                    setPopup(tf_classification, obj, labels, tbl_widths_customers, col_names);
            tr.setCallback(new TableRenderer.Callback() {
                @Override
                public void ok(TableRenderer.OutputData data) {
                    Field.Combo classification = (Field.Combo) tf_classification;
                    S1_inventory_classification.to_inventory_classification to = classification_list.get(data.selected_row);
                    classification.setText(to.name.toUpperCase());
                    classification.setId("" + to.id);

                }
            });
        }
    }

    List<S1_inventory_sub_classification.to_inventory_sub_classification> sub_classification_list = new ArrayList();

    private void init_sub_classification() {
        if (!jCheckBox7.isSelected()) {
            Field.Combo classification = (Field.Combo) tf_classification;
            String where = " where name like '%" + tf_sub_classification.getText() + "%' and classification_code='" + classification.getId() + "' order by name asc";
            if (jCheckBox6.isSelected()) {
                where = " where name like '%" + tf_sub_classification.getText() + "%'  order by name asc";
            }

            sub_classification_list.clear();
            sub_classification_list = S1_inventory_sub_classification.ret_data2(where);
            Object[][] obj = new Object[sub_classification_list.size()][1];
            int i = 0;
            for (S1_inventory_sub_classification.to_inventory_sub_classification to : sub_classification_list) {
                obj[i][0] = " " + to.name.toUpperCase();
                i++;
            }
            JLabel[] labels = {};
            int[] tbl_widths_customers = {tf_sub_classification.getWidth()};
            String[] col_names = {"Name"};
            TableRenderer tr = new TableRenderer();
            TableRenderer.setPopup(tf_sub_classification, obj, labels, tbl_widths_customers, col_names);
            tr.setCallback(new TableRenderer.Callback() {
                @Override
                public void ok(TableRenderer.OutputData data) {
                    Field.Combo sub_classification = (Field.Combo) tf_sub_classification;
                    S1_inventory_sub_classification.to_inventory_sub_classification to = sub_classification_list.get(data.selected_row);
                    sub_classification.setText(to.name.toUpperCase());
                    sub_classification.setId("" + to.id);

                }
            });
        }

    }
    List<servicing.category.S1_inventory_brand.to_inventory_brand> brand_list = new ArrayList();

    private void init_brand() {
        if (!jCheckBox14.isSelected()) {
            String where = " where name like '%" + tf_brand.getText() + "%' order by name asc";
            brand_list.clear();
            brand_list = servicing.category.S1_inventory_brand.ret_data2(where);
            Object[][] obj = new Object[brand_list.size()][1];
            int i = 0;
            for (servicing.category.S1_inventory_brand.to_inventory_brand to : brand_list) {
                obj[i][0] = " " + to.name.toUpperCase();
                i++;
            }
            JLabel[] labels = {};
            int[] tbl_widths_customers = {tf_category.getWidth()};

            String[] col_names = {"Name"};
            TableRenderer tr = new TableRenderer();
            TableRenderer.
                    setPopup(tf_brand, obj, labels, tbl_widths_customers, col_names);
            tr.setCallback(new TableRenderer.Callback() {
                @Override
                public void ok(TableRenderer.OutputData data) {
                    Field.Combo brand = (Field.Combo) tf_brand;
                    servicing.category.S1_inventory_brand.to_inventory_brand to = brand_list.get(data.selected_row);
                    brand.setText(to.name.toUpperCase());
                    brand.setId("" + to.id);

                }
            });
        }

    }

    List<S1_inventory_model.to_inventory_model> model_list = new ArrayList();

    private void init_model() {
        if (!jCheckBox8.isSelected()) {
            Field.Combo brand = (Field.Combo) tf_brand;

            String where = " where name like '%" + tf_model.getText() + "%' and brand_code= '" + brand.getId() + "'order by name asc";
            if (jCheckBox14.isSelected()) {
                where = " where name like '%" + tf_model.getText() + "%' order by name asc";
            }

            model_list.clear();
            model_list = S1_inventory_model.ret_data2(where);
            Object[][] obj = new Object[model_list.size()][1];
            int i = 0;
            for (S1_inventory_model.to_inventory_model to : model_list) {
                obj[i][0] = " " + to.name.toUpperCase();
                i++;
            }
            JLabel[] labels = {};
            int[] tbl_widths_customers = {tf_model.getWidth()};
            int width = 0;
            String[] col_names = {"Name"};
            TableRenderer tr = new TableRenderer();
            TableRenderer.
                    setPopup(tf_model, obj, labels, tbl_widths_customers, col_names);
            tr.setCallback(new TableRenderer.Callback() {
                @Override
                public void ok(TableRenderer.OutputData data) {
                    Field.Combo model = (Field.Combo) tf_model;
                    S1_inventory_model.to_inventory_model to = model_list.get(data.selected_row);
                    model.setText(to.name.toUpperCase());
                    model.setId("" + to.id);

                }
            });
        }
    }

    private ArrayListModel tbl_ledger_ALM;
    private TblledgerModel tbl_ledger_M;

    private void init_tbl_ledger() {
        tbl_ledger_ALM = new ArrayListModel();
        tbl_ledger_M = new TblledgerModel(tbl_ledger_ALM);
        tbl_ledger.getTableHeader().
                setPreferredSize(new Dimension(100, 40));
        tbl_ledger.setModel(tbl_ledger_M);
        tbl_ledger.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_ledger.setRowHeight(25);
        int[] tbl_widths_banks = {70, 80, 100, 180, 80, 80};
        for (int i = 0, n = tbl_widths_banks.length; i < n; i++) {
            if (i == 2) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_ledger, i, tbl_widths_banks[i]);
        }
        Dimension d = tbl_ledger.getTableHeader().
                getPreferredSize();
        d.height = 25;
        tbl_ledger.getTableHeader().
                setPreferredSize(d);
        tbl_ledger.getTableHeader().
                setFont(new java.awt.Font("Arial", 0, 11));
        tbl_ledger.setRowHeight(25);
        tbl_ledger.setFont(new java.awt.Font("Arial", 0, 11));
        TableWidthUtilities.setColumnRightRenderer(tbl_ledger, 4);
        TableWidthUtilities.setColumnRightRenderer(tbl_ledger, 5);
    }

    private void loadData_ledger(List<Srpt_stock_take_by_date.field> acc) {
        tbl_ledger_ALM.clear();
        tbl_ledger_ALM.addAll(acc);
    }

    public static class TblledgerModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Qty", "Item Code", "Description", "Location", "Cost", "Amount"
        };

        public TblledgerModel(ListModel listmodel) {
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
            Srpt_stock_take_by_date.field tt = (Srpt_stock_take_by_date.field) getRow(row);
            switch (col) {
                case 0:
                    return " " + tt.getQty();
                case 1:
                    return " " + tt.getItem_code();
                case 2:
                    return " " + tt.getDescription();
                case 3:
                    return " " + tt.getLocation();
                case 4:
                    return FitIn.fmt_wc_0(tt.getCost()) + " ";

                default:
                    return FitIn.fmt_wc_0(tt.cost * tt.qty) + " ";
            }
        }
    }
}
