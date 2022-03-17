package account;

import database.DatabaseConnection;
import java.sql.*;

public class PotentialTenant extends Account{

    //Constructors
    public PotentialTenant() {}

    //Account
    @Override
    public boolean createAccount() {
        try{
            Statement statement = DatabaseConnection.getConnection().createStatement();
            String query = "insert into tenant (tenant_name, tenant_phone, tenant_email, tenant_username, tenant_password) VALUES ('" +
             getName() + "'," + getPhone() + ",'" + getEmail() + "' ,'" + getUsername() + "','" + getPassword() + "')";
            statement.executeUpdate(query);
        }catch (Exception ex) {
            return false;
        }
        return true;
        
    }

    @Override
    public String toString(){
        return "Tenant";
    } //Return actor's string

    public boolean login(String usernameEntered, String passwordEntered) { //check username password in database
        try{
            Statement statement = database.DatabaseConnection.getConnection().createStatement();
            String query = "select * from tenant where tenant_username='"+usernameEntered
                    +"' and tenant_password='"+ passwordEntered+"'";
            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet.next()){
                //if exist then set details for this account
                setID(resultSet.getInt(1));
                setName(resultSet.getString(2));
                setPhone(resultSet.getInt(3));
                setEmail(resultSet.getString(4));
                setUsername(resultSet.getString(5));
                setPassword(resultSet.getString(6));
                setRole(0);
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
            String sql = "update tenant " +
                    "set tenant_name = '" + getName() + "'" +
                    ", tenant_phone = " + getPhone() +
                    ", tenant_email = '" + getEmail() + "'" +
                    ", tenant_username = '" + getUsername() + "'" +
                    ", tenant_password = '" + getPassword() + "'" +
                    " where tenant_id = " + getID() +
                    ";";
            statement.executeUpdate(sql);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

}
