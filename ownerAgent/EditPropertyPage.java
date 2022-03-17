package ownerAgent;

import java.util.ArrayList;
import javax.swing.JCheckBox;
import property.Facility;

public class EditPropertyPage extends PropertyPage {

    //Constructor
    public EditPropertyPage(int propertyID){
        this.setTitle("Edit Property Page");

        //Overwrite
        titleLabel.setText("Edit Property");

        //Set initial text
        addEditPropertyContr.setPropertyID(propertyID);
        setInitialValue();
        setFacility(propertyID);

    }
    
    //set initial property's data from the database
    private void setInitialValue(){
        String[] initialStringValues = addEditPropertyContr.getStringInitialValues();

        //Property's Details
        setComponent(nameLabel, "Name:", nameTF, initialStringValues[0], nameSep);
        setComponent(addressLabel, "Address:", addressTF, initialStringValues[1], addressSep);
        typeCbB.setSelectedItem(initialStringValues[2]);
        setComponent(priceLabel, "Rental Price:    RM", priceTF, initialStringValues[3], priceSep);
        setComponent(projectLabel, "Project/Township:", projectTF, initialStringValues[4], projectSep);
        setComponent(sizeLabel, "Size:", sizeTF, initialStringValues[5], sizeSep);
        numberOfRoomCbB.setSelectedItem(initialStringValues[6]);
        numberOfBathroomCbB.setSelectedItem(initialStringValues[7]);

        if(initialStringValues[8].equals("Y"))
            activeStatusCB.setSelected(true);
        else{
            activeStatusCB.setSelected(false);
        }
    }

    //set default facility's data from database for the property
    public void setFacility(int propertyID){
        Facility facility = new Facility();
        ArrayList<String> initialFacility = facility.getFacilityFromDatabase(propertyID);
        ArrayList<JCheckBox> facilityCB = getFacilityCheckBox();

        for(String fac : initialFacility){
            for(JCheckBox cb: facilityCB){
                if (cb.getText().equals(fac))
                    cb.setSelected(true);
            }
        }
    }
}

