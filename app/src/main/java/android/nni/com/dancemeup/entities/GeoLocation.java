package android.nni.com.dancemeup.entities;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

/**
 * Created by magma on 12/27/2017.
 */

public class GeoLocation extends GsonEntity implements Serializable{

    private double longitude;

    private double latitude;

    public GeoLocation(){

    }

    public void setLatitude(double latitude){
        this.latitude = latitude;
    }

    public double getLatitude(){
        return this.latitude;
    }

    public void setLongitude(double longitude){
        this.longitude = longitude;
    }

    public double getLongitude(){
        return this.longitude;
    }

}
