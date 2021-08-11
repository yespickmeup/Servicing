/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicing.utils;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

/**
 *
 * @author Guinness
 */
public class Button {

    public static class Default extends JButton {

        public Default() {
            this.setBackground(new java.awt.Color(240, 240, 240));
            this.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
            this.setForeground(new java.awt.Color(0, 0, 0));
            this.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, false));
            this.setContentAreaFilled(false);
            this.setFocusable(false);
            this.setOpaque(true);
            if (!Default.this.isEnabled()) {
                Default.this.setBackground(new java.awt.Color(240, 240, 240));
            } else {
                Default.this.setBackground(new java.awt.Color(230, 230, 230));
            }
            this.addMouseListener(new MouseAdapter() {

                @Override
                public void mouseEntered(MouseEvent e) {

                    if (!Default.this.isEnabled()) {
                        Default.this.setBackground(new java.awt.Color(240, 240, 240));
                    } else {
                        Default.this.setBackground(new java.awt.Color(230, 230, 230));
                    }
                }

                @Override
                public void mouseExited(MouseEvent e) {

                    Default.this.setBackground(new java.awt.Color(240, 240, 240));
                }

            });
        }

    }

    public static class Search extends JButton {

        public Search() {
            this.setBackground(new java.awt.Color(240, 240, 240));
            this.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
            this.setForeground(new java.awt.Color(0, 0, 0));
            this.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, false));
            this.setContentAreaFilled(false);
            this.setFocusable(false);
            this.setOpaque(true);
            if (!Search.this.isEnabled()) {
                Search.this.setBackground(new java.awt.Color(240, 240, 240));
            } else {
                Search.this.setBackground(new java.awt.Color(230, 230, 230));
            }
            this.addMouseListener(new MouseAdapter() {

                @Override
                public void mouseClicked(MouseEvent e) {

                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    if (!Search.this.isEnabled()) {
                        Search.this.setBackground(new java.awt.Color(240, 240, 240));
                    } else {
                        Search.this.setBackground(new java.awt.Color(230, 230, 230));
                    }

                }

                @Override
                public void mouseExited(MouseEvent e) {
                    if (!Search.this.isEnabled()) {
                        Search.this.setBackground(new java.awt.Color(240, 240, 240));
                    } else {
                        Search.this.setBackground(new java.awt.Color(230, 230, 230));
                    }

                }

            });
        }

        public void load() {
            Search.this.setIcon(new javax.swing.ImageIcon(getClass().getResource("/synsoftech/fields/wall24.png"))); // NOI18N
            Search.this.setBackground(new java.awt.Color(241, 218, 218));
            Search.this.enable(false);
            Search.this.setEnabled(false);
            Search.this.setToolTipText("Loading, Please wait...");

        }

        public void finish() {
            Search.this.setIcon(new javax.swing.ImageIcon(getClass().getResource("/synsoftech/fields/search19.png"))); // NOI18N
            Search.this.setBackground(new java.awt.Color(240, 240, 240));
            Search.this.enable(true);
            Search.this.setEnabled(true);
        }
    }

    public static class Primary extends JButton {

        public Primary() {
            this.setBackground(new java.awt.Color(66, 139, 202));

            this.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
            this.setForeground(new java.awt.Color(255, 255, 255));
            this.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, false));
            this.setContentAreaFilled(false);
            this.setFocusable(false);
            this.setOpaque(true);
            if (!Primary.this.isEnabled()) {
                Primary.this.setBackground(new java.awt.Color(240, 240, 240));
            } else {
                Primary.this.setBackground(new java.awt.Color(48, 113, 169));
            }
            this.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    if (!Primary.this.isEnabled()) {
                        Primary.this.setBackground(new java.awt.Color(240, 240, 240));
                    } else {
                        Primary.this.setBackground(new java.awt.Color(48, 113, 169));
                    }

                }

                @Override
                public void mouseExited(MouseEvent e) {
                    if (!Primary.this.isEnabled()) {
                        Primary.this.setBackground(new java.awt.Color(240, 240, 240));
                    } else {
                        Primary.this.setBackground(new java.awt.Color(66, 139, 202));
                    }

                }

            });

        }

        public void set_enabled(final boolean stmt) {
            Primary.this.setEnabled(stmt);
            if (stmt) {
                Primary.this.setBackground(new java.awt.Color(48, 113, 169));
            } else {
                Primary.this.setBackground(new java.awt.Color(240, 240, 240));
            }
        }

    }

    public static class Success extends JButton {

        public Success() {
            this.setBackground(new java.awt.Color(92, 184, 92));
            this.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
            this.setForeground(new java.awt.Color(255, 255, 255));
            this.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, false));
            this.setContentAreaFilled(false);
            this.setFocusable(false);
            this.setOpaque(true);
            if (!Success.this.isEnabled()) {
                Success.this.setBackground(new java.awt.Color(240, 240, 240));
            } else {
                Success.this.setBackground(new java.awt.Color(83, 165, 83));
            }
            this.addMouseListener(new MouseAdapter() {

                @Override
                public void mouseEntered(MouseEvent e) {
                    if (!Success.this.isEnabled()) {
                        Success.this.setBackground(new java.awt.Color(240, 240, 240));
                    } else {
                        Success.this.setBackground(new java.awt.Color(83, 165, 83));
                    }

                }

                @Override
                public void mouseExited(MouseEvent e) {
                    if (!Success.this.isEnabled()) {
                        Success.this.setBackground(new java.awt.Color(240, 240, 240));
                    } else {
                        Success.this.setBackground(new java.awt.Color(92, 184, 92));
                    }

                }

            });
        }

        public void set_enabled(final boolean stmt) {
            Success.this.setEnabled(stmt);
            if (stmt) {
                Success.this.setBackground(new java.awt.Color(83, 165, 83));
            } else {
                Success.this.setBackground(new java.awt.Color(240, 240, 240));
            }
        }

    }

    public static class Info extends JButton {

        public Info() {

            if (!this.isEnabled()) {
                this.setBackground(new java.awt.Color(240, 240, 240));
            } else {
                this.setBackground(new java.awt.Color(91, 192, 222));
                this.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
                this.setForeground(new java.awt.Color(255, 255, 255));
                this.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, false));
                this.setContentAreaFilled(false);
                this.setFocusable(false);
                this.setOpaque(true);
                this.updateUI();
            }

            this.addMouseListener(new MouseAdapter() {

                @Override
                public void mouseEntered(MouseEvent e) {
                    if (!Info.this.isEnabled()) {
                        Info.this.setBackground(new java.awt.Color(240, 240, 240));
                    } else {
                        Info.this.setBackground(new java.awt.Color(49, 176, 213));
                    }

                }

                @Override
                public void mouseExited(MouseEvent e) {
                    if (!Info.this.isEnabled()) {
                        Info.this.setBackground(new java.awt.Color(240, 240, 240));
                    } else {
                        Info.this.setBackground(new java.awt.Color(91, 192, 222));
                    }

                }

            });
        }

        public void set_enabled(final boolean stmt) {
            Info.this.setEnabled(stmt);
            if (stmt) {
                Info.this.setBackground(new java.awt.Color(91, 192, 222));
            } else {
                Info.this.setBackground(new java.awt.Color(240, 240, 240));
            }
        }
    }

    public static class Warning extends JButton {

        public Warning() {
            this.setBackground(new java.awt.Color(240, 173, 78));
            this.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
            this.setForeground(new java.awt.Color(255, 255, 255));
            this.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, false));
            this.setContentAreaFilled(false);
            this.setFocusable(false);
            this.setOpaque(true);
            if (!Warning.this.isEnabled()) {
                Warning.this.setBackground(new java.awt.Color(240, 240, 240));
            } else {
                Warning.this.setBackground(new java.awt.Color(236, 151, 31));
            }
            this.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    if (!Warning.this.isEnabled()) {
                        Warning.this.setBackground(new java.awt.Color(240, 240, 240));
                    } else {
                        Warning.this.setBackground(new java.awt.Color(236, 151, 31));
                    }

                }

                @Override
                public void mouseExited(MouseEvent e) {
                    if (!Warning.this.isEnabled()) {
                        Warning.this.setBackground(new java.awt.Color(240, 240, 240));
                    } else {
                        Warning.this.setBackground(new java.awt.Color(240, 173, 78));
                    }

                }
            });
        }

        public void set_enabled(final boolean stmt) {
            Warning.this.setEnabled(stmt);
            if (stmt) {
                Warning.this.setBackground(new java.awt.Color(91, 192, 222));
            } else {
                Warning.this.setBackground(new java.awt.Color(240, 240, 240));
            }
        }

    }

    public static class Dangerous extends JButton {

        public Dangerous() {
            this.setBackground(new java.awt.Color(217, 83, 79));
            this.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
            this.setForeground(new java.awt.Color(255, 255, 255));
            this.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, false));
            this.setContentAreaFilled(false);
            this.setFocusable(false);
            this.setOpaque(true);
            if (!Dangerous.this.isEnabled()) {
                Dangerous.this.setBackground(new java.awt.Color(240, 240, 240));
            } else {
                Dangerous.this.setBackground(new java.awt.Color(201, 48, 44));
            }
            this.addMouseListener(new MouseAdapter() {

                @Override
                public void mouseEntered(MouseEvent e) {
                    if (!Dangerous.this.isEnabled()) {
                        Dangerous.this.setBackground(new java.awt.Color(240, 240, 240));
                    } else {
                        Dangerous.this.setBackground(new java.awt.Color(201, 48, 44));
                    }

                }

                @Override
                public void mouseExited(MouseEvent e) {
                    if (!Dangerous.this.isEnabled()) {
                        Dangerous.this.setBackground(new java.awt.Color(240, 240, 240));
                    } else {
                        Dangerous.this.setBackground(new java.awt.Color(217, 83, 79));
                    }

                }

            });
        }

        public void set_enabled(final boolean stmt) {
            Dangerous.this.setEnabled(stmt);
            if (stmt) {
                Dangerous.this.setBackground(new java.awt.Color(201, 48, 44));
            } else {
                Dangerous.this.setBackground(new java.awt.Color(240, 240, 240));
            }
        }
    }

    public static class Orange extends JButton {

        public Orange() {
            this.setBackground(new java.awt.Color(48, 113, 169));
            this.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
            this.setForeground(new java.awt.Color(255, 255, 255));
            this.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, false));
            this.setContentAreaFilled(false);
            this.setFocusable(false);
            this.setOpaque(true);
            if (!Orange.this.isEnabled()) {
                Orange.this.setBackground(new java.awt.Color(240, 240, 240));
            } else {
                Orange.this.setBackground(new java.awt.Color(238, 156, 7));
            }

            this.addMouseListener(new MouseAdapter() {

                @Override
                public void mouseEntered(MouseEvent e) {
                    if (!Orange.this.isEnabled()) {
                        Orange.this.setBackground(new java.awt.Color(240, 240, 240));
                    } else {
                        Orange.this.setBackground(new java.awt.Color(238, 156, 7));
                    }

                }

                @Override
                public void mouseExited(MouseEvent e) {
                    if (!Orange.this.isEnabled()) {
                        Orange.this.setBackground(new java.awt.Color(240, 240, 240));
                    } else {
                        Orange.this.setBackground(new java.awt.Color(48, 113, 169));
                    }

                }

            });
        }

        public void set_enabled(final boolean stmt) {
            Orange.this.setEnabled(stmt);
            if (stmt) {
                Orange.this.setBackground(new java.awt.Color(238, 156, 7));
            } else {
                Orange.this.setBackground(new java.awt.Color(240, 240, 240));
            }
        }
    }

    public static class Tooltip extends JButton {

        public Tooltip() {
            this.addMouseListener(new MouseAdapter() {

                @Override
                public void mouseEntered(MouseEvent e) {

                }

                @Override
                public void mouseExited(MouseEvent e) {

                }

            });
        }

    }

    public static class Print extends JButton {

        public Print() {
            this.setBackground(new java.awt.Color(240, 240, 240));
            this.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
            this.setForeground(new java.awt.Color(0, 0, 0));
            this.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 0, false));
            this.setContentAreaFilled(false);
            this.setFocusable(false);
            this.setOpaque(true);

            this.addMouseListener(new MouseAdapter() {

                @Override
                public void mouseClicked(MouseEvent e) {

                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    if (Print.this.isEnabled()) {
                        Print.this.setBackground(new java.awt.Color(230, 230, 230));
                    }

                }

                @Override
                public void mouseExited(MouseEvent e) {
                    if (Print.this.isEnabled()) {
                        Print.this.setBackground(new java.awt.Color(240, 240, 240));
                    }

                }

            });
        }

        public void load() {
            Print.this.setIcon(new javax.swing.ImageIcon(getClass().getResource("/synsoftech/fields/wall24.png"))); // NOI18N
            Print.this.setBackground(new java.awt.Color(241, 218, 218));
            Print.this.enable(false);
            Print.this.setEnabled(false);
            Print.this.setToolTipText("Loading, Please wait...");

        }

        public void finish() {
            Print.this.setIcon(new javax.swing.ImageIcon(getClass().getResource("/synsoftech/fields/printer67.png"))); // NOI18N
            Print.this.setBackground(new java.awt.Color(240, 240, 240));
            Print.this.enable(true);
            Print.this.setEnabled(true);
        }
    }

}
