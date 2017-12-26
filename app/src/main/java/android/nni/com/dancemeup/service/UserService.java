package android.nni.com.dancemeup.service;

import android.content.Context;
import android.nni.com.dancemeup.entities.User;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

/**
 * Created by magma on 12/24/2017.
 */

public class UserService {

    private static final String TAG = "User Service";

    private RequestQueue queue;

    public UserService(Context context){
        queue = Volley.newRequestQueue(context);
    }

    public boolean createUser(User user){
        String url ="http://192.168.0.7:8080/api/user";

        // Request a string response from the provided URL.
        JsonObjectRequest stringRequest = new JsonObjectRequest(Request.Method.POST, url, user.toJSON(),
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
