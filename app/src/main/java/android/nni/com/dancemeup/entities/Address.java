package android.nni.com.dancemeup.entities;

/**
 * Created by magma on 1/3/2018.
 */

public class Address extends GsonEntity {

    private String country;

    private String address1;

    private String address2;

    private String city;

    private String state;

    private int zipcode;

    public String getCountry(){
        return this.country;
    }

    public String getAddress1(){
        return this.address1;
    }

    public String getAddress2(){
        return this.address2;
    }

    public String getCity(){
        return this.city;
    }

    public String getState(){
        return this.state;
    }

    public int getZipcode(){
        return this.zipcode;
    }

    public void setCountry(String country){
        this.country = country;
    }

    public void setAddress1(String address1){
        this.address1 = address1;
    }

    public void setAddress2(String address2){
        this.address2 = address2;
    }

    public void setCity(String city){
        this.city = city;
    }

    public void setState(String state){
        this.state = state;
    }

    public void setZipcode(int zipcode){
        this.zipcode = zipcode;
    }

    public Address(){

    }
}