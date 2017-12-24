package android.nni.com.dancemeup.entities;

/**
 * Created by magma on 12/22/2017.
 */

public class User {

    private String username;

    private String password;

    public String getUsername(){
        return this.username;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public User(){

    }
}
