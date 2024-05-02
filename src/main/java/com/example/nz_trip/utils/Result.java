package com.example.nz_trip.utils;

import java.util.HashMap;

public class Result {
    private Integer code;
    private String message;
    private HashMap<String,Object> data = new HashMap<>();


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HashMap<String,Object> getData() {
        return data;
    }

    public void setData(HashMap<String,Object> data) {
        this.data = data;
    }

    private Result(){}

    public static Result success(){
        Result r = new Result();
        r.setCode(0);
        r.setMessage("成功");
        return r;
    }

    public static  Result  failed(){
        Result r = new Result();
        r.setCode(200);
        r.setData(null);
        return r;
    }

    public Result data(HashMap<String,Object> value){
        this.data = value;
        return this;
    }

    public Result message(String message){
        this.message = message;
        return this;
    }





}