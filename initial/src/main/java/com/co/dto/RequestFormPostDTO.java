package com.co.dto;

import org.apache.http.NameValuePair;

import java.util.ArrayList;

public class RequestFormPostDTO extends RequestDTO
{
    private ArrayList<NameValuePair> params;

    public void setParams(ArrayList<NameValuePair> params) {
        this.params = params;
    }

    public ArrayList<NameValuePair> getParams() {
        return params;
    }

    @Override
    public String toString() {
        final String[] params_string = {""};
        this.params.forEach((k)-> params_string[0] += " "  + (k.getName() + " = ").concat(k.getValue()));
        return "RequestFormPostDTO{" +
                "params:".concat(params_string[0]) +
                "} ".concat(super.toString());
    }
}
