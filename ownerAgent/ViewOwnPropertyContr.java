package ownerAgent;

import main.Frame;
import javax.swing.*;
import java.util.ArrayList;

public class ViewOwnPropertyContr {

    //View
    private Frame currentFrame; //From Home Page
    private JPanel currentPane; //From MyPropertyPane from ViewOwnPropertyPage and SubMyPropertyPane

    //Model
    ViewOwnPropertyModel viewOwnPropertyModel = new ViewOwnPropertyModel();
    
    //Constructor
    public ViewOwnPropertyContr(Frame currentFrame){
        this.currentFrame = currentFrame;
    }

    public void addPropertyActionPerformed(){ //load to AddPropertyPage
        currentFrame.close();
        AddPropertyPage addPropertyPage = new AddPropertyPage();
        addPropertyPage.setVisible(true);
    }

    public void refreshLabelMouseClicked(){ //remove all SubMyPropertyPane from MyPropertyPane
        currentPane.removeAll();
    }

    public void editPropertyButtonActionPerformed(int propertyID){ //load to EditPropertyPage
        viewOwnPropertyModel.setPropertyID(propertyID);
        currentFrame.close();
        EditPropertyPage editPropertyPage = new EditPropertyPage(propertyID);
        editPropertyPage.setVisible(true);
    }

    public void deletePropertyButtonActionPerformed(int propertyID){ //delete property, get confirmation from user
        //create JOptionPane
        int choice = JOptionPane.showConfirmDialog(currentFrame,"Are you sure you want to delete this property?","Delete Confirmation",JOptionPane. YES_NO_OPTION);

        //perform delete
        if(choice==JOptionPane.YES_OPTION){
            viewOwnPropertyModel.setPropertyID(propertyID);
            viewOwnPropertyModel.deleteProperty();
            JOptionPane.showMessageDialog(currentFrame,"Property has been deleted successfully\nPlease refresh the page.");
        }
    }

    public ArrayList<ViewOwnPropertySubPane> getAllMyProperties(){ //get all own property from sub pane class
        return viewOwnPropertyModel.getAllMyProperties(this);
    }

    public String[] readPropertyString(int propertyID){ //return string's property's details
        viewOwnPropertyModel.setPropertyID(propertyID);
        return viewOwnPropertyModel.readPropertyString();
    }

    //getter
    public JPanel getNewCurrentPane(){ //Get main pane
        return currentPane;
    }

    public int getNumberOfProperty() { //Get number of my properties
        return viewOwnPropertyModel.getNumberOfProperty();
    }

    //setter
    public void setCurrentPane(JPanel currentPane){ //Set main pane
        this.currentPane = currentPane;
    }



}
