package com.prontoresolved.util;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by nageshk on 11/9/2017.
 */
public class ProntoUtil {

    public static boolean nullOREmpty(String val) {
        val = val != null ? val.trim() : val;
        return (val == null || val.equals("null") || val.length() == 0) ? true : false;
    }

    public static String replaceEscapeSequences(String val) {


        byte stringBytes[] = val.getBytes();
        String str = new String();
        for (byte b : stringBytes) {

            System.out.println((char) b + " : " + b);


            switch (b) {


                case 34:
                    str += "\"";
                    break;

                case 39:
                    str += "\'";
                    break;

                case 92:
                    str += "\\";
                    break;

                default:
                    str += (char) b;
            }


        }

        return str;

    }


    public static boolean isValidEmail(String email) {
        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern1 = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher1 = pattern1.matcher(email);
        return matcher1.matches();
    }

    public String getFormattedDate(Date date){
        return null;
    }
}
