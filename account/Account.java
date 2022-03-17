package account;

public abstract class Account {

    private String username;
    private String password;
    private String name;
    private String email;
    private int phone;
    private int id;
    private int role;

    private static Account account;
    abstract boolean createAccount();
    public abstract String toString();

    //setter
    public void setUsername(String username){
        this.username = username;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setPhone(int phone){
        this.phone = phone;
    }
    public void setID(int id){
        this.id = id;
    }
    public void setAcount(Account account){
        Account.account = account;
    }
    public void setRole(int role) {
        this.role = role;
    }

    //getter
    public int getRole() {
        return role;
    }
    public int getID(){
        return id;
    }
    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }
    public String getName(){
        return name;
    }
    public String getEmail(){
        return email;
    }
    public int getPhone(){
        return phone;
    }
    public static Account getAccount(){
        return account;
    }
}
