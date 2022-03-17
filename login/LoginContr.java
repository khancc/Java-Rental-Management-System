package login;

import javax.swing.*;
import home.HomePage;

public class LoginContr {

    //View
    private LoginPage currentFrame;

    //Model
    private Login login = new Login();;

    //Constructor
    LoginContr(LoginPage currentFrame){
        this.currentFrame = currentFrame;
    }

    public void setRole(int role){
        login.setRole(role);
    }

    public void loginButtonActionPerformed(int role){ //check login using model
        login.setRole(role);
        boolean checkFlag = login.checkLogin(currentFrame.getNameEntered(), currentFrame.getPasswordEntered()); //checked here

        if (checkFlag){ //correct and found, then load to home page
            currentFrame.close();
            new HomePage().setVisible(true);
        }
        else{//wrong or not found
            JOptionPane.showMessageDialog(currentFrame,"Wrong Username and Password","Invalid Input", JOptionPane.ERROR_MESSAGE);
        }
    }

}
