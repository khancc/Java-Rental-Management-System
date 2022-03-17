package main;

import register.PreRegisterView;
import login.PreLoginPage;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class LandingPage extends Frame{

    //GUI - swing
    private JLabel logoLabel,titleLabel,registerButton,loginButton;
    private JPanel leftPanel, rightPanel;

    //Constructor
    public LandingPage(){

        this.setTitle("Landing Page");
        this.setSize(new Dimension(800,570));
        getContentPane().setLayout(null);

        leftPanel = new JPanel();
        leftPanel.setBackground(new Color(186, 79, 84));
        leftPanel.setBounds(0,0,500,600);
        leftPanel.setLayout(null);

        rightPanel = new JPanel();
        rightPanel.setLayout(null);
        rightPanel.setBounds(500,0,300,600);
        rightPanel.setBackground(Color.PINK);

        logoLabel = new JLabel();
        Image getImage = new ImageIcon(getClass().getResource("/image/CyberentLogo.png")).getImage();
        Image scaledImg = getImage.getScaledInstance(250,250,Image.SCALE_SMOOTH);
        ImageIcon img = new ImageIcon(scaledImg);
        logoLabel.setIcon(img);
        logoLabel.setBounds(125, 90, 250, 250);

        titleLabel = new JLabel("Cyberent Rental System");
        Font fontStyle = new Font("SansSerif", Font.BOLD, 30);
        titleLabel.setFont(fontStyle);
        titleLabel.setForeground(Color.BLACK);
        titleLabel.setBounds(80,340,350,50);

        leftPanel.add(logoLabel);
        leftPanel.add(titleLabel);

        registerButton = new JLabel(new ImageIcon(getClass().getResource("/image/registerBefore.png")));
        registerButton.setBounds(70,150,156,74);
        registerButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        registerButton.addMouseListener(new MouseAdapter(){
            //to change imageIcon
            public void mouseEntered(MouseEvent evt) {
                buttonMouseEntered(evt);
            }
            public void mouseExited(MouseEvent evt){
                buttonMouseExited(evt);
            }
            public void mouseClicked(MouseEvent evt){
                buttonMouseClicked(evt);
            }
        });

        loginButton = new JLabel(new ImageIcon(getClass().getResource("/image/loginBefore.png")));
        loginButton.setBounds(70,280,156,74);
        loginButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        loginButton.addMouseListener(new MouseAdapter(){
            //to change imageIcon
            public void mouseEntered(MouseEvent evt) {
                buttonMouseEntered(evt);
            }
            public void mouseExited(MouseEvent evt){
                buttonMouseExited(evt);
            }
            public void mouseClicked(MouseEvent evt){
                buttonMouseClicked(evt);
            }
        });
        rightPanel.add(registerButton);
        rightPanel.add(loginButton);

        getContentPane().add(leftPanel);
        getContentPane().add(rightPanel);

        setLocationRelativeTo(null);
    }

    public void buttonMouseEntered(MouseEvent e) {
        if (e.getSource() == registerButton) {
            registerButton.setIcon(new ImageIcon(getClass().getResource("/image/registerAfter.png")));
        }
        else {
            loginButton.setIcon(new ImageIcon(getClass().getResource("/image/loginAfter.png")));
        }
    }

    public void buttonMouseExited(MouseEvent e) {
        if (e.getSource() == registerButton) {
            registerButton.setIcon(new ImageIcon(getClass().getResource("/image/registerBefore.png")));
        }
        else {
            loginButton.setIcon(new ImageIcon(getClass().getResource("/image/loginBefore.png")));

        }
    }

    public void buttonMouseClicked(MouseEvent e) {
        if (e.getSource() == registerButton) {
            close();
            new PreRegisterView().setVisible(true);
        }
        else {
            close();
            new PreLoginPage().setVisible(true);
        }
    }
}
