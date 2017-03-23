package com.example.sugandh.panacea1;

/**
 * Created by sugandh on 3/21/2017.
 */

public class selectUsp {
    String name,email,password,address,service,pincode,experience;

    public String getName() {
        return name;
    }

    public selectUsp(String name, String email, String address, String service, String pincode) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.service = service;
        this.pincode = pincode;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }
}
