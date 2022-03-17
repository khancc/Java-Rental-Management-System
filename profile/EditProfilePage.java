package profile;

import main.Frame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EditProfilePage extends Frame {

    //GUI - swing
    private JButton SubmitButton;
    private JPanel componentPanel1, bgPanel, editProfilePanel, contentPanel;
    private JLabel backLabel, emailLabel, nameLabel, passwordLabel, phoneLabel, titleLabel, usernameLabel;
    private JTextField emailTF, usernameTF, nameTF, passwordTF, phoneTF;
    private JScrollPane jScrollPane2;

    //Controller
    private EditProfileContr editProfileContr = new EditProfileContr(getFrame());

    //Constructor
    public EditProfilePage() {
        bgPanel = new JPanel();
        jScrollPane2 = new JScrollPane();
        editProfilePanel = new JPanel();
        contentPanel = new JPanel();
        componentPanel1 = new JPanel();
        backLabel = new JLabel();
        nameLabel = new JLabel();
        emailLabel = new JLabel();
        phoneLabel = new JLabel();
        usernameLabel = new JLabel();
        passwordLabel = new JLabel();
        nameTF = new JTextField();
        emailTF = new JTextField();
        phoneTF = new JTextField();
        usernameTF = new JTextField();
        passwordTF = new JTextField();
        SubmitButton = new JButton();
        titleLabel = new JLabel();

        this.setTitle("Edit Profile");
        this.setResizable(true);

        backLabel.setIcon(new ImageIcon(getClass().getResource("/image/back-red.png"))); // NOI18N
        backLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        backLabel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                editProfileContr.backLabelMouseClicked();
            }
        });


        bgPanel.setBackground(new Color(255, 255, 255));
        editProfilePanel.setBackground(new Color(255, 204, 204));

        contentPanel.setBackground(new Color(255, 255, 255));
        contentPanel.setPreferredSize(new Dimension(800, 570));

        componentPanel1.setBackground(new Color(255, 255, 255));
        componentPanel1.setBorder(BorderFactory.createLineBorder(new Color(186, 79, 84), 3));

        nameLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16)); // NOI18N
        nameLabel.setText("Name:");

        emailLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16)); // NOI18N
        emailLabel.setText("Email:");

        phoneLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16)); // NOI18N
        phoneLabel.setText("Phone:");

        usernameLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16)); // NOI18N
        usernameLabel.setText("Username:");

        passwordLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16)); // NOI18N
        passwordLabel.setText("Password:");

        setInitialValue();

        SubmitButton.setFont(new Font("Segoe UI", Font.BOLD, 16)); // NOI18N
        SubmitButton.setText("Submit");
        SubmitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //get all user input to be passed to the controller
                String[] editedValues = new String[5];
                editedValues[0] = nameTF.getText();
                editedValues[1] = phoneTF.getText();
                editedValues[2] = emailTF.getText();
                editedValues[3] = usernameTF.getText();
                editedValues[4] = passwordTF.getText();
                editProfileContr.SubmitButtonActionPerformed(editedValues);
            }
        });

        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 24)); // NOI18N
        titleLabel.setText("Edit Profile");

        //Alignment
        GroupLayout componentPanel1Layout = new GroupLayout(componentPanel1);
        componentPanel1.setLayout(componentPanel1Layout);
        componentPanel1Layout.setHorizontalGroup(
                componentPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(componentPanel1Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(componentPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(usernameLabel, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                        .addComponent(passwordLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(phoneLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(emailLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(nameLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(componentPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(nameTF, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(passwordTF, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(usernameTF, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(phoneTF, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(emailTF, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(622, Short.MAX_VALUE))
        );
        componentPanel1Layout.setVerticalGroup(
                componentPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(componentPanel1Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addGroup(componentPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(nameLabel)
                                        .addComponent(nameTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(componentPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(emailLabel)
                                        .addComponent(emailTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(componentPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(phoneLabel)
                                        .addComponent(phoneTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(componentPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(usernameLabel)
                                        .addComponent(usernameTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(componentPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(passwordLabel)
                                        .addComponent(passwordTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(30, Short.MAX_VALUE))
        );

        GroupLayout propertyPanelLayout = new GroupLayout(contentPanel);
        contentPanel.setLayout(propertyPanelLayout);
        propertyPanelLayout.setHorizontalGroup(
                propertyPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(propertyPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(propertyPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(componentPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(propertyPanelLayout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(SubmitButton)))
                                .addContainerGap())
        );
        propertyPanelLayout.setVerticalGroup(
                propertyPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(propertyPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(componentPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(SubmitButton)
                                .addContainerGap(27, Short.MAX_VALUE))
        );

        GroupLayout EditProfileContainPanelLayout = new GroupLayout(editProfilePanel);
        editProfilePanel.setLayout(EditProfileContainPanelLayout);
        EditProfileContainPanelLayout.setHorizontalGroup(
                EditProfileContainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(EditProfileContainPanelLayout.createSequentialGroup()

                                .addContainerGap()
                                .addGroup(EditProfileContainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(contentPanel, GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
                                        .addGroup(EditProfileContainPanelLayout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(backLabel, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(titleLabel)
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        EditProfileContainPanelLayout.setVerticalGroup(
                EditProfileContainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(EditProfileContainPanelLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(backLabel, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                                .addComponent(titleLabel)
                                .addGap(18, 18, 18)
                                .addComponent(contentPanel, GroupLayout.PREFERRED_SIZE, 330, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(100, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(editProfilePanel);

        GroupLayout bgPanelLayout = new GroupLayout(bgPanel);
        bgPanel.setLayout(bgPanelLayout);
        bgPanelLayout.setHorizontalGroup(
                bgPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 1300, Short.MAX_VALUE)
        );
        bgPanelLayout.setVerticalGroup(
                bgPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 300, Short.MAX_VALUE)
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 991, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(bgPanel, GroupLayout.PREFERRED_SIZE, 1300, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 804, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(bgPanel, GroupLayout.PREFERRED_SIZE, 300, Short.MAX_VALUE)
                                        .addContainerGap()))
        );

        pack();
        setLocationRelativeTo(null);
    }

    public void setInitialValue(){ //set textFills' text value
        String[] initialValues = editProfileContr.setInitialValues();
        nameTF.setText(initialValues[0]);
        phoneTF.setText(initialValues[1]);
        emailTF.setText(initialValues[2]);
        usernameTF.setText(initialValues[3]);
        passwordTF.setText(initialValues[4]);
    }
}