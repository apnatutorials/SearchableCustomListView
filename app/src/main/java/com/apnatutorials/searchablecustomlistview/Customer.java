package com.apnatutorials.searchablecustomlistview;
public class Customer {
    private String firstName = "";
    private String lastName = "";
    private int id = 0;
    private int profilePic = -1;

    public Customer(String firstName, String lastName, int id, int pic) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.profilePic = pic;

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(int profilePic) {
        this.profilePic = profilePic;
    }

    @Override
    public String toString() {
        return this.firstName + " " + this.lastName;
    }
}
