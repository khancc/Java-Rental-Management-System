package admin;

import home.WrapCellRenderer;
import register.Request;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import account.Admin;

public class RequestContr {

    //View
    private RequestPane panel;

    //Association
    private Admin admin = new Admin();
    private Request request = new Request();

    //Variables
    private String[] registerTableColumn = {"ID", "Name", "Phone", "Email", "Role"};
    private Object[][] requestArray;
    private Integer rowSelected;

    //Constructor
    RequestContr(RequestPane panel){
        this.panel = panel;
    }

    public void setDefaultTable(JTable table){ //set all requests to the table
        //get all requests
        ArrayList<ArrayList<Object>> requestList = request.getRequestList();
        requestArray = WrapCellRenderer.arrayListToArray(requestList);

        //update table
        DefaultTableModel model = new DefaultTableModel(requestArray, registerTableColumn);
        table.setModel(model);
        panel.setTableContent(table);
    }

    public void approveBtnActionPerformed(JTable table) { //to perform approve request by using models
        try{
            //read request from database return as account type
            int id = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString());
            request = request.getRequestFromDatabase(id); 

            //delete the row which approved from the table
            DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
            for(int i=0; i<table.getRowCount();i++){
                if (Integer.parseInt(table.getValueAt(i, 0).toString()) == id)
                    rowSelected = i;
            }
            tableModel.removeRow(rowSelected);

            //approve request
            JOptionPane.showMessageDialog(panel, "Registration approved");
            admin.approveRequest(request);

        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "No request");
        }
    }

    public void declineBtnActionPerformed(JTable table) { //to perform decline request by using models
        try{
            //get which id and its email did user choose to delete
            int id = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString());
            String email = table.getValueAt(table.getSelectedRow(), 3).toString();

            //delete the row which approved from the table
            DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
            for(int i=0; i<table.getRowCount();i++){
                if (Integer.parseInt(table.getValueAt(i, 0).toString()) == id)
                    rowSelected = i;
            }
            tableModel.removeRow(rowSelected);

            //decline request
            JOptionPane.showMessageDialog(panel, "Registration declined");
            admin.declineRequest(id,email);

        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "No request");
        }
    }

}

