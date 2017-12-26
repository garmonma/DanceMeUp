package android.nni.com.dancemeup.service;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.nni.com.dancemeup.entities.Profile;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import static android.support.v4.app.ActivityCompat.requestPermissions;
import static android.support.v4.content.ContextCompat.checkSelfPermission;

/**
 * Created by magma on 12/24/2017.
 */

public class ProfileService {

    private static final String TAG = "Profile Service";

    private RequestQueue queue;

    public ProfileService(Activity context){
        queue = Volley.newRequestQueue(context);
    }

    public boolean createProfile(Profile profile){
        String url ="http://192.168.0.7:8080/api/profile";

        // Request a string response from the provided URL.
        JsonObjectRequest stringRequest = new JsonObjectRequest(Request.Method.POST, url, profile.toJSON(),
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.i(TAG, "Response : " + response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.i(TAG, "Error : " + error);
                    }
                });

        // Add the request to the RequestQueue.
        queue.add(stringRequest);

        return true;
    }
}