package register;

import main.LandingPage;
import javax.swing.*;

public class RegisterContr {
    //View
    private RegisterView currentFrame;

    //Model
    private Register register = new Register();

    //Constructor
    RegisterContr(RegisterView currentFrame){
        this.currentFrame = currentFrame;
    }

    public void signUpButtonMouseClicked(int roleNumber) { //sign up
        //get error message from model
        String message = register.checkRegistration(currentFrame.getNameEntered(), currentFrame.getPhoneEntered(), currentFrame.getEmailEntered());

        //no input error
        if (register.getCheckRegister()) {
            //generate request and store into database
            Request request = new Request(roleNumber, currentFrame.getNameEntered(), currentFrame.getEmailEntered(), currentFrame.getPhoneEntered());

            //check database table if same email and phone registered by other user
            if (!request.checkTable()){ //email or phone in used, check from actor's database
                JOptionPane.showMessageDialog(currentFrame, "Invalid input. Email or phone number has registered.", "Registration Fail", JOptionPane.INFORMATION_MESSAGE);
            }
            else if (!request.insertRequest()){ //email or phone in used,, check from registration's database
                JOptionPane.showMessageDialog(currentFrame, "Invalid input. Email or phone number has registered.", "Registration Fail", JOptionPane.INFORMATION_MESSAGE);
            }
            else{ //email and phone not been used, load to landing page
                JOptionPane.showMessageDialog(currentFrame, "Your registration has been submitted to the Administrator." +
                                "\nPlease kindly check your email for the results.\nThis process might take some time.\nThank You.",
                        "Registration Submitted", JOptionPane.INFORMATION_MESSAGE);
                currentFrame.close();
                new LandingPage().setVisible(true);
            }
        }
        else{
            //show unsuccessful register to UI
            JOptionPane.showMessageDialog(currentFrame,message,"Invalid Input", JOptionPane.ERROR_MESSAGE);
        }

    }

}
