package login;

import main.Frame;
import register.RegisterView;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginPage extends Frame {

    //GUI - swing
    private JLabel backLabel,logoIconLabel,errorLabel,iconLabel1,iconLabel2,registerLabel,roleLabel,titleLabel;
    private JButton loginButton;
    private JPasswordField passwordPF;
    private JSeparator passwordSep,usernameSep;
    private JPanel pinkBgPanel,whiteBgPanel;
    private JTextField usernameTF;
    private String nameEntered,passwordEntered;

    //Controller
    private LoginContr loginContr = new LoginContr(this);

    //Constructor
    LoginPage(int roleNumber){

        loginContr.setRole(roleNumber); //set which role did user choose
        this.setTitle("Login Page");
        this.setSize(new Dimension(570, 639));

        whiteBgPanel = new JPanel();
        pinkBgPanel = new JPanel();
        usernameTF = new JTextField();
        passwordPF = new JPasswordField();
        usernameSep = new JSeparator();
        passwordSep = new JSeparator();
        iconLabel1 = new JLabel();
        iconLabel2 = new JLabel();
        titleLabel = new JLabel();
        loginButton = new JButton();
        logoIconLabel = new JLabel();
        registerLabel = new JLabel();
        roleLabel = new JLabel();
        backLabel = new JLabel();
        errorLabel = new JLabel();

        setBgColor1(whiteBgPanel, pinkBgPanel);
        pinkBgPanel.setBorder(BorderFactory.createCompoundBorder());

        usernameTF.setBackground(new Color(186, 79, 84));
        usernameTF.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        usernameTF.setForeground(new Color(204, 204, 204));
        usernameTF.setHorizontalAlignment(JTextField.CENTER);
        usernameTF.setText("Username");
        usernameTF.setBorder(null);
        usernameTF.setCaretColor(new Color(255, 255, 255));

        passwordPF.setBackground(new Color(186, 79, 84));
        passwordPF.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        passwordPF.setForeground(new Color(204, 204, 204));
        passwordPF.setHorizontalAlignment(JTextField.CENTER);
        passwordPF.setText("Password");
        passwordPF.setBorder(null);

        usernameSep.setBackground(new Color(255, 255, 255));

        passwordSep.setBackground(new Color(255, 255, 255));

        iconLabel1.setIcon(new ImageIcon(getClass().getResource("/image/Profile.png")));

        iconLabel2.setIcon(new ImageIcon(getClass().getResource("/image/Lock.png")));

        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 30));
        titleLabel.setForeground(new Color(255, 255, 255));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setText("Login");

        loginButton.setBackground(Color.white);
        loginButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        loginButton.setForeground(new Color(51, 51, 51));
        loginButton.setText("Log In");
        loginButton.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        loginButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        loginButton.setFocusPainted(false);
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                //get user input and to be referenced by controller
                nameEntered = usernameTF.getText();
                passwordEntered = String.valueOf(passwordPF.getPassword());
                loginContr.loginButtonActionPerformed(roleNumber);
            }
        });

        errorLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        errorLabel.setForeground(new Color(0, 204, 51));
        errorLabel.setHorizontalAlignment(SwingConstants.CENTER);
        errorLabel.setText("Wrong Username and Password");
        errorLabel.setVisible(false);

        logoIconLabel.setHorizontalAlignment(SwingConstants.CENTER);
        logoIconLabel.setIcon(new ImageIcon(getClass().getResource("/image/CyberentLogo.png")));

        registerLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        registerLabel.setForeground(new Color(204, 204, 204));
        registerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        registerLabel.setText("Doesn't Have a Account? Click Here to Create");
        registerLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        registerLabel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                close();
                new RegisterView(roleNumber).setVisible(true);
            }
        });

        roleLabel.setFont(new Font("SansSerif", Font.BOLD, 12));
        roleLabel.setForeground(new Color(204, 204, 204));
        roleLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        roleLabel.setText(super.getRoleString(roleNumber));

        backLabel.setIcon(new ImageIcon(getClass().getResource("/image/Back.png")));
        backLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        backLabel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                close();
                new PreLoginPage().setVisible(true);
            }
        });

        //Alignment
        GroupLayout pinkBgPanelLayout = new GroupLayout(pinkBgPanel);
        pinkBgPanel.setLayout(pinkBgPanelLayout);
        pinkBgPanelLayout.setHorizontalGroup(
                pinkBgPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, pinkBgPanelLayout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(titleLabel, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(pinkBgPanelLayout.createSequentialGroup()
                                .addGap(245, 245, 245)
                                .addComponent(loginButton, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(pinkBgPanelLayout.createSequentialGroup()
                                .addGap(113, 113, 113)
                                .addComponent(registerLabel, GroupLayout.PREFERRED_SIZE, 346, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(102, Short.MAX_VALUE))
                        .addGroup(pinkBgPanelLayout.createSequentialGroup()
                                .addGap(173, 173, 173)
                                .addComponent(errorLabel, GroupLayout.PREFERRED_SIZE, 222, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, pinkBgPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(backLabel, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(roleLabel, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                        .addComponent(logoIconLabel, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pinkBgPanelLayout.createSequentialGroup()
                                .addGap(158, 158, 158)
                                .addGroup(pinkBgPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addGroup(pinkBgPanelLayout.createSequentialGroup()
                                                .addGap(2, 2, 2)
                                                .addComponent(iconLabel1, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(iconLabel2, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pinkBgPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(usernameSep)
                                        .addComponent(usernameTF)
                                        .addComponent(passwordPF)
                                        .addComponent(passwordSep, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pinkBgPanelLayout.setVerticalGroup(
                pinkBgPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(pinkBgPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(pinkBgPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(roleLabel, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(backLabel, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
                                .addGap(17, 17, 17)
                                .addComponent(logoIconLabel, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(titleLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                                .addGroup(pinkBgPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(iconLabel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(usernameTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(usernameSep, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(pinkBgPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(iconLabel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(passwordPF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(passwordSep, GroupLayout.PREFERRED_SIZE, 11, GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(loginButton, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                .addGap(11, 11, 11)
                                .addComponent(errorLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(registerLabel)
                                .addGap(128, 128, 128))
        );

        GroupLayout whiteBgPanelLayout = new GroupLayout(whiteBgPanel);
        whiteBgPanel.setLayout(whiteBgPanelLayout);
        whiteBgPanelLayout.setHorizontalGroup(
                whiteBgPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(whiteBgPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(pinkBgPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        whiteBgPanelLayout.setVerticalGroup(
                whiteBgPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(whiteBgPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(pinkBgPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(whiteBgPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(whiteBgPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }

    //getter
    public String getNameEntered(){
        return nameEntered;
    }
    public String getPasswordEntered(){
        return passwordEntered;
    }
}
