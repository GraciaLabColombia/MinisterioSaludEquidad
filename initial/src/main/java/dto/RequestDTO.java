package dto;

import java.util.Map;

public class RequestDTO
{
    private Map<String, String> headers;

    private String url;

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        final String[] headers_string = {""};
        this.headers.forEach((k,v)-> headers_string[0] += " " + k + " = " + v);
        return "RequestDTO{" +
                "headers:" + headers_string[0] +
                ", url='" + url + '\'' +
                '}';
    }
}
