package android.nni.com.dancemeup.entities;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by magma on 12/27/2017.
 */

public abstract class GsonEntity {

    public JSONObject toJSON(){
        Gson gson = new Gson();
        String json = gson.toJson(this);

        JSONObject object = null;
        try {
            object = new JSONObject(json);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return object;
    }

    @Override
    public String toString() {
        return toJSON().toString();
    }
}
