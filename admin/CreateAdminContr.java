package admin;

import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import account.Admin;
import home.WrapCellRenderer;
import register.Register;

public class CreateAdminContr {

    //View
    private CreateAdminPane panel;

    //Association
    private Register register = new Register();
    private Admin admin = new Admin();

    //Variables
    private String[] adminColumnName = {"Name", "Email", "Phone"};
    private Object[][] adminArray;

    //Constructor
    CreateAdminContr(CreateAdminPane panel){
        this.panel = panel;
    }

    public void addAdminBtnActionPerformed() { //to perform add admin by using model
        //check input error
        String message = register.checkRegistration(panel.getNameEntered(), panel.getPhoneEntered(), panel.getEmailEntered());

        if (register.getCheckRegister()) { //if no input error
            //show successful created to UI, and store into database
            admin.addAdmin(panel.getNameEntered(), panel.getEmailEntered(), panel.getPhoneEntered());
        }
        else{ //if error
            //show unsuccessful register to UI
            JOptionPane.showMessageDialog(null,message,"Invalid Input", JOptionPane.ERROR_MESSAGE);
        }
    } 

    public void refreshBtnActionPerformed(JTable table) { //refresh table
        //get all admin
        ArrayList<ArrayList<Object>> adminList = admin.getAdminList();
        adminArray = WrapCellRenderer.arrayListToArray(adminList);

        //update table
        DefaultTableModel model = new DefaultTableModel(adminArray, adminColumnName );
        table.setModel(model);
        table.setDefaultRenderer(Object.class, new WrapCellRenderer());
        panel.setTableContent(table);
    } 

}

