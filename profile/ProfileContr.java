package profile;

import main.Frame;

public class ProfileContr {

    //View
    private Frame currentFrame;

    //Model
    ProfileModel profileModel = new ProfileModel();

    //Constructor
    public ProfileContr(Frame currentFrame){
        this.currentFrame = currentFrame;
    }

    public String[] setInitialValues(){ //set textFills' text value for Profile Page
        return profileModel.getProfileData();
    }

    public void EditButtonActionPerformed(java.awt.event.ActionEvent evt) { //edit button clicked, load to EditPropertyPage
        currentFrame.close();
        new EditProfilePage().setVisible(true);
    }



}
