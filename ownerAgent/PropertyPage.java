package ownerAgent;

import main.Frame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class PropertyPage extends Frame{
    //Gui - swing
    protected JCheckBox activeStatusCB, airCornCB, fridgeCB, gymRoomCB, parkingCB, swimmingPoolCB, tvCB, washingMachineCB,wifiCB, waterHeaterCB, gasCB;
    protected JLabel addressLabel, backLabel,facilitiesLabel, nameLabel, numberOfBathroomLabel, numberOfRoomLabel, priceLabel;
    protected JLabel projectLabel, propertyDetailsLabel, propertyTypeLabel, rentalRateLabel, sizeLabel, sizeUnitLabel, titleLabel, generalLabel;
    protected JSeparator addressSep, nameSep, priceSep, projectSep, sizeSep;
    protected JTextField addressTF, nameTF, priceTF, projectTF, sizeTF;
    protected JPanel facilitiesPanel, generalPanel, pinkBgPanel, propertyDetailsPanel, whiteBgPanel;
    protected JScrollPane jScrollPane;
    protected JComboBox<String> numberOfBathroomCbB, numberOfRoomCbB, typeCbB;
    protected JButton saveButton;
    private ArrayList<JCheckBox> facilityCB = new ArrayList<JCheckBox>();

    //Controller
    protected AddEditPropertyContr addEditPropertyContr = new AddEditPropertyContr(getFrame());

    //Constructor
    PropertyPage(){
        this.setResizable(true);

        whiteBgPanel = new JPanel();
        jScrollPane = new JScrollPane();
        pinkBgPanel = new JPanel();
        backLabel = new JLabel();
        titleLabel = new JLabel();
        propertyDetailsLabel = new JLabel();
        generalPanel = new JPanel();
        nameLabel = new JLabel();
        nameSep = new JSeparator();
        nameTF = new JTextField();
        addressLabel = new JLabel();
        addressSep = new JSeparator();
        addressTF = new JTextField();
        propertyTypeLabel = new JLabel();
        priceLabel = new JLabel();
        priceTF = new JTextField();
        priceSep = new JSeparator();
        generalLabel = new JLabel();
        propertyDetailsPanel = new JPanel();
        projectLabel = new JLabel();
        projectTF = new JTextField();
        projectSep = new JSeparator();
        sizeLabel = new JLabel();
        sizeSep = new JSeparator();
        sizeTF = new JTextField();
        sizeUnitLabel = new JLabel();
        numberOfRoomLabel = new JLabel();
        numberOfRoomCbB = new JComboBox<>();
        numberOfBathroomLabel = new JLabel();
        numberOfBathroomCbB = new JComboBox<>();
        typeCbB = new JComboBox<>();
        rentalRateLabel = new JLabel();
        facilitiesPanel = new JPanel();
        swimmingPoolCB = new JCheckBox();
        parkingCB = new JCheckBox();
        airCornCB = new JCheckBox();
        wifiCB = new JCheckBox();
        tvCB = new JCheckBox();
        fridgeCB = new JCheckBox();
        washingMachineCB = new JCheckBox();
        gymRoomCB = new JCheckBox();
        waterHeaterCB = new JCheckBox();
        gasCB = new JCheckBox();
        facilitiesLabel = new JLabel();
        activeStatusCB = new JCheckBox();
        saveButton = new JButton();

        super.setBgColor2(whiteBgPanel, pinkBgPanel);

        backLabel.setIcon(new ImageIcon(getClass().getResource("/image/back-red.png")));
        backLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        backLabel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                addEditPropertyContr.backLabelMouseClicked(evt);
            }
        });

        titleLabel.setBackground(new Color(255, 204, 204));
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
        titleLabel.setForeground(new Color(186, 79, 84));
        titleLabel.setText("Property Template");

        //General Section
        generalLabel.setBackground(new Color(255, 204, 204));
        generalLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
        generalLabel.setForeground(new Color(186, 79, 84));
        generalLabel.setText("General");

        generalPanel.setBackground(new Color(255, 255, 255));
        generalPanel.setBorder(BorderFactory.createLineBorder(new Color(186, 79, 84), 3));

        setCheckBox(swimmingPoolCB, "Swimming Pool");
        setCheckBox(parkingCB, "Parking");
        setCheckBox(airCornCB, "Air Conditional");
        setCheckBox(wifiCB, "Wifi");
        setCheckBox(tvCB, "Tv");
        setCheckBox(fridgeCB, "Fridge");
        setCheckBox(washingMachineCB, "Washing Machine");
        setCheckBox(gymRoomCB, "Gym Room");
        setCheckBox(waterHeaterCB, "Water Heater");
        setCheckBox(gasCB, "Stove");

        setComponent(nameLabel, "Name:", nameTF, "", nameSep);
        setComponent(addressLabel, "Address:", addressTF, "", addressSep);
        setComponent(priceLabel, "Rental Price:    RM", priceTF, "", priceSep);
        setComboBox(propertyTypeLabel, "Property's Type:", typeCbB, new String[] { "Single Storey", "Double Storey", "Triple Storey","Studio","Condominium", "Apartment", "Townhouse", "Bungalow", "Other"});

       
        //Property's Details Section
        propertyDetailsLabel.setBackground(new Color(255, 204, 204));
        propertyDetailsLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
        propertyDetailsLabel.setForeground(new Color(186, 79, 84));
        propertyDetailsLabel.setText("Property's Details");

        propertyDetailsPanel.setBackground(new Color(255, 255, 255));
        propertyDetailsPanel.setBorder(BorderFactory.createLineBorder(new Color(186, 79, 84), 3));

        sizeUnitLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
        sizeUnitLabel.setText("square feet");

        setComponent(projectLabel, "Project/Township:", projectTF, "", projectSep);
        setComponent(sizeLabel, "Size:", sizeTF, "", sizeSep);
        setComboBox(numberOfRoomLabel, "Number of Room:", numberOfRoomCbB, new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15" });
        setComboBox(numberOfBathroomLabel, "Number of Bathroom:", numberOfBathroomCbB, new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15" });

        //Facilities Section
        facilitiesPanel.setBackground(new Color(255, 255, 255));
        facilitiesPanel.setBorder(BorderFactory.createLineBorder(new Color(186, 79, 84), 3));

        facilitiesLabel.setBackground(new Color(255, 204, 204));
        facilitiesLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
        facilitiesLabel.setForeground(new Color(186, 79, 84));
        facilitiesLabel.setText("Facilities");

        //Other
        setCheckBox(activeStatusCB, "Active Status");
        activeStatusCB.setBackground(new Color(255, 204, 204));

        saveButton.setBackground(Color.white);
        saveButton.setFont(new Font("Segoe UI", Font.BOLD, 14)); // NOI18N
        saveButton.setForeground(new Color(51, 51, 51));
        saveButton.setText("Save Changes");
        saveButton.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        saveButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        saveButton.setFocusPainted(false);
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                String name = nameTF.getText();
                String address = addressTF.getText();
                String propertyType = typeCbB.getSelectedItem().toString();
                String price = priceTF.getText();
                String project = projectTF.getText();
                String size = sizeTF.getText();
                String numberOfRoom = numberOfRoomCbB.getSelectedItem().toString();
                String numberOfBathroom = numberOfBathroomCbB.getSelectedItem().toString();
                boolean status = activeStatusCB.isSelected();
                ArrayList<String> selectedFacility = new ArrayList<String>();
                for(JCheckBox facility: facilityCB){
                    if (facility.isSelected())
                        selectedFacility.add(facility.getText());
                }
                
                String[] stringTF = new String[]{name,address,project,size,price,propertyType,numberOfRoom,numberOfBathroom};

                //pass user input to the controller
                addEditPropertyContr.buttonActionPerformed(stringTF,status,selectedFacility); 
            }
        });

        //Alignment Section 1
        GroupLayout facilitiesPanelLayout = new GroupLayout(facilitiesPanel);
        facilitiesPanel.setLayout(facilitiesPanelLayout);
        facilitiesPanelLayout.setHorizontalGroup(
                facilitiesPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(facilitiesPanelLayout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(facilitiesPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(fridgeCB, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(tvCB, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(facilitiesPanelLayout.createSequentialGroup()
                                                .addComponent(airCornCB, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(gasCB, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(facilitiesPanelLayout.createSequentialGroup()
                                                .addComponent(parkingCB, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(waterHeaterCB, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(facilitiesPanelLayout.createSequentialGroup()
                                                .addComponent(swimmingPoolCB, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(gymRoomCB, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(facilitiesPanelLayout.createSequentialGroup()
                                                .addComponent(wifiCB, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(washingMachineCB, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        facilitiesPanelLayout.setVerticalGroup(
                facilitiesPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(facilitiesPanelLayout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addGroup(facilitiesPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(swimmingPoolCB)
                                        .addComponent(gymRoomCB))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(facilitiesPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(parkingCB)
                                        .addComponent(waterHeaterCB))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(facilitiesPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(wifiCB)
                                        .addComponent(washingMachineCB))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(facilitiesPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(airCornCB)
                                        .addComponent(gasCB))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tvCB)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fridgeCB)
                                .addContainerGap(18, Short.MAX_VALUE))
        );

        //Alignment Section 2
        GroupLayout propertyDetailsPanelLayout = new GroupLayout(propertyDetailsPanel);
        propertyDetailsPanel.setLayout(propertyDetailsPanelLayout);
        propertyDetailsPanelLayout.setHorizontalGroup(
                propertyDetailsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(propertyDetailsPanelLayout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(propertyDetailsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(propertyDetailsPanelLayout.createSequentialGroup()
                                                .addComponent(numberOfBathroomLabel, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(numberOfBathroomCbB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(propertyDetailsPanelLayout.createSequentialGroup()
                                                .addGroup(propertyDetailsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(propertyDetailsPanelLayout.createSequentialGroup()
                                                                .addComponent(projectLabel)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(propertyDetailsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(projectTF, GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)
                                                                        .addComponent(projectSep)))
                                                        .addGroup(propertyDetailsPanelLayout.createSequentialGroup()
                                                                .addComponent(sizeLabel, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(propertyDetailsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(sizeSep)
                                                                        .addComponent(sizeTF, GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(sizeUnitLabel, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(propertyDetailsPanelLayout.createSequentialGroup()
                                                                .addComponent(numberOfRoomLabel, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(numberOfRoomCbB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                                .addContainerGap(264, Short.MAX_VALUE))))
        );
        propertyDetailsPanelLayout.setVerticalGroup(
                propertyDetailsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(propertyDetailsPanelLayout.createSequentialGroup()
                                .addContainerGap(24, Short.MAX_VALUE)
                                .addGroup(propertyDetailsPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(projectLabel)
                                        .addComponent(projectTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(projectSep, GroupLayout.PREFERRED_SIZE, 11, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(propertyDetailsPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(sizeLabel)
                                        .addComponent(sizeTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(sizeUnitLabel))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(sizeSep, GroupLayout.PREFERRED_SIZE, 11, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(propertyDetailsPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(numberOfRoomLabel)
                                        .addComponent(numberOfRoomCbB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(propertyDetailsPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(numberOfBathroomLabel)
                                        .addComponent(numberOfBathroomCbB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(25, 25, 25))
        );

        //Alignment Section 3
        GroupLayout generalPanelLayout = new GroupLayout(generalPanel);
        generalPanel.setLayout(generalPanelLayout);
        generalPanelLayout.setHorizontalGroup(
                generalPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(generalPanelLayout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(generalPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(generalPanelLayout.createSequentialGroup()
                                                .addGroup(generalPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                        .addGroup(GroupLayout.Alignment.LEADING, generalPanelLayout.createSequentialGroup()
                                                                .addGap(1, 1, 1)
                                                                .addComponent(addressLabel, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(generalPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(addressSep)
                                                                        .addComponent(addressTF)))
                                                        .addGroup(GroupLayout.Alignment.LEADING, generalPanelLayout.createSequentialGroup()
                                                                .addComponent(priceLabel)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(generalPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(priceSep)
                                                                        .addComponent(priceTF, GroupLayout.DEFAULT_SIZE, 599, Short.MAX_VALUE))
                                                                .addGap(421, 421, 421)))
                                                .addGap(29, 29, 29))
                                        .addGroup(generalPanelLayout.createSequentialGroup()
                                                .addComponent(nameLabel, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(generalPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(nameSep)
                                                        .addComponent(nameTF))
                                                .addGap(33, 33, 33))
                                        .addGroup(generalPanelLayout.createSequentialGroup()
                                                .addComponent(propertyTypeLabel, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(typeCbB, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        generalPanelLayout.setVerticalGroup(
                generalPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(generalPanelLayout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addGroup(generalPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(nameLabel)
                                        .addComponent(nameTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nameSep, GroupLayout.PREFERRED_SIZE, 11, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(generalPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(addressLabel)
                                        .addComponent(addressTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(addressSep, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(generalPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(propertyTypeLabel)
                                        .addComponent(typeCbB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(24, 24, 24)
                                .addGroup(generalPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(priceLabel)
                                        .addComponent(priceTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(priceSep, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(19, Short.MAX_VALUE))
        );

        GroupLayout pinkBgPanelLayout = new GroupLayout(pinkBgPanel);
        pinkBgPanel.setLayout(pinkBgPanelLayout);
        pinkBgPanelLayout.setHorizontalGroup(
                pinkBgPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(pinkBgPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(backLabel)
                                .addGap(37, 37, 37))
                        .addGroup(pinkBgPanelLayout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addGroup(pinkBgPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(generalPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(pinkBgPanelLayout.createSequentialGroup()
                                                .addGroup(pinkBgPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                        .addComponent(generalLabel, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 239, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(titleLabel, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 239, GroupLayout.PREFERRED_SIZE))
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(GroupLayout.Alignment.TRAILING, pinkBgPanelLayout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(activeStatusCB)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(saveButton, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(pinkBgPanelLayout.createSequentialGroup()
                                                .addGroup(pinkBgPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(pinkBgPanelLayout.createSequentialGroup()
                                                                .addComponent(propertyDetailsPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addGap(18, 18, 18))
                                                        .addGroup(pinkBgPanelLayout.createSequentialGroup()
                                                                .addComponent(propertyDetailsLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addGap(30, 30, 30)))
                                                .addGroup(pinkBgPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(facilitiesLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(facilitiesPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addGap(48, 48, 48))
        );
        pinkBgPanelLayout.setVerticalGroup(
                pinkBgPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(pinkBgPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(backLabel)
                                .addGap(19, 19, 19)
                                .addComponent(titleLabel)
                                .addGap(26, 26, 26)
                                .addComponent(generalLabel, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(generalPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addGroup(pinkBgPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(propertyDetailsLabel, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(facilitiesLabel, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pinkBgPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(propertyDetailsPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(facilitiesPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(pinkBgPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(saveButton, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(activeStatusCB))
                                .addContainerGap(59, Short.MAX_VALUE))
        );

        jScrollPane.setViewportView(pinkBgPanel);

        GroupLayout whiteBgPanelLayout = new GroupLayout(whiteBgPanel);
        whiteBgPanel.setLayout(whiteBgPanelLayout);
        whiteBgPanelLayout.setHorizontalGroup(
                whiteBgPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(whiteBgPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane, GroupLayout.DEFAULT_SIZE, 1400, Short.MAX_VALUE)
                                .addContainerGap())
        );
        whiteBgPanelLayout.setVerticalGroup(
                whiteBgPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(whiteBgPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane, GroupLayout.DEFAULT_SIZE, 830, Short.MAX_VALUE)
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
                        .addComponent(whiteBgPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }

    public void setCheckBox(JCheckBox cb, String text){ //set checkBox's preference
        cb.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        cb.setText(text);
        cb.setBackground(new Color(255, 255, 255));
        cb.setBorder(BorderFactory.createLineBorder(new Color(255, 204, 204)));
        cb.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cb.setFocusable(false);
        facilityCB.add(cb);
    }

    //set textFill's and Separator's preference
    protected void setComponent(JLabel lb, String lbText, JTextField tf, String tfText, JSeparator sep){
        tf.setBackground(new Color(255, 255, 255));
        tf.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        tf.setText(tfText);
        tf.setBorder(null);

        lb.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lb.setText(lbText);

        sep.setBackground(new Color(255, 204, 204));
    }

    protected void setComboBox(JLabel lb, String lbText, JComboBox cbb, String[] array){ //set comboBox's preference
        lb.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lb.setText(lbText);

        cbb.setBackground(new Color(255, 204, 204));
        cbb.setFont(new Font("Segoe UI", Font.BOLD, 14));
        cbb.setModel(new DefaultComboBoxModel<>(array));
        cbb.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cbb.setFocusable(false);
    }

    //getter
    public ArrayList<JCheckBox> getFacilityCheckBox(){
        return facilityCB;
    }

}
