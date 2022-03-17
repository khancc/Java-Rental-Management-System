package main;

import javax.swing.*;
import java.awt.*;

public class LogoutPane extends JPanel {

    // GUI - swing
    private JLabel emojiLabel;
    private JPanel mainPanel;
    private Frame mainFrame;

    // Constructor
    public LogoutPane(Frame mainFrame){
        this.mainFrame = mainFrame;
        emojiLabel = new JLabel();
        mainPanel = new JPanel();

        this.setBackground(new Color(255,255,255));
        mainPanel.setBackground(new Color(255, 204, 204));

        emojiLabel.setFont(new Font("Segoe UI", Font.BOLD, 24)); // NOI18N
        emojiLabel.setForeground(new Color(186, 79, 84));
        emojiLabel.setHorizontalAlignment(SwingConstants.CENTER);
        emojiLabel.setIconTextGap(20);
        emojiLabel.setIcon(new ImageIcon(getClass().getResource("/image/original.png")));
        emojiLabel.setText("Click Me to Log Out");
        emojiLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        emojiLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        emojiLabel.setVerticalTextPosition(SwingConstants.BOTTOM);
        emojiLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            //to change imageIcon
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                emojiLabel.setIcon(new ImageIcon(getClass().getResource("/image/mouseIn.png")));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                emojiLabel.setIcon(new ImageIcon(getClass().getResource("/image/mouseOut.png")));
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                emojiLabel.setIcon( new ImageIcon(getClass().getResource("/image/mousePressed.png")));
            }
            //do logout action here
            public void mouseReleased(java.awt.event.MouseEvent evt) { emojiLabelMouseReleased(); }
        });

        mainPanel.add(emojiLabel);
        mainPanel.setLayout(new GridBagLayout());
        this.add(mainPanel, new GridBagConstraints());

        //Alignment
        GroupLayout thisPanelLayout = new GroupLayout(this);
        this.setLayout(thisPanelLayout);
        thisPanelLayout.setHorizontalGroup(
                thisPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 708, Short.MAX_VALUE)
                        .addGroup(thisPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(thisPanelLayout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(mainPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addContainerGap()))
        );
        thisPanelLayout.setVerticalGroup(
                thisPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 687, Short.MAX_VALUE)
                        .addGroup(thisPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(thisPanelLayout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(mainPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addContainerGap()))
        );
    }

    public void emojiLabelMouseReleased(){ //logout, load to landing page
        int input = JOptionPane.showOptionDialog(this, "You Have Been Log Out Successfully.\nSee You Next Time", "Logout", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);

        if(input == JOptionPane.OK_OPTION || input == JOptionPane.CLOSED_OPTION)
        {
            mainFrame.getFrame().close();
            new LandingPage().setVisible(true);
        }
    }

}
