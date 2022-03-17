package admin;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;

public class RequestPane extends JPanel{
    //Gui - swing
    private JLabel idLabel, nameLabel, emailLabel, phoneLabel, roleLabel,selectRowLabel;
    private JTextField registrationIdTF, registrationNameTF, registrationEmailTF, registrationPhoneTF, registrationAccountTF;
    private JPanel manageRequestPanel1,manageRequestPanel2;
    private JButton approveBtn, declineBtn,refreshRegistrationBtn;
    private JScrollPane manageRequestScrollPane1, manageRequestScrollPane2,registrationTableScrollPane;
    private JTable registrationTable;

    //Controller
    private RequestContr requestContr = new RequestContr(this);

    //Constructor
    public RequestPane(){
        manageRequestPanel1 = new javax.swing.JPanel();
        manageRequestScrollPane1 = new javax.swing.JScrollPane();
        manageRequestPanel2 = new javax.swing.JPanel();
        approveBtn = new javax.swing.JButton();
        declineBtn = new javax.swing.JButton();
        registrationIdTF = new javax.swing.JTextField();
        idLabel = new javax.swing.JLabel();
        registrationNameTF = new javax.swing.JTextField();
        nameLabel = new javax.swing.JLabel();
        emailLabel = new javax.swing.JLabel();
        phoneLabel = new javax.swing.JLabel();
        roleLabel = new javax.swing.JLabel();
        registrationEmailTF = new javax.swing.JTextField();
        registrationPhoneTF = new javax.swing.JTextField();
        registrationAccountTF = new javax.swing.JTextField();
        manageRequestScrollPane2 = new javax.swing.JScrollPane();
        registrationTableScrollPane = new javax.swing.JScrollPane();
        registrationTable = new javax.swing.JTable();
        refreshRegistrationBtn = new javax.swing.JButton();
        selectRowLabel = new javax.swing.JLabel();

        manageRequestPanel1.setBackground(new java.awt.Color(255, 204, 204));

        manageRequestPanel2.setBackground(new java.awt.Color(255,204, 204));
        manageRequestPanel2.setPreferredSize(new java.awt.Dimension(726, 544));

        approveBtn.setFont(new java.awt.Font("Segoe UI", 1, 14));
        approveBtn.setText("Approve");
        approveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requestContr.approveBtnActionPerformed(registrationTable);
            }
        });

        declineBtn.setFont(new java.awt.Font("Segoe UI", 1, 14));
        declineBtn.setText("Decline");
        declineBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requestContr.declineBtnActionPerformed(registrationTable);
            }
        });

        idLabel.setFont(new java.awt.Font("Segoe UI", Font.BOLD, 14));
        idLabel.setText("ID");

        nameLabel.setFont(new java.awt.Font("Segoe UI", Font.BOLD, 14));
        nameLabel.setText("Name");

        emailLabel.setFont(new java.awt.Font("Segoe UI", Font.BOLD, 14));
        emailLabel.setText("Email");

        phoneLabel.setFont(new java.awt.Font("Segoe UI", Font.BOLD, 14));
        phoneLabel.setText("Phone (+60)");

        roleLabel.setFont(new java.awt.Font("Segoe UI", Font.BOLD, 14));
        roleLabel.setText("Role");

        registrationTable.setDefaultEditor(Object.class, null);
        registrationTable.setRowSelectionAllowed(true);
        registrationTable.setSelectionBackground(Color.pink);
        requestContr.setDefaultTable(registrationTable);
        registrationTable.getTableHeader().setReorderingAllowed(false);
        registrationTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                registrationTableMouseClicked();
            }
        });
        registrationTableScrollPane.setViewportView(registrationTable);
        manageRequestScrollPane2.setViewportView(registrationTableScrollPane);

        refreshRegistrationBtn.setFont(new java.awt.Font("Segoe UI", 1, 14));
        refreshRegistrationBtn.setText("Refresh Registration Table");
        refreshRegistrationBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requestContr.setDefaultTable(registrationTable);
            }
        });

        selectRowLabel.setFont(new java.awt.Font("Segoe UI", 1, 18));
        selectRowLabel.setText("Please select a row to approve or decline.");

        //Alignment
        javax.swing.GroupLayout manageRequestPanel2Layout = new javax.swing.GroupLayout(manageRequestPanel2);
        manageRequestPanel2.setLayout(manageRequestPanel2Layout);
        manageRequestPanel2Layout.setHorizontalGroup(
                manageRequestPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, manageRequestPanel2Layout.createSequentialGroup()
                                .addGroup(manageRequestPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(manageRequestPanel2Layout.createSequentialGroup()
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(declineBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(manageRequestPanel2Layout.createSequentialGroup()
                                                .addGap(21, 21, 21)
                                                .addGroup(manageRequestPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(manageRequestPanel2Layout.createSequentialGroup()
                                                                .addGroup(manageRequestPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(idLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(roleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(phoneLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(nameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(emailLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(selectRowLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(manageRequestPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(manageRequestPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                                .addComponent(registrationEmailTF, javax.swing.GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)
                                                                                .addComponent(registrationPhoneTF)
                                                                                .addComponent(registrationAccountTF))
                                                                        .addGroup(manageRequestPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                                .addComponent(registrationNameTF, javax.swing.GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)
                                                                                .addComponent(registrationIdTF)))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(approveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(manageRequestScrollPane2))))
                                .addGap(18, 18, 18)
                                .addComponent(refreshRegistrationBtn)
                                .addGap(19, 19, 19))
        );
        manageRequestPanel2Layout.setVerticalGroup(
                manageRequestPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(manageRequestPanel2Layout.createSequentialGroup()
                                .addGroup(manageRequestPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(manageRequestPanel2Layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(manageRequestScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(manageRequestPanel2Layout.createSequentialGroup()
                                                .addGap(150, 150, 150)
                                                .addComponent(refreshRegistrationBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(manageRequestPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(manageRequestPanel2Layout.createSequentialGroup()
                                                .addGap(219, 219, 219)
                                                .addComponent(declineBtn))
                                        .addGroup(manageRequestPanel2Layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(selectRowLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(28, 28, 28)
                                                .addGroup(manageRequestPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(idLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(registrationIdTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(39, 39, 39)
                                                .addGroup(manageRequestPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(registrationNameTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(approveBtn))
                                                .addGap(42, 42, 42)
                                                .addGroup(manageRequestPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(emailLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(registrationEmailTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(35, 35, 35)
                                                .addGroup(manageRequestPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(phoneLabel)
                                                        .addComponent(registrationPhoneTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(38, 38, 38)
                                .addGroup(manageRequestPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(roleLabel)
                                        .addComponent(registrationAccountTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(37, Short.MAX_VALUE))
        );

        manageRequestScrollPane1.setViewportView(manageRequestPanel2);

        javax.swing.GroupLayout manageRequestPanel1Layout = new javax.swing.GroupLayout(manageRequestPanel1);
        manageRequestPanel1.setLayout(manageRequestPanel1Layout);
        manageRequestPanel1Layout.setHorizontalGroup(
                manageRequestPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, manageRequestPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(manageRequestScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1293, Short.MAX_VALUE)
                                .addContainerGap())
        );
        manageRequestPanel1Layout.setVerticalGroup(
                manageRequestPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(manageRequestPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(manageRequestScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 712, Short.MAX_VALUE)
                                .addContainerGap())
        );
    }

    //getter
    public JPanel getPanel(){
        return manageRequestPanel2;
    }

    //setter
    public void setTableContent(JTable table) { this.registrationTable = table; } //set registration request's table's data

    public void registrationTableMouseClicked() { //set registration request's JTextFills' text while row clicked
        DefaultTableModel table = (DefaultTableModel)registrationTable.getModel();
        int selectedRow = registrationTable.getSelectedRow();

        registrationIdTF.setText(table.getValueAt(selectedRow, 0).toString());
        registrationNameTF.setText(table.getValueAt(selectedRow, 1).toString());
        registrationEmailTF.setText(table.getValueAt(selectedRow, 3).toString());
        registrationPhoneTF.setText(table.getValueAt(selectedRow, 2).toString());
        registrationAccountTF.setText(table.getValueAt(selectedRow, 4).toString());
        registrationAccountTF.setEditable(false);
        registrationEmailTF.setEditable(false);
        registrationIdTF.setEditable(false);
        registrationNameTF.setEditable(false);
        registrationPhoneTF.setEditable(false);
    }

}
