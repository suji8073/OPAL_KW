package com.kw.opal;

public class Local_user {

    String userID;
    String userPassword;
    String userName;
    String userAge;
    String image;

    public Local_user(String userID, String userPassword, String userName, String userAge,String image) {
        this.userID = userID;
        this.userPassword = userPassword;
        this.userName = userName;
        this.userAge = userAge;
        this.image=image;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAge() {
        return userAge;
    }

    public void setUserAge(String userAge) {
        this.userAge = userAge;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image =image;
    }
}


