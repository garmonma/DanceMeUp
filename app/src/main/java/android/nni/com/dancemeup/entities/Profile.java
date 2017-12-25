package android.nni.com.dancemeup.entities;

/**
 * Created by magma on 12/22/2017.
 */

public class Profile {

    private String email;

    private String dances;

    private String gender;

    public String getEmail(){
        return this.email;
    }

    public String getDances(){
        return this.dances;
    }

    public String getGender(){
        return this.gender;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setDances(String dances){
        this.dances = dances;
    }

    public void setGender(String gender){
        this.gender = gender;
    }

    public String toString(){
        return String.format("Profile { Email {%s},\n Dances [%s},\n Gender {%s}}",
                this.email, this.dances, this.gender);
    }

    public Profile(){

    }


}
