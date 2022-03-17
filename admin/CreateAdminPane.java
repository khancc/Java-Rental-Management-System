package admin;

import javax.swing.*;
import java.awt.*;

public class CreateAdminPane {

    //GUI - swing
    private JLabel createAdminLabel, adminNameLabel, adminEmailLabel, adminPhoneLabel;
    private JTextField adminNameTF, adminEmailTF, adminPhoneTF;
    private JPanel createAdminPage,createAdminPanel1,createAdminPanel2;
    private JButton addAdminBtn, refreshAdminBtn;
    private JScrollPane adminTableScrollPane, createAdminScrollPane;
    private JTable adminTable;
    private String nameEntered, emailEntered, phoneEntered;

    //Controller
    private CreateAdminContr contr = new CreateAdminContr(this);

    //Constructor
    public CreateAdminPane(){
        createAdminPage = new JPanel();
        createAdminScrollPane = new JScrollPane();
        createAdminPanel1 = new JPanel();
        createAdminPanel2 = new JPanel();
        adminNameLabel = new JLabel();
        adminPhoneLabel = new JLabel();
        adminEmailLabel = new JLabel();
        addAdminBtn = new JButton();
        adminNameTF = new JTextField();
        adminPhoneTF = new JTextField();
        adminEmailTF = new JTextField();
        createAdminLabel = new JLabel();
        adminTableScrollPane = new JScrollPane();
        adminTable = new JTable();
        refreshAdminBtn = new JButton();


        createAdminPage.setBackground(new java.awt.Color(255, 204, 204));

        createAdminPanel1.setBackground(new java.awt.Color(255, 255, 255));

        createAdminPanel2.setBackground(new java.awt.Color(255, 255, 255));
        createAdminPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(186, 79, 84), 3));

        adminNameLabel.setFont(new java.awt.Font("Segoe UI", Font.PLAIN, 16));
        adminNameLabel.setText("Name:");

        adminPhoneLabel.setFont(new java.awt.Font("Segoe UI", Font.PLAIN, 16));
        adminPhoneLabel.setText("Phone (+60)");

        adminEmailLabel.setFont(new java.awt.Font("Segoe UI", Font.PLAIN, 16));
        adminEmailLabel.setText("Email");


        addAdminBtn.setFont(new java.awt.Font("Segoe UI", Font.BOLD, 14));
        addAdminBtn.setText("Add");
        addAdminBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addAdminBtn.setFocusPainted(false);
        addAdminBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameEntered = adminNameTF.getText();
                phoneEntered = adminPhoneTF.getText();
                emailEntered = adminEmailTF.getText();
                contr.addAdminBtnActionPerformed();
                System.out.print(nameEntered+phoneEntered+emailEntered);
            }
        });

        adminNameTF.setFont(new java.awt.Font("Segoe UI", 0, 12));
        adminPhoneTF.setFont(new java.awt.Font("Segoe UI", 0, 12));
        adminEmailTF.setFont(new java.awt.Font("Segoe UI", 0, 12));

        createAdminLabel.setFont(new java.awt.Font("Segoe UI", 1, 24));
        createAdminLabel.setText("Create More Admin Account");

        adminTable.setFont(new java.awt.Font("Segoe UI", 1, 14));
        adminTable.getTableHeader().setReorderingAllowed(false);
        adminTableScrollPane.setViewportView(adminTable);
        adminTable.setDefaultEditor(Object.class, null);
        contr.refreshBtnActionPerformed(adminTable);

        refreshAdminBtn.setFont(new java.awt.Font("Segoe UI", 1, 14));
        refreshAdminBtn.setText("Refresh Admin Table");
        refreshAdminBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contr.refreshBtnActionPerformed(adminTable);
            }
        });

        //Alignment 1
        javax.swing.GroupLayout createAdminPanel2Layout = new javax.swing.GroupLayout(createAdminPanel2);
        createAdminPanel2.setLayout(createAdminPanel2Layout);
        createAdminPanel2Layout.setHorizontalGroup(
                createAdminPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(createAdminPanel2Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(createAdminPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(adminPhoneLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(adminNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(adminEmailLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(168, 168, 168)
                                .addGroup(createAdminPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(adminEmailTF, javax.swing.GroupLayout.DEFAULT_SIZE, 671, Short.MAX_VALUE)
                                        .addGroup(createAdminPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(adminPhoneTF, javax.swing.GroupLayout.DEFAULT_SIZE, 671, Short.MAX_VALUE)
                                                .addComponent(adminNameTF)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(addAdminBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(19, 19, 19))
        );
        createAdminPanel2Layout.setVerticalGroup(
                createAdminPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(createAdminPanel2Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addGroup(createAdminPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(adminNameTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(adminNameLabel))
                                .addGap(18, 18, 18)
                                .addGroup(createAdminPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(adminPhoneLabel)
                                        .addComponent(adminPhoneTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(createAdminPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(adminEmailLabel)
                                        .addComponent(adminEmailTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(addAdminBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(30, Short.MAX_VALUE))
        );

        //Alignment 2
        javax.swing.GroupLayout createAdminPanel1Layout = new javax.swing.GroupLayout(createAdminPanel1);
        createAdminPanel1.setLayout(createAdminPanel1Layout);
        createAdminPanel1Layout.setHorizontalGroup(
                createAdminPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(createAdminPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(createAdminPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(createAdminPanel1Layout.createSequentialGroup()
                                                .addComponent(createAdminPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addContainerGap())
                                        .addGroup(createAdminPanel1Layout.createSequentialGroup()
                                                .addComponent(adminTableScrollPane)
                                                .addGap(32, 32, 32)
                                                .addComponent(refreshAdminBtn)
                                                .addGap(18, 18, 18))))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, createAdminPanel1Layout.createSequentialGroup()
                                .addContainerGap(410, Short.MAX_VALUE)
                                .addComponent(createAdminLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(468, 468, 468))
        );
        createAdminPanel1Layout.setVerticalGroup(
                createAdminPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(createAdminPanel1Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(createAdminLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(createAdminPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                                .addGroup(createAdminPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, createAdminPanel1Layout.createSequentialGroup()
                                                .addComponent(refreshAdminBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(205, 205, 205))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, createAdminPanel1Layout.createSequentialGroup()
                                                .addComponent(adminTableScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(29, 29, 29))))
        );

        createAdminScrollPane.setViewportView(createAdminPanel1);

        javax.swing.GroupLayout createAdminPageLayout = new javax.swing.GroupLayout(createAdminPage);
        createAdminPage.setLayout(createAdminPageLayout);
        createAdminPageLayout.setHorizontalGroup(
                createAdminPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(createAdminPageLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(createAdminScrollPane)
                                .addContainerGap())
        );
        createAdminPageLayout.setVerticalGroup(
                createAdminPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(createAdminPageLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(createAdminScrollPane)
                                .addContainerGap())
        );
    }

    //getter
    public String getNameEntered(){
        return nameEntered;
    }
    public String getPhoneEntered(){
        return phoneEntered;
    }
    public String getEmailEntered(){
        return emailEntered;
    }
    public JPanel getPanel(){
        return createAdminPage;
    }

    //setter
    public void setTableContent(JTable table) { this.adminTable = table; }


}

