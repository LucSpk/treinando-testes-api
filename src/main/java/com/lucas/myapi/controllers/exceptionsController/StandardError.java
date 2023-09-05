package com.lucas.myapi.controllers.exceptionsController;

public class StandardError {

    private Integer status;
    private Long timeStamp;
    private String mesage;

    public StandardError() {
    }

    public StandardError(Integer status, Long timeStamp, String mesage) {
        this.status = status;
        this.timeStamp = timeStamp;
        this.mesage = mesage;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getMesage() {
        return mesage;
    }

    public void setMesage(String mesage) {
        this.mesage = mesage;
    }
}
