package com.prontoresolved.components;

/**
 * Created by venkatarao.g on 3/8/2018.
 */

public class Notification {
    private String title;
    private String message;
    private String statusType;
    public Notification(String title,String message,String statusType){

        this.title=title;
        this.message=message;
        this.statusType=statusType;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public void setStatusType(String statusType) {
        this.statusType = statusType;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatusType() {
        return statusType;
    }

    public String getMessage() {
        return message;
    }

    public String getTitle() {
        return title;
    }


}
