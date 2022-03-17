package ownerAgent;

import account.Account;
import account.Agent;
import account.Owner;
import property.Property;
import java.util.ArrayList;

public class ViewOwnPropertyModel {

    //Association
    private Account account = Account.getAccount();
    private Owner owner;
    private Agent agent;

    //Variables
    private int propertyID;
    private int numberOfProperty;

    //Constructor
    ViewOwnPropertyModel(){
        if(account.getRole()==1){ //agent
            agent = (Agent)account;
        }
        if(account.getRole()==2) //owner
            owner = (Owner)account; 
    }

    //Get all my properties from database
    public ArrayList<ViewOwnPropertySubPane> getAllMyProperties(ViewOwnPropertyContr contr){
        ViewOwnPropertySubPane viewOwnPropertySubPane;
        ArrayList<ViewOwnPropertySubPane> viewOwnPropertySubPaneArray = new ArrayList<>(); //sub-panel's list
        ArrayList<Property> propertyList;

        if(account.getRole()==1) //agent
            propertyList = agent.viewOwnProperty();
        else //owner
            propertyList = owner.viewOwnProperty();

        numberOfProperty = propertyList.size();

        if(numberOfProperty!=0){
            for (Property property : propertyList) {
                viewOwnPropertySubPane = new ViewOwnPropertySubPane(contr, property.getPropertyID());
                viewOwnPropertySubPaneArray.add(viewOwnPropertySubPane);
            }
        }
        return viewOwnPropertySubPaneArray;
    }

    public void deleteProperty(){ //delete a property
        if(account.getRole()==1)
            agent.deleteProperty(propertyID); //agent
        else
            owner.deleteProperty(propertyID); //owner
    }

    public String[] readPropertyString(){ //get property data from database and return as an string array for property's initialisation
        Property property = new Property();
        property = property.getPropertyFromDatabase(propertyID);

        return property.returnString();
    }

    //setter
    public void setPropertyID(int propertyID){
        this.propertyID = propertyID;
    }

    //getter
    public int getNumberOfProperty() {
        return numberOfProperty;
    }

}
