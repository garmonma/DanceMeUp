package android.nni.com.dancemeup.utils;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.util.Log;

import static android.support.v4.app.ActivityCompat.*;

/**
 * Created by magma on 12/20/2017.
 */

public class LocationUtils {

    private static final String TAG = "Location Utils";

    public LocationUtils() {

    }

    public LocationManager getLocationManager(Context context){
        // Acquire a reference to the system Location Manager
        LocationManager locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);

        return locationManager;
    }

    public void initLocationListener(LocationManager locationManager, Activity context){
        // Define a listener that responds to location updates
        Log.i(TAG, "Location Listener Initializing");
        LocationListener locationListener = new LocationListener() {
            public void onLocationChanged(Location location) {
                // Called when a new location is found by the network location provider.
                //makeUseOfNewLocation(location);

                double latitude = location.getLatitude();
                double longitude = location.getLongitude();
                Log.i(TAG, "Longitude : " + longitude + " Latitude : " + latitude);
            }

            public void onStatusChanged(String provider, int status, Bundle extras) {
            }

            public void onProviderEnabled(String provider) {

            }

            public void onProviderDisabled(String provider) {
            }
        };

        Log.i(TAG, "Access Fine Location Permission : " + checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION));

        Log.i(TAG, "Access Coarse Location Permission : " + checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION));

        if (checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            //Log.i(TAG, "location permission denied");
            requestPermissions(context, new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION}, 1 );
        }

        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);
        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,  0,  0, locationListener);

        /* Register the listener with the Location Manager to receive location updates */

    }

    @SuppressLint("MissingPermission")
    public Location getLastKnownLocation(LocationManager manager, Context context){

        if (checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            Log.i(TAG, "location permission denied");
            return null;
        }
        return manager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
    }
}