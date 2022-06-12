package com.ozkaraca.rabbitmqdemo.model;

import java.io.Serializable;
import java.util.Date;

public class CallerPerson implements Serializable {
    // nesneyi serialize edip kuyruğa gnderiyoruz almak istegigimiz zamanda java tarafında anlamlı bir sekilde
    // prosesses edebilmek için implemente etmeliyiz
    // bunlarla çağrıyı kuyruga atıcaz kuyruktanda bir baskası alıp process edecek

     private String callerPersonId;
     private String callerPerson;
     private Date createdAt;
     private  Boolean seen;
     private String message;

    public String getCallerPerson() {
        return callerPerson;
    }

    public void setCallerPerson(String callerPerson) {
        this.callerPerson = callerPerson;
    }
    public String getcallerPersonId() {
        return callerPersonId;
    }

    public void setcallerPersonId(String callerPersonId) {
        this.callerPersonId =callerPersonId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Boolean getSeen() {
        return seen;
    }

    public void setSeen(Boolean seen) {
        this.seen = seen;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

   @Override
    public String toString() {
        return "CallerPerson{" +
                "callerPersonId='" + callerPersonId + '\'' +
                ", callerPerson='" + callerPerson + '\'' +
                ", createdAt=" + createdAt +
                ", seen=" + seen +
                ", message='" + message + '\'' +
                '}';
    }
}