package com.co.builder;

import com.co.annotation.ServiceConfig;
import com.co.dto.RequestBodyDTO;
import com.co.dto.RequestDTO;
import com.co.dto.RequestFormPostDTO;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.lang.reflect.Method;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PropertiesBuilder
{
    public static RequestBodyDTO getAnnotationFeatures(String body, String method_name, Class<?> class_from_method, Class<?>... parameters) throws NoSuchMethodException
    {
        Method method = class_from_method.getMethod(method_name, parameters);
        ServiceConfig mapping = method.getAnnotation(ServiceConfig.class);

        RequestBodyDTO post_request = new RequestBodyDTO();
        post_request.setHeaders(getHeaders(mapping));
        post_request.setUrl(buildUrl(mapping).toString());
        post_request.setBody(body);

        return post_request;

    }

    public static RequestFormPostDTO getAnnotationFeatures(String method_name, Class<?> class_from_method, Class<?>... params) throws NoSuchMethodException
    {
        Method method = class_from_method.getMethod(method_name, params);
        ServiceConfig mapping = method.getAnnotation(ServiceConfig.class);

        RequestFormPostDTO post_form_request = new RequestFormPostDTO();
        post_form_request.setHeaders(getHeaders(mapping));
        post_form_request.setUrl(buildUrl(mapping).toString());
        post_form_request.setParams(getParams(mapping));

        return post_form_request;
    }

    public static RequestDTO getAnnotationFeaturesForGet(String method_name, Class<?> class_from_method, Class<?>... params) throws NoSuchMethodException
    {
        Method method = class_from_method.getMethod(method_name, params);
        ServiceConfig mapping = method.getAnnotation(ServiceConfig.class);

        RequestDTO get_request = new RequestDTO();
        get_request.setHeaders(getHeaders(mapping));
        get_request.setUrl(buildUrl(mapping).toString());

        return get_request;
    }

    private static Map getHeaders(ServiceConfig config)
    {
        Map<String, String> headers_map = new HashMap<String, String>();
        Pattern pattern = Pattern.compile("(.+)?\\=(.+)");
        Arrays.asList(config.headers()).forEach(header -> {Matcher matcher = pattern.matcher(header); if(matcher.find()) headers_map.put(matcher.group(1), matcher.group(2));});
        return headers_map;
    }

    private static ArrayList<NameValuePair> getParams(ServiceConfig config)
    {
        ArrayList<NameValuePair> postParameters = new ArrayList<NameValuePair>();
        Pattern pattern = Pattern.compile("(.+)?\\=(.+)");
        Arrays.asList(config.params()).forEach(param -> {Matcher matcher = pattern.matcher(param); if(matcher.find()) postParameters.add(new BasicNameValuePair(matcher.group(1), matcher.group(2)));});

        return postParameters;
    }

    private static StringBuilder buildUrl(ServiceConfig config)
    {
        StringBuilder builder = new StringBuilder();
        builder.append(config.protocol())
                .append(":")
                .append("//")
                .append(config.domain())
                .append(":")
                .append(config.port())
                .append(config.uri());

        return builder;

    }
}
