package register;

import main.Frame;
import javax.swing.*;
import login.PreLoginPage;
import java.awt.*;

public class RegisterView extends Frame{

    //Gui - swing
    private JLabel prePhoneLabel, backLabel, descriptionLabel1, descriptionLabel2, iconLabel1, iconLabel2, iconLabel3, loginLabel, logoIconLabel, roleLabel, titleLabel;
    private JSeparator emailSep,nameSep, phoneSep;
    private JTextField emailTF, nameTF1, phoneTF;
    private JPanel pinkBgPanel, whiteBgPanel;
    private JButton signUpButton;
    private String nameEntered,emailEntered,phoneEntered;

    //Controller
    private RegisterContr registerContr = new RegisterContr(this);

    //Constructor
    public RegisterView(int roleNumber){
        this.setTitle("Register Page");
        this.setSize(new Dimension(570, 639));

        whiteBgPanel = new javax.swing.JPanel();
        pinkBgPanel = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        nameTF1 = new javax.swing.JTextField();
        nameSep = new javax.swing.JSeparator();
        phoneTF = new javax.swing.JTextField();
        phoneSep = new javax.swing.JSeparator();
        emailTF = new javax.swing.JTextField();
        emailSep = new javax.swing.JSeparator();
        iconLabel1 = new javax.swing.JLabel();
        iconLabel2 = new javax.swing.JLabel();
        iconLabel3 = new javax.swing.JLabel();
        signUpButton = new javax.swing.JButton();
        logoIconLabel = new javax.swing.JLabel();
        loginLabel = new javax.swing.JLabel();
        roleLabel = new javax.swing.JLabel();
        backLabel = new javax.swing.JLabel();
        descriptionLabel1 = new javax.swing.JLabel();
        descriptionLabel2 = new javax.swing.JLabel();
        prePhoneLabel = new javax.swing.JLabel();

        setBgColor1(whiteBgPanel, pinkBgPanel);
        pinkBgPanel.setBorder(BorderFactory.createCompoundBorder());

        titleLabel.setFont(new java.awt.Font("SansSerif", Font.BOLD, 30)); // NOI18N
        titleLabel.setForeground(new java.awt.Color(255, 255, 255));
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("Registration");

        nameTF1.setBackground(new java.awt.Color(186, 79, 84));
        nameTF1.setFont(new java.awt.Font("Segoe UI", Font.PLAIN, 18)); // NOI18N
        nameTF1.setForeground(new java.awt.Color(204, 204, 204));
        nameTF1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        nameTF1.setText("Your Name");
        nameTF1.setBorder(null);
        nameTF1.setCaretColor(new java.awt.Color(255, 255, 255));

        nameSep.setBackground(new java.awt.Color(255, 255, 255));
        nameSep.setForeground(new java.awt.Color(255, 255, 255));

        phoneTF.setBackground(new java.awt.Color(186, 79, 84));
        phoneTF.setFont(new java.awt.Font("Segoe UI", Font.PLAIN, 18)); // NOI18N
        phoneTF.setForeground(new java.awt.Color(204, 204, 204));
        phoneTF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        phoneTF.setText("Phone Number");
        phoneTF.setBorder(null);
        phoneTF.setCaretColor(new java.awt.Color(255, 255, 255));

        phoneSep.setBackground(new java.awt.Color(255, 255, 255));
        phoneSep.setForeground(new java.awt.Color(255, 255, 255));

        emailTF.setBackground(new java.awt.Color(186, 79, 84));
        emailTF.setFont(new java.awt.Font("Segoe UI", Font.PLAIN, 18)); // NOI18N
        emailTF.setForeground(new java.awt.Color(204, 204, 204));
        emailTF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        emailTF.setText("Email Address");
        emailTF.setBorder(null);
        emailTF.setCaretColor(new java.awt.Color(255, 255, 255));

        emailSep.setBackground(new java.awt.Color(255, 255, 255));
        emailSep.setForeground(new java.awt.Color(255, 255, 255));

        iconLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Profile.png"))); // NOI18N

        iconLabel2.setBackground(new java.awt.Color(255, 255, 255));
        iconLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Phone.png"))); // NOI18N

        iconLabel3.setBackground(new java.awt.Color(255, 255, 255));
        iconLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Email.png"))); // NOI18N

        signUpButton.setBackground(Color.white);
        signUpButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        signUpButton.setForeground(new java.awt.Color(51, 51, 51));
        signUpButton.setText("Sign Up");
        signUpButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        signUpButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        signUpButton.setFocusPainted(false);
        signUpButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                //get user input to be referenced by controller
                nameEntered = nameTF1.getText();
                phoneEntered = phoneTF.getText();
                emailEntered = emailTF.getText();
                registerContr.signUpButtonMouseClicked(roleNumber);
            }
        });

        logoIconLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logoIconLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/CyberentLogo.png"))); // NOI18N

        loginLabel.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        loginLabel.setForeground(new java.awt.Color(204, 204, 204));
        loginLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        loginLabel.setText("Already Have an account? Click Here to Log In");
        loginLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        loginLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                close();
                new PreLoginPage().setVisible(true);
            }
        });

        roleLabel.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        roleLabel.setForeground(new java.awt.Color(204, 204, 204));
        roleLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        roleLabel.setText(super.getRoleString(roleNumber));

        backLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Back.png"))); // NOI18N
        backLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        backLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                close();
                new PreRegisterView().setVisible(true);
            }
        });

        descriptionLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        descriptionLabel1.setForeground(new java.awt.Color(204, 204, 204));
        descriptionLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        descriptionLabel1.setText("the system after Registration Approved");
        descriptionLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        descriptionLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        descriptionLabel2.setForeground(new java.awt.Color(204, 204, 204));
        descriptionLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        descriptionLabel2.setText("Username and Password will be autogenerated by");
        descriptionLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        prePhoneLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        prePhoneLabel.setForeground(new java.awt.Color(204, 204, 204));
        prePhoneLabel.setText("+60");

        //Alignment
        javax.swing.GroupLayout pinkBgPanelLayout = new javax.swing.GroupLayout(pinkBgPanel);
        pinkBgPanel.setLayout(pinkBgPanelLayout);
        pinkBgPanelLayout.setHorizontalGroup(
                pinkBgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pinkBgPanelLayout.createSequentialGroup()
                                .addGap(111, 111, 111)
                                .addGroup(pinkBgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(pinkBgPanelLayout.createSequentialGroup()
                                                .addGroup(pinkBgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(iconLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(iconLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 2, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(iconLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pinkBgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(nameSep)
                                        .addGroup(pinkBgPanelLayout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addComponent(prePhoneLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                                                .addComponent(phoneTF, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(62, 62, 62))
                                        .addComponent(emailTF)
                                        .addComponent(nameTF1)
                                        .addComponent(phoneSep)
                                        .addComponent(emailSep))
                                .addGap(132, 132, 132))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pinkBgPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(backLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(roleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                        .addComponent(logoIconLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pinkBgPanelLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(174, 174, 174))
                        .addGroup(pinkBgPanelLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(pinkBgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(descriptionLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(descriptionLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(pinkBgPanelLayout.createSequentialGroup()
                                .addGap(244, 244, 244)
                                .addComponent(signUpButton, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(pinkBgPanelLayout.createSequentialGroup()
                                .addGap(76, 76, 76)
                                .addComponent(loginLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pinkBgPanelLayout.setVerticalGroup(
                pinkBgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pinkBgPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(pinkBgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(roleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(backLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(17, 17, 17)
                                .addComponent(logoIconLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(titleLabel)
                                .addGap(30, 30, 30)
                                .addComponent(descriptionLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(descriptionLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                                .addGroup(pinkBgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(iconLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(nameTF1))
                                .addGroup(pinkBgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(pinkBgPanelLayout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(nameSep, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addGroup(pinkBgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(phoneTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(pinkBgPanelLayout.createSequentialGroup()
                                                                .addComponent(prePhoneLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(1, 1, 1)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(phoneSep, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(emailTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(emailSep, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(pinkBgPanelLayout.createSequentialGroup()
                                                .addGap(31, 31, 31)
                                                .addComponent(iconLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(iconLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(34, 34, 34)
                                .addComponent(signUpButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(loginLabel)
                                .addGap(64, 64, 64))
        );

        javax.swing.GroupLayout whiteBgPanelLayout = new javax.swing.GroupLayout(whiteBgPanel);
        whiteBgPanel.setLayout(whiteBgPanelLayout);
        whiteBgPanelLayout.setHorizontalGroup(
                whiteBgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(whiteBgPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(pinkBgPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        whiteBgPanelLayout.setVerticalGroup(
                whiteBgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(whiteBgPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(pinkBgPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(whiteBgPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(whiteBgPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
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
}
