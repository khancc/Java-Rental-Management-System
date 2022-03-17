package register;

import main.Frame;
import main.LandingPage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PreRegisterView extends Frame{

    //Gui - swing
    private JLabel backLabel, iconLabel0, iconLabel1, iconLabel2, titleLabel;
    private JPanel pinkBgPanel, whiteBgPanel;

    //Constructor
    public PreRegisterView(){

        this.setTitle("Pre-Register Page");

        whiteBgPanel = new javax.swing.JPanel();
        pinkBgPanel = new javax.swing.JPanel();
        iconLabel0 = new javax.swing.JLabel();
        iconLabel1 = new javax.swing.JLabel();
        iconLabel2 = new javax.swing.JLabel();
        titleLabel = new javax.swing.JLabel();
        backLabel = new javax.swing.JLabel();

        setBgColor1(whiteBgPanel, pinkBgPanel);

        setLabelProp(iconLabel0, "/image/tenant.png", "Register as Tenant");
        iconLabel0.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                close();
                new RegisterView(0).setVisible(true); //role: tenant
            }
        });

        setLabelProp(iconLabel1, "/image/agent.png", "Register as Agent");
        iconLabel1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                close();
                new RegisterView(1).setVisible(true); //role: agent
            }
        });

        setLabelProp(iconLabel2, "/image/owner.png", "Register as Owner");
        iconLabel2.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                close();
                new RegisterView(2).setVisible(true); //role: agent
            }
        });

        titleLabel.setFont(new java.awt.Font("SansSerif", Font.BOLD, 24)); // NOI18N
        titleLabel.setForeground(new java.awt.Color(255, 255, 255));
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("Select Your Role");

        backLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Back.png"))); // NOI18N
        backLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        backLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                close();
                new LandingPage().setVisible(true);
            }
        });

        //Alignment
        javax.swing.GroupLayout pinkBgPanelLayout = new javax.swing.GroupLayout(pinkBgPanel);
        pinkBgPanel.setLayout(pinkBgPanelLayout);
        pinkBgPanelLayout.setHorizontalGroup(
                pinkBgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pinkBgPanelLayout.createSequentialGroup()
                                .addGroup(pinkBgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(pinkBgPanelLayout.createSequentialGroup()
                                                .addGap(67, 67, 67)
                                                .addComponent(iconLabel0)
                                                .addGap(51, 51, 51)
                                                .addComponent(iconLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(46, 46, 46)
                                                .addComponent(iconLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(pinkBgPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(backLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(pinkBgPanelLayout.createSequentialGroup()
                                                .addGap(294, 294, 294)
                                                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(62, Short.MAX_VALUE))
        );
        pinkBgPanelLayout.setVerticalGroup(
                pinkBgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pinkBgPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(backLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(titleLabel)
                                .addGap(57, 57, 57)
                                .addGroup(pinkBgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(iconLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(iconLabel0, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(iconLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(88, 88, 88))
        );

        javax.swing.GroupLayout whiteBgPanelLayout = new javax.swing.GroupLayout(whiteBgPanel);
        whiteBgPanel.setLayout(whiteBgPanelLayout);
        whiteBgPanelLayout.setHorizontalGroup(
                whiteBgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(whiteBgPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(pinkBgPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        whiteBgPanelLayout.setVerticalGroup(
                whiteBgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(whiteBgPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(pinkBgPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(whiteBgPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(whiteBgPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }

    private void setLabelProp(JLabel label, String imgFile, String text){ //set label's preference
        label.setFont(new java.awt.Font("SansSerif", Font.BOLD, 14));
        label.setForeground(new java.awt.Color(255, 255, 255));
        label.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        label.setIcon(new ImageIcon(getClass().getResource(imgFile)));
        label.setText(text);
        label.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        label.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        label.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        label.setIconTextGap(25);
        label.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    }
}
