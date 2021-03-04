package com.adda247.listuser.Model;



public class model {

    public model(String name, String email, String gender, String status) {
        this.name = name;
        Email = email;
        Gender = gender;
        Status = status;
    }

    public model() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    private String name ;
    private String Email;
    private String Gender;
    private String Status;


}
