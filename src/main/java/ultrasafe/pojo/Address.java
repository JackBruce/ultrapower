package ultrasafe.pojo;

/**
 * Created by root on 2017/6/23.
 */
public class Address {
    private String country;
    private String city;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Address(){

    }

    public Address(String country, String city) {
        this.country = country;
        this.city = city;
    }
}
