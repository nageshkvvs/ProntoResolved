package com.prontoresolved.servicepackets;

import android.content.Context;

import com.prontoresolved.enums.Language;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

/**
 * Created by nageshk on 11/9/2017.
 */
public class ProntoResolvedServiceRequestDataPacket extends JSONObject implements Serializable {


    private static final long serialVersionUID = 1512065094095405856L;
    private String serviceURL;

    public ProntoResolvedServiceRequestDataPacket(Context con, Language applicationLanguage, String serviceTokenId,
                                                  String userTokenId) throws JSONException {
        super();


        if (applicationLanguage != null) {
            this.put("Culture", applicationLanguage.getCulture());
        }


    }

    public String getServiceURL() {
        return serviceURL;
    }

    public void setServiceURL(String serviceURL) {
        this.serviceURL = serviceURL;
    }

}
