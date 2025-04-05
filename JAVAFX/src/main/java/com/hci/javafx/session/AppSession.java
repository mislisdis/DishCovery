package com.hci.javafx.session;

public class AppSession {

    private static AppSession instance;

    private final String username = "johnexample";
    private final String fName = "John";
    private final String lName = "Example";
    private boolean brightMode = true;

    private AppSession() {}

    public static AppSession getInstance() {
        if (instance == null) {
            instance = new AppSession();
        }
        return instance;
    }

    public boolean isBrightMode() {
        return brightMode;
    }

    public void setBrightMode(boolean brightMode) {
        this.brightMode = brightMode;
    }

    public String getlName() {
        return lName;
    }

    public String getfName() {
        return fName;
    }

    public String getUsername() {
        return username;
    }
}
