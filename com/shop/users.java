package com.shop;

public class users {
    private String username;
    private String userpass;
    private String userstatus;

    public users(String username, String userpass, String userstatus) {
        this.username = username;
        this.userpass = userpass;
        this.userstatus = userstatus;
    }

    public String getUsername() { return username; }
    public String getPassword() { return userpass; }
    public String getUserStat() { return userstatus; }
    
    @Override
    public String toString() {
        return String.format("User{username='%s', userpass='%s', userstatus='%s'}",
                username, userpass, userstatus);
    }
}
