package account;

import database.DatabaseConnection;
import property.*;
import java.sql.*;
import java.util.ArrayList;

public class Owner extends Account implements PropertyInterface{

    //Association
    private Facility facility = new Facility();

    //Constructors
    public Owner() {}

    //Account
    @Override
    public boolean createAccount() {
        try{
            Statement statement = DatabaseConnection.getConnection().createStatement();
            String query = "insert into owner (owner_name, owner_phone, owner_email, owner_username, owner_password) VALUES ('" +
                    getName() + "'," + getPhone() + ",'" + getEmail() + "' ,'" + getUsername() + "','" + getPassword() + "')";
            statement.executeUpdate(query);
        }catch (Exception ex) {
            return false;
        }
        return true;
    }

    @Override
    public String toString(){
        return "Owner";
    } //Return actor's string

    //Property Interface
    @Override
    public void addProperty(Property property,ArrayList<String> facilityList) { //save new property and facility into database
        try {
            PreparedStatement stmt=DatabaseConnection.getConnection().prepareStatement("insert into property (property_name, property_address, property_type, property_price, property_project, property_size, property_numRoom, property_numBathroom, property_status, property_owner) values (?,?,?,?,?,?,?,?,?,?);");
            stmt.setString(1,property.getName());
            stmt.setString(2,property.getAddress());
            stmt.setString(3,property.getType());
            stmt.setDouble(4,property.getPrice());
            stmt.setString(5,property.getProject());
            stmt.setInt(6,property.getSize());
            stmt.setInt(7,property.getRoom());
            stmt.setInt(8,property.getBathroom());
            stmt.setString(9,property.getStatus());
            stmt.setInt(10, getID());

            stmt.executeUpdate();
            facility.setFacility(facilityList);
            facility.storeDatabase();

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void editProperty(Property property,ArrayList<String> facilityList) { //save edited property and facility into database
        try {
            Statement statement = DatabaseConnection.getConnection().createStatement();
            String sql = "update property " +
                    "set property_name = '" + property.getName() + "'" +
                    ", property_address = '" + property.getAddress() + "'" +
                    ", property_type = '" + property.getType() + "'" +
                    ", property_price = " + property.getPrice() +
                    ", property_project = '" + property.getProject() + "'" +
                    ", property_size = " + property.getSize() +
                    ", property_numRoom = " + property.getRoom() +
                    ", property_numBathroom = " + property.getBathroom() +
                    ", property_status = '" + property.getStatus() + "'" +
                    " where property_id = " + property.getPropertyID() +
                    ";";
            statement.executeUpdate(sql);
            facility.setFacility(facilityList);
            facility.setPropertyId(property.getPropertyID());
            facility.updateDatabase(property.getPropertyID());
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void deleteProperty(int propertyID) { //delete a property in database
        try{
            Statement statement = DatabaseConnection.getConnection().createStatement();
            String sqlFacility = "delete from facility where property_id = " + propertyID;
            String sqlProperty = "delete from property where property_id = " + propertyID;
            statement.executeUpdate(sqlFacility);
            statement.executeUpdate(sqlProperty);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public ArrayList<Property> viewOwnProperty(){ //Get all my properties from database
        ArrayList<Property> ownPropertyList = new ArrayList<>();
        try{
            Statement statement = DatabaseConnection.getConnection().createStatement();
            String sql = "select * from property where property_owner=" + getID() + ";";
            ResultSet result = statement.executeQuery(sql);
            while(result.next()){
                Property property = new Property();
                //set the properties' details
                property.setPropertyID(result.getInt("property_id"));
                property.setName(result.getString("property_name")) ;
                property.setAddress(result.getString("property_address"));
                property.setProject(result.getString("property_project"));
                property.setType(result.getString("property_type"));
                property.setSize(result.getInt("property_size"));
                property.setRoom(result.getInt("property_numRoom"));
                property.setBathroom(result.getInt("property_numBathroom"));
                property.setPrice(result.getBigDecimal("property_price").doubleValue());
                property.setStatus(result.getString("property_status"));

                //set agent name and contact
                property.setOwnerID(result.getInt("property_owner"));

                //add into this property into array list
                ownPropertyList.add(property);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return ownPropertyList;
    }

    //Other
    public boolean login(String usernameEntered, String passwordEntered) { //check username password in database
        try{
            Statement statement = database.DatabaseConnection.getConnection().createStatement();
            String sql = "select * from owner where owner_username='"+usernameEntered
                    +"' and owner_password='"+ passwordEntered+"'";
            ResultSet resultSet = statement.executeQuery(sql);

            if (resultSet.next()){
                //if exist then set details for this account
                setID(resultSet.getInt(1));
                setName(resultSet.getString(2));
                setPhone(resultSet.getInt(3));
                setEmail(resultSet.getString(4));
                setUsername(resultSet.getString(5));
                setPassword(resultSet.getString(6));
                setRole(2);
                setAcount(this);
                return true; //account found
            }

        }catch(Exception ex){
            ex.printStackTrace();
        }
        return false; //account not found
    }

    public void editProfile() { //update edited account into database
        try {
            Statement statement = DatabaseConnection.getConnection().createStatement();
            String sql = "update owner " +
                    "set owner_name = '" + getName() + "'" +
                    ", owner_phone = " + getPhone() +
                    ", owner_email = '" + getEmail() + "'" +
                    ", owner_username = '" + getUsername() + "'" +
                    ", owner_password = '" + getPassword() + "'" +
                    " where owner_id = " + getID() +
                    ";";
            statement.executeUpdate(sql);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public static ArrayList<String> getNamePhone(int ID){ //get agent's name and phone to display to users
        try{
            Statement statement = database.DatabaseConnection.getConnection().createStatement();
            String sql = "select owner_name,owner_phone from owner where owner_id = "+ ID;
            ResultSet resultSet = statement.executeQuery(sql);
            ArrayList<String> namePhone = new ArrayList<String>();

            if (resultSet.next()){
                namePhone.add(resultSet.getString(1));
                namePhone.add(Integer.toString(resultSet.getInt(2)));
                return namePhone;
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

}


