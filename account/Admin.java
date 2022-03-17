package account;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.swing.JOptionPane;
import database.DatabaseConnection;
import register.Request;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;

public class Admin extends Account{

    private AccountFactory accountFactory = new AccountFactory();

    //Constructor
    public Admin(){}

    //Account
    @Override
    public boolean createAccount() { //save new account into database
        try{
            Statement statement = DatabaseConnection.getConnection().createStatement();
            String query = "insert into admin (admin_name, admin_phone, admin_email, admin_username, admin_password) VALUES ('"
             + getName() + "'," + getPhone() + ",'" + getEmail() + "' ,'" + getUsername() + "','" + getPassword() + "')";
            statement.executeUpdate(query);
            
        }catch (Exception ex) {
            String message = "Creation of new admin account is failed.";
            JOptionPane.showMessageDialog(null, message);
            return false;
        } 
        return true;     
    }

    @Override
    public String toString(){
        return "Admin";
    }

    //Other
    public boolean login(String usernameEntered, String passwordEntered) {
        //check username password
        try{
            Statement statement = database.DatabaseConnection.getConnection().createStatement();
            String sql = "select * from admin where admin_username='"+usernameEntered
                    +"' and admin_password='"+ passwordEntered+"'";
            ResultSet resultSet = statement.executeQuery(sql);

            if (resultSet.next()){
                //if exist then set details for this account
                setID(resultSet.getInt(1));
                setName(resultSet.getString(2));
                setPhone(resultSet.getInt(3));
                setEmail(resultSet.getString(4));
                setUsername(resultSet.getString(5));
                setPassword(resultSet.getString(6));
                setRole(3);
                setAcount(this);
                return true; //account found
            }

        }catch(Exception ex){
            ex.printStackTrace();
        }
        return false; //account not found
    }

    public void editProfile(){ //update edited account into database
        try {
            Statement statement = DatabaseConnection.getConnection().createStatement();
            String sql = "update admin " +
                    "set admin_name = '" + getName() + "'" +
                    ", admin_phone = " + getPhone() +
                    ", admin_email = '" + getEmail() + "'" +
                    ", admin_username = '" + getUsername() + "'" +
                    ", admin_password = '" + getPassword() + "'" +
                    " where admin_id = " + getID() +
                    ";";
            statement.executeUpdate(sql);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void approveRequest(Request request){ //approve request, create a new account, send email
        try{
            
            Statement statement = DatabaseConnection.getConnection().createStatement();
            String deleteQuery = "delete from registration where registration_id="+request.getId();
            statement.executeUpdate(deleteQuery);

            Account account = accountFactory.getAccount(request.getRole());
            account.setUsername(generateUsername(request.getEmail()));
            account.setPassword(generatePassword());
            account.setEmail(request.getEmail());
            account.setPhone(request.getPhone());
            account.setRole(request.getRole());
            account.setName(request.getName());
            
            if(account.createAccount()){
                System.out.println("Sending Email....");

                //send approved email to user with username and password
                sendEmail("cyberent.mmu@gmail.com","ooadcyberent",account.getEmail(),"Cyberent Application","Welcome to Cyberent!\n"+"\nCongratulations! Your registration has been approved!\n"+
                "\nHere are your username: " + account.getUsername() + " and password: " + account.getPassword() + ".");
                
                System.out.println("Email sent");
            }
        }catch (Exception ex) {
            System.out.println(ex.getMessage());
        }      
    }

    public void declineRequest(int id, String email){ //decline request, send email
        try{
            Statement statement = DatabaseConnection.getConnection().createStatement();
            //send request declined email
            System.out.println("Sending Email....");
            sendEmail("cyberent.mmu@gmail.com","ooadcyberent",email, 
            "Cyberent Application","We are sorry! Your registration has been declined.");
            System.out.println("Email sent");
            //delete data
            String deleteQuery = "delete from registration where registration_id="+id;
            statement.executeUpdate(deleteQuery);
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    //Assigned Username
    public static String generateUsername(String email){
        //Random 4 number
        Random random = new Random();
        String id = String.format("%04d", random.nextInt(10000));

        //trim '@'
        String newUsername = email.split("@")[0] + id;
        return newUsername;
    }

    //Assigned Password
    public static String generatePassword() {
        String capitalCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "1234567890";
        String combinedChars = capitalCaseLetters + lowerCaseLetters + numbers;
        Random random = new Random();
        char[] password = new char[8];

        password[0] = lowerCaseLetters.charAt(random.nextInt(lowerCaseLetters.length()));
        password[1] = capitalCaseLetters.charAt(random.nextInt(capitalCaseLetters.length()));
        password[2] = numbers.charAt(random.nextInt(numbers.length()));

        for(int i = 3; i< 8 ; i++) {
            password[i] = combinedChars.charAt(random.nextInt(combinedChars.length()));
        }
        StringBuilder sb = new StringBuilder("");
        sb.append(password);
        return sb.toString();
    }

    public void sendEmail(String from,String pw,String to,String sub,String msg){ //send email to new user
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        //get Session
        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(from,pw);
                    }
                });
        //compose message
        try {
            MimeMessage message = new MimeMessage(session);
            message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
            message.setSubject(sub);
            message.setText(msg);
            //send message
            Transport.send(message);
            System.out.println("Message is successfully sent.");
        } 
        catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    public void addAdmin(String name, String email, String phone){  //add new admin, invoke function to save into database, and send email
        try{
           
            Admin newAdmin = new Admin();
            newAdmin.setName(name);
            newAdmin.setEmail(email);
            newAdmin.setPhone(Integer.parseInt(phone));
            newAdmin.setUsername(generateUsername(email));
            newAdmin.setPassword(generatePassword());

            //insert admin data into database
            //send new admin email with username and password if account created
            if(newAdmin.createAccount()){
                sendEmail("cyberent.mmu@gmail.com","ooadcyberent",newAdmin.getEmail(),"Cyberent Admin","Welcome!\n"+"\nYou are now an admin of Cyberent.\n"+
                "\nHere are your username: " + newAdmin.getUsername() + " and password: " + newAdmin.getPassword() + ".");
                JOptionPane.showMessageDialog(null, "Created Successfully", "Admin account created", JOptionPane.INFORMATION_MESSAGE);
            }

        }catch (Exception ex) {
            ex.printStackTrace();
        }      
    }

    //get admin table list
    public ArrayList<ArrayList<Object>> getAdminList(){
        ArrayList<ArrayList<Object>> adminList = new ArrayList<>();
        
        try{
            Statement statement = DatabaseConnection.getConnection().createStatement();

            String query = "select * from admin";
            ResultSet rs = statement.executeQuery(query);
            while(rs.next()){
                ArrayList<Object> adminItem = new ArrayList<>();
                adminItem.add(rs.getString("admin_name"));
                adminItem.add(rs.getString("admin_email"));
                adminItem.add(rs.getInt("admin_phone"));
                adminList.add(adminItem);
            
            }      
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return adminList;  
    }
   
}