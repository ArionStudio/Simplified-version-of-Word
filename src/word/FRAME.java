/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package word;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.*;

/**
 *
 * @author Adrian
 */
class CheckBoxIcon implements Icon {

    @Override
    public void paintIcon(Component component, Graphics g, int x, int y) {
        AbstractButton abstractButton = (AbstractButton) component;
        ButtonModel buttonModel = abstractButton.getModel();

        Color color = buttonModel.isSelected() ? new Color(230, 230, 230) : new Color(230, 230, 230);
        g.setColor(color);
        if (buttonModel.isSelected()) {
            g.fillRect(1, 3, 20, 20);
        } else {
            g.drawRect(1, 3, 20, 20);
        }

    }

    @Override
    public int getIconWidth() {
        return 20;
    }

    @Override
    public int getIconHeight() {
        return 20;
    }
}

public final class FRAME extends JFrame implements ActionListener {

    private Color fontColor = new Color(0, 0, 0);
    private Color backColor = new Color(255, 255, 255);
    private boolean textWraped = true;
    private boolean textBold = false;
    private boolean textItalic = false;
    private boolean save = true;
    private int fontSize = 12;
    private String fontFamily = "Tahoma";
    private File rootFile = null;

    /**
     * Creates new form FRAME
     */
    public FRAME() {
        setTitle("Word PRO EDITON FOR PRO USERS FROM PRO PROGRAMERS");

        initComponents();
        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        initStyle();

        addWindowListener(
                new WindowAdapter() {
            Object[] mes = {"Czy chcesz zapisać zmiany w pliku?"};

            @Override
            public void windowClosing(WindowEvent windowEvent) {
                exitWord();
            }
        }
        );
    }

    private void initStyle() {
        try {
            //UIManager.setLookAndFeel(new SyntheticalFlatLafLight);
        } catch (Exception e) {

        }
        wordArea.requestFocus();
        wordArea.setOpaque(false);
        functionPanel.setOpaque(false);
        functionPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, new Color(230, 230, 230)));
        //menuBar.setBorderPainted(false);
        styleControl(thick);
        styleControl(italy);
        styleControl(copy);
        styleControl(paste);
        styleControl(erase);
        styleControl(textWrap);
        styleControl(fontSizeSelect);
        styleControl(fontFamilySelect);
    }

    private void letterCount() {
        String text = wordArea.getText();
        text = text.replaceAll("\\s+", "");
        letterCount.setText(text.length() + "");
    }

    private void styleControl(JComboBox control) {
        control.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255), 0));
        control.setBackground(new Color(255, 255, 255));
        control.setOpaque(true);
        control.setForeground(Color.BLUE);
    }

    private void styleControl(JButton control) {
        control.setBorderPainted(false);
        control.setFocusPainted(false);
        control.setContentAreaFilled(false);
        control.setBorderPainted(true);
        control.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255), 1));
        control.setFocusPainted(false);
        control.setBackground(new Color(230, 230, 230));
        control.setOpaque(true);
        control.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent me) {
                control.setBackground(new Color(190, 190, 190));
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent me) {
                control.setBackground(new Color(230, 230, 230));
                repaint();
            }
        });
    }

    private void styleControl(JCheckBox control) {

        Icon checked = new CheckBoxIcon();
        Icon unchecked = new CheckBoxIcon();

        control.setIcon(unchecked);
        control.setSelectedIcon(checked);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        functionPanel = new javax.swing.JPanel();
        copy = new javax.swing.JButton();
        paste = new javax.swing.JButton();
        erase = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        fontFamilySelect = new javax.swing.JComboBox<>();
        fontSizeSelect = new javax.swing.JComboBox<>();
        thick = new javax.swing.JButton();
        italy = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        fontColorField = new javax.swing.JTextField();
        backColorField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        textWrap = new javax.swing.JCheckBox();
        wordAreaPanel = new javax.swing.JScrollPane();
        wordArea = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        letterCount = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        newOpt = new javax.swing.JMenuItem();
        openOpt = new javax.swing.JMenuItem();
        saveOpt = new javax.swing.JMenuItem();
        saveAsOpt = new javax.swing.JMenuItem();
        CloseOpt = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        functionPanel.setBackground(new java.awt.Color(255, 255, 255));
        functionPanel.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);

        copy.setBackground(new java.awt.Color(255, 255, 255));
        copy.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        copy.setText("Kopiuj");
        copy.setBorder(null);
        copy.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        copy.setFocusPainted(false);
        copy.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                copyMouseClicked(evt);
            }
        });
        copy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copyActionPerformed(evt);
            }
        });

        paste.setBackground(new java.awt.Color(255, 255, 255));
        paste.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        paste.setText("Wklej");
        paste.setBorder(null);
        paste.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        paste.setFocusPainted(false);
        paste.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pasteMouseClicked(evt);
            }
        });

        erase.setBackground(new java.awt.Color(255, 255, 255));
        erase.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        erase.setText("Wytnij");
        erase.setBorder(null);
        erase.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        erase.setFocusPainted(false);
        erase.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                eraseMouseClicked(evt);
            }
        });
        erase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eraseActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        fontFamilySelect.setEditable(true);
        fontFamilySelect.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Arial", "Calibri", "Consolas", "Tahoma", "Times New Roman", "Bodoni MT", "CommercialScript BT", "Complex", "Copperplate Gothic Bold", "Copperplate Gothic Light", "Eras Bold ITC", "Eras Demi ITC", "Eras Light ITC", "EuroRoman" }));
        fontFamilySelect.setSelectedIndex(3);
        fontFamilySelect.setPreferredSize(new java.awt.Dimension(50, 25));
        fontFamilySelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fontFamilySelectActionPerformed(evt);
            }
        });

        fontSizeSelect.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "48", "72", "96", "102" }));
        fontSizeSelect.setSelectedIndex(11);
        fontSizeSelect.setPreferredSize(new java.awt.Dimension(50, 25));
        fontSizeSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fontSizeSelectActionPerformed(evt);
            }
        });

        thick.setBackground(new java.awt.Color(255, 255, 255));
        thick.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        thick.setText("B");
        thick.setToolTipText("");
        thick.setBorder(null);
        thick.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        thick.setFocusPainted(false);
        thick.setPreferredSize(new java.awt.Dimension(50, 25));
        thick.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                thickMouseClicked(evt);
            }
        });
        thick.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                thickActionPerformed(evt);
            }
        });

        italy.setBackground(new java.awt.Color(255, 255, 255));
        italy.setFont(new java.awt.Font("Arial", 2, 11)); // NOI18N
        italy.setText("I");
        italy.setBorder(null);
        italy.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        italy.setFocusPainted(false);
        italy.setPreferredSize(new java.awt.Dimension(50, 25));
        italy.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                italyMouseClicked(evt);
            }
        });
        italy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                italyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(fontFamilySelect, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fontSizeSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(thick, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(italy, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(fontFamilySelect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fontSizeSelect, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(thick, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(italy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        fontColorField.setBackground(new java.awt.Color(0, 0, 0));
        fontColorField.setToolTipText("");
        fontColorField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fontColorField.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        fontColorField.setFocusable(false);
        fontColorField.setPreferredSize(new java.awt.Dimension(50, 25));
        fontColorField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fontColorFieldMouseClicked(evt);
            }
        });
        fontColorField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fontColorFieldActionPerformed(evt);
            }
        });

        backColorField.setToolTipText("");
        backColorField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        backColorField.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        backColorField.setFocusable(false);
        backColorField.setPreferredSize(new java.awt.Dimension(50, 25));
        backColorField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backColorFieldMouseClicked(evt);
            }
        });
        backColorField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backColorFieldActionPerformed(evt);
            }
        });

        jLabel1.setText("Kolor czcionki");
        jLabel1.setPreferredSize(new java.awt.Dimension(50, 25));

        jLabel2.setText("Kolor tła");
        jLabel2.setPreferredSize(new java.awt.Dimension(50, 25));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fontColorField, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(backColorField, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fontColorField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(backColorField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        textWrap.setBackground(new java.awt.Color(255, 255, 255));
        textWrap.setSelected(true);
        textWrap.setText("Zawijanie tekstu");
        textWrap.setMargin(new java.awt.Insets(3, 3, 3, 3));
        textWrap.setPreferredSize(new java.awt.Dimension(50, 25));
        textWrap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textWrapActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout functionPanelLayout = new javax.swing.GroupLayout(functionPanel);
        functionPanel.setLayout(functionPanelLayout);
        functionPanelLayout.setHorizontalGroup(
            functionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(functionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(textWrap, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(copy, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(paste, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(erase, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        functionPanelLayout.setVerticalGroup(
            functionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(functionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(functionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(erase, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(paste, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(copy, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textWrap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        wordAreaPanel.setBackground(new java.awt.Color(255, 255, 255));
        wordAreaPanel.setBorder(null);

        wordArea.setColumns(20);
        wordArea.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        wordArea.setLineWrap(true);
        wordArea.setRows(5);
        wordArea.setBorder(null);
        wordArea.setInheritsPopupMenu(true);
        wordArea.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                wordAreaCaretUpdate(evt);
            }
        });
        wordAreaPanel.setViewportView(wordArea);

        jLabel3.setText("Liczba znaków:");

        letterCount.setText("0");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(functionPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(wordAreaPanel)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(letterCount)
                .addGap(51, 51, 51))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(functionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(wordAreaPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 749, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(letterCount, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        menuBar.setBackground(new java.awt.Color(255, 255, 255));
        menuBar.setBorder(null);
        menuBar.setAutoscrolls(true);
        menuBar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jMenu1.setBackground(new java.awt.Color(255, 255, 255));
        jMenu1.setText("File");
        jMenu1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenu1.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);

        newOpt.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        newOpt.setText("Nowy");
        newOpt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newOptActionPerformed(evt);
            }
        });
        jMenu1.add(newOpt);

        openOpt.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        openOpt.setText("Otwórz");
        openOpt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openOptActionPerformed(evt);
            }
        });
        jMenu1.add(openOpt);

        saveOpt.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        saveOpt.setText("Zapisz");
        saveOpt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveOptActionPerformed(evt);
            }
        });
        jMenu1.add(saveOpt);

        saveAsOpt.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        saveAsOpt.setText("Zapisz jako");
        saveAsOpt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveAsOptActionPerformed(evt);
            }
        });
        jMenu1.add(saveAsOpt);

        CloseOpt.setText("Zamknij");
        CloseOpt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CloseOptActionPerformed(evt);
            }
        });
        jMenu1.add(CloseOpt);

        menuBar.add(jMenu1);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void eraseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eraseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_eraseActionPerformed

    private void italyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_italyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_italyActionPerformed

    private void fontColorFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fontColorFieldMouseClicked
        Color buffor = fontColor;
        fontColor = JColorChooser.showDialog(null, "Wybierz kolor: ", fontColor);
        if (fontColor == null) {
            fontColor = buffor;
        }
        fontColorField.setBackground(fontColor);
        wordArea.setForeground(fontColor);
        wordArea.requestFocus();
    }//GEN-LAST:event_fontColorFieldMouseClicked

    private void backColorFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backColorFieldMouseClicked
        Color buffor = backColor;
        backColor = JColorChooser.showDialog(null, "Wybierz kolor: ", backColor);
        if (backColor == null) {
            backColor = buffor;
        }

        backColorField.setBackground(backColor);
        wordArea.setBackground(backColor);
        wordArea.requestFocus();
    }//GEN-LAST:event_backColorFieldMouseClicked

    private void backColorFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backColorFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_backColorFieldActionPerformed

    private void copyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copyActionPerformed

    }//GEN-LAST:event_copyActionPerformed

    private void thickActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_thickActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_thickActionPerformed

    private void textWrapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textWrapActionPerformed
        textWraped = !textWraped;
        wordArea.setLineWrap(textWraped);
        wordArea.requestFocus();
        wordArea.requestFocus();
    }//GEN-LAST:event_textWrapActionPerformed

    private void fontColorFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fontColorFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fontColorFieldActionPerformed

    private void thickMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_thickMouseClicked
        textBold = !textBold;
        int fontStyle = (textItalic ? 1 : 0) * 2 + (textBold ? 1 : 0);
        wordArea.setFont(wordArea.getFont().deriveFont(fontStyle));
        wordArea.requestFocus();
    }//GEN-LAST:event_thickMouseClicked

    private void italyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_italyMouseClicked
        textItalic = !textItalic;
        int fontStyle = (textItalic ? 1 : 0) * 2 + (textBold ? 1 : 0);
        wordArea.setFont(wordArea.getFont().deriveFont(fontStyle));
        wordArea.requestFocus();
    }//GEN-LAST:event_italyMouseClicked

    private void fontSizeSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fontSizeSelectActionPerformed
        fontSize = fontSizeSelect.getSelectedIndex() + 1;
        wordArea.setFont(wordArea.getFont().deriveFont((float) fontSize));
        wordArea.requestFocus();
    }//GEN-LAST:event_fontSizeSelectActionPerformed

    private void fontFamilySelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fontFamilySelectActionPerformed
        fontFamily = fontFamilySelect.getSelectedItem().toString();
        int fontStyle = (textItalic ? 1 : 0) * 2 + (textBold ? 1 : 0);
        wordArea.setFont(new Font(fontFamily, fontStyle, fontSize));
        Font f = new Font(fontFamily, 0, 12);
        wordArea.requestFocus();
    }//GEN-LAST:event_fontFamilySelectActionPerformed

    private void fileSave(File chosenFile) {
        try {
            FileWriter fW = new FileWriter(chosenFile, false);
            BufferedWriter writer = new BufferedWriter(fW);
            writer.write(wordArea.getText());
            writer.flush();
            writer.close();
            save = true;
        } catch (IOException e) {

        }
    }

    private void fileSaveWithFileChooser() {
        JFileChooser fCh = new JFileChooser();
        fCh.setDialogTitle("Zapisz plik");
        if (fCh.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            rootFile = new File(fCh.getSelectedFile().getAbsolutePath());
            fileSave(rootFile);
        }

    }

    private void exitWord() {
        Object[] mes1 = {"Czy chcesz zapisać zmiany w pliku?"};
        Object[] mes2 = {"Chcesz zapisać plik?"};
        int answer = 1;
        if (!save) {
            if (rootFile != null) {
                answer = JOptionPane.showConfirmDialog(wordArea, mes1, "Word", 1);
                if (answer == 0) {
                    fileSave(rootFile);
                }
            } else {
                answer = JOptionPane.showConfirmDialog(wordArea, mes2, "Word", 1);
                if (answer == 0) {
                    fileSaveWithFileChooser();
                }
            }
        }
        if (answer != 2) {
            System.exit(0);
        }
    }

    private void CloseOptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CloseOptActionPerformed
        exitWord();
    }//GEN-LAST:event_CloseOptActionPerformed

    private void newOptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newOptActionPerformed
        Object[] mes1 = {"Czy chcesz zapisać zmiany w pliku?"};
        Object[] mes2 = {"Chcesz zapisać plik?"};
        int answer = 2;
        if (!save) {
            if (rootFile != null) {
                answer = JOptionPane.showConfirmDialog(wordArea, mes1, "Word", 1);
                if (answer == 0) {
                    fileSave(rootFile);
                }
            } else {
                answer = JOptionPane.showConfirmDialog(wordArea, mes2, "Word", 1);
                if (answer == 0) {
                    fileSaveWithFileChooser();
                }
            }

        }
        if (answer != 2) {
            wordArea.setText("");
        }
        wordArea.requestFocus();
    }//GEN-LAST:event_newOptActionPerformed

    private void copyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_copyMouseClicked
        wordArea.copy();
        wordArea.requestFocus();
    }//GEN-LAST:event_copyMouseClicked

    private void pasteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pasteMouseClicked
        wordArea.paste();
        wordArea.requestFocus();
    }//GEN-LAST:event_pasteMouseClicked

    private void eraseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eraseMouseClicked
        wordArea.cut();
        wordArea.requestFocus();
    }//GEN-LAST:event_eraseMouseClicked

    private void wordAreaCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_wordAreaCaretUpdate
        save = false;
        letterCount();
    }//GEN-LAST:event_wordAreaCaretUpdate

    private void openOptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openOptActionPerformed
        Object[] mes1 = {"Czy chcesz zapisać zmiany w pliku?"};
        Object[] mes2 = {"Chcesz zapisać plik?"};
        int answer = 1;
        if (!save) {
            if (rootFile != null) {
                answer = JOptionPane.showConfirmDialog(wordArea, mes1, "Word", 1);
                if (answer == 0) {
                    fileSave(rootFile);
                }
            } else {
                answer = JOptionPane.showConfirmDialog(wordArea, mes2, "Word", 1);
                if (answer == 0) {
                    fileSaveWithFileChooser();
                }
            }

        }
        if (answer != 2) {
            JFileChooser fCh = new JFileChooser();
            fCh.setDialogTitle("Otwieranie");
            if (fCh.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                rootFile = new File(fCh.getSelectedFile().getAbsolutePath());
                try {
                    FileReader fR = new FileReader(rootFile);
                    BufferedReader bReader = new BufferedReader(fR);
                    String buffor;
                    String text = bReader.readLine();
                    while ((buffor = bReader.readLine()) != null) {
                        text += "\n" + buffor;
                    }
                    wordArea.setText(text);
                } catch (IOException e) {

                }
            }

        }
        wordArea.requestFocus();
    }//GEN-LAST:event_openOptActionPerformed

    private void saveOptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveOptActionPerformed
        if (!save) {
            if (rootFile != null) {
                fileSave(rootFile);
            }
        }
    }//GEN-LAST:event_saveOptActionPerformed

    private void saveAsOptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveAsOptActionPerformed
        fileSaveWithFileChooser();
        wordArea.requestFocus();
    }//GEN-LAST:event_saveAsOptActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FRAME.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new FRAME().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem CloseOpt;
    private javax.swing.JTextField backColorField;
    private javax.swing.JButton copy;
    private javax.swing.JButton erase;
    private javax.swing.JTextField fontColorField;
    private javax.swing.JComboBox<String> fontFamilySelect;
    private javax.swing.JComboBox<String> fontSizeSelect;
    private javax.swing.JPanel functionPanel;
    private javax.swing.JButton italy;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel letterCount;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem newOpt;
    private javax.swing.JMenuItem openOpt;
    private javax.swing.JButton paste;
    private javax.swing.JMenuItem saveAsOpt;
    private javax.swing.JMenuItem saveOpt;
    private javax.swing.JCheckBox textWrap;
    private javax.swing.JButton thick;
    private javax.swing.JTextArea wordArea;
    private javax.swing.JScrollPane wordAreaPanel;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void addActionListener(FRAME aThis) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
