package dev.yka.TechnicalExercise.Models;

import java.util.ArrayList;
import java.util.List;

public class ProcessedData {
    private String address1;
    private String address2;
    private String city;
    private String state;
    private String postcode;
    private String countryCode;
    private List<Resident> residents;

    public ProcessedData(DataEntry dataEntry) {
        this.address1 = dataEntry.getAddress1();
        this.address2 = dataEntry.getAddress2();
        this.city = dataEntry.getCity();
        this.state = dataEntry.getState();
        this.postcode = dataEntry.getPostcode();
        this.countryCode = dataEntry.getCountryCode();
        this.residents = new ArrayList<>();
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

    public List<Resident> getResidents() {
        return residents;
    }

    public void setResidents(List<Resident> residents) {
        this.residents = residents;
    }
}
