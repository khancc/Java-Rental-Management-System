package home;

import java.util.ArrayList;
import property.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.TreePath;
import account.Agent;
import account.Owner;

public class ViewBoardContr{

    //View
    private ViewBoardPane panel;

    //Constructor
    ViewBoardContr(ViewBoardPane panel){
        this.panel = panel;
    }

    //Variables
    private ArrayList<ArrayList<Object>> propertyList = new ArrayList<ArrayList<Object>>();
    private String[]columnTableString= {"ID","Name", "Address", "Property Type", "Price(RM)"};
    private Object[][] propertyArray;

    public void setDetailPanel(){ //set panel's details
        ArrayList<String> namePhone; //owner's or agent's name and phone
        Property property = new Property();

        property.getPropertyFromDatabase(panel.getIdEntered()); //get property's details from database

        //based on actor's role
        if (property.getOwnerID()>=1)
            namePhone = Owner.getNamePhone(property.getOwnerID());
        else
            namePhone = Agent.getNamePhone(property.getAgentID());

        Facility facility = new Facility();
        ArrayList<String> facilityArrayList = facility.getFacilityFromDatabase(panel.getIdEntered()); //get facility's details from database
        String[] facilityArray = facilityArrayList.toArray(new String[0]);

        //set panel's details
        panel.getFacilityList().setListData(facilityArray);
        panel.setPropertyDetails(property,namePhone);
    }

    public String setSortQuery(TreePath selectedNode){ //get query to access database for sorting purpose

        String parent = selectedNode.getPath()[1].toString().toLowerCase(); //string to access database based on which column
        parent = "property_" + parent; //exm: property_status
        String child = selectedNode.getLastPathComponent().toString(); //string to access database based on a condition

        //view all properties
        String query = "SELECT property_id,property_name,property_address,property_type,property_price FROM property";
        if (child.equals("All Property"))
            return query;

        //based on active or inactive
        if (parent.equals("property_status")){
            if(child.equals("Active")){ //condition: active
                return (query+ " WHERE " + parent + " = \"Y\"");
            }
            else{ //condition: inactive
                return (query+ " WHERE " + parent + " = \"N\"");
            }
        }

        //based on facility
        if (parent.equals("property_facility"))
            return "SELECT property.property_id,property_name ,property_address,property_type,property_price from property, facility WHERE " +
                    child.toLowerCase().replace(" ", "_") + " = 1 and property_status = 'Y' and facility.property_ID = property.property_id group by facility.property_ID";

        //based on price
        if(parent.equals("property_price")){
            if(child.equals("Low - High")){ //condition: ascending order
                return query + " WHERE property_status = 'Y' ORDER BY " + parent + " ASC";
            }else{ //condition: descending order
                return query + " WHERE property_status = 'Y' ORDER BY " + parent + " DESC";
            }
        }

        child = "\"" + child + "\""; //because child is varchar from now on

        //based on agent
        if (parent.equals("property_agent")){
            return query + " ,agent WHERE property_status = 'Y' and property_agent = (SELECT agent_id WHERE agent_name = " + child + ")" ;
        }

        //based on owner
        if(parent.equals("property_owner")){
            return query + " ,owner WHERE property_status = 'Y' and property_owner = (SELECT owner_id WHERE owner_name = " + child + ")" ;
        }

        //based on project/township
        if(parent.equals("property_project/township")){
            return query + " WHERE property_status = 'Y' and property_project = " + child;
        }

        //set query
        query = query + " WHERE property_status = 'Y' and " + parent + " = " + child; //for property_type
        return (query);
    }

    public void setDefaultTable(JTable table){ //set default data for view-board table
        //get all property from database
        propertyList = Property.getPropertyList("SELECT property_id,property_name,property_address,property_type,property_price FROM property WHERE property_status = 'Y'");

        //convert arraylist to array
        propertyArray = WrapCellRenderer.arrayListToArray(propertyList);

        //set table
        DefaultTableModel model = new DefaultTableModel(propertyArray, columnTableString);
        table.setModel(model);
        table.setDefaultRenderer(Object.class, new WrapCellRenderer());
        panel.setTableContent(table);
    }

    public void setTableContent(TreePath selectedNode,JTable table) throws NullPointerException{ //set data for view-board table based on node chosen
        //get all property from database based on node chosen
        String query = setSortQuery(selectedNode);
        propertyList = Property.getPropertyList(query);

        //convert arraylist to array
        propertyArray = WrapCellRenderer.arrayListToArray(propertyList);

        //update table
        table.setModel(new DefaultTableModel( propertyArray,columnTableString));
        table.setDefaultRenderer(Object.class, new WrapCellRenderer());
        panel.setTableContent(table);
    }
}





