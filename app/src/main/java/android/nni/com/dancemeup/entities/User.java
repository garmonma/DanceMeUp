package android.nni.com.dancemeup.entities;

import org.json.JSONException;
import org.json.JSONObject;

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

    public JSONObject toJSON(){
        JSONObject object = new JSONObject();
        try {
            object.put("username", this.username);
            object.put("password", this.password);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return object;
    }

    public User(){

    }
}