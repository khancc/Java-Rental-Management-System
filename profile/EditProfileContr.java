package profile;

import main.Frame;
import javax.swing.*;
import home.HomePage;

public class EditProfileContr {
    //View
    private Frame currentFrame;

    //Model
    private ProfileModel profileModel = new ProfileModel();

    //Constructor
    EditProfileContr(Frame currentFrame){
        this.currentFrame = currentFrame;
    }

    public String[] setInitialValues(){ //set initialise property's details for ProfilePane
        return profileModel.getProfileData();
    }

    public void SubmitButtonActionPerformed(String[] editedValues) { //submit edited profile
        //check input error and get error message
        String returnMessage = profileModel.checkError(editedValues);

        if(profileModel.getCheckError()){ //if no error
            JOptionPane.showMessageDialog(currentFrame,"Your Profile has been edited successfully.","Submitted Successfully", JOptionPane.INFORMATION_MESSAGE);
            backLabelMouseClicked(); //load to Home page - Profile Pane
        }
        else { //if error
            JOptionPane.showMessageDialog(currentFrame,returnMessage,"Invalid Input", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void backLabelMouseClicked() { //load to Home page - Profile Pane
        currentFrame.close();
        HomePage homePage= new HomePage();
        homePage.setVisible(true);
        homePage.getTabbedPane().setSelectedIndex(1);
    }


}
