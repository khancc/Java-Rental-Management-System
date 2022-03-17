package ownerAgent;

import account.Account;
import account.Agent;
import account.Owner;
import property.Property;
import java.util.ArrayList;
import java.util.Arrays;

public class AddEditPropertyModel {

    //Association
    private Account account = Account.getAccount();
    private Owner owner;
    private Agent agent;

    //Variables
    private boolean checkProperty;
    private String[] stringTF;
    private boolean status;
    private ArrayList<String> facility;
    private int propertyID;

    //Constructor
    AddEditPropertyModel(){
        if(account.getRole()==1)//agent
            agent = (Agent)account;
        else //owner
            owner = (Owner)account;
    }

    //check input error
    public String checkError(int action, String[] stringTF, boolean status, ArrayList<String> facility) {
        checkProperty = true;
        String[] attributeString = new String[]{"Name", "Address", "Project", "Size", "Price"};
        Boolean[] checkEachInput = new Boolean[5];
        Arrays.fill(checkEachInput, Boolean.TRUE); //initialise all to true
        String[] messageArray = new String[5];
        StringBuffer messageBuilder = new StringBuffer();

        //for name, address, project, and type, check is not empty
        for (int i = 0; i < 3; i++) {
            if(stringTF[i] == null || stringTF[i].isEmpty()){
                checkEachInput[i] = false;
                messageArray[i] = "Invalid " + attributeString[i] + ".\n" + attributeString[i] + " should not be blank.";
            }
        }

        //for size
        if(stringTF[3] == null || stringTF[3].isEmpty()) { //check is not empty
            checkEachInput[3] = false;
            messageArray[3] = "Invalid " + attributeString[3] + ".\n" + attributeString[3] + " should not be blank.";
        }
        else{ //make sure only digit
            for(char character : stringTF[3].toCharArray()){
                if(!Character.isDigit(character)){
                    checkEachInput[3] = false;
                    messageArray[3] = "Invalid Size.\nSize should contains only digits.";
                }
            }
        }

        //for price
        if(stringTF[4] == null || stringTF[4].isEmpty()) { //check is not empty
            checkEachInput[4] = false;
            messageArray[4] = "Invalid Price.\nPrice should not be blank.";
        }
        else{ //make sure only digit
            if(!stringTF[4].matches("[0-9.]*")){
                checkEachInput[4] = false;
                messageArray[4] = "Invalid Price.\nPrice should contains only digits and decimal point.";
            }
        }

        //create error message
        for (int i = 0; i < 5; i++) {
            if(checkEachInput[i]==false){
                checkProperty = false;
                messageBuilder.append("\n"+messageArray[i]);
            }
        }

        //do action
        if(!checkProperty) //if got error
            return messageBuilder.toString();
        else{ //if no error
            this.stringTF = stringTF;
            this.status = status;
            this.facility = facility;

            if(action == 1)
                editProperty();
            else
                addProperty();
        }

        return null;
    }

    public void addProperty(){
        //Change String to int
        int intSize = Integer.parseInt(stringTF[3]);
        int intNumberOfRoom = Integer.parseInt(stringTF[6]);
        int intNumberOfBathroom = Integer.parseInt(stringTF[7]);
        //Change String to double
        double doublePrice = Double.parseDouble(stringTF[4]);
        //Do changes
        String name = stringTF[0];
        String address = stringTF[1];
        String project = stringTF[2];
        String type = stringTF[5];
        //convert status to string
        String stringStatus;
        if(status)
            stringStatus = "Y";
        else
            stringStatus = "N";

        //create property
        Property property = new Property(name,address,type,doublePrice,project,intSize,intNumberOfRoom,intNumberOfBathroom,stringStatus);

        //insert into database
        if(account.getRole()==1)
            agent.addProperty(property,facility);
        else
            owner.addProperty(property,facility);
    }

    public void editProperty(){
        //Change String to int
        int intSize = Integer.parseInt(stringTF[3]);
        int intNumberOfRoom = Integer.parseInt(stringTF[6]);
        int intNumberOfBathroom = Integer.parseInt(stringTF[7]);
        //Change String to double
        double doublePrice = Double.parseDouble(stringTF[4]);
        //Do changes
        String name = stringTF[0];
        String address = stringTF[1];
        String project = stringTF[2];
        String type = stringTF[5];
        //convert status to string
        String stringStatus;
        if(status)
            stringStatus = "Y";
        else
            stringStatus = "N";

        //create property
        Property property = new Property(name,address,type,doublePrice,project,intSize,intNumberOfRoom,intNumberOfBathroom,stringStatus);
        property.setPropertyID(propertyID);

        //update database
        if(account.getRole()==1){
            property.setAgentID(account.getID());
            agent.editProperty(property, facility);
        }   
        else{
            property.setOwnerID(account.getID());
            owner.editProperty(property, facility);
        }
    }

    public String[] readPropertyString(){ ////get initialise property's details for AddEditPropertyContr
        Property property = new Property();
        property.getPropertyFromDatabase(propertyID); //get property's details from database

        String[] initialValues = property.returnString();
        return initialValues;
    }

    //getter
    public boolean getCheckProperty(){
        return checkProperty;
    }

    //setter
    public void setPropertyID(int propertyID){
        this.propertyID = propertyID;
    }

}
