package com.co.controller;

import com.co.dto.ErrorDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.co.dto.RequestBodyDTO;
import com.co.dto.RequestFormPostDTO;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import com.co.utils.SisafitraConstant;

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


    public String mapperBody(Object object) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(object);
    }

    private <T> Object sendRequest(HttpUriRequest request, Class<T> type) throws IOException, NoSuchFieldException, IllegalAccessException {
        Gson gson = new Gson();
        Object returning;
        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(request))
        {
            int status_code = response.getStatusLine().getStatusCode();
            String json_string = EntityUtils.toString(response.getEntity());
            Field statusCodeField;
            if (status_code != 200)
            {
                returning = new ErrorDTO();
                ((ErrorDTO)returning).setStatus_code(status_code);
                ((ErrorDTO)returning).setError(response.getStatusLine().toString());
                ((ErrorDTO)returning).setError_description(response.getStatusLine().getReasonPhrase());
            }else {
                returning = gson.fromJson(json_string, type);
            }
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