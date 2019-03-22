package com.tecocraft.authlibrary;

import android.util.Patterns;

import java.util.regex.Pattern;

/**
 * Created by lenovo on 3/20/2019.
 */

public class Authentication {

    /**
     * Method to authenticate User
     * @param email EmailId
     * @param password Password
     * @return true value if authentication is successful otherwise return false
     */
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

    /**
     * Method to perform Email and password validation
     * @param email EmailId
     * @param password Password
     * @return Error message if validation failed
     */
    public static String Validate(String email,String password) {
        String errorMsg = "";
        if (!email.isEmpty() && !password.isEmpty()) {
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                errorMsg = "Please enter valid email";
            }
            if (!Pattern.matches("(?=.*?[a-z])(?=.*?[0-9]).{6,}$", password)) {
                errorMsg = "Password should be minimum 6 character long and contains alphabets and digits";
            }

        } else {
            errorMsg = "Please enter email and password";
        }
        return errorMsg;
    }

}
