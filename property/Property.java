package property;

import java.sql.*;
import java.util.ArrayList;
import database.DatabaseConnection;

public class Property {

    private int id, numberOfRoom,numberOfBathroom,size;
    private String name,address,project,type,status;
    private double price;
    private int ownerID,agentID = 0;

    //Constructor
    public Property(){}

    //Constructor
    public Property(String name,String address, String type, double price, String project, int size, int numberOfRoom,int numberOfBathroom, String status){
        this.name = name;
        this.address = address;
        this.type = type;
        this.price = price;
        this.project = project;
        this.size = size;
        this.numberOfRoom = numberOfRoom;
        this.numberOfBathroom = numberOfBathroom;
        this.status = status;
    }

    public static ArrayList<ArrayList<Object>> getPropertyList(String query){ //get Property for TableList
        ArrayList<ArrayList<Object>> propertyList = new ArrayList<>();

        try{
            Statement stmt = DatabaseConnection.getConnection().createStatement();
            ResultSet rs=stmt.executeQuery(query);

            while(rs.next()){
                ArrayList<Object> propertyItem = new ArrayList<>();
                propertyItem.add(rs.getInt(1));
                propertyItem.add(rs.getString(2));
                propertyItem.add(rs.getString(3));
                propertyItem.add(rs.getString(4));
                propertyItem.add(rs.getBigDecimal(5).doubleValue());
                propertyList.add(propertyItem);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return propertyList;
    }

    public Property getPropertyFromDatabase(int propertyID){ //get 1 selected property data from database, and set property
        try{
            Statement statement = DatabaseConnection.getConnection().createStatement();
            String sql = "select * from property where property_id=" + propertyID + ";";
            ResultSet result = statement.executeQuery(sql);
            while(result.next()){
                setName(result.getString("property_name")) ;
                setAddress(result.getString("property_address"));
                setProject(result.getString("property_project"));
                setType(result.getString("property_type"));
                setSize(result.getInt("property_size"));
                setRoom(result.getInt("property_numRoom"));
                setBathroom(result.getInt("property_numBathroom"));
                setPrice(result.getBigDecimal("property_price").doubleValue());
                setStatus(result.getString("property_status"));
                setAgentID(result.getInt("property_agent"));
                setOwnerID(result.getInt("property_owner"));

            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return this;
    }

    public String[] returnString(){ //return details in string
        return new String[]{name,address,type,String.valueOf(price),project,String.valueOf(size),String.valueOf(numberOfRoom),String.valueOf(numberOfBathroom),status};
    }

    //getter
    public int getOwnerID() {
        return ownerID;
    }
    public int getAgentID() {
        return agentID;
    }
    public String getProject(){
        return project;
    }
    public int getSize(){
        return size;
    }
    public int getRoom(){
        return numberOfRoom;
    }
    public int getBathroom(){
        return numberOfBathroom;
    }
    public String getName(){
        return name;
    }
    public int getPropertyID(){
        return id;
    }
    public String getAddress(){
        return address;
    }
    public String getType(){
        return type;
    }
    public double getPrice(){
        return price;
    }
    public String getStatus(){
        return status;
    }

    //setter
    public void setOwnerID(int ownerID) {
        this.ownerID = ownerID;
    }
    public void setAgentID(int agentID) {
        this.agentID = agentID;
    }
    public void setStatus(String status){
        this.status = status;
    }
    public void setProject(String project){
        this.project=project;
    }
    public void setSize(int size){
        this.size=size;
    }
    public void setRoom(int room){
        this.numberOfRoom = room;
    }
    public void setBathroom(int bathroom){
        this.numberOfBathroom = bathroom;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setPropertyID(int id){
        this.id = id;
    }
    public void setAddress(String address){
        this.address = address;
    }
    public void setType(String type){
        this.type = type;
    }
    public void setPrice(double price){
        this.price = price;
    }
}


