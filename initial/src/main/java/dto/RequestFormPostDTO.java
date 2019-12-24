package dto;

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
}
