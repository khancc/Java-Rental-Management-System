package login;

import main.Frame;
import main.LandingPage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PreLoginPage extends Frame {

    //Gui - swing
    private JLabel backLabel,iconLabel0,iconLabel1,iconLabel2,iconLabel3,titleLabel;
    private JPanel pinkBgPanel,whiteBgPanel;

    //Constructor
    public PreLoginPage(){
        backLabel = new JLabel();
        iconLabel0 = new JLabel();
        iconLabel1 = new JLabel();
        iconLabel2 = new JLabel();
        iconLabel3 = new JLabel();
        titleLabel = new JLabel();
        pinkBgPanel = new JPanel();
        whiteBgPanel = new JPanel();

        this.setTitle("Pre-Login Page");

        setBgColor1(whiteBgPanel, pinkBgPanel);

        setLabelProp(iconLabel0, "/image/tenant.png", "Login as Tenant");
        iconLabel0.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent evt) {
                close();
                new LoginPage(0).setVisible(true); //role: tenant
            }
        });


        setLabelProp(iconLabel1, "/image/agent.png", "Login as Agent");
        iconLabel1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                close();
                new LoginPage(1).setVisible(true); //role: agent
            }
        });

        setLabelProp(iconLabel2, "/image/owner.png", "Login as Owner");
        iconLabel2.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent evt) {
                close();
                new LoginPage(2).setVisible(true); //role: agent
            }
        });

        setLabelProp(iconLabel3, "/image/admin.png", "Login as Admin");
        iconLabel3.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                close();
                new LoginPage(3).setVisible(true); //role: admin
            }
        });

        titleLabel.setFont(new Font("SansSerif", 1, 24));
        titleLabel.setForeground(new Color(255, 255, 255));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setText("Select Your Role");

        backLabel.setIcon(new ImageIcon(getClass().getResource("/image/Back.png")));
        backLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        backLabel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                close();
                new LandingPage().setVisible(true);
            }
        });

        //Alignment
        GroupLayout pinkBgPanelLayout = new GroupLayout(pinkBgPanel);
        pinkBgPanel.setLayout(pinkBgPanelLayout);
        pinkBgPanelLayout.setHorizontalGroup(
                pinkBgPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(pinkBgPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(pinkBgPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(pinkBgPanelLayout.createSequentialGroup()
                                                .addGap(50, 50, 50)
                                                .addComponent(iconLabel0)
                                                .addGap(31, 31, 31)
                                                .addComponent(iconLabel1, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                                                .addComponent(iconLabel2, GroupLayout.PREFERRED_SIZE, 208, GroupLayout.PREFERRED_SIZE)
                                                .addGap(35, 35, 35)
                                                .addComponent(iconLabel3, GroupLayout.PREFERRED_SIZE, 208, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(backLabel, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
                                .addGap(47, 47, 47))
                        .addGroup(GroupLayout.Alignment.TRAILING, pinkBgPanelLayout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(titleLabel, GroupLayout.PREFERRED_SIZE, 252, GroupLayout.PREFERRED_SIZE)
                                .addGap(382, 382, 382))
        );
        pinkBgPanelLayout.setVerticalGroup(
                pinkBgPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(pinkBgPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(backLabel, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(titleLabel, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
                                .addGap(46, 46, 46)
                                .addGroup(pinkBgPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(iconLabel0)
                                        .addGroup(pinkBgPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                .addComponent(iconLabel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(iconLabel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(iconLabel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(88, 88, 88))
        );

        GroupLayout whiteBgPanelLayout = new GroupLayout(whiteBgPanel);
        whiteBgPanel.setLayout(whiteBgPanelLayout);
        whiteBgPanelLayout.setHorizontalGroup(
                whiteBgPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(whiteBgPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(pinkBgPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        whiteBgPanelLayout.setVerticalGroup(
                whiteBgPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(whiteBgPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(pinkBgPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(whiteBgPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(whiteBgPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }

    private void setLabelProp(JLabel label, String imgFile, String text){ //set label's preference
        label.setFont(new Font("SansSerif", Font.BOLD, 14));
        label.setForeground(new Color(255, 255, 255));
        label.setIcon(new ImageIcon(getClass().getResource(imgFile)));
        label.setText(text);
        label.setVerticalAlignment(SwingConstants.TOP);
        label.setCursor(new Cursor(Cursor.HAND_CURSOR));
        label.setHorizontalTextPosition(SwingConstants.CENTER);
        label.setIconTextGap(25);
        label.setVerticalTextPosition(SwingConstants.BOTTOM);
    }

}

