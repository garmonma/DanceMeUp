package android.nni.com.dancemeup.entities;

import org.json.JSONObject;

import java.util.Date;

/**
 * Created by magma on 12/24/2017.
 */

public class Event {

    private String name;

    private String description;

    private Date date;

    public String getName(){
        return this.name;
    }

    public String getDescription(){
        return this.description;
    }

    public Date getDate(){
        return this.date;
    }

    public Event(){

    }



}
