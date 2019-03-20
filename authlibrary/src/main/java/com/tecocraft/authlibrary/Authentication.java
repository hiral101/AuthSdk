package com.tecocraft.authlibrary;

/**
 * Created by lenovo on 3/20/2019.
 */

public class Authentication {

    public static boolean verifyCredential(String email, String password) {

        if (!email.isEmpty() && !password.isEmpty()) {
            if (email.equalsIgnoreCase("test@gmail.com") && password.equalsIgnoreCase("test@123")) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

}
