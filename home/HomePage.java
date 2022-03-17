package home;

import java.awt.*;
import javax.swing.*;
import account.Account;
import admin.CreateAdminPane;
import admin.RequestPane;
import main.Frame;
import main.LogoutPane;
import ownerAgent.ViewOwnPropertyContr;
import ownerAgent.ViewOwnPropertyPane;
import profile.ProfileContr;
import profile.ProfilePane;

public class HomePage extends Frame {

    //GUI - swing
    private JPanel homePage,whiteBgPanel;
    private JTabbedPane tabbedPane;

    //Controller
    private ProfileContr profileContr = new ProfileContr(this);
    private ViewOwnPropertyContr viewOwnPropertyContr = new ViewOwnPropertyContr(this);

    //Association
    private Account account = Account.getAccount();

    //Constructor
    public HomePage(){
        this.setResizable(true);
        this.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        initComponents(account.getRole());
    }

    private void initComponents(int role) { //initialise GUI component

        whiteBgPanel = new JPanel();
        tabbedPane = new JTabbedPane();
        homePage = new JPanel();

        setTitle(getRoleString(account.getRole()));

        whiteBgPanel.setBackground(new Color(255, 255, 255));

        tabbedPane.setFont(new Font("Segoe UI", Font.BOLD, 14)); // NOI18N

        homePage.setBackground(new Color(255, 255, 255));
        homePage.setForeground(new Color(186, 79, 84));

        //set tabbed pane based on actor's role
        tabbedPane.addTab("   Home   ", new ViewBoardPane().getHomePanel()); //for all
        tabbedPane.addTab("  Profile  ", new ProfilePane(profileContr)); //for all

        //for admin
        if (role == 3){
            tabbedPane.addTab("  Add Admin  ", new CreateAdminPane().getPanel());
            tabbedPane.addTab("  Manage Registration Request  ", new RequestPane().getPanel());
        }
        ///for agent or owner
        if (role == 1 || role ==2)
            tabbedPane.addTab("   My Properties   ", new ViewOwnPropertyPane(viewOwnPropertyContr));

        tabbedPane.addTab("   Logout   ",new LogoutPane(this)); //for all

        whiteBgPanel.add(tabbedPane);

        //Alignment
        javax.swing.GroupLayout whiteBgPanelLayout = new javax.swing.GroupLayout(whiteBgPanel);
        whiteBgPanel.setLayout(whiteBgPanelLayout);
        whiteBgPanelLayout.setHorizontalGroup(
                whiteBgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(whiteBgPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(tabbedPane)
                                .addContainerGap())
        );
        whiteBgPanelLayout.setVerticalGroup(
                whiteBgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, whiteBgPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(tabbedPane)
                                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, 0)
                                .addComponent(whiteBgPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(whiteBgPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(getContentPane());
        setContentPane(scrollPane);
        pack();
    }

    //getter
    public JTabbedPane getTabbedPane(){
        return tabbedPane;
    }
    public Frame getFrame(){
        return this;
    }
}

