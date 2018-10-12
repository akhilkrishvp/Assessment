package com.assessment.Helper;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

/**
 * Created by akhil on 12/10/18.
 */

public class Validation {
    /**
     *  Email Address Validation
     */
    public static boolean isValidEmailAddress(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
    }
    /**
     *  Hide Keyboard
     */
    public static void hideSoftKeyboard(Activity activity) {
        InputMethodManager inputManager = (InputMethodManager) activity.getSystemService(
                Context.INPUT_METHOD_SERVICE);
        View focusedView = activity.getCurrentFocus();
    /*
     * If no view is focused, an NPE will be thrown
     *
     * Maxim Dmitriev
     */
        if (focusedView != null) {
            inputManager.hideSoftInputFromWindow(focusedView.getWindowToken(),
                    InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }
    /**
     *  Password Validation
     */
    public static boolean passwordValidation(String password) {
        // (?=.*[0-9]) a digit must occur at least once
        // (?=.*[a-z]) a lower case letter must occur at least once
        // (?=.*[A-Z]) an upper case letter must occur at least once
        // (?=.*[@#$%^&+=]) a special character must occur at least once
        // (?=\\S+$) no whitespace allowed in the entire string
        // .{8,} at least 8 characters

        String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=.,_+()*!?-])(?=\\S+$).{8,15}";
        return password.matches(pattern);
    }
}
