package com.prontoresolved.validations;

/**
 * Created by venkatarao.g on 1/30/2018.
 */

public class ProntoValidations {

    public static boolean isEmptyOrNull(CharSequence str) {
        if (str == null || str.length() == 0)
            return true;
        else
            return false;
    }
}
