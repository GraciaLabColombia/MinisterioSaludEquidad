package controller;

import com.google.gson.Gson;
import dto.RequestBodyDTO;
import dto.RequestFormPostDTO;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import utils.SisafitraConstant;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Map;

/**
 *
 */
public class BaseController
{
    public <T> Object responseFromPostRequest(RequestBodyDTO request, Class<T> type) throws IOException, NoSuchFieldException, IllegalAccessException {
        HttpPost post = new HttpPost(request.getUrl());
        request.getHeaders().forEach(post::setHeader);
        post.setEntity(new ByteArrayEntity(request.getBody().getBytes()));
        return sendRequest(post, type);
    }

    public <T> Object responseFromPostFormRequest(RequestFormPostDTO request, Class<T> type) throws IOException, NoSuchFieldException, IllegalAccessException {
        HttpPost post = new HttpPost(request.getUrl());
        request.getHeaders().forEach(post::setHeader);
        post.setEntity(new UrlEncodedFormEntity(request.getParams(), "UTF-8"));
        return sendRequest(post, type);
    }

    public <T> Object responseFromGetRequest(String url, Map<String, String> headers, Class<T> type) throws IOException, NoSuchFieldException, IllegalAccessException {
        HttpGet get = new HttpGet(url);
        headers.forEach(get::setHeader);
        return sendRequest(get, type);
    }

    private <T> Object sendRequest(HttpUriRequest request, Class<T> type) throws IOException, NoSuchFieldException, IllegalAccessException {
        Gson gson = new Gson();
        Object returning;
        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(request))
        {
            String json_string = EntityUtils.toString(response.getEntity());
            returning = gson.fromJson(json_string, type);
            Field statusCodeField;
            try {
                statusCodeField = returning.getClass().getDeclaredField(SisafitraConstant.STATUS_CODE);
            }catch(NoSuchFieldException ex)
            {
                statusCodeField = returning.getClass().getSuperclass().getDeclaredField(SisafitraConstant.STATUS_CODE);
            }
            statusCodeField.setAccessible(true);
            statusCodeField.set(returning, response.getStatusLine().getStatusCode());
        }

        return returning;
    }

}