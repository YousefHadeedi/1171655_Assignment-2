package com.example.a1171655_assignment_2.Models;

import java.util.ArrayList;

public class CV {
    private String firstName;
    private String lastName;
    private String dop;
    private String email;
    private String phone;
    private String address;
    private String about;
    // private ArrayList<Experience> experiences = new ArrayList<>();

    public CV() { }

    public CV(String firstName,
              String lastName,
              String dop,
              String email,
              String phone,
              String address,
              String about/*,
              ArrayList<Experience> experiences*/) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dop = dop;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.about = about;
        // this.experiences = experiences;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setDop(String dop) {
        this.dop = dop;
    }

    public String getDop() {
        return this.dop;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getAbout() {
        return this.about;
    }

    /*public void setExperiences(ArrayList<Experience> experiences) {
        this.experiences = experiences;
    }

    public ArrayList<Experience> getExperiences() {
        return this.experiences;
    }*/

}
