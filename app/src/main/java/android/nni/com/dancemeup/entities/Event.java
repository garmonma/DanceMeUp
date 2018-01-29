package android.nni.com.dancemeup.entities;

import com.google.gson.Gson;

import org.json.JSONObject;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by magma on 12/24/2017.
 */

public class Event extends GsonEntity {

    private String name;

    private String description;

    private Profile creator;

    private LocalDateTime date;

    private GeoLocation location;

    private Address address;

    public String getName(){
        return this.name;
    }

    public String getDescription(){
        return this.description;
    }

    public LocalDateTime getDate(){
        return this.date;
    }

    public Event(){

    }
}