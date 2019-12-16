package builder;

import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PropertiesBuilder
{
    public static StringBuilder buildUrl(Properties config_properties, String uri)
    {
        StringBuilder builder = new StringBuilder();
        builder.append(config_properties.getProperty("protocol"))
                .append(":")
                .append("//")
                .append(config_properties.getProperty("domain"))
                .append(":")
                .append(config_properties.getProperty("port"))
                .append(":")
                .append(config_properties.getProperty(uri));

        return builder;

    }

    public static Map<?,?> getMapFromStringHeaders(String method_name, Class<?> class_from_method) throws NoSuchMethodException
    {
        Map headers_map = Collections.EMPTY_MAP;
        Pattern pattern = Pattern.compile("(.+)?\\=(.+)");
        Method method = class_from_method.getMethod(method_name);
        RequestMapping mapping = method.getAnnotation(RequestMapping.class);
        for(String header: mapping.headers())
        {
            Matcher matcher = pattern.matcher(header);
            if(matcher.find())
            {
                headers_map.put(matcher.group(1), matcher.group(2));
            }
        }
        for(Annotation[] annotations: method.getParameterAnnotations())
        {
            for(Annotation annotation: annotations)
            {
                if (annotation instanceof RequestHeader)
                {
                    RequestHeader header = (RequestHeader) annotation;
                    headers_map.put(header.name(), header.value()) ;
                }
            }
        }
        return headers_map;
    }
}
