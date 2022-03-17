package ownerAgent;

import main.Frame;
import home.HomePage;
import javax.swing.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class AddEditPropertyContr {
    //View
    private Frame currentFrame;

    //Model
    AddEditPropertyModel addEditPropertyModel = new AddEditPropertyModel();

    //Variable
    private int propertyID;

    // Constructor
    AddEditPropertyContr(Frame currentFrame){
        this.currentFrame = currentFrame;
    }

    public void backLabelMouseClicked(MouseEvent evt) { //load to home page - view own property pane
        currentFrame.close();
        HomePage homePage = new HomePage();
            homePage.setVisible(true);
            homePage.getTabbedPane().setSelectedIndex(2);
    }

    public void buttonActionPerformed(String[] stringTF, boolean status,ArrayList<String> facility) { //add or edit button clicked
        String errorMessage; //to store error message
        String popUpMessage; //to store pop up message
        addEditPropertyModel.setPropertyID(propertyID);

        //check input error
        if(currentFrame.getTitle().equals("Edit Property Page")) { //if edit property
            errorMessage = addEditPropertyModel.checkError(1, stringTF,status,facility);
            popUpMessage = "This property has been edited successfully";
        }
        else { //if add property
            errorMessage = addEditPropertyModel.checkError(2, stringTF,status,facility);
            popUpMessage = "This property has been added successfully";
        }
        popUpMessage(errorMessage, popUpMessage); //to create JOptionPane
    }

    private void popUpMessage(String errorMessage, String popUpMessage) { //create JOptionPane
        //if no input error
        if (addEditPropertyModel.getCheckProperty()) {
            int input = JOptionPane.showOptionDialog(currentFrame, popUpMessage, "Changes Saved", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
            //load to home page - view own property pane
            if(input == JOptionPane.OK_OPTION || input == JOptionPane.CLOSED_OPTION)
            {
                currentFrame.close();
                HomePage homePage = new HomePage();
                homePage.setVisible(true);
                homePage.getTabbedPane().setSelectedIndex(2);
            }
        }
        else{ //if error
            JOptionPane.showMessageDialog(currentFrame,errorMessage,"Invalid Input", JOptionPane.ERROR_MESSAGE);
        }
    }

    public String[] getStringInitialValues(){ //get initialise property's details for EditPropertyPage
        addEditPropertyModel.setPropertyID(propertyID);
        return addEditPropertyModel.readPropertyString();
    }

    //setter
    public void setPropertyID(int propertyID){
        this.propertyID = propertyID;
    }

}
