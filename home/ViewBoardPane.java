package home;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreePath;
import property.Property;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;

public class ViewBoardPane extends JPanel implements ActionListener {

    private JPanel homePagePanel;
    private int idEntered;
    private TreeNode treeNode = new TreeNode();
    private JLabel nameLabel,priceLabel,projectLabel,instructionLabel, sizeLabel,typeLabel;
    private JComboBox<String> comboBox;
    private JPanel detailPanel,homePage,propertyPanel;
    private JScrollPane propertyScrollPane,homePageScrollPane,facilityScrollPane,sortTreeScrollPane;
    private JTree sortTree;
    private JTable propertyTable;
    private JButton viewButton;
    private JLabel addressLabel, addressLabelBold, facilityLabel, priceLabelBold, projectlabelBold, commentBold, fillContactLabel, fillOwnerAgentLabel, contactLabel, ownerAgentLabel;;
    private JLabel  nameLabelBold, numberOfBathroomLabel, numberOfBathroomLabelBold, numberOfRoomLabel, numberOfRoomLabelBold;
    private JLabel  sizeLabelBold, sizeUnitLabel, commentLabel, typeLabelBold;
    private JList<String> facilityList;
    private ViewBoardContr contr = new ViewBoardContr(this);

    public ViewBoardPane(){
        setPanel();
    }

    public JPanel getHomePanel(){
        return homePagePanel;
    }

    public void setPanel() {
        fillContactLabel = new JLabel();
        fillOwnerAgentLabel = new JLabel();
        contactLabel = new JLabel();
        ownerAgentLabel = new JLabel();
        nameLabelBold = new JLabel();
        addressLabelBold = new JLabel();
        addressLabel = new JLabel();
        typeLabelBold = new JLabel();
        priceLabelBold = new JLabel();
        projectlabelBold = new JLabel();
        sizeLabelBold = new JLabel();
        numberOfRoomLabelBold = new JLabel();
        numberOfBathroomLabelBold = new JLabel();
        numberOfRoomLabel = new JLabel();
        numberOfBathroomLabel = new JLabel();
        facilityLabel = new JLabel();
        commentBold = new JLabel();
        sizeUnitLabel = new JLabel();
        commentLabel = new JLabel();
        homePage = new JPanel();
        homePageScrollPane = new JScrollPane();
        homePagePanel = new JPanel();
        sortTreeScrollPane = new JScrollPane();
        sortTree = new JTree();
        propertyPanel = new JPanel();
        instructionLabel = new JLabel();
        comboBox = new JComboBox<>();
        detailPanel = new JPanel();
        nameLabel = new JLabel();
        sizeLabel = new JLabel();
        typeLabel = new JLabel();
        projectLabel = new JLabel();
        contactLabel = new JLabel();
        priceLabel = new JLabel();
        facilityScrollPane = new JScrollPane();
        propertyScrollPane = new JScrollPane();
        viewButton = new JButton();
        propertyTable = new JTable();

        homePage.setBackground(new java.awt.Color(255, 255, 255));
        homePage.setForeground(new java.awt.Color(186, 79, 84));
        homePageScrollPane.setBackground(new java.awt.Color(255, 255, 255));
        homePagePanel.setBackground(new java.awt.Color(255, 204, 204));

        sortTree = new JTree(treeNode.getRootNode());
        Icon imageIcon = new ImageIcon(getClass().getResource("/image/house.png"));
        DefaultTreeCellRenderer renderer = (DefaultTreeCellRenderer) sortTree.getCellRenderer();
        renderer.setBackgroundNonSelectionColor(Color.white);
        renderer.setTextNonSelectionColor(Color.BLACK);
        renderer.setBackgroundSelectionColor(new Color(255,204,204));
        renderer.setBorderSelectionColor(new Color(255,204,204));
        renderer.setLeafIcon(imageIcon);
        renderer.setClosedIcon(imageIcon);
        renderer.setOpenIcon(imageIcon);

        sortTree.setCellRenderer(renderer);
        sortTree.setBackground(Color.white);
        sortTree.setBorder(BorderFactory.createLineBorder(new java.awt.Color(186, 79, 84), 3));
        sortTree.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        sortTree.setForeground(Color.white);
        sortTree.getSelectionModel().addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                //get selected node
                TreePath nodePath = e.getPath();
                DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode)sortTree.getLastSelectedPathComponent();
                //check if the node is a child node (to eliminate 'All property')
                boolean parentNode = treeNode.getParentNode().contains(selectedNode);
                //if is a child node, pass the node to controller to generate query and display table list
                if (! parentNode)
                    contr.setTableContent(nodePath, propertyTable);
                //get property id listed from the table
                String[] propertyID = WrapCellRenderer.getTablePropertyID(propertyTable);
                comboBox.setModel(new DefaultComboBoxModel<>(propertyID));
                for( String ID:propertyID){
                    System.out.println(ID);
                }
            }
        });

        ((DefaultTableCellRenderer)propertyTable.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(SwingConstants.LEFT);
        contr.setDefaultTable(propertyTable);
        propertyTable.setFillsViewportHeight(true);
        propertyScrollPane.setViewportView(propertyTable);
        propertyScrollPane.setBorder(BorderFactory.createLineBorder(new java.awt.Color(186, 79, 84), 3));
        propertyTable.setBackground(Color.white);
        propertyTable.setDefaultEditor(Object.class, null);

        sortTreeScrollPane = new JScrollPane();
        sortTreeScrollPane.setViewportView(sortTree);

        propertyPanel.setBackground(Color.white);
        propertyPanel.setPreferredSize(new java.awt.Dimension(726, 544));

        instructionLabel.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 18)); // NOI18N
        instructionLabel.setText("Please select a property ID to view property details.");

        //comboBox.setSize(300,20);
        comboBox.setModel(new DefaultComboBoxModel<>(WrapCellRenderer.getTablePropertyID(propertyTable)));

        //Attribute - Bolded Label
        setBoldedLabel(nameLabelBold,"Property's Name:");
        setBoldedLabel(addressLabelBold,"Address:");
        setBoldedLabel(typeLabelBold,"Property's Type:");
        setBoldedLabel(priceLabelBold,"Rental Price: ");
        setBoldedLabel(projectlabelBold,"Project/Township:");
        setBoldedLabel(sizeLabelBold,"Size:");
        setBoldedLabel(numberOfRoomLabelBold,"Number of Room:");
        setBoldedLabel(numberOfBathroomLabelBold,"Number of Bathroom:");
        setBoldedLabel(sizeUnitLabel,"square feet");
        setBoldedLabel(facilityLabel,"Facilities");
        setBoldedLabel(ownerAgentLabel,"Owner/Agent:");
        setBoldedLabel(contactLabel,"Contact Number(+60):");

        //Facility List
        facilityList = new JList<>();
        facilityList.setBackground(new java.awt.Color(255, 255, 255));
        facilityList.setBorder(BorderFactory.createLineBorder(new java.awt.Color(186, 79, 84), 2));
        facilityList.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        //setFacilityDetails();
        facilityScrollPane = new JScrollPane();
        facilityScrollPane.setViewportView(facilityList);

        detailPanel.setBorder(BorderFactory.createLineBorder(new java.awt.Color(186, 79, 84), 3));
        GroupLayout detailPanelLayout = new GroupLayout(detailPanel);
        detailPanel.setLayout(detailPanelLayout);
        detailPanelLayout.setHorizontalGroup(
                detailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(detailPanelLayout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(detailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(detailPanelLayout.createSequentialGroup()
                                                .addComponent(nameLabelBold, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(facilityLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(detailPanelLayout.createSequentialGroup()
                                                .addGap(1, 1, 1)
                                                .addGroup(detailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addGroup(detailPanelLayout.createSequentialGroup()
                                                                .addComponent(priceLabelBold)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(priceLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                        .addGroup(detailPanelLayout.createSequentialGroup()
                                                                .addComponent(commentBold, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(commentLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                        .addGroup(detailPanelLayout.createSequentialGroup()
                                                                .addGroup(detailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(detailPanelLayout.createSequentialGroup()
                                                                                .addComponent(typeLabelBold, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(typeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(detailPanelLayout.createSequentialGroup()
                                                                                .addComponent(addressLabelBold, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addComponent(addressLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 797, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(detailPanelLayout.createSequentialGroup()
                                                                                .addGroup(detailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                                        .addGroup(detailPanelLayout.createSequentialGroup()
                                                                                                .addComponent(sizeLabelBold, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(sizeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                                        .addComponent(projectlabelBold))
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addGroup(detailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(projectLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addComponent(sizeUnitLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                        .addGroup(detailPanelLayout.createSequentialGroup()
                                                                                .addGroup(detailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addGroup(detailPanelLayout.createSequentialGroup()
                                                                                                .addComponent(numberOfRoomLabelBold, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                                .addComponent(numberOfRoomLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                        .addGroup(detailPanelLayout.createSequentialGroup()
                                                                                                .addComponent(numberOfBathroomLabelBold, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                                .addComponent(numberOfBathroomLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                                .addGap(18, 18, 18)
                                                                                .addGroup(detailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                                        .addGroup(detailPanelLayout.createSequentialGroup()
                                                                                                .addComponent(contactLabel)
                                                                                                .addGap(18, 18, 18)
                                                                                                .addComponent(fillContactLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                        .addGroup(detailPanelLayout.createSequentialGroup()
                                                                                                .addComponent(ownerAgentLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(fillOwnerAgentLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                                                                .addGap(2, 2, 2)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                                                .addComponent(facilityScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(118, 118, 118)
                                .addGap(19, 19, 19))
        );
        detailPanelLayout.setVerticalGroup(
                detailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(detailPanelLayout.createSequentialGroup()
                                .addGroup(detailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(detailPanelLayout.createSequentialGroup()
                                                .addGap(23, 23, 23)
                                                .addGroup(detailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(nameLabelBold)
                                                        .addComponent(nameLabel)))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, detailPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(facilityLabel)))
                                .addGroup(detailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(detailPanelLayout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addGroup(detailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(addressLabelBold)
                                                        .addComponent(addressLabel))
                                                .addGap(18, 18, 18)
                                                .addGroup(detailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(typeLabelBold)
                                                        .addComponent(typeLabel))
                                                .addGap(18, 18, 18)
                                                .addGroup(detailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(priceLabelBold)
                                                        .addComponent(priceLabel))
                                                .addGap(18, 18, 18)
                                                .addGroup(detailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(projectlabelBold)
                                                        .addComponent(projectLabel))
                                                .addGap(18, 18, 18)
                                                .addGroup(detailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(sizeLabelBold)
                                                        .addComponent(sizeLabel)
                                                        .addComponent(sizeUnitLabel))
                                                .addGap(18, 18, 18)
                                                .addGroup(detailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(numberOfRoomLabelBold)
                                                        .addComponent(numberOfRoomLabel)
                                                        .addComponent(ownerAgentLabel)
                                                        .addComponent(fillOwnerAgentLabel))
                                                .addGap(18, 18, 18)
                                                .addGroup(detailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(numberOfBathroomLabelBold)
                                                        .addComponent(numberOfBathroomLabel)
                                                        .addComponent(contactLabel)
                                                        .addComponent(fillContactLabel))
                                                .addGap(18, 18, 18)
                                                .addGroup(detailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(commentBold)
                                                        .addComponent(commentLabel))
                                                .addGap(15, 15, 15))
                                        .addGroup(detailPanelLayout.createSequentialGroup()
                                                .addGap(4, 4, 4)
                                                .addGroup(detailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(facilityScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)

                                                )))));

        detailPanel.setBackground(Color.white);
        detailPanel.setVisible(false);

        viewButton.setText("View Details");
        viewButton.addActionListener(this);

        GroupLayout propertyPanelLayout = new GroupLayout(propertyPanel);
        propertyPanel.setLayout(propertyPanelLayout);
        propertyPanelLayout.setHorizontalGroup(
                propertyPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(propertyPanelLayout.createSequentialGroup()
                                .addGroup(propertyPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(propertyPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(propertyPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(detailPanel, GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                                                        .addComponent(propertyScrollPane)))
                                        .addGroup(propertyPanelLayout.createSequentialGroup()
                                                .addGroup(propertyPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(propertyPanelLayout.createSequentialGroup()
                                                                .addGap(352, 352, 352)
                                                                .addComponent(instructionLabel))
                                                        .addGroup(propertyPanelLayout.createSequentialGroup()
                                                                .addGap(539, 539, 539)
                                                                .addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(213, 213, 213)
                                                                .addComponent(viewButton, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)))
                                                .addGap(0, 244, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        propertyPanelLayout.setVerticalGroup(
                propertyPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(propertyPanelLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(propertyScrollPane, GroupLayout.PREFERRED_SIZE, 315, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(instructionLabel)
                                .addGap(18, 18, 18)
                                .addGroup(propertyPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(viewButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(comboBox, GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addComponent(detailPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(16, Short.MAX_VALUE))
        );

        GroupLayout homePagePanelLayout = new GroupLayout(homePagePanel);
        homePagePanel.setLayout(homePagePanelLayout);
        homePagePanelLayout.setHorizontalGroup(
                homePagePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(homePagePanelLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(sortTreeScrollPane, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(propertyPanel, GroupLayout.DEFAULT_SIZE, 1195, Short.MAX_VALUE)
                                .addContainerGap())
        );
        homePagePanelLayout.setVerticalGroup(
                homePagePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(homePagePanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(homePagePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(propertyPanel, GroupLayout.DEFAULT_SIZE, 785, Short.MAX_VALUE)
                                        .addGroup(homePagePanelLayout.createSequentialGroup()
                                                .addComponent(sortTreeScrollPane, GroupLayout.PREFERRED_SIZE, 500, GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
        );

    }

    private void setBoldedLabel(JLabel label, String string){
        try{
            label.setFont(new java.awt.Font("Segoe UI", Font.BOLD, 16));
            label.setText(string);
        }catch(Exception e){

        }

    }

    private void setNormalLabel(JLabel label, String string){
        label.setFont(new java.awt.Font("Segoe UI", Font.PLAIN, 16));
        label.setText(string);
    }

    //selectedID and show property details
    @Override
    public void actionPerformed(ActionEvent e) {
        String selectedID = (String)comboBox.getSelectedItem();
        idEntered = Integer.parseInt(selectedID);
        contr.setDetailPanel();
        detailPanel.setVisible(true);
    }

    public JList<String> getFacilityList(){
        return facilityList;
    }
    public void setPropertyDetails(Property property,ArrayList<String> namePhone){

        setNormalLabel(nameLabel,property.getName());
        setNormalLabel(addressLabel,property.getAddress());
        setNormalLabel(typeLabel,property.getType());
        setNormalLabel(priceLabel,Double.toString(property.getPrice()));
        setNormalLabel(projectLabel,property.getProject());
        setNormalLabel(sizeLabel,Double.toString(property.getSize()));
        setNormalLabel(numberOfRoomLabel,Integer.toString(property.getRoom()));
        setNormalLabel(numberOfBathroomLabel,Integer.toString(property.getBathroom()));
        setNormalLabel(fillContactLabel,namePhone.get(1));
        setNormalLabel(fillOwnerAgentLabel, namePhone.get(0));
    }
    public int getIdEntered(){
        return idEntered;
    }

    public void setTableContent(JTable table){
        this.propertyTable = table;
    }

}
