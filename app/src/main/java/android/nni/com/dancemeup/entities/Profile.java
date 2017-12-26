package android.nni.com.dancemeup.entities;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by magma on 12/22/2017.
 */

public class Profile {

    private Long Id;

    private String nickname;

    private String email;

    private String firstName;

    private String lastName;

    private String location;

    private String aboutMe;

    private String gender;

    private String dances;

    private String photo;

    private String danceStatus;

    private Set<Event> events = new HashSet<Event>();

    public Long getId(){
        return Id;
    }

    public String getEmail(){
        return this.email;
    }

    public String getFirstName(){
        return this.firstName;
    }

    public String getLastName(){
        return this.lastName;
    }

    public String getAboutMe(){
        return this.aboutMe;
    }

    public String getDances(){
        return this.dances;
    }

    public String getGender(){
        return this.gender;
    }


    public String getPhoto(){
        return this.photo;
    }

    public String getDanceStatus(){
        return this.danceStatus;
    }

    public void setId(Long id) {
        Id = id;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setDances(String dances) {
        this.dances = dances;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public void setDanceStatus(String danceStatus) {
        this.danceStatus = danceStatus;
    }

    public void setEvents(Set<Event> events) {
        this.events = events;
    }

    public JSONObject toJSON(){
        JSONObject object = new JSONObject();
        try {
            object.put("email", this.email);
            object.put("dances", this.dances);
            object.put("gender", this.gender);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return object;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public Profile(){

    }
}