package ownerAgent;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ViewOwnPropertyPane extends JPanel{

    //Gui - swing
    private JScrollPane myPropertiesScrollPane;
    private JPanel myPropertyPanelInsideScrollPane;
    private JButton addPropertyButton;
    private JPanel viewPropertyPanel;
    private JLabel refreshLabel;

    //Controller
    private ViewOwnPropertyContr viewOwnPropertyContr;

    //Constructor
    public ViewOwnPropertyPane(ViewOwnPropertyContr contr){
        viewOwnPropertyContr = contr;

        myPropertiesScrollPane = new JScrollPane();
        myPropertyPanelInsideScrollPane = new JPanel();
        addPropertyButton = new JButton();
        viewPropertyPanel = new JPanel();
        refreshLabel = new JLabel();

        this.setBackground(new Color(255,204,204));

        //Refresh Label
        refreshLabel.setIcon(new ImageIcon(getClass().getResource("/image/refresh.png")));
        refreshLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        refreshLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                viewPropertyPanel = viewOwnPropertyContr.getNewCurrentPane();
                viewOwnPropertyContr.refreshLabelMouseClicked();
                addSubPanel();
            }
        });

        //Button
        addPropertyButton.setFont(new Font("Segoe UI", 1, 14));
        addPropertyButton.setText("Add Property");
        addPropertyButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        addPropertyButton.setFocusPainted(false);
        addPropertyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewOwnPropertyContr.addPropertyActionPerformed();
            }
        });

        myPropertyPanelInsideScrollPane.setBackground(new Color(255,255,255));

        //Panel that contain all own properties
        viewPropertyPanel.setBackground(new Color(255, 255, 255));
        viewPropertyPanel.setPreferredSize(new Dimension(726, 544));

        addSubPanel();

        //Alignment
        viewPropertyPanel.setLayout(new BoxLayout(viewPropertyPanel, BoxLayout.Y_AXIS));
        viewPropertyPanel.add(Box.createRigidArea(new Dimension(5, 5)));

        GroupLayout myPropertyPanelInsideScrollPaneLayout = new GroupLayout(myPropertyPanelInsideScrollPane);
        myPropertyPanelInsideScrollPane.setLayout(myPropertyPanelInsideScrollPaneLayout);
        myPropertyPanelInsideScrollPaneLayout.setHorizontalGroup(
                myPropertyPanelInsideScrollPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(myPropertyPanelInsideScrollPaneLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(viewPropertyPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        myPropertyPanelInsideScrollPaneLayout.setVerticalGroup(
                myPropertyPanelInsideScrollPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(myPropertyPanelInsideScrollPaneLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(viewPropertyPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );

        myPropertiesScrollPane.setViewportView(myPropertyPanelInsideScrollPane);

        GroupLayout myPropertiesPageLayout = new GroupLayout(this);
        this.setLayout(myPropertiesPageLayout);
        myPropertiesPageLayout.setHorizontalGroup(
                myPropertiesPageLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(myPropertiesPageLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(myPropertiesPageLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(GroupLayout.Alignment.TRAILING, myPropertiesPageLayout.createSequentialGroup()
                                                .addComponent(refreshLabel, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(addPropertyButton, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
                                                .addGap(14, 14, 14))
                                        .addGroup(myPropertiesPageLayout.createSequentialGroup()
                                                .addComponent(myPropertiesScrollPane)
                                                .addContainerGap())))
        );
        myPropertiesPageLayout.setVerticalGroup(
                myPropertiesPageLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(myPropertiesPageLayout.createSequentialGroup()
                                .addGroup(myPropertiesPageLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(myPropertiesPageLayout.createSequentialGroup()
                                                .addGap(21, 21, 21)
                                                .addComponent(addPropertyButton, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(myPropertiesPageLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(refreshLabel)))
                                .addGap(34, 34, 34)
                                .addComponent(myPropertiesScrollPane)
                                .addContainerGap())
        );
    }

    private void addSubPanel(){ //add SubPanel(property) into this panel
        //get all sub-panels from controller
        ArrayList<ViewOwnPropertySubPane> allMySubPanels = viewOwnPropertyContr.getAllMyProperties();

        //if no property inside, then display "no property"
        if(viewOwnPropertyContr.getNumberOfProperty() == 0){
            JPanel nothingInsidePanel = new JPanel();
            JLabel nothingInsideLabel = new JLabel();
            nothingInsideLabel.setText("No property");
            nothingInsidePanel.add(nothingInsideLabel);
            viewPropertyPanel.add(nothingInsidePanel);
            viewPropertyPanel.add(Box.createRigidArea(new Dimension(5, 10)));
        }
        else{ //add sub-panels into this panel
            for (ViewOwnPropertySubPane allMySubPanel : allMySubPanels) {
                viewPropertyPanel.add(allMySubPanel);
                viewPropertyPanel.add(Box.createRigidArea(new Dimension(5, 10)));
            }
        }
        viewOwnPropertyContr.setCurrentPane(viewPropertyPanel); //set currentPane for controller
    }

}
