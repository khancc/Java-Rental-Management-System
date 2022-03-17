package login;

import account.Admin;
import account.Agent;
import account.Owner;
import account.PotentialTenant;

public class Login {

    //Variables
    private int role; //0 for tenant, 1 for agent, 2 for owner, 3 for admin

    public boolean checkLogin(String usernameEntered,String passwordEntered){ //check account existence from database
        //tenant
        if (role == 0){
            PotentialTenant tenant = new PotentialTenant();
            return tenant.login(usernameEntered, passwordEntered);
        }
        //agent
        if (role == 1){
            Agent agent = new Agent();
            return agent.login(usernameEntered, passwordEntered);
        }
        //owner
        if (role == 2){
            Owner owner = new Owner();
            return owner.login(usernameEntered, passwordEntered);
        }
        //admin
        if(role ==3){
            Admin admin = new Admin();
            return admin.login(usernameEntered, passwordEntered);
        }

        return false;
    }

    //setter
    public void setRole(int role) {
        this.role = role;
    }

}
