package ru.silonov.assister.model.response;

public class DefaultResponse {
    private String message;

    public DefaultResponse(String message) {
        this.message = message;
    }

    public DefaultResponse() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
