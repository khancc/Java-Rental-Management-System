package ownerAgent;
import javax.swing.*;
import property.Facility;
import java.awt.*;
import java.util.ArrayList;

public class ViewOwnPropertySubPane extends JPanel {
    //Variable
    private int subMyPropertyPaneID;

    //GUI - swing
    private JLabel addressLabel, addressLabelBold, facilityLabel, priceLabel, priceLabelBold, projectLabel, projectlabelBold, commentBold;
    private JLabel nameLabel, nameLabelBold, numberOfBathroomLabel, numberOfBathroomLabelBold, numberOfRoomLabel, numberOfRoomLabelBold;
    private JLabel sizeLabel, sizeLabelBold, sizeUnitLabel, commentLabel, typeLabel, typeLabelBold;
    private JList<String> facilityList;
    private JScrollPane jScrollPane1;
    private JButton deletePropertyButton, editPropertyButton;

    //Controller
    private ViewOwnPropertyContr viewOwnPropertyContr;

    //Constructor
    ViewOwnPropertySubPane(ViewOwnPropertyContr contr, int propertyID){
        viewOwnPropertyContr = contr;
        subMyPropertyPaneID = propertyID;
        System.out.println(propertyID);
        nameLabelBold = new JLabel();
        addressLabelBold = new JLabel();
        typeLabelBold = new JLabel();
        priceLabelBold = new JLabel();
        nameLabel = new JLabel();
        addressLabel = new JLabel();
        typeLabel = new JLabel();
        priceLabel = new JLabel();
        projectlabelBold = new JLabel();
        projectLabel = new JLabel();
        sizeLabelBold = new JLabel();
        numberOfRoomLabelBold = new JLabel();
        numberOfRoomLabel = new JLabel();
        numberOfBathroomLabelBold = new JLabel();
        numberOfBathroomLabel = new JLabel();
        sizeLabel = new JLabel();
        jScrollPane1 = new JScrollPane();
        facilityList = new JList<>();
        facilityLabel = new JLabel();
        commentBold = new JLabel();
        commentLabel = new JLabel();
        editPropertyButton = new JButton();
        deletePropertyButton = new JButton();
        sizeUnitLabel = new JLabel();

        this.setBackground(new Color(255, 255, 255));
        this.setBorder(BorderFactory.createLineBorder(new Color(186, 79, 84), 3));

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
        
        //set property data
        setPropertyDetails();

        //Facility List
        facilityList.setBackground(new Color(255, 255, 255));
        facilityList.setBorder(BorderFactory.createLineBorder(new Color(186, 79, 84), 2));
        facilityList.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        Facility facility = new Facility();
        ArrayList<String> facilityArrayList = facility.getFacilityFromDatabase(subMyPropertyPaneID);
        String[] facilityArray = facilityArrayList.toArray(new String[0]);
        facilityList.setListData(facilityArray);

        jScrollPane1.setViewportView(facilityList);

        //Buttons
        setButton(editPropertyButton, "Edit Property");
        editPropertyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewOwnPropertyContr.editPropertyButtonActionPerformed(propertyID);
            }
        });

        setButton(deletePropertyButton, "Delete Property");
        deletePropertyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewOwnPropertyContr.deletePropertyButtonActionPerformed(propertyID);
            }
        });

        //Alignment
        GroupLayout component1Layout = new GroupLayout(this);
        this.setLayout(component1Layout);
        component1Layout.setHorizontalGroup(
                component1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(component1Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(component1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(component1Layout.createSequentialGroup()
                                                .addComponent(nameLabelBold, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(nameLabel, GroupLayout.PREFERRED_SIZE, 427, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(facilityLabel, GroupLayout.PREFERRED_SIZE, 256, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(component1Layout.createSequentialGroup()
                                                .addGap(1, 1, 1)
                                                .addGroup(component1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addGroup(component1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                                .addGroup(GroupLayout.Alignment.LEADING, component1Layout.createSequentialGroup()
                                                                        .addComponent(priceLabelBold)
                                                                        .addGap(18, 18, 18)
                                                                        .addComponent(priceLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                .addGroup(component1Layout.createSequentialGroup()
                                                                        .addComponent(typeLabelBold, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(typeLabel, GroupLayout.PREFERRED_SIZE, 288, GroupLayout.PREFERRED_SIZE)))
                                                        .addGroup(component1Layout.createSequentialGroup()
                                                                .addComponent(numberOfRoomLabelBold, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(numberOfRoomLabel, GroupLayout.PREFERRED_SIZE, 281, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(component1Layout.createSequentialGroup()
                                                                .addComponent(numberOfBathroomLabelBold, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(numberOfBathroomLabel, GroupLayout.PREFERRED_SIZE, 242, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(component1Layout.createSequentialGroup()
                                                                .addComponent(addressLabelBold, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(addressLabel, GroupLayout.PREFERRED_SIZE, 797, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(component1Layout.createSequentialGroup()
                                                                .addGroup(component1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                                        .addGroup(component1Layout.createSequentialGroup()
                                                                                .addComponent(sizeLabelBold, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(sizeLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                        .addComponent(projectlabelBold))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(component1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(projectLabel, GroupLayout.PREFERRED_SIZE, 270, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(sizeUnitLabel, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)))
                                                        .addGroup(component1Layout.createSequentialGroup()
                                                                .addComponent(commentBold, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(commentLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                                                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 258, GroupLayout.PREFERRED_SIZE)))
                                .addGap(118, 118, 118)
                                .addGroup(component1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(deletePropertyButton, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(editPropertyButton, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE))
                                .addGap(19, 19, 19))
        );
        component1Layout.setVerticalGroup(
                component1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(component1Layout.createSequentialGroup()
                                .addGroup(component1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(component1Layout.createSequentialGroup()
                                                .addGap(23, 23, 23)
                                                .addGroup(component1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(nameLabelBold)
                                                        .addComponent(nameLabel)))
                                        .addGroup(GroupLayout.Alignment.TRAILING, component1Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(facilityLabel)))
                                .addGroup(component1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addGroup(component1Layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addGroup(component1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(addressLabelBold)
                                                        .addComponent(addressLabel))
                                                .addGap(18, 18, 18)
                                                .addGroup(component1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(typeLabelBold)
                                                        .addComponent(typeLabel))
                                                .addGap(18, 18, 18)
                                                .addGroup(component1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(priceLabelBold)
                                                        .addComponent(priceLabel))
                                                .addGap(18, 18, 18)
                                                .addGroup(component1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(projectlabelBold)
                                                        .addComponent(projectLabel))
                                                .addGap(18, 18, 18)
                                                .addGroup(component1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(sizeLabelBold)
                                                        .addComponent(sizeLabel)
                                                        .addComponent(sizeUnitLabel))
                                                .addGap(18, 18, 18)
                                                .addGroup(component1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(numberOfRoomLabelBold)
                                                        .addComponent(numberOfRoomLabel))
                                                .addGap(18, 18, 18)
                                                .addGroup(component1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(numberOfBathroomLabelBold)
                                                        .addComponent(numberOfBathroomLabel))
                                                .addGap(18, 18, 18)
                                                .addGroup(component1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(commentBold)
                                                        .addComponent(commentLabel))
                                                .addGap(15, 15, 15))
                                        .addGroup(component1Layout.createSequentialGroup()
                                                .addGap(4, 4, 4)
                                                .addGroup(component1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 289, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(editPropertyButton, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(deletePropertyButton, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(23, Short.MAX_VALUE))
        );

    }

    private void setBoldedLabel(JLabel label, String string){ //set bolded label
        label.setFont(new Font("Segoe UI", Font.BOLD, 16));
        label.setText(string);
    }

    private void setNormalLabel(JLabel label, String string){ //set normal label
        label.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        label.setText(string);
    }

    private void setButton(JButton button, String string){ //set button
        button.setFont(new Font("Segoe UI", Font.BOLD, 14));
        button.setText(string);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setFocusPainted(false);
    }

    private void setPropertyDetails(){ //set text normal label and other property's details
        //read property's details from controller
        String[] strings = viewOwnPropertyContr.readPropertyString(subMyPropertyPaneID);

        setNormalLabel(nameLabel,strings[0]);
        setNormalLabel(addressLabel,strings[1]);
        setNormalLabel(typeLabel,strings[2]);
        setNormalLabel(priceLabel,strings[3]);
        setNormalLabel(projectLabel,strings[4]);
        setNormalLabel(sizeLabel,strings[5]);
        setNormalLabel(numberOfRoomLabel,strings[6]);
        setNormalLabel(numberOfBathroomLabel,strings[7]);

        if(strings[8].equals("N")){//if status is inactive
            this.setBackground(new Color(224,224,224));
            facilityList.setBackground(new Color(224,224,224));
        }
    }

}
