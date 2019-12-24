package controller;

import com.google.gson.Gson;
import dto.RequestBodyDTO;
import dto.RequestFormPostDTO;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.Map;

/**
 *
 */
public class BaseController
{
    public <T> Object responseFromPostRequest(RequestBodyDTO request, Class<T> type) throws IOException
    {
        Gson gson = new Gson();
        Object returning;
        HttpPost post = new HttpPost(request.getUrl());
        request.getHeaders().forEach(post::setHeader);
        post.setEntity(new ByteArrayEntity(request.getBody().getBytes()));
        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(post))
        {
            String json_string = EntityUtils.toString(response.getEntity());
            returning =  gson.fromJson(json_string, type);
        }
        return returning;
    }

    public <T> Object responseFromPostFormRequest(RequestFormPostDTO request, Class<T> type) throws IOException
    {
        Gson gson = new Gson();
        Object returning;
        HttpPost post = new HttpPost(request.getUrl());
        request.getHeaders().forEach(post::setHeader);
        post.setEntity(new UrlEncodedFormEntity(request.getParams(), "UTF-8"));
        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(post))
        {
            String json_string = EntityUtils.toString(response.getEntity());
            returning =  gson.fromJson(json_string, type);
        }
        return returning;
    }

    public <T> Object responseFromGetRequest(String url, Map<String, String> headers, Class<T> type) throws IOException
    {
        Gson gson = new Gson();
        Object returning;
        HttpGet get = new HttpGet(url);
        headers.forEach(get::setHeader);
        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(get))
        {
            String json_string = EntityUtils.toString(response.getEntity());
            returning = gson.fromJson(json_string, type);
        }

        return returning;
    }

}