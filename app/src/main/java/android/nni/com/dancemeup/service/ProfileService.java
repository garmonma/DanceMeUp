package android.nni.com.dancemeup.service;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.nni.com.dancemeup.beans.GeoLocationRadiusBean;
import android.nni.com.dancemeup.entities.GeoLocation;
import android.nni.com.dancemeup.entities.Profile;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import org.json.JSONException;
import org.json.JSONObject;

import static android.support.v4.app.ActivityCompat.requestPermissions;
import static android.support.v4.content.ContextCompat.checkSelfPermission;

/**
 * Created by magma on 12/24/2017.
 */

public class ProfileService {

    private static final String TAG = "Profile Service";

    private RequestQueue queue;

    private Gson gson;

    public ProfileService(Activity context){
        queue = Volley.newRequestQueue(context);
        gson = new Gson();
    }

    public void createProfile(final Profile profile, final ServerCallback callback){
        String url ="http://192.168.0.7:8080/api/profile";

        // Request a string response from the provided URL.
        JsonObjectRequest createProfile = new JsonObjectRequest(Request.Method.POST, url, profile.toJSON(),
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.i(TAG, "Response : " + response);
                        callback.onSuccess(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.i(TAG, "Error : " + error);
                    }
                });

        // Add the request to the RequestQueue.
        queue.add(createProfile);

    }

    public void updateProfile(final Profile profile, final ServerCallback callback){
        String url ="http://192.168.0.7:8080/api/profile";

        Log.i(TAG, "Pre Update Profile" + profile.toString());

        // Request a string response from the provided URL.
        JsonObjectRequest updateProfile = new JsonObjectRequest(Request.Method.PUT, url, profile.toJSON(),
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        callback.onSuccess(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.i(TAG, "Error : " + error);
                    }
                });

        // Add the request to the RequestQueue.
        queue.add(updateProfile);
    }

    public void getProfiles(final GeoLocationRadiusBean data, final ServerCallback callback){
        String url ="http://192.168.0.7:8080/api/getProfiles";

        Log.i(TAG, "Get profiles in radius : " + data.getRadius());

        // Request a string response from the provided URL.
        JsonObjectRequest updateProfile = new JsonObjectRequest(Request.Method.PUT, url, data.toJSON(),
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        callback.onSuccess(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.i(TAG, "Error : " + error);
                    }
                });

        // Add the request to the RequestQueue.
        queue.add(updateProfile);
    }
}