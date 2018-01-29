package android.nni.com.dancemeup.beans;

import android.nni.com.dancemeup.entities.GeoLocation;
import android.nni.com.dancemeup.entities.GsonEntity;

/**
 * Created by magma on 1/3/2018.
 */

public class GeoLocationRadiusBean extends GsonEntity {

    private GeoLocation location;

    private int radius;

    public GeoLocationRadiusBean(){
        this.radius = 5;
    }

    public void setLocation(GeoLocation location){
        this.location = location;
    }

    public GeoLocation getLocation(){
        return this.location;
    }

    public void setRadius(int radius){
        this.radius = radius;
    }

    public int getRadius(){
        return this.radius;
    }

}