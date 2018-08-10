package com.prontoresolved.enums;

/**
 * Created by nageshk on 11/9/2017.
 */
public enum Language {

    English("en", "English", "en-US"), Spanish("es", "español", "es-ES");

    private String internationalizationCode;
    private String displayString;
    private String culture;

    public String getInternationalizationCode() {
        return internationalizationCode;
    }

    public String getDisplayString() {
        return displayString;
    }

    public String getCulture() {
        return culture;
    }

    Language(String code, String displayStr, String strCulture) {
        internationalizationCode = code;
        displayString = displayStr;
        culture = strCulture;
    }


}
