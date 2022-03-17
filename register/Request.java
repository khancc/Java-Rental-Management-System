package register;
import database.DatabaseConnection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import account.*;

public class Request {

    private int role,phone,id;
    private String name;
    private String email;

    //Constructor
    public Request(){}

    //Constructor
    Request(int role, String name, String email, String phone) {
        this.role = role;
        this.name = name;
        this.email = email;
        this.phone = Integer.parseInt(phone);
    }

    public boolean insertRequest(){ //to insert database and check if insert successfully

        try {

            Statement statement = DatabaseConnection.getConnection().createStatement();
            String insertFields = "INSERT INTO registration VALUES(NULL, \"" + name + "\"," +  phone+ ",\"" + email + "\"," + role + ")";
            System.out.println(insertFields);
            statement.executeUpdate(insertFields);
            return true; //no email or phone in used
        } catch (Exception ex) {
            return false; //email or phone is in used
        }
    }

    //check if existing table has other user using same email or phone number
    public boolean checkTable(){
        AccountFactory factory = new AccountFactory();
        try{
            String roleString = factory.getAccount(role).toString().toLowerCase();
            Statement statement = DatabaseConnection.getConnection().createStatement();
            String query = "SELECT " + roleString + "_email, " + roleString + "_phone FROM " + roleString + " WHERE " + roleString +
                    "_email = \'" + email + "\' or " + roleString + "_phone = " + phone;
            ResultSet rs = statement.executeQuery(query);

            if(rs.next()){
                return false; //email or phone is in used
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return true; //no email or phone in used
    }

    public ArrayList<ArrayList<Object>> getRequestList(){ //get request table list
        AccountFactory factory = new AccountFactory();
        ArrayList<ArrayList<Object>> requestList = new ArrayList<>();

        try{
            //open connection
            Statement statement = DatabaseConnection.getConnection().createStatement();
            String query = "select * from registration;";
            ResultSet rs = statement.executeQuery(query);

            while(rs.next()){
                //add all data
                ArrayList<Object> requestRow = new ArrayList<Object>();
                requestRow.add(rs.getInt(1));
                requestRow.add(rs.getString(2));
                requestRow.add(rs.getInt(3));
                requestRow.add(rs.getString(4));
                requestRow.add(factory.getAccount(rs.getInt(5)).toString());
                requestList.add(requestRow);
            }
        } catch(Exception ex){
            ex.printStackTrace();
        }
        return requestList;
    }

    //get one request selected from database, return account type
    public Request getRequestFromDatabase(int registrationID){

        try{
            Statement statement = DatabaseConnection.getConnection().createStatement();
            String sql = "select * from registration where registration_id=" + registrationID + ";";
            ResultSet result = statement.executeQuery(sql);
            while(result.next()){
                int role = result.getInt("registration_account");
                setId(registrationID);
                setName(result.getString("registration_name"));
                setEmail(result.getString("registration_email"));
                setPhone(result.getInt("registration_phone"));
                setRole(role);
                return this;
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    //setter
    public void setId(int id) {
        this.id = id;
    }
    public void setRole(int role) {
        this.role = role;
    }
    public void setName(String name){ this.name = name; }
    public void setPhone(int phone){
        this.phone = phone;
    }
    public void setEmail(String email){
        this.email = email;
    }

    //getter
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public int getPhone(){
        return phone;
    }
    public String getEmail(){
        return email;
    }
    public int getRole(){
        return role;
    }
}
