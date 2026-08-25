package com.enesyaray.kutuphaneapi.exception;

import java.time.LocalDateTime;
import java.util.Map;

public class HataCevabi {
    private int status;
    private String massege;
    private LocalDateTime timestamp;
    private Map<String,String> errors;

    public HataCevabi(int status,String message){
        this.status=status;
        this.massege=message;
        this.timestamp=LocalDateTime.now();
    }

    public HataCevabi(int status,String message,Map<String,String>errors){
        this.status=status;
        this.massege=message;
        this.timestamp=LocalDateTime.now();
        this.errors=errors;
    }

    public int getStatus() {
        return status;
    }

    public String getMassege() {
        return massege;
    }

    public Map<String, String> getErrors() {
        return errors;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
