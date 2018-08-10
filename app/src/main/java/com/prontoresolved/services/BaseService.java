package com.prontoresolved.services;

import android.os.AsyncTask;

import com.prontoresolved.servicepackets.ProntoResolvedServiceRequestDataPacket;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by nageshk on 11/9/2017.
 */
public abstract class BaseService extends AsyncTask<Void, Void, String> {

    protected ProntoResolvedServiceRequestDataPacket prontoResolvedServiceRequestDataPacket = null;
    protected JSONObject serviceResponse = null;
    protected ServiceHandler sh = new ServiceHandler();

    public BaseService(ProntoResolvedServiceRequestDataPacket prontoResolvedServiceRequestDataPacket) {
        System.out.println(" prontoResolvedServiceRequestDataPacket URL " + prontoResolvedServiceRequestDataPacket.getServiceURL());
        System.out.println(" prontoResolvedServiceRequestDataPacket req " + prontoResolvedServiceRequestDataPacket);
        this.prontoResolvedServiceRequestDataPacket = prontoResolvedServiceRequestDataPacket;
    }

    String tokenResponse;


    @Override
    protected String doInBackground(Void... params) {
        tokenResponse = sh.makeServiceCall(prontoResolvedServiceRequestDataPacket.getServiceURL(), ServiceHandler.POST,
                prontoResolvedServiceRequestDataPacket.toString());


        return null;

    }

    @Override
    protected void onPostExecute(String result) {
        try {

            System.out.println(" FN here 123 ");
            //System.out.println(" tokenResponse "+tokenResponse);
            if (tokenResponse != null) {
                if (tokenResponse.equals("IOE") || tokenResponse.contains("xml")) {
                    //serviceResponse = new JSONObject("{\"IOE\":\"IOE\"}");
                    serviceResponse = new JSONObject(tokenResponse);
                } else {
                    serviceResponse = new JSONObject(tokenResponse);
                }

                System.out.println(" serviceResponse " + serviceResponse);
                _actOnServiceResponse(serviceResponse);
            } else {
                _alertServiceResponseNull();
            }
        } catch (JSONException e) {
            e.printStackTrace();
            System.out.println(" Exception caught ");
            _alertServiceResponseNull();
        }
    }

    protected void submitRequest() {
        this.execute();
    }

    // All the Sub Service classes need to implement  actOnServiceResponse for example displaying alerts,
    // navigating to new view, checking the session etc.
    protected abstract void _actOnServiceResponse(JSONObject serviceResponse) throws JSONException;

    protected abstract void _alertServiceResponseNull();

}
