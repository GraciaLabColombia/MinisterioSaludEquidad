package controller;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.util.Map;

/**
 *
 */
public class BaseController
{
    public CloseableHttpResponse responseFromPostRequest(String url, Map<String, String> headers, Object json_body) throws IOException
    {
        CloseableHttpResponse returning = null;
        HttpPost post = new HttpPost(url);
        headers.forEach(post::setHeader);
        post.setEntity(new ByteArrayEntity(json_body.toString().getBytes()));
        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(post))
        {
             returning = response;
        }
        return returning;
    }

    public CloseableHttpResponse responseFromGetRequest(String url, Map<String, String> headers) throws IOException
    {
        CloseableHttpResponse returning = null;
        HttpGet get = new HttpGet(url);
        headers.forEach(get::setHeader);
        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(get))
        {
            returning = response;
        }

        return returning;
    }

}