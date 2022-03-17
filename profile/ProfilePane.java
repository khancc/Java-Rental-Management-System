package profile;

import javax.swing.*;
import java.awt.*;

public class ProfilePane extends JPanel{

    //GUI - swing
    private JButton editButton;
    private JPanel profilePanel, pinkBackgroundPanel, contentPanel, thisPanel;
    private JLabel emailLabel, nameLabel, passwordLabel, phoneLabel, titleLabel, usernameLabel;
    private JTextField emailTF, nameTF, passwordTF, phoneTF, usernameTF;
    private JScrollPane jScrollPane;

    //Controller
    private ProfileContr profileContr;

    //Constructor
    public ProfilePane(ProfileContr contr) {

        profileContr = contr;

        thisPanel = new JPanel();
        jScrollPane = new JScrollPane();
        pinkBackgroundPanel = new JPanel();
        contentPanel = new JPanel();
        profilePanel = new JPanel();
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
        editButton = new JButton();
        titleLabel = new JLabel();

        thisPanel.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane.setBackground(new java.awt.Color(255, 255, 255));
        pinkBackgroundPanel.setBackground(new java.awt.Color(255, 204, 204));
        contentPanel.setBackground(new java.awt.Color(255, 255, 255));
        contentPanel.setPreferredSize(new java.awt.Dimension(726, 544));
        profilePanel.setBackground(new java.awt.Color(255, 255, 255));
        profilePanel.setBorder(BorderFactory.createLineBorder(new java.awt.Color(186, 79, 84), 3));

        titleLabel.setFont(new java.awt.Font("Segoe UI", Font.BOLD, 24)); // NOI18N
        titleLabel.setText("Profile");

        nameLabel.setFont(new java.awt.Font("Segoe UI", Font.PLAIN, 16)); // NOI18N
        nameLabel.setText("Name:");

        emailLabel.setFont(new java.awt.Font("Segoe UI", Font.PLAIN, 16)); // NOI18N
        emailLabel.setText("Email:");

        phoneLabel.setFont(new java.awt.Font("Segoe UI", Font.PLAIN, 16)); // NOI18N
        phoneLabel.setText("Phone:");

        usernameLabel.setFont(new java.awt.Font("Segoe UI", Font.PLAIN, 16)); // NOI18N
        usernameLabel.setText("Username:");

        passwordLabel.setFont(new java.awt.Font("Segoe UI", Font.PLAIN, 16)); // NOI18N
        passwordLabel.setText("Password:");

        nameTF.setBackground(new java.awt.Color(255, 255, 255, 0));
        nameTF.setEditable(false);
        nameTF.setBorder(null);

        emailTF.setBackground(new java.awt.Color(255, 255, 255, 0));
        emailTF.setEditable(false);
        emailTF.setBorder(null);

        phoneTF.setBackground(new java.awt.Color(255, 255, 255, 0));
        phoneTF.setEditable(false);
        phoneTF.setBorder(null);

        usernameTF.setBackground(new java.awt.Color(255, 255, 255, 0));
        usernameTF.setEditable(false);
        usernameTF.setBorder(null);

        passwordTF.setBackground(new java.awt.Color(255, 255, 255, 0));
        passwordTF.setEditable(false);
        passwordTF.setBorder(null);

        setInitialValue();

        editButton.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        editButton.setText("Edit Profile");
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profileContr.EditButtonActionPerformed(evt);
            }
        });

        //Alignment
        GroupLayout componentPanel1Layout = new GroupLayout(profilePanel);
        profilePanel.setLayout(componentPanel1Layout);
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
                                        .addComponent(profilePanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(propertyPanelLayout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(editButton)))
                                .addContainerGap())
        );
        propertyPanelLayout.setVerticalGroup(
                propertyPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(propertyPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(profilePanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(editButton)
                                .addContainerGap(27, Short.MAX_VALUE))
        );

        GroupLayout ProfileContainPanelLayout = new GroupLayout(pinkBackgroundPanel);
        pinkBackgroundPanel.setLayout(ProfileContainPanelLayout);
        ProfileContainPanelLayout.setHorizontalGroup(
                ProfileContainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(ProfileContainPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(ProfileContainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(contentPanel, GroupLayout.DEFAULT_SIZE, 971, Short.MAX_VALUE)
                                        .addGroup(ProfileContainPanelLayout.createSequentialGroup()
                                                .addComponent(titleLabel)
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        ProfileContainPanelLayout.setVerticalGroup(
                ProfileContainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(ProfileContainPanelLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(titleLabel)
                                .addGap(18, 18, 18)
                                .addComponent(contentPanel, GroupLayout.PREFERRED_SIZE, 290, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(422, Short.MAX_VALUE))
        );

        jScrollPane.setViewportView(pinkBackgroundPanel);

        GroupLayout whiteBgPanelLayout = new GroupLayout(this);
        this.setLayout(whiteBgPanelLayout);
        whiteBgPanelLayout.setHorizontalGroup(
                whiteBgPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane, GroupLayout.DEFAULT_SIZE, 991, Short.MAX_VALUE)
        );
        whiteBgPanelLayout.setVerticalGroup(
                whiteBgPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane)
        );
    }

    public void setInitialValue(){ //set textFills' text value
        String[] initialValues = profileContr.setInitialValues();
        nameTF.setText(initialValues[0]);
        phoneTF.setText(initialValues[1]);
        emailTF.setText(initialValues[2]);
        usernameTF.setText(initialValues[3]);
        passwordTF.setText(initialValues[4]);
    }
}
