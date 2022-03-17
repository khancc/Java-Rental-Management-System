package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;

public class Frame extends JFrame {

    //Constructor
    public Frame(){
        setIconImage(new ImageIcon(getClass().getResource("/image/CyberentLogo.png")).getImage());
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
    }

    public void setBgColor1(JPanel whitePnl, JPanel pinkPnl){
        whitePnl.setBackground(new Color(255, 255, 255));
        pinkPnl.setBackground(new Color(186, 79, 84));
    }

    public void setBgColor2(JPanel whitePnl, JPanel pinkPnl){
        whitePnl.setBackground(new Color(255, 255, 255));
        pinkPnl.setBackground(new Color(255, 204, 204));
    }

    public void close(){ //close this frame
        WindowEvent closeWindow = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
    }

    public String getRoleString(int roleNumber){ //get role in string
        String roleString;
        if (roleNumber == 0)
            roleString = "Tenant";
        else if (roleNumber == 1)
            roleString = "Agent";
        else if (roleNumber == 2)
            roleString = "Owner";
        else
            roleString = "Admin";
        return roleString;
    }

    //getter
    public Frame getFrame(){
        return this;
    }

}
