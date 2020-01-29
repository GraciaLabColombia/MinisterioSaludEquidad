package com.co.builder;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.JsonSerializer;

import java.io.IOException;

public class SedesCustomSerializer extends JsonSerializer<String>
{
    @Override
    public void serialize(String value, JsonGenerator gen, SerializerProvider serializers) throws IOException
    {
        gen.writeString(value.toLowerCase().equals("true") ? "1" : "0");
        //gen.writeNumber(value.toLowerCase().equals("true") ? "1" : "0");
    }

}
