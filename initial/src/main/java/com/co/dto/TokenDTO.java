package com.co.dto;

public class TokenDTO extends ResponseDTO
{
    private String access_token;

    private String token_type;

    private int expires_in;

    public String getAccess_token() {
        return access_token;
    }

    public String getToken_type() {
        return token_type;
    }

    public int getExpires_in() {
        return expires_in;
    }

    @Override
    public String toString() {
        return "TokenDTO{" +
                "status_code=" + super.getStatus_code() +
                ", access_token='" + access_token + '\'' +
                ", token_type='" + token_type + '\'' +
                ", expires_in=" + expires_in +
                '}';
    }
}
