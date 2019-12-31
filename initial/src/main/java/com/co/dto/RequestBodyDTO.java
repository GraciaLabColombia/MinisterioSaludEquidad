package com.co.dto;

public class RequestBodyDTO extends RequestDTO
{
    private String body;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "RequestBodyDTO{" +
                "body='" + body + '\'' +
                '}';
    }
}
