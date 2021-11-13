package dev.yka.TechnicalExercise.Models;

import java.util.List;

public class ProcessedData {
    private String address1;
    private String address2;
    private String city;
    private String state;
    private String postcode;
    private String countryCode;
    private List<Resident> resident;

    public ProcessedData(String address1, String address2, String city, String state, String postcode, String countryCode, List<Resident> resident) {
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.state = state;
        this.postcode = postcode;
        this.countryCode = countryCode;
        this.resident = resident;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public List<Resident> getResident() {
        return resident;
    }

    public void setResident(List<Resident> resident) {
        this.resident = resident;
    }
}
