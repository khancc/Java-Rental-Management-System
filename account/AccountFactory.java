package account;

public class AccountFactory {

    public Account getAccount(int role){ //0 for tenant, 1 for agent, 2 for owner, 3 for admin
        if (role == 0){
            return new PotentialTenant();
        }   
        else if (role == 1){
            return new Agent();
        }  
        else if (role ==2){
            return new Owner();
        }   
        else{
            return new Admin();
        }
            
    }
}
